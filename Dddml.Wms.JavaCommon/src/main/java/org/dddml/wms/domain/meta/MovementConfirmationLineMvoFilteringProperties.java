package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementConfirmationLineMvoFilteringProperties
{

    private MovementConfirmationLineMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
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
            "movementConfirmationDocumentStatusId",
            "movementConfirmationMovementDocumentNumber",
            "movementConfirmationIsApproved",
            "movementConfirmationApprovalAmount",
            "movementConfirmationProcessed",
            "movementConfirmationProcessing",
            "movementConfirmationDocumentTypeId",
            "movementConfirmationDescription",
            "movementConfirmationVersion",
            "movementConfirmationCreatedBy",
            "movementConfirmationCreatedAt",
            "movementConfirmationUpdatedBy",
            "movementConfirmationUpdatedAt",
            "movementConfirmationActive",
            "movementConfirmationDeleted",
            "movementConfirmationLineId.movementConfirmationDocumentNumber",
            "movementConfirmationLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
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
            "Boolean",
            "BigDecimal",
            "Boolean",
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
        aliasMap.put("movementConfirmationDocumentStatusId", "movementConfirmationDocumentStatusId");
        aliasMap.put("MovementConfirmationDocumentStatusId", "movementConfirmationDocumentStatusId");
        aliasMap.put("movementConfirmationMovementDocumentNumber", "movementConfirmationMovementDocumentNumber");
        aliasMap.put("MovementConfirmationMovementDocumentNumber", "movementConfirmationMovementDocumentNumber");
        aliasMap.put("movementConfirmationIsApproved", "movementConfirmationIsApproved");
        aliasMap.put("MovementConfirmationIsApproved", "movementConfirmationIsApproved");
        aliasMap.put("movementConfirmationApprovalAmount", "movementConfirmationApprovalAmount");
        aliasMap.put("MovementConfirmationApprovalAmount", "movementConfirmationApprovalAmount");
        aliasMap.put("movementConfirmationProcessed", "movementConfirmationProcessed");
        aliasMap.put("MovementConfirmationProcessed", "movementConfirmationProcessed");
        aliasMap.put("movementConfirmationProcessing", "movementConfirmationProcessing");
        aliasMap.put("MovementConfirmationProcessing", "movementConfirmationProcessing");
        aliasMap.put("movementConfirmationDocumentTypeId", "movementConfirmationDocumentTypeId");
        aliasMap.put("MovementConfirmationDocumentTypeId", "movementConfirmationDocumentTypeId");
        aliasMap.put("movementConfirmationDescription", "movementConfirmationDescription");
        aliasMap.put("MovementConfirmationDescription", "movementConfirmationDescription");
        aliasMap.put("movementConfirmationVersion", "movementConfirmationVersion");
        aliasMap.put("MovementConfirmationVersion", "movementConfirmationVersion");
        aliasMap.put("movementConfirmationCreatedBy", "movementConfirmationCreatedBy");
        aliasMap.put("MovementConfirmationCreatedBy", "movementConfirmationCreatedBy");
        aliasMap.put("movementConfirmationCreatedAt", "movementConfirmationCreatedAt");
        aliasMap.put("MovementConfirmationCreatedAt", "movementConfirmationCreatedAt");
        aliasMap.put("movementConfirmationUpdatedBy", "movementConfirmationUpdatedBy");
        aliasMap.put("MovementConfirmationUpdatedBy", "movementConfirmationUpdatedBy");
        aliasMap.put("movementConfirmationUpdatedAt", "movementConfirmationUpdatedAt");
        aliasMap.put("MovementConfirmationUpdatedAt", "movementConfirmationUpdatedAt");
        aliasMap.put("movementConfirmationActive", "movementConfirmationActive");
        aliasMap.put("MovementConfirmationActive", "movementConfirmationActive");
        aliasMap.put("movementConfirmationDeleted", "movementConfirmationDeleted");
        aliasMap.put("MovementConfirmationDeleted", "movementConfirmationDeleted");
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

