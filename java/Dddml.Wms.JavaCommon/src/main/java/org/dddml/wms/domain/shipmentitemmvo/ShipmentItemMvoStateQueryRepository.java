package org.dddml.wms.domain.shipmentitemmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemMvoStateQueryRepository
{
    ShipmentItemMvoState get(ShipmentItemId id);

    Iterable<ShipmentItemMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentItemMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentItemMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

