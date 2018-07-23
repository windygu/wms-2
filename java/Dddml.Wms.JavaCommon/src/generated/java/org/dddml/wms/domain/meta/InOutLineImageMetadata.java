package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InOutLineImageMetadata {

    private InOutLineImageMetadata() {
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
            "inOutLineLineNumber",
            "inOutLineImageId.inOutDocumentNumber",
            "inOutLineImageId.inOutLineLineNumber",
            "inOutLineImageId.sequenceId",
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
        aliasMap.put("sequenceId", "inOutLineImageId.sequenceId");
        aliasMap.put("SequenceId", "inOutLineImageId.sequenceId");
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
        aliasMap.put("inOutDocumentNumber", "inOutLineImageId.inOutDocumentNumber");
        aliasMap.put("InOutDocumentNumber", "inOutLineImageId.inOutDocumentNumber");
        aliasMap.put("inOutLineLineNumber", "inOutLineImageId.inOutLineLineNumber");
        aliasMap.put("InOutLineLineNumber", "inOutLineImageId.inOutLineLineNumber");
        aliasMap.put("inOutLineImageId.inOutDocumentNumber", "inOutLineImageId.inOutDocumentNumber");
        aliasMap.put("InOutLineImageId.InOutDocumentNumber", "inOutLineImageId.inOutDocumentNumber");
        aliasMap.put("inOutLineImageId.inOutLineLineNumber", "inOutLineImageId.inOutLineLineNumber");
        aliasMap.put("InOutLineImageId.InOutLineLineNumber", "inOutLineImageId.inOutLineLineNumber");
        aliasMap.put("inOutLineImageId.sequenceId", "inOutLineImageId.sequenceId");
        aliasMap.put("InOutLineImageId.SequenceId", "inOutLineImageId.sequenceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

