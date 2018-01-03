package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentStateEvent extends AbstractStateEvent implements ShipmentStateEvent 
{
    private ShipmentStateEventId stateEventId;

    public ShipmentStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ShipmentStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getShipmentId() {
        return getStateEventId().getShipmentId();
    }

    public void setShipmentId(String shipmentId) {
        getStateEventId().setShipmentId(shipmentId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
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

    private String shipperId;

    public String getShipperId()
    {
        return this.shipperId;
    }

    public void setShipperId(String shipperId)
    {
        this.shipperId = shipperId;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractShipmentStateEvent() {
    }

    protected AbstractShipmentStateEvent(ShipmentStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected ShipmentItemStateEventDao getShipmentItemStateEventDao() {
        return (ShipmentItemStateEventDao)ApplicationContext.current.get("ShipmentItemStateEventDao");
    }

    protected ShipmentItemStateEventId newShipmentItemStateEventId(String shipmentItemSeqId)
    {
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(this.getStateEventId().getShipmentId(), 
            shipmentItemSeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentItemStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentStateEvent oe, ShipmentItemStateEvent e)
    {
        if (!oe.getStateEventId().getShipmentId().equals(e.getStateEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getStateEventId().getShipmentId(), e.getStateEventId().getShipmentId());
        }
    }

    protected ShipmentReceiptStateEventDao getShipmentReceiptStateEventDao() {
        return (ShipmentReceiptStateEventDao)ApplicationContext.current.get("ShipmentReceiptStateEventDao");
    }

    protected ShipmentReceiptStateEventId newShipmentReceiptStateEventId(String receiptSeqId)
    {
        ShipmentReceiptStateEventId stateEventId = new ShipmentReceiptStateEventId(this.getStateEventId().getShipmentId(), 
            receiptSeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentReceiptStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentStateEvent oe, ShipmentReceiptStateEvent e)
    {
        if (!oe.getStateEventId().getShipmentId().equals(e.getStateEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getStateEventId().getShipmentId(), e.getStateEventId().getShipmentId());
        }
    }

    public ShipmentItemStateEvent.ShipmentItemStateCreated newShipmentItemStateCreated(String shipmentItemSeqId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateCreated(newShipmentItemStateEventId(shipmentItemSeqId));
    }

    public ShipmentItemStateEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(String shipmentItemSeqId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateMergePatched(newShipmentItemStateEventId(shipmentItemSeqId));
    }

    public ShipmentReceiptStateEvent.ShipmentReceiptStateCreated newShipmentReceiptStateCreated(String receiptSeqId) {
        return new AbstractShipmentReceiptStateEvent.SimpleShipmentReceiptStateCreated(newShipmentReceiptStateEventId(receiptSeqId));
    }

    public ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched newShipmentReceiptStateMergePatched(String receiptSeqId) {
        return new AbstractShipmentReceiptStateEvent.SimpleShipmentReceiptStateMergePatched(newShipmentReceiptStateEventId(receiptSeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentStateCreated extends AbstractShipmentStateEvent implements ShipmentStateEvent.ShipmentStateCreated, Saveable
    {
        public AbstractShipmentStateCreated() {
            this(new ShipmentStateEventId());
        }

        public AbstractShipmentStateCreated(ShipmentStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<ShipmentItemStateEventId, ShipmentItemStateEvent.ShipmentItemStateCreated> shipmentItemEvents = new HashMap<ShipmentItemStateEventId, ShipmentItemStateEvent.ShipmentItemStateCreated>();
        
        private Iterable<ShipmentItemStateEvent.ShipmentItemStateCreated> readOnlyShipmentItemEvents;

        public Iterable<ShipmentItemStateEvent.ShipmentItemStateCreated> getShipmentItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentItemEvents.values();
            }
            else
            {
                if (readOnlyShipmentItemEvents != null) { return readOnlyShipmentItemEvents; }
                ShipmentItemStateEventDao eventDao = getShipmentItemStateEventDao();
                List<ShipmentItemStateEvent.ShipmentItemStateCreated> eL = new ArrayList<ShipmentItemStateEvent.ShipmentItemStateCreated>();
                for (ShipmentItemStateEvent e : eventDao.findByShipmentStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentItemStateEvent.ShipmentItemStateCreated)e);
                }
                return (readOnlyShipmentItemEvents = eL);
            }
        }

        public void setShipmentItemEvents(Iterable<ShipmentItemStateEvent.ShipmentItemStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentItemStateEvent.ShipmentItemStateCreated e : es)
                {
                    addShipmentItemEvent(e);
                }
            }
            else { this.shipmentItemEvents.clear(); }
        }
        
        public void addShipmentItemEvent(ShipmentItemStateEvent.ShipmentItemStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentItemEvents.put(e.getStateEventId(), e);
        }

        private Map<ShipmentReceiptStateEventId, ShipmentReceiptStateEvent.ShipmentReceiptStateCreated> shipmentReceiptEvents = new HashMap<ShipmentReceiptStateEventId, ShipmentReceiptStateEvent.ShipmentReceiptStateCreated>();
        
        private Iterable<ShipmentReceiptStateEvent.ShipmentReceiptStateCreated> readOnlyShipmentReceiptEvents;

        public Iterable<ShipmentReceiptStateEvent.ShipmentReceiptStateCreated> getShipmentReceiptEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentReceiptEvents.values();
            }
            else
            {
                if (readOnlyShipmentReceiptEvents != null) { return readOnlyShipmentReceiptEvents; }
                ShipmentReceiptStateEventDao eventDao = getShipmentReceiptStateEventDao();
                List<ShipmentReceiptStateEvent.ShipmentReceiptStateCreated> eL = new ArrayList<ShipmentReceiptStateEvent.ShipmentReceiptStateCreated>();
                for (ShipmentReceiptStateEvent e : eventDao.findByShipmentStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentReceiptStateEvent.ShipmentReceiptStateCreated)e);
                }
                return (readOnlyShipmentReceiptEvents = eL);
            }
        }

        public void setShipmentReceiptEvents(Iterable<ShipmentReceiptStateEvent.ShipmentReceiptStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e : es)
                {
                    addShipmentReceiptEvent(e);
                }
            }
            else { this.shipmentReceiptEvents.clear(); }
        }
        
        public void addShipmentReceiptEvent(ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentReceiptEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (ShipmentItemStateEvent.ShipmentItemStateCreated e : this.getShipmentItemEvents()) {
                getShipmentItemStateEventDao().save(e);
            }
            for (ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e : this.getShipmentReceiptEvents()) {
                getShipmentReceiptStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentStateMergePatched extends AbstractShipmentStateEvent implements ShipmentStateEvent.ShipmentStateMergePatched, Saveable
    {
        public AbstractShipmentStateMergePatched() {
            this(new ShipmentStateEventId());
        }

        public AbstractShipmentStateMergePatched(ShipmentStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyShipmentTypeIdRemoved;

        public Boolean getIsPropertyShipmentTypeIdRemoved() {
            return this.isPropertyShipmentTypeIdRemoved;
        }

        public void setIsPropertyShipmentTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentTypeIdRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved() {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed) {
            this.isPropertyStatusIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryOrderIdRemoved;

        public Boolean getIsPropertyPrimaryOrderIdRemoved() {
            return this.isPropertyPrimaryOrderIdRemoved;
        }

        public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed) {
            this.isPropertyPrimaryOrderIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryReturnIdRemoved;

        public Boolean getIsPropertyPrimaryReturnIdRemoved() {
            return this.isPropertyPrimaryReturnIdRemoved;
        }

        public void setIsPropertyPrimaryReturnIdRemoved(Boolean removed) {
            this.isPropertyPrimaryReturnIdRemoved = removed;
        }

        private Boolean isPropertyPicklistBinIdRemoved;

        public Boolean getIsPropertyPicklistBinIdRemoved() {
            return this.isPropertyPicklistBinIdRemoved;
        }

        public void setIsPropertyPicklistBinIdRemoved(Boolean removed) {
            this.isPropertyPicklistBinIdRemoved = removed;
        }

        private Boolean isPropertyEstimatedReadyDateRemoved;

        public Boolean getIsPropertyEstimatedReadyDateRemoved() {
            return this.isPropertyEstimatedReadyDateRemoved;
        }

        public void setIsPropertyEstimatedReadyDateRemoved(Boolean removed) {
            this.isPropertyEstimatedReadyDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipDateRemoved;

        public Boolean getIsPropertyEstimatedShipDateRemoved() {
            return this.isPropertyEstimatedShipDateRemoved;
        }

        public void setIsPropertyEstimatedShipDateRemoved(Boolean removed) {
            this.isPropertyEstimatedShipDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipWorkEffIdRemoved;

        public Boolean getIsPropertyEstimatedShipWorkEffIdRemoved() {
            return this.isPropertyEstimatedShipWorkEffIdRemoved;
        }

        public void setIsPropertyEstimatedShipWorkEffIdRemoved(Boolean removed) {
            this.isPropertyEstimatedShipWorkEffIdRemoved = removed;
        }

        private Boolean isPropertyEstimatedArrivalDateRemoved;

        public Boolean getIsPropertyEstimatedArrivalDateRemoved() {
            return this.isPropertyEstimatedArrivalDateRemoved;
        }

        public void setIsPropertyEstimatedArrivalDateRemoved(Boolean removed) {
            this.isPropertyEstimatedArrivalDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedArrivalWorkEffIdRemoved;

        public Boolean getIsPropertyEstimatedArrivalWorkEffIdRemoved() {
            return this.isPropertyEstimatedArrivalWorkEffIdRemoved;
        }

        public void setIsPropertyEstimatedArrivalWorkEffIdRemoved(Boolean removed) {
            this.isPropertyEstimatedArrivalWorkEffIdRemoved = removed;
        }

        private Boolean isPropertyLatestCancelDateRemoved;

        public Boolean getIsPropertyLatestCancelDateRemoved() {
            return this.isPropertyLatestCancelDateRemoved;
        }

        public void setIsPropertyLatestCancelDateRemoved(Boolean removed) {
            this.isPropertyLatestCancelDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipCostRemoved;

        public Boolean getIsPropertyEstimatedShipCostRemoved() {
            return this.isPropertyEstimatedShipCostRemoved;
        }

        public void setIsPropertyEstimatedShipCostRemoved(Boolean removed) {
            this.isPropertyEstimatedShipCostRemoved = removed;
        }

        private Boolean isPropertyCurrencyUomIdRemoved;

        public Boolean getIsPropertyCurrencyUomIdRemoved() {
            return this.isPropertyCurrencyUomIdRemoved;
        }

        public void setIsPropertyCurrencyUomIdRemoved(Boolean removed) {
            this.isPropertyCurrencyUomIdRemoved = removed;
        }

        private Boolean isPropertyHandlingInstructionsRemoved;

        public Boolean getIsPropertyHandlingInstructionsRemoved() {
            return this.isPropertyHandlingInstructionsRemoved;
        }

        public void setIsPropertyHandlingInstructionsRemoved(Boolean removed) {
            this.isPropertyHandlingInstructionsRemoved = removed;
        }

        private Boolean isPropertyOriginFacilityIdRemoved;

        public Boolean getIsPropertyOriginFacilityIdRemoved() {
            return this.isPropertyOriginFacilityIdRemoved;
        }

        public void setIsPropertyOriginFacilityIdRemoved(Boolean removed) {
            this.isPropertyOriginFacilityIdRemoved = removed;
        }

        private Boolean isPropertyDestinationFacilityIdRemoved;

        public Boolean getIsPropertyDestinationFacilityIdRemoved() {
            return this.isPropertyDestinationFacilityIdRemoved;
        }

        public void setIsPropertyDestinationFacilityIdRemoved(Boolean removed) {
            this.isPropertyDestinationFacilityIdRemoved = removed;
        }

        private Boolean isPropertyOriginContactMechIdRemoved;

        public Boolean getIsPropertyOriginContactMechIdRemoved() {
            return this.isPropertyOriginContactMechIdRemoved;
        }

        public void setIsPropertyOriginContactMechIdRemoved(Boolean removed) {
            this.isPropertyOriginContactMechIdRemoved = removed;
        }

        private Boolean isPropertyOriginTelecomNumberIdRemoved;

        public Boolean getIsPropertyOriginTelecomNumberIdRemoved() {
            return this.isPropertyOriginTelecomNumberIdRemoved;
        }

        public void setIsPropertyOriginTelecomNumberIdRemoved(Boolean removed) {
            this.isPropertyOriginTelecomNumberIdRemoved = removed;
        }

        private Boolean isPropertyDestinationContactMechIdRemoved;

        public Boolean getIsPropertyDestinationContactMechIdRemoved() {
            return this.isPropertyDestinationContactMechIdRemoved;
        }

        public void setIsPropertyDestinationContactMechIdRemoved(Boolean removed) {
            this.isPropertyDestinationContactMechIdRemoved = removed;
        }

        private Boolean isPropertyDestinationTelecomNumberIdRemoved;

        public Boolean getIsPropertyDestinationTelecomNumberIdRemoved() {
            return this.isPropertyDestinationTelecomNumberIdRemoved;
        }

        public void setIsPropertyDestinationTelecomNumberIdRemoved(Boolean removed) {
            this.isPropertyDestinationTelecomNumberIdRemoved = removed;
        }

        private Boolean isPropertyPartyIdToRemoved;

        public Boolean getIsPropertyPartyIdToRemoved() {
            return this.isPropertyPartyIdToRemoved;
        }

        public void setIsPropertyPartyIdToRemoved(Boolean removed) {
            this.isPropertyPartyIdToRemoved = removed;
        }

        private Boolean isPropertyPartyIdFromRemoved;

        public Boolean getIsPropertyPartyIdFromRemoved() {
            return this.isPropertyPartyIdFromRemoved;
        }

        public void setIsPropertyPartyIdFromRemoved(Boolean removed) {
            this.isPropertyPartyIdFromRemoved = removed;
        }

        private Boolean isPropertyAdditionalShippingChargeRemoved;

        public Boolean getIsPropertyAdditionalShippingChargeRemoved() {
            return this.isPropertyAdditionalShippingChargeRemoved;
        }

        public void setIsPropertyAdditionalShippingChargeRemoved(Boolean removed) {
            this.isPropertyAdditionalShippingChargeRemoved = removed;
        }

        private Boolean isPropertyAddtlShippingChargeDescRemoved;

        public Boolean getIsPropertyAddtlShippingChargeDescRemoved() {
            return this.isPropertyAddtlShippingChargeDescRemoved;
        }

        public void setIsPropertyAddtlShippingChargeDescRemoved(Boolean removed) {
            this.isPropertyAddtlShippingChargeDescRemoved = removed;
        }

        private Boolean isPropertyShipperIdRemoved;

        public Boolean getIsPropertyShipperIdRemoved() {
            return this.isPropertyShipperIdRemoved;
        }

        public void setIsPropertyShipperIdRemoved(Boolean removed) {
            this.isPropertyShipperIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<ShipmentItemStateEventId, ShipmentItemStateEvent> shipmentItemEvents = new HashMap<ShipmentItemStateEventId, ShipmentItemStateEvent>();
        
        private Iterable<ShipmentItemStateEvent> readOnlyShipmentItemEvents;

        public Iterable<ShipmentItemStateEvent> getShipmentItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentItemEvents.values();
            }
            else
            {
                if (readOnlyShipmentItemEvents != null) { return readOnlyShipmentItemEvents; }
                ShipmentItemStateEventDao eventDao = getShipmentItemStateEventDao();
                List<ShipmentItemStateEvent> eL = new ArrayList<ShipmentItemStateEvent>();
                for (ShipmentItemStateEvent e : eventDao.findByShipmentStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentItemStateEvent)e);
                }
                return (readOnlyShipmentItemEvents = eL);
            }
        }

        public void setShipmentItemEvents(Iterable<ShipmentItemStateEvent> es)
        {
            if (es != null)
            {
                for (ShipmentItemStateEvent e : es)
                {
                    addShipmentItemEvent(e);
                }
            }
            else { this.shipmentItemEvents.clear(); }
        }
        
        public void addShipmentItemEvent(ShipmentItemStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentItemEvents.put(e.getStateEventId(), e);
        }

        private Map<ShipmentReceiptStateEventId, ShipmentReceiptStateEvent> shipmentReceiptEvents = new HashMap<ShipmentReceiptStateEventId, ShipmentReceiptStateEvent>();
        
        private Iterable<ShipmentReceiptStateEvent> readOnlyShipmentReceiptEvents;

        public Iterable<ShipmentReceiptStateEvent> getShipmentReceiptEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentReceiptEvents.values();
            }
            else
            {
                if (readOnlyShipmentReceiptEvents != null) { return readOnlyShipmentReceiptEvents; }
                ShipmentReceiptStateEventDao eventDao = getShipmentReceiptStateEventDao();
                List<ShipmentReceiptStateEvent> eL = new ArrayList<ShipmentReceiptStateEvent>();
                for (ShipmentReceiptStateEvent e : eventDao.findByShipmentStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentReceiptStateEvent)e);
                }
                return (readOnlyShipmentReceiptEvents = eL);
            }
        }

        public void setShipmentReceiptEvents(Iterable<ShipmentReceiptStateEvent> es)
        {
            if (es != null)
            {
                for (ShipmentReceiptStateEvent e : es)
                {
                    addShipmentReceiptEvent(e);
                }
            }
            else { this.shipmentReceiptEvents.clear(); }
        }
        
        public void addShipmentReceiptEvent(ShipmentReceiptStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentReceiptEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (ShipmentItemStateEvent e : this.getShipmentItemEvents()) {
                getShipmentItemStateEventDao().save(e);
            }
            for (ShipmentReceiptStateEvent e : this.getShipmentReceiptEvents()) {
                getShipmentReceiptStateEventDao().save(e);
            }
        }
    }


    public static class SimpleShipmentStateCreated extends AbstractShipmentStateCreated
    {
        public SimpleShipmentStateCreated() {
        }

        public SimpleShipmentStateCreated(ShipmentStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleShipmentStateMergePatched extends AbstractShipmentStateMergePatched
    {
        public SimpleShipmentStateMergePatched() {
        }

        public SimpleShipmentStateMergePatched(ShipmentStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

