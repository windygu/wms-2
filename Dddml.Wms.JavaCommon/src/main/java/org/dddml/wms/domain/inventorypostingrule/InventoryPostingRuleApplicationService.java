package org.dddml.wms.domain.inventorypostingrule;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryPostingRuleApplicationService
{
    void when(InventoryPostingRuleCommand.CreateInventoryPostingRule c);

    void when(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c);

    void when(InventoryPostingRuleCommand.DeleteInventoryPostingRule c);

    InventoryPostingRuleState get(String id);

    Iterable<InventoryPostingRuleState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InventoryPostingRuleState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPostingRuleState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPostingRuleState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InventoryPostingRuleStateEvent getStateEvent(String inventoryPostingRuleId, long version);

    InventoryPostingRuleState getHistoryState(String inventoryPostingRuleId, long version);

}

