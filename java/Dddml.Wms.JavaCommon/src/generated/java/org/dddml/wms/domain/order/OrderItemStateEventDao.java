package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemStateEventDao
{
    void save(OrderItemStateEvent e);

    Iterable<OrderItemStateEvent> findByOrderEventId(OrderEventId orderEventId);

}

