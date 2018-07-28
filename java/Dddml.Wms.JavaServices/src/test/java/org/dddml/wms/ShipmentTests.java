package org.dddml.wms;

import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceState;
import org.dddml.wms.domain.product.AbstractProductCommand;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductCommand;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.shipmenttype.ShipmentTypeIds;
import org.dddml.wms.specialization.ApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/2/4.
 */
public class ShipmentTests {
    private ShipmentApplicationService shipmentApplicationService;

    private ProductApplicationService productApplicationService;

    private AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;

    public void setUp() {
        //super.SetUp();
        shipmentApplicationService = (ShipmentApplicationService) ApplicationContext.current.get("shipmentApplicationService");
        productApplicationService = (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
        attributeSetInstanceApplicationService = (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
    }

    public void testImportAndReceive() {
        // ///////////////////////////////////////
        // Create a product for test.
        ProductCommand.CreateProduct prd_1 = createProduct_1();

        // ///////////////////////////////////////
        // Create a shipment.
        String shipmentId = createShipment_1(prd_1);

        updateShipmentToPurchShipShipped(shipmentId);

        receiveAllItems(shipmentId);

        updateShipmentToPurchShipReceived(shipmentId);
    }

    private static java.math.BigDecimal getTestWeightKg() {
        return java.math.BigDecimal.valueOf(761.125);
    }

    private void updateShipmentToPurchShipReceived(String shipmentId) {
        //var updateShipment = new MergePatchShipment();
        ShipmentCommands.ConfirmAllItemsReceived updateShipment = new ShipmentCommands.ConfirmAllItemsReceived();
        updateShipment.setShipmentId(shipmentId);
        updateShipment.setCommandId(UUID.randomUUID().toString());
        //updateShipment.StatusId = StatusItemIds.PurchShipShipped;
        updateShipment.setVersion(3L); //todo???
        shipmentApplicationService.when(updateShipment);
    }

    private void receiveAllItems(String shipmentId) {
        ShipmentState shipmentState = shipmentApplicationService.get(shipmentId);
        Long version = shipmentState.getVersion();
        for (ShipmentItemState item : shipmentState.getShipmentItems()) {
            ShipmentCommands.ReceiveItem receiveItem = new ShipmentCommands.ReceiveItem();
            receiveItem.setShipmentId(shipmentId);
            receiveItem.setShipmentItemSeqId(item.getShipmentItemSeqId());
            receiveItem.setAcceptedQuantity(item.getQuantity());
            receiveItem.setRejectedQuantity(BigDecimal.ZERO);
            receiveItem.setDamagedQuantity(BigDecimal.ZERO);

            if (!(null == item.getAttributeSetInstanceId())) {
                AttributeSetInstanceState srcAttrSetInst = attributeSetInstanceApplicationService.get(item.getAttributeSetInstanceId());
                String rollId = srcAttrSetInst.getSerialNumber();

                java.util.HashMap<String, Object> attrSetInst_1 = new java.util.HashMap<String, Object>();
                // //////////////////////////////////
                attrSetInst_1.put("SerialNumber", rollId);
                //attrSetInst_1.Add("WidthInch", (decimal)17.75);
                //attrSetInst_1.Add("DiameterInch", 48.00);
                //attrSetInst_1.Add("WeightLbs", (decimal)1678);
                attrSetInst_1.put("WeightKg",
                        getTestWeightKg().subtract(java.math.BigDecimal.valueOf(0.001)));
                //attrSetInst_1.Add("AirDryWeightLbs", (decimal)1705.682);
                //attrSetInst_1.Add("AirDryWeightKg", (decimal)773.684);
                //attrSetInst_1.Add("AirDryMetricTon", (decimal)0.774);
                //attrSetInst_1.Add("PackageCount", 2);
                //attrSetInst_1.Add("AirDryPct", (decimal)101.650);
                // //////////////////////////////////
                receiveItem.setAttributeSetInstance(attrSetInst_1);
            }

            receiveItem.setCommandId(UUID.randomUUID().toString());
            receiveItem.setVersion(version);
            shipmentApplicationService.when(receiveItem);

            version++;
        }
    }

    private void updateShipmentToPurchShipShipped(String shipmentId) {
        long firstVersion = 0L;
        //var updateShipment = new MergePatchShipment();
        ShipmentCommands.Ship updateShipment = new ShipmentCommands.Ship();
        updateShipment.setShipmentId(shipmentId);
        updateShipment.setCommandId(UUID.randomUUID().toString());
        //updateShipment.StatusId = StatusItemIds.PurchShipShipped;
        updateShipment.setVersion(firstVersion);
        shipmentApplicationService.when(updateShipment);
    }

    private String createShipment_1(ProductCommand.CreateProduct prd_1) {
        String shipmentId = new java.util.Date().getTime() + "";
        ShipmentCommands.Import shipImport = new ShipmentCommands.Import();
        shipImport.setShipmentId(shipmentId);

        String prdId = prd_1.getProductId();

        String rollId_1 = "H71051402A";
        ImportingShipmentItem shipItem_1 = newImportingShipmentItem(prdId, rollId_1);

        String rollId_2 = "H00000000A";
        ImportingShipmentItem shipItem_2 = newImportingShipmentItem(prdId, rollId_2);

        shipImport.setShipmentItems(
                        java.util.Arrays.asList(new ImportingShipmentItem[]{shipItem_1, shipItem_2})
        );

        shipImport.setShipmentTypeId(ShipmentTypeIds.INCOMING_SHIPMENT);
        shipImport.setDestinationFacilityId("TEST_1");

        shipmentApplicationService.when(shipImport);
        return shipmentId;
    }

    private static ImportingShipmentItem newImportingShipmentItem(String productId, String rollId) {
        ImportingShipmentItem shipItem_1 = new ImportingShipmentItem();
        shipItem_1.setProductId(productId);
        shipItem_1.setQuantity(BigDecimal.valueOf(1));
        java.util.HashMap<String, Object> attrSetInst_1 = new java.util.HashMap<String, Object>();

        // //////////////////////////////////
        attrSetInst_1.put("SerialNumber", rollId);
        attrSetInst_1.put("WidthInch", java.math.BigDecimal.valueOf(17.75));
        attrSetInst_1.put("DiameterInch", 48.00);
        attrSetInst_1.put("WeightLbs", 1678);
        attrSetInst_1.put("WeightKg", getTestWeightKg());
        attrSetInst_1.put("AirDryWeightLbs", java.math.BigDecimal.valueOf(1705.682));
        attrSetInst_1.put("AirDryWeightKg", java.math.BigDecimal.valueOf(773.684));
        attrSetInst_1.put("AirDryMetricTon", java.math.BigDecimal.valueOf(0.774));
        attrSetInst_1.put("PackageCount", 2);
        attrSetInst_1.put("AirDryPct", java.math.BigDecimal.valueOf(101.650));
        // //////////////////////////////////

        shipItem_1.setAttributeSetInstance(attrSetInst_1);
        return shipItem_1;
    }


    private ProductCommand.CreateProduct createProduct_1() {
        ProductCommand.CreateProduct prd_1 = new AbstractProductCommand.SimpleCreateProduct();
        prd_1.setProductId(new java.util.Date().getTime() + ""); //Guid.NewGuid().ToString();
        prd_1.setProductName("Test_" + prd_1.getProductId());
        prd_1.setAttributeSetId(InitAttributeSets.FLUFF_PULP_ATTR_SET_ID);//"FluffPulpAttrSet");
        prd_1.setIsSerialNumbered(true);
        //prd_1.QuantityUomId;
        prd_1.setCommandId(UUID.randomUUID().toString());

        productApplicationService.when(prd_1);
        return prd_1;
    }

}
