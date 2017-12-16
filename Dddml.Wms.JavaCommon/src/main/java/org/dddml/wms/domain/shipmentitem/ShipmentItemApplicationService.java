package org.dddml.wms.domain.shipmentitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentItemApplicationService
{
    void when(ShipmentItemCommand.CreateShipmentItem c);

    void when(ShipmentItemCommand.MergePatchShipmentItem c);

    ShipmentItemState get(ShipmentItemId id);

    Iterable<ShipmentItemState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentItemStateEvent getStateEvent(ShipmentItemId shipmentItemId, long version);

    ShipmentItemState getHistoryState(ShipmentItemId shipmentItemId, long version);

}

