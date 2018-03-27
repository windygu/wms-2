package org.dddml.wms.domain.picklistrolemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistRoleMvoApplicationService
{
    void when(PicklistRoleMvoCommand.CreatePicklistRoleMvo c);

    void when(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c);

    void when(PicklistRoleMvoCommand.DeletePicklistRoleMvo c);

    PicklistRoleMvoState get(PicklistRoleId id);

    Iterable<PicklistRoleMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PicklistRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistRoleMvoStateEvent getStateEvent(PicklistRoleId picklistRoleId, long version);

    PicklistRoleMvoState getHistoryState(PicklistRoleId picklistRoleId, long version);

}

