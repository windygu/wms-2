package org.dddml.wms.domain.inventorypostingrule;

/**
 * Created by yangjiefeng on 2018/1/29.
 */
public class InventoryPostingRuleIds {

    public static final String QUANTITY_ON_HAND_UPDATE_PRODUCT_SELLABLE_TOTAL = "OH->PrdSellableTotal";
    public static final String QUANTITY_OCCUPIED_UPDATE_PRODUCT_SELLABLE_TOTAL = "Oc->PrdSellableTotal";
    public static final String QUANTITY_RESERVED_UPDATE_PRODUCT_SELLABLE_TOTAL = "R->PrdSellableTotal";
    public static final String QUANTITY_VIRTUAL_UPDATE_PRODUCT_SELLABLE_TOTAL = "V->PrdSellableTotal";
    public static final String QUANTITY_IN_TRANSIT_UPDATE_PRODUCT_SELLABLE_TOTAL = "IT->PrdSellableTotal";

    // 需求数量 = 订单占用数量（Oc） - 在库数量（OH） + 保留数量（R） - 在途数量（IT）
    public static final String QUANTITY_ON_HAND_UPDATE_PRODUCT_REQUIRED_TOTAL = "OH->PrdRequiredTotal";
    public static final String QUANTITY_OCCUPIED_UPDATE_PRODUCT_REQUIRED_TOTAL = "Oc->PrdRequiredTotal";
    public static final String QUANTITY_RESERVED_UPDATE_PRODUCT_REQUIRED_TOTAL = "R->PrdRequiredTotal";
    public static final String QUANTITY_IN_TRANSIT_UPDATE_PRODUCT_REQUIRED_TOTAL = "IT->PrdRequiredTotal";

    public static final String OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY = "SellableQuantity";
    public static final String OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY = "RequiredQuantity";
    
}
