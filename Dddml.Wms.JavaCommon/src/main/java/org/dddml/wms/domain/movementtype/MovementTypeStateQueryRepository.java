package org.dddml.wms.domain.movementtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementTypeStateQueryRepository
{
    MovementTypeState get(String id);

    Iterable<MovementTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<MovementTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    MovementTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    MovementTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<MovementTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

