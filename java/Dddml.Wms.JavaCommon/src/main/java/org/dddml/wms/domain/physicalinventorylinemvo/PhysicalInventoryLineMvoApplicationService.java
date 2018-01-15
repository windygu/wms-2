package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PhysicalInventoryLineMvoApplicationService
{
    void when(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c);

    void when(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c);

    void when(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c);

    PhysicalInventoryLineMvoState get(PhysicalInventoryLineId id);

    Iterable<PhysicalInventoryLineMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PhysicalInventoryLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PhysicalInventoryLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PhysicalInventoryLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PhysicalInventoryLineMvoStateEvent getStateEvent(PhysicalInventoryLineId physicalInventoryLineId, long version);

    PhysicalInventoryLineMvoState getHistoryState(PhysicalInventoryLineId physicalInventoryLineId, long version);

}

