package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.Set;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentreceiptmvo.ShipmentReceiptMvoStateEvent.*;

public interface ShipmentReceiptMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentReceiptId getShipmentReceiptId();

    void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId);

    String getProductId();

    void setProductId(String productId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getRejectionReasonId();

    void setRejectionReasonId(String rejectionReasonId);

    String getDamageStatusId();

    void setDamageStatusId(String damageStatusId);

    String getDamageReasonId();

    void setDamageReasonId(String damageReasonId);

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

    String getShipmentShipmentTypeId();

    void setShipmentShipmentTypeId(String shipmentShipmentTypeId);

    String getShipmentStatusId();

    void setShipmentStatusId(String shipmentStatusId);

    String getShipmentPrimaryOrderId();

    void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId);

    String getShipmentPrimaryReturnId();

    void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId);

    String getShipmentPicklistBinId();

    void setShipmentPicklistBinId(String shipmentPicklistBinId);

    java.sql.Timestamp getShipmentEstimatedReadyDate();

    void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate);

    java.sql.Timestamp getShipmentEstimatedShipDate();

    void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate);

    String getShipmentEstimatedShipWorkEffId();

    void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId);

    java.sql.Timestamp getShipmentEstimatedArrivalDate();

    void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate);

    String getShipmentEstimatedArrivalWorkEffId();

    void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId);

    java.sql.Timestamp getShipmentLatestCancelDate();

    void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate);

    java.math.BigDecimal getShipmentEstimatedShipCost();

    void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost);

    String getShipmentCurrencyUomId();

    void setShipmentCurrencyUomId(String shipmentCurrencyUomId);

    String getShipmentHandlingInstructions();

    void setShipmentHandlingInstructions(String shipmentHandlingInstructions);

    String getShipmentOriginFacilityId();

    void setShipmentOriginFacilityId(String shipmentOriginFacilityId);

    String getShipmentDestinationFacilityId();

    void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId);

    String getShipmentOriginContactMechId();

    void setShipmentOriginContactMechId(String shipmentOriginContactMechId);

    String getShipmentOriginTelecomNumberId();

    void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId);

    String getShipmentDestinationContactMechId();

    void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId);

    String getShipmentDestinationTelecomNumberId();

    void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId);

    String getShipmentPartyIdTo();

    void setShipmentPartyIdTo(String shipmentPartyIdTo);

    String getShipmentPartyIdFrom();

    void setShipmentPartyIdFrom(String shipmentPartyIdFrom);

    java.math.BigDecimal getShipmentAdditionalShippingCharge();

    void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge);

    String getShipmentAddtlShippingChargeDesc();

    void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc);

    Long getShipmentVersion();

    void setShipmentVersion(Long shipmentVersion);

    String getShipmentCreatedBy();

    void setShipmentCreatedBy(String shipmentCreatedBy);

    Date getShipmentCreatedAt();

    void setShipmentCreatedAt(Date shipmentCreatedAt);

    String getShipmentUpdatedBy();

    void setShipmentUpdatedBy(String shipmentUpdatedBy);

    Date getShipmentUpdatedAt();

    void setShipmentUpdatedAt(Date shipmentUpdatedAt);

    Boolean getShipmentActive();

    void setShipmentActive(Boolean shipmentActive);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated e);

    void when(ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched e);

    
}

