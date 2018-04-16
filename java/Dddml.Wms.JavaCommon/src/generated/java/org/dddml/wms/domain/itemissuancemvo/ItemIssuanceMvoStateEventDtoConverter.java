package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ItemIssuanceMvoStateEventDtoConverter {

    public ItemIssuanceMvoStateEventDto toItemIssuanceMvoStateEventDto(AbstractItemIssuanceMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractItemIssuanceMvoEvent.AbstractItemIssuanceMvoStateCreated) {
            ItemIssuanceMvoEvent.ItemIssuanceMvoStateCreated e = (ItemIssuanceMvoEvent.ItemIssuanceMvoStateCreated) stateEvent;
            return toItemIssuanceMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractItemIssuanceMvoEvent.AbstractItemIssuanceMvoStateMergePatched) {
            ItemIssuanceMvoEvent.ItemIssuanceMvoStateMergePatched e = (ItemIssuanceMvoEvent.ItemIssuanceMvoStateMergePatched) stateEvent;
            return toItemIssuanceMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractItemIssuanceMvoEvent.AbstractItemIssuanceMvoStateDeleted) {
            ItemIssuanceMvoEvent.ItemIssuanceMvoStateDeleted e = (ItemIssuanceMvoEvent.ItemIssuanceMvoStateDeleted) stateEvent;
            return toItemIssuanceMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateCreatedDto toItemIssuanceMvoStateCreatedDto(ItemIssuanceMvoEvent.ItemIssuanceMvoStateCreated e) {
        ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateCreatedDto dto = new ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateCreatedDto();
        dto.setItemIssuanceMvoEventId(e.getItemIssuanceMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOrderId(e.getOrderId());
        dto.setOrderItemSeqId(e.getOrderItemSeqId());
        dto.setShipGroupSeqId(e.getShipGroupSeqId());
        dto.setProductId(e.getProductId());
        dto.setLocatorId(e.getLocatorId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setFixedAssetId(e.getFixedAssetId());
        dto.setMaintHistSeqId(e.getMaintHistSeqId());
        dto.setIssuedDateTime(e.getIssuedDateTime());
        dto.setIssuedByUserLoginId(e.getIssuedByUserLoginId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
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

    public ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateMergePatchedDto toItemIssuanceMvoStateMergePatchedDto(ItemIssuanceMvoEvent.ItemIssuanceMvoStateMergePatched e) {
        ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateMergePatchedDto dto = new ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateMergePatchedDto();
        dto.setItemIssuanceMvoEventId(e.getItemIssuanceMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOrderId(e.getOrderId());
        dto.setOrderItemSeqId(e.getOrderItemSeqId());
        dto.setShipGroupSeqId(e.getShipGroupSeqId());
        dto.setProductId(e.getProductId());
        dto.setLocatorId(e.getLocatorId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setShipmentItemSeqId(e.getShipmentItemSeqId());
        dto.setFixedAssetId(e.getFixedAssetId());
        dto.setMaintHistSeqId(e.getMaintHistSeqId());
        dto.setIssuedDateTime(e.getIssuedDateTime());
        dto.setIssuedByUserLoginId(e.getIssuedByUserLoginId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
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
        dto.setIsPropertyOrderIdRemoved(e.getIsPropertyOrderIdRemoved());
        dto.setIsPropertyOrderItemSeqIdRemoved(e.getIsPropertyOrderItemSeqIdRemoved());
        dto.setIsPropertyShipGroupSeqIdRemoved(e.getIsPropertyShipGroupSeqIdRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyShipmentItemSeqIdRemoved(e.getIsPropertyShipmentItemSeqIdRemoved());
        dto.setIsPropertyFixedAssetIdRemoved(e.getIsPropertyFixedAssetIdRemoved());
        dto.setIsPropertyMaintHistSeqIdRemoved(e.getIsPropertyMaintHistSeqIdRemoved());
        dto.setIsPropertyIssuedDateTimeRemoved(e.getIsPropertyIssuedDateTimeRemoved());
        dto.setIsPropertyIssuedByUserLoginIdRemoved(e.getIsPropertyIssuedByUserLoginIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyCancelQuantityRemoved(e.getIsPropertyCancelQuantityRemoved());
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


    public ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateDeletedDto toItemIssuanceMvoStateDeletedDto(ItemIssuanceMvoEvent.ItemIssuanceMvoStateDeleted e) {
        ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateDeletedDto dto = new ItemIssuanceMvoStateEventDto.ItemIssuanceMvoStateDeletedDto();
        dto.setItemIssuanceMvoEventId(e.getItemIssuanceMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

