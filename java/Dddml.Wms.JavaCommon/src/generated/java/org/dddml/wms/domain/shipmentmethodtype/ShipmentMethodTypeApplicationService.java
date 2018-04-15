package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentMethodTypeApplicationService
{
    void when(ShipmentMethodTypeCommand.CreateShipmentMethodType c);

    void when(ShipmentMethodTypeCommand.MergePatchShipmentMethodType c);

    void when(ShipmentMethodTypeCommand.DeleteShipmentMethodType c);

    ShipmentMethodTypeState get(String id);

    Iterable<ShipmentMethodTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentMethodTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentMethodTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentMethodTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentMethodTypeEvent getEvent(String shipmentMethodTypeId, long version);

    ShipmentMethodTypeState getHistoryState(String shipmentMethodTypeId, long version);

}

