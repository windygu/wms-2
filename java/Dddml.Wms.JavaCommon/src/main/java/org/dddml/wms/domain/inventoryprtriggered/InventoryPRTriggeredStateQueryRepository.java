package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryPRTriggeredStateQueryRepository
{
    InventoryPRTriggeredState get(InventoryPRTriggeredId id);

    Iterable<InventoryPRTriggeredState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryPRTriggeredState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPRTriggeredState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryPRTriggeredState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryPRTriggeredState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryPRTriggeredState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

