package org.dddml.wms.domain.picklistitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistItemMvoStateQueryRepository
{
    PicklistItemMvoState get(PicklistBinPicklistItemId id);

    Iterable<PicklistItemMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PicklistItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PicklistItemMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PicklistItemMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PicklistItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

