package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ShipmentReceiptImageStates extends Iterable<ShipmentReceiptImageState>, Saveable
{
    ShipmentReceiptImageState get(String sequenceId);

    //ShipmentReceiptImageState get(String sequenceId, boolean forCreation);

    //ShipmentReceiptImageState get(String sequenceId, boolean forCreation, boolean nullAllowed);

    void remove(ShipmentReceiptImageState state);

    void add(ShipmentReceiptImageState state);

}


