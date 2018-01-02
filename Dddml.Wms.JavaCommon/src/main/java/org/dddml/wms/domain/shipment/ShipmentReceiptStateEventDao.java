package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptStateEventDao
{
    void save(ShipmentReceiptStateEvent e);

    Iterable<ShipmentReceiptStateEvent> findByShipmentStateEventId(ShipmentStateEventId shipmentStateEventId);

}

