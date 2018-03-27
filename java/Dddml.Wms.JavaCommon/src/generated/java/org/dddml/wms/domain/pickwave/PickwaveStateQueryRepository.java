package org.dddml.wms.domain.pickwave;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PickwaveStateQueryRepository
{
    PickwaveState get(Long id);

    Iterable<PickwaveState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PickwaveState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PickwaveState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PickwaveState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PickwaveState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PickwaveState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

