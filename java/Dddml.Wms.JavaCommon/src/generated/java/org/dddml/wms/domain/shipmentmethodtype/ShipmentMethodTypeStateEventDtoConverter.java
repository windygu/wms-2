package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentMethodTypeStateEventDtoConverter {

    public ShipmentMethodTypeStateEventDto toShipmentMethodTypeStateEventDto(AbstractShipmentMethodTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentMethodTypeStateEvent.AbstractShipmentMethodTypeStateCreated) {
            ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated e = (ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated) stateEvent;
            return toShipmentMethodTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentMethodTypeStateEvent.AbstractShipmentMethodTypeStateMergePatched) {
            ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched e = (ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched) stateEvent;
            return toShipmentMethodTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractShipmentMethodTypeStateEvent.AbstractShipmentMethodTypeStateDeleted) {
            ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted e = (ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted) stateEvent;
            return toShipmentMethodTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateCreatedDto toShipmentMethodTypeStateCreatedDto(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated e) {
        ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateCreatedDto dto = new ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateCreatedDto();
        dto.setShipmentMethodTypeEventId(e.getShipmentMethodTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceNum(e.getSequenceNum());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateMergePatchedDto toShipmentMethodTypeStateMergePatchedDto(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched e) {
        ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateMergePatchedDto dto = new ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateMergePatchedDto();
        dto.setShipmentMethodTypeEventId(e.getShipmentMethodTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceNum(e.getSequenceNum());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertySequenceNumRemoved(e.getIsPropertySequenceNumRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto toShipmentMethodTypeStateDeletedDto(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted e) {
        ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto dto = new ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto();
        dto.setShipmentMethodTypeEventId(e.getShipmentMethodTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

