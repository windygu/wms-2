package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageStateRepository
{
    ShipmentPackageState get(ShipmentPackageId id, boolean nullAllowed);

    void save(ShipmentPackageState state);

}

