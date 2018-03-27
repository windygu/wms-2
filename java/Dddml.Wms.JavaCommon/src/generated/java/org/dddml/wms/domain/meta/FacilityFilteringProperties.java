package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class FacilityFilteringProperties
{

    private FacilityFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "facilityId",
            "facilityTypeId",
            "parentFacilityId",
            "ownerPartyId",
            "defaultInventoryItemTypeId",
            "facilityName",
            "primaryFacilityGroupId",
            "oldSquareFootage",
            "facilitySize",
            "facilitySizeUomId",
            "productStoreId",
            "defaultDaysToShip",
            "openedDate",
            "closedDate",
            "description",
            "defaultDimensionUomId",
            "defaultWeightUomId",
            "geoPointId",
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
            "Long",
            "java.math.BigDecimal",
            "String",
            "String",
            "Long",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
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
        aliasMap.put("facilityId", "facilityId");
        aliasMap.put("FacilityId", "facilityId");
        aliasMap.put("facilityTypeId", "facilityTypeId");
        aliasMap.put("FacilityTypeId", "facilityTypeId");
        aliasMap.put("parentFacilityId", "parentFacilityId");
        aliasMap.put("ParentFacilityId", "parentFacilityId");
        aliasMap.put("ownerPartyId", "ownerPartyId");
        aliasMap.put("OwnerPartyId", "ownerPartyId");
        aliasMap.put("defaultInventoryItemTypeId", "defaultInventoryItemTypeId");
        aliasMap.put("DefaultInventoryItemTypeId", "defaultInventoryItemTypeId");
        aliasMap.put("facilityName", "facilityName");
        aliasMap.put("FacilityName", "facilityName");
        aliasMap.put("primaryFacilityGroupId", "primaryFacilityGroupId");
        aliasMap.put("PrimaryFacilityGroupId", "primaryFacilityGroupId");
        aliasMap.put("oldSquareFootage", "oldSquareFootage");
        aliasMap.put("OldSquareFootage", "oldSquareFootage");
        aliasMap.put("facilitySize", "facilitySize");
        aliasMap.put("FacilitySize", "facilitySize");
        aliasMap.put("facilitySizeUomId", "facilitySizeUomId");
        aliasMap.put("FacilitySizeUomId", "facilitySizeUomId");
        aliasMap.put("productStoreId", "productStoreId");
        aliasMap.put("ProductStoreId", "productStoreId");
        aliasMap.put("defaultDaysToShip", "defaultDaysToShip");
        aliasMap.put("DefaultDaysToShip", "defaultDaysToShip");
        aliasMap.put("openedDate", "openedDate");
        aliasMap.put("OpenedDate", "openedDate");
        aliasMap.put("closedDate", "closedDate");
        aliasMap.put("ClosedDate", "closedDate");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("defaultDimensionUomId", "defaultDimensionUomId");
        aliasMap.put("DefaultDimensionUomId", "defaultDimensionUomId");
        aliasMap.put("defaultWeightUomId", "defaultWeightUomId");
        aliasMap.put("DefaultWeightUomId", "defaultWeightUomId");
        aliasMap.put("geoPointId", "geoPointId");
        aliasMap.put("GeoPointId", "geoPointId");
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

