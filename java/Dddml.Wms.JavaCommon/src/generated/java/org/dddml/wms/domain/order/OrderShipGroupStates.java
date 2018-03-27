package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface OrderShipGroupStates extends Iterable<OrderShipGroupState>, Saveable
{
    OrderShipGroupState get(Long shipGroupSeqId);

    OrderShipGroupState get(Long shipGroupSeqId, boolean forCreation);

    OrderShipGroupState get(Long shipGroupSeqId, boolean forCreation, boolean nullAllowed);

    void remove(OrderShipGroupState state);

    void addToSave(OrderShipGroupState state);

}


