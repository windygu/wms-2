package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentPackageStateEvent extends AbstractStateEvent implements ShipmentPackageStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractShipmentPackageStateEvent() {
    }

    protected AbstractShipmentPackageStateEvent(ShipmentPackageEventId eventId) {
        this.shipmentPackageEventId = eventId;
    }

    protected ShipmentPackageContentStateEventDao getShipmentPackageContentStateEventDao() {
        return (ShipmentPackageContentStateEventDao)ApplicationContext.current.get("ShipmentPackageContentStateEventDao");
    }

    protected ShipmentPackageContentEventId newShipmentPackageContentEventId(String shipmentItemSeqId)
    {
        ShipmentPackageContentEventId eventId = new ShipmentPackageContentEventId(this.getShipmentPackageEventId().getShipmentPackageId(), 
            shipmentItemSeqId, 
            this.getShipmentPackageEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(ShipmentPackageContentStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(ShipmentPackageStateEvent oe, ShipmentPackageContentStateEvent e)
    {
        if (!oe.getShipmentPackageEventId().getShipmentPackageId().equals(e.getShipmentPackageContentEventId().getShipmentPackageId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipmentPackageId %1$s but inner id ShipmentPackageId %2$s", 
                oe.getShipmentPackageEventId().getShipmentPackageId(), e.getShipmentPackageContentEventId().getShipmentPackageId());
        }
    }

    public ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateCreated(newShipmentPackageContentEventId(shipmentItemSeqId));
    }

    public ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched newShipmentPackageContentStateMergePatched(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateMergePatched(newShipmentPackageContentEventId(shipmentItemSeqId));
    }

    public ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId) {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateRemoved(newShipmentPackageContentEventId(shipmentItemSeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentPackageStateCreated extends AbstractShipmentPackageStateEvent implements ShipmentPackageStateEvent.ShipmentPackageStateCreated, Saveable
    {
        public AbstractShipmentPackageStateCreated() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateCreated(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated>();
        
        private Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> getShipmentPackageContentEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentStateEventDao eventDao = getShipmentPackageContentStateEventDao();
                List<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> eL = new ArrayList<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated>();
                for (ShipmentPackageContentStateEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentPackageContentEvents.put(e.getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentPackageStateMergePatched extends AbstractShipmentPackageStateEvent implements ShipmentPackageStateEvent.ShipmentPackageStateMergePatched, Saveable
    {
        public AbstractShipmentPackageStateMergePatched() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateMergePatched(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

        private Map<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent>();
        
        private Iterable<ShipmentPackageContentStateEvent> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentStateEvent> getShipmentPackageContentEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentStateEventDao eventDao = getShipmentPackageContentStateEventDao();
                List<ShipmentPackageContentStateEvent> eL = new ArrayList<ShipmentPackageContentStateEvent>();
                for (ShipmentPackageContentStateEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentPackageContentStateEvent)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentStateEvent> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentStateEvent e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentPackageContentEvents.put(e.getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentStateEvent e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractShipmentPackageStateDeleted extends AbstractShipmentPackageStateEvent implements ShipmentPackageStateEvent.ShipmentPackageStateDeleted, Saveable
    {
        public AbstractShipmentPackageStateDeleted() {
            this(new ShipmentPackageEventId());
        }

        public AbstractShipmentPackageStateDeleted(ShipmentPackageEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> shipmentPackageContentEvents = new HashMap<ShipmentPackageContentEventId, ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved>();
        
        private Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> readOnlyShipmentPackageContentEvents;

        public Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> getShipmentPackageContentEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.shipmentPackageContentEvents.values();
            }
            else
            {
                if (readOnlyShipmentPackageContentEvents != null) { return readOnlyShipmentPackageContentEvents; }
                ShipmentPackageContentStateEventDao eventDao = getShipmentPackageContentStateEventDao();
                List<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> eL = new ArrayList<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved>();
                for (ShipmentPackageContentStateEvent e : eventDao.findByShipmentPackageEventId(this.getShipmentPackageEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved)e);
                }
                return (readOnlyShipmentPackageContentEvents = eL);
            }
        }

        public void setShipmentPackageContentEvents(Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> es)
        {
            if (es != null)
            {
                for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved e : es)
                {
                    addShipmentPackageContentEvent(e);
                }
            }
            else { this.shipmentPackageContentEvents.clear(); }
        }
        
        public void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.shipmentPackageContentEvents.put(e.getShipmentPackageContentEventId(), e);
        }

        public void save()
        {
            for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved e : this.getShipmentPackageContentEvents()) {
                getShipmentPackageContentStateEventDao().save(e);
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

