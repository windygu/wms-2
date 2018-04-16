package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderShipGroupEvent extends Event
{
    OrderShipGroupEventId getOrderShipGroupEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderShipGroupStateEvent extends OrderShipGroupEvent {
        Long getVersion();

        void setVersion(Long version);

        String getShipmentMethodTypeId();

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        String getSupplierPartyId();

        void setSupplierPartyId(String supplierPartyId);

        String getVendorPartyId();

        void setVendorPartyId(String vendorPartyId);

        String getCarrierPartyId();

        void setCarrierPartyId(String carrierPartyId);

        String getCarrierRoleTypeId();

        void setCarrierRoleTypeId(String carrierRoleTypeId);

        String getFacilityId();

        void setFacilityId(String facilityId);

        String getContactMechId();

        void setContactMechId(String contactMechId);

        String getTelecomContactMechId();

        void setTelecomContactMechId(String telecomContactMechId);

        String getTrackingNumber();

        void setTrackingNumber(String trackingNumber);

        String getShippingInstructions();

        void setShippingInstructions(String shippingInstructions);

        String getMaySplit();

        void setMaySplit(String maySplit);

        String getGiftMessage();

        void setGiftMessage(String giftMessage);

        String getIsGift();

        void setIsGift(String isGift);

        java.sql.Timestamp getShipAfterDate();

        void setShipAfterDate(java.sql.Timestamp shipAfterDate);

        java.sql.Timestamp getShipByDate();

        void setShipByDate(java.sql.Timestamp shipByDate);

        java.sql.Timestamp getEstimatedShipDate();

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        java.sql.Timestamp getEstimatedDeliveryDate();

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        Long getPickwaveId();

        void setPickwaveId(Long pickwaveId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface OrderShipGroupStateCreated extends OrderShipGroupStateEvent
    {
        Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e);

        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(String orderItemSeqId);

    
    }


    interface OrderShipGroupStateMergePatched extends OrderShipGroupStateEvent
    {
        Boolean getIsPropertyShipmentMethodTypeIdRemoved();

        void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertySupplierPartyIdRemoved();

        void setIsPropertySupplierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyVendorPartyIdRemoved();

        void setIsPropertyVendorPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyCarrierPartyIdRemoved();

        void setIsPropertyCarrierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyCarrierRoleTypeIdRemoved();

        void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyFacilityIdRemoved();

        void setIsPropertyFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyContactMechIdRemoved();

        void setIsPropertyContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTelecomContactMechIdRemoved();

        void setIsPropertyTelecomContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyShippingInstructionsRemoved();

        void setIsPropertyShippingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyMaySplitRemoved();

        void setIsPropertyMaySplitRemoved(Boolean removed);

        Boolean getIsPropertyGiftMessageRemoved();

        void setIsPropertyGiftMessageRemoved(Boolean removed);

        Boolean getIsPropertyIsGiftRemoved();

        void setIsPropertyIsGiftRemoved(Boolean removed);

        Boolean getIsPropertyShipAfterDateRemoved();

        void setIsPropertyShipAfterDateRemoved(Boolean removed);

        Boolean getIsPropertyShipByDateRemoved();

        void setIsPropertyShipByDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedDeliveryDateRemoved();

        void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed);

        Boolean getIsPropertyPickwaveIdRemoved();

        void setIsPropertyPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<OrderItemShipGroupAssociationEvent> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent e);

        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(String orderItemSeqId);

        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched newOrderItemShipGroupAssociationStateMergePatched(String orderItemSeqId);

        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(String orderItemSeqId);


    }

    interface OrderShipGroupStateRemoved extends OrderShipGroupStateEvent
    {
        Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e);
        
        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(String orderItemSeqId);

    }


}

