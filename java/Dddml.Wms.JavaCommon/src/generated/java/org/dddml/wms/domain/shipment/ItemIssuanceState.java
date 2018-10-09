package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ItemIssuanceEvent.*;

public interface ItemIssuanceState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getItemIssuanceSeqId();

    String getOrderId();

    String getOrderItemSeqId();

    String getShipGroupSeqId();

    String getProductId();

    String getLocatorId();

    String getAttributeSetInstanceId();

    String getShipmentItemSeqId();

    String getFixedAssetId();

    String getMaintHistSeqId();

    java.sql.Timestamp getIssuedDateTime();

    String getIssuedByUserLoginId();

    java.math.BigDecimal getQuantity();

    java.math.BigDecimal getCancelQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getShipmentId();

    interface MutableItemIssuanceState extends ItemIssuanceState {
        void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId);

        void setItemIssuanceSeqId(String itemIssuanceSeqId);

        void setOrderId(String orderId);

        void setOrderItemSeqId(String orderItemSeqId);

        void setShipGroupSeqId(String shipGroupSeqId);

        void setProductId(String productId);

        void setLocatorId(String locatorId);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setShipmentItemSeqId(String shipmentItemSeqId);

        void setFixedAssetId(String fixedAssetId);

        void setMaintHistSeqId(String maintHistSeqId);

        void setIssuedDateTime(java.sql.Timestamp issuedDateTime);

        void setIssuedByUserLoginId(String issuedByUserLoginId);

        void setQuantity(java.math.BigDecimal quantity);

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setShipmentId(String shipmentId);


        void mutate(Event e);

        void when(ItemIssuanceEvent.ItemIssuanceStateCreated e);

        void when(ItemIssuanceEvent.ItemIssuanceStateMergePatched e);

        void when(ItemIssuanceEvent.ItemIssuanceStateRemoved e);
    }

    interface SqlItemIssuanceState extends MutableItemIssuanceState {
        ShipmentItemIssuanceId getShipmentItemIssuanceId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

