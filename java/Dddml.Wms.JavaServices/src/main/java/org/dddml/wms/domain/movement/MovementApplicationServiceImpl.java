package org.dddml.wms.domain.movement;

import org.dddml.wms.specialization.EventStore;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class MovementApplicationServiceImpl extends AbstractMovementApplicationService.SimpleMovementApplicationService {

    public MovementApplicationServiceImpl(EventStore eventStore, MovementStateRepository stateRepository, MovementStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(MovementCommands.DocumentAction c) {
        //todo
        super.when(c);
    }
}
