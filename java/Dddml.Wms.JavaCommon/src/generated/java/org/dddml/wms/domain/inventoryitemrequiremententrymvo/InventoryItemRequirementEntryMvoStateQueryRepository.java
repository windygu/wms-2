package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementEntryMvoStateQueryRepository
{
    InventoryItemRequirementEntryMvoState get(InventoryItemRequirementEntryId id);

    Iterable<InventoryItemRequirementEntryMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryItemRequirementEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryItemRequirementEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryItemRequirementEntryMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryItemRequirementEntryMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryItemRequirementEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

