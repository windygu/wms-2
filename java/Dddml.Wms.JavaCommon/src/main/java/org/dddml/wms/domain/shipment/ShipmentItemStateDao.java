package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemStateDao
{
    ShipmentItemState get(ShipmentItemId id, boolean nullAllowed);

    void save(ShipmentItemState state);

    Iterable<ShipmentItemState> findByShipmentId(String shipmentId);

    void delete(ShipmentItemState state);
}


