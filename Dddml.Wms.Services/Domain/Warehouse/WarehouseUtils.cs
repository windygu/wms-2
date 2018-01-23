using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Domain.Warehouse
{
    public static class WarehouseUtils
    {

        public static string GetInTransitLocatorId(string warehouseId)
        {
            if (String.IsNullOrWhiteSpace(warehouseId)) { throw new ArgumentNullException("warehouseId"); }
            return warehouseId + "-IN_TRANSIT";
        }

        public static string GetReceivingLocatorId(string warehouseId)
        {
            if (String.IsNullOrWhiteSpace(warehouseId)) { throw new ArgumentNullException("warehouseId"); }
            return warehouseId + "-RECEIVING_AREA";
        }

    }
}
