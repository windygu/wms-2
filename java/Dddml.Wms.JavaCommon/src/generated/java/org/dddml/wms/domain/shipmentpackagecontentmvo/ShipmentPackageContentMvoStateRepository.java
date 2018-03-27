package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageContentMvoStateRepository
{
    ShipmentPackageContentMvoState get(ShipmentPackageContentId id, boolean nullAllowed);

    void save(ShipmentPackageContentMvoState state);

}

