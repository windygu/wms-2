package org.dddml.wms.domain.itemissuancemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ItemIssuanceMvoStateQueryRepository
{
    ItemIssuanceMvoState get(ShipmentItemIssuanceId id);

    Iterable<ItemIssuanceMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ItemIssuanceMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ItemIssuanceMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ItemIssuanceMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ItemIssuanceMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ItemIssuanceMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

