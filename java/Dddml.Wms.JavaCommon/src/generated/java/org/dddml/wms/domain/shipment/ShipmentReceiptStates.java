package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ShipmentReceiptStates extends Iterable<ShipmentReceiptState>, Saveable
{
    ShipmentReceiptState get(String receiptSeqId);

    //ShipmentReceiptState get(String receiptSeqId, boolean forCreation);

    //ShipmentReceiptState get(String receiptSeqId, boolean forCreation, boolean nullAllowed);

    void remove(ShipmentReceiptState state);

    void add(ShipmentReceiptState state);

}


