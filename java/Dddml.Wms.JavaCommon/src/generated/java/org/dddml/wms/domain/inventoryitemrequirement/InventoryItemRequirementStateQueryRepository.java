package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementStateQueryRepository
{
    InventoryItemRequirementState get(InventoryItemId id);

    Iterable<InventoryItemRequirementState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryItemRequirementState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemRequirementState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryItemRequirementState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryItemRequirementState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryItemRequirementState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryItemRequirementEntryState getInventoryItemRequirementEntry(InventoryItemId inventoryItemRequirementId, Long entrySeqId);

    Iterable<InventoryItemRequirementEntryState> getInventoryItemRequirementEntries(InventoryItemId inventoryItemRequirementId);

}

