package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderShipGroupStateEvent extends Event
{
    OrderShipGroupEventId getOrderShipGroupEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderShipGroupStateCreated extends OrderShipGroupStateEvent
    {
        Iterable<OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated e);

        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(String orderItemSeqId);

    
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

        Iterable<OrderItemShipGroupAssociationStateEvent> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationStateEvent e);

        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(String orderItemSeqId);

        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched newOrderItemShipGroupAssociationStateMergePatched(String orderItemSeqId);

        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(String orderItemSeqId);


    }

    interface OrderShipGroupStateRemoved extends OrderShipGroupStateEvent
    {
        Iterable<OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved> getOrderItemShipGroupAssociationEvents();
        
        void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved e);
        
        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(String orderItemSeqId);

    }


}

