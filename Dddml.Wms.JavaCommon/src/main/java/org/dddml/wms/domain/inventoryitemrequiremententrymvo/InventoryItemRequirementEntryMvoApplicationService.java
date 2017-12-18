package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemRequirementEntryMvoApplicationService
{
    void when(InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo c);

    void when(InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo c);

    InventoryItemRequirementEntryMvoState get(InventoryItemRequirementEntryId id);

    Iterable<InventoryItemRequirementEntryMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InventoryItemRequirementEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemRequirementEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemRequirementEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryItemRequirementEntryMvoStateEvent getStateEvent(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, long version);

    InventoryItemRequirementEntryMvoState getHistoryState(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, long version);

}

