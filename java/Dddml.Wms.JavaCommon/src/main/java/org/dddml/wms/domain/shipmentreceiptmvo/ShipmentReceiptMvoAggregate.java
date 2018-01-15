package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.List;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentReceiptMvoAggregate
{
    ShipmentReceiptMvoState getState();

    List<Event> getChanges();

    void create(ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo c);

    void mergePatch(ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo c);

    void throwOnInvalidStateTransition(Command c);
}

