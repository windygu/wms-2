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
        /// 移库 / 调拨单。
        /// </summary>
        public const string Movement = "Movement";

        /// <summary>
        /// 移库 / 调拨确认单。
        /// </summary>
        public const string MovementConfirmation = "MovementConfirmation";

        // //////////////////// 以上是“父”类型 //////////////////////////

        #region Child Document Types

        public const string In = "In";

        public const string Out = "Out";

        /// <summary>
        /// 在途移库。
        /// </summary>
        public const string InTransitMovement = "InTransitMovement";

        ///// <summary>
        ///// 其他入出库。
        ///// </summary>
        //public const string MiscellaneousInOut = "MiscellaneousInOut";

        ///// <summary>
        ///// 工单入出库。
        ///// </summary>
        //public const string WorkOrderInOut = "WorkOrderInOut";

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
