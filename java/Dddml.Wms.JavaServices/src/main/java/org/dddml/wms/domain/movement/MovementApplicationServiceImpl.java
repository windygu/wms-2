package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.inventoryitem.InventoryItemApplicationService;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationApplicationService;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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


}
