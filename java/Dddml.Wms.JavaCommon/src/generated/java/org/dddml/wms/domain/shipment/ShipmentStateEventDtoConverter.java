package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentStateEventDtoConverter {

    public ShipmentStateEventDto toShipmentStateEventDto(AbstractShipmentEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentEvent.AbstractShipmentStateCreated) {
            ShipmentEvent.ShipmentStateCreated e = (ShipmentEvent.ShipmentStateCreated) stateEvent;
            return toShipmentStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentEvent.AbstractShipmentStateMergePatched) {
            ShipmentEvent.ShipmentStateMergePatched e = (ShipmentEvent.ShipmentStateMergePatched) stateEvent;
            return toShipmentStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentStateEventDto.ShipmentStateCreatedDto toShipmentStateCreatedDto(ShipmentEvent.ShipmentStateCreated e) {
        ShipmentStateEventDto.ShipmentStateCreatedDto dto = new ShipmentStateEventDto.ShipmentStateCreatedDto();
        dto.setShipmentEventId(e.getShipmentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentTypeId(e.getShipmentTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryReturnId(e.getPrimaryReturnId());
        dto.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        dto.setPicklistBinId(e.getPicklistBinId());
        dto.setBolNumber(e.getBolNumber());
        dto.setSealNumber(e.getSealNumber());
        dto.setVehicleId(e.getVehicleId());
        dto.setPoNumber(e.getPoNumber());
        dto.setCarrier(e.getCarrier());
        dto.setDateShipped(e.getDateShipped());
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
        for (ShipmentItemEvent.ShipmentItemStateCreated ee : e.getShipmentItemEvents()) {
            ShipmentItemStateEventDto.ShipmentItemStateCreatedDto eeDto = getShipmentItemStateEventDtoConverter().toShipmentItemStateCreatedDto(ee);
            shipmentItemEvents.add(eeDto);
        }
        dto.setShipmentItemEvents(shipmentItemEvents.toArray(new ShipmentItemStateEventDto.ShipmentItemStateCreatedDto[0]));

        List<ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto> shipmentReceiptEvents = new ArrayList<>();
        for (ShipmentReceiptEvent.ShipmentReceiptStateCreated ee : e.getShipmentReceiptEvents()) {
            ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto eeDto = getShipmentReceiptStateEventDtoConverter().toShipmentReceiptStateCreatedDto(ee);
            shipmentReceiptEvents.add(eeDto);
        }
        dto.setShipmentReceiptEvents(shipmentReceiptEvents.toArray(new ShipmentReceiptStateEventDto.ShipmentReceiptStateCreatedDto[0]));

        List<ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto> itemIssuanceEvents = new ArrayList<>();
        for (ItemIssuanceEvent.ItemIssuanceStateCreated ee : e.getItemIssuanceEvents()) {
            ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto eeDto = getItemIssuanceStateEventDtoConverter().toItemIssuanceStateCreatedDto(ee);
            itemIssuanceEvents.add(eeDto);
        }
        dto.setItemIssuanceEvents(itemIssuanceEvents.toArray(new ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto[0]));

        return dto;
    }

    public ShipmentStateEventDto.ShipmentStateMergePatchedDto toShipmentStateMergePatchedDto(ShipmentEvent.ShipmentStateMergePatched e) {
        ShipmentStateEventDto.ShipmentStateMergePatchedDto dto = new ShipmentStateEventDto.ShipmentStateMergePatchedDto();
        dto.setShipmentEventId(e.getShipmentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentTypeId(e.getShipmentTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryReturnId(e.getPrimaryReturnId());
        dto.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        dto.setPicklistBinId(e.getPicklistBinId());
        dto.setBolNumber(e.getBolNumber());
        dto.setSealNumber(e.getSealNumber());
        dto.setVehicleId(e.getVehicleId());
        dto.setPoNumber(e.getPoNumber());
        dto.setCarrier(e.getCarrier());
        dto.setDateShipped(e.getDateShipped());
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
        dto.setIsPropertyPrimaryShipGroupSeqIdRemoved(e.getIsPropertyPrimaryShipGroupSeqIdRemoved());
        dto.setIsPropertyPicklistBinIdRemoved(e.getIsPropertyPicklistBinIdRemoved());
        dto.setIsPropertyBolNumberRemoved(e.getIsPropertyBolNumberRemoved());
        dto.setIsPropertySealNumberRemoved(e.getIsPropertySealNumberRemoved());
        dto.setIsPropertyVehicleIdRemoved(e.getIsPropertyVehicleIdRemoved());
        dto.setIsPropertyPoNumberRemoved(e.getIsPropertyPoNumberRemoved());
        dto.setIsPropertyCarrierRemoved(e.getIsPropertyCarrierRemoved());
        dto.setIsPropertyDateShippedRemoved(e.getIsPropertyDateShippedRemoved());
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
        for (ShipmentItemEvent ee : e.getShipmentItemEvents()) {
            ShipmentItemStateEventDto eeDto = getShipmentItemStateEventDtoConverter().toShipmentItemStateEventDto((AbstractShipmentItemEvent) ee);
            shipmentItemEvents.add(eeDto);
        }
        dto.setShipmentItemEvents(shipmentItemEvents.toArray(new ShipmentItemStateEventDto[0]));

        List<ShipmentReceiptStateEventDto> shipmentReceiptEvents = new ArrayList<>();
        for (ShipmentReceiptEvent ee : e.getShipmentReceiptEvents()) {
            ShipmentReceiptStateEventDto eeDto = getShipmentReceiptStateEventDtoConverter().toShipmentReceiptStateEventDto((AbstractShipmentReceiptEvent) ee);
            shipmentReceiptEvents.add(eeDto);
        }
        dto.setShipmentReceiptEvents(shipmentReceiptEvents.toArray(new ShipmentReceiptStateEventDto[0]));

        List<ItemIssuanceStateEventDto> itemIssuanceEvents = new ArrayList<>();
        for (ItemIssuanceEvent ee : e.getItemIssuanceEvents()) {
            ItemIssuanceStateEventDto eeDto = getItemIssuanceStateEventDtoConverter().toItemIssuanceStateEventDto((AbstractItemIssuanceEvent) ee);
            itemIssuanceEvents.add(eeDto);
        }
        dto.setItemIssuanceEvents(itemIssuanceEvents.toArray(new ItemIssuanceStateEventDto[0]));

        return dto;
    }


    protected ShipmentItemStateEventDtoConverter getShipmentItemStateEventDtoConverter() {
        return new ShipmentItemStateEventDtoConverter();
    }

    protected ShipmentReceiptStateEventDtoConverter getShipmentReceiptStateEventDtoConverter() {
        return new ShipmentReceiptStateEventDtoConverter();
    }

    protected ItemIssuanceStateEventDtoConverter getItemIssuanceStateEventDtoConverter() {
        return new ItemIssuanceStateEventDtoConverter();
    }

}

