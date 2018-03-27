package org.dddml.wms.domain.orderrolemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderRoleMvoApplicationService
{
    void when(OrderRoleMvoCommand.CreateOrderRoleMvo c);

    void when(OrderRoleMvoCommand.MergePatchOrderRoleMvo c);

    void when(OrderRoleMvoCommand.DeleteOrderRoleMvo c);

    OrderRoleMvoState get(OrderRoleId id);

    Iterable<OrderRoleMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderRoleMvoStateEvent getStateEvent(OrderRoleId orderRoleId, long version);

    OrderRoleMvoState getHistoryState(OrderRoleId orderRoleId, long version);

}

