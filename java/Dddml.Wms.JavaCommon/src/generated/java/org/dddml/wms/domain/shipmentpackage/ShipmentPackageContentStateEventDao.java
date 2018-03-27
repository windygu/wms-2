package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageContentStateEventDao
{
    void save(ShipmentPackageContentStateEvent e);

    Iterable<ShipmentPackageContentStateEvent> findByShipmentPackageEventId(ShipmentPackageEventId shipmentPackageEventId);

}

