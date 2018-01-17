using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.Shipment
{
    public partial class ShipmentAggregate
    {

        public void Import(IEnumerable<ImportingShipmentItem> shipmentItems, long version, string commandId, string requesterId)
        {
            throw new NotSupportedException();
        }

    }
}
