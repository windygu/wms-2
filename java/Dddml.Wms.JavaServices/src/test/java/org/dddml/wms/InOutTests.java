package org.dddml.wms;

import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.inventoryitem.InventoryItemIds;
import org.dddml.wms.domain.product.AbstractProductCommand;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductCommand;
import org.dddml.wms.domain.uom.UomIds;
import org.dddml.wms.specialization.ApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/2/2.
 */
public class InOutTests {

    public static final String TEST_WAREHOUSE_ID = "TEST";
    public static final String TEST_LOCATOR_ID_1 = "TEST_1";
    public static final String TEST_LOCATOR_ID_1_RECEIVING_AREA = "TEST_1-RECEIVING_AREA";
    public static final String  TEST_LOCATOR_ID_2 = "TEST_2";

    private ProductApplicationService productApplicationService;

    private AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;

    private InOutApplicationService inOutApplicationService;

    public void setUp() {
        productApplicationService = (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
        attributeSetInstanceApplicationService = (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
        inOutApplicationService = (InOutApplicationService) ApplicationContext.current.get("inOutApplicationService");
    }

    public void testInThenOut() {
        String prdId = getTestProductId2();
        String inDocumentNumber = createInOutForTest(inOutApplicationService, DocumentTypeIds.IN, prdId, BigDecimal.valueOf(123));
        completeInOut(inDocumentNumber);
        testInThenOut_Out(prdId);
    }

    private void testInThenOut_Out(String prdId) {
        String outDocumentNumber = createInOutForTest2(inOutApplicationService, DocumentTypeIds.OUT, prdId, BigDecimal.valueOf(-123));
        completeInOut(outDocumentNumber);
    }

    public void testCreateAndCompleteAndReverseInOut() {
        String documentNumber_1 = testCreateAndComplateInOut_0();
        testReverseInOut(documentNumber_1);
        // //////////////////
        testCreateInOutAndAddLine_0();
    }

    private static void testReverseInOut(String documentNumber) {
        InOutCommands.Reverse reverse = new InOutCommands.Reverse();
        reverse.setCommandId(UUID.randomUUID().toString());
        reverse.setVersion(1L);
        reverse.setDocumentNumber(documentNumber);
        InOutApplicationService inOutApplicationService = (InOutApplicationService) ApplicationContext.current.get("inOutApplicationService");
        inOutApplicationService.when(reverse);
    }

    private String testCreateInOutAndAddLine_0() {
        String documentNumber = createInOutForTest(inOutApplicationService, DocumentTypeIds.IN_OUT, getTestProductId2(), BigDecimal.valueOf(123));

        InOutState inOut_1 = inOutApplicationService.get(documentNumber);

        String prdId = new java.util.Date().getTime() + "";
        ProductCommand.CreateProduct prd_1 = createFPProduct_1(prdId);

        InOutCommands.AddLine addLine = new InOutCommands.AddLine();
        addLine.setDocumentNumber(documentNumber);
        addLine.setLineNumber(new java.util.Date().getTime() + "");
        addLine.setVersion(inOut_1.getVersion());
        addLine.setCommandId(UUID.randomUUID().toString());
        addLine.setProductId(prd_1.getProductId());
        addLine.setLocatorId(TEST_LOCATOR_ID_1);
        //addLine.setQuantityUomId();
        addLine.setMovementQuantity(BigDecimal.valueOf(773.233));
        // /////////////////////////////////////
        java.util.HashMap<String, Object> attrSetInst_1 = new java.util.HashMap<String, Object>();
        // //////////////////////////////////
        attrSetInst_1.put("SerialNumber", UUID.randomUUID().toString());
        //attrSetInst_1.Add("WidthInch", (decimal)17.75);
        //attrSetInst_1.Add("DiameterInch", 48.00);
        //attrSetInst_1.Add("WeightLbs", (decimal)1678);
        //attrSetInst_1.put("WeightKg", BigDecimal.valueOf(773.233));
        //attrSetInst_1.Add("AirDryWeightLbs", (decimal)1705.682);
        attrSetInst_1.put("airDryWeightKg", BigDecimal.valueOf(773.684));
        //attrSetInst_1.Add("AirDryMetricTon", (decimal)0.774);
        //attrSetInst_1.Add("RollCnt", 2);
        //attrSetInst_1.Add("AirDryPct", (decimal)101.650);
        attrSetInst_1.put("statusIds", new String[] {"DAMAGE_WRAPPER", "DAMAGE_EDGE"});
        // //////////////////////////////////
        addLine.setAttributeSetInstance(attrSetInst_1);
        inOutApplicationService.when(addLine);

        return documentNumber;
    }

    private ProductCommand.CreateProduct createFPProduct_1(String productId) {
        ProductCommand.CreateProduct prd_1 = new AbstractProductCommand.SimpleCreateProduct();
        prd_1.setProductId(productId); //Guid.NewGuid().ToString();
        prd_1.setProductName("Test_" + prd_1.getProductId());
        prd_1.setPrimaryProductCategoryId(InitAttributeSets.FLUFF_PULP_PRODUCT_CATEGORY_ID);
        prd_1.setAttributeSetId(InitAttributeSets.FLUFF_PULP_ATTR_SET_ID);//"FluffPulpAttrSet");
        prd_1.setAttributeSetInstanceId(InitAttributeSets.FP_SECONDARY_QTY_UOM_ADMT_ATTR_SET_INST_ID);
        prd_1.setIsSerialNumbered(true);
        prd_1.setQuantityUomId(UomIds.kg);
        prd_1.setCommandId(UUID.randomUUID().toString());

        productApplicationService.when(prd_1);
        return prd_1;
    }

    private String testCreateAndComplateInOut_0() {
        String documentNumber = createInOutForTest(inOutApplicationService, DocumentTypeIds.IN_OUT, getTestProductId2(), BigDecimal.valueOf(123));
        completeInOut(documentNumber);
        return documentNumber;
        //
        //            MergePatchInOut patchInOut = new MergePatchInOut();
        //            patchInOut.DocumentNumber = documentNumber;
        //            patchInOut.DocumentAction = DocumentAction.Void;//不能这样写：patchInOut.DocumentStatus = DocumentStatus.Voided
        //            patchInOut.Version = 1;
        //            patchInOut.CommandId = Guid.NewGuid().ToString();
        //            inOutApplicationService.When(patchInOut);
        //            var inOutResult = inOutApplicationService.Get(inOut.DocumentNumber);
        //            //Console.WriteLine(inOutResult.DocumentNumber);
        //            Assert.AreEqual(DocumentStatusIds.Voided, inOutResult.DocumentStatusId);
        //            //Console.WriteLine(inOutResult.FreightAmount);
        //            //Assert.AreEqual(inOut.FreightAmount, inOutResult.FreightAmount);
        //            //Console.WriteLine(inOutResult.ChargeAmount);
        //            //Assert.AreEqual(inOut.ChargeAmount, inOutResult.ChargeAmount);
        //
    }

    //    public void testCompleteInOut() {
    //        String documentNumber = "IX2019-03-14";
    //        completeInOut(documentNumber);
    //    }

    private void completeInOut(String documentNumber) {
        InOutState inout = inOutApplicationService.get(documentNumber);
        InOutCommands.Complete complete = new InOutCommands.Complete();
        complete.setDocumentNumber(documentNumber);
        complete.setVersion(inout.getVersion());
        complete.setCommandId(UUID.randomUUID().toString());
        inOutApplicationService.when(complete);
    }

    private String createInOutForTest(InOutApplicationService inOutApplicationService, String documentTypeId,
                                      String productId, BigDecimal movementQuantity) {
        String documentNumber = UUID.randomUUID().toString();

        InOutCommand.CreateInOut inOut = new AbstractInOutCommand.SimpleCreateInOut();
        inOut.setDocumentNumber(documentNumber);
        inOut.setCommandId(UUID.randomUUID().toString());
        //inOut.DocumentAction = DocumentAction.Draft;// 不能这样写：inOut.DocumentStatus = DocumentStatus.Drafted
        //inOut.ChargeAmount = new Money(10000, "CNY");
        //inOut.FreightAmount = new Money(400, "CNY");
        inOut.setMovementTypeId(documentTypeId);
        inOut.setMovementDate(new java.util.Date());

        InOutLineCommand.CreateInOutLine line_1 = inOut.newCreateInOutLine();
        line_1.setLineNumber(String.valueOf(new java.util.Date().getTime()));
        line_1.setProductId(productId);
        line_1.setLocatorId(TEST_LOCATOR_ID_2);//("TEST_" + new java.util.Date().getTime());
        line_1.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);
        line_1.setMovementQuantity(movementQuantity);
        inOut.getCreateInOutLineCommands().add(line_1);

        inOutApplicationService.when(inOut);
        return documentNumber;
    }


    private String createInOutForTest2(InOutApplicationService inOutApplicationService, String documentTypeId,
                                      String productId, BigDecimal movementQuantity) {
        String documentNumber = UUID.randomUUID().toString();

        InOutCommand.CreateInOut inOut = new AbstractInOutCommand.SimpleCreateInOut();
        inOut.setDocumentNumber(documentNumber);
        inOut.setCommandId(UUID.randomUUID().toString());
        //inOut.DocumentAction = DocumentAction.Draft;// 不能这样写：inOut.DocumentStatus = DocumentStatus.Drafted
        //inOut.ChargeAmount = new Money(10000, "CNY");
        //inOut.FreightAmount = new Money(400, "CNY");
        inOut.setMovementTypeId(documentTypeId);
        inOut.setMovementDate(new java.util.Date());
        inOutApplicationService.when(inOut);

        InOutState inOutState = inOutApplicationService.get(documentNumber);
        InOutCommands.AddLine line_1 = new InOutCommands.AddLine();
        line_1.setDocumentNumber(documentNumber);
        line_1.setLineNumber(String.valueOf(new java.util.Date().getTime()));
        line_1.setProductId(productId);
        line_1.setLocatorId(TEST_LOCATOR_ID_2);//("TEST_" + new java.util.Date().getTime());
        line_1.setAttributeSetInstance(null);
        line_1.setMovementQuantity(movementQuantity);
        line_1.setVersion(inOutState.getVersion());
        line_1.setCommandId(UUID.randomUUID().toString());
        inOutApplicationService.when(line_1);

        return documentNumber;
    }

    private String getTestProductId2() {
        String productId = "TEST_" + new java.util.Date().getTime();
        ProductCommand.CreateProduct prd_1 = new AbstractProductCommand.SimpleCreateProduct();
        prd_1.setProductId(productId); //Guid.NewGuid().ToString();
        prd_1.setProductName("Test_" + prd_1.getProductId());
        //prd_1.setPrimaryProductCategoryId(InitAttributeSets.FLUFF_PULP_PRODUCT_CATEGORY_ID);
        //prd_1.setAttributeSetId(InitAttributeSets.FLUFF_PULP_ATTR_SET_ID);//"FluffPulpAttrSet");
        //prd_1.setAttributeSetInstanceId(InitAttributeSets.FP_SECONDARY_QTY_UOM_ADMT_ATTR_SET_INST_ID);
        prd_1.setIsSerialNumbered(false);
        prd_1.setQuantityUomId(UomIds.kg);
        prd_1.setCommandId(UUID.randomUUID().toString());

        productApplicationService.when(prd_1);
        return productId;
    }

}
