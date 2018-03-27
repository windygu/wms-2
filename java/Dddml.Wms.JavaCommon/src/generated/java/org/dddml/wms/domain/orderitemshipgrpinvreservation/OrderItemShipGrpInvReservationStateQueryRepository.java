package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGrpInvReservationStateQueryRepository
{
    OrderItemShipGrpInvReservationState get(OrderItemShipGrpInvResId id);

    Iterable<OrderItemShipGrpInvReservationState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderItemShipGrpInvReservationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemShipGrpInvReservationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderItemShipGrpInvReservationState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderItemShipGrpInvReservationState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderItemShipGrpInvReservationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

