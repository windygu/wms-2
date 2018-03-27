package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentPackageStateEventDtoConverter {

    public ShipmentPackageStateEventDto toShipmentPackageStateEventDto(AbstractShipmentPackageStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentPackageStateEvent.AbstractShipmentPackageStateCreated) {
            ShipmentPackageStateEvent.ShipmentPackageStateCreated e = (ShipmentPackageStateEvent.ShipmentPackageStateCreated) stateEvent;
            return toShipmentPackageStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageStateEvent.AbstractShipmentPackageStateMergePatched) {
            ShipmentPackageStateEvent.ShipmentPackageStateMergePatched e = (ShipmentPackageStateEvent.ShipmentPackageStateMergePatched) stateEvent;
            return toShipmentPackageStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractShipmentPackageStateEvent.AbstractShipmentPackageStateDeleted) {
            ShipmentPackageStateEvent.ShipmentPackageStateDeleted e = (ShipmentPackageStateEvent.ShipmentPackageStateDeleted) stateEvent;
            return toShipmentPackageStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentPackageStateEventDto.ShipmentPackageStateCreatedDto toShipmentPackageStateCreatedDto(ShipmentPackageStateEvent.ShipmentPackageStateCreated e) {
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
        for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated ee : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto eeDto = getShipmentPackageContentStateEventDtoConverter().toShipmentPackageContentStateCreatedDto(ee);
            shipmentPackageContentEvents.add(eeDto);
        }
        dto.setShipmentPackageContentEvents(shipmentPackageContentEvents.toArray(new ShipmentPackageContentStateEventDto.ShipmentPackageContentStateCreatedDto[0]));

        return dto;
    }

    public ShipmentPackageStateEventDto.ShipmentPackageStateMergePatchedDto toShipmentPackageStateMergePatchedDto(ShipmentPackageStateEvent.ShipmentPackageStateMergePatched e) {
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
        for (ShipmentPackageContentStateEvent ee : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentStateEventDto eeDto = getShipmentPackageContentStateEventDtoConverter().toShipmentPackageContentStateEventDto((AbstractShipmentPackageContentStateEvent) ee);
            shipmentPackageContentEvents.add(eeDto);
        }
        dto.setShipmentPackageContentEvents(shipmentPackageContentEvents.toArray(new ShipmentPackageContentStateEventDto[0]));

        return dto;
    }


    public ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto toShipmentPackageStateDeletedDto(ShipmentPackageStateEvent.ShipmentPackageStateDeleted e) {
        ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto dto = new ShipmentPackageStateEventDto.ShipmentPackageStateDeletedDto();
        dto.setShipmentPackageEventId(e.getShipmentPackageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<ShipmentPackageContentStateEventDto.ShipmentPackageContentStateRemovedDto> shipmentPackageContentEvents = new ArrayList<>();
        for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved ee : e.getShipmentPackageContentEvents()) {
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

