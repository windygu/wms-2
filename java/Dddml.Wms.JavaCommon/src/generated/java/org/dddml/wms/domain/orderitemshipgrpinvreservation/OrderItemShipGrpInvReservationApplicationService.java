package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemShipGrpInvReservationApplicationService
{
    void when(OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation c);

    void when(OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation c);

    void when(OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation c);

    OrderItemShipGrpInvReservationState get(OrderItemShipGrpInvResId id);

    Iterable<OrderItemShipGrpInvReservationState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderItemShipGrpInvReservationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemShipGrpInvReservationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemShipGrpInvReservationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderItemShipGrpInvReservationStateEvent getStateEvent(OrderItemShipGrpInvResId orderItemShipGrpInvResId, long version);

    OrderItemShipGrpInvReservationState getHistoryState(OrderItemShipGrpInvResId orderItemShipGrpInvResId, long version);

}

