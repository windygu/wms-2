package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentPackageEvent extends AbstractEvent implements ShipmentPackageEvent.SqlShipmentPackageEvent 
{
    private ShipmentPackageEventId shipmentPackageEventId;

    public ShipmentPackageEventId getShipmentPackageEventId() {
        return this.shipmentPackageEventId;
    }

    public void setShipmentPackageEventId(ShipmentPackageEventId eventId) {
        this.shipmentPackageEventId = eventId;
    }
    
    public ShipmentPackageId getShipmentPackageId() {
        return getShipmentPackageEventId().getShipmentPackageId();
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId) {
        getShipmentPackageEventId().setShipmentPackageId(shipmentPackageId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getShipmentPackageEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getShipmentPackageEventId().setVersion(version);
    //}

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

    protected AbstractShipmentPackageEvent() {
    }

    protected AbstractShipmentPackageEvent(ShipmentPackageEventId eventId) {
        this.shipmentPackageEventId = eventId;
    }

    protected ShipmentPackageContentEventDao getShipmentPackageContentEventDao() {
        return (ShipmentPackageContentEventDao)ApplicationContext.current.get("ShipmentPackageContentEventDao");
    }

    protected ShipmentPackageContentEventId newShipmentPackageContentEventId(String shipmentItemSeqId)
    {
        ShipmentPackageContentEventId eventId = new ShipmentPackageContentEventId(this.getShipmentPackageEventId().getShipmentPackageId(), 
            shipmentItemSeqId, 
            this.getShipmentPackageEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentPackageContentEvent.SqlShipmentPackageContentEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentPackageEvent.SqlShipmentPackageEvent oe, ShipmentPackageContentEvent.SqlShipmentPackageContentEvent e)
    {
        if (!oe.getShipmentPackageEventId().getShipmentPackageId().equals(e.getShipmentPackageContentEventId().getShipmentPackageId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentPackageId %1$s but inner id ShipmentPackageId %2$s", 
                oe.getShipmentPackageEventId().getShipmentPackageId(), e.getShipmentPackageContentEventId().getShipmentPackageId());
        }
    }

    public ShipmentPackageContentEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentEvent.SimpleShipmentPackageContentStateCreated(newShipmentPackageContentEventId(shipmentItemSeqId));
    }

    public ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched newShipmentPackageContentStateMergePatched(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentEvent.SimpleShipmentPackageContentStateMergePatched(newShipmentPackageContentEventId(shipmentItemSeqId));
    }

    public ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentEvent.SimpleShipmentPackageContentStateRemoved(newShipmentPackageContentEventId(shipmentItemSeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentPackageStateEvent extends AbstractShipmentPackageEvent implements ShipmentPackageEvent.ShipmentPackageStateEvent {
        private String shipmentBoxTypeId;

        public String getShipmentBoxTypeId()
        {
            return this.shipmentBoxTypeId;
        }

        public void setShipmentBoxTypeId(String shipmentBoxTypeId)
        {
            this.shipmentBoxTypeId = shipmentBoxTypeId;
        }

        private java.sql.Timestamp dateCreated;

        public java.sql.Timestamp getDateCreated()
        {
            return this.dateCreated;
        }

        public void setDateCreated(java.sql.Timestamp dateCreated)
        {
            this.dateCreated = dateCreated;
        }

        private java.math.BigDecimal boxLength;

        public java.math.BigDecimal getBoxLength()
        {
            return this.boxLength;
        }

        public void setBoxLength(java.math.BigDecimal boxLength)
        {
            this.boxLength = boxLength;
        }

        private java.math.BigDecimal boxHeight;

        public java.math.BigDecimal getBoxHeight()
        {
            return this.boxHeight;
        }

        public void setBoxHeight(java.math.BigDecimal boxHeight)
        {
            this.boxHeight = boxHeight;
        }

        private java.math.BigDecimal boxWidth;

        public java.math.BigDecimal getBoxWidth()
        {
            return this.boxWidth;
        }

        public void setBoxWidth(java.math.BigDecimal boxWidth)
        {
            this.boxWidth = boxWidth;
        }

        private String dimensionUomId;

        public String getDimensionUomId()
        {
            return this.dimensionUomId;
        }

        public void setDimensionUomId(String dimensionUomId)
        {
            this.dimensionUomId = dimensionUomId;
        }

        private java.math.BigDecimal weight;

        public java.math.BigDecimal getWeight()
        {
            return this.weight;
        }

        public void setWeight(java.math.BigDecimal weight)
        {
            this.weight = weight;
        }

        private String weightUomId;

        public String getWeightUomId()
        {
            return this.weightUomId;
        }

        public void setWeightUomId(String weightUomId)
        {
            this.weightUomId = weightUomId;
        }

        private java.math.BigDecimal insuredValue;

        public java.math.BigDecimal getInsuredValue()
        {
            return this.insuredValue;
        }

        public void setInsuredValue(java.math.BigDecimal insuredValue)
        {
            this.insuredValue = insuredValue;
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

        protected AbstractShipmentPackageStateEvent(ShipmentPackageEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentPackageStateCreated extends AbstractShipmentPackageStateEvent implements ShipmentPackageEvent.ShipmentPackageStateCreated, Saveable
    {
        public AbstractShipmentPackageStateCreated() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateCreated(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<ShipmentPackageContentEventId, ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentEvent.ShipmentPackageContentStateCreated>();
        
        private Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> getShipmentPackageContentEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentEventDao eventDao = getShipmentPackageContentEventDao();
                List<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> eL = new ArrayList<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated>();
                for (ShipmentPackageContentEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    ((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).setEventReadOnly(true);
                    eL.add((ShipmentPackageContentEvent.ShipmentPackageContentStateCreated)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e)
        {
            throwOnInconsistentEventIds((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e);
            this.shipmentPackageContentEvents.put(((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentPackageStateMergePatched extends AbstractShipmentPackageStateEvent implements ShipmentPackageEvent.ShipmentPackageStateMergePatched, Saveable
    {
        public AbstractShipmentPackageStateMergePatched() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateMergePatched(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyShipmentBoxTypeIdRemoved;

        public Boolean getIsPropertyShipmentBoxTypeIdRemoved() {
            return this.isPropertyShipmentBoxTypeIdRemoved;
        }

        public void setIsPropertyShipmentBoxTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentBoxTypeIdRemoved = removed;
        }

        private Boolean isPropertyDateCreatedRemoved;

        public Boolean getIsPropertyDateCreatedRemoved() {
            return this.isPropertyDateCreatedRemoved;
        }

        public void setIsPropertyDateCreatedRemoved(Boolean removed) {
            this.isPropertyDateCreatedRemoved = removed;
        }

        private Boolean isPropertyBoxLengthRemoved;

        public Boolean getIsPropertyBoxLengthRemoved() {
            return this.isPropertyBoxLengthRemoved;
        }

        public void setIsPropertyBoxLengthRemoved(Boolean removed) {
            this.isPropertyBoxLengthRemoved = removed;
        }

        private Boolean isPropertyBoxHeightRemoved;

        public Boolean getIsPropertyBoxHeightRemoved() {
            return this.isPropertyBoxHeightRemoved;
        }

        public void setIsPropertyBoxHeightRemoved(Boolean removed) {
            this.isPropertyBoxHeightRemoved = removed;
        }

        private Boolean isPropertyBoxWidthRemoved;

        public Boolean getIsPropertyBoxWidthRemoved() {
            return this.isPropertyBoxWidthRemoved;
        }

        public void setIsPropertyBoxWidthRemoved(Boolean removed) {
            this.isPropertyBoxWidthRemoved = removed;
        }

        private Boolean isPropertyDimensionUomIdRemoved;

        public Boolean getIsPropertyDimensionUomIdRemoved() {
            return this.isPropertyDimensionUomIdRemoved;
        }

        public void setIsPropertyDimensionUomIdRemoved(Boolean removed) {
            this.isPropertyDimensionUomIdRemoved = removed;
        }

        private Boolean isPropertyWeightRemoved;

        public Boolean getIsPropertyWeightRemoved() {
            return this.isPropertyWeightRemoved;
        }

        public void setIsPropertyWeightRemoved(Boolean removed) {
            this.isPropertyWeightRemoved = removed;
        }

        private Boolean isPropertyWeightUomIdRemoved;

        public Boolean getIsPropertyWeightUomIdRemoved() {
            return this.isPropertyWeightUomIdRemoved;
        }

        public void setIsPropertyWeightUomIdRemoved(Boolean removed) {
            this.isPropertyWeightUomIdRemoved = removed;
        }

        private Boolean isPropertyInsuredValueRemoved;

        public Boolean getIsPropertyInsuredValueRemoved() {
            return this.isPropertyInsuredValueRemoved;
        }

        public void setIsPropertyInsuredValueRemoved(Boolean removed) {
            this.isPropertyInsuredValueRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<ShipmentPackageContentEventId, ShipmentPackageContentEvent> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentEvent>();
        
        private Iterable<ShipmentPackageContentEvent> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentEvent> getShipmentPackageContentEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentEventDao eventDao = getShipmentPackageContentEventDao();
                List<ShipmentPackageContentEvent> eL = new ArrayList<ShipmentPackageContentEvent>();
                for (ShipmentPackageContentEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    ((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).setEventReadOnly(true);
                    eL.add((ShipmentPackageContentEvent)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentEvent> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentEvent e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentEvent e)
        {
            throwOnInconsistentEventIds((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e);
            this.shipmentPackageContentEvents.put(((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentEvent e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentPackageStateDeleted extends AbstractShipmentPackageStateEvent implements ShipmentPackageEvent.ShipmentPackageStateDeleted, Saveable
    {
        public AbstractShipmentPackageStateDeleted() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateDeleted(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<ShipmentPackageContentEventId, ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved>();
        
        private Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> getShipmentPackageContentEvents()
        {
            if (!getEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentEventDao eventDao = getShipmentPackageContentEventDao();
                List<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> eL = new ArrayList<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved>();
                for (ShipmentPackageContentEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    ((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).setEventReadOnly(true);
                    eL.add((ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e)
        {
            throwOnInconsistentEventIds((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e);
            this.shipmentPackageContentEvents.put(((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)e).getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentEventDao().save(e);
            }
        }
    }
    public static class SimpleShipmentPackageStateCreated extends AbstractShipmentPackageStateCreated
    {
        public SimpleShipmentPackageStateCreated() {
        }

        public SimpleShipmentPackageStateCreated(ShipmentPackageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentPackageStateMergePatched extends AbstractShipmentPackageStateMergePatched
    {
        public SimpleShipmentPackageStateMergePatched() {
        }

        public SimpleShipmentPackageStateMergePatched(ShipmentPackageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentPackageStateDeleted extends AbstractShipmentPackageStateDeleted
    {
        public SimpleShipmentPackageStateDeleted() {
        }

        public SimpleShipmentPackageStateDeleted(ShipmentPackageEventId eventId) {
            super(eventId);
        }
    }

}

