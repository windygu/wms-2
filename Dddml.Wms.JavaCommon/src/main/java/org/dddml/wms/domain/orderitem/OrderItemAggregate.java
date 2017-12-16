package org.dddml.wms.domain.orderitem;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemAggregate
{
    OrderItemState getState();

    List<Event> getChanges();

    void create(OrderItemCommand.CreateOrderItem c);

    void mergePatch(OrderItemCommand.MergePatchOrderItem c);

    void throwOnInvalidStateTransition(Command c);
}

