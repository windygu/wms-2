package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipGroupEventDao
{
    void save(OrderShipGroupEvent e);

    Iterable<OrderShipGroupEvent> findByOrderEventId(OrderEventId orderEventId);

}

