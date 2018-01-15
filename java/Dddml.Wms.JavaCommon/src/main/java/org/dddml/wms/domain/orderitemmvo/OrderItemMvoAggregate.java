package org.dddml.wms.domain.orderitemmvo;

import java.util.List;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemMvoAggregate
{
    OrderItemMvoState getState();

    List<Event> getChanges();

    void create(OrderItemMvoCommand.CreateOrderItemMvo c);

    void mergePatch(OrderItemMvoCommand.MergePatchOrderItemMvo c);

    void throwOnInvalidStateTransition(Command c);
}

