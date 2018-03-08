package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemStateEventDao
{
    void save(ShipmentItemStateEvent e);

    Iterable<ShipmentItemStateEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

