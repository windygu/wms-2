package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ItemIssuanceEventDao
{
    void save(ItemIssuanceEvent e);

    Iterable<ItemIssuanceEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

