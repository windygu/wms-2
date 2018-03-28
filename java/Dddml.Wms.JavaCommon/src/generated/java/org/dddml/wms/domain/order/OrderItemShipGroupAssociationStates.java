package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface OrderItemShipGroupAssociationStates extends Iterable<OrderItemShipGroupAssociationState>, Saveable
{
    OrderItemShipGroupAssociationState get(String orderItemSeqId);

    OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean forCreation);

    OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean forCreation, boolean nullAllowed);

    void remove(OrderItemShipGroupAssociationState state);

    void addToSave(OrderItemShipGroupAssociationState state);

}


