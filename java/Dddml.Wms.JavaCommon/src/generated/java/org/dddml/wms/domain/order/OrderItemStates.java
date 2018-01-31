package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface OrderItemStates extends Iterable<OrderItemState>, Saveable
{
    OrderItemState get(String orderItemSeqId);

    OrderItemState get(String orderItemSeqId, boolean forCreation);

    OrderItemState get(String orderItemSeqId, boolean forCreation, boolean nullAllowed);

    void remove(OrderItemState state);

    void addToSave(OrderItemState state);

}


