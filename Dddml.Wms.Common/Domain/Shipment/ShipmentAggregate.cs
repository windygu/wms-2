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

        public void ReceiveItem(string shipmentItemSeqId, IDictionary<string, object> attributeSetInstance, string rejectionReasonId, string damageStatusId, string damageReasonId, decimal? acceptedQuantity, decimal? rejectedQuantity, decimal? damagedQuantity, string itemDescription, long version, string commandId, string requesterId)
        {
            throw new NotSupportedException();
        }
    }
}
