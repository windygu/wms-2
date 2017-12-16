package org.dddml.wms.domain.shipmentitem;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentItemStateQueryRepository
{
    ShipmentItemState get(ShipmentItemId id);

    Iterable<ShipmentItemState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentItemState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentItemState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

