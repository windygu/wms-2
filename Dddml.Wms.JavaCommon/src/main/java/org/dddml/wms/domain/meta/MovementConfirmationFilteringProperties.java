package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementConfirmationFilteringProperties
{

    private MovementConfirmationFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "documentNumber",
            "documentStatusId",
            "movementDocumentNumber",
            "isApproved",
            "approvalAmount",
            "processed",
            "processing",
            "documentTypeId",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
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
        aliasMap.put("documentNumber", "documentNumber");
        aliasMap.put("DocumentNumber", "documentNumber");
        aliasMap.put("documentStatusId", "documentStatusId");
        aliasMap.put("DocumentStatusId", "documentStatusId");
        aliasMap.put("movementDocumentNumber", "movementDocumentNumber");
        aliasMap.put("MovementDocumentNumber", "movementDocumentNumber");
        aliasMap.put("isApproved", "isApproved");
        aliasMap.put("IsApproved", "isApproved");
        aliasMap.put("approvalAmount", "approvalAmount");
        aliasMap.put("ApprovalAmount", "approvalAmount");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("processing", "processing");
        aliasMap.put("Processing", "processing");
        aliasMap.put("documentTypeId", "documentTypeId");
        aliasMap.put("DocumentTypeId", "documentTypeId");
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
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

