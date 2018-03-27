package org.dddml.wms.domain.orderrolemvo;

import java.util.List;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderRoleMvoAggregate
{
    OrderRoleMvoState getState();

    List<Event> getChanges();

    void create(OrderRoleMvoCommand.CreateOrderRoleMvo c);

    void mergePatch(OrderRoleMvoCommand.MergePatchOrderRoleMvo c);

    void delete(OrderRoleMvoCommand.DeleteOrderRoleMvo c);

    void throwOnInvalidStateTransition(Command c);
}

