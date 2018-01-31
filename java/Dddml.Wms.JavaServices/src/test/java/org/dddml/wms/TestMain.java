package org.dddml.wms;

import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
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

        try {
            InitInventoryPostingRules.createDefaultInventoryPostingRules();
        } catch (Exception ex) {
            if(InitEntityXmlData.isCausedByConstraintViolation(ex)) {
                ex.printStackTrace();
            } else {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }

        try {
            InitAttributeSets.createDefaultAttributeSets();
        } catch (Exception ex) {
            if(InitEntityXmlData.isCausedByConstraintViolation(ex)) {
                ex.printStackTrace();
            } else {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        // ///////////////////////////////////
        //if(true) return;

        //testInventoryItemApplicationService();

        testCreateAndComplateInOut_0();

        //testTableIdGenerator();
        //if(true) return;

    }


    private static void testTableIdGenerator() {
        TableIdGenerator idGenerator = new TableIdGenerator();
        System.out.println(idGenerator.getNextId());
        System.out.println(idGenerator.getNextId());
        System.out.println(idGenerator.getNextId());
    }

    private static String testCreateAndComplateInOut_0() {
        InOutApplicationService inOutApplicationService = (InOutApplicationService)ApplicationContext.current.get("inOutApplicationService");

        String documentNumber = UUID.randomUUID().toString();

        InOutCommand.CreateInOut inOut = new AbstractInOutCommand.SimpleCreateInOut();
        inOut.setDocumentNumber(documentNumber);
        inOut.setCommandId(UUID.randomUUID().toString());
        //inOut.DocumentAction = DocumentAction.Draft;// 不能这样写：inOut.DocumentStatus = DocumentStatus.Drafted
        //inOut.ChargeAmount = new Money(10000, "CNY");
        //inOut.FreightAmount = new Money(400, "CNY");
        inOut.setMovementTypeId(DocumentTypeIds.IN_OUT);
        inOut.setMovementDate(new java.util.Date());

        InOutLineCommand.CreateInOutLine line_1 = inOut.newCreateInOutLine();
        line_1.setLineNumber(String.valueOf(new java.util.Date().getTime()));
        line_1.setProductId("TEST_" + new java.util.Date().getTime());
        line_1.setLocatorId("TEST_" + new java.util.Date().getTime());
        line_1.setAttributeSetInstanceId("EMPTY");
        line_1.setMovementQuantity(BigDecimal.valueOf(123));
        inOut.getInOutLines().add(line_1);

        inOutApplicationService.when(inOut);

        InOutState inOut_1 = inOutApplicationService.get(documentNumber);

        InOutCommands.Complete complete = new InOutCommands.Complete();
        complete.setDocumentNumber(documentNumber);
        complete.setVersion(inOut_1.getVersion());
        complete.setCommandId(UUID.randomUUID().toString());
        inOutApplicationService.when(complete);

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

    // /////////////////////////////////////////////////////////////
    //todo 事实上库存单元的应用服务的创建方法应该只是一个内部服务，不应该通过 RESTful API（外部）可访问
    // 需要有一个生成选项，把它从 RESTful API 中去掉。
    // 直接创建库存单元是不对的。
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