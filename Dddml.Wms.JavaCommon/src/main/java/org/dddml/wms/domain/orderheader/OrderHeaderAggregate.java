package org.dddml.wms.domain.orderheader;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderHeaderAggregate
{
    OrderHeaderState getState();

    List<Event> getChanges();

    void create(OrderHeaderCommand.CreateOrderHeader c);

    void mergePatch(OrderHeaderCommand.MergePatchOrderHeader c);

    void throwOnInvalidStateTransition(Command c);
}

