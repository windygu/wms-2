package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementLineMvoFilteringProperties
{

    private MovementLineMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
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
            "movementDocumentStatusId",
            "movementMovementDate",
            "movementPosted",
            "movementProcessed",
            "movementProcessing",
            "movementDateReceived",
            "movementDocumentTypeId",
            "movementIsInTransit",
            "movementIsApproved",
            "movementApprovalAmount",
            "movementShipperId",
            "movementSalesRepresentativeId",
            "movementBusinessPartnerId",
            "movementChargeAmount",
            "movementCreateFrom",
            "movementFreightAmount",
            "movementReversalDocumentNumber",
            "movementWarehouseIdFrom",
            "movementWarehouseIdTo",
            "movementDescription",
            "movementVersion",
            "movementCreatedBy",
            "movementCreatedAt",
            "movementUpdatedBy",
            "movementUpdatedAt",
            "movementActive",
            "movementDeleted",
            "movementLineId.movementDocumentNumber",
            "movementLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
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
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "Date",
            "String",
            "Boolean",
            "Boolean",
            "BigDecimal",
            "String",
            "String",
            "String",
            "BigDecimal",
            "String",
            "BigDecimal",
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
        aliasMap.put("movementDocumentStatusId", "movementDocumentStatusId");
        aliasMap.put("MovementDocumentStatusId", "movementDocumentStatusId");
        aliasMap.put("movementMovementDate", "movementMovementDate");
        aliasMap.put("MovementMovementDate", "movementMovementDate");
        aliasMap.put("movementPosted", "movementPosted");
        aliasMap.put("MovementPosted", "movementPosted");
        aliasMap.put("movementProcessed", "movementProcessed");
        aliasMap.put("MovementProcessed", "movementProcessed");
        aliasMap.put("movementProcessing", "movementProcessing");
        aliasMap.put("MovementProcessing", "movementProcessing");
        aliasMap.put("movementDateReceived", "movementDateReceived");
        aliasMap.put("MovementDateReceived", "movementDateReceived");
        aliasMap.put("movementDocumentTypeId", "movementDocumentTypeId");
        aliasMap.put("MovementDocumentTypeId", "movementDocumentTypeId");
        aliasMap.put("movementIsInTransit", "movementIsInTransit");
        aliasMap.put("MovementIsInTransit", "movementIsInTransit");
        aliasMap.put("movementIsApproved", "movementIsApproved");
        aliasMap.put("MovementIsApproved", "movementIsApproved");
        aliasMap.put("movementApprovalAmount", "movementApprovalAmount");
        aliasMap.put("MovementApprovalAmount", "movementApprovalAmount");
        aliasMap.put("movementShipperId", "movementShipperId");
        aliasMap.put("MovementShipperId", "movementShipperId");
        aliasMap.put("movementSalesRepresentativeId", "movementSalesRepresentativeId");
        aliasMap.put("MovementSalesRepresentativeId", "movementSalesRepresentativeId");
        aliasMap.put("movementBusinessPartnerId", "movementBusinessPartnerId");
        aliasMap.put("MovementBusinessPartnerId", "movementBusinessPartnerId");
        aliasMap.put("movementChargeAmount", "movementChargeAmount");
        aliasMap.put("MovementChargeAmount", "movementChargeAmount");
        aliasMap.put("movementCreateFrom", "movementCreateFrom");
        aliasMap.put("MovementCreateFrom", "movementCreateFrom");
        aliasMap.put("movementFreightAmount", "movementFreightAmount");
        aliasMap.put("MovementFreightAmount", "movementFreightAmount");
        aliasMap.put("movementReversalDocumentNumber", "movementReversalDocumentNumber");
        aliasMap.put("MovementReversalDocumentNumber", "movementReversalDocumentNumber");
        aliasMap.put("movementWarehouseIdFrom", "movementWarehouseIdFrom");
        aliasMap.put("MovementWarehouseIdFrom", "movementWarehouseIdFrom");
        aliasMap.put("movementWarehouseIdTo", "movementWarehouseIdTo");
        aliasMap.put("MovementWarehouseIdTo", "movementWarehouseIdTo");
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

