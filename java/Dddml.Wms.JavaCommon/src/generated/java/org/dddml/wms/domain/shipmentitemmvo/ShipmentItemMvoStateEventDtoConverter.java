package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ShipmentItemMvoStateEventDtoConverter {

    public ShipmentItemMvoStateEventDto toShipmentItemMvoStateEventDto(AbstractShipmentItemMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractShipmentItemMvoEvent.AbstractShipmentItemMvoStateCreated) {
            ShipmentItemMvoEvent.ShipmentItemMvoStateCreated e = (ShipmentItemMvoEvent.ShipmentItemMvoStateCreated) stateEvent;
            return toShipmentItemMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractShipmentItemMvoEvent.AbstractShipmentItemMvoStateMergePatched) {
            ShipmentItemMvoEvent.ShipmentItemMvoStateMergePatched e = (ShipmentItemMvoEvent.ShipmentItemMvoStateMergePatched) stateEvent;
            return toShipmentItemMvoStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ShipmentItemMvoStateEventDto.ShipmentItemMvoStateCreatedDto toShipmentItemMvoStateCreatedDto(ShipmentItemMvoEvent.ShipmentItemMvoStateCreated e) {
        ShipmentItemMvoStateEventDto.ShipmentItemMvoStateCreatedDto dto = new ShipmentItemMvoStateEventDto.ShipmentItemMvoStateCreatedDto();
        dto.setShipmentItemMvoEventId(e.getShipmentItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setQuantity(e.getQuantity());
        dto.setShipmentContentDescription(e.getShipmentContentDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setShipmentShipmentTypeId(e.getShipmentShipmentTypeId());
        dto.setShipmentStatusId(e.getShipmentStatusId());
        dto.setShipmentPrimaryOrderId(e.getShipmentPrimaryOrderId());
        dto.setShipmentPrimaryReturnId(e.getShipmentPrimaryReturnId());
        dto.setShipmentPrimaryShipGroupSeqId(e.getShipmentPrimaryShipGroupSeqId());
        dto.setShipmentPicklistBinId(e.getShipmentPicklistBinId());
        dto.setShipmentEstimatedReadyDate(e.getShipmentEstimatedReadyDate());
        dto.setShipmentEstimatedShipDate(e.getShipmentEstimatedShipDate());
        dto.setShipmentEstimatedShipWorkEffId(e.getShipmentEstimatedShipWorkEffId());
        dto.setShipmentEstimatedArrivalDate(e.getShipmentEstimatedArrivalDate());
        dto.setShipmentEstimatedArrivalWorkEffId(e.getShipmentEstimatedArrivalWorkEffId());
        dto.setShipmentLatestCancelDate(e.getShipmentLatestCancelDate());
        dto.setShipmentEstimatedShipCost(e.getShipmentEstimatedShipCost());
        dto.setShipmentCurrencyUomId(e.getShipmentCurrencyUomId());
        dto.setShipmentHandlingInstructions(e.getShipmentHandlingInstructions());
        dto.setShipmentOriginFacilityId(e.getShipmentOriginFacilityId());
        dto.setShipmentDestinationFacilityId(e.getShipmentDestinationFacilityId());
        dto.setShipmentOriginContactMechId(e.getShipmentOriginContactMechId());
        dto.setShipmentOriginTelecomNumberId(e.getShipmentOriginTelecomNumberId());
        dto.setShipmentDestinationContactMechId(e.getShipmentDestinationContactMechId());
        dto.setShipmentDestinationTelecomNumberId(e.getShipmentDestinationTelecomNumberId());
        dto.setShipmentPartyIdTo(e.getShipmentPartyIdTo());
        dto.setShipmentPartyIdFrom(e.getShipmentPartyIdFrom());
        dto.setShipmentAdditionalShippingCharge(e.getShipmentAdditionalShippingCharge());
        dto.setShipmentAddtlShippingChargeDesc(e.getShipmentAddtlShippingChargeDesc());
        dto.setShipmentCreatedBy(e.getShipmentCreatedBy());
        dto.setShipmentCreatedAt(e.getShipmentCreatedAt());
        dto.setShipmentUpdatedBy(e.getShipmentUpdatedBy());
        dto.setShipmentUpdatedAt(e.getShipmentUpdatedAt());
        dto.setShipmentActive(e.getShipmentActive());
        return dto;
    }

    public ShipmentItemMvoStateEventDto.ShipmentItemMvoStateMergePatchedDto toShipmentItemMvoStateMergePatchedDto(ShipmentItemMvoEvent.ShipmentItemMvoStateMergePatched e) {
        ShipmentItemMvoStateEventDto.ShipmentItemMvoStateMergePatchedDto dto = new ShipmentItemMvoStateEventDto.ShipmentItemMvoStateMergePatchedDto();
        dto.setShipmentItemMvoEventId(e.getShipmentItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setQuantity(e.getQuantity());
        dto.setShipmentContentDescription(e.getShipmentContentDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setShipmentShipmentTypeId(e.getShipmentShipmentTypeId());
        dto.setShipmentStatusId(e.getShipmentStatusId());
        dto.setShipmentPrimaryOrderId(e.getShipmentPrimaryOrderId());
        dto.setShipmentPrimaryReturnId(e.getShipmentPrimaryReturnId());
        dto.setShipmentPrimaryShipGroupSeqId(e.getShipmentPrimaryShipGroupSeqId());
        dto.setShipmentPicklistBinId(e.getShipmentPicklistBinId());
        dto.setShipmentEstimatedReadyDate(e.getShipmentEstimatedReadyDate());
        dto.setShipmentEstimatedShipDate(e.getShipmentEstimatedShipDate());
        dto.setShipmentEstimatedShipWorkEffId(e.getShipmentEstimatedShipWorkEffId());
        dto.setShipmentEstimatedArrivalDate(e.getShipmentEstimatedArrivalDate());
        dto.setShipmentEstimatedArrivalWorkEffId(e.getShipmentEstimatedArrivalWorkEffId());
        dto.setShipmentLatestCancelDate(e.getShipmentLatestCancelDate());
        dto.setShipmentEstimatedShipCost(e.getShipmentEstimatedShipCost());
        dto.setShipmentCurrencyUomId(e.getShipmentCurrencyUomId());
        dto.setShipmentHandlingInstructions(e.getShipmentHandlingInstructions());
        dto.setShipmentOriginFacilityId(e.getShipmentOriginFacilityId());
        dto.setShipmentDestinationFacilityId(e.getShipmentDestinationFacilityId());
        dto.setShipmentOriginContactMechId(e.getShipmentOriginContactMechId());
        dto.setShipmentOriginTelecomNumberId(e.getShipmentOriginTelecomNumberId());
        dto.setShipmentDestinationContactMechId(e.getShipmentDestinationContactMechId());
        dto.setShipmentDestinationTelecomNumberId(e.getShipmentDestinationTelecomNumberId());
        dto.setShipmentPartyIdTo(e.getShipmentPartyIdTo());
        dto.setShipmentPartyIdFrom(e.getShipmentPartyIdFrom());
        dto.setShipmentAdditionalShippingCharge(e.getShipmentAdditionalShippingCharge());
        dto.setShipmentAddtlShippingChargeDesc(e.getShipmentAddtlShippingChargeDesc());
        dto.setShipmentCreatedBy(e.getShipmentCreatedBy());
        dto.setShipmentCreatedAt(e.getShipmentCreatedAt());
        dto.setShipmentUpdatedBy(e.getShipmentUpdatedBy());
        dto.setShipmentUpdatedAt(e.getShipmentUpdatedAt());
        dto.setShipmentActive(e.getShipmentActive());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyShipmentContentDescriptionRemoved(e.getIsPropertyShipmentContentDescriptionRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyShipmentShipmentTypeIdRemoved(e.getIsPropertyShipmentShipmentTypeIdRemoved());
        dto.setIsPropertyShipmentStatusIdRemoved(e.getIsPropertyShipmentStatusIdRemoved());
        dto.setIsPropertyShipmentPrimaryOrderIdRemoved(e.getIsPropertyShipmentPrimaryOrderIdRemoved());
        dto.setIsPropertyShipmentPrimaryReturnIdRemoved(e.getIsPropertyShipmentPrimaryReturnIdRemoved());
        dto.setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(e.getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved());
        dto.setIsPropertyShipmentPicklistBinIdRemoved(e.getIsPropertyShipmentPicklistBinIdRemoved());
        dto.setIsPropertyShipmentEstimatedReadyDateRemoved(e.getIsPropertyShipmentEstimatedReadyDateRemoved());
        dto.setIsPropertyShipmentEstimatedShipDateRemoved(e.getIsPropertyShipmentEstimatedShipDateRemoved());
        dto.setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(e.getIsPropertyShipmentEstimatedShipWorkEffIdRemoved());
        dto.setIsPropertyShipmentEstimatedArrivalDateRemoved(e.getIsPropertyShipmentEstimatedArrivalDateRemoved());
        dto.setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(e.getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved());
        dto.setIsPropertyShipmentLatestCancelDateRemoved(e.getIsPropertyShipmentLatestCancelDateRemoved());
        dto.setIsPropertyShipmentEstimatedShipCostRemoved(e.getIsPropertyShipmentEstimatedShipCostRemoved());
        dto.setIsPropertyShipmentCurrencyUomIdRemoved(e.getIsPropertyShipmentCurrencyUomIdRemoved());
        dto.setIsPropertyShipmentHandlingInstructionsRemoved(e.getIsPropertyShipmentHandlingInstructionsRemoved());
        dto.setIsPropertyShipmentOriginFacilityIdRemoved(e.getIsPropertyShipmentOriginFacilityIdRemoved());
        dto.setIsPropertyShipmentDestinationFacilityIdRemoved(e.getIsPropertyShipmentDestinationFacilityIdRemoved());
        dto.setIsPropertyShipmentOriginContactMechIdRemoved(e.getIsPropertyShipmentOriginContactMechIdRemoved());
        dto.setIsPropertyShipmentOriginTelecomNumberIdRemoved(e.getIsPropertyShipmentOriginTelecomNumberIdRemoved());
        dto.setIsPropertyShipmentDestinationContactMechIdRemoved(e.getIsPropertyShipmentDestinationContactMechIdRemoved());
        dto.setIsPropertyShipmentDestinationTelecomNumberIdRemoved(e.getIsPropertyShipmentDestinationTelecomNumberIdRemoved());
        dto.setIsPropertyShipmentPartyIdToRemoved(e.getIsPropertyShipmentPartyIdToRemoved());
        dto.setIsPropertyShipmentPartyIdFromRemoved(e.getIsPropertyShipmentPartyIdFromRemoved());
        dto.setIsPropertyShipmentAdditionalShippingChargeRemoved(e.getIsPropertyShipmentAdditionalShippingChargeRemoved());
        dto.setIsPropertyShipmentAddtlShippingChargeDescRemoved(e.getIsPropertyShipmentAddtlShippingChargeDescRemoved());
        dto.setIsPropertyShipmentCreatedByRemoved(e.getIsPropertyShipmentCreatedByRemoved());
        dto.setIsPropertyShipmentCreatedAtRemoved(e.getIsPropertyShipmentCreatedAtRemoved());
        dto.setIsPropertyShipmentUpdatedByRemoved(e.getIsPropertyShipmentUpdatedByRemoved());
        dto.setIsPropertyShipmentUpdatedAtRemoved(e.getIsPropertyShipmentUpdatedAtRemoved());
        dto.setIsPropertyShipmentActiveRemoved(e.getIsPropertyShipmentActiveRemoved());
        return dto;
    }


}

