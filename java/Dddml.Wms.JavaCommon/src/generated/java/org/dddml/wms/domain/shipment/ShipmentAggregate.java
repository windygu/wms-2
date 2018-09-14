package org.dddml.wms.domain.shipment;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ShipmentAggregate
{
    ShipmentState getState();

    List<Event> getChanges();

    void create(ShipmentCommand.CreateShipment c);

    void mergePatch(ShipmentCommand.MergePatchShipment c);

    void _import(String shipmentTypeId, String primaryOrderId, String primaryReturnId, Boolean onlyOneOrder, String bolNumber, String vehicleId, String sealNumber, String externalOrderNumber, String carrier, java.sql.Timestamp dateShipped, java.sql.Timestamp estimatedReadyDate, java.sql.Timestamp estimatedShipDate, java.sql.Timestamp estimatedArrivalDate, java.sql.Timestamp latestCancelDate, java.math.BigDecimal estimatedShipCost, String currencyUomId, String handlingInstructions, String originFacilityId, String destinationFacilityId, String partyIdTo, String partyIdFrom, java.math.BigDecimal additionalShippingCharge, String addtlShippingChargeDesc, Iterable<ImportingShipmentItem> shipmentItems, Long version, String commandId, String requesterId);

    void receiveItem(String receiptSeqId, String shipmentItemSeqId, String orderId, String orderItemSeqId, String locatorId, java.util.Map<String, Object> attributeSetInstance, String rejectionReasonId, Iterable<String> damageStatusIds, String damageReasonId, java.math.BigDecimal acceptedQuantity, java.math.BigDecimal rejectedQuantity, java.math.BigDecimal damagedQuantity, String itemDescription, Long version, String commandId, String requesterId);

    void issueItem(String itemIssuanceSeqId, String shipmentItemSeqId, String orderId, String orderItemSeqId, String shipGroupSeqId, String productId, String locatorId, java.util.Map<String, Object> attributeSetInstance, java.math.BigDecimal quantity, java.math.BigDecimal cancelQuantity, String itemDescription, Long version, String commandId, String requesterId);

    void confirmAllItemsReceived(String destinationLocatorId, Long version, String commandId, String requesterId);

    void confirmAllItemsIssued(Long version, String commandId, String requesterId);

    void purchaseShipmentAction(String value, Long version, String commandId, String requesterId);

    void salesShipmentAction(String value, Long version, String commandId, String requesterId);

    void throwOnInvalidStateTransition(Command c);
}

