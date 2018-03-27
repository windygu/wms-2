package org.dddml.wms.domain.picklistrolemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistRoleMvoStateQueryRepository
{
    PicklistRoleMvoState get(PicklistRoleId id);

    Iterable<PicklistRoleMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PicklistRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PicklistRoleMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PicklistRoleMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PicklistRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

