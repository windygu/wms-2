package org.dddml.wms.domain.inout;

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
        //todo
        super.when(c);
    }
}
