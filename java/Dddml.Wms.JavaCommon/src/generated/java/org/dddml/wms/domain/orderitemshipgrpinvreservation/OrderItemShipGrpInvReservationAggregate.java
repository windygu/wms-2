package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemShipGrpInvReservationAggregate
{
    OrderItemShipGrpInvReservationState getState();

    List<Event> getChanges();

    void create(OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation c);

    void mergePatch(OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation c);

    void delete(OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation c);

    void throwOnInvalidStateTransition(Command c);
}

