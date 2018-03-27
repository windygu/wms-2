package org.dddml.wms.domain.picklistbin;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistBinStateQueryRepository
{
    PicklistBinState get(String id);

    Iterable<PicklistBinState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PicklistBinState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistBinState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PicklistBinState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PicklistBinState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PicklistBinState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistItemState getPicklistItem(String picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

}

