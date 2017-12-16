package org.dddml.wms.domain.orderitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemStateQueryRepository
{
    OrderItemState get(OrderItemId id);

    Iterable<OrderItemState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderItemState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderItemState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

