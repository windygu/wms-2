package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PhysicalInventoryLineFilteringProperties
{

    private PhysicalInventoryLineFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "lineNumber",
            "locatorId",
            "productId",
            "attributeSetInstanceId",
            "bookQuantity",
            "countedQuantity",
            "processed",
            "reversalLineNumber",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "physicalInventoryDocumentNumber",
            "physicalInventoryLineId.physicalInventoryDocumentNumber",
            "physicalInventoryLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "BigDecimal",
            "BigDecimal",
            "Boolean",
            "Long",
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
        aliasMap.put("lineNumber", "physicalInventoryLineId.lineNumber");
        aliasMap.put("LineNumber", "physicalInventoryLineId.lineNumber");
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("bookQuantity", "bookQuantity");
        aliasMap.put("BookQuantity", "bookQuantity");
        aliasMap.put("countedQuantity", "countedQuantity");
        aliasMap.put("CountedQuantity", "countedQuantity");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("reversalLineNumber", "reversalLineNumber");
        aliasMap.put("ReversalLineNumber", "reversalLineNumber");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
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
        aliasMap.put("physicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("PhysicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("physicalInventoryLineId.physicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("PhysicalInventoryLineId.PhysicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("physicalInventoryLineId.lineNumber", "physicalInventoryLineId.lineNumber");
        aliasMap.put("PhysicalInventoryLineId.LineNumber", "physicalInventoryLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

