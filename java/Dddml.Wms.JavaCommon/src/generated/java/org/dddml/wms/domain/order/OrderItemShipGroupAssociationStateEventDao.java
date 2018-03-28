package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGroupAssociationStateEventDao
{
    void save(OrderItemShipGroupAssociationStateEvent e);

    Iterable<OrderItemShipGroupAssociationStateEvent> findByOrderShipGroupEventId(OrderShipGroupEventId orderShipGroupEventId);

}

