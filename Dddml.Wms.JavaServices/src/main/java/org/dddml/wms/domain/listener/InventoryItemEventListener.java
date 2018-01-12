package org.dddml.wms.domain.listener;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.AggregateEvent;
import org.dddml.wms.specialization.AggregateEventListener;

/**
 * Created by yangjiefeng on 2018/1/12.
 */
public class InventoryItemEventListener implements AggregateEventListener<InventoryItemAggregate, InventoryItemState> {

    @Override
    public void eventAppended(AggregateEvent<InventoryItemAggregate, InventoryItemState> e) {
        //todo
    }
}
