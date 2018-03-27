package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ItemIssuanceStateEventDao
{
    void save(ItemIssuanceStateEvent e);

    Iterable<ItemIssuanceStateEvent> findByShipmentEventId(ShipmentEventId shipmentEventId);

}

