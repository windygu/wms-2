package org.dddml.wms.domain.shipmentitem;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentItemAggregate
{
    ShipmentItemState getState();

    List<Event> getChanges();

    void create(ShipmentItemCommand.CreateShipmentItem c);

    void mergePatch(ShipmentItemCommand.MergePatchShipmentItem c);

    void throwOnInvalidStateTransition(Command c);
}

