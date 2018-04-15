package org.dddml.wms.domain.shipmentpackage;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentPackageApplicationService
{
    void when(ShipmentPackageCommand.CreateShipmentPackage c);

    void when(ShipmentPackageCommand.MergePatchShipmentPackage c);

    void when(ShipmentPackageCommand.DeleteShipmentPackage c);

    ShipmentPackageState get(ShipmentPackageId id);

    Iterable<ShipmentPackageState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentPackageEvent getEvent(ShipmentPackageId shipmentPackageId, long version);

    ShipmentPackageState getHistoryState(ShipmentPackageId shipmentPackageId, long version);

    ShipmentPackageContentState getShipmentPackageContent(ShipmentPackageId shipmentPackageId, String shipmentItemSeqId);

    Iterable<ShipmentPackageContentState> getShipmentPackageContents(ShipmentPackageId shipmentPackageId);

}

