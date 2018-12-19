package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceUtils;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.domain.warehouse.WarehouseUtils;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }
    AttributeSetService getAttributeSetService() {
        return (AttributeSetService) ApplicationContext.current.get("attributeSetService");
    }
    AttributeSetInstanceApplicationService getAttributeSetInstanceApplicationService() {
        return (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
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
            MovementState mov = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
            List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = completeMovementCreateInventoryItemEntries(mov, c.getRequesterId());
            InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);
            if (mov.getIsInTransit()) {
                MovementConfirmationCommand.CreateMovementConfirmation movConfirm = createMovementConfirmation(mov);
                getMovementConfirmationApplicationService().when(movConfirm);
            }
            super.when(c);
        } else if (Objects.equals(c.getValue(), DocumentAction.CONFIRM)) {
            throw new UnsupportedOperationException("Need to confirm MovementConfirmation.");
        } else if (Objects.equals(c.getValue(), DocumentAction.REVERSE)) {
            MovementState srcMov = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.COMPLETED);
            MovementCommand.CreateMovement reversalMovInfo = createReversalMovementAndCompleteAndClose(c, srcMov);
            reverseUpdateSourceMovement(c, reversalMovInfo);
            //base.When(c);
        } else {
            super.when(c);
        }
    }

    @Override
    @Transactional
    public void when(MovementCommands.AddLine c) {
        MovementState inOut = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
        MovementLineCommand.CreateMovementLine createLine = createMovementLine(c);
        MovementCommand.MergePatchMovement updateMov = new AbstractMovementCommand.SimpleMergePatchMovement();
        updateMov.setDocumentNumber(c.getDocumentNumber());
        updateMov.setVersion(inOut.getVersion());
        updateMov.setCommandId(c.getCommandId());
        updateMov.setRequesterId(c.getRequesterId());
        updateMov.getMovementLineCommands().add(createLine);
        when(updateMov);
    }

    private MovementLineCommand.CreateMovementLine createMovementLine(MovementCommands.AddLine d) {
    	MovementLineCommand.CreateMovementLine line = new AbstractMovementLineCommand.SimpleCreateMovementLine();

        ProductState productState = getProductState(d.getProductId());
        //todo 应该对 AttributeSetInstancd 做检查？
        // assertAttributeSetInstance(prodcutState, attrSetInstMap)???
        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(getAttributeSetService(), getAttributeSetInstanceApplicationService(), productState.getAttributeSetId(), d.getAttributeSetInstance());
        //if (_log.IsDebugEnabled) {
        //    _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //}

        line.setLineNumber(d.getLineNumber());
        line.setProductId(productState.getProductId());
        line.setLocatorIdTo(d.getLocatorIdTo());
        line.setLocatorIdFrom(d.getLocatorIdFrom());
        line.setAttributeSetInstanceId(attrSetInstId);
        line.setMovementQuantity(d.getMovementQuantity());
        line.setActive(true);
        line.setMovementDocumentNumber(d.getDocumentNumber());
        line.setCommandId(d.getCommandId());
        line.setCommandType(d.getCommandType());
        line.setRequesterId(d.getRequesterId());
        return line;
    }
    
    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }
    public void confirmUpdateMovement(MovementCommands.DocumentAction c) {
        update(c, ar -> ((MovementAggregate) ar).documentAction(DocumentAction.CONFIRM, c.getVersion(), c.getCommandId(), c.getRequesterId(), c));
    }

    private void reverseUpdateSourceMovement(MovementCommands.DocumentAction c, MovementCommand.CreateMovement reversalMovInfo) {
        String reversalDocumentNumber = reversalMovInfo.getDocumentNumber();
        String description = "(" + reversalMovInfo.getDocumentNumber() + "<-)"; //(1000016<-)
        update(c, ar -> ((MovementAggregateImpl)ar).reverse(reversalDocumentNumber, description, c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> completeMovementCreateInventoryItemEntries(MovementState movement, String requesterId) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> invItemEntries = new ArrayList<InventoryItemEntryCommand.CreateInventoryItemEntry>();
        for (MovementLineState d : movement.getMovementLines()) {
            InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair =
                    completeMovementCreateInventoryItemEntryPair(movement, d, () -> getSeqIdGenerator().getNextId(), requesterId);
            invItemEntries.addAll(Arrays.asList(trxPair));
        }

        //////////////////////////////////////////////////
        //排序，出库的事务先执行
        //invItemEntries.Sort(new Comparison<ICreateInventoryItemEntry>((x, y) =>
        //        (x.OnHandQuantity > y.OnHandQuantity) ? 1 :
        //            (x.OnHandQuantity == y.OnHandQuantity ? 0 : -1)));

        return invItemEntries;
    }

    ///// <summary>
    ///// Confirm all movement line quantities.
    ///// </summary>
    //internal IList<ICreateInventoryItemEntry> ConfirmMovementCreateInventoryItemEntries(IMovementState movement)
    //{
    //    Func<IMovementLineState, decimal> getConfirmedQty = d => d.MovementQuantity;
    //    var invItemEntries = ConfirmMovementCreateInventoryItemEntries(movement, getConfirmedQty);
    //    return invItemEntries;
    //}

    private MovementCommand.CreateMovement createReversalMovementAndCompleteAndClose(MovementCommands.DocumentAction c, MovementState movement) {
        MovementCommand.CreateMovement createReversalMovement = createReversalMovement(movement);

        when(createReversalMovement);
        long firstVersion = 0L;//!!
        MovementCommands.DocumentAction cmdComplete = new MovementCommands.DocumentAction();
        cmdComplete.setValue(DocumentAction.COMPLETE);
        cmdComplete.setDocumentNumber(createReversalMovement.getDocumentNumber());
        cmdComplete.setVersion(firstVersion);
        cmdComplete.setCommandId(c.getCommandId());
        cmdComplete.setRequesterId(c.getRequesterId());
        when(cmdComplete);
        MovementCommands.DocumentAction cmdClose = new MovementCommands.DocumentAction();
        cmdClose.setValue(DocumentAction.CLOSE);
        cmdClose.setDocumentNumber(createReversalMovement.getDocumentNumber());
        cmdClose.setVersion(firstVersion + 1);
        cmdClose.setCommandId(c.getCommandId());
        cmdClose.setRequesterId(c.getRequesterId());
        when(cmdClose);

        return createReversalMovement;
    }

    protected MovementCommand.CreateMovement createReversalMovement(MovementState movement) {
        MovementCommand.CreateMovement reversalMov = doCreateReversalMovement(movement);
        for (MovementLineState d : movement.getMovementLines()) {
            MovementLineCommand.CreateMovementLine r = doCreateReversalMovementLine(d);
            reversalMov.getCreateMovementLineCommands().add(r);
        }
        return reversalMov;
    }

    /**
     生成反转的单据（但不包括行）。
     */
    protected MovementCommand.CreateMovement doCreateReversalMovement(MovementState movement) {
        MovementCommand.CreateMovement reversalMov = new AbstractMovementCommand.SimpleCreateMovement();

        //reversalInOut.Organization = inOut.Organization;
        //reversalInOut.Client = inOut.Client;

        //生成新的单号:
        reversalMov.setDocumentNumber("RM" + getSeqIdGenerator().getNextId()); //DocumentNumberGenerator.GetNewDocumentNumber();
        //设置反转关系:
        reversalMov.setReversalDocumentNumber(movement.getDocumentNumber());

        //movement.Reversal = reversalMov;
        //源单据前向关联到反转单据:
        //movement.Description = "(" + reversalMov.DocumentNumber + "<-)";//(1000016<-)

        //反转单据后向关联到源单据:
        reversalMov.setDescription("{->" + movement.getDocumentNumber() + ")"); //{->1000015)

        //reversalMov.Posted = movement.Posted;//??
        //reversalMov.Processing = movement.Processing;
        //reversalMov.Processed = movement.Processed;

        reversalMov.setDocumentTypeId(movement.getDocumentTypeId());
        reversalMov.setMovementDate(movement.getMovementDate()); //???

        reversalMov.setApprovalAmount(movement.getApprovalAmount());
        reversalMov.setChargeAmount(movement.getChargeAmount());
        reversalMov.setDateReceived(movement.getDateReceived());
        reversalMov.setFreightAmount(movement.getFreightAmount());
        reversalMov.setActive(movement.getActive());
        reversalMov.setIsInTransit(false); //??
        reversalMov.setSalesRepresentativeId(movement.getSalesRepresentativeId());
        reversalMov.setShipperId(movement.getShipperId());
        reversalMov.setBusinessPartnerId(movement.getBusinessPartnerId());
        //reversalMov.User = movement.User;

        reversalMov.setWarehouseIdFrom(movement.getWarehouseIdFrom());
        reversalMov.setWarehouseIdTo(movement.getWarehouseIdTo());

        return reversalMov;
    }

    protected MovementLineCommand.CreateMovementLine doCreateReversalMovementLine(MovementLineState movementLine) {
        MovementLineCommand.CreateMovementLine reversalLine = new AbstractMovementLineCommand.SimpleCreateMovementLine();
        //reversalLine.Organization = Context.Organization;
        //reversalLine.UpdatedBy = Context.User;
        //reversalLine.UpdateTime = now;
        //reversalLine.CreatedBy = Context.User;
        //reversalLine.CreationTime = now;
        //reversalLine.Processed = movementLine.Processed;//???
        reversalLine.setReversalLineNumber(movementLine.getLineNumber()); //设置反转行
        reversalLine.setProductId(movementLine.getProductId());
        reversalLine.setLocatorIdFrom(movementLine.getLocatorIdFrom());
        reversalLine.setLocatorIdTo(movementLine.getLocatorIdTo());
        reversalLine.setAttributeSetInstanceId(movementLine.getAttributeSetInstanceId());
        //reversalLine.AttributeSetInstanceTo = movementLine.AttributeSetInstanceTo;

        reversalLine.setLineNumber(movementLine.getLineNumber());

        //数量反转
        reversalLine.setMovementQuantity(movementLine.getMovementQuantity().negate());
        //reversalLine.TargetQuantity = -movementLine.TargetQuantity;
        //reversalLine.ConfirmedQuantity = -movementLine.ConfirmedQuantity;
        //reversalLine.ScrappedQuantity = -movementLine.ScrappedQuantity;

        return reversalLine;
    }

    public static List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmMovementCreateInventoryItemEntries(
            MovementState movement, java.util.function.Function<MovementLineState, BigDecimal> getConfirmedQty, Supplier<Long> nextEntrySeqId, String requesterId) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> invItemEntries = new ArrayList<InventoryItemEntryCommand.CreateInventoryItemEntry>();
        for (MovementLineState d : movement.getMovementLines()) {
            InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair =
                    confirmMovementCreateInventoryItemEntryPair(movement, d, getConfirmedQty.apply(d), nextEntrySeqId, requesterId);
            invItemEntries.addAll(Arrays.asList(trxPair));
        }
        return invItemEntries;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry[] completeMovementCreateInventoryItemEntryPair(
            MovementState movement, MovementLineState movementLine,
            Supplier<Long> nextEntrySeqId, String requesterId) {
        InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry[2];

        BigDecimal quantity = movementLine.getMovementQuantity();
        /////////////////////// From: ////////////////////////////
        BigDecimal signum = BigDecimal.valueOf(-1);
        trxPair[0] = createInventoryItemEntry(
                movement, movementLine, movementLine.getLocatorIdFrom(), quantity.multiply(signum),
                0, nextEntrySeqId, false, requesterId);

        /////////////////////// To:   ////////////////////////////
        signum = BigDecimal.valueOf(1);
        if (!movement.getIsInTransit()) {
            trxPair[1] = createInventoryItemEntry(movement, movementLine, movementLine.getLocatorIdTo(),
                    quantity.multiply(signum), 1, nextEntrySeqId, false, requesterId);
        } else {
            String locId = WarehouseUtils.getInTransitLocatorId(movement.getWarehouseIdFrom());
            trxPair[1] = createInventoryItemEntry(movement, movementLine, locId, quantity.multiply(signum),
                    1, nextEntrySeqId, true, requesterId);
        }
        return trxPair;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry[] confirmMovementCreateInventoryItemEntryPair(
            MovementState movement, MovementLineState movementLine, BigDecimal confirmedQty,
            Supplier<Long> nextEntrySeqId, String requesterId) {
        if (!movement.getIsInTransit()) {
            throw new IllegalArgumentException("Movement is NOT In-Transit.");
        }
        InventoryItemEntryCommand.CreateInventoryItemEntry[] trxPair = new InventoryItemEntryCommand.CreateInventoryItemEntry[2];

        /////////////////////// From: ////////////////////////////
        BigDecimal signum = BigDecimal.valueOf(-1);
        String locIdFrom = WarehouseUtils.getInTransitLocatorId(movement.getWarehouseIdFrom());
        trxPair[0] = createInventoryItemEntry(
                movement, movementLine, locIdFrom, confirmedQty.multiply(signum),
                2, nextEntrySeqId, true, requesterId);

        /////////////////////// To:   ////////////////////////////
        signum = BigDecimal.valueOf(1);
        trxPair[1] = createInventoryItemEntry(
                movement, movementLine, movementLine.getLocatorIdTo(), confirmedQty.multiply(signum),
                3, nextEntrySeqId, false, requesterId);

        return trxPair;
    }

    static InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(MovementState movement, MovementLineState movementLine,
                                                                                       String locatorId, java.math.BigDecimal quantity, int lineSubSeqId,
                                                                                       Supplier<Long> nextEntrySeqId, boolean usingInTransitQty, String requesterId) {
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        String attrSetInstId = movementLine.getAttributeSetInstanceId();
        if(attrSetInstId == null || attrSetInstId.isEmpty()) {
            attrSetInstId = InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID;
        }
        InventoryItemId invItemId = new InventoryItemId(movementLine.getProductId(), locatorId, attrSetInstId);
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
        if (movement.getMovementDate() != null) {
            entry.setOccurredAt(new Timestamp(movement.getMovementDate().getTime()));
        } else {
            entry.setOccurredAt((Timestamp) ApplicationContext.current.getTimestampService().now(Timestamp.class));
        }
        entry.setRequesterId(requesterId);
        return entry;
    }

    private MovementState assertDocumentStatus(String docNumber, String docStatus) {
        MovementState mov = getStateRepository().get(docNumber, true);
        if (mov == null) {
            throw new IllegalArgumentException(String.format("Error document number: %1$s", docNumber));
        } else {
            if (!Objects.equals(docStatus.toLowerCase(), mov.getDocumentStatusId().toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error document status: %1$s", mov.getDocumentStatusId()));
            }
        }
        return mov;
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
            movConfirm.getCreateMovementConfirmationLineCommands().add(confirmLine);
        }
    }

    ///#endregion
    @Override
    public MovementAggregate getMovementAggregate(MovementState state) {
        return new MovementAggregateImpl(state);
    }

    public static class MovementAggregateImpl extends AbstractMovementAggregate.SimpleMovementAggregate {
        public MovementAggregateImpl(MovementState state) {
            super(state);
        }

        public void reverse(String reversalDocumentNumber, String desc, long version, String commandId, String requesterId) {
            MovementEvent.MovementStateMergePatched e = newMovementStateMergePatched(version, commandId, requesterId);
            e.setReversalDocumentNumber(reversalDocumentNumber);
            e.setDescription(desc);
            doDocumentAction(DocumentAction.REVERSE, ts -> e.setDocumentStatusId(ts));
            apply(e);
        }
    }

}
