package org.dddml.wms.domain.shipment;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentApplicationService
{
    void when(ShipmentCommand.CreateShipment c);

    void when(ShipmentCommand.MergePatchShipment c);

    ShipmentState get(String id);

    Iterable<ShipmentState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentStateEvent getStateEvent(String shipmentId, long version);

    ShipmentState getHistoryState(String shipmentId, long version);

    ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId);

    ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId);

}

