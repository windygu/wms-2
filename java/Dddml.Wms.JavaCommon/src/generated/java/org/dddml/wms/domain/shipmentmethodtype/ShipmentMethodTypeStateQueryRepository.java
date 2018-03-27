package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentMethodTypeStateQueryRepository
{
    ShipmentMethodTypeState get(String id);

    Iterable<ShipmentMethodTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentMethodTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentMethodTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentMethodTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentMethodTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentMethodTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

