package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentStateEvent extends Event
{
    ShipmentStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getShipmentTypeId();

    void setShipmentTypeId(String shipmentTypeId);

    String getStatusId();

    void setStatusId(String statusId);

    String getPrimaryOrderId();

    void setPrimaryOrderId(String primaryOrderId);

    String getPrimaryReturnId();

    void setPrimaryReturnId(String primaryReturnId);

    String getPicklistBinId();

    void setPicklistBinId(String picklistBinId);

    java.sql.Timestamp getEstimatedReadyDate();

    void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate);

    java.sql.Timestamp getEstimatedShipDate();

    void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

    String getEstimatedShipWorkEffId();

    void setEstimatedShipWorkEffId(String estimatedShipWorkEffId);

    java.sql.Timestamp getEstimatedArrivalDate();

    void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate);

    String getEstimatedArrivalWorkEffId();

    void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId);

    java.sql.Timestamp getLatestCancelDate();

    void setLatestCancelDate(java.sql.Timestamp latestCancelDate);

    java.math.BigDecimal getEstimatedShipCost();

    void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost);

    String getCurrencyUomId();

    void setCurrencyUomId(String currencyUomId);

    String getHandlingInstructions();

    void setHandlingInstructions(String handlingInstructions);

    String getOriginFacilityId();

    void setOriginFacilityId(String originFacilityId);

    String getDestinationFacilityId();

    void setDestinationFacilityId(String destinationFacilityId);

    String getOriginContactMechId();

    void setOriginContactMechId(String originContactMechId);

    String getOriginTelecomNumberId();

    void setOriginTelecomNumberId(String originTelecomNumberId);

    String getDestinationContactMechId();

    void setDestinationContactMechId(String destinationContactMechId);

    String getDestinationTelecomNumberId();

    void setDestinationTelecomNumberId(String destinationTelecomNumberId);

    String getPartyIdTo();

    void setPartyIdTo(String partyIdTo);

    String getPartyIdFrom();

    void setPartyIdFrom(String partyIdFrom);

    java.math.BigDecimal getAdditionalShippingCharge();

    void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge);

    String getAddtlShippingChargeDesc();

    void setAddtlShippingChargeDesc(String addtlShippingChargeDesc);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentStateCreated extends ShipmentStateEvent
    {
    
    }


    interface ShipmentStateMergePatched extends ShipmentStateEvent
    {
        Boolean getIsPropertyShipmentTypeIdRemoved();

        void setIsPropertyShipmentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryOrderIdRemoved();

        void setIsPropertyPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryReturnIdRemoved();

        void setIsPropertyPrimaryReturnIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinIdRemoved();

        void setIsPropertyPicklistBinIdRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedReadyDateRemoved();

        void setIsPropertyEstimatedReadyDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipWorkEffIdRemoved();

        void setIsPropertyEstimatedShipWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedArrivalDateRemoved();

        void setIsPropertyEstimatedArrivalDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedArrivalWorkEffIdRemoved();

        void setIsPropertyEstimatedArrivalWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyLatestCancelDateRemoved();

        void setIsPropertyLatestCancelDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipCostRemoved();

        void setIsPropertyEstimatedShipCostRemoved(Boolean removed);

        Boolean getIsPropertyCurrencyUomIdRemoved();

        void setIsPropertyCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyHandlingInstructionsRemoved();

        void setIsPropertyHandlingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyOriginFacilityIdRemoved();

        void setIsPropertyOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationFacilityIdRemoved();

        void setIsPropertyDestinationFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginContactMechIdRemoved();

        void setIsPropertyOriginContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginTelecomNumberIdRemoved();

        void setIsPropertyOriginTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationContactMechIdRemoved();

        void setIsPropertyDestinationContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationTelecomNumberIdRemoved();

        void setIsPropertyDestinationTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyPartyIdToRemoved();

        void setIsPropertyPartyIdToRemoved(Boolean removed);

        Boolean getIsPropertyPartyIdFromRemoved();

        void setIsPropertyPartyIdFromRemoved(Boolean removed);

        Boolean getIsPropertyAdditionalShippingChargeRemoved();

        void setIsPropertyAdditionalShippingChargeRemoved(Boolean removed);

        Boolean getIsPropertyAddtlShippingChargeDescRemoved();

        void setIsPropertyAddtlShippingChargeDescRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

