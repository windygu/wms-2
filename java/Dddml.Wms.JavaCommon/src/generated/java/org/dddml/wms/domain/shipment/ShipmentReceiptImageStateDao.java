package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptImageStateDao
{
    ShipmentReceiptImageState get(ShipmentReceiptImageId id, boolean nullAllowed);

    void save(ShipmentReceiptImageState state);

    Iterable<ShipmentReceiptImageState> findByShipmentIdAndShipmentReceiptReceiptSeqId(String shipmentId, String shipmentReceiptReceiptSeqId);

    void delete(ShipmentReceiptImageState state);
}


