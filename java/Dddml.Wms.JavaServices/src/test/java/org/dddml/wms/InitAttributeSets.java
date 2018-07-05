package org.dddml.wms;

import org.dddml.wms.domain.attribute.AbstractAttributeCommand;
import org.dddml.wms.domain.attribute.AttributeApplicationService;
import org.dddml.wms.domain.attribute.AttributeCommand;
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

    static final String[][] FLUFF_PULP_ATTRS = new String[][]{
            // 序列号（卷号）。
            //public string SerialNumber { get; set; }
            new String[]{"WidthInch", "Decimal"},
            new String[]{"DiameterInch", "Decimal"},
            new String[]{"WeightLbs", "Decimal"},
            new String[]{"WeightKg", "Decimal", "true"},//isMandatory
            new String[]{"AirDryWeightLbs", "Decimal"},
            new String[]{"AirDryWeightKg", "Decimal"},
            new String[]{"AirDryMetricTon", "Decimal"},
            new String[]{"PackageCount", "Decimal"},
            new String[]{"AirDryPct", "Int32"},
    };

    static AttributeApplicationService attributeApplicationService;

    static AttributeSetApplicationService attributeSetApplicationService;

    public static void createDefaultAttributeSets() {
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");

        List<AttributeCommand.CreateAttribute> attrs = createFluffPulpAttributes();
        //List<CreateAttributeValue> attrVals;
        List<AttributeSetCommand.CreateAttributeSet> attrSets = Arrays.asList(createFluffPulpAttributeSet(attrs));
        //List<CreateAttributeUse> attrUses;

        save(attrs, attrSets);
    }

    private static List<AttributeCommand.CreateAttribute> createFluffPulpAttributes(){
        List<AttributeCommand.CreateAttribute> attrs = new ArrayList<>();
        for(String[] attrInfo : FLUFF_PULP_ATTRS) {
            AttributeCommand.CreateAttribute a = new AbstractAttributeCommand.SimpleCreateAttribute();
            a.setAttributeId(attrInfo[0]);
            a.setAttributeName(a.getAttributeId());
            a.setActive(true);
            a.setAttributeValueType(attrInfo[1]);
            if (attrInfo.length > 2) {
                a.setIsMandatory(Boolean.parseBoolean(attrInfo[2]));
            }
            attrs.add(a);
        }
        return attrs;
    }

    private static AttributeSetCommand.CreateAttributeSet createFluffPulpAttributeSet(List<AttributeCommand.CreateAttribute> attrs) {
        AttributeSetCommand.CreateAttributeSet attrSet = new AbstractAttributeSetCommand.SimpleCreateAttributeSet();
        attrSet.setAttributeSetId(FLUFF_PULP_ATTR_SET_ID);
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
            if (a.getFieldName() != null) {
                a.setFieldName(a.getAttributeId()); //这些属性都存在同名的字段（列）
            }
            a.setCommandId(a.getAttributeName()); // 幂等命令
            attributeApplicationService.when(a);
        }
        for (AttributeSetCommand.CreateAttributeSet attrSet : attrSets) {
            attrSet.setCommandId(attrSet.getAttributeSetId()); // 幂等命令
            attributeSetApplicationService.when(attrSet);
        }
    }


}
