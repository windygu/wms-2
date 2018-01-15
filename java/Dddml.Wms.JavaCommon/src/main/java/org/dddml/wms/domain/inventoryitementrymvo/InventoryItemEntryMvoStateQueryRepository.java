package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEntryMvoStateQueryRepository
{
    InventoryItemEntryMvoState get(InventoryItemEntryId id);

    Iterable<InventoryItemEntryMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryItemEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryItemEntryMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryItemEntryMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryItemEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

