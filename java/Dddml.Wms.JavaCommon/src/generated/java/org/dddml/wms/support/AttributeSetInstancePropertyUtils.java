// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstancePropertyUtils.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.wms.support;

import org.dddml.wms.domain.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.dddml.wms.domain.attributesetinstance.*;


public class AttributeSetInstancePropertyUtils {
    private AttributeSetInstancePropertyUtils() {
    }

    private static String getSafeStringValue(String str) {
        if (str == null) {
            return "[null]";
        }
        return str;
    }


    private static String getMD5HashString(MessageDigest md5Hash, String input) {
        try {
            byte[] data = md5Hash.digest(input.getBytes("UTF-8"));
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                String hex = Integer.toHexString(data[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sBuilder.append(hex.toLowerCase());
            }
            return sBuilder.toString();
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }



    public static String getHash(AttributeSetInstanceEvent.AttributeSetInstanceStateCreated instance) {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeSetId").append("=").append(getSafeStringValue(instance.getAttributeSetId())).append("|");
        sb.append("OrganizationId").append("=").append(getSafeStringValue(instance.getOrganizationId())).append("|");
        sb.append("ReferenceId").append("=").append(getSafeStringValue(instance.getReferenceId())).append("|");
        sb.append("SerialNumber").append("=").append(getSafeStringValue(instance.getSerialNumber())).append("|");
        sb.append("LotId").append("=").append(getSafeStringValue(instance.getLotId())).append("|");
        sb.append("StatusId").append("=").append(getSafeStringValue(instance.getStatusId())).append("|");
        sb.append("ImageUrl").append("=").append(getSafeStringValue(instance.getImageUrl())).append("|");
        sb.append("Description").append("=").append(getSafeStringValue(instance.getDescription())).append("|");
        sb.append("Active").append("=").append(instance.getActive()).append("|");
        sb.append("WidthInch").append("=").append(instance.getWidthInch()).append("|");
        sb.append("DiameterInch").append("=").append(instance.getDiameterInch()).append("|");
        sb.append("WeightLbs").append("=").append(instance.getWeightLbs()).append("|");
        sb.append("WeightKg").append("=").append(instance.getWeightKg()).append("|");
        sb.append("AirDryWeightLbs").append("=").append(instance.getAirDryWeightLbs()).append("|");
        sb.append("AirDryWeightKg").append("=").append(instance.getAirDryWeightKg()).append("|");
        sb.append("AirDryMetricTon").append("=").append(instance.getAirDryMetricTon()).append("|");
        sb.append("PackageCount").append("=").append(instance.getPackageCount()).append("|");
        sb.append("AirDryPct").append("=").append(instance.getAirDryPct()).append("|");
        sb.append("_F_B_0_").append("=").append(instance.get_F_B_0_()).append("|");
        sb.append("_F_I_0_").append("=").append(instance.get_F_I_0_()).append("|");
        sb.append("_F_L_0_").append("=").append(instance.get_F_L_0_()).append("|");
        sb.append("_F_DT_0_").append("=").append(instance.get_F_DT_0_()).append("|");
        sb.append("_F_N_0_").append("=").append(instance.get_F_N_0_()).append("|");
        sb.append("_F_C5_0_").append("=").append(getSafeStringValue(instance.get_F_C5_0_())).append("|");
        sb.append("_F_C10_0_").append("=").append(getSafeStringValue(instance.get_F_C10_0_())).append("|");
        sb.append("_F_C20_0_").append("=").append(getSafeStringValue(instance.get_F_C20_0_())).append("|");
        sb.append("_F_C50_0_").append("=").append(getSafeStringValue(instance.get_F_C50_0_())).append("|");
        sb.append("_F_C100_0_").append("=").append(getSafeStringValue(instance.get_F_C100_0_())).append("|");
        sb.append("_F_C200_0_").append("=").append(getSafeStringValue(instance.get_F_C200_0_())).append("|");
        sb.append("_F_C500_0_").append("=").append(getSafeStringValue(instance.get_F_C500_0_())).append("|");
        sb.append("_F_C1000_0_").append("=").append(getSafeStringValue(instance.get_F_C1000_0_())).append("|");
        sb.append("_F_B_1_").append("=").append(instance.get_F_B_1_()).append("|");
        sb.append("_F_I_1_").append("=").append(instance.get_F_I_1_()).append("|");
        sb.append("_F_L_1_").append("=").append(instance.get_F_L_1_()).append("|");
        sb.append("_F_DT_1_").append("=").append(instance.get_F_DT_1_()).append("|");
        sb.append("_F_N_1_").append("=").append(instance.get_F_N_1_()).append("|");
        sb.append("_F_C5_1_").append("=").append(getSafeStringValue(instance.get_F_C5_1_())).append("|");
        sb.append("_F_C10_1_").append("=").append(getSafeStringValue(instance.get_F_C10_1_())).append("|");
        sb.append("_F_C20_1_").append("=").append(getSafeStringValue(instance.get_F_C20_1_())).append("|");
        sb.append("_F_C50_1_").append("=").append(getSafeStringValue(instance.get_F_C50_1_())).append("|");
        sb.append("_F_C100_1_").append("=").append(getSafeStringValue(instance.get_F_C100_1_())).append("|");
        sb.append("_F_C200_1_").append("=").append(getSafeStringValue(instance.get_F_C200_1_())).append("|");
        sb.append("_F_B_2_").append("=").append(instance.get_F_B_2_()).append("|");
        sb.append("_F_I_2_").append("=").append(instance.get_F_I_2_()).append("|");
        sb.append("_F_L_2_").append("=").append(instance.get_F_L_2_()).append("|");
        sb.append("_F_DT_2_").append("=").append(instance.get_F_DT_2_()).append("|");
        sb.append("_F_N_2_").append("=").append(instance.get_F_N_2_()).append("|");
        sb.append("_F_C5_2_").append("=").append(getSafeStringValue(instance.get_F_C5_2_())).append("|");
        sb.append("_F_C10_2_").append("=").append(getSafeStringValue(instance.get_F_C10_2_())).append("|");
        sb.append("_F_C20_2_").append("=").append(getSafeStringValue(instance.get_F_C20_2_())).append("|");
        sb.append("_F_C50_2_").append("=").append(getSafeStringValue(instance.get_F_C50_2_())).append("|");
        sb.append("_F_B_3_").append("=").append(instance.get_F_B_3_()).append("|");
        sb.append("_F_I_3_").append("=").append(instance.get_F_I_3_()).append("|");
        sb.append("_F_L_3_").append("=").append(instance.get_F_L_3_()).append("|");
        sb.append("_F_DT_3_").append("=").append(instance.get_F_DT_3_()).append("|");
        sb.append("_F_N_3_").append("=").append(instance.get_F_N_3_()).append("|");
        sb.append("_F_C5_3_").append("=").append(getSafeStringValue(instance.get_F_C5_3_())).append("|");
        sb.append("_F_C10_3_").append("=").append(getSafeStringValue(instance.get_F_C10_3_())).append("|");
        sb.append("_F_C20_3_").append("=").append(getSafeStringValue(instance.get_F_C20_3_())).append("|");
        sb.append("_F_C50_3_").append("=").append(getSafeStringValue(instance.get_F_C50_3_())).append("|");
        sb.append("_F_B_4_").append("=").append(instance.get_F_B_4_()).append("|");
        sb.append("_F_I_4_").append("=").append(instance.get_F_I_4_()).append("|");
        sb.append("_F_L_4_").append("=").append(instance.get_F_L_4_()).append("|");
        sb.append("_F_DT_4_").append("=").append(instance.get_F_DT_4_()).append("|");
        sb.append("_F_N_4_").append("=").append(instance.get_F_N_4_()).append("|");
        sb.append("_F_C5_4_").append("=").append(getSafeStringValue(instance.get_F_C5_4_())).append("|");
        sb.append("_F_C10_4_").append("=").append(getSafeStringValue(instance.get_F_C10_4_())).append("|");
        sb.append("_F_C20_4_").append("=").append(getSafeStringValue(instance.get_F_C20_4_())).append("|");
        sb.append("_F_C50_4_").append("=").append(getSafeStringValue(instance.get_F_C50_4_())).append("|");

        try {
            String hash = getMD5HashString(MessageDigest.getInstance("MD5"), sb.toString());
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }



    public static String getHash(AttributeSetInstanceCommand.CreateAttributeSetInstance instance) {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeSetId").append("=").append(getSafeStringValue(instance.getAttributeSetId())).append("|");
        sb.append("OrganizationId").append("=").append(getSafeStringValue(instance.getOrganizationId())).append("|");
        sb.append("ReferenceId").append("=").append(getSafeStringValue(instance.getReferenceId())).append("|");
        sb.append("SerialNumber").append("=").append(getSafeStringValue(instance.getSerialNumber())).append("|");
        sb.append("LotId").append("=").append(getSafeStringValue(instance.getLotId())).append("|");
        sb.append("StatusId").append("=").append(getSafeStringValue(instance.getStatusId())).append("|");
        sb.append("ImageUrl").append("=").append(getSafeStringValue(instance.getImageUrl())).append("|");
        sb.append("Description").append("=").append(getSafeStringValue(instance.getDescription())).append("|");
        sb.append("Active").append("=").append(instance.getActive()).append("|");
        sb.append("WidthInch").append("=").append(instance.getWidthInch()).append("|");
        sb.append("DiameterInch").append("=").append(instance.getDiameterInch()).append("|");
        sb.append("WeightLbs").append("=").append(instance.getWeightLbs()).append("|");
        sb.append("WeightKg").append("=").append(instance.getWeightKg()).append("|");
        sb.append("AirDryWeightLbs").append("=").append(instance.getAirDryWeightLbs()).append("|");
        sb.append("AirDryWeightKg").append("=").append(instance.getAirDryWeightKg()).append("|");
        sb.append("AirDryMetricTon").append("=").append(instance.getAirDryMetricTon()).append("|");
        sb.append("PackageCount").append("=").append(instance.getPackageCount()).append("|");
        sb.append("AirDryPct").append("=").append(instance.getAirDryPct()).append("|");
        sb.append("_F_B_0_").append("=").append(instance.get_F_B_0_()).append("|");
        sb.append("_F_I_0_").append("=").append(instance.get_F_I_0_()).append("|");
        sb.append("_F_L_0_").append("=").append(instance.get_F_L_0_()).append("|");
        sb.append("_F_DT_0_").append("=").append(instance.get_F_DT_0_()).append("|");
        sb.append("_F_N_0_").append("=").append(instance.get_F_N_0_()).append("|");
        sb.append("_F_C5_0_").append("=").append(getSafeStringValue(instance.get_F_C5_0_())).append("|");
        sb.append("_F_C10_0_").append("=").append(getSafeStringValue(instance.get_F_C10_0_())).append("|");
        sb.append("_F_C20_0_").append("=").append(getSafeStringValue(instance.get_F_C20_0_())).append("|");
        sb.append("_F_C50_0_").append("=").append(getSafeStringValue(instance.get_F_C50_0_())).append("|");
        sb.append("_F_C100_0_").append("=").append(getSafeStringValue(instance.get_F_C100_0_())).append("|");
        sb.append("_F_C200_0_").append("=").append(getSafeStringValue(instance.get_F_C200_0_())).append("|");
        sb.append("_F_C500_0_").append("=").append(getSafeStringValue(instance.get_F_C500_0_())).append("|");
        sb.append("_F_C1000_0_").append("=").append(getSafeStringValue(instance.get_F_C1000_0_())).append("|");
        sb.append("_F_B_1_").append("=").append(instance.get_F_B_1_()).append("|");
        sb.append("_F_I_1_").append("=").append(instance.get_F_I_1_()).append("|");
        sb.append("_F_L_1_").append("=").append(instance.get_F_L_1_()).append("|");
        sb.append("_F_DT_1_").append("=").append(instance.get_F_DT_1_()).append("|");
        sb.append("_F_N_1_").append("=").append(instance.get_F_N_1_()).append("|");
        sb.append("_F_C5_1_").append("=").append(getSafeStringValue(instance.get_F_C5_1_())).append("|");
        sb.append("_F_C10_1_").append("=").append(getSafeStringValue(instance.get_F_C10_1_())).append("|");
        sb.append("_F_C20_1_").append("=").append(getSafeStringValue(instance.get_F_C20_1_())).append("|");
        sb.append("_F_C50_1_").append("=").append(getSafeStringValue(instance.get_F_C50_1_())).append("|");
        sb.append("_F_C100_1_").append("=").append(getSafeStringValue(instance.get_F_C100_1_())).append("|");
        sb.append("_F_C200_1_").append("=").append(getSafeStringValue(instance.get_F_C200_1_())).append("|");
        sb.append("_F_B_2_").append("=").append(instance.get_F_B_2_()).append("|");
        sb.append("_F_I_2_").append("=").append(instance.get_F_I_2_()).append("|");
        sb.append("_F_L_2_").append("=").append(instance.get_F_L_2_()).append("|");
        sb.append("_F_DT_2_").append("=").append(instance.get_F_DT_2_()).append("|");
        sb.append("_F_N_2_").append("=").append(instance.get_F_N_2_()).append("|");
        sb.append("_F_C5_2_").append("=").append(getSafeStringValue(instance.get_F_C5_2_())).append("|");
        sb.append("_F_C10_2_").append("=").append(getSafeStringValue(instance.get_F_C10_2_())).append("|");
        sb.append("_F_C20_2_").append("=").append(getSafeStringValue(instance.get_F_C20_2_())).append("|");
        sb.append("_F_C50_2_").append("=").append(getSafeStringValue(instance.get_F_C50_2_())).append("|");
        sb.append("_F_B_3_").append("=").append(instance.get_F_B_3_()).append("|");
        sb.append("_F_I_3_").append("=").append(instance.get_F_I_3_()).append("|");
        sb.append("_F_L_3_").append("=").append(instance.get_F_L_3_()).append("|");
        sb.append("_F_DT_3_").append("=").append(instance.get_F_DT_3_()).append("|");
        sb.append("_F_N_3_").append("=").append(instance.get_F_N_3_()).append("|");
        sb.append("_F_C5_3_").append("=").append(getSafeStringValue(instance.get_F_C5_3_())).append("|");
        sb.append("_F_C10_3_").append("=").append(getSafeStringValue(instance.get_F_C10_3_())).append("|");
        sb.append("_F_C20_3_").append("=").append(getSafeStringValue(instance.get_F_C20_3_())).append("|");
        sb.append("_F_C50_3_").append("=").append(getSafeStringValue(instance.get_F_C50_3_())).append("|");
        sb.append("_F_B_4_").append("=").append(instance.get_F_B_4_()).append("|");
        sb.append("_F_I_4_").append("=").append(instance.get_F_I_4_()).append("|");
        sb.append("_F_L_4_").append("=").append(instance.get_F_L_4_()).append("|");
        sb.append("_F_DT_4_").append("=").append(instance.get_F_DT_4_()).append("|");
        sb.append("_F_N_4_").append("=").append(instance.get_F_N_4_()).append("|");
        sb.append("_F_C5_4_").append("=").append(getSafeStringValue(instance.get_F_C5_4_())).append("|");
        sb.append("_F_C10_4_").append("=").append(getSafeStringValue(instance.get_F_C10_4_())).append("|");
        sb.append("_F_C20_4_").append("=").append(getSafeStringValue(instance.get_F_C20_4_())).append("|");
        sb.append("_F_C50_4_").append("=").append(getSafeStringValue(instance.get_F_C50_4_())).append("|");

        try {
            String hash = getMD5HashString(MessageDigest.getInstance("MD5"), sb.toString());
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }



    public static String getHash(AttributeSetInstanceState instance) {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeSetId").append("=").append(getSafeStringValue(instance.getAttributeSetId())).append("|");
        sb.append("OrganizationId").append("=").append(getSafeStringValue(instance.getOrganizationId())).append("|");
        sb.append("ReferenceId").append("=").append(getSafeStringValue(instance.getReferenceId())).append("|");
        sb.append("SerialNumber").append("=").append(getSafeStringValue(instance.getSerialNumber())).append("|");
        sb.append("LotId").append("=").append(getSafeStringValue(instance.getLotId())).append("|");
        sb.append("StatusId").append("=").append(getSafeStringValue(instance.getStatusId())).append("|");
        sb.append("ImageUrl").append("=").append(getSafeStringValue(instance.getImageUrl())).append("|");
        sb.append("Description").append("=").append(getSafeStringValue(instance.getDescription())).append("|");
        sb.append("Active").append("=").append(instance.getActive()).append("|");
        sb.append("WidthInch").append("=").append(instance.getWidthInch()).append("|");
        sb.append("DiameterInch").append("=").append(instance.getDiameterInch()).append("|");
        sb.append("WeightLbs").append("=").append(instance.getWeightLbs()).append("|");
        sb.append("WeightKg").append("=").append(instance.getWeightKg()).append("|");
        sb.append("AirDryWeightLbs").append("=").append(instance.getAirDryWeightLbs()).append("|");
        sb.append("AirDryWeightKg").append("=").append(instance.getAirDryWeightKg()).append("|");
        sb.append("AirDryMetricTon").append("=").append(instance.getAirDryMetricTon()).append("|");
        sb.append("PackageCount").append("=").append(instance.getPackageCount()).append("|");
        sb.append("AirDryPct").append("=").append(instance.getAirDryPct()).append("|");
        sb.append("_F_B_0_").append("=").append(instance.get_F_B_0_()).append("|");
        sb.append("_F_I_0_").append("=").append(instance.get_F_I_0_()).append("|");
        sb.append("_F_L_0_").append("=").append(instance.get_F_L_0_()).append("|");
        sb.append("_F_DT_0_").append("=").append(instance.get_F_DT_0_()).append("|");
        sb.append("_F_N_0_").append("=").append(instance.get_F_N_0_()).append("|");
        sb.append("_F_C5_0_").append("=").append(getSafeStringValue(instance.get_F_C5_0_())).append("|");
        sb.append("_F_C10_0_").append("=").append(getSafeStringValue(instance.get_F_C10_0_())).append("|");
        sb.append("_F_C20_0_").append("=").append(getSafeStringValue(instance.get_F_C20_0_())).append("|");
        sb.append("_F_C50_0_").append("=").append(getSafeStringValue(instance.get_F_C50_0_())).append("|");
        sb.append("_F_C100_0_").append("=").append(getSafeStringValue(instance.get_F_C100_0_())).append("|");
        sb.append("_F_C200_0_").append("=").append(getSafeStringValue(instance.get_F_C200_0_())).append("|");
        sb.append("_F_C500_0_").append("=").append(getSafeStringValue(instance.get_F_C500_0_())).append("|");
        sb.append("_F_C1000_0_").append("=").append(getSafeStringValue(instance.get_F_C1000_0_())).append("|");
        sb.append("_F_B_1_").append("=").append(instance.get_F_B_1_()).append("|");
        sb.append("_F_I_1_").append("=").append(instance.get_F_I_1_()).append("|");
        sb.append("_F_L_1_").append("=").append(instance.get_F_L_1_()).append("|");
        sb.append("_F_DT_1_").append("=").append(instance.get_F_DT_1_()).append("|");
        sb.append("_F_N_1_").append("=").append(instance.get_F_N_1_()).append("|");
        sb.append("_F_C5_1_").append("=").append(getSafeStringValue(instance.get_F_C5_1_())).append("|");
        sb.append("_F_C10_1_").append("=").append(getSafeStringValue(instance.get_F_C10_1_())).append("|");
        sb.append("_F_C20_1_").append("=").append(getSafeStringValue(instance.get_F_C20_1_())).append("|");
        sb.append("_F_C50_1_").append("=").append(getSafeStringValue(instance.get_F_C50_1_())).append("|");
        sb.append("_F_C100_1_").append("=").append(getSafeStringValue(instance.get_F_C100_1_())).append("|");
        sb.append("_F_C200_1_").append("=").append(getSafeStringValue(instance.get_F_C200_1_())).append("|");
        sb.append("_F_B_2_").append("=").append(instance.get_F_B_2_()).append("|");
        sb.append("_F_I_2_").append("=").append(instance.get_F_I_2_()).append("|");
        sb.append("_F_L_2_").append("=").append(instance.get_F_L_2_()).append("|");
        sb.append("_F_DT_2_").append("=").append(instance.get_F_DT_2_()).append("|");
        sb.append("_F_N_2_").append("=").append(instance.get_F_N_2_()).append("|");
        sb.append("_F_C5_2_").append("=").append(getSafeStringValue(instance.get_F_C5_2_())).append("|");
        sb.append("_F_C10_2_").append("=").append(getSafeStringValue(instance.get_F_C10_2_())).append("|");
        sb.append("_F_C20_2_").append("=").append(getSafeStringValue(instance.get_F_C20_2_())).append("|");
        sb.append("_F_C50_2_").append("=").append(getSafeStringValue(instance.get_F_C50_2_())).append("|");
        sb.append("_F_B_3_").append("=").append(instance.get_F_B_3_()).append("|");
        sb.append("_F_I_3_").append("=").append(instance.get_F_I_3_()).append("|");
        sb.append("_F_L_3_").append("=").append(instance.get_F_L_3_()).append("|");
        sb.append("_F_DT_3_").append("=").append(instance.get_F_DT_3_()).append("|");
        sb.append("_F_N_3_").append("=").append(instance.get_F_N_3_()).append("|");
        sb.append("_F_C5_3_").append("=").append(getSafeStringValue(instance.get_F_C5_3_())).append("|");
        sb.append("_F_C10_3_").append("=").append(getSafeStringValue(instance.get_F_C10_3_())).append("|");
        sb.append("_F_C20_3_").append("=").append(getSafeStringValue(instance.get_F_C20_3_())).append("|");
        sb.append("_F_C50_3_").append("=").append(getSafeStringValue(instance.get_F_C50_3_())).append("|");
        sb.append("_F_B_4_").append("=").append(instance.get_F_B_4_()).append("|");
        sb.append("_F_I_4_").append("=").append(instance.get_F_I_4_()).append("|");
        sb.append("_F_L_4_").append("=").append(instance.get_F_L_4_()).append("|");
        sb.append("_F_DT_4_").append("=").append(instance.get_F_DT_4_()).append("|");
        sb.append("_F_N_4_").append("=").append(instance.get_F_N_4_()).append("|");
        sb.append("_F_C5_4_").append("=").append(getSafeStringValue(instance.get_F_C5_4_())).append("|");
        sb.append("_F_C10_4_").append("=").append(getSafeStringValue(instance.get_F_C10_4_())).append("|");
        sb.append("_F_C20_4_").append("=").append(getSafeStringValue(instance.get_F_C20_4_())).append("|");
        sb.append("_F_C50_4_").append("=").append(getSafeStringValue(instance.get_F_C50_4_())).append("|");

        try {
            String hash = getMD5HashString(MessageDigest.getInstance("MD5"), sb.toString());
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }


    public static boolean equals(AttributeSetInstanceCommand.CreateAttributeSetInstance instance1,
                                 AttributeSetInstanceState instance2) {
        if (!propertyEquals(instance1.getAttributeSetId(), instance2.getAttributeSetId())
                || !propertyEquals(instance1.getOrganizationId(), instance2.getOrganizationId())
                || !propertyEquals(instance1.getReferenceId(), instance2.getReferenceId())
                || !propertyEquals(instance1.getSerialNumber(), instance2.getSerialNumber())
                || !propertyEquals(instance1.getLotId(), instance2.getLotId())
                || !propertyEquals(instance1.getStatusId(), instance2.getStatusId())
                || !propertyEquals(instance1.getImageUrl(), instance2.getImageUrl())
                || !propertyEquals(instance1.getDescription(), instance2.getDescription())
                || !propertyEquals(instance1.getActive(), instance2.getActive())
                || !propertyEquals(instance1.getWidthInch(), instance2.getWidthInch())
                || !propertyEquals(instance1.getDiameterInch(), instance2.getDiameterInch())
                || !propertyEquals(instance1.getWeightLbs(), instance2.getWeightLbs())
                || !propertyEquals(instance1.getWeightKg(), instance2.getWeightKg())
                || !propertyEquals(instance1.getAirDryWeightLbs(), instance2.getAirDryWeightLbs())
                || !propertyEquals(instance1.getAirDryWeightKg(), instance2.getAirDryWeightKg())
                || !propertyEquals(instance1.getAirDryMetricTon(), instance2.getAirDryMetricTon())
                || !propertyEquals(instance1.getPackageCount(), instance2.getPackageCount())
                || !propertyEquals(instance1.getAirDryPct(), instance2.getAirDryPct())
                || !propertyEquals(instance1.get_F_B_0_(), instance2.get_F_B_0_())
                || !propertyEquals(instance1.get_F_I_0_(), instance2.get_F_I_0_())
                || !propertyEquals(instance1.get_F_L_0_(), instance2.get_F_L_0_())
                || !propertyEquals(instance1.get_F_DT_0_(), instance2.get_F_DT_0_())
                || !propertyEquals(instance1.get_F_N_0_(), instance2.get_F_N_0_())
                || !propertyEquals(instance1.get_F_C5_0_(), instance2.get_F_C5_0_())
                || !propertyEquals(instance1.get_F_C10_0_(), instance2.get_F_C10_0_())
                || !propertyEquals(instance1.get_F_C20_0_(), instance2.get_F_C20_0_())
                || !propertyEquals(instance1.get_F_C50_0_(), instance2.get_F_C50_0_())
                || !propertyEquals(instance1.get_F_C100_0_(), instance2.get_F_C100_0_())
                || !propertyEquals(instance1.get_F_C200_0_(), instance2.get_F_C200_0_())
                || !propertyEquals(instance1.get_F_C500_0_(), instance2.get_F_C500_0_())
                || !propertyEquals(instance1.get_F_C1000_0_(), instance2.get_F_C1000_0_())
                || !propertyEquals(instance1.get_F_B_1_(), instance2.get_F_B_1_())
                || !propertyEquals(instance1.get_F_I_1_(), instance2.get_F_I_1_())
                || !propertyEquals(instance1.get_F_L_1_(), instance2.get_F_L_1_())
                || !propertyEquals(instance1.get_F_DT_1_(), instance2.get_F_DT_1_())
                || !propertyEquals(instance1.get_F_N_1_(), instance2.get_F_N_1_())
                || !propertyEquals(instance1.get_F_C5_1_(), instance2.get_F_C5_1_())
                || !propertyEquals(instance1.get_F_C10_1_(), instance2.get_F_C10_1_())
                || !propertyEquals(instance1.get_F_C20_1_(), instance2.get_F_C20_1_())
                || !propertyEquals(instance1.get_F_C50_1_(), instance2.get_F_C50_1_())
                || !propertyEquals(instance1.get_F_C100_1_(), instance2.get_F_C100_1_())
                || !propertyEquals(instance1.get_F_C200_1_(), instance2.get_F_C200_1_())
                || !propertyEquals(instance1.get_F_B_2_(), instance2.get_F_B_2_())
                || !propertyEquals(instance1.get_F_I_2_(), instance2.get_F_I_2_())
                || !propertyEquals(instance1.get_F_L_2_(), instance2.get_F_L_2_())
                || !propertyEquals(instance1.get_F_DT_2_(), instance2.get_F_DT_2_())
                || !propertyEquals(instance1.get_F_N_2_(), instance2.get_F_N_2_())
                || !propertyEquals(instance1.get_F_C5_2_(), instance2.get_F_C5_2_())
                || !propertyEquals(instance1.get_F_C10_2_(), instance2.get_F_C10_2_())
                || !propertyEquals(instance1.get_F_C20_2_(), instance2.get_F_C20_2_())
                || !propertyEquals(instance1.get_F_C50_2_(), instance2.get_F_C50_2_())
                || !propertyEquals(instance1.get_F_B_3_(), instance2.get_F_B_3_())
                || !propertyEquals(instance1.get_F_I_3_(), instance2.get_F_I_3_())
                || !propertyEquals(instance1.get_F_L_3_(), instance2.get_F_L_3_())
                || !propertyEquals(instance1.get_F_DT_3_(), instance2.get_F_DT_3_())
                || !propertyEquals(instance1.get_F_N_3_(), instance2.get_F_N_3_())
                || !propertyEquals(instance1.get_F_C5_3_(), instance2.get_F_C5_3_())
                || !propertyEquals(instance1.get_F_C10_3_(), instance2.get_F_C10_3_())
                || !propertyEquals(instance1.get_F_C20_3_(), instance2.get_F_C20_3_())
                || !propertyEquals(instance1.get_F_C50_3_(), instance2.get_F_C50_3_())
                || !propertyEquals(instance1.get_F_B_4_(), instance2.get_F_B_4_())
                || !propertyEquals(instance1.get_F_I_4_(), instance2.get_F_I_4_())
                || !propertyEquals(instance1.get_F_L_4_(), instance2.get_F_L_4_())
                || !propertyEquals(instance1.get_F_DT_4_(), instance2.get_F_DT_4_())
                || !propertyEquals(instance1.get_F_N_4_(), instance2.get_F_N_4_())
                || !propertyEquals(instance1.get_F_C5_4_(), instance2.get_F_C5_4_())
                || !propertyEquals(instance1.get_F_C10_4_(), instance2.get_F_C10_4_())
                || !propertyEquals(instance1.get_F_C20_4_(), instance2.get_F_C20_4_())
                || !propertyEquals(instance1.get_F_C50_4_(), instance2.get_F_C50_4_())
            )
        {
            return false; 
        }
        return true;
    }

    private static boolean propertyEquals(Object p1, Object p2) {
        if (p1 == p2) {
            return true;
        }
        if (p1 == null) {
            return false;
        }
        return p1.equals(p2);
    }

}


