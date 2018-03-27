package org.dddml.wms.domain.order;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public interface OrderStateQueryRepository
{
    OrderState get(String id);

    Iterable<OrderState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderRoleState getOrderRole(String orderId, PartyRoleId partyRoleId);

    OrderItemState getOrderItem(String orderId, String orderItemSeqId);

    OrderShipGroupState getOrderShipGroup(String orderId, Long shipGroupSeqId);

}

