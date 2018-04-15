package org.dddml.wms.domain.picklistitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistItemMvoApplicationService
{
    void when(PicklistItemMvoCommand.CreatePicklistItemMvo c);

    void when(PicklistItemMvoCommand.MergePatchPicklistItemMvo c);

    void when(PicklistItemMvoCommand.DeletePicklistItemMvo c);

    PicklistItemMvoState get(PicklistBinPicklistItemId id);

    Iterable<PicklistItemMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PicklistItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistItemMvoEvent getEvent(PicklistBinPicklistItemId picklistBinPicklistItemId, long version);

    PicklistItemMvoState getHistoryState(PicklistBinPicklistItemId picklistBinPicklistItemId, long version);

}

