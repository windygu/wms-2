package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderRoleMetadata {

    private OrderRoleMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderId",
            "partyRoleId.partyId",
            "partyRoleId.roleTypeId",
            "orderRoleId.orderId",
            "orderRoleId.partyRoleIdPartyId",
            "orderRoleId.partyRoleIdRoleTypeId",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("orderId", "orderRoleId.orderId");
        aliasMap.put("OrderId", "orderRoleId.orderId");
        aliasMap.put("partyRoleId.partyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("PartyRoleId.PartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("partyRoleId.partyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("PartyRoleId.PartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("partyRoleId.roleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("PartyRoleId.RoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("partyRoleId.roleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("PartyRoleId.RoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("orderRoleId.orderId", "orderRoleId.orderId");
        aliasMap.put("OrderRoleId.OrderId", "orderRoleId.orderId");
        aliasMap.put("orderRoleId.partyRoleIdPartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("OrderRoleId.PartyRoleIdPartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("orderRoleId.partyRoleId.partyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("OrderRoleId.PartyRoleId.PartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("orderRoleId.partyRoleIdRoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("OrderRoleId.PartyRoleIdRoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("orderRoleId.partyRoleId.roleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("OrderRoleId.PartyRoleId.RoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

