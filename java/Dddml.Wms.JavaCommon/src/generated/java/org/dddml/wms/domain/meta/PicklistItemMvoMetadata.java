package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class PicklistItemMvoMetadata {

    private PicklistItemMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "picklistBinVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "itemStatusId",
            "quantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "picklistBinPicklistId",
            "picklistBinBinLocationNumber",
            "picklistBinPrimaryOrderId",
            "picklistBinPrimaryShipGroupSeqId",
            "picklistBinVersion",
            "picklistBinCreatedBy",
            "picklistBinCreatedAt",
            "picklistBinUpdatedBy",
            "picklistBinUpdatedAt",
            "picklistBinActive",
            "picklistBinDeleted",
            "picklistBinPicklistItemId.picklistBinId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId",
            "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "java.math.BigDecimal",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "Long",
            "String",
            "Long",
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
            "Long",
            "String",
            "String",
            "String",
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
        aliasMap.put("itemStatusId", "itemStatusId");
        aliasMap.put("ItemStatusId", "itemStatusId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
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
        aliasMap.put("picklistBinPicklistId", "picklistBinPicklistId");
        aliasMap.put("PicklistBinPicklistId", "picklistBinPicklistId");
        aliasMap.put("picklistBinBinLocationNumber", "picklistBinBinLocationNumber");
        aliasMap.put("PicklistBinBinLocationNumber", "picklistBinBinLocationNumber");
        aliasMap.put("picklistBinPrimaryOrderId", "picklistBinPrimaryOrderId");
        aliasMap.put("PicklistBinPrimaryOrderId", "picklistBinPrimaryOrderId");
        aliasMap.put("picklistBinPrimaryShipGroupSeqId", "picklistBinPrimaryShipGroupSeqId");
        aliasMap.put("PicklistBinPrimaryShipGroupSeqId", "picklistBinPrimaryShipGroupSeqId");
        aliasMap.put("picklistBinVersion", "picklistBinVersion");
        aliasMap.put("PicklistBinVersion", "picklistBinVersion");
        aliasMap.put("picklistBinCreatedBy", "picklistBinCreatedBy");
        aliasMap.put("PicklistBinCreatedBy", "picklistBinCreatedBy");
        aliasMap.put("picklistBinCreatedAt", "picklistBinCreatedAt");
        aliasMap.put("PicklistBinCreatedAt", "picklistBinCreatedAt");
        aliasMap.put("picklistBinUpdatedBy", "picklistBinUpdatedBy");
        aliasMap.put("PicklistBinUpdatedBy", "picklistBinUpdatedBy");
        aliasMap.put("picklistBinUpdatedAt", "picklistBinUpdatedAt");
        aliasMap.put("PicklistBinUpdatedAt", "picklistBinUpdatedAt");
        aliasMap.put("picklistBinActive", "picklistBinActive");
        aliasMap.put("PicklistBinActive", "picklistBinActive");
        aliasMap.put("picklistBinDeleted", "picklistBinDeleted");
        aliasMap.put("PicklistBinDeleted", "picklistBinDeleted");
        aliasMap.put("picklistBinPicklistItemId.picklistBinId", "picklistBinPicklistItemId.picklistBinId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistBinId", "picklistBinPicklistItemId.picklistBinId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdOrderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.orderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.OrderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdOrderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.orderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.OrderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdShipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.shipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.ShipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdProductId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.productId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.ProductId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdLocatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.locatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.LocatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvIdAttributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("picklistBinPicklistItemId.picklistItemOrderShipGrpInvId.attributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("PicklistBinPicklistItemId.PicklistItemOrderShipGrpInvId.AttributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

