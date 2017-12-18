package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemStateDao
{
    OrderItemState get(OrderItemId id, boolean nullAllowed);

    void save(OrderItemState state);

    Iterable<OrderItemState> findByOrderId(String orderId);

    void delete(OrderItemState state);
}


