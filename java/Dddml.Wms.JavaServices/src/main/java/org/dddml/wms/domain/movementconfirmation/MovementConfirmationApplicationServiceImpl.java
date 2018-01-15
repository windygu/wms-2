package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.specialization.EventStore;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class MovementConfirmationApplicationServiceImpl extends AbstractMovementConfirmationApplicationService.SimpleMovementConfirmationApplicationService {

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
