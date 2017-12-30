package org.dddml.wms.domain.uomtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface UomTypeStateQueryRepository
{
    UomTypeState get(String id);

    Iterable<UomTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<UomTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    UomTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    UomTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<UomTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

