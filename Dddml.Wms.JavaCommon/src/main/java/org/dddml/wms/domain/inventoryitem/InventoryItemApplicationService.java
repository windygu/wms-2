package org.dddml.wms.domain.inventoryitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemApplicationService
{
    void when(InventoryItemCommand.CreateInventoryItem c);

    void when(InventoryItemCommand.MergePatchInventoryItem c);

    InventoryItemState get(InventoryItemId id);

    Iterable<InventoryItemState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryItemStateEvent getStateEvent(InventoryItemId inventoryItemId, long version);

    InventoryItemState getHistoryState(InventoryItemId inventoryItemId, long version);

    InventoryItemEntryState getInventoryItemEntry(InventoryItemId inventoryItemId, Long entrySeqId);

}

