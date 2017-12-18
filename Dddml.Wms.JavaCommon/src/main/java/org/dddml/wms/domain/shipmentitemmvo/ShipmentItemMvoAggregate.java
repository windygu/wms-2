package org.dddml.wms.domain.shipmentitemmvo;

import java.util.List;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentItemMvoAggregate
{
    ShipmentItemMvoState getState();

    List<Event> getChanges();

    void create(ShipmentItemMvoCommand.CreateShipmentItemMvo c);

    void mergePatch(ShipmentItemMvoCommand.MergePatchShipmentItemMvo c);

    void delete(ShipmentItemMvoCommand.DeleteShipmentItemMvo c);

    void throwOnInvalidStateTransition(Command c);
}

