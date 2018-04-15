package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentMethodTypeStateEventDtoConverter {

    public ShipmentMethodTypeStateEventDto toShipmentMethodTypeStateEventDto(AbstractShipmentMethodTypeEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentMethodTypeEvent.AbstractShipmentMethodTypeStateCreated) {
            ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated e = (ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated) stateEvent;
            return toShipmentMethodTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentMethodTypeEvent.AbstractShipmentMethodTypeStateMergePatched) {
            ShipmentMethodTypeEvent.ShipmentMethodTypeStateMergePatched e = (ShipmentMethodTypeEvent.ShipmentMethodTypeStateMergePatched) stateEvent;
            return toShipmentMethodTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractShipmentMethodTypeEvent.AbstractShipmentMethodTypeStateDeleted) {
            ShipmentMethodTypeEvent.ShipmentMethodTypeStateDeleted e = (ShipmentMethodTypeEvent.ShipmentMethodTypeStateDeleted) stateEvent;
            return toShipmentMethodTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateCreatedDto toShipmentMethodTypeStateCreatedDto(ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated e) {
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

    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateMergePatchedDto toShipmentMethodTypeStateMergePatchedDto(ShipmentMethodTypeEvent.ShipmentMethodTypeStateMergePatched e) {
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


    public ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto toShipmentMethodTypeStateDeletedDto(ShipmentMethodTypeEvent.ShipmentMethodTypeStateDeleted e) {
        ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto dto = new ShipmentMethodTypeStateEventDto.ShipmentMethodTypeStateDeletedDto();
        dto.setShipmentMethodTypeEventId(e.getShipmentMethodTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

