package org.dddml.wms.domain.uom;

import org.dddml.support.criterion.Criterion;

import java.util.List;
import java.util.Map;

public interface UomStateQueryRepository {
    UomState get(String id);

    Iterable<UomState> getAll(Integer firstResult, Integer maxResults);

    Iterable<UomState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    UomState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    UomState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<UomState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

