package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementLineFilteringProperties
{

    private MovementLineFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "lineNumber",
            "movementQuantity",
            "productId",
            "locatorIdFrom",
            "locatorIdTo",
            "attributeSetInstanceId",
            "processed",
            "reversalLineNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "movementDocumentNumber",
            "movementLineId.movementDocumentNumber",
            "movementLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "BigDecimal",
            "String",
            "String",
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
        aliasMap.put("lineNumber", "movementLineId.lineNumber");
        aliasMap.put("LineNumber", "movementLineId.lineNumber");
        aliasMap.put("movementQuantity", "movementQuantity");
        aliasMap.put("MovementQuantity", "movementQuantity");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("locatorIdFrom", "locatorIdFrom");
        aliasMap.put("LocatorIdFrom", "locatorIdFrom");
        aliasMap.put("locatorIdTo", "locatorIdTo");
        aliasMap.put("LocatorIdTo", "locatorIdTo");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("reversalLineNumber", "reversalLineNumber");
        aliasMap.put("ReversalLineNumber", "reversalLineNumber");
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
        aliasMap.put("movementDocumentNumber", "movementLineId.movementDocumentNumber");
        aliasMap.put("MovementDocumentNumber", "movementLineId.movementDocumentNumber");
        aliasMap.put("movementLineId.movementDocumentNumber", "movementLineId.movementDocumentNumber");
        aliasMap.put("MovementLineId.MovementDocumentNumber", "movementLineId.movementDocumentNumber");
        aliasMap.put("movementLineId.lineNumber", "movementLineId.lineNumber");
        aliasMap.put("MovementLineId.LineNumber", "movementLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

