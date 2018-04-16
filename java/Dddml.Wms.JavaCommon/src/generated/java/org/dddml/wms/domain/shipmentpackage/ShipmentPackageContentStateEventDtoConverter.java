package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentPackageContentStateEventDtoConverter {

    public ShipmentPackageContentStateEventDto toShipmentPackageContentStateEventDto(AbstractShipmentPackageContentEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentPackageContentEvent.AbstractShipmentPackageContentStateCreated) {
            ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e = (ShipmentPackageContentEvent.ShipmentPackageContentStateCreated) stateEvent;
            return toShipmentPackageContentStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageContentEvent.AbstractShipmentPackageContentStateMergePatched) {
            ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched e = (ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched) stateEvent;
            return toShipmentPackageContentStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageContentEvent.AbstractShipmentPackageContentStateRemoved) {
            ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e = (ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved) stateEvent;
            return toShipmentPackageContentStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto toShipmentPackageContentStateCreatedDto(ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e) {
        ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto dto = new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto();
        dto.setShipmentPackageContentEventId(e.getShipmentPackageContentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSubProductId(e.getSubProductId());
        dto.setSubProductQuantity(e.getSubProductQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public ShipmentPackageContentStateEventDto.ShipmentPackageContentStateMergePatchedDto toShipmentPackageContentStateMergePatchedDto(ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched e) {
        ShipmentPackageContentStateEventDto.ShipmentPackageContentStateMergePatchedDto dto = new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateMergePatchedDto();
        dto.setShipmentPackageContentEventId(e.getShipmentPackageContentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSubProductId(e.getSubProductId());
        dto.setSubProductQuantity(e.getSubProductQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertySubProductIdRemoved(e.getIsPropertySubProductIdRemoved());
        dto.setIsPropertySubProductQuantityRemoved(e.getIsPropertySubProductQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto toShipmentPackageContentStateRemovedDto(ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e) {
        ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto dto = new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto();
        dto.setShipmentPackageContentEventId(e.getShipmentPackageContentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

