package org.dddml.wms.domain.shipmentpackage;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentPackageAggregate
{
    ShipmentPackageState getState();

    List<Event> getChanges();

    void create(ShipmentPackageCommand.CreateShipmentPackage c);

    void mergePatch(ShipmentPackageCommand.MergePatchShipmentPackage c);

    void delete(ShipmentPackageCommand.DeleteShipmentPackage c);

    void throwOnInvalidStateTransition(Command c);
}

