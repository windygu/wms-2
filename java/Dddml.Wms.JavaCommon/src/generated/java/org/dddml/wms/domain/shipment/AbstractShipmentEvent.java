package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentEvent extends AbstractEvent implements ShipmentEvent 
{
    private ShipmentEventId shipmentEventId;

    public ShipmentEventId getShipmentEventId() {
        return this.shipmentEventId;
    }

    public void setShipmentEventId(ShipmentEventId eventId) {
        this.shipmentEventId = eventId;
    }
    
    public String getShipmentId() {
        return getShipmentEventId().getShipmentId();
    }

    public void setShipmentId(String shipmentId) {
        getShipmentEventId().setShipmentId(shipmentId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractShipmentEvent() {
    }

    protected AbstractShipmentEvent(ShipmentEventId eventId) {
        this.shipmentEventId = eventId;
    }

    protected ShipmentImageEventDao getShipmentImageEventDao() {
        return (ShipmentImageEventDao)ApplicationContext.current.get("ShipmentImageEventDao");
    }

    protected ShipmentImageEventId newShipmentImageEventId(String sequenceId)
    {
        ShipmentImageEventId eventId = new ShipmentImageEventId(this.getShipmentEventId().getShipmentId(), 
            sequenceId, 
            this.getShipmentEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentImageEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentEvent oe, ShipmentImageEvent e)
    {
        if (!oe.getShipmentEventId().getShipmentId().equals(e.getShipmentImageEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getShipmentEventId().getShipmentId(), e.getShipmentImageEventId().getShipmentId());
        }
    }

    protected ShipmentItemEventDao getShipmentItemEventDao() {
        return (ShipmentItemEventDao)ApplicationContext.current.get("ShipmentItemEventDao");
    }

    protected ShipmentItemEventId newShipmentItemEventId(String shipmentItemSeqId)
    {
        ShipmentItemEventId eventId = new ShipmentItemEventId(this.getShipmentEventId().getShipmentId(), 
            shipmentItemSeqId, 
            this.getShipmentEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentItemEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentEvent oe, ShipmentItemEvent e)
    {
        if (!oe.getShipmentEventId().getShipmentId().equals(e.getShipmentItemEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getShipmentEventId().getShipmentId(), e.getShipmentItemEventId().getShipmentId());
        }
    }

    protected ShipmentReceiptEventDao getShipmentReceiptEventDao() {
        return (ShipmentReceiptEventDao)ApplicationContext.current.get("ShipmentReceiptEventDao");
    }

    protected ShipmentReceiptEventId newShipmentReceiptEventId(String receiptSeqId)
    {
        ShipmentReceiptEventId eventId = new ShipmentReceiptEventId(this.getShipmentEventId().getShipmentId(), 
            receiptSeqId, 
            this.getShipmentEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentReceiptEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentEvent oe, ShipmentReceiptEvent e)
    {
        if (!oe.getShipmentEventId().getShipmentId().equals(e.getShipmentReceiptEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getShipmentEventId().getShipmentId(), e.getShipmentReceiptEventId().getShipmentId());
        }
    }

    protected ItemIssuanceEventDao getItemIssuanceEventDao() {
        return (ItemIssuanceEventDao)ApplicationContext.current.get("ItemIssuanceEventDao");
    }

    protected ItemIssuanceEventId newItemIssuanceEventId(String itemIssuanceSeqId)
    {
        ItemIssuanceEventId eventId = new ItemIssuanceEventId(this.getShipmentEventId().getShipmentId(), 
            itemIssuanceSeqId, 
            this.getShipmentEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ItemIssuanceEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentEvent oe, ItemIssuanceEvent e)
    {
        if (!oe.getShipmentEventId().getShipmentId().equals(e.getItemIssuanceEventId().getShipmentId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentId %1$s but inner id ShipmentId %2$s", 
                oe.getShipmentEventId().getShipmentId(), e.getItemIssuanceEventId().getShipmentId());
        }
    }

    public ShipmentImageEvent.ShipmentImageStateCreated newShipmentImageStateCreated(String sequenceId) {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateCreated(newShipmentImageEventId(sequenceId));
    }

    public ShipmentImageEvent.ShipmentImageStateMergePatched newShipmentImageStateMergePatched(String sequenceId) {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateMergePatched(newShipmentImageEventId(sequenceId));
    }

    public ShipmentImageEvent.ShipmentImageStateRemoved newShipmentImageStateRemoved(String sequenceId) {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateRemoved(newShipmentImageEventId(sequenceId));
    }

    public ShipmentItemEvent.ShipmentItemStateCreated newShipmentItemStateCreated(String shipmentItemSeqId) {
        return new AbstractShipmentItemEvent.SimpleShipmentItemStateCreated(newShipmentItemEventId(shipmentItemSeqId));
    }

    public ShipmentItemEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(String shipmentItemSeqId) {
        return new AbstractShipmentItemEvent.SimpleShipmentItemStateMergePatched(newShipmentItemEventId(shipmentItemSeqId));
    }

    public ShipmentReceiptEvent.ShipmentReceiptStateCreated newShipmentReceiptStateCreated(String receiptSeqId) {
        return new AbstractShipmentReceiptEvent.SimpleShipmentReceiptStateCreated(newShipmentReceiptEventId(receiptSeqId));
    }

    public ShipmentReceiptEvent.ShipmentReceiptStateMergePatched newShipmentReceiptStateMergePatched(String receiptSeqId) {
        return new AbstractShipmentReceiptEvent.SimpleShipmentReceiptStateMergePatched(newShipmentReceiptEventId(receiptSeqId));
    }

    public ItemIssuanceEvent.ItemIssuanceStateCreated newItemIssuanceStateCreated(String itemIssuanceSeqId) {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateCreated(newItemIssuanceEventId(itemIssuanceSeqId));
    }

    public ItemIssuanceEvent.ItemIssuanceStateMergePatched newItemIssuanceStateMergePatched(String itemIssuanceSeqId) {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateMergePatched(newItemIssuanceEventId(itemIssuanceSeqId));
    }

    public ItemIssuanceEvent.ItemIssuanceStateRemoved newItemIssuanceStateRemoved(String itemIssuanceSeqId) {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateRemoved(newItemIssuanceEventId(itemIssuanceSeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentStateEvent extends AbstractShipmentEvent implements ShipmentEvent.ShipmentStateEvent {
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

        private String primaryShipGroupSeqId;

        public String getPrimaryShipGroupSeqId()
        {
            return this.primaryShipGroupSeqId;
        }

        public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId)
        {
            this.primaryShipGroupSeqId = primaryShipGroupSeqId;
        }

        private Boolean onlyOneOrder;

        public Boolean getOnlyOneOrder()
        {
            return this.onlyOneOrder;
        }

        public void setOnlyOneOrder(Boolean onlyOneOrder)
        {
            this.onlyOneOrder = onlyOneOrder;
        }

        private Boolean onlyOneOrderShipGroup;

        public Boolean getOnlyOneOrderShipGroup()
        {
            return this.onlyOneOrderShipGroup;
        }

        public void setOnlyOneOrderShipGroup(Boolean onlyOneOrderShipGroup)
        {
            this.onlyOneOrderShipGroup = onlyOneOrderShipGroup;
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

        private String externalOrderNumber;

        public String getExternalOrderNumber()
        {
            return this.externalOrderNumber;
        }

        public void setExternalOrderNumber(String externalOrderNumber)
        {
            this.externalOrderNumber = externalOrderNumber;
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

        private Boolean isCreatedFromPackingList;

        public Boolean getIsCreatedFromPackingList()
        {
            return this.isCreatedFromPackingList;
        }

        public void setIsCreatedFromPackingList(Boolean isCreatedFromPackingList)
        {
            this.isCreatedFromPackingList = isCreatedFromPackingList;
        }

        private Boolean isScheduleNeeded;

        public Boolean getIsScheduleNeeded()
        {
            return this.isScheduleNeeded;
        }

        public void setIsScheduleNeeded(Boolean isScheduleNeeded)
        {
            this.isScheduleNeeded = isScheduleNeeded;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractShipmentStateEvent(ShipmentEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentStateCreated extends AbstractShipmentStateEvent implements ShipmentEvent.ShipmentStateCreated, Saveable
    {
        public AbstractShipmentStateCreated() {
            this(new ShipmentEventId());
        }

        public AbstractShipmentStateCreated(ShipmentEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<ShipmentImageEventId, ShipmentImageEvent.ShipmentImageStateCreated> shipmentImageEvents = new HashMap<ShipmentImageEventId, ShipmentImageEvent.ShipmentImageStateCreated>();
        
        private Iterable<ShipmentImageEvent.ShipmentImageStateCreated> readOnlyShipmentImageEvents;

        public Iterable<ShipmentImageEvent.ShipmentImageStateCreated> getShipmentImageEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentImageEvents.values();
            }
            else
            {
                if (readOnlyShipmentImageEvents != null) { return readOnlyShipmentImageEvents; }
                ShipmentImageEventDao eventDao = getShipmentImageEventDao();
                List<ShipmentImageEvent.ShipmentImageStateCreated> eL = new ArrayList<ShipmentImageEvent.ShipmentImageStateCreated>();
                for (ShipmentImageEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentImageEvent.ShipmentImageStateCreated)e);
                }
                return (readOnlyShipmentImageEvents = eL);
            }
        }

        public void setShipmentImageEvents(Iterable<ShipmentImageEvent.ShipmentImageStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentImageEvent.ShipmentImageStateCreated e : es)
                {
                    addShipmentImageEvent(e);
                }
            }
            else { this.shipmentImageEvents.clear(); }
        }
        
        public void addShipmentImageEvent(ShipmentImageEvent.ShipmentImageStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentImageEvents.put(e.getShipmentImageEventId(), e);
        }

        private Map<ShipmentItemEventId, ShipmentItemEvent.ShipmentItemStateCreated> shipmentItemEvents = new HashMap<ShipmentItemEventId, ShipmentItemEvent.ShipmentItemStateCreated>();
        
        private Iterable<ShipmentItemEvent.ShipmentItemStateCreated> readOnlyShipmentItemEvents;

        public Iterable<ShipmentItemEvent.ShipmentItemStateCreated> getShipmentItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentItemEvents.values();
            }
            else
            {
                if (readOnlyShipmentItemEvents != null) { return readOnlyShipmentItemEvents; }
                ShipmentItemEventDao eventDao = getShipmentItemEventDao();
                List<ShipmentItemEvent.ShipmentItemStateCreated> eL = new ArrayList<ShipmentItemEvent.ShipmentItemStateCreated>();
                for (ShipmentItemEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentItemEvent.ShipmentItemStateCreated)e);
                }
                return (readOnlyShipmentItemEvents = eL);
            }
        }

        public void setShipmentItemEvents(Iterable<ShipmentItemEvent.ShipmentItemStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentItemEvent.ShipmentItemStateCreated e : es)
                {
                    addShipmentItemEvent(e);
                }
            }
            else { this.shipmentItemEvents.clear(); }
        }
        
        public void addShipmentItemEvent(ShipmentItemEvent.ShipmentItemStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentItemEvents.put(e.getShipmentItemEventId(), e);
        }

        private Map<ShipmentReceiptEventId, ShipmentReceiptEvent.ShipmentReceiptStateCreated> shipmentReceiptEvents = new HashMap<ShipmentReceiptEventId, ShipmentReceiptEvent.ShipmentReceiptStateCreated>();
        
        private Iterable<ShipmentReceiptEvent.ShipmentReceiptStateCreated> readOnlyShipmentReceiptEvents;

        public Iterable<ShipmentReceiptEvent.ShipmentReceiptStateCreated> getShipmentReceiptEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentReceiptEvents.values();
            }
            else
            {
                if (readOnlyShipmentReceiptEvents != null) { return readOnlyShipmentReceiptEvents; }
                ShipmentReceiptEventDao eventDao = getShipmentReceiptEventDao();
                List<ShipmentReceiptEvent.ShipmentReceiptStateCreated> eL = new ArrayList<ShipmentReceiptEvent.ShipmentReceiptStateCreated>();
                for (ShipmentReceiptEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentReceiptEvent.ShipmentReceiptStateCreated)e);
                }
                return (readOnlyShipmentReceiptEvents = eL);
            }
        }

        public void setShipmentReceiptEvents(Iterable<ShipmentReceiptEvent.ShipmentReceiptStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentReceiptEvent.ShipmentReceiptStateCreated e : es)
                {
                    addShipmentReceiptEvent(e);
                }
            }
            else { this.shipmentReceiptEvents.clear(); }
        }
        
        public void addShipmentReceiptEvent(ShipmentReceiptEvent.ShipmentReceiptStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentReceiptEvents.put(e.getShipmentReceiptEventId(), e);
        }

        private Map<ItemIssuanceEventId, ItemIssuanceEvent.ItemIssuanceStateCreated> itemIssuanceEvents = new HashMap<ItemIssuanceEventId, ItemIssuanceEvent.ItemIssuanceStateCreated>();
        
        private Iterable<ItemIssuanceEvent.ItemIssuanceStateCreated> readOnlyItemIssuanceEvents;

        public Iterable<ItemIssuanceEvent.ItemIssuanceStateCreated> getItemIssuanceEvents()
        {
            if (!getEventReadOnly())
            {
                return this.itemIssuanceEvents.values();
            }
            else
            {
                if (readOnlyItemIssuanceEvents != null) { return readOnlyItemIssuanceEvents; }
                ItemIssuanceEventDao eventDao = getItemIssuanceEventDao();
                List<ItemIssuanceEvent.ItemIssuanceStateCreated> eL = new ArrayList<ItemIssuanceEvent.ItemIssuanceStateCreated>();
                for (ItemIssuanceEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ItemIssuanceEvent.ItemIssuanceStateCreated)e);
                }
                return (readOnlyItemIssuanceEvents = eL);
            }
        }

        public void setItemIssuanceEvents(Iterable<ItemIssuanceEvent.ItemIssuanceStateCreated> es)
        {
            if (es != null)
            {
                for (ItemIssuanceEvent.ItemIssuanceStateCreated e : es)
                {
                    addItemIssuanceEvent(e);
                }
            }
            else { this.itemIssuanceEvents.clear(); }
        }
        
        public void addItemIssuanceEvent(ItemIssuanceEvent.ItemIssuanceStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.itemIssuanceEvents.put(e.getItemIssuanceEventId(), e);
        }

        public void save()
        {
            for (ShipmentImageEvent.ShipmentImageStateCreated e : this.getShipmentImageEvents()) {
                getShipmentImageEventDao().save(e);
            }
            for (ShipmentItemEvent.ShipmentItemStateCreated e : this.getShipmentItemEvents()) {
                getShipmentItemEventDao().save(e);
            }
            for (ShipmentReceiptEvent.ShipmentReceiptStateCreated e : this.getShipmentReceiptEvents()) {
                getShipmentReceiptEventDao().save(e);
            }
            for (ItemIssuanceEvent.ItemIssuanceStateCreated e : this.getItemIssuanceEvents()) {
                getItemIssuanceEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentStateMergePatched extends AbstractShipmentStateEvent implements ShipmentEvent.ShipmentStateMergePatched, Saveable
    {
        public AbstractShipmentStateMergePatched() {
            this(new ShipmentEventId());
        }

        public AbstractShipmentStateMergePatched(ShipmentEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

        public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved() {
            return this.isPropertyPrimaryShipGroupSeqIdRemoved;
        }

        public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed) {
            this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
        }

        private Boolean isPropertyOnlyOneOrderRemoved;

        public Boolean getIsPropertyOnlyOneOrderRemoved() {
            return this.isPropertyOnlyOneOrderRemoved;
        }

        public void setIsPropertyOnlyOneOrderRemoved(Boolean removed) {
            this.isPropertyOnlyOneOrderRemoved = removed;
        }

        private Boolean isPropertyOnlyOneOrderShipGroupRemoved;

        public Boolean getIsPropertyOnlyOneOrderShipGroupRemoved() {
            return this.isPropertyOnlyOneOrderShipGroupRemoved;
        }

        public void setIsPropertyOnlyOneOrderShipGroupRemoved(Boolean removed) {
            this.isPropertyOnlyOneOrderShipGroupRemoved = removed;
        }

        private Boolean isPropertyPicklistBinIdRemoved;

        public Boolean getIsPropertyPicklistBinIdRemoved() {
            return this.isPropertyPicklistBinIdRemoved;
        }

        public void setIsPropertyPicklistBinIdRemoved(Boolean removed) {
            this.isPropertyPicklistBinIdRemoved = removed;
        }

        private Boolean isPropertyBolNumberRemoved;

        public Boolean getIsPropertyBolNumberRemoved() {
            return this.isPropertyBolNumberRemoved;
        }

        public void setIsPropertyBolNumberRemoved(Boolean removed) {
            this.isPropertyBolNumberRemoved = removed;
        }

        private Boolean isPropertySealNumberRemoved;

        public Boolean getIsPropertySealNumberRemoved() {
            return this.isPropertySealNumberRemoved;
        }

        public void setIsPropertySealNumberRemoved(Boolean removed) {
            this.isPropertySealNumberRemoved = removed;
        }

        private Boolean isPropertyVehicleIdRemoved;

        public Boolean getIsPropertyVehicleIdRemoved() {
            return this.isPropertyVehicleIdRemoved;
        }

        public void setIsPropertyVehicleIdRemoved(Boolean removed) {
            this.isPropertyVehicleIdRemoved = removed;
        }

        private Boolean isPropertyExternalOrderNumberRemoved;

        public Boolean getIsPropertyExternalOrderNumberRemoved() {
            return this.isPropertyExternalOrderNumberRemoved;
        }

        public void setIsPropertyExternalOrderNumberRemoved(Boolean removed) {
            this.isPropertyExternalOrderNumberRemoved = removed;
        }

        private Boolean isPropertyCarrierRemoved;

        public Boolean getIsPropertyCarrierRemoved() {
            return this.isPropertyCarrierRemoved;
        }

        public void setIsPropertyCarrierRemoved(Boolean removed) {
            this.isPropertyCarrierRemoved = removed;
        }

        private Boolean isPropertyDateShippedRemoved;

        public Boolean getIsPropertyDateShippedRemoved() {
            return this.isPropertyDateShippedRemoved;
        }

        public void setIsPropertyDateShippedRemoved(Boolean removed) {
            this.isPropertyDateShippedRemoved = removed;
        }

        private Boolean isPropertyIsCreatedFromPackingListRemoved;

        public Boolean getIsPropertyIsCreatedFromPackingListRemoved() {
            return this.isPropertyIsCreatedFromPackingListRemoved;
        }

        public void setIsPropertyIsCreatedFromPackingListRemoved(Boolean removed) {
            this.isPropertyIsCreatedFromPackingListRemoved = removed;
        }

        private Boolean isPropertyIsScheduleNeededRemoved;

        public Boolean getIsPropertyIsScheduleNeededRemoved() {
            return this.isPropertyIsScheduleNeededRemoved;
        }

        public void setIsPropertyIsScheduleNeededRemoved(Boolean removed) {
            this.isPropertyIsScheduleNeededRemoved = removed;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<ShipmentImageEventId, ShipmentImageEvent> shipmentImageEvents = new HashMap<ShipmentImageEventId, ShipmentImageEvent>();
        
        private Iterable<ShipmentImageEvent> readOnlyShipmentImageEvents;

        public Iterable<ShipmentImageEvent> getShipmentImageEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentImageEvents.values();
            }
            else
            {
                if (readOnlyShipmentImageEvents != null) { return readOnlyShipmentImageEvents; }
                ShipmentImageEventDao eventDao = getShipmentImageEventDao();
                List<ShipmentImageEvent> eL = new ArrayList<ShipmentImageEvent>();
                for (ShipmentImageEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentImageEvent)e);
                }
                return (readOnlyShipmentImageEvents = eL);
            }
        }

        public void setShipmentImageEvents(Iterable<ShipmentImageEvent> es)
        {
            if (es != null)
            {
                for (ShipmentImageEvent e : es)
                {
                    addShipmentImageEvent(e);
                }
            }
            else { this.shipmentImageEvents.clear(); }
        }
        
        public void addShipmentImageEvent(ShipmentImageEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentImageEvents.put(e.getShipmentImageEventId(), e);
        }

        private Map<ShipmentItemEventId, ShipmentItemEvent> shipmentItemEvents = new HashMap<ShipmentItemEventId, ShipmentItemEvent>();
        
        private Iterable<ShipmentItemEvent> readOnlyShipmentItemEvents;

        public Iterable<ShipmentItemEvent> getShipmentItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentItemEvents.values();
            }
            else
            {
                if (readOnlyShipmentItemEvents != null) { return readOnlyShipmentItemEvents; }
                ShipmentItemEventDao eventDao = getShipmentItemEventDao();
                List<ShipmentItemEvent> eL = new ArrayList<ShipmentItemEvent>();
                for (ShipmentItemEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentItemEvent)e);
                }
                return (readOnlyShipmentItemEvents = eL);
            }
        }

        public void setShipmentItemEvents(Iterable<ShipmentItemEvent> es)
        {
            if (es != null)
            {
                for (ShipmentItemEvent e : es)
                {
                    addShipmentItemEvent(e);
                }
            }
            else { this.shipmentItemEvents.clear(); }
        }
        
        public void addShipmentItemEvent(ShipmentItemEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentItemEvents.put(e.getShipmentItemEventId(), e);
        }

        private Map<ShipmentReceiptEventId, ShipmentReceiptEvent> shipmentReceiptEvents = new HashMap<ShipmentReceiptEventId, ShipmentReceiptEvent>();
        
        private Iterable<ShipmentReceiptEvent> readOnlyShipmentReceiptEvents;

        public Iterable<ShipmentReceiptEvent> getShipmentReceiptEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentReceiptEvents.values();
            }
            else
            {
                if (readOnlyShipmentReceiptEvents != null) { return readOnlyShipmentReceiptEvents; }
                ShipmentReceiptEventDao eventDao = getShipmentReceiptEventDao();
                List<ShipmentReceiptEvent> eL = new ArrayList<ShipmentReceiptEvent>();
                for (ShipmentReceiptEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ShipmentReceiptEvent)e);
                }
                return (readOnlyShipmentReceiptEvents = eL);
            }
        }

        public void setShipmentReceiptEvents(Iterable<ShipmentReceiptEvent> es)
        {
            if (es != null)
            {
                for (ShipmentReceiptEvent e : es)
                {
                    addShipmentReceiptEvent(e);
                }
            }
            else { this.shipmentReceiptEvents.clear(); }
        }
        
        public void addShipmentReceiptEvent(ShipmentReceiptEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentReceiptEvents.put(e.getShipmentReceiptEventId(), e);
        }

        private Map<ItemIssuanceEventId, ItemIssuanceEvent> itemIssuanceEvents = new HashMap<ItemIssuanceEventId, ItemIssuanceEvent>();
        
        private Iterable<ItemIssuanceEvent> readOnlyItemIssuanceEvents;

        public Iterable<ItemIssuanceEvent> getItemIssuanceEvents()
        {
            if (!getEventReadOnly())
            {
                return this.itemIssuanceEvents.values();
            }
            else
            {
                if (readOnlyItemIssuanceEvents != null) { return readOnlyItemIssuanceEvents; }
                ItemIssuanceEventDao eventDao = getItemIssuanceEventDao();
                List<ItemIssuanceEvent> eL = new ArrayList<ItemIssuanceEvent>();
                for (ItemIssuanceEvent e : eventDao.findByShipmentEventId(this.getShipmentEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((ItemIssuanceEvent)e);
                }
                return (readOnlyItemIssuanceEvents = eL);
            }
        }

        public void setItemIssuanceEvents(Iterable<ItemIssuanceEvent> es)
        {
            if (es != null)
            {
                for (ItemIssuanceEvent e : es)
                {
                    addItemIssuanceEvent(e);
                }
            }
            else { this.itemIssuanceEvents.clear(); }
        }
        
        public void addItemIssuanceEvent(ItemIssuanceEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.itemIssuanceEvents.put(e.getItemIssuanceEventId(), e);
        }

        public void save()
        {
            for (ShipmentImageEvent e : this.getShipmentImageEvents()) {
                getShipmentImageEventDao().save(e);
            }
            for (ShipmentItemEvent e : this.getShipmentItemEvents()) {
                getShipmentItemEventDao().save(e);
            }
            for (ShipmentReceiptEvent e : this.getShipmentReceiptEvents()) {
                getShipmentReceiptEventDao().save(e);
            }
            for (ItemIssuanceEvent e : this.getItemIssuanceEvents()) {
                getItemIssuanceEventDao().save(e);
            }
        }
    }


    public static class SimpleShipmentStateCreated extends AbstractShipmentStateCreated
    {
        public SimpleShipmentStateCreated() {
        }

        public SimpleShipmentStateCreated(ShipmentEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentStateMergePatched extends AbstractShipmentStateMergePatched
    {
        public SimpleShipmentStateMergePatched() {
        }

        public SimpleShipmentStateMergePatched(ShipmentEventId eventId) {
            super(eventId);
        }
    }

}

