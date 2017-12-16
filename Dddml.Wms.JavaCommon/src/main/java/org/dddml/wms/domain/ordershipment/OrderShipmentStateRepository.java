package org.dddml.wms.domain.ordershipment;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipmentStateRepository
{
    OrderShipmentState get(OrderShipmentId id, boolean nullAllowed);

    void save(OrderShipmentState state);

}

