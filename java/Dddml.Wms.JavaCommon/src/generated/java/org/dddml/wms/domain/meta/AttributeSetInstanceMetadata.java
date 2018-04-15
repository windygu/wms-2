package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class AttributeSetInstanceMetadata {

    private AttributeSetInstanceMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "attributeSetInstanceId",
            "attributeSetId",
            "organizationId",
            "referenceId",
            "serialNumber",
            "lotId",
            "description",
            "widthInch",
            "diameterInch",
            "weightLbs",
            "weightKg",
            "airDryWeightLbs",
            "airDryWeightKg",
            "airDryMetricTon",
            "packageCount",
            "airDryPct",
            "_F_B_0_",
            "_F_I_0_",
            "_F_L_0_",
            "_F_DT_0_",
            "_F_N_0_",
            "_F_C5_0_",
            "_F_C10_0_",
            "_F_C20_0_",
            "_F_C50_0_",
            "_F_C100_0_",
            "_F_C200_0_",
            "_F_C500_0_",
            "_F_C1000_0_",
            "_F_B_1_",
            "_F_I_1_",
            "_F_L_1_",
            "_F_DT_1_",
            "_F_N_1_",
            "_F_C5_1_",
            "_F_C10_1_",
            "_F_C20_1_",
            "_F_C50_1_",
            "_F_C100_1_",
            "_F_C200_1_",
            "_F_B_2_",
            "_F_I_2_",
            "_F_L_2_",
            "_F_DT_2_",
            "_F_N_2_",
            "_F_C5_2_",
            "_F_C10_2_",
            "_F_C20_2_",
            "_F_C50_2_",
            "_F_B_3_",
            "_F_I_3_",
            "_F_L_3_",
            "_F_DT_3_",
            "_F_N_3_",
            "_F_C5_3_",
            "_F_C10_3_",
            "_F_C20_3_",
            "_F_C50_3_",
            "_F_B_4_",
            "_F_I_4_",
            "_F_L_4_",
            "_F_DT_4_",
            "_F_N_4_",
            "_F_C5_4_",
            "_F_C10_4_",
            "_F_C20_4_",
            "_F_C50_4_",
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
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "Integer",
            "BigDecimal",
            "Boolean",
            "Integer",
            "Long",
            "Date",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "Date",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "Date",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "Date",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "Date",
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
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("attributeSetId", "attributeSetId");
        aliasMap.put("AttributeSetId", "attributeSetId");
        aliasMap.put("organizationId", "organizationId");
        aliasMap.put("OrganizationId", "organizationId");
        aliasMap.put("referenceId", "referenceId");
        aliasMap.put("ReferenceId", "referenceId");
        aliasMap.put("serialNumber", "serialNumber");
        aliasMap.put("SerialNumber", "serialNumber");
        aliasMap.put("lotId", "lotId");
        aliasMap.put("LotId", "lotId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("widthInch", "widthInch");
        aliasMap.put("WidthInch", "widthInch");
        aliasMap.put("diameterInch", "diameterInch");
        aliasMap.put("DiameterInch", "diameterInch");
        aliasMap.put("weightLbs", "weightLbs");
        aliasMap.put("WeightLbs", "weightLbs");
        aliasMap.put("weightKg", "weightKg");
        aliasMap.put("WeightKg", "weightKg");
        aliasMap.put("airDryWeightLbs", "airDryWeightLbs");
        aliasMap.put("AirDryWeightLbs", "airDryWeightLbs");
        aliasMap.put("airDryWeightKg", "airDryWeightKg");
        aliasMap.put("AirDryWeightKg", "airDryWeightKg");
        aliasMap.put("airDryMetricTon", "airDryMetricTon");
        aliasMap.put("AirDryMetricTon", "airDryMetricTon");
        aliasMap.put("packageCount", "packageCount");
        aliasMap.put("PackageCount", "packageCount");
        aliasMap.put("airDryPct", "airDryPct");
        aliasMap.put("AirDryPct", "airDryPct");
        aliasMap.put("_F_B_0_", "_F_B_0_");
        aliasMap.put("_F_B_0_", "_F_B_0_");
        aliasMap.put("_F_I_0_", "_F_I_0_");
        aliasMap.put("_F_I_0_", "_F_I_0_");
        aliasMap.put("_F_L_0_", "_F_L_0_");
        aliasMap.put("_F_L_0_", "_F_L_0_");
        aliasMap.put("_F_DT_0_", "_F_DT_0_");
        aliasMap.put("_F_DT_0_", "_F_DT_0_");
        aliasMap.put("_F_N_0_", "_F_N_0_");
        aliasMap.put("_F_N_0_", "_F_N_0_");
        aliasMap.put("_F_C5_0_", "_F_C5_0_");
        aliasMap.put("_F_C5_0_", "_F_C5_0_");
        aliasMap.put("_F_C10_0_", "_F_C10_0_");
        aliasMap.put("_F_C10_0_", "_F_C10_0_");
        aliasMap.put("_F_C20_0_", "_F_C20_0_");
        aliasMap.put("_F_C20_0_", "_F_C20_0_");
        aliasMap.put("_F_C50_0_", "_F_C50_0_");
        aliasMap.put("_F_C50_0_", "_F_C50_0_");
        aliasMap.put("_F_C100_0_", "_F_C100_0_");
        aliasMap.put("_F_C100_0_", "_F_C100_0_");
        aliasMap.put("_F_C200_0_", "_F_C200_0_");
        aliasMap.put("_F_C200_0_", "_F_C200_0_");
        aliasMap.put("_F_C500_0_", "_F_C500_0_");
        aliasMap.put("_F_C500_0_", "_F_C500_0_");
        aliasMap.put("_F_C1000_0_", "_F_C1000_0_");
        aliasMap.put("_F_C1000_0_", "_F_C1000_0_");
        aliasMap.put("_F_B_1_", "_F_B_1_");
        aliasMap.put("_F_B_1_", "_F_B_1_");
        aliasMap.put("_F_I_1_", "_F_I_1_");
        aliasMap.put("_F_I_1_", "_F_I_1_");
        aliasMap.put("_F_L_1_", "_F_L_1_");
        aliasMap.put("_F_L_1_", "_F_L_1_");
        aliasMap.put("_F_DT_1_", "_F_DT_1_");
        aliasMap.put("_F_DT_1_", "_F_DT_1_");
        aliasMap.put("_F_N_1_", "_F_N_1_");
        aliasMap.put("_F_N_1_", "_F_N_1_");
        aliasMap.put("_F_C5_1_", "_F_C5_1_");
        aliasMap.put("_F_C5_1_", "_F_C5_1_");
        aliasMap.put("_F_C10_1_", "_F_C10_1_");
        aliasMap.put("_F_C10_1_", "_F_C10_1_");
        aliasMap.put("_F_C20_1_", "_F_C20_1_");
        aliasMap.put("_F_C20_1_", "_F_C20_1_");
        aliasMap.put("_F_C50_1_", "_F_C50_1_");
        aliasMap.put("_F_C50_1_", "_F_C50_1_");
        aliasMap.put("_F_C100_1_", "_F_C100_1_");
        aliasMap.put("_F_C100_1_", "_F_C100_1_");
        aliasMap.put("_F_C200_1_", "_F_C200_1_");
        aliasMap.put("_F_C200_1_", "_F_C200_1_");
        aliasMap.put("_F_B_2_", "_F_B_2_");
        aliasMap.put("_F_B_2_", "_F_B_2_");
        aliasMap.put("_F_I_2_", "_F_I_2_");
        aliasMap.put("_F_I_2_", "_F_I_2_");
        aliasMap.put("_F_L_2_", "_F_L_2_");
        aliasMap.put("_F_L_2_", "_F_L_2_");
        aliasMap.put("_F_DT_2_", "_F_DT_2_");
        aliasMap.put("_F_DT_2_", "_F_DT_2_");
        aliasMap.put("_F_N_2_", "_F_N_2_");
        aliasMap.put("_F_N_2_", "_F_N_2_");
        aliasMap.put("_F_C5_2_", "_F_C5_2_");
        aliasMap.put("_F_C5_2_", "_F_C5_2_");
        aliasMap.put("_F_C10_2_", "_F_C10_2_");
        aliasMap.put("_F_C10_2_", "_F_C10_2_");
        aliasMap.put("_F_C20_2_", "_F_C20_2_");
        aliasMap.put("_F_C20_2_", "_F_C20_2_");
        aliasMap.put("_F_C50_2_", "_F_C50_2_");
        aliasMap.put("_F_C50_2_", "_F_C50_2_");
        aliasMap.put("_F_B_3_", "_F_B_3_");
        aliasMap.put("_F_B_3_", "_F_B_3_");
        aliasMap.put("_F_I_3_", "_F_I_3_");
        aliasMap.put("_F_I_3_", "_F_I_3_");
        aliasMap.put("_F_L_3_", "_F_L_3_");
        aliasMap.put("_F_L_3_", "_F_L_3_");
        aliasMap.put("_F_DT_3_", "_F_DT_3_");
        aliasMap.put("_F_DT_3_", "_F_DT_3_");
        aliasMap.put("_F_N_3_", "_F_N_3_");
        aliasMap.put("_F_N_3_", "_F_N_3_");
        aliasMap.put("_F_C5_3_", "_F_C5_3_");
        aliasMap.put("_F_C5_3_", "_F_C5_3_");
        aliasMap.put("_F_C10_3_", "_F_C10_3_");
        aliasMap.put("_F_C10_3_", "_F_C10_3_");
        aliasMap.put("_F_C20_3_", "_F_C20_3_");
        aliasMap.put("_F_C20_3_", "_F_C20_3_");
        aliasMap.put("_F_C50_3_", "_F_C50_3_");
        aliasMap.put("_F_C50_3_", "_F_C50_3_");
        aliasMap.put("_F_B_4_", "_F_B_4_");
        aliasMap.put("_F_B_4_", "_F_B_4_");
        aliasMap.put("_F_I_4_", "_F_I_4_");
        aliasMap.put("_F_I_4_", "_F_I_4_");
        aliasMap.put("_F_L_4_", "_F_L_4_");
        aliasMap.put("_F_L_4_", "_F_L_4_");
        aliasMap.put("_F_DT_4_", "_F_DT_4_");
        aliasMap.put("_F_DT_4_", "_F_DT_4_");
        aliasMap.put("_F_N_4_", "_F_N_4_");
        aliasMap.put("_F_N_4_", "_F_N_4_");
        aliasMap.put("_F_C5_4_", "_F_C5_4_");
        aliasMap.put("_F_C5_4_", "_F_C5_4_");
        aliasMap.put("_F_C10_4_", "_F_C10_4_");
        aliasMap.put("_F_C10_4_", "_F_C10_4_");
        aliasMap.put("_F_C20_4_", "_F_C20_4_");
        aliasMap.put("_F_C20_4_", "_F_C20_4_");
        aliasMap.put("_F_C50_4_", "_F_C50_4_");
        aliasMap.put("_F_C50_4_", "_F_C50_4_");
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

