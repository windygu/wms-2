package org.dddml.wms.domain.shipmenttype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentTypeApplicationService
{
    void when(ShipmentTypeCommand.CreateShipmentType c);

    void when(ShipmentTypeCommand.MergePatchShipmentType c);

    ShipmentTypeState get(String id);

    Iterable<ShipmentTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

