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

    void when(ShipmentCommands.Import c);

    void when(ShipmentCommands.Ship c);

    void when(ShipmentCommands.ReceiveItem c);

    void when(ShipmentCommands.AddItemAndReceipt c);

    void when(ShipmentCommands.AddItemAndIssuance c);

    void when(ShipmentCommands.ConfirmAllItemsReceived c);

    void when(ShipmentCommands.ConfirmAllItemsIssued c);

    ShipmentState get(String id);

    Iterable<ShipmentState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ShipmentEvent getEvent(String shipmentId, long version);

    ShipmentState getHistoryState(String shipmentId, long version);

    ShipmentImageState getShipmentImage(String shipmentId, String sequenceId);

    Iterable<ShipmentImageState> getShipmentImages(String shipmentId);

    ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId);

    Iterable<ShipmentItemState> getShipmentItems(String shipmentId);

    ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId);

    Iterable<ShipmentReceiptState> getShipmentReceipts(String shipmentId);

    ShipmentReceiptImageState getShipmentReceiptImage(String shipmentId, String shipmentReceiptReceiptSeqId, String sequenceId);

    Iterable<ShipmentReceiptImageState> getShipmentReceiptImages(String shipmentId, String shipmentReceiptReceiptSeqId);

    ItemIssuanceState getItemIssuance(String shipmentId, String itemIssuanceSeqId);

    Iterable<ItemIssuanceState> getItemIssuances(String shipmentId);

}

