package org.dddml.wms.domain.roletype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface RoleTypeStateQueryRepository
{
    RoleTypeState get(String id);

    Iterable<RoleTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<RoleTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RoleTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    RoleTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    RoleTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<RoleTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

