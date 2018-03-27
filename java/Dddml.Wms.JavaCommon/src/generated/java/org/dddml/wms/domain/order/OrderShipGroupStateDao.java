package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipGroupStateDao
{
    OrderShipGroupState get(OrderShipGroupId id, boolean nullAllowed);

    void save(OrderShipGroupState state);

    Iterable<OrderShipGroupState> findByOrderId(String orderId);

    void delete(OrderShipGroupState state);
}


