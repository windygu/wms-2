package org.dddml.wms;

import org.dddml.wms.domain.attribute.AttributeApplicationService;
import org.dddml.wms.domain.attribute.AttributeCommand;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetCommand;
import org.dddml.wms.specialization.ApplicationContext;

import java.util.List;

/**
 * Created by yangjiefeng on 2018/1/30.
 */
public class InitAttributeSets {

    static final String FLUFF_PULP_ATTR_SET_ID = "FluffPulpAttrSet";

    static final String[][] FLUFF_PULP_ATTRS = new String[][]{
            // 序列号（卷号）。
            //public string SerialNumber { get; set; }
            new String[]{"WidthInch", "Decimal"},
            new String[]{"DiameterInch", "Decimal"},
            new String[]{"WeightLbs", "Decimal"},
            new String[]{"WeightKg", "Decimal"},
            new String[]{"AirDryWeightLbs", "Decimal"},
            new String[]{"AirDryWeightKg", "Decimal"},
            new String[]{"AirDryMetricTon", "Decimal"},
            new String[]{"PackageCount", "Decimal"},
            new String[]{"AirDryPct", "Int32"},
    };

    static AttributeApplicationService attributeApplicationService;

    static AttributeSetApplicationService attributeSetApplicationService;

    public static void CreateDefaultAttributeSets() {
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");

        List<AttributeCommand.CreateAttribute> attrs = null;//todo
        //List<CreateAttributeValue> attrVals;
        List<AttributeSetCommand.CreateAttributeSet> attrSets = null;//todo
        //List<CreateAttributeUse> attrUses;

        save(attrs, attrSets);
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
