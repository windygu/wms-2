package org.dddml.wms;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.tool.ApplicationServiceReflectUtils;
import org.dddml.wms.tool.XmlEntityDataTool;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.dddml.wms.specialization.spring.SpringApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestMain {


    static org.springframework.context.ApplicationContext springFrameworkApplicationContext;

    static {
        springFrameworkApplicationContext = new ClassPathXmlApplicationContext(
                "config/SpringConfigs.xml"
                //"config/DatabaseConfig.xml"
                //"config/AggregatesHibernateConfig.xml",
                //"config/TreesHibernateConfig.xml",
                //"config/TreesConfig.xml",
                //"config/CustomIdGeneratorsConfig.xml",
                //"config/GardenAggregateConfig.xml"
        );
    }

    public static void main(final String[] args) throws Exception {
//        ReflectReadOnlyProxyGenerator generator = new ReflectReadOnlyProxyGenerator();
//        TestIntf1 testIntf1 = (TestIntf1) generator.createProxy(new TestClass1(), new Class[]{TestIntf1.class}, "getStateReadOnly", TestClass1.readOnlyPropertyNames);
//        testIntf1.setF2("testTestTest2");
//        testIntf1.setF1("testTestTest1");
        //testSet();
        //if (true) return;

        ApplicationContext.current = new SpringApplicationContext(springFrameworkApplicationContext);

        // ///////////////////////////////////
        InitEntityXmlData.createEntityXmlData();

        InitInventoryPostingRules.createDefaultInventoryPostingRules();

        InitAttributeSets.createDefaultAttributeSets();
        // ///////////////////////////////////
        //if(true) return;

        testInventoryItemApplicationService();

    }


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