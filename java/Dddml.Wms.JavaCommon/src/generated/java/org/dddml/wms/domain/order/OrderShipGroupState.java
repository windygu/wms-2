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

    String getShipGroupSeqId();

    String getShipmentMethodTypeId();

    String getSupplierPartyId();

    String getVendorPartyId();

    String getCarrierPartyId();

    String getCarrierRoleTypeId();

    String getFacilityId();

    String getContactMechId();

    String getTelecomContactMechId();

    String getMaySplit();

    String getGiftMessage();

    String getIsGift();

    java.sql.Timestamp getShipAfterDate();

    java.sql.Timestamp getShipByDate();

    String getOrderShipGroupStatusId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getOrderId();

    EntityStateCollection<String, OrderItemShipGroupAssociationState> getOrderItemShipGroupAssociations();

    interface MutableOrderShipGroupState extends OrderShipGroupState {
        void setOrderShipGroupId(OrderShipGroupId orderShipGroupId);

        void setShipGroupSeqId(String shipGroupSeqId);

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        void setSupplierPartyId(String supplierPartyId);

        void setVendorPartyId(String vendorPartyId);

        void setCarrierPartyId(String carrierPartyId);

        void setCarrierRoleTypeId(String carrierRoleTypeId);

        void setFacilityId(String facilityId);

        void setContactMechId(String contactMechId);

        void setTelecomContactMechId(String telecomContactMechId);

        void setMaySplit(String maySplit);

        void setGiftMessage(String giftMessage);

        void setIsGift(String isGift);

        void setShipAfterDate(java.sql.Timestamp shipAfterDate);

        void setShipByDate(java.sql.Timestamp shipByDate);

        void setOrderShipGroupStatusId(String orderShipGroupStatusId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setOrderId(String orderId);


        void mutate(Event e);

        void when(OrderShipGroupEvent.OrderShipGroupStateCreated e);

        void when(OrderShipGroupEvent.OrderShipGroupStateMergePatched e);

        void when(OrderShipGroupEvent.OrderShipGroupStateRemoved e);
    }

    interface SqlOrderShipGroupState extends MutableOrderShipGroupState {
        OrderShipGroupId getOrderShipGroupId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

