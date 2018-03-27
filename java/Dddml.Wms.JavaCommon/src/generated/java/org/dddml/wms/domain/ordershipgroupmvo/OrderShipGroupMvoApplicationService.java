package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderShipGroupMvoApplicationService
{
    void when(OrderShipGroupMvoCommand.CreateOrderShipGroupMvo c);

    void when(OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo c);

    void when(OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo c);

    OrderShipGroupMvoState get(OrderShipGroupId id);

    Iterable<OrderShipGroupMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderShipGroupMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipGroupMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderShipGroupMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderShipGroupMvoStateEvent getStateEvent(OrderShipGroupId orderShipGroupId, long version);

    OrderShipGroupMvoState getHistoryState(OrderShipGroupId orderShipGroupId, long version);

}

