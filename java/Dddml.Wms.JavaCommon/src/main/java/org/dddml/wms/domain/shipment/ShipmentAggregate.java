package org.dddml.wms.domain.shipment;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentAggregate
{
    ShipmentState getState();

    List<Event> getChanges();

    void create(ShipmentCommand.CreateShipment c);

    void mergePatch(ShipmentCommand.MergePatchShipment c);

    void _import(Iterable<ImportingShipmentItem> shipmentItems, Long version, String commandId, String requesterId);

    void throwOnInvalidStateTransition(Command c);
}

