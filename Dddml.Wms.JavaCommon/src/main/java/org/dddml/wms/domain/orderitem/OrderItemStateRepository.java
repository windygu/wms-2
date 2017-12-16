package org.dddml.wms.domain.orderitem;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemStateRepository
{
    OrderItemState get(OrderItemId id, boolean nullAllowed);

    void save(OrderItemState state);

}

