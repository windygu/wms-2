package org.dddml.wms;

import org.dddml.wms.domain.attribute.AbstractAttributeCommand;
import org.dddml.wms.domain.attribute.AttributeApplicationService;
import org.dddml.wms.domain.attribute.AttributeCommand;
import org.dddml.wms.domain.attribute.AttributeValueCommand;
import org.dddml.wms.domain.attributeset.AbstractAttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeUseCommand;
import org.dddml.wms.domain.attributesetinstance.AbstractAttributeSetInstanceCommand;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceCommand;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.ReflectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangjiefeng on 2018/1/30.
 */
public class InitAttributeSets {

    public static final String FLUFF_PULP_PRODUCT_CATEGORY_ID ="FluffPulp";

    public static final String FSC_FIELD_NAME = "_F_C5_1_";

    public static final String SECONDARY_QUANTITY_UOM_FIELD_NAME = "_F_C5_0_";

    // ----------------- 属性集（产品的属性集、库存单元的属性集的 Id） ---------------------------

    public static final String FLUFF_PULP_ATTR_SET_ID = "FluffPulpAttrSet";

    public static final String KRAFT_LINERBOARD_ATTR_SET_ID = "KraftLinerboardAttrSet";

    public static final String CORRUGATED_PAPER_ATTR_SET_ID = "CorrugatedPaperAttrSet";

    public static final String KRAFT_LINERBOARD_PRODUCT_ATTR_SET_ID = "KLBProductAttrSet";

    public static final String CORRUGATED_PAPER_PRODUCT_ATTR_SET_ID = "CPProductAttrSet";

    public static final String FLUFF_PULP_PRODUCT_ATTR_SET_ID ="FluffPulpProductAttrSet";


    // ------------------------- 库存单元属性集的属性 -----------------------------

    static final String[][] FLUFF_PULP_ATTRS = new String[][]{
            // 序列号（卷号）。
            //public string SerialNumber { get; set; }
            //new String[]{"widthInch", "Decimal"},
            //new String[]{"diameterInch", "Decimal"},
            new String[]{"weightLbs", "Decimal"},
            //new String[]{"WeightKg", "Decimal", "true"},//isMandatory
            new String[]{"airDryWeightLbs", "Decimal"},
            new String[]{"airDryWeightKg", "Decimal"},
            new String[]{"airDryMetricTon", "Decimal"},
            new String[]{"rollCnt", "Decimal"},
            new String[]{"airDryPct", "Int32"},
    };

    static final String[][] KRAFT_LINERBOARD_ATTRS = new String[][]{
            new String[]{"SecondaryUomQuantity", "Decimal", "false", "_F_N_0_"},// 次计量单位数量
    };

    static final String[][] CORRUGATED_PAPER_ATTRS = new String[][]{
            new String[]{"SecondaryUomQuantity", "Decimal", "false", "_F_N_0_"},// 次计量单位数量
    };

    static final String ATTR_PO_REFERENCE_ID = "POReference";

    public static final String PO_REFERENCE_FIELD_NAME = "_F_C20_3_";

    private static AttributeCommand.CreateAttribute createPOReferenceAttribute() {
        AttributeCommand.CreateAttribute a = new AbstractAttributeCommand.SimpleCreateAttribute();
        a.setAttributeId(ATTR_PO_REFERENCE_ID);
        a.setAttributeName("POReference");
        a.setActive(true);
        a.setIsMandatory(true);
        a.setAttributeValueType("String");
        a.setAttributeValueLength(20);
        a.setFieldName(PO_REFERENCE_FIELD_NAME);//占用一个扩展字段
        return a;
    }

    /*
    static final String ATTR_QUALITY_STATUS_ID = "QualityStatus";

    static final String[][] ATTR_QUALITY_STATUS_VALUES = new String[][] {
            new String[]{"M-G", "单货相符，质量完好"},
            new String[]{"M-NG", "单货相符，质量缺陷"},
            new String[]{"UM-G", "单货不符，质量完好"},
            new String[]{"UM-NG", "单货不符，质量缺陷"}
    };

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
    */

    // ---------------------------- 产品的属性集实例的 Id --------------------------

    static final String KLB_SECONDARY_QTY_UOM_M_FSC_NO_ATTR_SET_INST_ID = "KLBSecondaryQtyUom:M-FSC:NO";

    static final String CP_SECONDARY_QTY_UOM_M_FSC_YES_ATTR_SET_INST_ID = "CPSecondaryQtyUom:M-FSC:YES";

    //static final String FP_SECONDARY_QTY_UOM_ADMT_FSC_NO_ATTR_SET_INST_ID = "FPSecondaryQtyUom:ADMT-FSC:NO";
    static final String FP_SECONDARY_QTY_UOM_ADMT_ATTR_SET_INST_ID = "FPSecondaryQtyUom:ADMT";



    static AttributeApplicationService attributeApplicationService;

    static AttributeSetApplicationService attributeSetApplicationService;

    static AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;

    public static void createDefaultAttributeSets() {
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");
        attributeSetInstanceApplicationService = (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");

        // 牛卡纸库存单元属性集
        List<AttributeCommand.CreateAttribute> klbAttrs = createAttributes(KRAFT_LINERBOARD_ATTRS);
        //klbAttrs.add(createQualityStatusAttribute());
        klbAttrs.add(createPOReferenceAttribute());
        AttributeSetCommand.CreateAttributeSet klbAttrSet = createAttributeSet(KRAFT_LINERBOARD_ATTR_SET_ID,
                klbAttrs.stream().map(a -> a.getAttributeId()).toArray(String[]::new));
        save(klbAttrs, Collections.singletonList(klbAttrSet));

        // 瓦楞纸库存单元属性集
        List<AttributeCommand.CreateAttribute> cpAttrs = createAttributes(CORRUGATED_PAPER_ATTRS);
        //cpAttrs.add(createQualityStatusAttribute());
        cpAttrs.add(createPOReferenceAttribute());
        AttributeSetCommand.CreateAttributeSet cpAttrSet = createAttributeSet(CORRUGATED_PAPER_ATTR_SET_ID,
                cpAttrs.stream().map(a -> a.getAttributeId()).toArray(String[]::new));
        save(cpAttrs, Collections.singletonList(cpAttrSet));

        // 绒毛浆库存单元属性集
        // create Fluff Pulp AttributeSet
        List<AttributeCommand.CreateAttribute> fpAttrs = createAttributes(FLUFF_PULP_ATTRS);
        //fpAttrs.add(createQualityStatusAttribute());
        fpAttrs.add(createPOReferenceAttribute());
        AttributeSetCommand.CreateAttributeSet fpAttrSet = createAttributeSet(FLUFF_PULP_ATTR_SET_ID,
                fpAttrs.stream().map(a -> a.getAttributeId()).toArray(String[]::new));
        save(fpAttrs, Collections.singletonList(fpAttrSet));


        // ------------------------------产品属性集以及相关实例 -----------------------------
        //牛卡纸产品属性集
        String sqUomAttrId = createSecondaryQuantityUomAttribute();//次计量单位属性
        String fscAttrId = createFscAttribute();//FSC 认证属性
        AttributeSetCommand.CreateAttributeSet klbPrdAttrSet = createAttributeSet(KRAFT_LINERBOARD_PRODUCT_ATTR_SET_ID,
                new String[]{sqUomAttrId, fscAttrId});
        saveAttributeSet(klbPrdAttrSet);
        //创建牛卡纸产品属性集实例
        AttributeSetInstanceCommand.CreateAttributeSetInstance secondaryQtyUomMAndFscNoAttrSetInst = createKlbSecondaryQtyUomMAndFscNoAttrSetInst();
        attributeSetInstanceApplicationService.when(secondaryQtyUomMAndFscNoAttrSetInst);

        // -----------------------------------------------------------
        //瓦楞纸产品属性集
        AttributeSetCommand.CreateAttributeSet cpPrdAttrSet = createAttributeSet(CORRUGATED_PAPER_PRODUCT_ATTR_SET_ID,
                new String[]{sqUomAttrId, fscAttrId});
        saveAttributeSet(cpPrdAttrSet);
        //创建瓦楞纸产品属性集实例
        AttributeSetInstanceCommand.CreateAttributeSetInstance secondaryQtyUomMAndFscYesAttrSetInst = createCpSecondaryQtyUomMAndFscYesAttrSetInst();
        attributeSetInstanceApplicationService.when(secondaryQtyUomMAndFscYesAttrSetInst);

        // -----------------------------------------------------------
        //绒毛浆产品属性集
        //AttributeSetCommand.CreateAttributeSet fpPrdAttrSet = createAttributeSet(FLUFF_PULP_PRODUCT_ATTR_SET_ID,
        //        new String[]{sqUomAttrId, fscAttrId});
        AttributeSetCommand.CreateAttributeSet fpPrdAttrSet = createAttributeSet(FLUFF_PULP_PRODUCT_ATTR_SET_ID,
                new String[]{sqUomAttrId});
        saveAttributeSet(fpPrdAttrSet);
        //创建绒毛浆产品属性集实例
        //AttributeSetInstanceCommand.CreateAttributeSetInstance secondaryQtyUomAdtmAndFscNoAttrSetInst = createFpSecondaryQtyUomAdtmAndFscNoAttrSetInst();
        //attributeSetInstanceApplicationService.when(secondaryQtyUomAdtmAndFscNoAttrSetInst);
        AttributeSetInstanceCommand.CreateAttributeSetInstance secondaryQtyUomAdtmAttrSetInst = createFpSecondaryQtyUomAdtmAttrSetInst();
        attributeSetInstanceApplicationService.when(secondaryQtyUomAdtmAttrSetInst);

    }

    private static AttributeSetInstanceCommand.CreateAttributeSetInstance createKlbSecondaryQtyUomMAndFscNoAttrSetInst() {
        AttributeSetInstanceCommand.CreateAttributeSetInstance attrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        String attributeSetInstanceId = KLB_SECONDARY_QTY_UOM_M_FSC_NO_ATTR_SET_INST_ID;
        attrSetInst.setAttributeSetInstanceId(attributeSetInstanceId);
        attrSetInst.setAttributeSetId(KRAFT_LINERBOARD_PRODUCT_ATTR_SET_ID);
        ReflectUtils.setPropertyValue(SECONDARY_QUANTITY_UOM_FIELD_NAME, attrSetInst, "M");
        ReflectUtils.setPropertyValue(FSC_FIELD_NAME, attrSetInst, "N");
        attrSetInst.setActive(true);
        attrSetInst.setCommandId(attrSetInst.getAttributeSetInstanceId());
        return attrSetInst;
    }

    private static AttributeSetInstanceCommand.CreateAttributeSetInstance createCpSecondaryQtyUomMAndFscYesAttrSetInst() {
        AttributeSetInstanceCommand.CreateAttributeSetInstance attrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        String attributeSetInstanceId = CP_SECONDARY_QTY_UOM_M_FSC_YES_ATTR_SET_INST_ID;
        attrSetInst.setAttributeSetInstanceId(attributeSetInstanceId);
        attrSetInst.setAttributeSetId(CORRUGATED_PAPER_PRODUCT_ATTR_SET_ID);
        ReflectUtils.setPropertyValue(SECONDARY_QUANTITY_UOM_FIELD_NAME, attrSetInst, "M");
        ReflectUtils.setPropertyValue(FSC_FIELD_NAME, attrSetInst, "Y");
        attrSetInst.setActive(true);
        attrSetInst.setCommandId(attrSetInst.getAttributeSetInstanceId());
        return attrSetInst;
    }

    private static AttributeSetInstanceCommand.CreateAttributeSetInstance createFpSecondaryQtyUomAdtmAttrSetInst() {
        AttributeSetInstanceCommand.CreateAttributeSetInstance attrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        String attributeSetInstanceId = FP_SECONDARY_QTY_UOM_ADMT_ATTR_SET_INST_ID;
        attrSetInst.setAttributeSetInstanceId(attributeSetInstanceId);
        attrSetInst.setAttributeSetId(FLUFF_PULP_PRODUCT_ATTR_SET_ID);
        ReflectUtils.setPropertyValue(SECONDARY_QUANTITY_UOM_FIELD_NAME, attrSetInst, "ADMT");
        //ReflectUtils.setPropertyValue(FSC_FIELD_NAME, attrSetInst, "N");
        attrSetInst.setActive(true);
        attrSetInst.setCommandId(attrSetInst.getAttributeSetInstanceId());
        return attrSetInst;
    }

    //    private static AttributeSetInstanceCommand.CreateAttributeSetInstance createFpSecondaryQtyUomAdtmAndFscNoAttrSetInst() {
    //        AttributeSetInstanceCommand.CreateAttributeSetInstance attrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
    //        String attributeSetInstanceId = FP_SECONDARY_QTY_UOM_ADMT_FSC_NO_ATTR_SET_INST_ID;
    //        attrSetInst.setAttributeSetInstanceId(attributeSetInstanceId);
    //        attrSetInst.setAttributeSetId(FLUFF_PULP_PRODUCT_ATTR_SET_ID);
    //        ReflectUtils.setPropertyValue(SECONDARY_QUANTITY_UOM_FIELD_NAME, attrSetInst, "ADMT");
    //        ReflectUtils.setPropertyValue(FSC_FIELD_NAME, attrSetInst, "N");
    //        attrSetInst.setActive(true);
    //        attrSetInst.setCommandId(attrSetInst.getAttributeSetInstanceId());
    //        return attrSetInst;
    //    }



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

    private static AttributeSetCommand.CreateAttributeSet createAttributeSet(String attrSetId, String[] attrIds) {
        AttributeSetCommand.CreateAttributeSet attrSet = new AbstractAttributeSetCommand.SimpleCreateAttributeSet();
        attrSet.setAttributeSetId(attrSetId);
        if (attrSet.getAttributeSetName() == null) {
            attrSet.setAttributeSetName(attrSet.getAttributeSetId());
        }
        attrSet.setActive(true);
        for (String a : attrIds) {
            AttributeUseCommand.CreateAttributeUse attrUse = attrSet.newCreateAttributeUse();
            attrUse.setAttributeId(a);
            attrUse.setActive(true);
            attrSet.getAttributeUses().add(attrUse);
        }
        return attrSet;
    }

    private static String createSecondaryQuantityUomAttribute() {
        AttributeCommand.CreateAttribute sqUomAttr = new AbstractAttributeCommand.SimpleCreateAttribute();
        sqUomAttr.setAttributeId("SecondaryQuantityUom");
        sqUomAttr.setAttributeName("Secondary Quantity Uom");
        sqUomAttr.setAttributeValueType("string");
        sqUomAttr.setAttributeValueLength(5);
        sqUomAttr.setFieldName(SECONDARY_QUANTITY_UOM_FIELD_NAME);//占用一个扩展字段
        sqUomAttr.setActive(true);
        sqUomAttr.setIsMandatory(true);
        //sqUomAttr.setIsList(false);
        sqUomAttr.setCommandId(sqUomAttr.getAttributeId());
        attributeApplicationService.when(sqUomAttr);
        return sqUomAttr.getAttributeId();
    }

    private static String createFscAttribute() {
        AttributeCommand.CreateAttribute fscAttr = new AbstractAttributeCommand.SimpleCreateAttribute();
        fscAttr.setAttributeId("FSC");
        fscAttr.setAttributeName("FSC");
        fscAttr.setAttributeValueType("string");
        fscAttr.setAttributeValueLength(5);
        fscAttr.setFieldName(FSC_FIELD_NAME);//占用一个扩展字段
        fscAttr.setActive(true);
        fscAttr.setIsMandatory(true);
        fscAttr.setIsList(true);
        fscAttr.setCommandId(fscAttr.getAttributeId());
        AttributeValueCommand.CreateAttributeValue y = fscAttr.newCreateAttributeValue();
        y.setValue("Y");
        y.setActive(true);
        y.setAttributeValueName("Yes");
        fscAttr.getAttributeValues().add(y);
        AttributeValueCommand.CreateAttributeValue n = fscAttr.newCreateAttributeValue();
        n.setValue("N");
        n.setActive(true);
        n.setAttributeValueName("No");
        fscAttr.getAttributeValues().add(n);
        attributeApplicationService.when(fscAttr);
        return fscAttr.getAttributeId();
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
            saveAttributeSet(attrSet);
        }
    }

    private static void saveAttributeSet(AttributeSetCommand.CreateAttributeSet attrSet) {
        attrSet.setCommandId(attrSet.getAttributeSetId()); // 幂等命令
        attributeSetApplicationService.when(attrSet);
    }


}
