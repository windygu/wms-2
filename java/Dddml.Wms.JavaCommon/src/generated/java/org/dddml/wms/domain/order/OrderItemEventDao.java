package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemEventDao
{
    void save(OrderItemEvent e);

    Iterable<OrderItemEvent> findByOrderEventId(OrderEventId orderEventId);

}

