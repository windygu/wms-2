package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptStateDao
{
    ShipmentReceiptState get(ShipmentReceiptId id, boolean nullAllowed);

    void save(ShipmentReceiptState state);

    Iterable<ShipmentReceiptState> findByShipmentId(String shipmentId);

    void delete(ShipmentReceiptState state);
}


