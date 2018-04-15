package org.dddml.wms.domain.orderitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemMvoApplicationService
{
    void when(OrderItemMvoCommand.CreateOrderItemMvo c);

    void when(OrderItemMvoCommand.MergePatchOrderItemMvo c);

    OrderItemMvoState get(OrderItemId id);

    Iterable<OrderItemMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderItemMvoEvent getEvent(OrderItemId orderItemId, long version);

    OrderItemMvoState getHistoryState(OrderItemId orderItemId, long version);

}

