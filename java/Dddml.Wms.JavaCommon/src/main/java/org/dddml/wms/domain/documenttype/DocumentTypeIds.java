package org.dddml.wms.domain.documenttype;

/**
 * Created by yangjiefeng on 2018/1/31.
 */
public class DocumentTypeIds {
    /**
     出入库单。
     */
    public static final String IN_OUT = "InOut";

    /**
     装运单。
     */
    public static final String SHIPMENT = "Shipment";

    /**
     盘点单。
     */
    public static final String PHYSICAL_INVENTORY = "PhysicalInventory";

    /**
     移库 / 调拨单。
     */
    public static final String MOVEMENT = "Movement";

    /**
     移库 / 调拨确认单。
     */
    public static final String MOVEMENT_CONFIRMATION = "MovementConfirmation";

    // //////////////////// 以上是"父"类型 //////////////////////////

    public static final String IN = "In";
    
    public static final String OUT = "Out";

    /**
     在途移库。
     */
    public static final String IN_TRANSIT_MOVEMENT = "InTransitMovement";

    ///// <summary>
    ///// 其他入出库。
    ///// </summary>
    //public const string MiscellaneousInOut = "MiscellaneousInOut";

    ///// <summary>
    ///// 工单入出库。
    ///// </summary>
    //public const string WorkOrderInOut = "WorkOrderInOut";

    /**
     （从供应商）收货。
     */
    public static final String VENDOR_RECEIPT = "VendorReceipt";

    /**
     发货（给客户）。
     */
    public static final String CUSTOMER_SHIPMENT = "CustomerShipment";
}
