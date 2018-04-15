package org.dddml.wms.domain.roletype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface RoleTypeApplicationService
{
    void when(RoleTypeCommand.CreateRoleType c);

    void when(RoleTypeCommand.MergePatchRoleType c);

    void when(RoleTypeCommand.DeleteRoleType c);

    RoleTypeState get(String id);

    Iterable<RoleTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<RoleTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RoleTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RoleTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    RoleTypeEvent getEvent(String roleTypeId, long version);

    RoleTypeState getHistoryState(String roleTypeId, long version);

}

