package org.dddml.wms.domain.inventoryitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemStateQueryRepository
{
    InventoryItemState get(InventoryItemId id);

    Iterable<InventoryItemState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryItemState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryItemState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryItemEntryState getInventoryItemEntry(InventoryItemId inventoryItemId, Long entrySeqId);

    Iterable<InventoryItemEntryState> getInventoryItemEntries(InventoryItemId inventoryItemId);

}

