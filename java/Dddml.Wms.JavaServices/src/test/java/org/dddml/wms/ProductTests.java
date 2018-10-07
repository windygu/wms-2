package org.dddml.wms;

import org.dddml.wms.domain.attribute.AbstractAttributeCommand;
import org.dddml.wms.domain.attribute.AttributeApplicationService;
import org.dddml.wms.domain.attribute.AttributeCommand;
import org.dddml.wms.domain.attribute.AttributeValueCommand;
import org.dddml.wms.domain.attributeset.AbstractAttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetCommand;
import org.dddml.wms.domain.attributeset.AttributeUseCommand;
import org.dddml.wms.domain.product.AbstractProductCommand;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductCommand;
import org.dddml.wms.specialization.ApplicationContext;

import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/2/2.
 */
public class ProductTests {


    private ProductApplicationService productApplicationService;

    private AttributeSetApplicationService attributeSetApplicationService;

    private AttributeApplicationService attributeApplicationService;

    public void setUp() {
        productApplicationService = (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");
    }

    public void testCreateAttributesAndProducts() {
        testCreateAttributeSetAndProduct_0();
    }

    private void testCreateAttributeSetAndProduct_0() {
        String attributeSetId_0 = createAttributeSet_0();
        ProductCommand.CreateProduct prd_0 = createProduct_0(attributeSetId_0);

        // ////////////////////
        createProduct_1();
    }

    private String createAttributeSet_0() {
        String colorAttrId = createRgbColorAttribute();
        String sizeAttrId = createSizeAttribute();
        AttributeSetCommand.CreateAttributeSet attrSet = new AbstractAttributeSetCommand.SimpleCreateAttributeSet();
        attrSet.setAttributeSetId("TShirtAttrSet");
        attrSet.setAttributeSetName("TShirt Attribute Set");
        attrSet.setCommandId(attrSet.getAttributeSetId());
        AttributeUseCommand.CreateAttributeUse useColor = attrSet.newCreateAttributeUse();
        useColor.setAttributeId(colorAttrId);
        useColor.setActive(true);
        attrSet.getCreateAttributeUseCommands().add(useColor);
        AttributeUseCommand.CreateAttributeUse useSize = attrSet.newCreateAttributeUse();
        useSize.setAttributeId(sizeAttrId);
        useSize.setActive(true);
        attrSet.getCreateAttributeUseCommands().add(useSize);
        attributeSetApplicationService.when(attrSet);
        return  attrSet.getAttributeSetId();
    }

    private String createSizeAttribute() {
        AttributeCommand.CreateAttribute sizeAttr = new AbstractAttributeCommand.SimpleCreateAttribute();
        sizeAttr.setAttributeId("Size");
        sizeAttr.setAttributeName("Size");
        sizeAttr.setAttributeValueType("string");
        sizeAttr.setAttributeValueLength(10);
        sizeAttr.setFieldName("_F_C10_1_");//占用一个扩展字段
        sizeAttr.setActive(true);
        sizeAttr.setIsMandatory(true);
        sizeAttr.setIsList(true);
        sizeAttr.setCommandId(sizeAttr.getAttributeId());
        AttributeValueCommand.CreateAttributeValue s = sizeAttr.newCreateAttributeValue();
        s.setValue("S");
        s.setActive(true);
        s.setAttributeValueName("S");
        sizeAttr.getCreateAttributeValueCommands().add(s);
        AttributeValueCommand.CreateAttributeValue m = sizeAttr.newCreateAttributeValue();
        m.setValue("M");
        m.setActive(true);
        m.setAttributeValueName("M");
        sizeAttr.getCreateAttributeValueCommands().add(m);
        AttributeValueCommand.CreateAttributeValue l = sizeAttr.newCreateAttributeValue();
        l.setValue("L");
        l.setActive(true);
        l.setAttributeValueName("L");
        sizeAttr.getCreateAttributeValueCommands().add(l);
        attributeApplicationService.when(sizeAttr);
        return sizeAttr.getAttributeId();
    }

    private String createRgbColorAttribute() {
        AttributeCommand.CreateAttribute colorAttr = new AbstractAttributeCommand.SimpleCreateAttribute();
        colorAttr.setAttributeId("RgbColor");
        colorAttr.setAttributeName("RGB Color");
        colorAttr.setAttributeValueType("string");
        colorAttr.setAttributeValueLength(10);
        colorAttr.setFieldName("_F_C10_0_");//占用一个扩展字段
        colorAttr.setActive(true);
        colorAttr.setIsMandatory(true);
        colorAttr.setIsList(true);
        colorAttr.setCommandId(colorAttr.getAttributeId());
        AttributeValueCommand.CreateAttributeValue r = colorAttr.newCreateAttributeValue();
        r.setValue("R");
        r.setActive(true);
        r.setAttributeValueName("Red");
        colorAttr.getCreateAttributeValueCommands().add(r);
        AttributeValueCommand.CreateAttributeValue g = colorAttr.newCreateAttributeValue();
        g.setValue("G");
        g.setActive(true);
        g.setAttributeValueName("Green");
        colorAttr.getCreateAttributeValueCommands().add(g);
        AttributeValueCommand.CreateAttributeValue b = colorAttr.newCreateAttributeValue();
        b.setValue("B");
        b.setActive(true);
        b.setAttributeValueName("Blue");
        colorAttr.getCreateAttributeValueCommands().add(b);
        attributeApplicationService.when(colorAttr);
        return colorAttr.getAttributeId();
    }

    private ProductCommand.CreateProduct createProduct_0(String attributeSetId) {
        ProductCommand.CreateProduct prd_0 = new AbstractProductCommand.SimpleCreateProduct();
        prd_0.setProductId("TShirt_" + new java.util.Date().getTime() + ""); //Guid.NewGuid().ToString();
        prd_0.setProductName("Test_" + prd_0.getProductId());
        prd_0.setAttributeSetId(attributeSetId);
        prd_0.setIsSerialNumbered(false);
        prd_0.setIsManagedByLot(false);
        //prd_1.QuantityUomId;
        prd_0.setCommandId(UUID.randomUUID().toString());

        productApplicationService.when(prd_0);
        return prd_0;
    }

    private ProductCommand.CreateProduct createProduct_1() {
        ProductCommand.CreateProduct prd_1 = new AbstractProductCommand.SimpleCreateProduct();
        prd_1.setProductId("MineralWater" + new java.util.Date().getTime() + ""); //Guid.NewGuid().ToString();
        prd_1.setProductName("Test_" + prd_1.getProductId());
        //prd_1.setAttributeSetId(attributeSetId);
        prd_1.setIsSerialNumbered(false);
        prd_1.setIsManagedByLot(true);
        //prd_1.QuantityUomId;
        prd_1.setCommandId(UUID.randomUUID().toString());
        productApplicationService.when(prd_1);
        return prd_1;
    }

}
