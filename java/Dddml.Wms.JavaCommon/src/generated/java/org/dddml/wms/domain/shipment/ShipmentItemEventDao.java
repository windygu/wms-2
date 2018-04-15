package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemEventDao
{
    void save(ShipmentItemEvent e);

    Iterable<ShipmentItemEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

