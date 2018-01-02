package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentReceiptMvoStateRepository
{
    ShipmentReceiptMvoState get(ShipmentReceiptId id, boolean nullAllowed);

    void save(ShipmentReceiptMvoState state);

}

