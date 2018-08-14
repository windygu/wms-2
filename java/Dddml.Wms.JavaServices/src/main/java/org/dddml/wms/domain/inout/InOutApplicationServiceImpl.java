package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceUtils;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class InOutApplicationServiceImpl extends AbstractInOutApplicationService.SimpleInOutApplicationService {

    ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    AttributeSetInstanceApplicationService getAttributeSetInstanceApplicationService() {
        return (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
    }

    AttributeSetService getAttributeSetService() {
        return (AttributeSetService) ApplicationContext.current.get("attributeSetService");
    }

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public void setSeqIdGenerator(IdGenerator<Long, Object, Object> seqIdGenerator) {
        this.seqIdGenerator = seqIdGenerator;
    }

    public InOutApplicationServiceImpl(EventStore eventStore, InOutStateRepository stateRepository, InOutStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(InOutCommands.DocumentAction c) {
        //
        // 注意：这里通过覆写父类方法，加上事务注解，其实没有遵循“聚合外最终一致”的处理原则。
        //
        if (Objects.equals(c.getValue(), DocumentAction.COMPLETE)) {
            // 操作出入库单（IN_OUT）
            InOutState inOut = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
            // 操作库存（InventoryItem）
            List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = completeInOutCreateInventoryItemEntries(inOut);
            InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);
            super.when(c);
        } else if (Objects.equals(c.getValue(), DocumentAction.REVERSE)) {
            InOutState srcInOut = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.COMPLETED);
            InOutCommand.CreateInOut reversalInOutInfo = createReversalInOutAndCompleteAndClose(c, srcInOut);
            reverseUpdateSourceInOut(c, reversalInOutInfo);
            //super.when(c);
        } else {
            super.when(c);
        }
    }

    private void reverseUpdateSourceInOut(InOutCommands.DocumentAction c, InOutCommand.CreateInOut reversalInOutInfo) {
        //源单据前向关联到反转单据：
        String reversalDocumentNumber = reversalInOutInfo.getDocumentNumber();
        String description = "(" + reversalInOutInfo.getDocumentNumber() + "<-)";//(1000016<-)
        update(c, ar -> ((InOutAggregateImpl) ar)
                .reverse(reversalDocumentNumber, description, c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    private InOutCommand.CreateInOut createReversalInOutAndCompleteAndClose(InOutCommands.DocumentAction c, InOutState inOut) {
        InOutCommand.CreateInOut createReversalInOut = createReversalInOut(inOut);

        when(createReversalInOut);
        long firstVersion = 0;//!!!

        InOutCommands.Complete completeCmd = new InOutCommands.Complete();
        completeCmd.setDocumentNumber(createReversalInOut.getDocumentNumber());
        completeCmd.setVersion(firstVersion);
        completeCmd.setCommandId(c.getCommandId());
        completeCmd.setRequesterId(c.getRequesterId());
        when(completeCmd);

        InOutCommands.Close closeCmd = new InOutCommands.Close();
        closeCmd.setDocumentNumber(createReversalInOut.getDocumentNumber());
        closeCmd.setVersion(firstVersion + 1);
        closeCmd.setCommandId(c.getCommandId());
        closeCmd.setRequesterId(c.getRequesterId());
        when(closeCmd);

        return createReversalInOut;
    }

    protected InOutCommand.CreateInOut createReversalInOut(InOutState inOut) {
        InOutCommand.CreateInOut reversalInOut = doCreateReversalInOut(inOut);

        for (InOutLineState d : inOut.getInOutLines()) {
            InOutLineCommand.CreateInOutLine r = doCreateReversalInOutLine(d);
            reversalInOut.getInOutLines().add(r);
        }

        return reversalInOut;
    }

    /**
     * 生成反转的单据（但不包括行）。
     */
    protected InOutCommand.CreateInOut doCreateReversalInOut(InOutState inOut) {
        InOutCommand.CreateInOut reversalInOut = new AbstractInOutCommand.SimpleCreateInOut();

        //reversalInOut.Organization = inOut.Organization;//？
        //reversalInOut.Client = inOut.Client;
        //reversalInOut.CreatedBy = reversalInOut.UpdatedBy = Context.User;
        //reversalInOut.CreationTime = reversalInOut.UpdateTime = now;

        //生成新的单号:
        reversalInOut.setDocumentNumber("RIO" + getSeqIdGenerator().getNextId()); //DocumentNumberGenerator.GetNewDocumentNumber();
        //设置反转关系:
        reversalInOut.setReversalDocumentNumber(inOut.getDocumentNumber());
        //inOut.Reversal = reversalInOut;
        ////源单据前向关联到反转单据:
        //inOut.Description = "(" + reversalInOut.DocumentNumber + "<-)";//(1000016<-)
        //反转单据后向关联到源单据:
        reversalInOut.setDescription("{->" + inOut.getDocumentNumber() + ")"); //{->1000015)

        //reversalInOut.IsSOTransaction = inOut.IsSOTransaction;
        //reversalInOut. DocumentStatus
        //reversalInOut.Posted = inOut.Posted;//??
        //reversalInOut.Processing = inOut.Processing;
        //reversalInOut.Processed = inOut.Processed;
        reversalInOut.setDocumentTypeId(inOut.getDocumentTypeId());
        reversalInOut.setOrderId(inOut.getOrderId());
        reversalInOut.setDateOrdered(inOut.getDateOrdered());
        //reversalInOut.IsPrinted
        reversalInOut.setMovementTypeId(inOut.getMovementTypeId());
        reversalInOut.setMovementDate(inOut.getMovementDate());
        reversalInOut.setBusinessPartnerId(inOut.getBusinessPartnerId());
        reversalInOut.setWarehouseId(inOut.getWarehouseId());
        //reversalInOut.FreightAmount;
        //reversalInOut.Shipper
        //reversalInOut.ChargeAmount??
        //reversalInOut.DatePrinted;
        //reversalInOut.CreateFrom
        //reversalInOut.GenerateTo
        //reversalInOut.User = inOut.User;
        //reversalInOut.SalesRepresentative
        reversalInOut.setNumberOfPackages(inOut.getNumberOfPackages());
        //reversalInOut.PickDate
        //reversalInOut.ShipDate
        reversalInOut.setTrackingNumber(inOut.getTrackingNumber());
        //reversalInOut.DateReceived
        //reversalInOut.IsInTransit
        //reversalInOut.IsApproved;
        //reversalInOut.IsInDispute
        //reversalInOut.Volume = inOut.Volume;
        //reversalInOut.Weight = inOut.Weight;
        //reversalInOut.Rma = inOut.Rma;
        //reversalInOut.IsDropShip = inOut.IsDropShip;
        return reversalInOut;
    }

    /**
     * 生成反转的行。
     */
    protected InOutLineCommand.CreateInOutLine doCreateReversalInOutLine(InOutLineState inOutLine) {
        InOutLineCommand.CreateInOutLine reversalLine = new AbstractInOutLineCommand.SimpleCreateInOutLine();
        reversalLine.setReversalLineNumber(inOutLine.getLineNumber()); //设置反转行
        //reversalLine.Organization = Context.Organization;//？
        //reversalLine.UpdatedBy = Context.User;
        //reversalLine.UpdateTime = now;
        //reversalLine.CreatedBy = Context.User;
        //reversalLine.CreationTime = now;
        reversalLine.setProductId(inOutLine.getProductId());
        reversalLine.setLocatorId(inOutLine.getLocatorId());
        reversalLine.setAttributeSetInstanceId(inOutLine.getAttributeSetInstanceId());

        //reversalLine.IsDescription = inOutLine.IsDescription;
        reversalLine.setIsInvoiced(inOutLine.getIsInvoiced());
        reversalLine.setLineNumber(inOutLine.getLineNumber());
        //reversalLine.RmaLine = inOutLine.RmaLine;
        reversalLine.setProcessed(inOutLine.getProcessed());
        //reversalLine.RmaLine = inOutLine.RmaLine;
        reversalLine.setQuantityUomId(inOutLine.getQuantityUomId());

        //数量全部反转？
        reversalLine.setMovementQuantity(inOutLine.getMovementQuantity().negate());
        //reversalLine.QuantityEntered = -inOutLine.QuantityEntered;
        //reversalLine.ScrappedQuantity = -inOutLine.ScrappedQuantity;
        //reversalLine.PickedQuantity = -inOutLine.PickedQuantity;
        //reversalLine.TargetQuantity = -inOutLine.TargetQuantity;

        return reversalLine;
    }

    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> completeInOutCreateInventoryItemEntries(InOutState inOut) {
        //int signum = GetSignumOfMovementType(inOut.MovementTypeId);
        InOutLineStates ioLines = inOut.getInOutLines();
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (InOutLineState d : ioLines) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(inOut, d);// signum);
            entries.add(e);
        }
        return entries;
    }

    protected InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(InOutState inOut, InOutLineState inOutLine) {
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        String attrSetInstId = inOutLine.getAttributeSetInstanceId();
        if(attrSetInstId == null || attrSetInstId.isEmpty()) {
            attrSetInstId = InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID;
        }
        entry.setInventoryItemId(new InventoryItemId(inOutLine.getProductId(), inOutLine.getLocatorId(), attrSetInstId));
        entry.setEntrySeqId(getSeqIdGenerator().getNextId());//DateTime.Now.Ticks;
        entry.setOnHandQuantity(inOutLine.getMovementQuantity());// *signum;
        entry.setSource(new InventoryItemSourceInfo(DocumentTypeIds.IN_OUT, inOut.getDocumentNumber(), inOutLine.getLineNumber(), 0));
        return entry;
    }

    private InOutState assertDocumentStatus(String docNumber, String docStatus) {
        InOutState inOut = getStateRepository().get(docNumber, true);
        if (inOut == null) {
            throw new IllegalArgumentException(String.format("Error document number: %1$s", docNumber));
        } else {
            if (!Objects.equals(docStatus.toLowerCase(), inOut.getDocumentStatusId().toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error document status: %1$s", inOut.getDocumentStatusId()));
            }
        }
        return inOut;
    }


    @Override
    @Transactional
    public void when(InOutCommands.Complete c) {
        when(newDocumentAction(DocumentAction.COMPLETE, c));
    }

    @Override
    @Transactional
    public void when(InOutCommands.Close c) {
        when(newDocumentAction(DocumentAction.CLOSE, c));
    }

    @Override
    @Transactional
    public void when(InOutCommands.Void c) {
        when(newDocumentAction(DocumentAction.VOID, c));
    }

    @Override
    @Transactional
    public void when(InOutCommands.Reverse c) {
        when(newDocumentAction(DocumentAction.REVERSE, c));
    }

    @Override
    @Transactional
    public void when(InOutCommands.AddLine c) {
        InOutState inOut = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
        InOutLineCommand.CreateInOutLine createLine = createInOutLine(c);
        InOutCommand.MergePatchInOut updateInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
        updateInOut.setDocumentNumber(c.getDocumentNumber());
        updateInOut.setVersion(inOut.getVersion());
        updateInOut.setCommandId(c.getCommandId());
        updateInOut.setRequesterId(c.getRequesterId());
        updateInOut.getInOutLineCommands().add(createLine);
        when(updateInOut);
    }


    private InOutLineCommand.CreateInOutLine createInOutLine(InOutCommands.AddLine d) {
        InOutLineCommand.CreateInOutLine line = new AbstractInOutLineCommand.SimpleCreateInOutLine();

        ProductState prdState = getProductState(d.getProductId());

        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(getAttributeSetService(), getAttributeSetInstanceApplicationService(), prdState.getAttributeSetId(), d.getAttributeSetInstance());
        //if (_log.IsDebugEnabled) {
        //    _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //}

        line.setLineNumber(d.getLineNumber());
        line.setProductId(prdState.getProductId());
        line.setLocatorId(d.getLocatorId());
        line.setAttributeSetInstanceId(attrSetInstId);
        line.setQuantityUomId(d.getQuantityUomId());
        line.setMovementQuantity(d.getMovementQuantity());
        line.setDescription(d.getDescription());
        line.setDamageStatusIds(d.getDamageStatusIds() == null ? null : new HashSet<>(d.getDamageStatusIds()));
        line.setActive(true);
        //todo More proerties???
        return line;
    }

    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }


    private static InOutCommands.DocumentAction newDocumentAction(String value, InOutCommand c) {
        InOutCommands.DocumentAction a = new InOutCommands.DocumentAction();
        a.setValue(value);
        a.setDocumentNumber(c.getDocumentNumber());
        a.setVersion(c.getVersion());
        a.setCommandId(c.getCommandId());
        a.setRequesterId(c.getRequesterId());
        return a;
    }

    @Override
    public InOutAggregate getInOutAggregate(InOutState state) {
        return new InOutAggregateImpl(state);
    }

    public static class InOutAggregateImpl extends AbstractInOutAggregate.SimpleInOutAggregate {
        public InOutAggregateImpl(InOutState state) {
            super(state);
        }

        public void reverse(String reversalDocumentNumber, String desc, long version, String commandId, String requesterId) {
            InOutEvent.InOutStateMergePatched e = newInOutStateMergePatched(version, commandId, requesterId);
            e.setReversalDocumentNumber(reversalDocumentNumber);
            e.setDescription(desc);
            doDocumentAction(DocumentAction.REVERSE, ts -> e.setDocumentStatusId(ts));
            apply(e);
        }
    }

}
