package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class MovementConfirmationLineMetadata {

    private MovementConfirmationLineMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "lineNumber",
            "movementLineNumber",
            "targetQuantity",
            "confirmedQuantity",
            "differenceQuantity",
            "scrappedQuantity",
            "description",
            "processed",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "movementConfirmationDocumentNumber",
            "movementConfirmationLineId.movementConfirmationDocumentNumber",
            "movementConfirmationLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "String",
            "Boolean",
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
        aliasMap.put("lineNumber", "movementConfirmationLineId.lineNumber");
        aliasMap.put("LineNumber", "movementConfirmationLineId.lineNumber");
        aliasMap.put("movementLineNumber", "movementLineNumber");
        aliasMap.put("MovementLineNumber", "movementLineNumber");
        aliasMap.put("targetQuantity", "targetQuantity");
        aliasMap.put("TargetQuantity", "targetQuantity");
        aliasMap.put("confirmedQuantity", "confirmedQuantity");
        aliasMap.put("ConfirmedQuantity", "confirmedQuantity");
        aliasMap.put("differenceQuantity", "differenceQuantity");
        aliasMap.put("DifferenceQuantity", "differenceQuantity");
        aliasMap.put("scrappedQuantity", "scrappedQuantity");
        aliasMap.put("ScrappedQuantity", "scrappedQuantity");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
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
        aliasMap.put("movementConfirmationDocumentNumber", "movementConfirmationLineId.movementConfirmationDocumentNumber");
        aliasMap.put("MovementConfirmationDocumentNumber", "movementConfirmationLineId.movementConfirmationDocumentNumber");
        aliasMap.put("movementConfirmationLineId.movementConfirmationDocumentNumber", "movementConfirmationLineId.movementConfirmationDocumentNumber");
        aliasMap.put("MovementConfirmationLineId.MovementConfirmationDocumentNumber", "movementConfirmationLineId.movementConfirmationDocumentNumber");
        aliasMap.put("movementConfirmationLineId.lineNumber", "movementConfirmationLineId.lineNumber");
        aliasMap.put("MovementConfirmationLineId.LineNumber", "movementConfirmationLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

