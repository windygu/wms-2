package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SellableInventoryItemEntryMvoApplicationService
{
    void when(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c);

    void when(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c);

    SellableInventoryItemEntryMvoState get(SellableInventoryItemEntryId id);

    Iterable<SellableInventoryItemEntryMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SellableInventoryItemEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    SellableInventoryItemEntryMvoStateEvent getStateEvent(SellableInventoryItemEntryId sellableInventoryItemEntryId, long version);

    SellableInventoryItemEntryMvoState getHistoryState(SellableInventoryItemEntryId sellableInventoryItemEntryId, long version);

}

