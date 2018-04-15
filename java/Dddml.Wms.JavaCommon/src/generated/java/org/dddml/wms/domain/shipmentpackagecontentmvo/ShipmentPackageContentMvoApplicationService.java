package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentPackageContentMvoApplicationService
{
    void when(ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo c);

    void when(ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo c);

    void when(ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo c);

    ShipmentPackageContentMvoState get(ShipmentPackageContentId id);

    Iterable<ShipmentPackageContentMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageContentMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageContentMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageContentMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentPackageContentMvoEvent getEvent(ShipmentPackageContentId shipmentPackageContentId, long version);

    ShipmentPackageContentMvoState getHistoryState(ShipmentPackageContentId shipmentPackageContentId, long version);

}

