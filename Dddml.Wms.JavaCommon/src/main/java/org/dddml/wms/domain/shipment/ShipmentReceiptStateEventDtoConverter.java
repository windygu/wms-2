package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentReceiptStateEventDtoConverter {

    public ShipmentReceiptStateEventDto toShipmentReceiptStateEventDto(AbstractShipmentReceiptStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentReceiptStateEvent.AbstractShipmentReceiptStateCreated) {
            ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e = (ShipmentReceiptStateEvent.ShipmentReceiptStateCreated) stateEvent;
            return toShipmentReceiptStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentReceiptStateEvent.AbstractShipmentReceiptStateMergePatched) {
            ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched e = (ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched) stateEvent;
            return toShipmentReceiptStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto toShipmentReceiptStateCreatedDto(ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e) {
        ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto dto = new ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto();
        dto.setStateEventId(new ShipmentReceiptStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setRejectionReasonId(e.getRejectionReasonId());
        dto.setDamageStatusId(e.getDamageStatusId());
        dto.setDamageReasonId(e.getDamageReasonId());
        dto.setItemDescription(e.getItemDescription());
        dto.setAcceptedQuantity(e.getAcceptedQuantity());
        dto.setRejectedQuantity(e.getRejectedQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto toShipmentReceiptStateMergePatchedDto(ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched e) {
        ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto dto = new ShipmentReceiptStateEventDto.ShipmentReceiptStateMergePatchedDto();
        dto.setStateEventId(new ShipmentReceiptStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setRejectionReasonId(e.getRejectionReasonId());
        dto.setDamageStatusId(e.getDamageStatusId());
        dto.setDamageReasonId(e.getDamageReasonId());
        dto.setItemDescription(e.getItemDescription());
        dto.setAcceptedQuantity(e.getAcceptedQuantity());
        dto.setRejectedQuantity(e.getRejectedQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyShipmentItemSeqIdRemoved(e.getIsPropertyShipmentItemSeqIdRemoved());
        dto.setIsPropertyRejectionReasonIdRemoved(e.getIsPropertyRejectionReasonIdRemoved());
        dto.setIsPropertyDamageStatusIdRemoved(e.getIsPropertyDamageStatusIdRemoved());
        dto.setIsPropertyDamageReasonIdRemoved(e.getIsPropertyDamageReasonIdRemoved());
        dto.setIsPropertyItemDescriptionRemoved(e.getIsPropertyItemDescriptionRemoved());
        dto.setIsPropertyAcceptedQuantityRemoved(e.getIsPropertyAcceptedQuantityRemoved());
        dto.setIsPropertyRejectedQuantityRemoved(e.getIsPropertyRejectedQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

