package org.dddml.wms.domain.orderitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderItemApplicationService
{
    void when(OrderItemCommand.CreateOrderItem c);

    void when(OrderItemCommand.MergePatchOrderItem c);

    OrderItemState get(OrderItemId id);

    Iterable<OrderItemState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderItemStateEvent getStateEvent(OrderItemId orderItemId, long version);

    OrderItemState getHistoryState(OrderItemId orderItemId, long version);

}

