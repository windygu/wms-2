package org.dddml.wms;

import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.ApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/2/2.
 */
public class InOutTests {

    public static void testCreateAndCompleteAndReverseInOut() {
        String documentNumber = testCreateAndComplateInOut_0();
        testReverseInOut(documentNumber);
    }

    private static void testReverseInOut(String documentNumber) {
        InOutCommands.Reverse reverse = new InOutCommands.Reverse();
        reverse.setCommandId(UUID.randomUUID().toString());
        reverse.setVersion(1L);
        reverse.setDocumentNumber(documentNumber);
        InOutApplicationService inOutApplicationService = (InOutApplicationService) ApplicationContext.current.get("inOutApplicationService");
        inOutApplicationService.when(reverse);
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

}
