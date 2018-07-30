package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ShipmentImageStates extends Iterable<ShipmentImageState>, Saveable
{
    ShipmentImageState get(String sequenceId);

    ShipmentImageState get(String sequenceId, boolean forCreation);

    ShipmentImageState get(String sequenceId, boolean forCreation, boolean nullAllowed);

    void remove(ShipmentImageState state);

    void addToSave(ShipmentImageState state);

}


