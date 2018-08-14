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

    ShipmentReceiptId getShipmentReceiptId();

    void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId);

    String getReceiptSeqId();

    void setReceiptSeqId(String receiptSeqId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getShipmentPackageSeqId();

    void setShipmentPackageSeqId(String shipmentPackageSeqId);

    String getOrderId();

    void setOrderId(String orderId);

    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

    String getReturnId();

    void setReturnId(String returnId);

    String getReturnItemSeqId();

    void setReturnItemSeqId(String returnItemSeqId);

    String getRejectionReasonId();

    void setRejectionReasonId(String rejectionReasonId);

    String getDamageReasonId();

    void setDamageReasonId(String damageReasonId);

    String getReceivedBy();

    void setReceivedBy(String receivedBy);

    java.sql.Timestamp getDatetimeReceived();

    void setDatetimeReceived(java.sql.Timestamp datetimeReceived);

    String getItemDescription();

    void setItemDescription(String itemDescription);

    java.math.BigDecimal getAcceptedQuantity();

    void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity);

    java.math.BigDecimal getRejectedQuantity();

    void setRejectedQuantity(java.math.BigDecimal rejectedQuantity);

    java.math.BigDecimal getDamagedQuantity();

    void setDamagedQuantity(java.math.BigDecimal damagedQuantity);

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

    String getShipmentId();

    void setShipmentId(String shipmentId);

    Set<String> getDamageStatusIds();

    void setDamageStatusIds(Set<String> damageStatusIds);


    boolean isStateUnsaved();

    boolean getForReapplying();

    ShipmentReceiptImageStates getShipmentReceiptImages();


    void mutate(Event e);

    void when(ShipmentReceiptEvent.ShipmentReceiptStateCreated e);

    void when(ShipmentReceiptEvent.ShipmentReceiptStateMergePatched e);

    
}

