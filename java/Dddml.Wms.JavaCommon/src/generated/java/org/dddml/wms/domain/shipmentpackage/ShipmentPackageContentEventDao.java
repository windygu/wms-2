package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageContentEventDao
{
    void save(ShipmentPackageContentEvent e);

    Iterable<ShipmentPackageContentEvent> findByShipmentPackageEventId(ShipmentPackageEventId shipmentPackageEventId);

}

