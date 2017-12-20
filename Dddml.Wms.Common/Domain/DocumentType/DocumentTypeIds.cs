using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.DocumentType
{
    /// <summary>
    /// 文档的类型。
    /// </summary>
    public static class DocumentTypeIds
    {
        /// <summary>
        /// 出入库单。
        /// </summary>
        public const string InOut = "InOut";

        /// <summary>
        /// 装运单。
        /// </summary>
        public const string Shipment = "Shipment";

        /// <summary>
        /// 盘点单。
        /// </summary>
        public const string PhysicalInventory = "PhysicalInventory";

        /// <summary>
        /// 移库。
        /// </summary>
        public const string Movement = "Movement";


        // //////////////////// 以上是“父”类型 //////////////////////////

        #region Child Document Types


        /// <summary>
        /// 在途移库。
        /// </summary>
        public const string InTransitMovement = "InTransitMovement";

        ///// <summary>
        ///// 库位调拨入库。
        ///// </summary>
        //public const string MovementIn = "MovementIn";

        ///// <summary>
        ///// 库位调拨出库。
        ///// </summary>
        //public const string MovementOut = "MovementOut";

        /// <summary>
        /// 其他入库。
        /// </summary>
        public const string MiscellaneousIn = "MiscellaneousIn";

        /// <summary>
        /// 其他出库。
        /// </summary>
        public const string MiscellaneousOut = "MiscellaneousOut";

        /// <summary>
        /// 工单入库。
        /// </summary>
        public const string WorkOrderIn = "WorkOrderIn";

        /// <summary>
        /// 工单出库。
        /// </summary>
        public const string WorkOrderOut = "WorkOrderOut";

        /// <summary>
        /// （从供应商）收货。
        /// </summary>
        public const string VendorReceipt = "VendorReceipt";

        /// <summary>
        /// 发货（给客户）。
        /// </summary>
        public const string CustomerShipment = "CustomerShipment";

        #endregion

    }
}
