package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface DamageHandlingMethodStateQueryRepository
{
    DamageHandlingMethodState get(String id);

    Iterable<DamageHandlingMethodState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<DamageHandlingMethodState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageHandlingMethodState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    DamageHandlingMethodState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    DamageHandlingMethodState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<DamageHandlingMethodState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

