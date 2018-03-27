package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ItemIssuanceStateDao
{
    ItemIssuanceState get(ShipmentItemIssuanceId id, boolean nullAllowed);

    void save(ItemIssuanceState state);

    Iterable<ItemIssuanceState> findByShipmentId(String shipmentId);

    void delete(ItemIssuanceState state);
}


