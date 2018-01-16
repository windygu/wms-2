package org.dddml.wms.domain.party;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PartyStateQueryRepository
{
    PartyState get(String id);

    Iterable<PartyState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PartyState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PartyState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PartyState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PartyState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PartyState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    Iterable<PartyState> getAll(Class<? extends PartyState> stateType, Integer firstResult, Integer maxResults);
    
    Iterable<PartyState> get(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PartyState> get(Class<? extends PartyState> stateType, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PartyState getFirst(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PartyState getFirst(Class<? extends PartyState> stateType, Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PartyState> getByProperty(Class<? extends PartyState> stateType, String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter);

    long getCount(Class<? extends PartyState> stateType, Criterion filter);

}

