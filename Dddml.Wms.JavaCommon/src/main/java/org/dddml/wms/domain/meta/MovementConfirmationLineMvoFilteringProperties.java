package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementConfirmationLineMvoFilteringProperties
{

    private MovementConfirmationLineMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "targetQuantity",
            "confirmedQuantity",
            "differenceQuantity",
            "scrappedQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "movementDocumentTypeId",
            "movementDocumentStatusId",
            "movementMovementTypeId",
            "movementDescription",
            "movementVersion",
            "movementCreatedBy",
            "movementCreatedAt",
            "movementUpdatedBy",
            "movementUpdatedAt",
            "movementActive",
            "movementDeleted",
            "movementConfirmationLineId.movementDocumentNumber",
            "movementConfirmationLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
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
        aliasMap.put("targetQuantity", "targetQuantity");
        aliasMap.put("TargetQuantity", "targetQuantity");
        aliasMap.put("confirmedQuantity", "confirmedQuantity");
        aliasMap.put("ConfirmedQuantity", "confirmedQuantity");
        aliasMap.put("differenceQuantity", "differenceQuantity");
        aliasMap.put("DifferenceQuantity", "differenceQuantity");
        aliasMap.put("scrappedQuantity", "scrappedQuantity");
        aliasMap.put("ScrappedQuantity", "scrappedQuantity");
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
        aliasMap.put("movementDocumentTypeId", "movementDocumentTypeId");
        aliasMap.put("MovementDocumentTypeId", "movementDocumentTypeId");
        aliasMap.put("movementDocumentStatusId", "movementDocumentStatusId");
        aliasMap.put("MovementDocumentStatusId", "movementDocumentStatusId");
        aliasMap.put("movementMovementTypeId", "movementMovementTypeId");
        aliasMap.put("MovementMovementTypeId", "movementMovementTypeId");
        aliasMap.put("movementDescription", "movementDescription");
        aliasMap.put("MovementDescription", "movementDescription");
        aliasMap.put("movementVersion", "movementVersion");
        aliasMap.put("MovementVersion", "movementVersion");
        aliasMap.put("movementCreatedBy", "movementCreatedBy");
        aliasMap.put("MovementCreatedBy", "movementCreatedBy");
        aliasMap.put("movementCreatedAt", "movementCreatedAt");
        aliasMap.put("MovementCreatedAt", "movementCreatedAt");
        aliasMap.put("movementUpdatedBy", "movementUpdatedBy");
        aliasMap.put("MovementUpdatedBy", "movementUpdatedBy");
        aliasMap.put("movementUpdatedAt", "movementUpdatedAt");
        aliasMap.put("MovementUpdatedAt", "movementUpdatedAt");
        aliasMap.put("movementActive", "movementActive");
        aliasMap.put("MovementActive", "movementActive");
        aliasMap.put("movementDeleted", "movementDeleted");
        aliasMap.put("MovementDeleted", "movementDeleted");
        aliasMap.put("movementConfirmationLineId.movementDocumentNumber", "movementConfirmationLineId.movementDocumentNumber");
        aliasMap.put("MovementConfirmationLineId.MovementDocumentNumber", "movementConfirmationLineId.movementDocumentNumber");
        aliasMap.put("movementConfirmationLineId.lineNumber", "movementConfirmationLineId.lineNumber");
        aliasMap.put("MovementConfirmationLineId.LineNumber", "movementConfirmationLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

