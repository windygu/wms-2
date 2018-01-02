package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentItemStateEventDtoConverter {

    public ShipmentItemStateEventDto toShipmentItemStateEventDto(AbstractShipmentItemStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentItemStateEvent.AbstractShipmentItemStateCreated) {
            ShipmentItemStateEvent.ShipmentItemStateCreated e = (ShipmentItemStateEvent.ShipmentItemStateCreated) stateEvent;
            return toShipmentItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentItemStateEvent.AbstractShipmentItemStateMergePatched) {
            ShipmentItemStateEvent.ShipmentItemStateMergePatched e = (ShipmentItemStateEvent.ShipmentItemStateMergePatched) stateEvent;
            return toShipmentItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentItemStateEventDto.ShipmentItemStateCreatedDto toShipmentItemStateCreatedDto(ShipmentItemStateEvent.ShipmentItemStateCreated e) {
        ShipmentItemStateEventDto.ShipmentItemStateCreatedDto dto = new ShipmentItemStateEventDto.ShipmentItemStateCreatedDto();
        dto.setStateEventId(new ShipmentItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setQuantity(e.getQuantity());
        dto.setShipmentContentDescription(e.getShipmentContentDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentItemStateEventDto.ShipmentItemStateMergePatchedDto toShipmentItemStateMergePatchedDto(ShipmentItemStateEvent.ShipmentItemStateMergePatched e) {
        ShipmentItemStateEventDto.ShipmentItemStateMergePatchedDto dto = new ShipmentItemStateEventDto.ShipmentItemStateMergePatchedDto();
        dto.setStateEventId(new ShipmentItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setQuantity(e.getQuantity());
        dto.setShipmentContentDescription(e.getShipmentContentDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyShipmentContentDescriptionRemoved(e.getIsPropertyShipmentContentDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

