package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.inventoryitem.InventoryItemApplicationService;
import org.dddml.wms.domain.movement.MovementApplicationService;
import org.dddml.wms.domain.movement.MovementApplicationServiceImpl;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.dddml.wms.specialization.spring.SpringUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class MovementConfirmationApplicationServiceImpl extends AbstractMovementConfirmationApplicationService.SimpleMovementConfirmationApplicationService {

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    MovementApplicationServiceImpl getMovementApplicationService() {
        MovementApplicationService movService = (MovementApplicationService) ApplicationContext.current.get("movementApplicationService");
        if (movService instanceof MovementApplicationServiceImpl) {
            return (MovementApplicationServiceImpl) movService;
        }
        Object aopTarget = SpringUtils.getAopTarget(movService);
        return (MovementApplicationServiceImpl) aopTarget;
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public final IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public final void setSeqIdGenerator(IdGenerator<Long, Object, Object> value) {
        seqIdGenerator = value;
    }

    public MovementConfirmationApplicationServiceImpl(EventStore eventStore, MovementConfirmationStateRepository stateRepository, MovementConfirmationStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(MovementConfirmationCommands.DocumentAction c) {
        //todo
        super.when(c);
    }
}
