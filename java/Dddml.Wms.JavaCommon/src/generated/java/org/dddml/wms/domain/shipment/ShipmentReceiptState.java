package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentReceiptEvent.*;

public interface ShipmentReceiptState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getReceiptSeqId();

    String getProductId();

    String getAttributeSetInstanceId();

    String getLocatorId();

    String getShipmentItemSeqId();

    String getShipmentPackageSeqId();

    String getOrderId();

    String getOrderItemSeqId();

    String getReturnId();

    String getReturnItemSeqId();

    String getRejectionReasonId();

    String getDamageReasonId();

    String getReceivedBy();

    java.sql.Timestamp getDatetimeReceived();

    String getItemDescription();

    java.math.BigDecimal getAcceptedQuantity();

    java.math.BigDecimal getRejectedQuantity();

    java.math.BigDecimal getDamagedQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getShipmentId();

    Set<String> getDamageStatusIds();

    void setDamageStatusIds(Set<String> damageStatusIds);

    EntityStateCollection<String, ShipmentReceiptImageState> getShipmentReceiptImages();

    interface MutableShipmentReceiptState extends ShipmentReceiptState {
        void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId);

        void setReceiptSeqId(String receiptSeqId);

        void setProductId(String productId);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setLocatorId(String locatorId);

        void setShipmentItemSeqId(String shipmentItemSeqId);

        void setShipmentPackageSeqId(String shipmentPackageSeqId);

        void setOrderId(String orderId);

        void setOrderItemSeqId(String orderItemSeqId);

        void setReturnId(String returnId);

        void setReturnItemSeqId(String returnItemSeqId);

        void setRejectionReasonId(String rejectionReasonId);

        void setDamageReasonId(String damageReasonId);

        void setReceivedBy(String receivedBy);

        void setDatetimeReceived(java.sql.Timestamp datetimeReceived);

        void setItemDescription(String itemDescription);

        void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity);

        void setRejectedQuantity(java.math.BigDecimal rejectedQuantity);

        void setDamagedQuantity(java.math.BigDecimal damagedQuantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setShipmentId(String shipmentId);

        void setDamageStatusIds(Set<String> damageStatusIds);


        void mutate(Event e);

        void when(ShipmentReceiptEvent.ShipmentReceiptStateCreated e);

        void when(ShipmentReceiptEvent.ShipmentReceiptStateMergePatched e);

        void when(ShipmentReceiptEvent.ShipmentReceiptStateRemoved e);
    }

    interface SqlShipmentReceiptState extends MutableShipmentReceiptState {
        ShipmentReceiptId getShipmentReceiptId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

