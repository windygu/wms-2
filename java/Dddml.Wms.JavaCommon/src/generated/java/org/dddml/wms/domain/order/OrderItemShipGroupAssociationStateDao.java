package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGroupAssociationStateDao
{
    OrderItemShipGroupAssociationState get(OrderItemShipGroupAssociationId id, boolean nullAllowed);

    void save(OrderItemShipGroupAssociationState state);

    Iterable<OrderItemShipGroupAssociationState> findByOrderIdAndOrderShipGroupShipGroupSeqId(String orderId, Long orderShipGroupShipGroupSeqId);

    void delete(OrderItemShipGroupAssociationState state);
}


