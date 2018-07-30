package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentImageStateDao
{
    ShipmentImageState get(ShipmentImageId id, boolean nullAllowed);

    void save(ShipmentImageState state);

    Iterable<ShipmentImageState> findByShipmentId(String shipmentId);

    void delete(ShipmentImageState state);
}


