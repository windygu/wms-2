package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipGroupMvoStateQueryRepository
{
    OrderShipGroupMvoState get(OrderShipGroupId id);

    Iterable<OrderShipGroupMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderShipGroupMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipGroupMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderShipGroupMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderShipGroupMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderShipGroupMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

