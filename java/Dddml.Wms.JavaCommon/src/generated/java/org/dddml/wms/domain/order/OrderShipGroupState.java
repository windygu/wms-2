package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderShipGroupEvent.*;

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

    String getContactPartyId();

    void setContactPartyId(String contactPartyId);

    String getVehiclePlateNumber();

    void setVehiclePlateNumber(String vehiclePlateNumber);

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

    Integer getNumberOfPackages();

    void setNumberOfPackages(Integer numberOfPackages);

    Integer getNumberOfContainers();

    void setNumberOfContainers(Integer numberOfContainers);

    Integer getNumberOfPakagesPerContainer();

    void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer);

    String getStatusId();

    void setStatusId(String statusId);

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

    OrderItemShipGroupAssociationStates getOrderItemShipGroupAssociations();


    void mutate(Event e);

    void when(OrderShipGroupEvent.OrderShipGroupStateCreated e);

    void when(OrderShipGroupEvent.OrderShipGroupStateMergePatched e);

    void when(OrderShipGroupEvent.OrderShipGroupStateRemoved e);
    
}

