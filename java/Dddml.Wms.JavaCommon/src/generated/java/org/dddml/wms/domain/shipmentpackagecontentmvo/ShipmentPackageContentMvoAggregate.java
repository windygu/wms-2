package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.List;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentPackageContentMvoAggregate
{
    ShipmentPackageContentMvoState getState();

    List<Event> getChanges();

    void create(ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo c);

    void mergePatch(ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo c);

    void delete(ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo c);

    void throwOnInvalidStateTransition(Command c);
}

