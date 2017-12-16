package org.dddml.wms.domain.orderheader;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderHeaderApplicationService
{
    void when(OrderHeaderCommand.CreateOrderHeader c);

    void when(OrderHeaderCommand.MergePatchOrderHeader c);

    OrderHeaderState get(String id);

    Iterable<OrderHeaderState> getAll(Integer firstResult, Integer maxResults);

    Iterable<OrderHeaderState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderHeaderState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrderHeaderState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    OrderHeaderStateEvent getStateEvent(String orderId, long version);

    OrderHeaderState getHistoryState(String orderId, long version);

}

