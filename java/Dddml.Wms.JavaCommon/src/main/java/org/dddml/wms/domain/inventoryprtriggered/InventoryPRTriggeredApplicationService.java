package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryPRTriggeredApplicationService
{
    void when(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c);

    void when(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c);

    InventoryPRTriggeredState get(InventoryPRTriggeredId id);

    Iterable<InventoryPRTriggeredState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InventoryPRTriggeredState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPRTriggeredState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InventoryPRTriggeredState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

