package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderRoleEventDao
{
    void save(OrderRoleEvent e);

    Iterable<OrderRoleEvent> findByOrderEventId(OrderEventId orderEventId);

}

