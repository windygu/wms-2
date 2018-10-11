package org.dddml.wms.domain.order;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderAggregate
{
    OrderState getState();

    List<Event> getChanges();

    void create(OrderCommand.CreateOrder c);

    void mergePatch(OrderCommand.MergePatchOrder c);

    void orderShipGroupAction(String shipGroupSeqId, String value, Long version, String commandId, String requesterId, OrderCommands.OrderShipGroupAction c);

    void throwOnInvalidStateTransition(Command c);
}

