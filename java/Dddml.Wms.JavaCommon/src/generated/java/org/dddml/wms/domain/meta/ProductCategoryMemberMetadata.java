package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ProductCategoryMemberMetadata {

    private ProductCategoryMemberMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "thruDate",
            "comments",
            "sequenceNum",
            "quantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "productCategoryMemberId.productCategoryId",
            "productCategoryMemberId.productId",
    };

    public static final String[] propertyTypes = new String[] {
            "java.sql.Timestamp",
            "String",
            "Long",
            "java.math.BigDecimal",
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
        aliasMap.put("thruDate", "thruDate");
        aliasMap.put("ThruDate", "thruDate");
        aliasMap.put("comments", "comments");
        aliasMap.put("Comments", "comments");
        aliasMap.put("sequenceNum", "sequenceNum");
        aliasMap.put("SequenceNum", "sequenceNum");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
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
        aliasMap.put("productCategoryMemberId.productCategoryId", "productCategoryMemberId.productCategoryId");
        aliasMap.put("ProductCategoryMemberId.ProductCategoryId", "productCategoryMemberId.productCategoryId");
        aliasMap.put("productCategoryMemberId.productId", "productCategoryMemberId.productId");
        aliasMap.put("ProductCategoryMemberId.ProductId", "productCategoryMemberId.productId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

