package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentTypeStateRepository
{
    ShipmentTypeState get(String id, boolean nullAllowed);

    void save(ShipmentTypeState state);

}

