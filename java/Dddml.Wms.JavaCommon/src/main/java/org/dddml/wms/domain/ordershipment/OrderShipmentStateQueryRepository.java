package org.dddml.wms.domain.ordershipment;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipmentStateQueryRepository
{
    OrderShipmentState get(OrderShipmentId id);

    Iterable<OrderShipmentState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderShipmentState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderShipmentState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

