package org.dddml.wms.domain.sellableinventoryitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public interface SellableInventoryItemStateQueryRepository
{
    SellableInventoryItemState get(InventoryItemId id);

    Iterable<SellableInventoryItemState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<SellableInventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    SellableInventoryItemState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    SellableInventoryItemState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<SellableInventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    SellableInventoryItemEntryState getSellableInventoryItemEntry(InventoryItemId sellableInventoryItemId, Long entrySeqId);

}

