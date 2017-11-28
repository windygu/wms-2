package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEventTypeStateQueryRepository
{
    InventoryItemEventTypeState get(String id);

    Iterable<InventoryItemEventTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryItemEventTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemEventTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryItemEventTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryItemEventTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryItemEventTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

