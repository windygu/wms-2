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
            "movementLineId.movementDocumentNumber",
            "movementLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("movementQuantity", "movementQuantity");
        aliasMap.put("MovementQuantity", "movementQuantity");
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

