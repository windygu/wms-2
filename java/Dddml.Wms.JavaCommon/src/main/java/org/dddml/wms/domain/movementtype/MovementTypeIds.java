package org.dddml.wms.domain.movementtype;

/**
 * Created by yangjiefeng on 2018/1/31.
 */
public class MovementTypeIds {
    /**
     发货（给客户）。
     */
    public static final String CUSTOMER_SHIPMENT = "C-";

    /**
     客户退货。
     */
    public static final String CUSTOMER_RETURN = "C+";

    /**
     （从供应商）收货。
     */
    public static final String VENDOR_RECEIPT = "V+";

    /**
     退货给供应商。
     */
    public static final String VENDOR_RETURN = "V-";

    /**
     盘入。
     */
    public static final String PHYSICAL_INVENTORY_IN = "I+";

    /**
     盘出。
     */
    public static final String PHYSICAL_INVENTORY_OUT = "I-";

    /**
     生产入库。
     */
    public static final String PRODUCTION_IN = "P+";

    /**
     生产出库。
     */
    public static final String PRODUCTION_OUT = "P-";

    /**
     移出（因移库减少库存）。
     */
    public static final String MOVEMENT_OUT = "M-";

    /**
     移入（因移库增加库存）。
     */
    public static final String MOVEMENT_IN = "M+";

    /**
     工单入库。
     */
    public static final String WORK_ORDER_IN = "W+";

    /**
     工单出库。
     */
    public static final String WORK_ORDER_OUT = "W-";


    /**
     其他入库。
     */
    public static final String MISCELLANEOUS_IN = "Misc+";

    /**
     其他出库。
     */
    public static final String MISCELLANEOUS_OUT = "Misc-";

}
