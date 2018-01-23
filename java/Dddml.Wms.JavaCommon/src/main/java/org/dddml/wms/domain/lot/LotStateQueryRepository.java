package org.dddml.wms.domain.lot;

import org.dddml.support.criterion.Criterion;

import java.util.List;
import java.util.Map;

public interface LotStateQueryRepository {
    LotState get(String id);

    Iterable<LotState> getAll(Integer firstResult, Integer maxResults);

    Iterable<LotState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LotState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    LotState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    LotState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<LotState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

