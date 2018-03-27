package org.dddml.wms.domain.orderrolemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderRoleMvoStateQueryRepository
{
    OrderRoleMvoState get(OrderRoleId id);

    Iterable<OrderRoleMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderRoleMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderRoleMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

