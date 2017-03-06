package org.dddml.wms.domain.organization;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrganizationStateQueryRepository
{
    OrganizationState get(String id);

    Iterable<OrganizationState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrganizationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrganizationState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrganizationState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrganizationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

