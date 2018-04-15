package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentReceiptStateEventDtoConverter {

    public ShipmentReceiptStateEventDto toShipmentReceiptStateEventDto(AbstractShipmentReceiptEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentReceiptEvent.AbstractShipmentReceiptStateCreated) {
            ShipmentReceiptEvent.ShipmentReceiptStateCreated e = (ShipmentReceiptEvent.ShipmentReceiptStateCreated) stateEvent;
            return toShipmentReceiptStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentReceiptEvent.AbstractShipmentReceiptStateMergePatched) {
            ShipmentReceiptEvent.ShipmentReceiptStateMergePatched e = (ShipmentReceiptEvent.ShipmentReceiptStateMergePatched) stateEvent;
            return toShipmentReceiptStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto toShipmentReceiptStateCreatedDto(ShipmentReceiptEvent.ShipmentReceiptStateCreated e) {
        ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto dto = new ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto();
        dto.setShipmentReceiptEventId(e.getShipmentReceiptEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setLocatorId(e.getLocatorId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setShipmentPackageSeqId(e.getShipmentPackageSeqId());
        dto.setOrderId(e.getOrderId());
        dto.setOrderItemSeqId(e.getOrderItemSeqId());
        dto.setReturnId(e.getReturnId());
        dto.setReturnItemSeqId(e.getReturnItemSeqId());
        dto.setRejectionReasonId(e.getRejectionReasonId());
        dto.setDamageStatusId(e.getDamageStatusId());
        dto.setDamageReasonId(e.getDamageReasonId());
        dto.setReceivedBy(e.getReceivedBy());
        dto.setDatetimeReceived(e.getDatetimeReceived());
        dto.setItemDescription(e.getItemDescription());
        dto.setAcceptedQuantity(e.getAcceptedQuantity());
        dto.setRejectedQuantity(e.getRejectedQuantity());
        dto.setDamagedQuantity(e.getDamagedQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto toShipmentReceiptStateMergePatchedDto(ShipmentReceiptEvent.ShipmentReceiptStateMergePatched e) {
        ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto dto = new ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto();
        dto.setShipmentReceiptEventId(e.getShipmentReceiptEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setLocatorId(e.getLocatorId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setShipmentPackageSeqId(e.getShipmentPackageSeqId());
        dto.setOrderId(e.getOrderId());
        dto.setOrderItemSeqId(e.getOrderItemSeqId());
        dto.setReturnId(e.getReturnId());
        dto.setReturnItemSeqId(e.getReturnItemSeqId());
        dto.setRejectionReasonId(e.getRejectionReasonId());
        dto.setDamageStatusId(e.getDamageStatusId());
        dto.setDamageReasonId(e.getDamageReasonId());
        dto.setReceivedBy(e.getReceivedBy());
        dto.setDatetimeReceived(e.getDatetimeReceived());
        dto.setItemDescription(e.getItemDescription());
        dto.setAcceptedQuantity(e.getAcceptedQuantity());
        dto.setRejectedQuantity(e.getRejectedQuantity());
        dto.setDamagedQuantity(e.getDamagedQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyShipmentItemSeqIdRemoved(e.getIsPropertyShipmentItemSeqIdRemoved());
        dto.setIsPropertyShipmentPackageSeqIdRemoved(e.getIsPropertyShipmentPackageSeqIdRemoved());
        dto.setIsPropertyOrderIdRemoved(e.getIsPropertyOrderIdRemoved());
        dto.setIsPropertyOrderItemSeqIdRemoved(e.getIsPropertyOrderItemSeqIdRemoved());
        dto.setIsPropertyReturnIdRemoved(e.getIsPropertyReturnIdRemoved());
        dto.setIsPropertyReturnItemSeqIdRemoved(e.getIsPropertyReturnItemSeqIdRemoved());
        dto.setIsPropertyRejectionReasonIdRemoved(e.getIsPropertyRejectionReasonIdRemoved());
        dto.setIsPropertyDamageStatusIdRemoved(e.getIsPropertyDamageStatusIdRemoved());
        dto.setIsPropertyDamageReasonIdRemoved(e.getIsPropertyDamageReasonIdRemoved());
        dto.setIsPropertyReceivedByRemoved(e.getIsPropertyReceivedByRemoved());
        dto.setIsPropertyDatetimeReceivedRemoved(e.getIsPropertyDatetimeReceivedRemoved());
        dto.setIsPropertyItemDescriptionRemoved(e.getIsPropertyItemDescriptionRemoved());
        dto.setIsPropertyAcceptedQuantityRemoved(e.getIsPropertyAcceptedQuantityRemoved());
        dto.setIsPropertyRejectedQuantityRemoved(e.getIsPropertyRejectedQuantityRemoved());
        dto.setIsPropertyDamagedQuantityRemoved(e.getIsPropertyDamagedQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

