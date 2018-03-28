package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.List;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemShipGroupAssociationMvoAggregate
{
    OrderItemShipGroupAssociationMvoState getState();

    List<Event> getChanges();

    void create(OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo c);

    void mergePatch(OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo c);

    void delete(OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo c);

    void throwOnInvalidStateTransition(Command c);
}

