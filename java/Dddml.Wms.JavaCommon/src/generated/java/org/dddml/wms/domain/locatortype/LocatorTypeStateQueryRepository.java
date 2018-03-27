package org.dddml.wms.domain.locatortype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface LocatorTypeStateQueryRepository
{
    LocatorTypeState get(String id);

    Iterable<LocatorTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<LocatorTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    LocatorTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    LocatorTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<LocatorTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

