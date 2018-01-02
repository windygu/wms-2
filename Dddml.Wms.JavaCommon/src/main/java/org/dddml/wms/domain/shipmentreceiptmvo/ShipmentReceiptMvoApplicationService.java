package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentReceiptMvoApplicationService
{
    void when(ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo c);

    void when(ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo c);

    ShipmentReceiptMvoState get(ShipmentReceiptId id);

    Iterable<ShipmentReceiptMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentReceiptMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentReceiptMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentReceiptMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentReceiptMvoStateEvent getStateEvent(ShipmentReceiptId shipmentReceiptId, long version);

    ShipmentReceiptMvoState getHistoryState(ShipmentReceiptId shipmentReceiptId, long version);

}

