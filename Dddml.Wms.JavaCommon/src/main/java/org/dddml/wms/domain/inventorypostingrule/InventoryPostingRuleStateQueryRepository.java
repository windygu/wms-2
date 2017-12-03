package org.dddml.wms.domain.inventorypostingrule;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryPostingRuleStateQueryRepository
{
    InventoryPostingRuleState get(String id);

    Iterable<InventoryPostingRuleState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InventoryPostingRuleState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPostingRuleState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InventoryPostingRuleState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InventoryPostingRuleState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InventoryPostingRuleState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

