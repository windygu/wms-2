package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGroupAssociationEventDao
{
    void save(OrderItemShipGroupAssociationEvent e);

    Iterable<OrderItemShipGroupAssociationEvent> findByOrderShipGroupEventId(OrderShipGroupEventId orderShipGroupEventId);

}

