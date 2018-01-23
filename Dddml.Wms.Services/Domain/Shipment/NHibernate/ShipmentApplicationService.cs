using Spring.Transaction.Interceptor;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Dddml.Wms.Domain.AttributeSetInstance;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.Product;
using Common.Logging;
using Dddml.Wms.Domain.Services;
using Dddml.Wms.Domain.StatusItem;

namespace Dddml.Wms.Domain.Shipment.NHibernate
{
    public partial class ShipmentApplicationService
    {
        static readonly ILog _log = LogManager.GetLogger<ShipmentApplicationService>();

        IProductApplicationService ProductApplicationService
        {
            get { return ApplicationContext.Current["productApplicationService"] as IProductApplicationService; }
        }

        IAttributeSetInstanceApplicationService AttributeSetInstanceApplicationService
        {
            get { return ApplicationContext.Current["attributeSetInstanceApplicationService"] as IAttributeSetInstanceApplicationService; }
        }

        IAttributeSetService AttributeSetService
        {
            get { return ApplicationContext.Current["attributeSetService"] as IAttributeSetService; }
        }

        [Transaction]
        public override void When(ShipmentCommands.Import c)
        {
            var shipment = new CreateShipment();
            shipment.ShipmentId = c.ShipmentId;
            shipment.OriginFacilityId = c.OriginFacilityId;
            shipment.DestinationFacilityId= c.DestinationFacilityId;
            shipment.PartyIdFrom = c.PartyIdFrom;
            shipment.PartyIdTo = c.PartyIdTo;
            //todo More properties...

            var shipItems = new List<ICreateShipmentItem>();
            int i = 0;
            foreach (var d in c.ShipmentItems)
            {
                var shipItem = CreateShipmentItem(i, d);

                shipment.ShipmentItems.Add(shipItem);
                i++;
            }

            When(shipment);
        }

        private CreateShipmentItem CreateShipmentItem(int i, ImportingShipmentItem d)
        {
            var shipItem = new CreateShipmentItem();

            var prdState = GetProductState(d.ProductId);

            string attrSetInstId = CreateAttributeSetInstance(prdState.AttributeSetId, d.AttributeSetInstance);
            if (_log.IsDebugEnabled) { _log.Debug("Create attribute set instance, id: " + attrSetInstId); }

            shipItem.ShipmentItemSeqId = i.ToString();
            shipItem.ProductId = prdState.ProductId;
            shipItem.AttributeSetInstanceId = attrSetInstId;
            shipItem.Quantity = d.Quantity;
            shipItem.Active = true;
            //todo More proerties???
            return shipItem;
        }

        [Transaction]
        public override void When(ShipmentCommands.ReceiveItem c)
        {
            var shipment = AssertShipmentStatus(c.ShipmentId, StatusItemIds.PurchShipShipped);
            var shipmentItem = shipment.ShipmentItems.Get(c.ShipmentItemSeqId);
            if (shipmentItem == null)
            {
                throw new ArgumentException(String.Format("CANNOT get shipment item. ShipmentItemSeqId: {0}", c.ShipmentItemSeqId));
            }
            if (shipmentItem.Quantity != c.AcceptedQuantity + c.RejectedQuantity)
            {
                throw new ArgumentException(String.Format("shipmentItem.Quantity != c.AcceptedQuantity + c.RejectedQuantity. {0} != {1} + {2}"
                    , shipmentItem.Quantity, c.AcceptedQuantity, c.RejectedQuantity));
            }

            // ////////////////////////////////////////////////////
            ICreateOrMergePatchOrRemoveShipmentReceipt updateReceipt = CreateOrUpdateShipmentReceipt(c, shipment, shipmentItem);
            
            // ////////////////////////////////////////////////////
            UpdateShipment(c, updateReceipt);
            
        }

        private void UpdateShipment(ShipmentCommands.ReceiveItem c, ICreateOrMergePatchOrRemoveShipmentReceipt updateReceipt)
        {
            var updateShipment = new MergePatchShipment();
            updateShipment.ShipmentReceiptCommands.Add(updateReceipt);
            updateShipment.ShipmentId = c.ShipmentId;
            updateShipment.Version = c.Version;
            updateShipment.CommandId = c.CommandId;
            updateShipment.RequesterId = c.RequesterId;
            When(updateShipment);
        }

        private ICreateOrMergePatchOrRemoveShipmentReceipt CreateOrUpdateShipmentReceipt(ShipmentCommands.ReceiveItem c, IShipmentState shipment, IShipmentItemState shipmentItem)
        {
            ICreateOrMergePatchOrRemoveShipmentReceipt updateReceipt = null;
            var receiptSeqId = c.ShipmentItemSeqId;
            var receipt = shipment.ShipmentReceipts.Get(receiptSeqId, false, true);
            if (receipt == null)
            {
                updateReceipt = new CreateShipmentReceipt();
            }
            else
            {
                updateReceipt = new MergePatchShipmentReceipt();
            }

            var prdState = GetProductState(shipmentItem.ProductId);

            string attrSetInstId = CreateAttributeSetInstance(prdState.AttributeSetId, c.AttributeSetInstance);
            if (_log.IsDebugEnabled) { _log.Debug("Create attribute set instance, id: " + attrSetInstId); }

            updateReceipt.AttributeSetInstanceId = attrSetInstId;

            updateReceipt.ReceiptSeqId = receiptSeqId;
            updateReceipt.ShipmentItemSeqId = shipmentItem.ShipmentItemSeqId;
            updateReceipt.ProductId = shipmentItem.ProductId;
            updateReceipt.AcceptedQuantity = c.AcceptedQuantity;
            updateReceipt.RejectedQuantity = c.RejectedQuantity;
            updateReceipt.DamagedQuantity = c.DamagedQuantity;
            updateReceipt.DamageStatusId = c.DamageStatusId;
            updateReceipt.DamageReasonId = c.DamageReasonId;
            updateReceipt.ReceivedBy = c.RequesterId;
            return updateReceipt;
        }

        private string CreateAttributeSetInstance(string attrSetId, IDictionary<string, object> attrSetInstDict)
        {
            if (String.IsNullOrWhiteSpace(attrSetId))
            {
                return null;
            }
            var nameDict = AttributeSetService.GetPropertyExtensionFieldDictionary(attrSetId);

            var createAttrSetInst = new CreateAttributeSetInstance();
            foreach (var kv in attrSetInstDict)
            {
                // //////////////////////////////////////////
                var fname = nameDict.ContainsKey(kv.Key) ? nameDict[kv.Key] : kv.Key;
                // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
                var b = ReflectUtils.TrySetPropertyValue(fname, createAttrSetInst, kv.Value);
                if (!b)
                {
                    var fmt = "Set property error. Property name: {0}";
                    if (_log.IsInfoEnabled) { _log.Info(String.Format(fmt, fname)); }
                    throw new DomainError(fmt, fname);
                }
                // //////////////////////////////////////////
            }
            var attrSetInstId = AttributeSetInstanceApplicationService.CreateWithoutId(createAttrSetInst);
            return attrSetInstId;
        }

        private IProductState GetProductState(string productId)
        {
            var prdState = ProductApplicationService.Get(productId);
            if (prdState == null)
            {
                throw new ArgumentException(String.Format("Product NOT found. Product Id.: {0}", productId));
            }
            return prdState;
        }

        private IShipmentState AssertShipmentStatus(string shipmentId, string status)
        {
            var shipment = StateRepository.Get(shipmentId, true);
            if (shipment == null)
            {
                throw new ArgumentException(String.Format("Error shipment Id.: {0}", shipmentId));
            }
            else
            {
                if (status != shipment.StatusId)
                {
                    throw new ApplicationException(String.Format("Error shipment status: {0}", shipment.StatusId));
                }
            }
            return shipment;
        }




    }
}
