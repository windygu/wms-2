package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipGroupStateEventDao
{
    void save(OrderShipGroupStateEvent e);

    Iterable<OrderShipGroupStateEvent> findByOrderEventId(OrderEventId orderEventId);

}

