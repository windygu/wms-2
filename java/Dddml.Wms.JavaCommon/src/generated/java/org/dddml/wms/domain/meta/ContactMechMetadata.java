package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ContactMechMetadata {

    private ContactMechMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "contactMechId",
            "contactMechTypeId",
            "infoString",
            "toName",
            "attnName",
            "address1",
            "address2",
            "directions",
            "city",
            "postalCode",
            "postalCodeExt",
            "countryGeoId",
            "stateProvinceGeoId",
            "countyGeoId",
            "postalCodeGeoId",
            "geoPointId",
            "countryCode",
            "areaCode",
            "contactNumber",
            "askForName",
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
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
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
        aliasMap.put("contactMechId", "contactMechId");
        aliasMap.put("ContactMechId", "contactMechId");
        aliasMap.put("contactMechTypeId", "contactMechTypeId");
        aliasMap.put("ContactMechTypeId", "contactMechTypeId");
        aliasMap.put("infoString", "infoString");
        aliasMap.put("InfoString", "infoString");
        aliasMap.put("toName", "toName");
        aliasMap.put("ToName", "toName");
        aliasMap.put("attnName", "attnName");
        aliasMap.put("AttnName", "attnName");
        aliasMap.put("address1", "address1");
        aliasMap.put("Address1", "address1");
        aliasMap.put("address2", "address2");
        aliasMap.put("Address2", "address2");
        aliasMap.put("directions", "directions");
        aliasMap.put("Directions", "directions");
        aliasMap.put("city", "city");
        aliasMap.put("City", "city");
        aliasMap.put("postalCode", "postalCode");
        aliasMap.put("PostalCode", "postalCode");
        aliasMap.put("postalCodeExt", "postalCodeExt");
        aliasMap.put("PostalCodeExt", "postalCodeExt");
        aliasMap.put("countryGeoId", "countryGeoId");
        aliasMap.put("CountryGeoId", "countryGeoId");
        aliasMap.put("stateProvinceGeoId", "stateProvinceGeoId");
        aliasMap.put("StateProvinceGeoId", "stateProvinceGeoId");
        aliasMap.put("countyGeoId", "countyGeoId");
        aliasMap.put("CountyGeoId", "countyGeoId");
        aliasMap.put("postalCodeGeoId", "postalCodeGeoId");
        aliasMap.put("PostalCodeGeoId", "postalCodeGeoId");
        aliasMap.put("geoPointId", "geoPointId");
        aliasMap.put("GeoPointId", "geoPointId");
        aliasMap.put("countryCode", "countryCode");
        aliasMap.put("CountryCode", "countryCode");
        aliasMap.put("areaCode", "areaCode");
        aliasMap.put("AreaCode", "areaCode");
        aliasMap.put("contactNumber", "contactNumber");
        aliasMap.put("ContactNumber", "contactNumber");
        aliasMap.put("askForName", "askForName");
        aliasMap.put("AskForName", "askForName");
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

