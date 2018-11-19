package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentEvent.*;

public interface ShipmentState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getShipmentId();

    String getShipmentTypeId();

    String getStatusId();

    String getPrimaryOrderId();

    String getPrimaryReturnId();

    String getPrimaryShipGroupSeqId();

    Boolean getOnlyOneOrder();

    Boolean getOnlyOneOrderShipGroup();

    String getPicklistBinId();

    String getBolNumber();

    String getSealNumber();

    String getVehicleId();

    String getExternalOrderNumber();

    String getCarrier();

    java.sql.Timestamp getDateShipped();

    Boolean getIsCreatedFromPackingList();

    Boolean getIsScheduleNeeded();

    java.sql.Timestamp getEstimatedReadyDate();

    java.sql.Timestamp getEstimatedShipDate();

    String getEstimatedShipWorkEffId();

    java.sql.Timestamp getEstimatedArrivalDate();

    String getEstimatedArrivalWorkEffId();

    java.sql.Timestamp getLatestCancelDate();

    java.math.BigDecimal getEstimatedShipCost();

    String getCurrencyUomId();

    String getHandlingInstructions();

    String getOriginFacilityId();

    String getDestinationFacilityId();

    String getOriginContactMechId();

    String getOriginTelecomNumberId();

    String getDestinationContactMechId();

    String getDestinationTelecomNumberId();

    String getPartyIdTo();

    String getPartyIdFrom();

    java.math.BigDecimal getAdditionalShippingCharge();

    String getAddtlShippingChargeDesc();

    Boolean get_F_B_1_();

    Boolean get_F_B_2_();

    Boolean get_F_B_3_();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    EntityStateCollection<String, ShipmentImageState> getShipmentImages();

    EntityStateCollection<String, ShipmentItemState> getShipmentItems();

    EntityStateCollection<String, ShipmentReceiptState> getShipmentReceipts();

    EntityStateCollection<String, ItemIssuanceState> getItemIssuances();

    interface MutableShipmentState extends ShipmentState {
        void setShipmentId(String shipmentId);

        void setShipmentTypeId(String shipmentTypeId);

        void setStatusId(String statusId);

        void setPrimaryOrderId(String primaryOrderId);

        void setPrimaryReturnId(String primaryReturnId);

        void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId);

        void setOnlyOneOrder(Boolean onlyOneOrder);

        void setOnlyOneOrderShipGroup(Boolean onlyOneOrderShipGroup);

        void setPicklistBinId(String picklistBinId);

        void setBolNumber(String bolNumber);

        void setSealNumber(String sealNumber);

        void setVehicleId(String vehicleId);

        void setExternalOrderNumber(String externalOrderNumber);

        void setCarrier(String carrier);

        void setDateShipped(java.sql.Timestamp dateShipped);

        void setIsCreatedFromPackingList(Boolean isCreatedFromPackingList);

        void setIsScheduleNeeded(Boolean isScheduleNeeded);

        void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate);

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        void setEstimatedShipWorkEffId(String estimatedShipWorkEffId);

        void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate);

        void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId);

        void setLatestCancelDate(java.sql.Timestamp latestCancelDate);

        void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost);

        void setCurrencyUomId(String currencyUomId);

        void setHandlingInstructions(String handlingInstructions);

        void setOriginFacilityId(String originFacilityId);

        void setDestinationFacilityId(String destinationFacilityId);

        void setOriginContactMechId(String originContactMechId);

        void setOriginTelecomNumberId(String originTelecomNumberId);

        void setDestinationContactMechId(String destinationContactMechId);

        void setDestinationTelecomNumberId(String destinationTelecomNumberId);

        void setPartyIdTo(String partyIdTo);

        void setPartyIdFrom(String partyIdFrom);

        void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge);

        void setAddtlShippingChargeDesc(String addtlShippingChargeDesc);

        void set_F_B_1_(Boolean _F_B_1_);

        void set_F_B_2_(Boolean _F_B_2_);

        void set_F_B_3_(Boolean _F_B_3_);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(ShipmentEvent.ShipmentStateCreated e);

        void when(ShipmentEvent.ShipmentStateMergePatched e);

    }

    interface SqlShipmentState extends MutableShipmentState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

