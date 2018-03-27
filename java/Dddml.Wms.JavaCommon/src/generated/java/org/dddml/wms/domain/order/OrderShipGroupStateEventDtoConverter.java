package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderShipGroupStateEventDtoConverter {

    public OrderShipGroupStateEventDto toOrderShipGroupStateEventDto(AbstractOrderShipGroupStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderShipGroupStateEvent.AbstractOrderShipGroupStateCreated) {
            OrderShipGroupStateEvent.OrderShipGroupStateCreated e = (OrderShipGroupStateEvent.OrderShipGroupStateCreated) stateEvent;
            return toOrderShipGroupStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupStateEvent.AbstractOrderShipGroupStateMergePatched) {
            OrderShipGroupStateEvent.OrderShipGroupStateMergePatched e = (OrderShipGroupStateEvent.OrderShipGroupStateMergePatched) stateEvent;
            return toOrderShipGroupStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupStateEvent.AbstractOrderShipGroupStateRemoved) {
            OrderShipGroupStateEvent.OrderShipGroupStateRemoved e = (OrderShipGroupStateEvent.OrderShipGroupStateRemoved) stateEvent;
            return toOrderShipGroupStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderShipGroupStateEventDto.OrderShipGroupStateCreatedDto toOrderShipGroupStateCreatedDto(OrderShipGroupStateEvent.OrderShipGroupStateCreated e) {
        OrderShipGroupStateEventDto.OrderShipGroupStateCreatedDto dto = new OrderShipGroupStateEventDto.OrderShipGroupStateCreatedDto();
        dto.setOrderShipGroupEventId(e.getOrderShipGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setSupplierPartyId(e.getSupplierPartyId());
        dto.setVendorPartyId(e.getVendorPartyId());
        dto.setCarrierPartyId(e.getCarrierPartyId());
        dto.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        dto.setFacilityId(e.getFacilityId());
        dto.setContactMechId(e.getContactMechId());
        dto.setTelecomContactMechId(e.getTelecomContactMechId());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setShippingInstructions(e.getShippingInstructions());
        dto.setMaySplit(e.getMaySplit());
        dto.setGiftMessage(e.getGiftMessage());
        dto.setIsGift(e.getIsGift());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setShipByDate(e.getShipByDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderShipGroupStateEventDto.OrderShipGroupStateMergePatchedDto toOrderShipGroupStateMergePatchedDto(OrderShipGroupStateEvent.OrderShipGroupStateMergePatched e) {
        OrderShipGroupStateEventDto.OrderShipGroupStateMergePatchedDto dto = new OrderShipGroupStateEventDto.OrderShipGroupStateMergePatchedDto();
        dto.setOrderShipGroupEventId(e.getOrderShipGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setSupplierPartyId(e.getSupplierPartyId());
        dto.setVendorPartyId(e.getVendorPartyId());
        dto.setCarrierPartyId(e.getCarrierPartyId());
        dto.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        dto.setFacilityId(e.getFacilityId());
        dto.setContactMechId(e.getContactMechId());
        dto.setTelecomContactMechId(e.getTelecomContactMechId());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setShippingInstructions(e.getShippingInstructions());
        dto.setMaySplit(e.getMaySplit());
        dto.setGiftMessage(e.getGiftMessage());
        dto.setIsGift(e.getIsGift());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setShipByDate(e.getShipByDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setActive(e.getActive());
        dto.setIsPropertyShipmentMethodTypeIdRemoved(e.getIsPropertyShipmentMethodTypeIdRemoved());
        dto.setIsPropertySupplierPartyIdRemoved(e.getIsPropertySupplierPartyIdRemoved());
        dto.setIsPropertyVendorPartyIdRemoved(e.getIsPropertyVendorPartyIdRemoved());
        dto.setIsPropertyCarrierPartyIdRemoved(e.getIsPropertyCarrierPartyIdRemoved());
        dto.setIsPropertyCarrierRoleTypeIdRemoved(e.getIsPropertyCarrierRoleTypeIdRemoved());
        dto.setIsPropertyFacilityIdRemoved(e.getIsPropertyFacilityIdRemoved());
        dto.setIsPropertyContactMechIdRemoved(e.getIsPropertyContactMechIdRemoved());
        dto.setIsPropertyTelecomContactMechIdRemoved(e.getIsPropertyTelecomContactMechIdRemoved());
        dto.setIsPropertyTrackingNumberRemoved(e.getIsPropertyTrackingNumberRemoved());
        dto.setIsPropertyShippingInstructionsRemoved(e.getIsPropertyShippingInstructionsRemoved());
        dto.setIsPropertyMaySplitRemoved(e.getIsPropertyMaySplitRemoved());
        dto.setIsPropertyGiftMessageRemoved(e.getIsPropertyGiftMessageRemoved());
        dto.setIsPropertyIsGiftRemoved(e.getIsPropertyIsGiftRemoved());
        dto.setIsPropertyShipAfterDateRemoved(e.getIsPropertyShipAfterDateRemoved());
        dto.setIsPropertyShipByDateRemoved(e.getIsPropertyShipByDateRemoved());
        dto.setIsPropertyEstimatedShipDateRemoved(e.getIsPropertyEstimatedShipDateRemoved());
        dto.setIsPropertyEstimatedDeliveryDateRemoved(e.getIsPropertyEstimatedDeliveryDateRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto toOrderShipGroupStateRemovedDto(OrderShipGroupStateEvent.OrderShipGroupStateRemoved e) {
        OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto dto = new OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto();
        dto.setOrderShipGroupEventId(e.getOrderShipGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

