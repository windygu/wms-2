package org.dddml.wms.domain.order;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderAggregate
{
    OrderState getState();

    List<Event> getChanges();

    void create(OrderCommand.CreateOrder c);

    void mergePatch(OrderCommand.MergePatchOrder c);

    void throwOnInvalidStateTransition(Command c);
}

