package org.dddml.wms.domain.shipmentpackage;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentPackageStateQueryRepository
{
    ShipmentPackageState get(ShipmentPackageId id);

    Iterable<ShipmentPackageState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentPackageState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentPackageState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentPackageState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentPackageState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentPackageState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentPackageContentState getShipmentPackageContent(ShipmentPackageId shipmentPackageId, String shipmentItemSeqId);

}

