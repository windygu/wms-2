package org.dddml.wms.domain.picklist;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public interface PicklistStateQueryRepository
{
    PicklistState get(String id);

    Iterable<PicklistState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PicklistState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PicklistState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PicklistState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PicklistState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistRoleState getPicklistRole(String picklistId, PartyRoleId partyRoleId);

}

