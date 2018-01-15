package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.specialization.EventStore;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class InOutApplicationServiceImpl extends AbstractInOutApplicationService.SimpleInOutApplicationService {

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
            // todo
            // 操作出入库单（InOut）
            // 操作库存（InventoryItem）
            //            var inOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
            //            var inventoryItemEntries = CompleteInOutCreateInventoryItemEntries(inOut);
            //            CreateOrUpdateInventoryItems(inventoryItemEntries);
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
