package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class UomConversionMetadata {

    private UomConversionMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "conversionFactor",
            "customMethodId",
            "decimalScale",
            "roundingMode",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "uomConversionId.uomId",
            "uomConversionId.uomIdTo",
    };

    public static final String[] propertyTypes = new String[] {
            "Double",
            "String",
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
        aliasMap.put("conversionFactor", "conversionFactor");
        aliasMap.put("ConversionFactor", "conversionFactor");
        aliasMap.put("customMethodId", "customMethodId");
        aliasMap.put("CustomMethodId", "customMethodId");
        aliasMap.put("decimalScale", "decimalScale");
        aliasMap.put("DecimalScale", "decimalScale");
        aliasMap.put("roundingMode", "roundingMode");
        aliasMap.put("RoundingMode", "roundingMode");
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
        aliasMap.put("uomConversionId.uomId", "uomConversionId.uomId");
        aliasMap.put("UomConversionId.UomId", "uomConversionId.uomId");
        aliasMap.put("uomConversionId.uomIdTo", "uomConversionId.uomIdTo");
        aliasMap.put("UomConversionId.UomIdTo", "uomConversionId.uomIdTo");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

