package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ItemIssuanceStateEvent.*;

public interface ItemIssuanceState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentItemIssuanceId getShipmentItemIssuanceId();

    void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId);

    String getItemIssuanceSeqId();

    void setItemIssuanceSeqId(String itemIssuanceSeqId);

    String getOrderId();

    void setOrderId(String orderId);

    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

    Long getShipGroupSeqId();

    void setShipGroupSeqId(Long shipGroupSeqId);

    String getProductId();

    void setProductId(String productId);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getFixedAssetId();

    void setFixedAssetId(String fixedAssetId);

    String getMaintHistSeqId();

    void setMaintHistSeqId(String maintHistSeqId);

    java.sql.Timestamp getIssuedDateTime();

    void setIssuedDateTime(java.sql.Timestamp issuedDateTime);

    String getIssuedByUserLoginId();

    void setIssuedByUserLoginId(String issuedByUserLoginId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.math.BigDecimal getCancelQuantity();

    void setCancelQuantity(java.math.BigDecimal cancelQuantity);

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

    String getShipmentId();

    void setShipmentId(String shipmentId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ItemIssuanceStateEvent.ItemIssuanceStateCreated e);

    void when(ItemIssuanceStateEvent.ItemIssuanceStateMergePatched e);

    void when(ItemIssuanceStateEvent.ItemIssuanceStateRemoved e);
    
}

