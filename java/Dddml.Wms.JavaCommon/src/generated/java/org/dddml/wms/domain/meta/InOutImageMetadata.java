package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InOutImageMetadata {

    private InOutImageMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "sequenceId",
            "url",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inOutDocumentNumber",
            "inOutImageId.inOutDocumentNumber",
            "inOutImageId.sequenceId",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("sequenceId", "inOutImageId.sequenceId");
        aliasMap.put("SequenceId", "inOutImageId.sequenceId");
        aliasMap.put("url", "url");
        aliasMap.put("Url", "url");
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
        aliasMap.put("inOutDocumentNumber", "inOutImageId.inOutDocumentNumber");
        aliasMap.put("InOutDocumentNumber", "inOutImageId.inOutDocumentNumber");
        aliasMap.put("inOutImageId.inOutDocumentNumber", "inOutImageId.inOutDocumentNumber");
        aliasMap.put("InOutImageId.InOutDocumentNumber", "inOutImageId.inOutDocumentNumber");
        aliasMap.put("inOutImageId.sequenceId", "inOutImageId.sequenceId");
        aliasMap.put("InOutImageId.SequenceId", "inOutImageId.sequenceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

