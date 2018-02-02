package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.warehouse.WarehouseUtils;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class MovementApplicationServiceImpl extends AbstractMovementApplicationService.SimpleMovementApplicationService {


    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public final IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public final void setSeqIdGenerator(IdGenerator<Long, Object, Object> value) {
        seqIdGenerator = value;
    }

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    MovementConfirmationApplicationService getMovementConfirmationApplicationService() {
        return (MovementConfirmationApplicationService) ApplicationContext.current.get("movementConfirmationApplicationService");
    }

    public MovementApplicationServiceImpl(EventStore eventStore, MovementStateRepository stateRepository, MovementStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(MovementCommands.DocumentAction c) {
        if (Objects.equals(c.getValue(), DocumentAction.COMPLETE)) {
            //todo
//            var mov = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
//            var inventoryItemEntries = CompleteMovementCreateInventoryItemEntries(mov);
//            CreateOrUpdateInventoryItems(inventoryItemEntries);
//            if (mov.IsInTransit) {
//                var movConfirm = CreateMovementConfirmation(mov);
//                MovementConfirmationApplicationService.When(movConfirm);
//            }
            super.when(c);
        } else if (Objects.equals(c.getValue(), DocumentAction.CONFIRM)) {
            throw new UnsupportedOperationException("Need to confirm MovementConfirmation.");
        } else if (Objects.equals(c.getValue(), DocumentAction.REVERSE)) {
            //todo
//            var srcMov = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);
//            var reversalMovInfo = CreateReversalMovementAndCompleteAndClose(c, srcMov);
//            ReverseUpdateSourceMovement(c, reversalMovInfo);
//            //base.When(c);
        } else {
            super.when(c);
        }
    }

    static List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmMovementCreateInventoryItemEntries(
            MovementState movement, java.util.function.Function<MovementLineState, BigDecimal> getConfirmedQty, Supplier<Long> nextEntrySeqId) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> invItemEntries = new ArrayList<InventoryItemEntryCommand.CreateInventoryItemEntry>();
        for (MovementLineState d : movement.getMovementLines()) {
            InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair =
                    confirmMovementCreateInventoryItemEntryPair(movement, d, getConfirmedQty.apply(d), nextEntrySeqId);
            invItemEntries.addAll(Arrays.asList(trxPair));
        }
        return invItemEntries;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry[] completeMovementCreateInventoryItemEntryPair(
            MovementState movement, MovementLineState movementLine,
            Supplier<Long> nextEntrySeqId) {
        InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry[2];

        BigDecimal quantity = movementLine.getMovementQuantity();
        /////////////////////// From: ////////////////////////////
        BigDecimal signum = BigDecimal.valueOf(-1);
        trxPair[0] = createInventoryItemEntry(
                movement, movementLine, movementLine.getLocatorIdFrom(), quantity.multiply(signum),
                0, nextEntrySeqId, false);

        /////////////////////// To:   ////////////////////////////
        signum = BigDecimal.valueOf(1);
        if (!movement.getIsInTransit()) {
            trxPair[1] = createInventoryItemEntry(movement, movementLine, movementLine.getLocatorIdTo(),
                    quantity.multiply(signum), 1, nextEntrySeqId, false);
        } else {
            String locId = WarehouseUtils.getInTransitLocatorId(movement.getWarehouseIdFrom());
            trxPair[1] = createInventoryItemEntry(movement, movementLine, locId, quantity.multiply(signum),
                    1, nextEntrySeqId, true);
        }
        return trxPair;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry[] confirmMovementCreateInventoryItemEntryPair(
            MovementState movement, MovementLineState movementLine, BigDecimal confirmedQty,
            Supplier<Long> nextEntrySeqId) {
        if (!movement.getIsInTransit()) {
            throw new IllegalArgumentException("Movement is NOT In-Transit.");
        }
        InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair = new InventoryItemEntryCommand.CreateInventoryItemEntry[2];

        /////////////////////// From: ////////////////////////////
        BigDecimal signum = BigDecimal.valueOf(-1);
        String locIdFrom = WarehouseUtils.getInTransitLocatorId(movement.getWarehouseIdFrom());
        trxPair[0] = createInventoryItemEntry(
                movement, movementLine, locIdFrom, confirmedQty.multiply(signum),
                2, nextEntrySeqId, true);

        /////////////////////// To:   ////////////////////////////
        signum = BigDecimal.valueOf(1);
        trxPair[1] = createInventoryItemEntry(
                movement, movementLine, movementLine.getLocatorIdTo(), confirmedQty.multiply(signum),
                3, nextEntrySeqId, false);

        return trxPair;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(MovementState movement, MovementLineState movementLine, String locatorId, java.math.BigDecimal quantity, int lineSubSeqId, Supplier<Long> nextEntrySeqId, boolean usingInTransitQty) {
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        InventoryItemId invItemId = new InventoryItemId(movementLine.getProductId(), locatorId, movementLine.getAttributeSetInstanceId());
        entry.setInventoryItemId(invItemId);
        entry.setEntrySeqId(nextEntrySeqId.get());
        if (!usingInTransitQty) {
            entry.setOnHandQuantity(quantity);
        } else {
            entry.setInTransitQuantity(quantity);
        }
        entry.setSource(
                new InventoryItemSourceInfo(DocumentTypeIds.MOVEMENT, movement.getDocumentNumber(), movementLine.getLineNumber(), lineSubSeqId)
        );
        return entry;
    }

    ///#region MovementConfirmation

    /**
     创建 Movement 的确认单。
     */
    private MovementConfirmationCommand.CreateMovementConfirmation createMovementConfirmation(MovementState movement) {
        MovementConfirmationCommand.CreateMovementConfirmation movConfirm = new AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation();
        movConfirm.setMovementDocumentNumber(movement.getDocumentNumber());
        movConfirm.setDocumentNumber("MC" + movement.getDocumentNumber()); //SeqIdGenerator.GetNextId();
        movConfirm.setDocumentTypeId(DocumentTypeIds.MOVEMENT_CONFIRMATION);
        //movConfirm.CreatedBy = movConfirm.UpdatedBy = Context.User;
        //movConfirm.CreationTime = movConfirm.UpdateTime = now;
        addMovementConfirmationLines(movement, movConfirm);
        return movConfirm;
    }

    private void addMovementConfirmationLines(MovementState movement, MovementConfirmationCommand.CreateMovementConfirmation movConfirm) {
        for (MovementLineState movLine : movement.getMovementLines()) {
            MovementConfirmationLineCommand.CreateMovementConfirmationLine confirmLine = new AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine();
            //confirmLine.MovementConfirmationDocumentNumber = movConfirm;
            //confirmLine.CreatedBy = confirmLine.UpdatedBy = Context.User;
            //confirmLine.CreationTime = confirmLine.UpdateTime = now;
            confirmLine.setLineNumber(movLine.getLineNumber()); //SeqIdGenerator.GetNextId().ToString();
            confirmLine.setMovementLineNumber(movLine.getLineNumber());
            confirmLine.setTargetQuantity(movLine.getMovementQuantity());
            confirmLine.setConfirmedQuantity(BigDecimal.valueOf(0)); //??
            movConfirm.getMovementConfirmationLines().add(confirmLine);
        }
    }

    ///#endregion

}
