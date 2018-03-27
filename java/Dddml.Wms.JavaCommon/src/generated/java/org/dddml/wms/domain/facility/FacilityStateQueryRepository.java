package org.dddml.wms.domain.facility;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface FacilityStateQueryRepository
{
    FacilityState get(String id);

    Iterable<FacilityState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<FacilityState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<FacilityState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    FacilityState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    FacilityState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<FacilityState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

