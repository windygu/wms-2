package org.dddml.wms;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.locator.AbstractLocatorCommand;
import org.dddml.wms.domain.locator.LocatorApplicationService;
import org.dddml.wms.domain.locator.LocatorCommand;
import org.dddml.wms.domain.warehouse.AbstractWarehouseCommand;
import org.dddml.wms.domain.warehouse.WarehouseApplicationService;
import org.dddml.wms.domain.warehouse.WarehouseCommand;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.dddml.wms.specialization.spring.SpringApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class TestMain {


    static org.springframework.context.ApplicationContext springFrameworkApplicationContext;

    static {
        springFrameworkApplicationContext = new ClassPathXmlApplicationContext(
                "config/SpringConfigs.xml",
                "config/TestDataSourceConfig.xml"
                //"config/AggregatesHibernateConfig.xml",
                //"config/TreesHibernateConfig.xml",
                //"config/TreesConfig.xml",
                //"config/CustomIdGeneratorsConfig.xml",
                //"config/GardenAggregateConfig.xml"
        );
    }

    public static void main(final String[] args) throws Exception {
        ApplicationContext.current = new SpringApplicationContext(springFrameworkApplicationContext);

        // //////////////////  initialize database data /////////////////
        if (true) { // if need to initialize, switch to true, else to false.
            try {
                InitAttributeSets.createDefaultAttributeSets();
            } catch (Exception ex) {
                if (InitEntityXmlData.isCausedByConstraintViolation(ex)) {
                    ex.printStackTrace();
                } else {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }

            InitEntityXmlData.createEntityXmlData();
            try {
                InitInventoryPostingRules.createDefaultInventoryPostingRules();
            } catch (Exception ex) {
                if (InitEntityXmlData.isCausedByConstraintViolation(ex)) {
                    ex.printStackTrace();
                } else {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }
        // ////////////////////////////////////////////////////////////
        try {
            testCreateWarehouse();
            testCreateLocators();
        } catch (Exception ex) {
            if (InitEntityXmlData.isCausedByConstraintViolation(ex)) {
                ex.printStackTrace();
            } else {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }

        InOutTests inOutTests = new InOutTests();
        inOutTests.setUp();
        inOutTests.testInThenOut();//测试入库后马上出库，该产品的库存应该为 0
        //if (true) return;
        inOutTests.testCreateAndCompleteAndReverseInOut();

        OrderShipGroupTests orderShipGroupTests = new OrderShipGroupTests();
        orderShipGroupTests.setUp();
        orderShipGroupTests.testCreatePOShipGroup1();
        orderShipGroupTests.testCreatePOShipGroupAndShipment2();
        orderShipGroupTests.testCreateSOShipGroup1();
        //if (true) return;

        ProductTests productTests = new ProductTests();
        productTests.setUp();
        productTests.testCreateAttributesAndProducts();
        //        ProductTests productTests2 = new ProductTests();
        //        productTests2.setUp();
        //        productTests2.testCreateAttributesAndProducts();
        //if(true) {return;}

        //testInventoryItemApplicationService();
        //if(true) return;


        MovementTests movementTests = new MovementTests();
        movementTests.setUp();
        movementTests.testCreateAndCompleteAndReverseMovement();

        ShipmentTests shipmentTests = new ShipmentTests();
        shipmentTests.setUp();
        shipmentTests.testImportAndReceive();

    }

    private static void testCreateWarehouse() {
        WarehouseCommand.CreateWarehouse createWarehouse = new AbstractWarehouseCommand.SimpleCreateWarehouse();
        createWarehouse.setWarehouseId(InOutTests.TEST_WAREHOUSE_ID);
        createWarehouse.setCommandId(UUID.randomUUID().toString());
        createWarehouse.setRequesterId("111111");
        createWarehouse.setActive(true);
        WarehouseApplicationService service = (WarehouseApplicationService) ApplicationContext.current.get("warehouseApplicationService");
        service.when(createWarehouse);
    }
    
    private static void testCreateLocators() {
        testCreateLocator(InOutTests.TEST_LOCATOR_ID_1);
        testCreateLocator(InOutTests.TEST_LOCATOR_ID_1_RECEIVING_AREA);
        testCreateLocator(InOutTests.TEST_LOCATOR_ID_2);
    }

    private static void testCreateLocator(String locatorId) {
        LocatorCommand.CreateLocator createLocator = new AbstractLocatorCommand.SimpleCreateLocator();
        createLocator.setWarehouseId(InOutTests.TEST_WAREHOUSE_ID);
        createLocator.setLocatorId(locatorId);
        createLocator.setCommandId(UUID.randomUUID().toString());
        createLocator.setRequesterId("111111");
        createLocator.setActive(true);
        LocatorApplicationService service = (LocatorApplicationService) ApplicationContext.current.get("locatorApplicationService");
        service.when(createLocator);
    }


    //        ReflectReadOnlyProxyGenerator generator = new ReflectReadOnlyProxyGenerator();
    //        TestIntf1 testIntf1 = (TestIntf1) generator.createProxy(new TestClass1(), new Class[]{TestIntf1.class}, "getStateReadOnly", TestClass1.readOnlyPropertyNames);
    //        testIntf1.setF2("testTestTest2");
    //        testIntf1.setF1("testTestTest1");


    private static void testTableIdGenerator() {
        TableIdGenerator idGenerator = new TableIdGenerator();
        System.out.println(idGenerator.getNextId());
        System.out.println(idGenerator.getNextId());
        System.out.println(idGenerator.getNextId());
    }

    // /////////////////////////////////////////////////////////////
    // 注意：直接创建库存单元是不对的。
    // 事实上库存单元的应用服务的创建方法应该只是一个内部服务，
    // 不应该通过 RESTful API（外部）可访问。
    // 有一个生成选项，可以把它从 RESTful API 中去掉。
    //
    // so this method is only for test!!!
    // /////////////////////////////////////////////////////////////
    private static void testInventoryItemApplicationService(){

        InventoryItemApplicationService service = (InventoryItemApplicationService)ApplicationContext.current.get("inventoryItemApplicationService") ;

        InventoryItemCommand.CreateInventoryItem ii = new AbstractInventoryItemCommand.SimpleCreateInventoryItem();
        InventoryItemId iiId = new InventoryItemId("TEST_PRD_1", "TEST_LOC_1", UUID.randomUUID().toString());
        ii.setInventoryItemId(iiId);

        InventoryItemEntryCommand.CreateInventoryItemEntry iiEntry = ii.newCreateInventoryItemEntry();
        iiEntry.setEntrySeqId(new Date().getTime());
        iiEntry.setOnHandQuantity(BigDecimal.valueOf(100));
        InventoryItemSourceInfo iiEntrySrc = new InventoryItemSourceInfo("TEST_EVT_TYPE", "TEST_DOCUMENT_NO_1", UUID.randomUUID().toString(), 0);
        iiEntry.setSource(iiEntrySrc);

        ii.getEntries().add(iiEntry);
        ii.setCommandId(UUID.randomUUID().toString());

        service.when(ii);
    }

}