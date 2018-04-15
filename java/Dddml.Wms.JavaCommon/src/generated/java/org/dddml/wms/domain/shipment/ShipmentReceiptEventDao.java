package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptEventDao
{
    void save(ShipmentReceiptEvent e);

    Iterable<ShipmentReceiptEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

