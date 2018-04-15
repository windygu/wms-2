package org.dddml.wms.domain.itemissuancemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ItemIssuanceMvoApplicationService
{
    void when(ItemIssuanceMvoCommand.CreateItemIssuanceMvo c);

    void when(ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo c);

    void when(ItemIssuanceMvoCommand.DeleteItemIssuanceMvo c);

    ItemIssuanceMvoState get(ShipmentItemIssuanceId id);

    Iterable<ItemIssuanceMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ItemIssuanceMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ItemIssuanceMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ItemIssuanceMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ItemIssuanceMvoEvent getEvent(ShipmentItemIssuanceId shipmentItemIssuanceId, long version);

    ItemIssuanceMvoState getHistoryState(ShipmentItemIssuanceId shipmentItemIssuanceId, long version);

}

