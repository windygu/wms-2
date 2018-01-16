package org.dddml.wms.domain.damagereason;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface DamageReasonStateQueryRepository
{
    DamageReasonState get(String id);

    Iterable<DamageReasonState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<DamageReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    DamageReasonState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    DamageReasonState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<DamageReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

