package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemMvoStateRepository
{
    ShipmentItemMvoState get(ShipmentItemId id, boolean nullAllowed);

    void save(ShipmentItemMvoState state);

}

