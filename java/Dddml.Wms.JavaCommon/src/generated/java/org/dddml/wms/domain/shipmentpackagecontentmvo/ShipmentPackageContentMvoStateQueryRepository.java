package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageContentMvoStateQueryRepository
{
    ShipmentPackageContentMvoState get(ShipmentPackageContentId id);

    Iterable<ShipmentPackageContentMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentPackageContentMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageContentMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentPackageContentMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentPackageContentMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentPackageContentMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

