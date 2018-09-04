package org.dddml.wms;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.product.*;
import org.dddml.wms.domain.uom.UomIds;
import org.dddml.wms.specialization.ApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/9/3.
 */
public class PhysicalInventoryTests {

    private ProductApplicationService productApplicationService;

    private AttributeSetApplicationService attributeSetApplicationService;

    private AttributeApplicationService attributeApplicationService;

    private PhysicalInventoryApplicationService physicalInventoryApplicationService;

    public void setUp() {
        attributeApplicationService = (AttributeApplicationService) ApplicationContext.current.get("attributeApplicationService");
        attributeSetApplicationService = (AttributeSetApplicationService) ApplicationContext.current.get("attributeSetApplicationService");
        productApplicationService = (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
        physicalInventoryApplicationService = (PhysicalInventoryApplicationService) ApplicationContext.current.get("physicalInventoryApplicationService");
    }

    public void testCreatePhysicalInventoryAndAddLines() {

        String piId = (new Date().getTime()) + "" + UUID.randomUUID().hashCode();

        // /////////////// 创建盘点单 //////////////////////////
        createTestPhysicalInventory(piId);

        // //////////// 把所有库存的盘点数量置为 0 ///////////////////////////
        // //////////// 如执行调整，现有库存都会被作（盘亏）出库 /////////////
        setAllCountedQuantityZero(piId);

        // //////////////////////////// Create Product /////////////////////////////////////
        String prdId_1 = new java.util.Date().getTime() + "" + UUID.randomUUID().hashCode();
        ProductCommand.CreateProduct prd = createFPProduct_1(prdId_1);
        // /////////////////////////////////

        PhysicalInventoryState physicalInventoryState = physicalInventoryApplicationService.get(piId);
        Long piVersion = physicalInventoryState.getVersion();

        PhysicalInventoryCommands.CountItem countItem_1 = createTestCountItem(prdId_1, piId, piVersion);

        physicalInventoryApplicationService.when(countItem_1);
        piVersion++;

        // ///////////////////////////////////////
        // ///// 完成盘点（执行盘点调整） ////////
        completePhysicalInventory(piId, piVersion);

    }

    void completePhysicalInventory(String piId, Long version) {
        PhysicalInventoryCommands.DocumentAction documentAction = new PhysicalInventoryCommands.DocumentAction();
        documentAction.setDocumentNumber(piId);
        documentAction.setValue(DocumentAction.COMPLETE);
        documentAction.setVersion(version);
        documentAction.setCommandId(UUID.randomUUID().toString());
        physicalInventoryApplicationService.when(documentAction);
    }


    void setAllCountedQuantityZero(String piId) {
        PhysicalInventoryState physicalInventoryState = physicalInventoryApplicationService.get(piId);
        if (physicalInventoryState.getPhysicalInventoryLines() == null) {
            return;
        }
        PhysicalInventoryCommand.MergePatchPhysicalInventory patchPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
        patchPhysicalInventory.setDocumentNumber(piId);
        patchPhysicalInventory.setCommandId(UUID.randomUUID().toString());
        patchPhysicalInventory.setVersion(physicalInventoryState.getVersion());
        for (PhysicalInventoryLineState line : physicalInventoryState.getPhysicalInventoryLines()) {
            PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine patchLine = patchPhysicalInventory.newMergePatchPhysicalInventoryLine();
            patchLine.setInventoryItemId(line.getInventoryItemId());
            patchLine.setCountedQuantity(BigDecimal.ZERO);
            patchPhysicalInventory.getPhysicalInventoryLineCommands().add(patchLine);
        }
        physicalInventoryApplicationService.when(patchPhysicalInventory);
    }

    PhysicalInventoryCommands.CountItem createTestCountItem(String productId, String piId, Long physicalInventoryVersion) {
        PhysicalInventoryCommands.CountItem countItem_1 = new PhysicalInventoryCommands.CountItem();
        countItem_1.setDocumentNumber(piId);
        countItem_1.setVersion(physicalInventoryVersion);
        countItem_1.setProductId(productId);
        countItem_1.setLocatorId(InOutTests.TEST_LOCATOR_ID_1);
        // ////////////////////////  Atttribute Set Instance /////////////////////////////////
        Map<String, Object> attrSetInst_1 = new HashMap<>();
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
        // /////////////////////////////////////////////////////////////////////////////////////
        countItem_1.setAttributeSetInstance(attrSetInst_1);
        countItem_1.setCountedQuantity(BigDecimal.valueOf(773.5));
        countItem_1.setCommandId(UUID.randomUUID().toString());
        return countItem_1;
    }

    void createTestPhysicalInventory(String piId) {
        PhysicalInventoryCommand.CreatePhysicalInventory createPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory();
        createPhysicalInventory.setDocumentNumber(piId);
        createPhysicalInventory.setWarehouseId(InOutTests.TEST_WAREHOUSE_ID);
        createPhysicalInventory.setLocatorIdPattern("%%");
        createPhysicalInventory.setProductIdPattern("%%");
        createPhysicalInventory.setActive(true);
        createPhysicalInventory.setCommandId(createPhysicalInventory.getDocumentNumber());
        physicalInventoryApplicationService.when(createPhysicalInventory);
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

}
