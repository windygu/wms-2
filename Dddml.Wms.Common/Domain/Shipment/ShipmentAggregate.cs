using Dddml.Wms.Domain.ShipmentType;
using Dddml.Wms.Domain.StatusItem;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.Shipment
{
    public partial class ShipmentAggregate : IShipmentAggregate
    {
        public void Import(string shipmentTypeId, string primaryOrderId, string primaryReturnId, DateTime? estimatedReadyDate, DateTime? estimatedShipDate, DateTime? estimatedArrivalDate, DateTime? latestCancelDate, decimal? estimatedShipCost, string currencyUomId, string handlingInstructions, string originFacilityId, string destinationFacilityId, string partyIdTo, string partyIdFrom, decimal? additionalShippingCharge, string addtlShippingChargeDesc, IEnumerable<ImportingShipmentItem> shipmentItems, long version, string commandId, string requesterId)
        {
            throw new NotSupportedException();
        }

        public void Ship(long version, string commandId, string requesterId)
        {
            bool isStatusOk = false;
            if (State.StatusId == StatusItemIds.PurchShipCreated)
            {
                isStatusOk = true;
            }
            else if (State.StatusId == StatusItemIds.ShipmentInput
                || State.StatusId == StatusItemIds.ShipmentPicked//??
                || State.StatusId == StatusItemIds.ShipmentPacked//??
                )
            {
                isStatusOk = true;
            }
            if (!isStatusOk)
            {
                throw new ArgumentException(String.Format("Error shipment status: {0}.", State.StatusId));
            }

            var e = NewShipmentStateMergePatched(version, commandId,requesterId);
            if (State.ShipmentTypeId == ShipmentTypeIds.IncomingShipment
                || ShipmentTypeIds.GetParentTypeId(State.ShipmentTypeId) == ShipmentTypeIds.IncomingShipment)
            {
                e.StatusId = StatusItemIds.PurchShipShipped;
            }
            else
            {
                e.StatusId = StatusItemIds.ShipmentShipped;
            }
            Apply(e);
       }

        public void ReceiveItem(string shipmentItemSeqId, IDictionary<string, object> attributeSetInstance, string rejectionReasonId, string damageStatusId, string damageReasonId, decimal? acceptedQuantity, decimal? rejectedQuantity, decimal? damagedQuantity, string itemDescription, long version, string commandId, string requesterId)
        {
            throw new NotSupportedException();
        }

        public void ConfirmReceipt(long version, string commandId, string requesterId)
        {
            bool isStatusOk = false;
            if (State.StatusId == StatusItemIds.PurchShipShipped)
            {
                isStatusOk = true;
            }
            if (!isStatusOk)
            {
                throw new ArgumentException(String.Format("Error shipment status: {0}.", State.StatusId));
            }
            var e = NewShipmentStateMergePatched(version, commandId, requesterId);
            e.StatusId = StatusItemIds.PurchShipReceived;
            Apply(e);
        }
    }
}
