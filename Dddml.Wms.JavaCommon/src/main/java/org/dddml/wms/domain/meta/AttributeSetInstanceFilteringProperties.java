package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeSetInstanceFilteringProperties
{

    private AttributeSetInstanceFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "attributeSetInstanceId",
            "attributeSetId",
            "organizationId",
            "referenceId",
            "serialNumber",
            "lot",
            "description",
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
            "_F_C500_1_",
            "_F_C1000_1_",
            "_F_B_2_",
            "_F_I_2_",
            "_F_L_2_",
            "_F_DT_2_",
            "_F_N_2_",
            "_F_C5_2_",
            "_F_C10_2_",
            "_F_C20_2_",
            "_F_C50_2_",
            "_F_C100_2_",
            "_F_C200_2_",
            "_F_C500_2_",
            "_F_C1000_2_",
            "_F_B_3_",
            "_F_I_3_",
            "_F_L_3_",
            "_F_DT_3_",
            "_F_N_3_",
            "_F_C5_3_",
            "_F_C10_3_",
            "_F_C20_3_",
            "_F_C50_3_",
            "_F_C100_3_",
            "_F_C200_3_",
            "_F_C500_3_",
            "_F_C1000_3_",
            "_F_B_4_",
            "_F_I_4_",
            "_F_L_4_",
            "_F_DT_4_",
            "_F_N_4_",
            "_F_C5_4_",
            "_F_C10_4_",
            "_F_C20_4_",
            "_F_C50_4_",
            "_F_C100_4_",
            "_F_C200_4_",
            "_F_C500_4_",
            "_F_C1000_4_",
            "_F_B_5_",
            "_F_I_5_",
            "_F_L_5_",
            "_F_DT_5_",
            "_F_N_5_",
            "_F_C5_5_",
            "_F_C10_5_",
            "_F_C20_5_",
            "_F_C50_5_",
            "_F_C100_5_",
            "_F_C200_5_",
            "_F_C500_5_",
            "_F_B_6_",
            "_F_I_6_",
            "_F_L_6_",
            "_F_DT_6_",
            "_F_N_6_",
            "_F_C5_6_",
            "_F_C10_6_",
            "_F_C20_6_",
            "_F_C50_6_",
            "_F_C100_6_",
            "_F_C200_6_",
            "_F_C500_6_",
            "_F_B_7_",
            "_F_I_7_",
            "_F_L_7_",
            "_F_DT_7_",
            "_F_N_7_",
            "_F_C5_7_",
            "_F_C10_7_",
            "_F_C20_7_",
            "_F_C50_7_",
            "_F_C100_7_",
            "_F_C200_7_",
            "_F_C500_7_",
            "_F_B_8_",
            "_F_I_8_",
            "_F_L_8_",
            "_F_DT_8_",
            "_F_N_8_",
            "_F_C5_8_",
            "_F_C10_8_",
            "_F_C20_8_",
            "_F_C50_8_",
            "_F_C100_8_",
            "_F_C200_8_",
            "_F_C500_8_",
            "_F_B_9_",
            "_F_I_9_",
            "_F_L_9_",
            "_F_DT_9_",
            "_F_N_9_",
            "_F_C5_9_",
            "_F_C10_9_",
            "_F_C20_9_",
            "_F_C50_9_",
            "_F_C100_9_",
            "_F_C200_9_",
            "_F_C500_9_",
            "_F_B_10_",
            "_F_I_10_",
            "_F_L_10_",
            "_F_DT_10_",
            "_F_N_10_",
            "_F_C5_10_",
            "_F_C10_10_",
            "_F_C20_10_",
            "_F_C50_10_",
            "_F_C100_10_",
            "_F_C200_10_",
            "_F_B_11_",
            "_F_I_11_",
            "_F_L_11_",
            "_F_DT_11_",
            "_F_N_11_",
            "_F_C5_11_",
            "_F_C10_11_",
            "_F_C20_11_",
            "_F_C50_11_",
            "_F_C100_11_",
            "_F_C200_11_",
            "_F_B_12_",
            "_F_I_12_",
            "_F_L_12_",
            "_F_DT_12_",
            "_F_N_12_",
            "_F_C5_12_",
            "_F_C10_12_",
            "_F_C20_12_",
            "_F_C50_12_",
            "_F_C100_12_",
            "_F_C200_12_",
            "_F_B_13_",
            "_F_I_13_",
            "_F_L_13_",
            "_F_DT_13_",
            "_F_N_13_",
            "_F_C5_13_",
            "_F_C10_13_",
            "_F_C20_13_",
            "_F_C50_13_",
            "_F_C100_13_",
            "_F_C200_13_",
            "_F_B_14_",
            "_F_I_14_",
            "_F_L_14_",
            "_F_DT_14_",
            "_F_N_14_",
            "_F_C5_14_",
            "_F_C10_14_",
            "_F_C20_14_",
            "_F_C50_14_",
            "_F_C100_14_",
            "_F_C200_14_",
            "_F_B_15_",
            "_F_I_15_",
            "_F_L_15_",
            "_F_DT_15_",
            "_F_N_15_",
            "_F_C5_15_",
            "_F_C10_15_",
            "_F_C20_15_",
            "_F_C50_15_",
            "_F_C100_15_",
            "_F_C200_15_",
            "_F_B_16_",
            "_F_I_16_",
            "_F_L_16_",
            "_F_DT_16_",
            "_F_N_16_",
            "_F_C5_16_",
            "_F_C10_16_",
            "_F_C20_16_",
            "_F_C50_16_",
            "_F_C100_16_",
            "_F_C200_16_",
            "_F_B_17_",
            "_F_I_17_",
            "_F_L_17_",
            "_F_DT_17_",
            "_F_N_17_",
            "_F_C5_17_",
            "_F_C10_17_",
            "_F_C20_17_",
            "_F_C50_17_",
            "_F_C100_17_",
            "_F_C200_17_",
            "_F_B_18_",
            "_F_I_18_",
            "_F_L_18_",
            "_F_DT_18_",
            "_F_N_18_",
            "_F_C5_18_",
            "_F_C10_18_",
            "_F_C20_18_",
            "_F_C50_18_",
            "_F_C100_18_",
            "_F_C200_18_",
            "_F_B_19_",
            "_F_I_19_",
            "_F_L_19_",
            "_F_DT_19_",
            "_F_N_19_",
            "_F_C5_19_",
            "_F_C10_19_",
            "_F_C20_19_",
            "_F_C50_19_",
            "_F_C100_19_",
            "_F_C200_19_",
            "_F_B_20_",
            "_F_I_20_",
            "_F_L_20_",
            "_F_N_20_",
            "_F_C5_20_",
            "_F_C10_20_",
            "_F_C20_20_",
            "_F_C50_20_",
            "_F_B_21_",
            "_F_I_21_",
            "_F_L_21_",
            "_F_N_21_",
            "_F_C5_21_",
            "_F_C10_21_",
            "_F_C20_21_",
            "_F_C50_21_",
            "_F_B_22_",
            "_F_I_22_",
            "_F_L_22_",
            "_F_N_22_",
            "_F_C5_22_",
            "_F_C10_22_",
            "_F_C20_22_",
            "_F_C50_22_",
            "_F_B_23_",
            "_F_I_23_",
            "_F_L_23_",
            "_F_N_23_",
            "_F_C5_23_",
            "_F_C10_23_",
            "_F_C20_23_",
            "_F_C50_23_",
            "_F_B_24_",
            "_F_I_24_",
            "_F_L_24_",
            "_F_N_24_",
            "_F_C5_24_",
            "_F_C10_24_",
            "_F_C20_24_",
            "_F_C50_24_",
            "_F_B_25_",
            "_F_I_25_",
            "_F_L_25_",
            "_F_N_25_",
            "_F_C5_25_",
            "_F_C10_25_",
            "_F_C20_25_",
            "_F_C50_25_",
            "_F_B_26_",
            "_F_I_26_",
            "_F_L_26_",
            "_F_N_26_",
            "_F_C5_26_",
            "_F_C10_26_",
            "_F_C20_26_",
            "_F_C50_26_",
            "_F_B_27_",
            "_F_I_27_",
            "_F_L_27_",
            "_F_N_27_",
            "_F_C5_27_",
            "_F_C10_27_",
            "_F_C20_27_",
            "_F_C50_27_",
            "_F_B_28_",
            "_F_I_28_",
            "_F_L_28_",
            "_F_N_28_",
            "_F_C5_28_",
            "_F_C10_28_",
            "_F_C20_28_",
            "_F_C50_28_",
            "_F_B_29_",
            "_F_I_29_",
            "_F_L_29_",
            "_F_N_29_",
            "_F_C5_29_",
            "_F_C10_29_",
            "_F_C20_29_",
            "_F_C50_29_",
            "_F_B_30_",
            "_F_I_30_",
            "_F_N_30_",
            "_F_C5_30_",
            "_F_C10_30_",
            "_F_C20_30_",
            "_F_C50_30_",
            "_F_B_31_",
            "_F_I_31_",
            "_F_N_31_",
            "_F_C5_31_",
            "_F_C10_31_",
            "_F_C20_31_",
            "_F_C50_31_",
            "_F_B_32_",
            "_F_I_32_",
            "_F_N_32_",
            "_F_C5_32_",
            "_F_C10_32_",
            "_F_C20_32_",
            "_F_C50_32_",
            "_F_B_33_",
            "_F_I_33_",
            "_F_N_33_",
            "_F_C5_33_",
            "_F_C10_33_",
            "_F_C20_33_",
            "_F_C50_33_",
            "_F_B_34_",
            "_F_I_34_",
            "_F_N_34_",
            "_F_C5_34_",
            "_F_C10_34_",
            "_F_C20_34_",
            "_F_C50_34_",
            "_F_B_35_",
            "_F_I_35_",
            "_F_N_35_",
            "_F_C5_35_",
            "_F_C10_35_",
            "_F_C20_35_",
            "_F_C50_35_",
            "_F_B_36_",
            "_F_I_36_",
            "_F_N_36_",
            "_F_C5_36_",
            "_F_C10_36_",
            "_F_C20_36_",
            "_F_C50_36_",
            "_F_B_37_",
            "_F_I_37_",
            "_F_N_37_",
            "_F_C5_37_",
            "_F_C10_37_",
            "_F_C20_37_",
            "_F_C50_37_",
            "_F_B_38_",
            "_F_I_38_",
            "_F_N_38_",
            "_F_C5_38_",
            "_F_C10_38_",
            "_F_C20_38_",
            "_F_C50_38_",
            "_F_B_39_",
            "_F_I_39_",
            "_F_N_39_",
            "_F_C5_39_",
            "_F_C10_39_",
            "_F_C20_39_",
            "_F_C50_39_",
            "_F_B_40_",
            "_F_I_40_",
            "_F_N_40_",
            "_F_C5_40_",
            "_F_C10_40_",
            "_F_C20_40_",
            "_F_C50_40_",
            "_F_B_41_",
            "_F_I_41_",
            "_F_N_41_",
            "_F_C5_41_",
            "_F_C10_41_",
            "_F_C20_41_",
            "_F_C50_41_",
            "_F_B_42_",
            "_F_I_42_",
            "_F_N_42_",
            "_F_C5_42_",
            "_F_C10_42_",
            "_F_C20_42_",
            "_F_C50_42_",
            "_F_B_43_",
            "_F_I_43_",
            "_F_N_43_",
            "_F_C5_43_",
            "_F_C10_43_",
            "_F_C20_43_",
            "_F_C50_43_",
            "_F_B_44_",
            "_F_I_44_",
            "_F_N_44_",
            "_F_C5_44_",
            "_F_C10_44_",
            "_F_C20_44_",
            "_F_C50_44_",
            "_F_B_45_",
            "_F_I_45_",
            "_F_N_45_",
            "_F_C5_45_",
            "_F_C10_45_",
            "_F_C20_45_",
            "_F_C50_45_",
            "_F_B_46_",
            "_F_I_46_",
            "_F_N_46_",
            "_F_C5_46_",
            "_F_C10_46_",
            "_F_C20_46_",
            "_F_C50_46_",
            "_F_B_47_",
            "_F_I_47_",
            "_F_N_47_",
            "_F_C5_47_",
            "_F_C10_47_",
            "_F_C20_47_",
            "_F_C50_47_",
            "_F_B_48_",
            "_F_I_48_",
            "_F_N_48_",
            "_F_C5_48_",
            "_F_C10_48_",
            "_F_C20_48_",
            "_F_C50_48_",
            "_F_B_49_",
            "_F_I_49_",
            "_F_N_49_",
            "_F_C5_49_",
            "_F_C10_49_",
            "_F_C20_49_",
            "_F_C50_49_",
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
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "Long",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Integer",
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
        aliasMap.put("lot", "lot");
        aliasMap.put("Lot", "lot");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
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
        aliasMap.put("_F_C500_1_", "_F_C500_1_");
        aliasMap.put("_F_C500_1_", "_F_C500_1_");
        aliasMap.put("_F_C1000_1_", "_F_C1000_1_");
        aliasMap.put("_F_C1000_1_", "_F_C1000_1_");
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
        aliasMap.put("_F_C100_2_", "_F_C100_2_");
        aliasMap.put("_F_C100_2_", "_F_C100_2_");
        aliasMap.put("_F_C200_2_", "_F_C200_2_");
        aliasMap.put("_F_C200_2_", "_F_C200_2_");
        aliasMap.put("_F_C500_2_", "_F_C500_2_");
        aliasMap.put("_F_C500_2_", "_F_C500_2_");
        aliasMap.put("_F_C1000_2_", "_F_C1000_2_");
        aliasMap.put("_F_C1000_2_", "_F_C1000_2_");
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
        aliasMap.put("_F_C100_3_", "_F_C100_3_");
        aliasMap.put("_F_C100_3_", "_F_C100_3_");
        aliasMap.put("_F_C200_3_", "_F_C200_3_");
        aliasMap.put("_F_C200_3_", "_F_C200_3_");
        aliasMap.put("_F_C500_3_", "_F_C500_3_");
        aliasMap.put("_F_C500_3_", "_F_C500_3_");
        aliasMap.put("_F_C1000_3_", "_F_C1000_3_");
        aliasMap.put("_F_C1000_3_", "_F_C1000_3_");
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
        aliasMap.put("_F_C100_4_", "_F_C100_4_");
        aliasMap.put("_F_C100_4_", "_F_C100_4_");
        aliasMap.put("_F_C200_4_", "_F_C200_4_");
        aliasMap.put("_F_C200_4_", "_F_C200_4_");
        aliasMap.put("_F_C500_4_", "_F_C500_4_");
        aliasMap.put("_F_C500_4_", "_F_C500_4_");
        aliasMap.put("_F_C1000_4_", "_F_C1000_4_");
        aliasMap.put("_F_C1000_4_", "_F_C1000_4_");
        aliasMap.put("_F_B_5_", "_F_B_5_");
        aliasMap.put("_F_B_5_", "_F_B_5_");
        aliasMap.put("_F_I_5_", "_F_I_5_");
        aliasMap.put("_F_I_5_", "_F_I_5_");
        aliasMap.put("_F_L_5_", "_F_L_5_");
        aliasMap.put("_F_L_5_", "_F_L_5_");
        aliasMap.put("_F_DT_5_", "_F_DT_5_");
        aliasMap.put("_F_DT_5_", "_F_DT_5_");
        aliasMap.put("_F_N_5_", "_F_N_5_");
        aliasMap.put("_F_N_5_", "_F_N_5_");
        aliasMap.put("_F_C5_5_", "_F_C5_5_");
        aliasMap.put("_F_C5_5_", "_F_C5_5_");
        aliasMap.put("_F_C10_5_", "_F_C10_5_");
        aliasMap.put("_F_C10_5_", "_F_C10_5_");
        aliasMap.put("_F_C20_5_", "_F_C20_5_");
        aliasMap.put("_F_C20_5_", "_F_C20_5_");
        aliasMap.put("_F_C50_5_", "_F_C50_5_");
        aliasMap.put("_F_C50_5_", "_F_C50_5_");
        aliasMap.put("_F_C100_5_", "_F_C100_5_");
        aliasMap.put("_F_C100_5_", "_F_C100_5_");
        aliasMap.put("_F_C200_5_", "_F_C200_5_");
        aliasMap.put("_F_C200_5_", "_F_C200_5_");
        aliasMap.put("_F_C500_5_", "_F_C500_5_");
        aliasMap.put("_F_C500_5_", "_F_C500_5_");
        aliasMap.put("_F_B_6_", "_F_B_6_");
        aliasMap.put("_F_B_6_", "_F_B_6_");
        aliasMap.put("_F_I_6_", "_F_I_6_");
        aliasMap.put("_F_I_6_", "_F_I_6_");
        aliasMap.put("_F_L_6_", "_F_L_6_");
        aliasMap.put("_F_L_6_", "_F_L_6_");
        aliasMap.put("_F_DT_6_", "_F_DT_6_");
        aliasMap.put("_F_DT_6_", "_F_DT_6_");
        aliasMap.put("_F_N_6_", "_F_N_6_");
        aliasMap.put("_F_N_6_", "_F_N_6_");
        aliasMap.put("_F_C5_6_", "_F_C5_6_");
        aliasMap.put("_F_C5_6_", "_F_C5_6_");
        aliasMap.put("_F_C10_6_", "_F_C10_6_");
        aliasMap.put("_F_C10_6_", "_F_C10_6_");
        aliasMap.put("_F_C20_6_", "_F_C20_6_");
        aliasMap.put("_F_C20_6_", "_F_C20_6_");
        aliasMap.put("_F_C50_6_", "_F_C50_6_");
        aliasMap.put("_F_C50_6_", "_F_C50_6_");
        aliasMap.put("_F_C100_6_", "_F_C100_6_");
        aliasMap.put("_F_C100_6_", "_F_C100_6_");
        aliasMap.put("_F_C200_6_", "_F_C200_6_");
        aliasMap.put("_F_C200_6_", "_F_C200_6_");
        aliasMap.put("_F_C500_6_", "_F_C500_6_");
        aliasMap.put("_F_C500_6_", "_F_C500_6_");
        aliasMap.put("_F_B_7_", "_F_B_7_");
        aliasMap.put("_F_B_7_", "_F_B_7_");
        aliasMap.put("_F_I_7_", "_F_I_7_");
        aliasMap.put("_F_I_7_", "_F_I_7_");
        aliasMap.put("_F_L_7_", "_F_L_7_");
        aliasMap.put("_F_L_7_", "_F_L_7_");
        aliasMap.put("_F_DT_7_", "_F_DT_7_");
        aliasMap.put("_F_DT_7_", "_F_DT_7_");
        aliasMap.put("_F_N_7_", "_F_N_7_");
        aliasMap.put("_F_N_7_", "_F_N_7_");
        aliasMap.put("_F_C5_7_", "_F_C5_7_");
        aliasMap.put("_F_C5_7_", "_F_C5_7_");
        aliasMap.put("_F_C10_7_", "_F_C10_7_");
        aliasMap.put("_F_C10_7_", "_F_C10_7_");
        aliasMap.put("_F_C20_7_", "_F_C20_7_");
        aliasMap.put("_F_C20_7_", "_F_C20_7_");
        aliasMap.put("_F_C50_7_", "_F_C50_7_");
        aliasMap.put("_F_C50_7_", "_F_C50_7_");
        aliasMap.put("_F_C100_7_", "_F_C100_7_");
        aliasMap.put("_F_C100_7_", "_F_C100_7_");
        aliasMap.put("_F_C200_7_", "_F_C200_7_");
        aliasMap.put("_F_C200_7_", "_F_C200_7_");
        aliasMap.put("_F_C500_7_", "_F_C500_7_");
        aliasMap.put("_F_C500_7_", "_F_C500_7_");
        aliasMap.put("_F_B_8_", "_F_B_8_");
        aliasMap.put("_F_B_8_", "_F_B_8_");
        aliasMap.put("_F_I_8_", "_F_I_8_");
        aliasMap.put("_F_I_8_", "_F_I_8_");
        aliasMap.put("_F_L_8_", "_F_L_8_");
        aliasMap.put("_F_L_8_", "_F_L_8_");
        aliasMap.put("_F_DT_8_", "_F_DT_8_");
        aliasMap.put("_F_DT_8_", "_F_DT_8_");
        aliasMap.put("_F_N_8_", "_F_N_8_");
        aliasMap.put("_F_N_8_", "_F_N_8_");
        aliasMap.put("_F_C5_8_", "_F_C5_8_");
        aliasMap.put("_F_C5_8_", "_F_C5_8_");
        aliasMap.put("_F_C10_8_", "_F_C10_8_");
        aliasMap.put("_F_C10_8_", "_F_C10_8_");
        aliasMap.put("_F_C20_8_", "_F_C20_8_");
        aliasMap.put("_F_C20_8_", "_F_C20_8_");
        aliasMap.put("_F_C50_8_", "_F_C50_8_");
        aliasMap.put("_F_C50_8_", "_F_C50_8_");
        aliasMap.put("_F_C100_8_", "_F_C100_8_");
        aliasMap.put("_F_C100_8_", "_F_C100_8_");
        aliasMap.put("_F_C200_8_", "_F_C200_8_");
        aliasMap.put("_F_C200_8_", "_F_C200_8_");
        aliasMap.put("_F_C500_8_", "_F_C500_8_");
        aliasMap.put("_F_C500_8_", "_F_C500_8_");
        aliasMap.put("_F_B_9_", "_F_B_9_");
        aliasMap.put("_F_B_9_", "_F_B_9_");
        aliasMap.put("_F_I_9_", "_F_I_9_");
        aliasMap.put("_F_I_9_", "_F_I_9_");
        aliasMap.put("_F_L_9_", "_F_L_9_");
        aliasMap.put("_F_L_9_", "_F_L_9_");
        aliasMap.put("_F_DT_9_", "_F_DT_9_");
        aliasMap.put("_F_DT_9_", "_F_DT_9_");
        aliasMap.put("_F_N_9_", "_F_N_9_");
        aliasMap.put("_F_N_9_", "_F_N_9_");
        aliasMap.put("_F_C5_9_", "_F_C5_9_");
        aliasMap.put("_F_C5_9_", "_F_C5_9_");
        aliasMap.put("_F_C10_9_", "_F_C10_9_");
        aliasMap.put("_F_C10_9_", "_F_C10_9_");
        aliasMap.put("_F_C20_9_", "_F_C20_9_");
        aliasMap.put("_F_C20_9_", "_F_C20_9_");
        aliasMap.put("_F_C50_9_", "_F_C50_9_");
        aliasMap.put("_F_C50_9_", "_F_C50_9_");
        aliasMap.put("_F_C100_9_", "_F_C100_9_");
        aliasMap.put("_F_C100_9_", "_F_C100_9_");
        aliasMap.put("_F_C200_9_", "_F_C200_9_");
        aliasMap.put("_F_C200_9_", "_F_C200_9_");
        aliasMap.put("_F_C500_9_", "_F_C500_9_");
        aliasMap.put("_F_C500_9_", "_F_C500_9_");
        aliasMap.put("_F_B_10_", "_F_B_10_");
        aliasMap.put("_F_B_10_", "_F_B_10_");
        aliasMap.put("_F_I_10_", "_F_I_10_");
        aliasMap.put("_F_I_10_", "_F_I_10_");
        aliasMap.put("_F_L_10_", "_F_L_10_");
        aliasMap.put("_F_L_10_", "_F_L_10_");
        aliasMap.put("_F_DT_10_", "_F_DT_10_");
        aliasMap.put("_F_DT_10_", "_F_DT_10_");
        aliasMap.put("_F_N_10_", "_F_N_10_");
        aliasMap.put("_F_N_10_", "_F_N_10_");
        aliasMap.put("_F_C5_10_", "_F_C5_10_");
        aliasMap.put("_F_C5_10_", "_F_C5_10_");
        aliasMap.put("_F_C10_10_", "_F_C10_10_");
        aliasMap.put("_F_C10_10_", "_F_C10_10_");
        aliasMap.put("_F_C20_10_", "_F_C20_10_");
        aliasMap.put("_F_C20_10_", "_F_C20_10_");
        aliasMap.put("_F_C50_10_", "_F_C50_10_");
        aliasMap.put("_F_C50_10_", "_F_C50_10_");
        aliasMap.put("_F_C100_10_", "_F_C100_10_");
        aliasMap.put("_F_C100_10_", "_F_C100_10_");
        aliasMap.put("_F_C200_10_", "_F_C200_10_");
        aliasMap.put("_F_C200_10_", "_F_C200_10_");
        aliasMap.put("_F_B_11_", "_F_B_11_");
        aliasMap.put("_F_B_11_", "_F_B_11_");
        aliasMap.put("_F_I_11_", "_F_I_11_");
        aliasMap.put("_F_I_11_", "_F_I_11_");
        aliasMap.put("_F_L_11_", "_F_L_11_");
        aliasMap.put("_F_L_11_", "_F_L_11_");
        aliasMap.put("_F_DT_11_", "_F_DT_11_");
        aliasMap.put("_F_DT_11_", "_F_DT_11_");
        aliasMap.put("_F_N_11_", "_F_N_11_");
        aliasMap.put("_F_N_11_", "_F_N_11_");
        aliasMap.put("_F_C5_11_", "_F_C5_11_");
        aliasMap.put("_F_C5_11_", "_F_C5_11_");
        aliasMap.put("_F_C10_11_", "_F_C10_11_");
        aliasMap.put("_F_C10_11_", "_F_C10_11_");
        aliasMap.put("_F_C20_11_", "_F_C20_11_");
        aliasMap.put("_F_C20_11_", "_F_C20_11_");
        aliasMap.put("_F_C50_11_", "_F_C50_11_");
        aliasMap.put("_F_C50_11_", "_F_C50_11_");
        aliasMap.put("_F_C100_11_", "_F_C100_11_");
        aliasMap.put("_F_C100_11_", "_F_C100_11_");
        aliasMap.put("_F_C200_11_", "_F_C200_11_");
        aliasMap.put("_F_C200_11_", "_F_C200_11_");
        aliasMap.put("_F_B_12_", "_F_B_12_");
        aliasMap.put("_F_B_12_", "_F_B_12_");
        aliasMap.put("_F_I_12_", "_F_I_12_");
        aliasMap.put("_F_I_12_", "_F_I_12_");
        aliasMap.put("_F_L_12_", "_F_L_12_");
        aliasMap.put("_F_L_12_", "_F_L_12_");
        aliasMap.put("_F_DT_12_", "_F_DT_12_");
        aliasMap.put("_F_DT_12_", "_F_DT_12_");
        aliasMap.put("_F_N_12_", "_F_N_12_");
        aliasMap.put("_F_N_12_", "_F_N_12_");
        aliasMap.put("_F_C5_12_", "_F_C5_12_");
        aliasMap.put("_F_C5_12_", "_F_C5_12_");
        aliasMap.put("_F_C10_12_", "_F_C10_12_");
        aliasMap.put("_F_C10_12_", "_F_C10_12_");
        aliasMap.put("_F_C20_12_", "_F_C20_12_");
        aliasMap.put("_F_C20_12_", "_F_C20_12_");
        aliasMap.put("_F_C50_12_", "_F_C50_12_");
        aliasMap.put("_F_C50_12_", "_F_C50_12_");
        aliasMap.put("_F_C100_12_", "_F_C100_12_");
        aliasMap.put("_F_C100_12_", "_F_C100_12_");
        aliasMap.put("_F_C200_12_", "_F_C200_12_");
        aliasMap.put("_F_C200_12_", "_F_C200_12_");
        aliasMap.put("_F_B_13_", "_F_B_13_");
        aliasMap.put("_F_B_13_", "_F_B_13_");
        aliasMap.put("_F_I_13_", "_F_I_13_");
        aliasMap.put("_F_I_13_", "_F_I_13_");
        aliasMap.put("_F_L_13_", "_F_L_13_");
        aliasMap.put("_F_L_13_", "_F_L_13_");
        aliasMap.put("_F_DT_13_", "_F_DT_13_");
        aliasMap.put("_F_DT_13_", "_F_DT_13_");
        aliasMap.put("_F_N_13_", "_F_N_13_");
        aliasMap.put("_F_N_13_", "_F_N_13_");
        aliasMap.put("_F_C5_13_", "_F_C5_13_");
        aliasMap.put("_F_C5_13_", "_F_C5_13_");
        aliasMap.put("_F_C10_13_", "_F_C10_13_");
        aliasMap.put("_F_C10_13_", "_F_C10_13_");
        aliasMap.put("_F_C20_13_", "_F_C20_13_");
        aliasMap.put("_F_C20_13_", "_F_C20_13_");
        aliasMap.put("_F_C50_13_", "_F_C50_13_");
        aliasMap.put("_F_C50_13_", "_F_C50_13_");
        aliasMap.put("_F_C100_13_", "_F_C100_13_");
        aliasMap.put("_F_C100_13_", "_F_C100_13_");
        aliasMap.put("_F_C200_13_", "_F_C200_13_");
        aliasMap.put("_F_C200_13_", "_F_C200_13_");
        aliasMap.put("_F_B_14_", "_F_B_14_");
        aliasMap.put("_F_B_14_", "_F_B_14_");
        aliasMap.put("_F_I_14_", "_F_I_14_");
        aliasMap.put("_F_I_14_", "_F_I_14_");
        aliasMap.put("_F_L_14_", "_F_L_14_");
        aliasMap.put("_F_L_14_", "_F_L_14_");
        aliasMap.put("_F_DT_14_", "_F_DT_14_");
        aliasMap.put("_F_DT_14_", "_F_DT_14_");
        aliasMap.put("_F_N_14_", "_F_N_14_");
        aliasMap.put("_F_N_14_", "_F_N_14_");
        aliasMap.put("_F_C5_14_", "_F_C5_14_");
        aliasMap.put("_F_C5_14_", "_F_C5_14_");
        aliasMap.put("_F_C10_14_", "_F_C10_14_");
        aliasMap.put("_F_C10_14_", "_F_C10_14_");
        aliasMap.put("_F_C20_14_", "_F_C20_14_");
        aliasMap.put("_F_C20_14_", "_F_C20_14_");
        aliasMap.put("_F_C50_14_", "_F_C50_14_");
        aliasMap.put("_F_C50_14_", "_F_C50_14_");
        aliasMap.put("_F_C100_14_", "_F_C100_14_");
        aliasMap.put("_F_C100_14_", "_F_C100_14_");
        aliasMap.put("_F_C200_14_", "_F_C200_14_");
        aliasMap.put("_F_C200_14_", "_F_C200_14_");
        aliasMap.put("_F_B_15_", "_F_B_15_");
        aliasMap.put("_F_B_15_", "_F_B_15_");
        aliasMap.put("_F_I_15_", "_F_I_15_");
        aliasMap.put("_F_I_15_", "_F_I_15_");
        aliasMap.put("_F_L_15_", "_F_L_15_");
        aliasMap.put("_F_L_15_", "_F_L_15_");
        aliasMap.put("_F_DT_15_", "_F_DT_15_");
        aliasMap.put("_F_DT_15_", "_F_DT_15_");
        aliasMap.put("_F_N_15_", "_F_N_15_");
        aliasMap.put("_F_N_15_", "_F_N_15_");
        aliasMap.put("_F_C5_15_", "_F_C5_15_");
        aliasMap.put("_F_C5_15_", "_F_C5_15_");
        aliasMap.put("_F_C10_15_", "_F_C10_15_");
        aliasMap.put("_F_C10_15_", "_F_C10_15_");
        aliasMap.put("_F_C20_15_", "_F_C20_15_");
        aliasMap.put("_F_C20_15_", "_F_C20_15_");
        aliasMap.put("_F_C50_15_", "_F_C50_15_");
        aliasMap.put("_F_C50_15_", "_F_C50_15_");
        aliasMap.put("_F_C100_15_", "_F_C100_15_");
        aliasMap.put("_F_C100_15_", "_F_C100_15_");
        aliasMap.put("_F_C200_15_", "_F_C200_15_");
        aliasMap.put("_F_C200_15_", "_F_C200_15_");
        aliasMap.put("_F_B_16_", "_F_B_16_");
        aliasMap.put("_F_B_16_", "_F_B_16_");
        aliasMap.put("_F_I_16_", "_F_I_16_");
        aliasMap.put("_F_I_16_", "_F_I_16_");
        aliasMap.put("_F_L_16_", "_F_L_16_");
        aliasMap.put("_F_L_16_", "_F_L_16_");
        aliasMap.put("_F_DT_16_", "_F_DT_16_");
        aliasMap.put("_F_DT_16_", "_F_DT_16_");
        aliasMap.put("_F_N_16_", "_F_N_16_");
        aliasMap.put("_F_N_16_", "_F_N_16_");
        aliasMap.put("_F_C5_16_", "_F_C5_16_");
        aliasMap.put("_F_C5_16_", "_F_C5_16_");
        aliasMap.put("_F_C10_16_", "_F_C10_16_");
        aliasMap.put("_F_C10_16_", "_F_C10_16_");
        aliasMap.put("_F_C20_16_", "_F_C20_16_");
        aliasMap.put("_F_C20_16_", "_F_C20_16_");
        aliasMap.put("_F_C50_16_", "_F_C50_16_");
        aliasMap.put("_F_C50_16_", "_F_C50_16_");
        aliasMap.put("_F_C100_16_", "_F_C100_16_");
        aliasMap.put("_F_C100_16_", "_F_C100_16_");
        aliasMap.put("_F_C200_16_", "_F_C200_16_");
        aliasMap.put("_F_C200_16_", "_F_C200_16_");
        aliasMap.put("_F_B_17_", "_F_B_17_");
        aliasMap.put("_F_B_17_", "_F_B_17_");
        aliasMap.put("_F_I_17_", "_F_I_17_");
        aliasMap.put("_F_I_17_", "_F_I_17_");
        aliasMap.put("_F_L_17_", "_F_L_17_");
        aliasMap.put("_F_L_17_", "_F_L_17_");
        aliasMap.put("_F_DT_17_", "_F_DT_17_");
        aliasMap.put("_F_DT_17_", "_F_DT_17_");
        aliasMap.put("_F_N_17_", "_F_N_17_");
        aliasMap.put("_F_N_17_", "_F_N_17_");
        aliasMap.put("_F_C5_17_", "_F_C5_17_");
        aliasMap.put("_F_C5_17_", "_F_C5_17_");
        aliasMap.put("_F_C10_17_", "_F_C10_17_");
        aliasMap.put("_F_C10_17_", "_F_C10_17_");
        aliasMap.put("_F_C20_17_", "_F_C20_17_");
        aliasMap.put("_F_C20_17_", "_F_C20_17_");
        aliasMap.put("_F_C50_17_", "_F_C50_17_");
        aliasMap.put("_F_C50_17_", "_F_C50_17_");
        aliasMap.put("_F_C100_17_", "_F_C100_17_");
        aliasMap.put("_F_C100_17_", "_F_C100_17_");
        aliasMap.put("_F_C200_17_", "_F_C200_17_");
        aliasMap.put("_F_C200_17_", "_F_C200_17_");
        aliasMap.put("_F_B_18_", "_F_B_18_");
        aliasMap.put("_F_B_18_", "_F_B_18_");
        aliasMap.put("_F_I_18_", "_F_I_18_");
        aliasMap.put("_F_I_18_", "_F_I_18_");
        aliasMap.put("_F_L_18_", "_F_L_18_");
        aliasMap.put("_F_L_18_", "_F_L_18_");
        aliasMap.put("_F_DT_18_", "_F_DT_18_");
        aliasMap.put("_F_DT_18_", "_F_DT_18_");
        aliasMap.put("_F_N_18_", "_F_N_18_");
        aliasMap.put("_F_N_18_", "_F_N_18_");
        aliasMap.put("_F_C5_18_", "_F_C5_18_");
        aliasMap.put("_F_C5_18_", "_F_C5_18_");
        aliasMap.put("_F_C10_18_", "_F_C10_18_");
        aliasMap.put("_F_C10_18_", "_F_C10_18_");
        aliasMap.put("_F_C20_18_", "_F_C20_18_");
        aliasMap.put("_F_C20_18_", "_F_C20_18_");
        aliasMap.put("_F_C50_18_", "_F_C50_18_");
        aliasMap.put("_F_C50_18_", "_F_C50_18_");
        aliasMap.put("_F_C100_18_", "_F_C100_18_");
        aliasMap.put("_F_C100_18_", "_F_C100_18_");
        aliasMap.put("_F_C200_18_", "_F_C200_18_");
        aliasMap.put("_F_C200_18_", "_F_C200_18_");
        aliasMap.put("_F_B_19_", "_F_B_19_");
        aliasMap.put("_F_B_19_", "_F_B_19_");
        aliasMap.put("_F_I_19_", "_F_I_19_");
        aliasMap.put("_F_I_19_", "_F_I_19_");
        aliasMap.put("_F_L_19_", "_F_L_19_");
        aliasMap.put("_F_L_19_", "_F_L_19_");
        aliasMap.put("_F_DT_19_", "_F_DT_19_");
        aliasMap.put("_F_DT_19_", "_F_DT_19_");
        aliasMap.put("_F_N_19_", "_F_N_19_");
        aliasMap.put("_F_N_19_", "_F_N_19_");
        aliasMap.put("_F_C5_19_", "_F_C5_19_");
        aliasMap.put("_F_C5_19_", "_F_C5_19_");
        aliasMap.put("_F_C10_19_", "_F_C10_19_");
        aliasMap.put("_F_C10_19_", "_F_C10_19_");
        aliasMap.put("_F_C20_19_", "_F_C20_19_");
        aliasMap.put("_F_C20_19_", "_F_C20_19_");
        aliasMap.put("_F_C50_19_", "_F_C50_19_");
        aliasMap.put("_F_C50_19_", "_F_C50_19_");
        aliasMap.put("_F_C100_19_", "_F_C100_19_");
        aliasMap.put("_F_C100_19_", "_F_C100_19_");
        aliasMap.put("_F_C200_19_", "_F_C200_19_");
        aliasMap.put("_F_C200_19_", "_F_C200_19_");
        aliasMap.put("_F_B_20_", "_F_B_20_");
        aliasMap.put("_F_B_20_", "_F_B_20_");
        aliasMap.put("_F_I_20_", "_F_I_20_");
        aliasMap.put("_F_I_20_", "_F_I_20_");
        aliasMap.put("_F_L_20_", "_F_L_20_");
        aliasMap.put("_F_L_20_", "_F_L_20_");
        aliasMap.put("_F_N_20_", "_F_N_20_");
        aliasMap.put("_F_N_20_", "_F_N_20_");
        aliasMap.put("_F_C5_20_", "_F_C5_20_");
        aliasMap.put("_F_C5_20_", "_F_C5_20_");
        aliasMap.put("_F_C10_20_", "_F_C10_20_");
        aliasMap.put("_F_C10_20_", "_F_C10_20_");
        aliasMap.put("_F_C20_20_", "_F_C20_20_");
        aliasMap.put("_F_C20_20_", "_F_C20_20_");
        aliasMap.put("_F_C50_20_", "_F_C50_20_");
        aliasMap.put("_F_C50_20_", "_F_C50_20_");
        aliasMap.put("_F_B_21_", "_F_B_21_");
        aliasMap.put("_F_B_21_", "_F_B_21_");
        aliasMap.put("_F_I_21_", "_F_I_21_");
        aliasMap.put("_F_I_21_", "_F_I_21_");
        aliasMap.put("_F_L_21_", "_F_L_21_");
        aliasMap.put("_F_L_21_", "_F_L_21_");
        aliasMap.put("_F_N_21_", "_F_N_21_");
        aliasMap.put("_F_N_21_", "_F_N_21_");
        aliasMap.put("_F_C5_21_", "_F_C5_21_");
        aliasMap.put("_F_C5_21_", "_F_C5_21_");
        aliasMap.put("_F_C10_21_", "_F_C10_21_");
        aliasMap.put("_F_C10_21_", "_F_C10_21_");
        aliasMap.put("_F_C20_21_", "_F_C20_21_");
        aliasMap.put("_F_C20_21_", "_F_C20_21_");
        aliasMap.put("_F_C50_21_", "_F_C50_21_");
        aliasMap.put("_F_C50_21_", "_F_C50_21_");
        aliasMap.put("_F_B_22_", "_F_B_22_");
        aliasMap.put("_F_B_22_", "_F_B_22_");
        aliasMap.put("_F_I_22_", "_F_I_22_");
        aliasMap.put("_F_I_22_", "_F_I_22_");
        aliasMap.put("_F_L_22_", "_F_L_22_");
        aliasMap.put("_F_L_22_", "_F_L_22_");
        aliasMap.put("_F_N_22_", "_F_N_22_");
        aliasMap.put("_F_N_22_", "_F_N_22_");
        aliasMap.put("_F_C5_22_", "_F_C5_22_");
        aliasMap.put("_F_C5_22_", "_F_C5_22_");
        aliasMap.put("_F_C10_22_", "_F_C10_22_");
        aliasMap.put("_F_C10_22_", "_F_C10_22_");
        aliasMap.put("_F_C20_22_", "_F_C20_22_");
        aliasMap.put("_F_C20_22_", "_F_C20_22_");
        aliasMap.put("_F_C50_22_", "_F_C50_22_");
        aliasMap.put("_F_C50_22_", "_F_C50_22_");
        aliasMap.put("_F_B_23_", "_F_B_23_");
        aliasMap.put("_F_B_23_", "_F_B_23_");
        aliasMap.put("_F_I_23_", "_F_I_23_");
        aliasMap.put("_F_I_23_", "_F_I_23_");
        aliasMap.put("_F_L_23_", "_F_L_23_");
        aliasMap.put("_F_L_23_", "_F_L_23_");
        aliasMap.put("_F_N_23_", "_F_N_23_");
        aliasMap.put("_F_N_23_", "_F_N_23_");
        aliasMap.put("_F_C5_23_", "_F_C5_23_");
        aliasMap.put("_F_C5_23_", "_F_C5_23_");
        aliasMap.put("_F_C10_23_", "_F_C10_23_");
        aliasMap.put("_F_C10_23_", "_F_C10_23_");
        aliasMap.put("_F_C20_23_", "_F_C20_23_");
        aliasMap.put("_F_C20_23_", "_F_C20_23_");
        aliasMap.put("_F_C50_23_", "_F_C50_23_");
        aliasMap.put("_F_C50_23_", "_F_C50_23_");
        aliasMap.put("_F_B_24_", "_F_B_24_");
        aliasMap.put("_F_B_24_", "_F_B_24_");
        aliasMap.put("_F_I_24_", "_F_I_24_");
        aliasMap.put("_F_I_24_", "_F_I_24_");
        aliasMap.put("_F_L_24_", "_F_L_24_");
        aliasMap.put("_F_L_24_", "_F_L_24_");
        aliasMap.put("_F_N_24_", "_F_N_24_");
        aliasMap.put("_F_N_24_", "_F_N_24_");
        aliasMap.put("_F_C5_24_", "_F_C5_24_");
        aliasMap.put("_F_C5_24_", "_F_C5_24_");
        aliasMap.put("_F_C10_24_", "_F_C10_24_");
        aliasMap.put("_F_C10_24_", "_F_C10_24_");
        aliasMap.put("_F_C20_24_", "_F_C20_24_");
        aliasMap.put("_F_C20_24_", "_F_C20_24_");
        aliasMap.put("_F_C50_24_", "_F_C50_24_");
        aliasMap.put("_F_C50_24_", "_F_C50_24_");
        aliasMap.put("_F_B_25_", "_F_B_25_");
        aliasMap.put("_F_B_25_", "_F_B_25_");
        aliasMap.put("_F_I_25_", "_F_I_25_");
        aliasMap.put("_F_I_25_", "_F_I_25_");
        aliasMap.put("_F_L_25_", "_F_L_25_");
        aliasMap.put("_F_L_25_", "_F_L_25_");
        aliasMap.put("_F_N_25_", "_F_N_25_");
        aliasMap.put("_F_N_25_", "_F_N_25_");
        aliasMap.put("_F_C5_25_", "_F_C5_25_");
        aliasMap.put("_F_C5_25_", "_F_C5_25_");
        aliasMap.put("_F_C10_25_", "_F_C10_25_");
        aliasMap.put("_F_C10_25_", "_F_C10_25_");
        aliasMap.put("_F_C20_25_", "_F_C20_25_");
        aliasMap.put("_F_C20_25_", "_F_C20_25_");
        aliasMap.put("_F_C50_25_", "_F_C50_25_");
        aliasMap.put("_F_C50_25_", "_F_C50_25_");
        aliasMap.put("_F_B_26_", "_F_B_26_");
        aliasMap.put("_F_B_26_", "_F_B_26_");
        aliasMap.put("_F_I_26_", "_F_I_26_");
        aliasMap.put("_F_I_26_", "_F_I_26_");
        aliasMap.put("_F_L_26_", "_F_L_26_");
        aliasMap.put("_F_L_26_", "_F_L_26_");
        aliasMap.put("_F_N_26_", "_F_N_26_");
        aliasMap.put("_F_N_26_", "_F_N_26_");
        aliasMap.put("_F_C5_26_", "_F_C5_26_");
        aliasMap.put("_F_C5_26_", "_F_C5_26_");
        aliasMap.put("_F_C10_26_", "_F_C10_26_");
        aliasMap.put("_F_C10_26_", "_F_C10_26_");
        aliasMap.put("_F_C20_26_", "_F_C20_26_");
        aliasMap.put("_F_C20_26_", "_F_C20_26_");
        aliasMap.put("_F_C50_26_", "_F_C50_26_");
        aliasMap.put("_F_C50_26_", "_F_C50_26_");
        aliasMap.put("_F_B_27_", "_F_B_27_");
        aliasMap.put("_F_B_27_", "_F_B_27_");
        aliasMap.put("_F_I_27_", "_F_I_27_");
        aliasMap.put("_F_I_27_", "_F_I_27_");
        aliasMap.put("_F_L_27_", "_F_L_27_");
        aliasMap.put("_F_L_27_", "_F_L_27_");
        aliasMap.put("_F_N_27_", "_F_N_27_");
        aliasMap.put("_F_N_27_", "_F_N_27_");
        aliasMap.put("_F_C5_27_", "_F_C5_27_");
        aliasMap.put("_F_C5_27_", "_F_C5_27_");
        aliasMap.put("_F_C10_27_", "_F_C10_27_");
        aliasMap.put("_F_C10_27_", "_F_C10_27_");
        aliasMap.put("_F_C20_27_", "_F_C20_27_");
        aliasMap.put("_F_C20_27_", "_F_C20_27_");
        aliasMap.put("_F_C50_27_", "_F_C50_27_");
        aliasMap.put("_F_C50_27_", "_F_C50_27_");
        aliasMap.put("_F_B_28_", "_F_B_28_");
        aliasMap.put("_F_B_28_", "_F_B_28_");
        aliasMap.put("_F_I_28_", "_F_I_28_");
        aliasMap.put("_F_I_28_", "_F_I_28_");
        aliasMap.put("_F_L_28_", "_F_L_28_");
        aliasMap.put("_F_L_28_", "_F_L_28_");
        aliasMap.put("_F_N_28_", "_F_N_28_");
        aliasMap.put("_F_N_28_", "_F_N_28_");
        aliasMap.put("_F_C5_28_", "_F_C5_28_");
        aliasMap.put("_F_C5_28_", "_F_C5_28_");
        aliasMap.put("_F_C10_28_", "_F_C10_28_");
        aliasMap.put("_F_C10_28_", "_F_C10_28_");
        aliasMap.put("_F_C20_28_", "_F_C20_28_");
        aliasMap.put("_F_C20_28_", "_F_C20_28_");
        aliasMap.put("_F_C50_28_", "_F_C50_28_");
        aliasMap.put("_F_C50_28_", "_F_C50_28_");
        aliasMap.put("_F_B_29_", "_F_B_29_");
        aliasMap.put("_F_B_29_", "_F_B_29_");
        aliasMap.put("_F_I_29_", "_F_I_29_");
        aliasMap.put("_F_I_29_", "_F_I_29_");
        aliasMap.put("_F_L_29_", "_F_L_29_");
        aliasMap.put("_F_L_29_", "_F_L_29_");
        aliasMap.put("_F_N_29_", "_F_N_29_");
        aliasMap.put("_F_N_29_", "_F_N_29_");
        aliasMap.put("_F_C5_29_", "_F_C5_29_");
        aliasMap.put("_F_C5_29_", "_F_C5_29_");
        aliasMap.put("_F_C10_29_", "_F_C10_29_");
        aliasMap.put("_F_C10_29_", "_F_C10_29_");
        aliasMap.put("_F_C20_29_", "_F_C20_29_");
        aliasMap.put("_F_C20_29_", "_F_C20_29_");
        aliasMap.put("_F_C50_29_", "_F_C50_29_");
        aliasMap.put("_F_C50_29_", "_F_C50_29_");
        aliasMap.put("_F_B_30_", "_F_B_30_");
        aliasMap.put("_F_B_30_", "_F_B_30_");
        aliasMap.put("_F_I_30_", "_F_I_30_");
        aliasMap.put("_F_I_30_", "_F_I_30_");
        aliasMap.put("_F_N_30_", "_F_N_30_");
        aliasMap.put("_F_N_30_", "_F_N_30_");
        aliasMap.put("_F_C5_30_", "_F_C5_30_");
        aliasMap.put("_F_C5_30_", "_F_C5_30_");
        aliasMap.put("_F_C10_30_", "_F_C10_30_");
        aliasMap.put("_F_C10_30_", "_F_C10_30_");
        aliasMap.put("_F_C20_30_", "_F_C20_30_");
        aliasMap.put("_F_C20_30_", "_F_C20_30_");
        aliasMap.put("_F_C50_30_", "_F_C50_30_");
        aliasMap.put("_F_C50_30_", "_F_C50_30_");
        aliasMap.put("_F_B_31_", "_F_B_31_");
        aliasMap.put("_F_B_31_", "_F_B_31_");
        aliasMap.put("_F_I_31_", "_F_I_31_");
        aliasMap.put("_F_I_31_", "_F_I_31_");
        aliasMap.put("_F_N_31_", "_F_N_31_");
        aliasMap.put("_F_N_31_", "_F_N_31_");
        aliasMap.put("_F_C5_31_", "_F_C5_31_");
        aliasMap.put("_F_C5_31_", "_F_C5_31_");
        aliasMap.put("_F_C10_31_", "_F_C10_31_");
        aliasMap.put("_F_C10_31_", "_F_C10_31_");
        aliasMap.put("_F_C20_31_", "_F_C20_31_");
        aliasMap.put("_F_C20_31_", "_F_C20_31_");
        aliasMap.put("_F_C50_31_", "_F_C50_31_");
        aliasMap.put("_F_C50_31_", "_F_C50_31_");
        aliasMap.put("_F_B_32_", "_F_B_32_");
        aliasMap.put("_F_B_32_", "_F_B_32_");
        aliasMap.put("_F_I_32_", "_F_I_32_");
        aliasMap.put("_F_I_32_", "_F_I_32_");
        aliasMap.put("_F_N_32_", "_F_N_32_");
        aliasMap.put("_F_N_32_", "_F_N_32_");
        aliasMap.put("_F_C5_32_", "_F_C5_32_");
        aliasMap.put("_F_C5_32_", "_F_C5_32_");
        aliasMap.put("_F_C10_32_", "_F_C10_32_");
        aliasMap.put("_F_C10_32_", "_F_C10_32_");
        aliasMap.put("_F_C20_32_", "_F_C20_32_");
        aliasMap.put("_F_C20_32_", "_F_C20_32_");
        aliasMap.put("_F_C50_32_", "_F_C50_32_");
        aliasMap.put("_F_C50_32_", "_F_C50_32_");
        aliasMap.put("_F_B_33_", "_F_B_33_");
        aliasMap.put("_F_B_33_", "_F_B_33_");
        aliasMap.put("_F_I_33_", "_F_I_33_");
        aliasMap.put("_F_I_33_", "_F_I_33_");
        aliasMap.put("_F_N_33_", "_F_N_33_");
        aliasMap.put("_F_N_33_", "_F_N_33_");
        aliasMap.put("_F_C5_33_", "_F_C5_33_");
        aliasMap.put("_F_C5_33_", "_F_C5_33_");
        aliasMap.put("_F_C10_33_", "_F_C10_33_");
        aliasMap.put("_F_C10_33_", "_F_C10_33_");
        aliasMap.put("_F_C20_33_", "_F_C20_33_");
        aliasMap.put("_F_C20_33_", "_F_C20_33_");
        aliasMap.put("_F_C50_33_", "_F_C50_33_");
        aliasMap.put("_F_C50_33_", "_F_C50_33_");
        aliasMap.put("_F_B_34_", "_F_B_34_");
        aliasMap.put("_F_B_34_", "_F_B_34_");
        aliasMap.put("_F_I_34_", "_F_I_34_");
        aliasMap.put("_F_I_34_", "_F_I_34_");
        aliasMap.put("_F_N_34_", "_F_N_34_");
        aliasMap.put("_F_N_34_", "_F_N_34_");
        aliasMap.put("_F_C5_34_", "_F_C5_34_");
        aliasMap.put("_F_C5_34_", "_F_C5_34_");
        aliasMap.put("_F_C10_34_", "_F_C10_34_");
        aliasMap.put("_F_C10_34_", "_F_C10_34_");
        aliasMap.put("_F_C20_34_", "_F_C20_34_");
        aliasMap.put("_F_C20_34_", "_F_C20_34_");
        aliasMap.put("_F_C50_34_", "_F_C50_34_");
        aliasMap.put("_F_C50_34_", "_F_C50_34_");
        aliasMap.put("_F_B_35_", "_F_B_35_");
        aliasMap.put("_F_B_35_", "_F_B_35_");
        aliasMap.put("_F_I_35_", "_F_I_35_");
        aliasMap.put("_F_I_35_", "_F_I_35_");
        aliasMap.put("_F_N_35_", "_F_N_35_");
        aliasMap.put("_F_N_35_", "_F_N_35_");
        aliasMap.put("_F_C5_35_", "_F_C5_35_");
        aliasMap.put("_F_C5_35_", "_F_C5_35_");
        aliasMap.put("_F_C10_35_", "_F_C10_35_");
        aliasMap.put("_F_C10_35_", "_F_C10_35_");
        aliasMap.put("_F_C20_35_", "_F_C20_35_");
        aliasMap.put("_F_C20_35_", "_F_C20_35_");
        aliasMap.put("_F_C50_35_", "_F_C50_35_");
        aliasMap.put("_F_C50_35_", "_F_C50_35_");
        aliasMap.put("_F_B_36_", "_F_B_36_");
        aliasMap.put("_F_B_36_", "_F_B_36_");
        aliasMap.put("_F_I_36_", "_F_I_36_");
        aliasMap.put("_F_I_36_", "_F_I_36_");
        aliasMap.put("_F_N_36_", "_F_N_36_");
        aliasMap.put("_F_N_36_", "_F_N_36_");
        aliasMap.put("_F_C5_36_", "_F_C5_36_");
        aliasMap.put("_F_C5_36_", "_F_C5_36_");
        aliasMap.put("_F_C10_36_", "_F_C10_36_");
        aliasMap.put("_F_C10_36_", "_F_C10_36_");
        aliasMap.put("_F_C20_36_", "_F_C20_36_");
        aliasMap.put("_F_C20_36_", "_F_C20_36_");
        aliasMap.put("_F_C50_36_", "_F_C50_36_");
        aliasMap.put("_F_C50_36_", "_F_C50_36_");
        aliasMap.put("_F_B_37_", "_F_B_37_");
        aliasMap.put("_F_B_37_", "_F_B_37_");
        aliasMap.put("_F_I_37_", "_F_I_37_");
        aliasMap.put("_F_I_37_", "_F_I_37_");
        aliasMap.put("_F_N_37_", "_F_N_37_");
        aliasMap.put("_F_N_37_", "_F_N_37_");
        aliasMap.put("_F_C5_37_", "_F_C5_37_");
        aliasMap.put("_F_C5_37_", "_F_C5_37_");
        aliasMap.put("_F_C10_37_", "_F_C10_37_");
        aliasMap.put("_F_C10_37_", "_F_C10_37_");
        aliasMap.put("_F_C20_37_", "_F_C20_37_");
        aliasMap.put("_F_C20_37_", "_F_C20_37_");
        aliasMap.put("_F_C50_37_", "_F_C50_37_");
        aliasMap.put("_F_C50_37_", "_F_C50_37_");
        aliasMap.put("_F_B_38_", "_F_B_38_");
        aliasMap.put("_F_B_38_", "_F_B_38_");
        aliasMap.put("_F_I_38_", "_F_I_38_");
        aliasMap.put("_F_I_38_", "_F_I_38_");
        aliasMap.put("_F_N_38_", "_F_N_38_");
        aliasMap.put("_F_N_38_", "_F_N_38_");
        aliasMap.put("_F_C5_38_", "_F_C5_38_");
        aliasMap.put("_F_C5_38_", "_F_C5_38_");
        aliasMap.put("_F_C10_38_", "_F_C10_38_");
        aliasMap.put("_F_C10_38_", "_F_C10_38_");
        aliasMap.put("_F_C20_38_", "_F_C20_38_");
        aliasMap.put("_F_C20_38_", "_F_C20_38_");
        aliasMap.put("_F_C50_38_", "_F_C50_38_");
        aliasMap.put("_F_C50_38_", "_F_C50_38_");
        aliasMap.put("_F_B_39_", "_F_B_39_");
        aliasMap.put("_F_B_39_", "_F_B_39_");
        aliasMap.put("_F_I_39_", "_F_I_39_");
        aliasMap.put("_F_I_39_", "_F_I_39_");
        aliasMap.put("_F_N_39_", "_F_N_39_");
        aliasMap.put("_F_N_39_", "_F_N_39_");
        aliasMap.put("_F_C5_39_", "_F_C5_39_");
        aliasMap.put("_F_C5_39_", "_F_C5_39_");
        aliasMap.put("_F_C10_39_", "_F_C10_39_");
        aliasMap.put("_F_C10_39_", "_F_C10_39_");
        aliasMap.put("_F_C20_39_", "_F_C20_39_");
        aliasMap.put("_F_C20_39_", "_F_C20_39_");
        aliasMap.put("_F_C50_39_", "_F_C50_39_");
        aliasMap.put("_F_C50_39_", "_F_C50_39_");
        aliasMap.put("_F_B_40_", "_F_B_40_");
        aliasMap.put("_F_B_40_", "_F_B_40_");
        aliasMap.put("_F_I_40_", "_F_I_40_");
        aliasMap.put("_F_I_40_", "_F_I_40_");
        aliasMap.put("_F_N_40_", "_F_N_40_");
        aliasMap.put("_F_N_40_", "_F_N_40_");
        aliasMap.put("_F_C5_40_", "_F_C5_40_");
        aliasMap.put("_F_C5_40_", "_F_C5_40_");
        aliasMap.put("_F_C10_40_", "_F_C10_40_");
        aliasMap.put("_F_C10_40_", "_F_C10_40_");
        aliasMap.put("_F_C20_40_", "_F_C20_40_");
        aliasMap.put("_F_C20_40_", "_F_C20_40_");
        aliasMap.put("_F_C50_40_", "_F_C50_40_");
        aliasMap.put("_F_C50_40_", "_F_C50_40_");
        aliasMap.put("_F_B_41_", "_F_B_41_");
        aliasMap.put("_F_B_41_", "_F_B_41_");
        aliasMap.put("_F_I_41_", "_F_I_41_");
        aliasMap.put("_F_I_41_", "_F_I_41_");
        aliasMap.put("_F_N_41_", "_F_N_41_");
        aliasMap.put("_F_N_41_", "_F_N_41_");
        aliasMap.put("_F_C5_41_", "_F_C5_41_");
        aliasMap.put("_F_C5_41_", "_F_C5_41_");
        aliasMap.put("_F_C10_41_", "_F_C10_41_");
        aliasMap.put("_F_C10_41_", "_F_C10_41_");
        aliasMap.put("_F_C20_41_", "_F_C20_41_");
        aliasMap.put("_F_C20_41_", "_F_C20_41_");
        aliasMap.put("_F_C50_41_", "_F_C50_41_");
        aliasMap.put("_F_C50_41_", "_F_C50_41_");
        aliasMap.put("_F_B_42_", "_F_B_42_");
        aliasMap.put("_F_B_42_", "_F_B_42_");
        aliasMap.put("_F_I_42_", "_F_I_42_");
        aliasMap.put("_F_I_42_", "_F_I_42_");
        aliasMap.put("_F_N_42_", "_F_N_42_");
        aliasMap.put("_F_N_42_", "_F_N_42_");
        aliasMap.put("_F_C5_42_", "_F_C5_42_");
        aliasMap.put("_F_C5_42_", "_F_C5_42_");
        aliasMap.put("_F_C10_42_", "_F_C10_42_");
        aliasMap.put("_F_C10_42_", "_F_C10_42_");
        aliasMap.put("_F_C20_42_", "_F_C20_42_");
        aliasMap.put("_F_C20_42_", "_F_C20_42_");
        aliasMap.put("_F_C50_42_", "_F_C50_42_");
        aliasMap.put("_F_C50_42_", "_F_C50_42_");
        aliasMap.put("_F_B_43_", "_F_B_43_");
        aliasMap.put("_F_B_43_", "_F_B_43_");
        aliasMap.put("_F_I_43_", "_F_I_43_");
        aliasMap.put("_F_I_43_", "_F_I_43_");
        aliasMap.put("_F_N_43_", "_F_N_43_");
        aliasMap.put("_F_N_43_", "_F_N_43_");
        aliasMap.put("_F_C5_43_", "_F_C5_43_");
        aliasMap.put("_F_C5_43_", "_F_C5_43_");
        aliasMap.put("_F_C10_43_", "_F_C10_43_");
        aliasMap.put("_F_C10_43_", "_F_C10_43_");
        aliasMap.put("_F_C20_43_", "_F_C20_43_");
        aliasMap.put("_F_C20_43_", "_F_C20_43_");
        aliasMap.put("_F_C50_43_", "_F_C50_43_");
        aliasMap.put("_F_C50_43_", "_F_C50_43_");
        aliasMap.put("_F_B_44_", "_F_B_44_");
        aliasMap.put("_F_B_44_", "_F_B_44_");
        aliasMap.put("_F_I_44_", "_F_I_44_");
        aliasMap.put("_F_I_44_", "_F_I_44_");
        aliasMap.put("_F_N_44_", "_F_N_44_");
        aliasMap.put("_F_N_44_", "_F_N_44_");
        aliasMap.put("_F_C5_44_", "_F_C5_44_");
        aliasMap.put("_F_C5_44_", "_F_C5_44_");
        aliasMap.put("_F_C10_44_", "_F_C10_44_");
        aliasMap.put("_F_C10_44_", "_F_C10_44_");
        aliasMap.put("_F_C20_44_", "_F_C20_44_");
        aliasMap.put("_F_C20_44_", "_F_C20_44_");
        aliasMap.put("_F_C50_44_", "_F_C50_44_");
        aliasMap.put("_F_C50_44_", "_F_C50_44_");
        aliasMap.put("_F_B_45_", "_F_B_45_");
        aliasMap.put("_F_B_45_", "_F_B_45_");
        aliasMap.put("_F_I_45_", "_F_I_45_");
        aliasMap.put("_F_I_45_", "_F_I_45_");
        aliasMap.put("_F_N_45_", "_F_N_45_");
        aliasMap.put("_F_N_45_", "_F_N_45_");
        aliasMap.put("_F_C5_45_", "_F_C5_45_");
        aliasMap.put("_F_C5_45_", "_F_C5_45_");
        aliasMap.put("_F_C10_45_", "_F_C10_45_");
        aliasMap.put("_F_C10_45_", "_F_C10_45_");
        aliasMap.put("_F_C20_45_", "_F_C20_45_");
        aliasMap.put("_F_C20_45_", "_F_C20_45_");
        aliasMap.put("_F_C50_45_", "_F_C50_45_");
        aliasMap.put("_F_C50_45_", "_F_C50_45_");
        aliasMap.put("_F_B_46_", "_F_B_46_");
        aliasMap.put("_F_B_46_", "_F_B_46_");
        aliasMap.put("_F_I_46_", "_F_I_46_");
        aliasMap.put("_F_I_46_", "_F_I_46_");
        aliasMap.put("_F_N_46_", "_F_N_46_");
        aliasMap.put("_F_N_46_", "_F_N_46_");
        aliasMap.put("_F_C5_46_", "_F_C5_46_");
        aliasMap.put("_F_C5_46_", "_F_C5_46_");
        aliasMap.put("_F_C10_46_", "_F_C10_46_");
        aliasMap.put("_F_C10_46_", "_F_C10_46_");
        aliasMap.put("_F_C20_46_", "_F_C20_46_");
        aliasMap.put("_F_C20_46_", "_F_C20_46_");
        aliasMap.put("_F_C50_46_", "_F_C50_46_");
        aliasMap.put("_F_C50_46_", "_F_C50_46_");
        aliasMap.put("_F_B_47_", "_F_B_47_");
        aliasMap.put("_F_B_47_", "_F_B_47_");
        aliasMap.put("_F_I_47_", "_F_I_47_");
        aliasMap.put("_F_I_47_", "_F_I_47_");
        aliasMap.put("_F_N_47_", "_F_N_47_");
        aliasMap.put("_F_N_47_", "_F_N_47_");
        aliasMap.put("_F_C5_47_", "_F_C5_47_");
        aliasMap.put("_F_C5_47_", "_F_C5_47_");
        aliasMap.put("_F_C10_47_", "_F_C10_47_");
        aliasMap.put("_F_C10_47_", "_F_C10_47_");
        aliasMap.put("_F_C20_47_", "_F_C20_47_");
        aliasMap.put("_F_C20_47_", "_F_C20_47_");
        aliasMap.put("_F_C50_47_", "_F_C50_47_");
        aliasMap.put("_F_C50_47_", "_F_C50_47_");
        aliasMap.put("_F_B_48_", "_F_B_48_");
        aliasMap.put("_F_B_48_", "_F_B_48_");
        aliasMap.put("_F_I_48_", "_F_I_48_");
        aliasMap.put("_F_I_48_", "_F_I_48_");
        aliasMap.put("_F_N_48_", "_F_N_48_");
        aliasMap.put("_F_N_48_", "_F_N_48_");
        aliasMap.put("_F_C5_48_", "_F_C5_48_");
        aliasMap.put("_F_C5_48_", "_F_C5_48_");
        aliasMap.put("_F_C10_48_", "_F_C10_48_");
        aliasMap.put("_F_C10_48_", "_F_C10_48_");
        aliasMap.put("_F_C20_48_", "_F_C20_48_");
        aliasMap.put("_F_C20_48_", "_F_C20_48_");
        aliasMap.put("_F_C50_48_", "_F_C50_48_");
        aliasMap.put("_F_C50_48_", "_F_C50_48_");
        aliasMap.put("_F_B_49_", "_F_B_49_");
        aliasMap.put("_F_B_49_", "_F_B_49_");
        aliasMap.put("_F_I_49_", "_F_I_49_");
        aliasMap.put("_F_I_49_", "_F_I_49_");
        aliasMap.put("_F_N_49_", "_F_N_49_");
        aliasMap.put("_F_N_49_", "_F_N_49_");
        aliasMap.put("_F_C5_49_", "_F_C5_49_");
        aliasMap.put("_F_C5_49_", "_F_C5_49_");
        aliasMap.put("_F_C10_49_", "_F_C10_49_");
        aliasMap.put("_F_C10_49_", "_F_C10_49_");
        aliasMap.put("_F_C20_49_", "_F_C20_49_");
        aliasMap.put("_F_C20_49_", "_F_C20_49_");
        aliasMap.put("_F_C50_49_", "_F_C50_49_");
        aliasMap.put("_F_C50_49_", "_F_C50_49_");
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

