package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentItemMvoEvent extends Event
{
    ShipmentItemMvoEventId getShipmentItemMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getShipmentContentDescription();

    void setShipmentContentDescription(String shipmentContentDescription);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

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

    Long getShipmentPrimaryShipGroupSeqId();

    void setShipmentPrimaryShipGroupSeqId(Long shipmentPrimaryShipGroupSeqId);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentItemMvoStateCreated extends ShipmentItemMvoEvent
    {
    
    }


    interface ShipmentItemMvoStateMergePatched extends ShipmentItemMvoEvent
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyShipmentContentDescriptionRemoved();

        void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentShipmentTypeIdRemoved();

        void setIsPropertyShipmentShipmentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentStatusIdRemoved();

        void setIsPropertyShipmentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryOrderIdRemoved();

        void setIsPropertyShipmentPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryReturnIdRemoved();

        void setIsPropertyShipmentPrimaryReturnIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPicklistBinIdRemoved();

        void setIsPropertyShipmentPicklistBinIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedReadyDateRemoved();

        void setIsPropertyShipmentEstimatedReadyDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipDateRemoved();

        void setIsPropertyShipmentEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipWorkEffIdRemoved();

        void setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedArrivalDateRemoved();

        void setIsPropertyShipmentEstimatedArrivalDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved();

        void setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentLatestCancelDateRemoved();

        void setIsPropertyShipmentLatestCancelDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipCostRemoved();

        void setIsPropertyShipmentEstimatedShipCostRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCurrencyUomIdRemoved();

        void setIsPropertyShipmentCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentHandlingInstructionsRemoved();

        void setIsPropertyShipmentHandlingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginFacilityIdRemoved();

        void setIsPropertyShipmentOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationFacilityIdRemoved();

        void setIsPropertyShipmentDestinationFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginContactMechIdRemoved();

        void setIsPropertyShipmentOriginContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginTelecomNumberIdRemoved();

        void setIsPropertyShipmentOriginTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationContactMechIdRemoved();

        void setIsPropertyShipmentDestinationContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationTelecomNumberIdRemoved();

        void setIsPropertyShipmentDestinationTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPartyIdToRemoved();

        void setIsPropertyShipmentPartyIdToRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPartyIdFromRemoved();

        void setIsPropertyShipmentPartyIdFromRemoved(Boolean removed);

        Boolean getIsPropertyShipmentAdditionalShippingChargeRemoved();

        void setIsPropertyShipmentAdditionalShippingChargeRemoved(Boolean removed);

        Boolean getIsPropertyShipmentAddtlShippingChargeDescRemoved();

        void setIsPropertyShipmentAddtlShippingChargeDescRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCreatedByRemoved();

        void setIsPropertyShipmentCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCreatedAtRemoved();

        void setIsPropertyShipmentCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentUpdatedByRemoved();

        void setIsPropertyShipmentUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentUpdatedAtRemoved();

        void setIsPropertyShipmentUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentActiveRemoved();

        void setIsPropertyShipmentActiveRemoved(Boolean removed);


    }


}

