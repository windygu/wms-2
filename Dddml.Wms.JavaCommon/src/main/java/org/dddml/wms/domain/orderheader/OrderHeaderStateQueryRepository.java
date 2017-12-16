package org.dddml.wms.domain.orderheader;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderHeaderStateQueryRepository
{
    OrderHeaderState get(String id);

    Iterable<OrderHeaderState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderHeaderState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderHeaderState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderHeaderState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderHeaderState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderHeaderState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

