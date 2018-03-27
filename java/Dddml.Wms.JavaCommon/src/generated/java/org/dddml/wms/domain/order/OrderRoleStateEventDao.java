package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderRoleStateEventDao
{
    void save(OrderRoleStateEvent e);

    Iterable<OrderRoleStateEvent> findByOrderEventId(OrderEventId orderEventId);

}

