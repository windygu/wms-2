package org.dddml.wms.domain.shipmenttype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentTypeAggregate
{
    ShipmentTypeState getState();

    List<Event> getChanges();

    void create(ShipmentTypeCommand.CreateShipmentType c);

    void mergePatch(ShipmentTypeCommand.MergePatchShipmentType c);

    void throwOnInvalidStateTransition(Command c);
}

