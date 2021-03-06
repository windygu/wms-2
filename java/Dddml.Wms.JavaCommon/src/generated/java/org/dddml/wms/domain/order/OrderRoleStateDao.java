package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderRoleStateDao
{
    OrderRoleState get(OrderRoleId id, boolean nullAllowed);

    void save(OrderRoleState state);

    Iterable<OrderRoleState> findByOrderId(String orderId);

    void delete(OrderRoleState state);
}


