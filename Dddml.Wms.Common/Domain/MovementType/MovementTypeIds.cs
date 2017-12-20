using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.MovementType
{
    /// <summary>
    /// 库存的移动类型。
    /// </summary>
    public static class MovementTypeIds
    {
        /// <summary>
        /// 发货（给客户）。
        /// </summary>
        public const string CustomerShipment = "C-";

        /// <summary>
        /// 客户退货。
        /// </summary>
        public const string CustomerReturn = "C+";

        /// <summary>
        /// （从供应商）收货。
        /// </summary>
        public const string VendorReceipt = "V+";

        /// <summary>
        /// 退货给供应商。
        /// </summary>
        public const string VendorReturn = "V-";

        /// <summary>
        /// 盘入。
        /// </summary>
        public const string PhysicalInventoryIn = "I+";

        /// <summary>
        /// 盘出。
        /// </summary>
        public const string PhysicalInventoryOut = "I-";

        /// <summary>
        /// 生产入库。
        /// </summary>
        public const string ProductionIn = "P+";

        /// <summary>
        /// 生产出库。
        /// </summary>
        public const string ProductionOut = "P-";

        /// <summary>
        /// 移出（因移库减少库存）。
        /// </summary>
        public const string MovementOut = "M-";

        /// <summary>
        /// 移入（因移库增加库存）。
        /// </summary>
        public const string MovementIn = "M+";

        /// <summary>
        /// 工单入库。
        /// </summary>
        public const string WorkOrderIn = "W+";

        /// <summary>
        /// 工单出库。
        /// </summary>
        public const string WorkOrderOut = "W-";


        /// <summary>
        /// 其他入库。
        /// </summary>
        public const string MiscellaneousIn = "Misc+";

        /// <summary>
        /// 其他出库。
        /// </summary>
        public const string MiscellaneousOut = "Misc-";

    }
}
