package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ItemIssuanceStateEventDtoConverter {

    public ItemIssuanceStateEventDto toItemIssuanceStateEventDto(AbstractItemIssuanceEvent stateEvent) {
        if (stateEvent instanceof AbstractItemIssuanceEvent.AbstractItemIssuanceStateCreated) {
            ItemIssuanceEvent.ItemIssuanceStateCreated e = (ItemIssuanceEvent.ItemIssuanceStateCreated) stateEvent;
            return toItemIssuanceStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractItemIssuanceEvent.AbstractItemIssuanceStateMergePatched) {
            ItemIssuanceEvent.ItemIssuanceStateMergePatched e = (ItemIssuanceEvent.ItemIssuanceStateMergePatched) stateEvent;
            return toItemIssuanceStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractItemIssuanceEvent.AbstractItemIssuanceStateRemoved) {
            ItemIssuanceEvent.ItemIssuanceStateRemoved e = (ItemIssuanceEvent.ItemIssuanceStateRemoved) stateEvent;
            return toItemIssuanceStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto toItemIssuanceStateCreatedDto(ItemIssuanceEvent.ItemIssuanceStateCreated e) {
        ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto dto = new ItemIssuanceStateEventDto.ItemIssuanceStateCreatedDto();
        dto.setItemIssuanceEventId(e.getItemIssuanceEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
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
        dto.setActive(e.getActive());
        return dto;
    }

    public ItemIssuanceStateEventDto.ItemIssuanceStateMergePatchedDto toItemIssuanceStateMergePatchedDto(ItemIssuanceEvent.ItemIssuanceStateMergePatched e) {
        ItemIssuanceStateEventDto.ItemIssuanceStateMergePatchedDto dto = new ItemIssuanceStateEventDto.ItemIssuanceStateMergePatchedDto();
        dto.setItemIssuanceEventId(e.getItemIssuanceEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
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
        dto.setActive(e.getActive());
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
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public ItemIssuanceStateEventDto.ItemIssuanceStateRemovedDto toItemIssuanceStateRemovedDto(ItemIssuanceEvent.ItemIssuanceStateRemoved e) {
        ItemIssuanceStateEventDto.ItemIssuanceStateRemovedDto dto = new ItemIssuanceStateEventDto.ItemIssuanceStateRemovedDto();
        dto.setItemIssuanceEventId(e.getItemIssuanceEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

