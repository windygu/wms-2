package org.dddml.wms.domain.party;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PersonStateQueryRepository
{
    PersonState get(String id);

    Iterable<PersonState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PersonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PersonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PersonState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PersonState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PersonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

