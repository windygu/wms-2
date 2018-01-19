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
            //todo

            var shipItems = new List<ICreateShipmentItem>();
            int i = 0;
            foreach (var d in c.ShipmentItems)
            {
                var shipItem = shipment.NewCreateShipmentItem();

                var prdState = GetProductState(d);

                string attrSetInstId = CreateAttributeSetInstance(d, prdState);
                if (_log.IsDebugEnabled) { _log.Debug("Create attribute set instance, id: " + attrSetInstId); }

                //todo
                shipItem.AttributeSetInstanceId = attrSetInstId;
                shipItem.ProductId = prdState.ProductId;
                shipItem.Quantity = d.Quantity;
                shipItem.Active = true;
                shipItem.ShipmentItemSeqId = i.ToString();

                shipment.ShipmentItems.Add(shipItem);
                i++;
            }

            When(shipment);
        }

        private string CreateAttributeSetInstance(ImportingShipmentItem d, IProductState prdState)
        {
            string attrSetInstId = null;
            var attrSetId = prdState.AttributeSetId;
            if (!String.IsNullOrWhiteSpace(attrSetId))
            {
                var nameDict = AttributeSetService.GetPropertyExtensionFieldDictionary(attrSetId);

                var attrSetInstDict = d.AttributeSetInstance;
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
                attrSetInstId = AttributeSetInstanceApplicationService.CreateWithoutId(createAttrSetInst);
            }
            return attrSetInstId;
        }

        private IProductState GetProductState(ImportingShipmentItem d)
        {
            var prdState = ProductApplicationService.Get(d.ProductId);
            if (prdState == null)
            {
                throw new ArgumentException(String.Format("Product NOT found. Product Id.: {0}", d.ProductId));
            }
            return prdState;
        }

    }
}
