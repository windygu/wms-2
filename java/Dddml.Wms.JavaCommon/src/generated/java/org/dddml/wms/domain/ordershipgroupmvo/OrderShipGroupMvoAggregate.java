package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.List;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderShipGroupMvoAggregate
{
    OrderShipGroupMvoState getState();

    List<Event> getChanges();

    void create(OrderShipGroupMvoCommand.CreateOrderShipGroupMvo c);

    void mergePatch(OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo c);

    void delete(OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo c);

    void throwOnInvalidStateTransition(Command c);
}

