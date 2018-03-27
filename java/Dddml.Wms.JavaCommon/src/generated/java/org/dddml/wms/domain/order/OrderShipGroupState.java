package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderShipGroupStateEvent.*;

public interface OrderShipGroupState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderShipGroupId getOrderShipGroupId();

    void setOrderShipGroupId(OrderShipGroupId orderShipGroupId);

    Long getShipGroupSeqId();

    void setShipGroupSeqId(Long shipGroupSeqId);

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

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getOrderId();

    void setOrderId(String orderId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderShipGroupStateEvent.OrderShipGroupStateCreated e);

    void when(OrderShipGroupStateEvent.OrderShipGroupStateMergePatched e);

    void when(OrderShipGroupStateEvent.OrderShipGroupStateRemoved e);
    
}

