package org.dddml.wms.domain.orderitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemMvoStateQueryRepository
{
    OrderItemMvoState get(OrderItemId id);

    Iterable<OrderItemMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderItemMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderItemMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

