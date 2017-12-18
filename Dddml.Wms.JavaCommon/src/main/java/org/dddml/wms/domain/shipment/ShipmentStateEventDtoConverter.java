package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentStateEventDtoConverter {

    public ShipmentStateEventDto toShipmentStateEventDto(AbstractShipmentStateEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentStateEvent.AbstractShipmentStateCreated) {
            ShipmentStateEvent.ShipmentStateCreated e = (ShipmentStateEvent.ShipmentStateCreated) stateEvent;
            return toShipmentStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentStateEvent.AbstractShipmentStateMergePatched) {
            ShipmentStateEvent.ShipmentStateMergePatched e = (ShipmentStateEvent.ShipmentStateMergePatched) stateEvent;
            return toShipmentStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ShipmentStateEventDto.ShipmentStateCreatedDto toShipmentStateCreatedDto(ShipmentStateEvent.ShipmentStateCreated e) {
        ShipmentStateEventDto.ShipmentStateCreatedDto dto = new ShipmentStateEventDto.ShipmentStateCreatedDto();
        dto.setStateEventId(new ShipmentStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentTypeId(e.getShipmentTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryReturnId(e.getPrimaryReturnId());
        dto.setPicklistBinId(e.getPicklistBinId());
        dto.setEstimatedReadyDate(e.getEstimatedReadyDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedShipWorkEffId(e.getEstimatedShipWorkEffId());
        dto.setEstimatedArrivalDate(e.getEstimatedArrivalDate());
        dto.setEstimatedArrivalWorkEffId(e.getEstimatedArrivalWorkEffId());
        dto.setLatestCancelDate(e.getLatestCancelDate());
        dto.setEstimatedShipCost(e.getEstimatedShipCost());
        dto.setCurrencyUomId(e.getCurrencyUomId());
        dto.setHandlingInstructions(e.getHandlingInstructions());
        dto.setOriginFacilityId(e.getOriginFacilityId());
        dto.setDestinationFacilityId(e.getDestinationFacilityId());
        dto.setOriginContactMechId(e.getOriginContactMechId());
        dto.setOriginTelecomNumberId(e.getOriginTelecomNumberId());
        dto.setDestinationContactMechId(e.getDestinationContactMechId());
        dto.setDestinationTelecomNumberId(e.getDestinationTelecomNumberId());
        dto.setPartyIdTo(e.getPartyIdTo());
        dto.setPartyIdFrom(e.getPartyIdFrom());
        dto.setAdditionalShippingCharge(e.getAdditionalShippingCharge());
        dto.setAddtlShippingChargeDesc(e.getAddtlShippingChargeDesc());
        dto.setActive(e.getActive());
        List<ShipmentItemStateEventDto.ShipmentItemStateCreatedDto> shipmentItemEvents = new ArrayList<>();
        for (ShipmentItemStateEvent.ShipmentItemStateCreated ee : e.getShipmentItemEvents()) {
            ShipmentItemStateEventDto.ShipmentItemStateCreatedDto eeDto = getShipmentItemStateEventDtoConverter().toShipmentItemStateCreatedDto(ee);
            shipmentItemEvents.add(eeDto);
        }
        dto.setShipmentItemEvents(shipmentItemEvents.toArray(new ShipmentItemStateEventDto.ShipmentItemStateCreatedDto[0]));

        return dto;
    }

    public ShipmentStateEventDto.ShipmentStateMergePatchedDto toShipmentStateMergePatchedDto(ShipmentStateEvent.ShipmentStateMergePatched e) {
        ShipmentStateEventDto.ShipmentStateMergePatchedDto dto = new ShipmentStateEventDto.ShipmentStateMergePatchedDto();
        dto.setStateEventId(new ShipmentStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentTypeId(e.getShipmentTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryReturnId(e.getPrimaryReturnId());
        dto.setPicklistBinId(e.getPicklistBinId());
        dto.setEstimatedReadyDate(e.getEstimatedReadyDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedShipWorkEffId(e.getEstimatedShipWorkEffId());
        dto.setEstimatedArrivalDate(e.getEstimatedArrivalDate());
        dto.setEstimatedArrivalWorkEffId(e.getEstimatedArrivalWorkEffId());
        dto.setLatestCancelDate(e.getLatestCancelDate());
        dto.setEstimatedShipCost(e.getEstimatedShipCost());
        dto.setCurrencyUomId(e.getCurrencyUomId());
        dto.setHandlingInstructions(e.getHandlingInstructions());
        dto.setOriginFacilityId(e.getOriginFacilityId());
        dto.setDestinationFacilityId(e.getDestinationFacilityId());
        dto.setOriginContactMechId(e.getOriginContactMechId());
        dto.setOriginTelecomNumberId(e.getOriginTelecomNumberId());
        dto.setDestinationContactMechId(e.getDestinationContactMechId());
        dto.setDestinationTelecomNumberId(e.getDestinationTelecomNumberId());
        dto.setPartyIdTo(e.getPartyIdTo());
        dto.setPartyIdFrom(e.getPartyIdFrom());
        dto.setAdditionalShippingCharge(e.getAdditionalShippingCharge());
        dto.setAddtlShippingChargeDesc(e.getAddtlShippingChargeDesc());
        dto.setActive(e.getActive());
        dto.setIsPropertyShipmentTypeIdRemoved(e.getIsPropertyShipmentTypeIdRemoved());
        dto.setIsPropertyStatusIdRemoved(e.getIsPropertyStatusIdRemoved());
        dto.setIsPropertyPrimaryOrderIdRemoved(e.getIsPropertyPrimaryOrderIdRemoved());
        dto.setIsPropertyPrimaryReturnIdRemoved(e.getIsPropertyPrimaryReturnIdRemoved());
        dto.setIsPropertyPicklistBinIdRemoved(e.getIsPropertyPicklistBinIdRemoved());
        dto.setIsPropertyEstimatedReadyDateRemoved(e.getIsPropertyEstimatedReadyDateRemoved());
        dto.setIsPropertyEstimatedShipDateRemoved(e.getIsPropertyEstimatedShipDateRemoved());
        dto.setIsPropertyEstimatedShipWorkEffIdRemoved(e.getIsPropertyEstimatedShipWorkEffIdRemoved());
        dto.setIsPropertyEstimatedArrivalDateRemoved(e.getIsPropertyEstimatedArrivalDateRemoved());
        dto.setIsPropertyEstimatedArrivalWorkEffIdRemoved(e.getIsPropertyEstimatedArrivalWorkEffIdRemoved());
        dto.setIsPropertyLatestCancelDateRemoved(e.getIsPropertyLatestCancelDateRemoved());
        dto.setIsPropertyEstimatedShipCostRemoved(e.getIsPropertyEstimatedShipCostRemoved());
        dto.setIsPropertyCurrencyUomIdRemoved(e.getIsPropertyCurrencyUomIdRemoved());
        dto.setIsPropertyHandlingInstructionsRemoved(e.getIsPropertyHandlingInstructionsRemoved());
        dto.setIsPropertyOriginFacilityIdRemoved(e.getIsPropertyOriginFacilityIdRemoved());
        dto.setIsPropertyDestinationFacilityIdRemoved(e.getIsPropertyDestinationFacilityIdRemoved());
        dto.setIsPropertyOriginContactMechIdRemoved(e.getIsPropertyOriginContactMechIdRemoved());
        dto.setIsPropertyOriginTelecomNumberIdRemoved(e.getIsPropertyOriginTelecomNumberIdRemoved());
        dto.setIsPropertyDestinationContactMechIdRemoved(e.getIsPropertyDestinationContactMechIdRemoved());
        dto.setIsPropertyDestinationTelecomNumberIdRemoved(e.getIsPropertyDestinationTelecomNumberIdRemoved());
        dto.setIsPropertyPartyIdToRemoved(e.getIsPropertyPartyIdToRemoved());
        dto.setIsPropertyPartyIdFromRemoved(e.getIsPropertyPartyIdFromRemoved());
        dto.setIsPropertyAdditionalShippingChargeRemoved(e.getIsPropertyAdditionalShippingChargeRemoved());
        dto.setIsPropertyAddtlShippingChargeDescRemoved(e.getIsPropertyAddtlShippingChargeDescRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<ShipmentItemStateEventDto> shipmentItemEvents = new ArrayList<>();
        for (ShipmentItemStateEvent ee : e.getShipmentItemEvents()) {
            ShipmentItemStateEventDto eeDto = getShipmentItemStateEventDtoConverter().toShipmentItemStateEventDto((AbstractShipmentItemStateEvent) ee);
            shipmentItemEvents.add(eeDto);
        }
        dto.setShipmentItemEvents(shipmentItemEvents.toArray(new ShipmentItemStateEventDto[0]));

        return dto;
    }


    protected ShipmentItemStateEventDtoConverter getShipmentItemStateEventDtoConverter() {
        return new ShipmentItemStateEventDtoConverter();
    }

}

