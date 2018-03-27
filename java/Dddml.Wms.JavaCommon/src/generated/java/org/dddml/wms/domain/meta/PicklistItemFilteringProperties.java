package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PicklistItemFilteringProperties
{

    private PicklistItemFilteringProperties()
    {
    }

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
            "picklistBinId",
            "picklistItemOrderShipGrpInvId.orderId",
            "picklistItemOrderShipGrpInvId.orderItemSeqId",
            "picklistItemOrderShipGrpInvId.shipGroupSeqId",
            "picklistItemOrderShipGrpInvId.productId",
            "picklistItemOrderShipGrpInvId.locatorId",
            "picklistItemOrderShipGrpInvId.attributeSetInstanceId",
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
            "String",
            "String",
            "Long",
            "String",
            "String",
            "String",
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
        aliasMap.put("picklistBinId", "picklistBinPicklistItemId.picklistBinId");
        aliasMap.put("PicklistBinId", "picklistBinPicklistItemId.picklistBinId");
        aliasMap.put("picklistItemOrderShipGrpInvId.orderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.OrderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("picklistItemOrderShipGrpInvId.orderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.OrderId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderId");
        aliasMap.put("picklistItemOrderShipGrpInvId.orderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.OrderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("picklistItemOrderShipGrpInvId.orderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.OrderItemSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdOrderItemSeqId");
        aliasMap.put("picklistItemOrderShipGrpInvId.shipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.ShipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("picklistItemOrderShipGrpInvId.shipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.ShipGroupSeqId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdShipGroupSeqId");
        aliasMap.put("picklistItemOrderShipGrpInvId.productId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.ProductId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("picklistItemOrderShipGrpInvId.productId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.ProductId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdProductId");
        aliasMap.put("picklistItemOrderShipGrpInvId.locatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.LocatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("picklistItemOrderShipGrpInvId.locatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.LocatorId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdLocatorId");
        aliasMap.put("picklistItemOrderShipGrpInvId.attributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.AttributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("picklistItemOrderShipGrpInvId.attributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
        aliasMap.put("PicklistItemOrderShipGrpInvId.AttributeSetInstanceId", "picklistBinPicklistItemId.picklistItemOrderShipGrpInvIdAttributeSetInstanceId");
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

