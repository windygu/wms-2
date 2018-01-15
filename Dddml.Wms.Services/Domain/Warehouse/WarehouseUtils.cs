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
            return warehouseId + "-IN_TRANSIT";
        }

    }
}
