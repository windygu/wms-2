package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class InOutApplicationServiceImpl extends AbstractInOutApplicationService.SimpleInOutApplicationService {

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
        if (c.getValue().equals(DocumentAction.COMPLETE)) {
            //
            // 注意：这里通过覆写父类方法，加上事务注解，其实没有遵循“聚合外最终一致”的处理原则。
            //
            // 操作出入库单（IN_OUT）
            InOutState inOut = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
            // 操作库存（InventoryItem）
            List<InventoryItemEntryCommand.CreateInventoryItemEntry>  inventoryItemEntries = completeInOutCreateInventoryItemEntries(inOut);
            InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);
            super.when(c);
        } else if (c.getValue().equals(DocumentAction.REVERSE)) {
            //            var srcInOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);
            //            var reversalInOutInfo = CreateReversalInOutAndCompleteAndClose(c, srcInOut);
            //            ReverseUpdateSourceInOut(c, reversalInOutInfo);
            super.when(c);
        } else {
            super.when(c);
        }
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
        entry.setInventoryItemId(new InventoryItemId(inOutLine.getProductId(), inOutLine.getLocatorId(), inOutLine.getAttributeSetInstanceId()));
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

    private static InOutCommands.DocumentAction newDocumentAction(String value, InOutCommand c) {
        InOutCommands.DocumentAction a = new InOutCommands.DocumentAction();
        a.setValue(value);
        a.setDocumentNumber(c.getDocumentNumber());
        a.setVersion(c.getVersion());
        a.setCommandId(c.getCommandId());
        a.setRequesterId(c.getRequesterId());
        return a;
    }

}
