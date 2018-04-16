package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentPackageStateEventDtoConverter {

    public ShipmentPackageStateEventDto toShipmentPackageStateEventDto(AbstractShipmentPackageEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentPackageEvent.AbstractShipmentPackageStateCreated) {
            ShipmentPackageEvent.ShipmentPackageStateCreated e = (ShipmentPackageEvent.ShipmentPackageStateCreated) stateEvent;
            return toShipmentPackageStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageEvent.AbstractShipmentPackageStateMergePatched) {
            ShipmentPackageEvent.ShipmentPackageStateMergePatched e = (ShipmentPackageEvent.ShipmentPackageStateMergePatched) stateEvent;
            return toShipmentPackageStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageEvent.AbstractShipmentPackageStateDeleted) {
            ShipmentPackageEvent.ShipmentPackageStateDeleted e = (ShipmentPackageEvent.ShipmentPackageStateDeleted) stateEvent;
            return toShipmentPackageStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentPackageStateEventDto.ShipmentPackageStateCreatedDto toShipmentPackageStateCreatedDto(ShipmentPackageEvent.ShipmentPackageStateCreated e) {
        ShipmentPackageStateEventDto.ShipmentPackageStateCreatedDto dto = new ShipmentPackageStateEventDto.ShipmentPackageStateCreatedDto();
        dto.setShipmentPackageEventId(e.getShipmentPackageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentBoxTypeId(e.getShipmentBoxTypeId());
        dto.setDateCreated(e.getDateCreated());
        dto.setBoxLength(e.getBoxLength());
        dto.setBoxHeight(e.getBoxHeight());
        dto.setBoxWidth(e.getBoxWidth());
        dto.setDimensionUomId(e.getDimensionUomId());
        dto.setWeight(e.getWeight());
        dto.setWeightUomId(e.getWeightUomId());
        dto.setInsuredValue(e.getInsuredValue());
        dto.setActive(e.getActive());
        List<ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto> shipmentPackageContentEvents = new ArrayList<>();
        for (ShipmentPackageContentEvent.ShipmentPackageContentStateCreated ee : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto eeDto = getShipmentPackageContentStateEventDtoConverter().toShipmentPackageContentStateCreatedDto(ee);
            shipmentPackageContentEvents.add(eeDto);
        }
        dto.setShipmentPackageContentEvents(shipmentPackageContentEvents.toArray(new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto[0]));

        return dto;
    }

    public ShipmentPackageStateEventDto.ShipmentPackageStateMergePatchedDto toShipmentPackageStateMergePatchedDto(ShipmentPackageEvent.ShipmentPackageStateMergePatched e) {
        ShipmentPackageStateEventDto.ShipmentPackageStateMergePatchedDto dto = new ShipmentPackageStateEventDto.ShipmentPackageStateMergePatchedDto();
        dto.setShipmentPackageEventId(e.getShipmentPackageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentBoxTypeId(e.getShipmentBoxTypeId());
        dto.setDateCreated(e.getDateCreated());
        dto.setBoxLength(e.getBoxLength());
        dto.setBoxHeight(e.getBoxHeight());
        dto.setBoxWidth(e.getBoxWidth());
        dto.setDimensionUomId(e.getDimensionUomId());
        dto.setWeight(e.getWeight());
        dto.setWeightUomId(e.getWeightUomId());
        dto.setInsuredValue(e.getInsuredValue());
        dto.setActive(e.getActive());
        dto.setIsPropertyShipmentBoxTypeIdRemoved(e.getIsPropertyShipmentBoxTypeIdRemoved());
        dto.setIsPropertyDateCreatedRemoved(e.getIsPropertyDateCreatedRemoved());
        dto.setIsPropertyBoxLengthRemoved(e.getIsPropertyBoxLengthRemoved());
        dto.setIsPropertyBoxHeightRemoved(e.getIsPropertyBoxHeightRemoved());
        dto.setIsPropertyBoxWidthRemoved(e.getIsPropertyBoxWidthRemoved());
        dto.setIsPropertyDimensionUomIdRemoved(e.getIsPropertyDimensionUomIdRemoved());
        dto.setIsPropertyWeightRemoved(e.getIsPropertyWeightRemoved());
        dto.setIsPropertyWeightUomIdRemoved(e.getIsPropertyWeightUomIdRemoved());
        dto.setIsPropertyInsuredValueRemoved(e.getIsPropertyInsuredValueRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<ShipmentPackageContentStateEventDto> shipmentPackageContentEvents = new ArrayList<>();
        for (ShipmentPackageContentEvent ee : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentStateEventDto eeDto = getShipmentPackageContentStateEventDtoConverter().toShipmentPackageContentStateEventDto((AbstractShipmentPackageContentEvent) ee);
            shipmentPackageContentEvents.add(eeDto);
        }
        dto.setShipmentPackageContentEvents(shipmentPackageContentEvents.toArray(new ShipmentPackageContentStateEventDto[0]));

        return dto;
    }


    public ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto toShipmentPackageStateDeletedDto(ShipmentPackageEvent.ShipmentPackageStateDeleted e) {
        ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto dto = new ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto();
        dto.setShipmentPackageEventId(e.getShipmentPackageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto> shipmentPackageContentEvents = new ArrayList<>();
        for (ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved ee : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto eeDto = getShipmentPackageContentStateEventDtoConverter().toShipmentPackageContentStateRemovedDto(ee);
            shipmentPackageContentEvents.add(eeDto);
        }
        dto.setShipmentPackageContentEvents(shipmentPackageContentEvents.toArray(new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto[0]));

        return dto;
    }

    protected ShipmentPackageContentStateEventDtoConverter getShipmentPackageContentStateEventDtoConverter() {
        return new ShipmentPackageContentStateEventDtoConverter();
    }

}

