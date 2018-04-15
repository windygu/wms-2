package org.dddml.wms.domain.locatortype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface LocatorTypeApplicationService
{
    void when(LocatorTypeCommand.CreateLocatorType c);

    void when(LocatorTypeCommand.MergePatchLocatorType c);

    void when(LocatorTypeCommand.DeleteLocatorType c);

    LocatorTypeState get(String id);

    Iterable<LocatorTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<LocatorTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    LocatorTypeEvent getEvent(String locatorTypeId, long version);

    LocatorTypeState getHistoryState(String locatorTypeId, long version);

}

