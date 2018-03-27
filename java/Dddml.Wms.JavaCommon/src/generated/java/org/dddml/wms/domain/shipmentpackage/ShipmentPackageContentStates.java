package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ShipmentPackageContentStates extends Iterable<ShipmentPackageContentState>, Saveable
{
    ShipmentPackageContentState get(String shipmentItemSeqId);

    ShipmentPackageContentState get(String shipmentItemSeqId, boolean forCreation);

    ShipmentPackageContentState get(String shipmentItemSeqId, boolean forCreation, boolean nullAllowed);

    void remove(ShipmentPackageContentState state);

    void addToSave(ShipmentPackageContentState state);

}


