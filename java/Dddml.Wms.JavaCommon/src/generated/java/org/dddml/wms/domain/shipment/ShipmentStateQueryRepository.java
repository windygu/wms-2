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

    ShipmentImageState getShipmentImage(String shipmentId, String sequenceId);

    Iterable<ShipmentImageState> getShipmentImages(String shipmentId, Criterion filter, List<String> orders);

    ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId);

    Iterable<ShipmentItemState> getShipmentItems(String shipmentId, Criterion filter, List<String> orders);

    ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId);

    Iterable<ShipmentReceiptState> getShipmentReceipts(String shipmentId, Criterion filter, List<String> orders);

    ShipmentReceiptImageState getShipmentReceiptImage(String shipmentId, String shipmentReceiptReceiptSeqId, String sequenceId);

    Iterable<ShipmentReceiptImageState> getShipmentReceiptImages(String shipmentId, String shipmentReceiptReceiptSeqId, Criterion filter, List<String> orders);

    ItemIssuanceState getItemIssuance(String shipmentId, String itemIssuanceSeqId);

    Iterable<ItemIssuanceState> getItemIssuances(String shipmentId, Criterion filter, List<String> orders);

}

