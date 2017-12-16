package org.dddml.wms.domain.ordershipment;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface OrderShipmentAggregate
{
    OrderShipmentState getState();

    List<Event> getChanges();

    void create(OrderShipmentCommand.CreateOrderShipment c);

    void mergePatch(OrderShipmentCommand.MergePatchOrderShipment c);

    void throwOnInvalidStateTransition(Command c);
}

