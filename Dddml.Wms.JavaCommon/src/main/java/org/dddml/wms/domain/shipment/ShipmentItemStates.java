package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ShipmentItemStates extends Iterable<ShipmentItemState>, Saveable
{
    ShipmentItemState get(String shipmentItemSeqId);

    ShipmentItemState get(String shipmentItemSeqId, boolean forCreation);

    ShipmentItemState get(String shipmentItemSeqId, boolean forCreation, boolean nullAllowed);

    void remove(ShipmentItemState state);

    void addToSave(ShipmentItemState state);

}


