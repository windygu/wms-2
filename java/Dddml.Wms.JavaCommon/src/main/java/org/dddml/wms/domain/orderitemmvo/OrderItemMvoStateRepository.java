package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemMvoStateRepository
{
    OrderItemMvoState get(OrderItemId id, boolean nullAllowed);

    void save(OrderItemMvoState state);

}

