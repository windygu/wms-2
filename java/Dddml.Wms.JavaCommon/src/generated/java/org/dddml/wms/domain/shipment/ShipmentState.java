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

    void setShipmentId(String shipmentId);

    String getShipmentTypeId();

    void setShipmentTypeId(String shipmentTypeId);

    String getStatusId();

    void setStatusId(String statusId);

    String getPrimaryOrderId();

    void setPrimaryOrderId(String primaryOrderId);

    String getPrimaryReturnId();

    void setPrimaryReturnId(String primaryReturnId);

    Long getPrimaryShipGroupSeqId();

    void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId);

    String getPicklistBinId();

    void setPicklistBinId(String picklistBinId);

    String getBolNumber();

    void setBolNumber(String bolNumber);

    String getSealNumber();

    void setSealNumber(String sealNumber);

    String getVehicleId();

    void setVehicleId(String vehicleId);

    String getPoNumber();

    void setPoNumber(String poNumber);

    String getCarrier();

    void setCarrier(String carrier);

    java.sql.Timestamp getDateShipped();

    void setDateShipped(java.sql.Timestamp dateShipped);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    ShipmentItemStates getShipmentItems();

    ShipmentReceiptStates getShipmentReceipts();

    ItemIssuanceStates getItemIssuances();


    void mutate(Event e);

    void when(ShipmentEvent.ShipmentStateCreated e);

    void when(ShipmentEvent.ShipmentStateMergePatched e);

    
}

