package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentEvent.*;

public abstract class AbstractShipmentState implements ShipmentState, Saveable
{

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private String shipmentTypeId;

    public String getShipmentTypeId()
    {
        return this.shipmentTypeId;
    }

    public void setShipmentTypeId(String shipmentTypeId)
    {
        this.shipmentTypeId = shipmentTypeId;
    }

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private String primaryOrderId;

    public String getPrimaryOrderId()
    {
        return this.primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId)
    {
        this.primaryOrderId = primaryOrderId;
    }

    private String primaryReturnId;

    public String getPrimaryReturnId()
    {
        return this.primaryReturnId;
    }

    public void setPrimaryReturnId(String primaryReturnId)
    {
        this.primaryReturnId = primaryReturnId;
    }

    private Long primaryShipGroupSeqId;

    public Long getPrimaryShipGroupSeqId()
    {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId)
    {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
    }

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
    }

    private String bolNumber;

    public String getBolNumber()
    {
        return this.bolNumber;
    }

    public void setBolNumber(String bolNumber)
    {
        this.bolNumber = bolNumber;
    }

    private String sealNumber;

    public String getSealNumber()
    {
        return this.sealNumber;
    }

    public void setSealNumber(String sealNumber)
    {
        this.sealNumber = sealNumber;
    }

    private String vehicleId;

    public String getVehicleId()
    {
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId)
    {
        this.vehicleId = vehicleId;
    }

    private String poNumber;

    public String getPoNumber()
    {
        return this.poNumber;
    }

    public void setPoNumber(String poNumber)
    {
        this.poNumber = poNumber;
    }

    private String carrier;

    public String getCarrier()
    {
        return this.carrier;
    }

    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }

    private java.sql.Timestamp dateShipped;

    public java.sql.Timestamp getDateShipped()
    {
        return this.dateShipped;
    }

    public void setDateShipped(java.sql.Timestamp dateShipped)
    {
        this.dateShipped = dateShipped;
    }

    private java.sql.Timestamp estimatedReadyDate;

    public java.sql.Timestamp getEstimatedReadyDate()
    {
        return this.estimatedReadyDate;
    }

    public void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate)
    {
        this.estimatedReadyDate = estimatedReadyDate;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private String estimatedShipWorkEffId;

    public String getEstimatedShipWorkEffId()
    {
        return this.estimatedShipWorkEffId;
    }

    public void setEstimatedShipWorkEffId(String estimatedShipWorkEffId)
    {
        this.estimatedShipWorkEffId = estimatedShipWorkEffId;
    }

    private java.sql.Timestamp estimatedArrivalDate;

    public java.sql.Timestamp getEstimatedArrivalDate()
    {
        return this.estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate)
    {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    private String estimatedArrivalWorkEffId;

    public String getEstimatedArrivalWorkEffId()
    {
        return this.estimatedArrivalWorkEffId;
    }

    public void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId)
    {
        this.estimatedArrivalWorkEffId = estimatedArrivalWorkEffId;
    }

    private java.sql.Timestamp latestCancelDate;

    public java.sql.Timestamp getLatestCancelDate()
    {
        return this.latestCancelDate;
    }

    public void setLatestCancelDate(java.sql.Timestamp latestCancelDate)
    {
        this.latestCancelDate = latestCancelDate;
    }

    private java.math.BigDecimal estimatedShipCost;

    public java.math.BigDecimal getEstimatedShipCost()
    {
        return this.estimatedShipCost;
    }

    public void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost)
    {
        this.estimatedShipCost = estimatedShipCost;
    }

    private String currencyUomId;

    public String getCurrencyUomId()
    {
        return this.currencyUomId;
    }

    public void setCurrencyUomId(String currencyUomId)
    {
        this.currencyUomId = currencyUomId;
    }

    private String handlingInstructions;

    public String getHandlingInstructions()
    {
        return this.handlingInstructions;
    }

    public void setHandlingInstructions(String handlingInstructions)
    {
        this.handlingInstructions = handlingInstructions;
    }

    private String originFacilityId;

    public String getOriginFacilityId()
    {
        return this.originFacilityId;
    }

    public void setOriginFacilityId(String originFacilityId)
    {
        this.originFacilityId = originFacilityId;
    }

    private String destinationFacilityId;

    public String getDestinationFacilityId()
    {
        return this.destinationFacilityId;
    }

    public void setDestinationFacilityId(String destinationFacilityId)
    {
        this.destinationFacilityId = destinationFacilityId;
    }

    private String originContactMechId;

    public String getOriginContactMechId()
    {
        return this.originContactMechId;
    }

    public void setOriginContactMechId(String originContactMechId)
    {
        this.originContactMechId = originContactMechId;
    }

    private String originTelecomNumberId;

    public String getOriginTelecomNumberId()
    {
        return this.originTelecomNumberId;
    }

    public void setOriginTelecomNumberId(String originTelecomNumberId)
    {
        this.originTelecomNumberId = originTelecomNumberId;
    }

    private String destinationContactMechId;

    public String getDestinationContactMechId()
    {
        return this.destinationContactMechId;
    }

    public void setDestinationContactMechId(String destinationContactMechId)
    {
        this.destinationContactMechId = destinationContactMechId;
    }

    private String destinationTelecomNumberId;

    public String getDestinationTelecomNumberId()
    {
        return this.destinationTelecomNumberId;
    }

    public void setDestinationTelecomNumberId(String destinationTelecomNumberId)
    {
        this.destinationTelecomNumberId = destinationTelecomNumberId;
    }

    private String partyIdTo;

    public String getPartyIdTo()
    {
        return this.partyIdTo;
    }

    public void setPartyIdTo(String partyIdTo)
    {
        this.partyIdTo = partyIdTo;
    }

    private String partyIdFrom;

    public String getPartyIdFrom()
    {
        return this.partyIdFrom;
    }

    public void setPartyIdFrom(String partyIdFrom)
    {
        this.partyIdFrom = partyIdFrom;
    }

    private java.math.BigDecimal additionalShippingCharge;

    public java.math.BigDecimal getAdditionalShippingCharge()
    {
        return this.additionalShippingCharge;
    }

    public void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge)
    {
        this.additionalShippingCharge = additionalShippingCharge;
    }

    private String addtlShippingChargeDesc;

    public String getAddtlShippingChargeDesc()
    {
        return this.addtlShippingChargeDesc;
    }

    public void setAddtlShippingChargeDesc(String addtlShippingChargeDesc)
    {
        this.addtlShippingChargeDesc = addtlShippingChargeDesc;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private ShipmentItemStates shipmentItems;

    public ShipmentItemStates getShipmentItems()
    {
        return this.shipmentItems;
    }

    public void setShipmentItems(ShipmentItemStates shipmentItems)
    {
        this.shipmentItems = shipmentItems;
    }

    private ShipmentReceiptStates shipmentReceipts;

    public ShipmentReceiptStates getShipmentReceipts()
    {
        return this.shipmentReceipts;
    }

    public void setShipmentReceipts(ShipmentReceiptStates shipmentReceipts)
    {
        this.shipmentReceipts = shipmentReceipts;
    }

    private ItemIssuanceStates itemIssuances;

    public ItemIssuanceStates getItemIssuances()
    {
        return this.itemIssuances;
    }

    public void setItemIssuances(ItemIssuanceStates itemIssuances)
    {
        this.itemIssuances = itemIssuances;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractShipmentState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setShipmentId(((ShipmentEvent) events.get(0)).getShipmentEventId().getShipmentId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractShipmentState() {
        this(false);
    }

    public AbstractShipmentState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        shipmentItems = new SimpleShipmentItemStates(this);
        shipmentReceipts = new SimpleShipmentReceiptStates(this);
        itemIssuances = new SimpleItemIssuanceStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentStateCreated) {
            when((ShipmentStateCreated) e);
        } else if (e instanceof ShipmentStateMergePatched) {
            when((ShipmentStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setShipmentTypeId(e.getShipmentTypeId());
        this.setStatusId(e.getStatusId());
        this.setPrimaryOrderId(e.getPrimaryOrderId());
        this.setPrimaryReturnId(e.getPrimaryReturnId());
        this.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        this.setPicklistBinId(e.getPicklistBinId());
        this.setBolNumber(e.getBolNumber());
        this.setSealNumber(e.getSealNumber());
        this.setVehicleId(e.getVehicleId());
        this.setPoNumber(e.getPoNumber());
        this.setCarrier(e.getCarrier());
        this.setDateShipped(e.getDateShipped());
        this.setEstimatedReadyDate(e.getEstimatedReadyDate());
        this.setEstimatedShipDate(e.getEstimatedShipDate());
        this.setEstimatedShipWorkEffId(e.getEstimatedShipWorkEffId());
        this.setEstimatedArrivalDate(e.getEstimatedArrivalDate());
        this.setEstimatedArrivalWorkEffId(e.getEstimatedArrivalWorkEffId());
        this.setLatestCancelDate(e.getLatestCancelDate());
        this.setEstimatedShipCost(e.getEstimatedShipCost());
        this.setCurrencyUomId(e.getCurrencyUomId());
        this.setHandlingInstructions(e.getHandlingInstructions());
        this.setOriginFacilityId(e.getOriginFacilityId());
        this.setDestinationFacilityId(e.getDestinationFacilityId());
        this.setOriginContactMechId(e.getOriginContactMechId());
        this.setOriginTelecomNumberId(e.getOriginTelecomNumberId());
        this.setDestinationContactMechId(e.getDestinationContactMechId());
        this.setDestinationTelecomNumberId(e.getDestinationTelecomNumberId());
        this.setPartyIdTo(e.getPartyIdTo());
        this.setPartyIdFrom(e.getPartyIdFrom());
        this.setAdditionalShippingCharge(e.getAdditionalShippingCharge());
        this.setAddtlShippingChargeDesc(e.getAddtlShippingChargeDesc());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (ShipmentItemEvent.ShipmentItemStateCreated innerEvent : e.getShipmentItemEvents()) {
            ShipmentItemState innerState = this.getShipmentItems().get(innerEvent.getShipmentItemEventId().getShipmentItemSeqId());
            innerState.mutate(innerEvent);
        }
        for (ShipmentReceiptEvent.ShipmentReceiptStateCreated innerEvent : e.getShipmentReceiptEvents()) {
            ShipmentReceiptState innerState = this.getShipmentReceipts().get(innerEvent.getShipmentReceiptEventId().getReceiptSeqId());
            innerState.mutate(innerEvent);
        }
        for (ItemIssuanceEvent.ItemIssuanceStateCreated innerEvent : e.getItemIssuanceEvents()) {
            ItemIssuanceState innerState = this.getItemIssuances().get(innerEvent.getItemIssuanceEventId().getItemIssuanceSeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(ShipmentStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getShipmentTypeId() == null)
        {
            if (e.getIsPropertyShipmentTypeIdRemoved() != null && e.getIsPropertyShipmentTypeIdRemoved())
            {
                this.setShipmentTypeId(null);
            }
        }
        else
        {
            this.setShipmentTypeId(e.getShipmentTypeId());
        }
        if (e.getStatusId() == null)
        {
            if (e.getIsPropertyStatusIdRemoved() != null && e.getIsPropertyStatusIdRemoved())
            {
                this.setStatusId(null);
            }
        }
        else
        {
            this.setStatusId(e.getStatusId());
        }
        if (e.getPrimaryOrderId() == null)
        {
            if (e.getIsPropertyPrimaryOrderIdRemoved() != null && e.getIsPropertyPrimaryOrderIdRemoved())
            {
                this.setPrimaryOrderId(null);
            }
        }
        else
        {
            this.setPrimaryOrderId(e.getPrimaryOrderId());
        }
        if (e.getPrimaryReturnId() == null)
        {
            if (e.getIsPropertyPrimaryReturnIdRemoved() != null && e.getIsPropertyPrimaryReturnIdRemoved())
            {
                this.setPrimaryReturnId(null);
            }
        }
        else
        {
            this.setPrimaryReturnId(e.getPrimaryReturnId());
        }
        if (e.getPrimaryShipGroupSeqId() == null)
        {
            if (e.getIsPropertyPrimaryShipGroupSeqIdRemoved() != null && e.getIsPropertyPrimaryShipGroupSeqIdRemoved())
            {
                this.setPrimaryShipGroupSeqId(null);
            }
        }
        else
        {
            this.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        }
        if (e.getPicklistBinId() == null)
        {
            if (e.getIsPropertyPicklistBinIdRemoved() != null && e.getIsPropertyPicklistBinIdRemoved())
            {
                this.setPicklistBinId(null);
            }
        }
        else
        {
            this.setPicklistBinId(e.getPicklistBinId());
        }
        if (e.getBolNumber() == null)
        {
            if (e.getIsPropertyBolNumberRemoved() != null && e.getIsPropertyBolNumberRemoved())
            {
                this.setBolNumber(null);
            }
        }
        else
        {
            this.setBolNumber(e.getBolNumber());
        }
        if (e.getSealNumber() == null)
        {
            if (e.getIsPropertySealNumberRemoved() != null && e.getIsPropertySealNumberRemoved())
            {
                this.setSealNumber(null);
            }
        }
        else
        {
            this.setSealNumber(e.getSealNumber());
        }
        if (e.getVehicleId() == null)
        {
            if (e.getIsPropertyVehicleIdRemoved() != null && e.getIsPropertyVehicleIdRemoved())
            {
                this.setVehicleId(null);
            }
        }
        else
        {
            this.setVehicleId(e.getVehicleId());
        }
        if (e.getPoNumber() == null)
        {
            if (e.getIsPropertyPoNumberRemoved() != null && e.getIsPropertyPoNumberRemoved())
            {
                this.setPoNumber(null);
            }
        }
        else
        {
            this.setPoNumber(e.getPoNumber());
        }
        if (e.getCarrier() == null)
        {
            if (e.getIsPropertyCarrierRemoved() != null && e.getIsPropertyCarrierRemoved())
            {
                this.setCarrier(null);
            }
        }
        else
        {
            this.setCarrier(e.getCarrier());
        }
        if (e.getDateShipped() == null)
        {
            if (e.getIsPropertyDateShippedRemoved() != null && e.getIsPropertyDateShippedRemoved())
            {
                this.setDateShipped(null);
            }
        }
        else
        {
            this.setDateShipped(e.getDateShipped());
        }
        if (e.getEstimatedReadyDate() == null)
        {
            if (e.getIsPropertyEstimatedReadyDateRemoved() != null && e.getIsPropertyEstimatedReadyDateRemoved())
            {
                this.setEstimatedReadyDate(null);
            }
        }
        else
        {
            this.setEstimatedReadyDate(e.getEstimatedReadyDate());
        }
        if (e.getEstimatedShipDate() == null)
        {
            if (e.getIsPropertyEstimatedShipDateRemoved() != null && e.getIsPropertyEstimatedShipDateRemoved())
            {
                this.setEstimatedShipDate(null);
            }
        }
        else
        {
            this.setEstimatedShipDate(e.getEstimatedShipDate());
        }
        if (e.getEstimatedShipWorkEffId() == null)
        {
            if (e.getIsPropertyEstimatedShipWorkEffIdRemoved() != null && e.getIsPropertyEstimatedShipWorkEffIdRemoved())
            {
                this.setEstimatedShipWorkEffId(null);
            }
        }
        else
        {
            this.setEstimatedShipWorkEffId(e.getEstimatedShipWorkEffId());
        }
        if (e.getEstimatedArrivalDate() == null)
        {
            if (e.getIsPropertyEstimatedArrivalDateRemoved() != null && e.getIsPropertyEstimatedArrivalDateRemoved())
            {
                this.setEstimatedArrivalDate(null);
            }
        }
        else
        {
            this.setEstimatedArrivalDate(e.getEstimatedArrivalDate());
        }
        if (e.getEstimatedArrivalWorkEffId() == null)
        {
            if (e.getIsPropertyEstimatedArrivalWorkEffIdRemoved() != null && e.getIsPropertyEstimatedArrivalWorkEffIdRemoved())
            {
                this.setEstimatedArrivalWorkEffId(null);
            }
        }
        else
        {
            this.setEstimatedArrivalWorkEffId(e.getEstimatedArrivalWorkEffId());
        }
        if (e.getLatestCancelDate() == null)
        {
            if (e.getIsPropertyLatestCancelDateRemoved() != null && e.getIsPropertyLatestCancelDateRemoved())
            {
                this.setLatestCancelDate(null);
            }
        }
        else
        {
            this.setLatestCancelDate(e.getLatestCancelDate());
        }
        if (e.getEstimatedShipCost() == null)
        {
            if (e.getIsPropertyEstimatedShipCostRemoved() != null && e.getIsPropertyEstimatedShipCostRemoved())
            {
                this.setEstimatedShipCost(null);
            }
        }
        else
        {
            this.setEstimatedShipCost(e.getEstimatedShipCost());
        }
        if (e.getCurrencyUomId() == null)
        {
            if (e.getIsPropertyCurrencyUomIdRemoved() != null && e.getIsPropertyCurrencyUomIdRemoved())
            {
                this.setCurrencyUomId(null);
            }
        }
        else
        {
            this.setCurrencyUomId(e.getCurrencyUomId());
        }
        if (e.getHandlingInstructions() == null)
        {
            if (e.getIsPropertyHandlingInstructionsRemoved() != null && e.getIsPropertyHandlingInstructionsRemoved())
            {
                this.setHandlingInstructions(null);
            }
        }
        else
        {
            this.setHandlingInstructions(e.getHandlingInstructions());
        }
        if (e.getOriginFacilityId() == null)
        {
            if (e.getIsPropertyOriginFacilityIdRemoved() != null && e.getIsPropertyOriginFacilityIdRemoved())
            {
                this.setOriginFacilityId(null);
            }
        }
        else
        {
            this.setOriginFacilityId(e.getOriginFacilityId());
        }
        if (e.getDestinationFacilityId() == null)
        {
            if (e.getIsPropertyDestinationFacilityIdRemoved() != null && e.getIsPropertyDestinationFacilityIdRemoved())
            {
                this.setDestinationFacilityId(null);
            }
        }
        else
        {
            this.setDestinationFacilityId(e.getDestinationFacilityId());
        }
        if (e.getOriginContactMechId() == null)
        {
            if (e.getIsPropertyOriginContactMechIdRemoved() != null && e.getIsPropertyOriginContactMechIdRemoved())
            {
                this.setOriginContactMechId(null);
            }
        }
        else
        {
            this.setOriginContactMechId(e.getOriginContactMechId());
        }
        if (e.getOriginTelecomNumberId() == null)
        {
            if (e.getIsPropertyOriginTelecomNumberIdRemoved() != null && e.getIsPropertyOriginTelecomNumberIdRemoved())
            {
                this.setOriginTelecomNumberId(null);
            }
        }
        else
        {
            this.setOriginTelecomNumberId(e.getOriginTelecomNumberId());
        }
        if (e.getDestinationContactMechId() == null)
        {
            if (e.getIsPropertyDestinationContactMechIdRemoved() != null && e.getIsPropertyDestinationContactMechIdRemoved())
            {
                this.setDestinationContactMechId(null);
            }
        }
        else
        {
            this.setDestinationContactMechId(e.getDestinationContactMechId());
        }
        if (e.getDestinationTelecomNumberId() == null)
        {
            if (e.getIsPropertyDestinationTelecomNumberIdRemoved() != null && e.getIsPropertyDestinationTelecomNumberIdRemoved())
            {
                this.setDestinationTelecomNumberId(null);
            }
        }
        else
        {
            this.setDestinationTelecomNumberId(e.getDestinationTelecomNumberId());
        }
        if (e.getPartyIdTo() == null)
        {
            if (e.getIsPropertyPartyIdToRemoved() != null && e.getIsPropertyPartyIdToRemoved())
            {
                this.setPartyIdTo(null);
            }
        }
        else
        {
            this.setPartyIdTo(e.getPartyIdTo());
        }
        if (e.getPartyIdFrom() == null)
        {
            if (e.getIsPropertyPartyIdFromRemoved() != null && e.getIsPropertyPartyIdFromRemoved())
            {
                this.setPartyIdFrom(null);
            }
        }
        else
        {
            this.setPartyIdFrom(e.getPartyIdFrom());
        }
        if (e.getAdditionalShippingCharge() == null)
        {
            if (e.getIsPropertyAdditionalShippingChargeRemoved() != null && e.getIsPropertyAdditionalShippingChargeRemoved())
            {
                this.setAdditionalShippingCharge(null);
            }
        }
        else
        {
            this.setAdditionalShippingCharge(e.getAdditionalShippingCharge());
        }
        if (e.getAddtlShippingChargeDesc() == null)
        {
            if (e.getIsPropertyAddtlShippingChargeDescRemoved() != null && e.getIsPropertyAddtlShippingChargeDescRemoved())
            {
                this.setAddtlShippingChargeDesc(null);
            }
        }
        else
        {
            this.setAddtlShippingChargeDesc(e.getAddtlShippingChargeDesc());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (ShipmentItemEvent innerEvent : e.getShipmentItemEvents()) {
            ShipmentItemState innerState = this.getShipmentItems().get(innerEvent.getShipmentItemEventId().getShipmentItemSeqId());
            innerState.mutate(innerEvent);
        }
        for (ShipmentReceiptEvent innerEvent : e.getShipmentReceiptEvents()) {
            ShipmentReceiptState innerState = this.getShipmentReceipts().get(innerEvent.getShipmentReceiptEventId().getReceiptSeqId());
            innerState.mutate(innerEvent);
        }
        for (ItemIssuanceEvent innerEvent : e.getItemIssuanceEvents()) {
            ItemIssuanceState innerState = this.getItemIssuances().get(innerEvent.getItemIssuanceEventId().getItemIssuanceSeqId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof ItemIssuanceEvent.ItemIssuanceStateRemoved)
            {
                //ItemIssuanceEvent.ItemIssuanceStateRemoved removed = (ItemIssuanceEvent.ItemIssuanceStateRemoved)innerEvent;
                this.getItemIssuances().remove(innerState);
            }
        }
    }

    public void save()
    {
        shipmentItems.save();

        shipmentReceipts.save();

        itemIssuances.save();

    }

    protected void throwOnWrongEvent(ShipmentEvent event)
    {
        String stateEntityId = this.getShipmentId(); // Aggregate Id
        String eventEntityId = event.getShipmentEventId().getShipmentId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getShipmentEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getShipmentEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentState extends AbstractShipmentState
    {

        public SimpleShipmentState() {
        }

        public SimpleShipmentState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleShipmentState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleShipmentItemStates extends AbstractShipmentItemStates
    {
        public SimpleShipmentItemStates(AbstractShipmentState outerState)
        {
            super(outerState);
        }
    }

    static class SimpleShipmentReceiptStates extends AbstractShipmentReceiptStates
    {
        public SimpleShipmentReceiptStates(AbstractShipmentState outerState)
        {
            super(outerState);
        }
    }

    static class SimpleItemIssuanceStates extends AbstractItemIssuanceStates
    {
        public SimpleItemIssuanceStates(AbstractShipmentState outerState)
        {
            super(outerState);
        }
    }


}

