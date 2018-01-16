package org.dddml.wms.domain.shipment;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentStateRepository
{
    ShipmentState get(String id, boolean nullAllowed);

    void save(ShipmentState state);

}

