package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderShipGroupStateEventDtoConverter {

    public OrderShipGroupStateEventDto toOrderShipGroupStateEventDto(AbstractOrderShipGroupEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderShipGroupEvent.AbstractOrderShipGroupStateCreated) {
            OrderShipGroupEvent.OrderShipGroupStateCreated e = (OrderShipGroupEvent.OrderShipGroupStateCreated) stateEvent;
            return toOrderShipGroupStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupEvent.AbstractOrderShipGroupStateMergePatched) {
            OrderShipGroupEvent.OrderShipGroupStateMergePatched e = (OrderShipGroupEvent.OrderShipGroupStateMergePatched) stateEvent;
            return toOrderShipGroupStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupEvent.AbstractOrderShipGroupStateRemoved) {
            OrderShipGroupEvent.OrderShipGroupStateRemoved e = (OrderShipGroupEvent.OrderShipGroupStateRemoved) stateEvent;
            return toOrderShipGroupStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderShipGroupStateEventDto.OrderShipGroupStateCreatedDto toOrderShipGroupStateCreatedDto(OrderShipGroupEvent.OrderShipGroupStateCreated e) {
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
        dto.setPickwaveId(e.getPickwaveId());
        dto.setActive(e.getActive());
        List<OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto> orderItemShipGroupAssociationEvents = new ArrayList<>();
        for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated ee : e.getOrderItemShipGroupAssociationEvents()) {
            OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto eeDto = getOrderItemShipGroupAssociationStateEventDtoConverter().toOrderItemShipGroupAssociationStateCreatedDto(ee);
            orderItemShipGroupAssociationEvents.add(eeDto);
        }
        dto.setOrderItemShipGroupAssociationEvents(orderItemShipGroupAssociationEvents.toArray(new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto[0]));

        return dto;
    }

    public OrderShipGroupStateEventDto.OrderShipGroupStateMergePatchedDto toOrderShipGroupStateMergePatchedDto(OrderShipGroupEvent.OrderShipGroupStateMergePatched e) {
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
        dto.setPickwaveId(e.getPickwaveId());
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
        dto.setIsPropertyPickwaveIdRemoved(e.getIsPropertyPickwaveIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<OrderItemShipGroupAssociationStateEventDto> orderItemShipGroupAssociationEvents = new ArrayList<>();
        for (OrderItemShipGroupAssociationEvent ee : e.getOrderItemShipGroupAssociationEvents()) {
            OrderItemShipGroupAssociationStateEventDto eeDto = getOrderItemShipGroupAssociationStateEventDtoConverter().toOrderItemShipGroupAssociationStateEventDto((AbstractOrderItemShipGroupAssociationEvent) ee);
            orderItemShipGroupAssociationEvents.add(eeDto);
        }
        dto.setOrderItemShipGroupAssociationEvents(orderItemShipGroupAssociationEvents.toArray(new OrderItemShipGroupAssociationStateEventDto[0]));

        return dto;
    }


    public OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto toOrderShipGroupStateRemovedDto(OrderShipGroupEvent.OrderShipGroupStateRemoved e) {
        OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto dto = new OrderShipGroupStateEventDto.OrderShipGroupStateRemovedDto();
        dto.setOrderShipGroupEventId(e.getOrderShipGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        List<OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto> orderItemShipGroupAssociationEvents = new ArrayList<>();
        for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved ee : e.getOrderItemShipGroupAssociationEvents()) {
            OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto eeDto = getOrderItemShipGroupAssociationStateEventDtoConverter().toOrderItemShipGroupAssociationStateRemovedDto(ee);
            orderItemShipGroupAssociationEvents.add(eeDto);
        }
        dto.setOrderItemShipGroupAssociationEvents(orderItemShipGroupAssociationEvents.toArray(new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto[0]));

        return dto;
    }

    protected OrderItemShipGroupAssociationStateEventDtoConverter getOrderItemShipGroupAssociationStateEventDtoConverter() {
        return new OrderItemShipGroupAssociationStateEventDtoConverter();
    }

}

