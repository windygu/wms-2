package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InOutLineFilteringProperties
{

    private InOutLineFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "lineNumber",
            "locatorId",
            "productId",
            "attributeSetInstanceId",
            "description",
            "quantityUomId",
            "movementQuantity",
            "pickedQuantity",
            "isInvoiced",
            "processed",
            "rmaLineNumber",
            "reversalLineNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inOutDocumentNumber",
            "inOutLineId.inOutDocumentNumber",
            "inOutLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "BigDecimal",
            "BigDecimal",
            "Boolean",
            "Boolean",
            "String",
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
        aliasMap.put("lineNumber", "inOutLineId.lineNumber");
        aliasMap.put("LineNumber", "inOutLineId.lineNumber");
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("quantityUomId", "quantityUomId");
        aliasMap.put("QuantityUomId", "quantityUomId");
        aliasMap.put("movementQuantity", "movementQuantity");
        aliasMap.put("MovementQuantity", "movementQuantity");
        aliasMap.put("pickedQuantity", "pickedQuantity");
        aliasMap.put("PickedQuantity", "pickedQuantity");
        aliasMap.put("isInvoiced", "isInvoiced");
        aliasMap.put("IsInvoiced", "isInvoiced");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("rmaLineNumber", "rmaLineNumber");
        aliasMap.put("RmaLineNumber", "rmaLineNumber");
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
        aliasMap.put("inOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("InOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("inOutLineId.inOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("InOutLineId.InOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("inOutLineId.lineNumber", "inOutLineId.lineNumber");
        aliasMap.put("InOutLineId.LineNumber", "inOutLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

