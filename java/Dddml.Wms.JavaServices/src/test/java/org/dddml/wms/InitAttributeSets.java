package org.dddml.wms;

import org.dddml.wms.domain.attribute.AbstractAttributeCommand;
import org.dddml.wms.domain.attribute.AttributeApplicationService;
import org.dddml.wms.domain.attribute.AttributeCommand;
import org.dddml.wms.domain.attribute.AttributeValueCommand;
import org.dddml.wms.domain.attributeset.AbstractAttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeUseCommand;
import org.dddml.wms.specialization.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangjiefeng on 2018/1/30.
 */
public class InitAttributeSets {

    public static final String FLUFF_PULP_ATTR_SET_ID = "FluffPulpAttrSet";

    public static final String KRAFT_LINERBOARD_ATTR_SET_ID = "KraftLinerboardAttrSet";

    static final String[][] FLUFF_PULP_ATTRS = new String[][]{
            // 序列号（卷号）。
            //public string SerialNumber { get; set; }
            new String[]{"widthInch", "Decimal"},
            new String[]{"diameterInch", "Decimal"},
            new String[]{"weightLbs", "Decimal"},
            //new String[]{"WeightKg", "Decimal", "true"},//isMandatory
            new String[]{"airDryWeightLbs", "Decimal"},
            new String[]{"airDryWeightKg", "Decimal"},
            new String[]{"airDryMetricTon", "Decimal"},
            new String[]{"packageCount", "Decimal"},
            new String[]{"airDryPct", "Int32"},
    };

    static final String ATTR_QUALITY_STATUS_ID = "QualityStatus";

    static final String[][] ATTR_QUALITY_STATUS_VALUES = new String[][] {
            new String[]{"M-G", "单货相符，质量完好"},
            new String[]{"M-NG", "单货相符，质量缺陷"},
            new String[]{"UM-G", "单货不符，质量完好"},
            new String[]{"UM-NG", "单货不符，质量缺陷"}
    };

    static final String[][] KRAFT_LINERBOARD_ATTRS = new String[][]{
            new String[]{"SecondaryUomQuantity", "Decimal", "false", "_F_N_0_"},// 次计量单位数量
    };

    static AttributeApplicationService attributeApplicationService;

    static AttributeSetApplicationService attributeSetApplicationService;

    public static void createDefaultAttributeSets() {
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");

        // create Fluff Pulp AttributeSet
        List<AttributeCommand.CreateAttribute> fpAttrs = createAttributes(FLUFF_PULP_ATTRS);
        fpAttrs.add(createQualityStatusAttribute());
        List<AttributeSetCommand.CreateAttributeSet> fpAttrSets = Arrays.asList(createAttributeSet(FLUFF_PULP_ATTR_SET_ID, fpAttrs));
        save(fpAttrs, fpAttrSets);

        //create KRAFT_LINERBOARD_ATTRS
        List<AttributeCommand.CreateAttribute> klbAttrs = createAttributes(KRAFT_LINERBOARD_ATTRS);
        klbAttrs.add(createQualityStatusAttribute());
        List<AttributeSetCommand.CreateAttributeSet> klbAttrSets = Arrays.asList(createAttributeSet(KRAFT_LINERBOARD_ATTR_SET_ID, klbAttrs));
        save(klbAttrs, klbAttrSets);

    }

    private static AttributeCommand.CreateAttribute createQualityStatusAttribute() {
        AttributeCommand.CreateAttribute a = new AbstractAttributeCommand.SimpleCreateAttribute();
        a.setAttributeId(ATTR_QUALITY_STATUS_ID);
        a.setAttributeName("质量情况");
        a.setActive(true);
        a.setIsMandatory(true);
        a.setAttributeValueType("String");
        //a.setAttributeValueLength();
        a.setFieldName("_F_C10_3_");//占用一个扩展字段
        for (String[] vs : ATTR_QUALITY_STATUS_VALUES) {
            AttributeValueCommand.CreateAttributeValue v = a.newCreateAttributeValue();
            v.setValue(vs[0]);
            v.setAttributeValueName(vs[1]);
            v.setActive(true);
            a.getAttributeValues().add(v);
        }
        return a;
    }

    private static List<AttributeCommand.CreateAttribute> createAttributes(String[][] attrArray){
        List<AttributeCommand.CreateAttribute> attrs = new ArrayList<>();
        for(String[] attrInfo : attrArray) {
            AttributeCommand.CreateAttribute a = new AbstractAttributeCommand.SimpleCreateAttribute();
            a.setAttributeId(attrInfo[0]);
            a.setAttributeName(a.getAttributeId());
            a.setActive(true);
            a.setAttributeValueType(attrInfo[1]);
            if (attrInfo.length > 2) {
                a.setIsMandatory(Boolean.parseBoolean(attrInfo[2]));
            }
            if(attrInfo.length > 3) {
                a.setFieldName(attrInfo[3]);//占用一个扩展字段，比如 _F_C10_3_, _F_N_0_ 等等
            }
            attrs.add(a);
        }
        return attrs;
    }

    private static AttributeSetCommand.CreateAttributeSet createAttributeSet(String attrSetId, List<AttributeCommand.CreateAttribute> attrs) {
        AttributeSetCommand.CreateAttributeSet attrSet = new AbstractAttributeSetCommand.SimpleCreateAttributeSet();
        attrSet.setAttributeSetId(attrSetId);
        attrSet.setAttributeSetName(attrSet.getAttributeSetId());
        attrSet.setActive(true);
        for (AttributeCommand.CreateAttribute a : attrs) {
            AttributeUseCommand.CreateAttributeUse attrUse = attrSet.newCreateAttributeUse();
            attrUse.setAttributeId(a.getAttributeId());
            attrUse.setActive(true);
            attrSet.getAttributeUses().add(attrUse);
        }
        return attrSet;
    }


    private static void save(List<AttributeCommand.CreateAttribute> attrs, List<AttributeSetCommand.CreateAttributeSet> attrSets) {
        for (AttributeCommand.CreateAttribute a : attrs) {
            if (a.getFieldName() == null) {//这些属性都存在同名的字段（列）
                String attrId = a.getAttributeId();
                String fieldName = attrId.substring(0, 1).toLowerCase() + attrId.substring(1);
                a.setFieldName(fieldName);
            }
            a.setCommandId(a.getAttributeId()); // 幂等命令
            attributeApplicationService.when(a);
        }
        for (AttributeSetCommand.CreateAttributeSet attrSet : attrSets) {
            attrSet.setCommandId(attrSet.getAttributeSetId()); // 幂等命令
            attributeSetApplicationService.when(attrSet);
        }
    }


}
