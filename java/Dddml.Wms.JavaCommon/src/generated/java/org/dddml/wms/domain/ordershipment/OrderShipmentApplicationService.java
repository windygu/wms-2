package org.dddml.wms.domain.ordershipment;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderShipmentApplicationService
{
    void when(OrderShipmentCommand.CreateOrderShipment c);

    void when(OrderShipmentCommand.MergePatchOrderShipment c);

    OrderShipmentState get(OrderShipmentId id);

    Iterable<OrderShipmentState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderShipmentEvent getEvent(OrderShipmentId orderShipmentId, long version);

    OrderShipmentState getHistoryState(OrderShipmentId orderShipmentId, long version);

}

