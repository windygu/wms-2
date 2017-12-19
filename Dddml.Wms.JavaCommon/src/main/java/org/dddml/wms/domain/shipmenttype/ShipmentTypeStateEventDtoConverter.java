package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentTypeStateEventDtoConverter {

    public ShipmentTypeStateEventDto toShipmentTypeStateEventDto(AbstractShipmentTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentTypeStateEvent.AbstractShipmentTypeStateCreated) {
            ShipmentTypeStateEvent.ShipmentTypeStateCreated e = (ShipmentTypeStateEvent.ShipmentTypeStateCreated) stateEvent;
            return toShipmentTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentTypeStateEvent.AbstractShipmentTypeStateMergePatched) {
            ShipmentTypeStateEvent.ShipmentTypeStateMergePatched e = (ShipmentTypeStateEvent.ShipmentTypeStateMergePatched) stateEvent;
            return toShipmentTypeStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentTypeStateEventDto.ShipmentTypeStateCreatedDto toShipmentTypeStateCreatedDto(ShipmentTypeStateEvent.ShipmentTypeStateCreated e) {
        ShipmentTypeStateEventDto.ShipmentTypeStateCreatedDto dto = new ShipmentTypeStateEventDto.ShipmentTypeStateCreatedDto();
        dto.setStateEventId(new ShipmentTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentTypeStateEventDto.ShipmentTypeStateMergePatchedDto toShipmentTypeStateMergePatchedDto(ShipmentTypeStateEvent.ShipmentTypeStateMergePatched e) {
        ShipmentTypeStateEventDto.ShipmentTypeStateMergePatchedDto dto = new ShipmentTypeStateEventDto.ShipmentTypeStateMergePatchedDto();
        dto.setStateEventId(new ShipmentTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyParentTypeIdRemoved(e.getIsPropertyParentTypeIdRemoved());
        dto.setIsPropertyHasTableRemoved(e.getIsPropertyHasTableRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

