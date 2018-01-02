package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class ShipmentReceiptFilteringProperties
{

    private ShipmentReceiptFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "receiptSeqId",
            "productId",
            "shipmentItemSeqId",
            "rejectionReasonId",
            "damageStatusId",
            "damageReasonId",
            "itemDescription",
            "acceptedQuantity",
            "rejectedQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentId",
            "shipmentReceiptId.shipmentId",
            "shipmentReceiptId.receiptSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
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
        aliasMap.put("receiptSeqId", "shipmentReceiptId.receiptSeqId");
        aliasMap.put("ReceiptSeqId", "shipmentReceiptId.receiptSeqId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("shipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("ShipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("rejectionReasonId", "rejectionReasonId");
        aliasMap.put("RejectionReasonId", "rejectionReasonId");
        aliasMap.put("damageStatusId", "damageStatusId");
        aliasMap.put("DamageStatusId", "damageStatusId");
        aliasMap.put("damageReasonId", "damageReasonId");
        aliasMap.put("DamageReasonId", "damageReasonId");
        aliasMap.put("itemDescription", "itemDescription");
        aliasMap.put("ItemDescription", "itemDescription");
        aliasMap.put("acceptedQuantity", "acceptedQuantity");
        aliasMap.put("AcceptedQuantity", "acceptedQuantity");
        aliasMap.put("rejectedQuantity", "rejectedQuantity");
        aliasMap.put("RejectedQuantity", "rejectedQuantity");
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
        aliasMap.put("shipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("ShipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("shipmentReceiptId.shipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("ShipmentReceiptId.ShipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("shipmentReceiptId.receiptSeqId", "shipmentReceiptId.receiptSeqId");
        aliasMap.put("ShipmentReceiptId.ReceiptSeqId", "shipmentReceiptId.receiptSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

