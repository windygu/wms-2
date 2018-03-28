package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGroupAssociationMvoStateQueryRepository
{
    OrderItemShipGroupAssociationMvoState get(OrderItemShipGroupAssociationId id);

    Iterable<OrderItemShipGroupAssociationMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<OrderItemShipGroupAssociationMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderItemShipGroupAssociationMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    OrderItemShipGroupAssociationMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    OrderItemShipGroupAssociationMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<OrderItemShipGroupAssociationMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

