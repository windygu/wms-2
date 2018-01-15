package org.dddml.wms.domain.sellableinventoryitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SellableInventoryItemApplicationService
{
    void when(SellableInventoryItemCommand.CreateSellableInventoryItem c);

    void when(SellableInventoryItemCommand.MergePatchSellableInventoryItem c);

    SellableInventoryItemState get(InventoryItemId id);

    Iterable<SellableInventoryItemState> getAll(Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    SellableInventoryItemEntryState getSellableInventoryItemEntry(InventoryItemId sellableInventoryItemId, Long entrySeqId);

}

