package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptImageEventDao
{
    void save(ShipmentReceiptImageEvent e);

    Iterable<ShipmentReceiptImageEvent> findByShipmentReceiptEventId(ShipmentReceiptEventId shipmentReceiptEventId);

}

