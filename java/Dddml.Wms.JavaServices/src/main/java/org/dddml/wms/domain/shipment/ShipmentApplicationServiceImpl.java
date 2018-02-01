package org.dddml.wms.domain.shipment;

import org.dddml.wms.specialization.EventStore;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangjiefeng on 2018/2/1.
 */
public class ShipmentApplicationServiceImpl extends AbstractShipmentApplicationService.SimpleShipmentApplicationService {

    public ShipmentApplicationServiceImpl(EventStore eventStore, ShipmentStateRepository stateRepository, ShipmentStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.Import c) {
        //todo
        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ReceiveItem c) {
        //todo
        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ConfirmAllItemsReceived c) {
        //todo
        super.when(c);
    }
}
