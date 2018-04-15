package org.dddml.wms.domain.picklist;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistApplicationService
{
    void when(PicklistCommand.CreatePicklist c);

    void when(PicklistCommand.MergePatchPicklist c);

    void when(PicklistCommand.DeletePicklist c);

    PicklistState get(String id);

    Iterable<PicklistState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PicklistState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistEvent getEvent(String picklistId, long version);

    PicklistState getHistoryState(String picklistId, long version);

    PicklistRoleState getPicklistRole(String picklistId, PartyRoleId partyRoleId);

    Iterable<PicklistRoleState> getPicklistRoles(String picklistId);

}

