package org.dddml.wms.domain.shipmenttype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentTypeStateQueryRepository
{
    ShipmentTypeState get(String id);

    Iterable<ShipmentTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

