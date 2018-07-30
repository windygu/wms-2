package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentImageEventDao
{
    void save(ShipmentImageEvent e);

    Iterable<ShipmentImageEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

