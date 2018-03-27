package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageContentStateDao
{
    ShipmentPackageContentState get(ShipmentPackageContentId id, boolean nullAllowed);

    void save(ShipmentPackageContentState state);

    Iterable<ShipmentPackageContentState> findByShipmentPackageId(ShipmentPackageId shipmentPackageId);

    void delete(ShipmentPackageContentState state);
}


