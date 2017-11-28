package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemEventTypeApplicationService
{
    void when(InventoryItemEventTypeCommand.CreateInventoryItemEventType c);

    void when(InventoryItemEventTypeCommand.MergePatchInventoryItemEventType c);

    void when(InventoryItemEventTypeCommand.DeleteInventoryItemEventType c);

    InventoryItemEventTypeState get(String id);

    Iterable<InventoryItemEventTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InventoryItemEventTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemEventTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemEventTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryItemEventTypeStateEvent getStateEvent(String inventoryItemEventTypeId, long version);

    InventoryItemEventTypeState getHistoryState(String inventoryItemEventTypeId, long version);

}

