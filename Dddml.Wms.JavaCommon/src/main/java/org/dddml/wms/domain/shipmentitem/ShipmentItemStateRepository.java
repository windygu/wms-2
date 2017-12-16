package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemStateRepository
{
    ShipmentItemState get(ShipmentItemId id, boolean nullAllowed);

    void save(ShipmentItemState state);

}

