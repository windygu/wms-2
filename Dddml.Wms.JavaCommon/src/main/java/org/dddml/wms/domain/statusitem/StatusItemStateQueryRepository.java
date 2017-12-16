package org.dddml.wms.domain.statusitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface StatusItemStateQueryRepository
{
    StatusItemState get(String id);

    Iterable<StatusItemState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<StatusItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<StatusItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    StatusItemState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    StatusItemState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<StatusItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

