package org.dddml.wms.domain.shipmentitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentItemMvoApplicationService
{
    void when(ShipmentItemMvoCommand.CreateShipmentItemMvo c);

    void when(ShipmentItemMvoCommand.MergePatchShipmentItemMvo c);

    void when(ShipmentItemMvoCommand.DeleteShipmentItemMvo c);

    ShipmentItemMvoState get(ShipmentItemId id);

    Iterable<ShipmentItemMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentItemMvoStateEvent getStateEvent(ShipmentItemId shipmentItemId, long version);

    ShipmentItemMvoState getHistoryState(ShipmentItemId shipmentItemId, long version);

}

