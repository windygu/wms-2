package org.dddml.wms.domain.shipmentmethodtype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentMethodTypeAggregate
{
    ShipmentMethodTypeState getState();

    List<Event> getChanges();

    void create(ShipmentMethodTypeCommand.CreateShipmentMethodType c);

    void mergePatch(ShipmentMethodTypeCommand.MergePatchShipmentMethodType c);

    void delete(ShipmentMethodTypeCommand.DeleteShipmentMethodType c);

    void throwOnInvalidStateTransition(Command c);
}

