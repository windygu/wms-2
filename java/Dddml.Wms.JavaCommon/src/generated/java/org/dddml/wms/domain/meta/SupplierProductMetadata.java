package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class SupplierProductMetadata {

    private SupplierProductMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "availableThruDate",
            "supplierPrefOrderId",
            "supplierRatingTypeId",
            "standardLeadTimeDays",
            "manufacturingLeadTimeDays",
            "deliveryLeadTimeDays",
            "quantityUomId",
            "lastPrice",
            "shippingPrice",
            "externalProductName",
            "externalProductId",
            "canDropShip",
            "comments",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "supplierProductId.productId",
            "supplierProductId.partyId",
            "supplierProductId.currencyUomId",
            "supplierProductId.minimumOrderQuantity",
    };

    public static final String[] propertyTypes = new String[] {
            "java.sql.Timestamp",
            "String",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "String",
            "Boolean",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
    };

    public static final Map<String, String> propertyTypeMap;

    public static final Map<String, String> aliasMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        initPropertyTypeMap();
        aliasMap = new HashMap<String, String>();
        initAliasMap();
    }

    private static  void initAliasMap() {
        aliasMap.put("availableThruDate", "availableThruDate");
        aliasMap.put("AvailableThruDate", "availableThruDate");
        aliasMap.put("supplierPrefOrderId", "supplierPrefOrderId");
        aliasMap.put("SupplierPrefOrderId", "supplierPrefOrderId");
        aliasMap.put("supplierRatingTypeId", "supplierRatingTypeId");
        aliasMap.put("SupplierRatingTypeId", "supplierRatingTypeId");
        aliasMap.put("standardLeadTimeDays", "standardLeadTimeDays");
        aliasMap.put("StandardLeadTimeDays", "standardLeadTimeDays");
        aliasMap.put("manufacturingLeadTimeDays", "manufacturingLeadTimeDays");
        aliasMap.put("ManufacturingLeadTimeDays", "manufacturingLeadTimeDays");
        aliasMap.put("deliveryLeadTimeDays", "deliveryLeadTimeDays");
        aliasMap.put("DeliveryLeadTimeDays", "deliveryLeadTimeDays");
        aliasMap.put("quantityUomId", "quantityUomId");
        aliasMap.put("QuantityUomId", "quantityUomId");
        aliasMap.put("lastPrice", "lastPrice");
        aliasMap.put("LastPrice", "lastPrice");
        aliasMap.put("shippingPrice", "shippingPrice");
        aliasMap.put("ShippingPrice", "shippingPrice");
        aliasMap.put("externalProductName", "externalProductName");
        aliasMap.put("ExternalProductName", "externalProductName");
        aliasMap.put("externalProductId", "externalProductId");
        aliasMap.put("ExternalProductId", "externalProductId");
        aliasMap.put("canDropShip", "canDropShip");
        aliasMap.put("CanDropShip", "canDropShip");
        aliasMap.put("comments", "comments");
        aliasMap.put("Comments", "comments");
        aliasMap.put("version", "version");
        aliasMap.put("Version", "version");
        aliasMap.put("createdBy", "createdBy");
        aliasMap.put("CreatedBy", "createdBy");
        aliasMap.put("createdAt", "createdAt");
        aliasMap.put("CreatedAt", "createdAt");
        aliasMap.put("updatedBy", "updatedBy");
        aliasMap.put("UpdatedBy", "updatedBy");
        aliasMap.put("updatedAt", "updatedAt");
        aliasMap.put("UpdatedAt", "updatedAt");
        aliasMap.put("active", "active");
        aliasMap.put("Active", "active");
        aliasMap.put("deleted", "deleted");
        aliasMap.put("Deleted", "deleted");
        aliasMap.put("supplierProductId.productId", "supplierProductId.productId");
        aliasMap.put("SupplierProductId.ProductId", "supplierProductId.productId");
        aliasMap.put("supplierProductId.partyId", "supplierProductId.partyId");
        aliasMap.put("SupplierProductId.PartyId", "supplierProductId.partyId");
        aliasMap.put("supplierProductId.currencyUomId", "supplierProductId.currencyUomId");
        aliasMap.put("SupplierProductId.CurrencyUomId", "supplierProductId.currencyUomId");
        aliasMap.put("supplierProductId.minimumOrderQuantity", "supplierProductId.minimumOrderQuantity");
        aliasMap.put("SupplierProductId.MinimumOrderQuantity", "supplierProductId.minimumOrderQuantity");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

