package org.dddml.wms.domain.shipment;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ShipmentStateQueryRepository
{
    ShipmentState get(String id);

    Iterable<ShipmentState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipmentState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipmentState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId);

    ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId);

}

