package org.dddml.wms;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.inventoryitem.InventoryItemIds;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.specialization.ApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/2/2.
 */
public class MovementTests {

    private MovementApplicationService movementApplicationService;

    private MovementConfirmationApplicationService movementConfirmationApplicationService;

    public final void setUp() {
        movementApplicationService = (MovementApplicationService) ApplicationContext.current.get("movementApplicationService");
        movementConfirmationApplicationService = (MovementConfirmationApplicationService) ApplicationContext.current.get("movementConfirmationApplicationService");
    }

    public final void testCreateAndCompleteAndReverseMovement() {
        String documentNumber_0 = testCreateAndCompleteMovement_0();
        String inTransitDocNumber_1 = testCreateAndCompleteMovement_1();
        String documentNumber_1 = testCreateAndCompleteAndReverseMovement_1();
        testCreateAndCompleteAndConfirmMovement_0();
    }

    //private void TestReverseMovement(string documentNumber)
    //{
    //    var reverse = new MovementCommands.Reverse();
    //    reverse.CommandId = Guid.NewGuid().ToString();
    //    reverse.Version = 2;
    //    reverse.DocumentNumber = documentNumber;
    //    movementApplicationService.When(reverse);
    //}

    private String testCreateAndCompleteMovement_0() {
        boolean isInTransit = false;
        String documentNumber = CreateAndCompleteTestMovement(isInTransit);
        return documentNumber;
    }

    private String testCreateAndCompleteMovement_1() {
        boolean isInTransit = true;
        String documentNumber = CreateAndCompleteTestMovement(isInTransit);
        return documentNumber;
    }

    private String testCreateAndCompleteAndConfirmMovement_0() {
        boolean isInTransit = true;
        String documentNumber = CreateAndCompleteTestMovement(isInTransit);

        String confirmDocNumber = "MC" + documentNumber;

        MovementConfirmationState movConfirm = movementConfirmationApplicationService.get(confirmDocNumber);

        long firstVersion = 0L;

        MovementConfirmationCommand.MergePatchMovementConfirmation updateMovConfirm = new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
        updateMovConfirm.setDocumentNumber(confirmDocNumber);
        updateMovConfirm.setVersion(firstVersion);
        updateMovConfirm.setCommandId(UUID.randomUUID().toString());
        for (MovementConfirmationLineState line : movConfirm.getMovementConfirmationLines()) {
            MovementConfirmationLineCommand.MergePatchMovementConfirmationLine updateLine = updateMovConfirm.newMergePatchMovementConfirmationLine();
            updateLine.setLineNumber(line.getLineNumber());
            updateLine.setConfirmedQuantity(line.getTargetQuantity());
            updateLine.setScrappedQuantity(BigDecimal.ZERO);
            updateLine.setDifferenceQuantity(BigDecimal.ZERO);
            updateMovConfirm.getMovementConfirmationLineCommands().add(updateLine);
        }
        movementConfirmationApplicationService.when(updateMovConfirm);

        // //////////////////////////////////
        MovementConfirmationCommands.DocumentAction actionConfirm = new MovementConfirmationCommands.DocumentAction();
        actionConfirm.setValue(DocumentAction.CONFIRM);
        actionConfirm.setDocumentNumber(confirmDocNumber);
        actionConfirm.setVersion(firstVersion + 1);
        actionConfirm.setCommandId(UUID.randomUUID().toString());
        movementConfirmationApplicationService.when(actionConfirm);

        return actionConfirm.getDocumentNumber();
    }

    private String CreateAndCompleteTestMovement(boolean isInTransit) {

        String documentNumber = UUID.randomUUID().toString();
        MovementCommand.CreateMovement movement = new AbstractMovementCommand.SimpleCreateMovement();
        movement.setDocumentNumber(documentNumber);
        movement.setCommandId(UUID.randomUUID().toString());
        movement.setWarehouseIdFrom("1");
        movement.setWarehouseIdTo("2");
        //movement.DocumentAction = DocumentAction.Draft;// 不能这样写：movement.DocumentStatus = DocumentStatus.Drafted
        //movement.ChargeAmount = new Money(10000, "CNY");
        //movement.FreightAmount = new Money(400, "CNY");
        //movement.MovementTypeId = DocumentTypeIds.Movement;
        movement.setMovementDate(new java.util.Date());

        //////////////////
        movement.setIsInTransit(isInTransit);
        //////////////////

        MovementLineCommand.CreateMovementLine line_1 = movement.newCreateMovementLine();
        line_1.setLineNumber(new java.util.Date().getTime() + ""); //todo??
        line_1.setProductId("TEST_" + new java.util.Date().getTime());
        line_1.setLocatorIdFrom("1_TEST_F_" + new java.util.Date().getTime());
        line_1.setLocatorIdTo("2_TEST_T_" + new java.util.Date().getTime());
        line_1.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);
        line_1.setMovementQuantity(BigDecimal.valueOf(123));
        movement.getMovementLines().add(line_1);

        movementApplicationService.when(movement);

        long firstVersion = 0L;
        MovementCommands.DocumentAction complete = new MovementCommands.DocumentAction();
        complete.setValue(DocumentAction.COMPLETE);
        complete.setDocumentNumber(documentNumber);
        complete.setVersion(firstVersion);
        complete.setCommandId(UUID.randomUUID().toString());
        movementApplicationService.when(complete);
        return documentNumber;
    }

    private String testCreateAndCompleteAndReverseMovement_1() {
        String documentNumber = UUID.randomUUID().toString();

        MovementCommand.CreateMovement movement = new AbstractMovementCommand.SimpleCreateMovement();
        movement.setDocumentNumber(documentNumber);
        movement.setCommandId(UUID.randomUUID().toString());
        movement.setWarehouseIdFrom("1");
        movement.setWarehouseIdTo("2");
        movement.setMovementDate(new java.util.Date());
        movement.setIsInTransit(false); //movement.IsInTransit = true;

        MovementLineCommand.CreateMovementLine line_1 = movement.newCreateMovementLine();
        line_1.setLineNumber(new java.util.Date().getTime() + ""); //todo??
        line_1.setProductId("TEST_" + new java.util.Date().getTime());
        line_1.setLocatorIdFrom("1_TEST_F_" + new java.util.Date().getTime());
        line_1.setLocatorIdTo("2_TEST_T_" + new java.util.Date().getTime());
        line_1.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);
        line_1.setMovementQuantity(BigDecimal.valueOf(233));
        movement.getMovementLines().add(line_1);

        movementApplicationService.when(movement);

        long firstVersion = 0L;
        MovementCommands.DocumentAction complete = new MovementCommands.DocumentAction();
        complete.setValue(DocumentAction.COMPLETE);
        complete.setDocumentNumber(documentNumber);
        complete.setVersion(firstVersion);
        complete.setCommandId(UUID.randomUUID().toString());
        movementApplicationService.when(complete);

        MovementCommands.DocumentAction reverse = new MovementCommands.DocumentAction();
        reverse.setValue(DocumentAction.REVERSE);
        reverse.setDocumentNumber(documentNumber);
        reverse.setVersion(firstVersion + 1);
        reverse.setCommandId(UUID.randomUUID().toString());
        movementApplicationService.when(reverse);

        return documentNumber;
    }

}
