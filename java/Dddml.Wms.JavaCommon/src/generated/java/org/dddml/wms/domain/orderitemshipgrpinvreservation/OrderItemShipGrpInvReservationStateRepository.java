package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGrpInvReservationStateRepository
{
    OrderItemShipGrpInvReservationState get(OrderItemShipGrpInvResId id, boolean nullAllowed);

    void save(OrderItemShipGrpInvReservationState state);

}

