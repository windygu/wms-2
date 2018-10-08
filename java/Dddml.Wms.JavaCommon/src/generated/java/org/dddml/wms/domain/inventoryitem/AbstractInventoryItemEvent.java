package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryItemEvent extends AbstractEvent implements InventoryItemEvent.SqlInventoryItemEvent 
{
    private InventoryItemEventId inventoryItemEventId;

    public InventoryItemEventId getInventoryItemEventId() {
        return this.inventoryItemEventId;
    }

    public void setInventoryItemEventId(InventoryItemEventId eventId) {
        this.inventoryItemEventId = eventId;
    }
    
    public InventoryItemId getInventoryItemId() {
        return getInventoryItemEventId().getInventoryItemId();
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        getInventoryItemEventId().setInventoryItemId(inventoryItemId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getInventoryItemEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getInventoryItemEventId().setVersion(version);
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

    protected AbstractInventoryItemEvent() {
    }

    protected AbstractInventoryItemEvent(InventoryItemEventId eventId) {
        this.inventoryItemEventId = eventId;
    }

    protected InventoryItemEntryEventDao getInventoryItemEntryEventDao() {
        return (InventoryItemEntryEventDao)ApplicationContext.current.get("InventoryItemEntryEventDao");
    }

    protected InventoryItemEntryEventId newInventoryItemEntryEventId(Long entrySeqId)
    {
        InventoryItemEntryEventId eventId = new InventoryItemEntryEventId(this.getInventoryItemEventId().getInventoryItemId(), 
            entrySeqId, 
            this.getInventoryItemEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(InventoryItemEntryEvent.SqlInventoryItemEntryEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(InventoryItemEvent.SqlInventoryItemEvent oe, InventoryItemEntryEvent.SqlInventoryItemEntryEvent e)
    {
        if (!oe.getInventoryItemEventId().getInventoryItemId().equals(e.getInventoryItemEntryEventId().getInventoryItemId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id InventoryItemId %1$s but inner id InventoryItemId %2$s", 
                oe.getInventoryItemEventId().getInventoryItemId(), e.getInventoryItemEntryEventId().getInventoryItemId());
        }
    }

    public InventoryItemEntryEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId) {
        return new AbstractInventoryItemEntryEvent.SimpleInventoryItemEntryStateCreated(newInventoryItemEntryEventId(entrySeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryItemStateEvent extends AbstractInventoryItemEvent implements InventoryItemEvent.InventoryItemStateEvent {
        private BigDecimal onHandQuantity;

        public BigDecimal getOnHandQuantity()
        {
            return this.onHandQuantity;
        }

        public void setOnHandQuantity(BigDecimal onHandQuantity)
        {
            this.onHandQuantity = onHandQuantity;
        }

        private BigDecimal inTransitQuantity;

        public BigDecimal getInTransitQuantity()
        {
            return this.inTransitQuantity;
        }

        public void setInTransitQuantity(BigDecimal inTransitQuantity)
        {
            this.inTransitQuantity = inTransitQuantity;
        }

        private BigDecimal reservedQuantity;

        public BigDecimal getReservedQuantity()
        {
            return this.reservedQuantity;
        }

        public void setReservedQuantity(BigDecimal reservedQuantity)
        {
            this.reservedQuantity = reservedQuantity;
        }

        private BigDecimal occupiedQuantity;

        public BigDecimal getOccupiedQuantity()
        {
            return this.occupiedQuantity;
        }

        public void setOccupiedQuantity(BigDecimal occupiedQuantity)
        {
            this.occupiedQuantity = occupiedQuantity;
        }

        private BigDecimal virtualQuantity;

        public BigDecimal getVirtualQuantity()
        {
            return this.virtualQuantity;
        }

        public void setVirtualQuantity(BigDecimal virtualQuantity)
        {
            this.virtualQuantity = virtualQuantity;
        }

        protected AbstractInventoryItemStateEvent(InventoryItemEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractInventoryItemStateCreated extends AbstractInventoryItemStateEvent implements InventoryItemEvent.InventoryItemStateCreated, Saveable
    {
        public AbstractInventoryItemStateCreated() {
            this(new InventoryItemEventId());
        }

        public AbstractInventoryItemStateCreated(InventoryItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<InventoryItemEntryEventId, InventoryItemEntryEvent.InventoryItemEntryStateCreated> inventoryItemEntryEvents = new HashMap<InventoryItemEntryEventId, InventoryItemEntryEvent.InventoryItemEntryStateCreated>();
        
        private Iterable<InventoryItemEntryEvent.InventoryItemEntryStateCreated> readOnlyInventoryItemEntryEvents;

        public Iterable<InventoryItemEntryEvent.InventoryItemEntryStateCreated> getInventoryItemEntryEvents()
        {
            if (!getEventReadOnly())
            {
                return this.inventoryItemEntryEvents.values();
            }
            else
            {
                if (readOnlyInventoryItemEntryEvents != null) { return readOnlyInventoryItemEntryEvents; }
                InventoryItemEntryEventDao eventDao = getInventoryItemEntryEventDao();
                List<InventoryItemEntryEvent.InventoryItemEntryStateCreated> eL = new ArrayList<InventoryItemEntryEvent.InventoryItemEntryStateCreated>();
                for (InventoryItemEntryEvent e : eventDao.findByInventoryItemEventId(this.getInventoryItemEventId()))
                {
                    ((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e).setEventReadOnly(true);
                    eL.add((InventoryItemEntryEvent.InventoryItemEntryStateCreated)e);
                }
                return (readOnlyInventoryItemEntryEvents = eL);
            }
        }

        public void setInventoryItemEntryEvents(Iterable<InventoryItemEntryEvent.InventoryItemEntryStateCreated> es)
        {
            if (es != null)
            {
                for (InventoryItemEntryEvent.InventoryItemEntryStateCreated e : es)
                {
                    addInventoryItemEntryEvent(e);
                }
            }
            else { this.inventoryItemEntryEvents.clear(); }
        }
        
        public void addInventoryItemEntryEvent(InventoryItemEntryEvent.InventoryItemEntryStateCreated e)
        {
            throwOnInconsistentEventIds((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e);
            this.inventoryItemEntryEvents.put(((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e).getInventoryItemEntryEventId(), e);
        }

        public void save()
        {
            for (InventoryItemEntryEvent.InventoryItemEntryStateCreated e : this.getInventoryItemEntryEvents()) {
                getInventoryItemEntryEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractInventoryItemStateMergePatched extends AbstractInventoryItemStateEvent implements InventoryItemEvent.InventoryItemStateMergePatched, Saveable
    {
        public AbstractInventoryItemStateMergePatched() {
            this(new InventoryItemEventId());
        }

        public AbstractInventoryItemStateMergePatched(InventoryItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyOnHandQuantityRemoved;

        public Boolean getIsPropertyOnHandQuantityRemoved() {
            return this.isPropertyOnHandQuantityRemoved;
        }

        public void setIsPropertyOnHandQuantityRemoved(Boolean removed) {
            this.isPropertyOnHandQuantityRemoved = removed;
        }

        private Boolean isPropertyInTransitQuantityRemoved;

        public Boolean getIsPropertyInTransitQuantityRemoved() {
            return this.isPropertyInTransitQuantityRemoved;
        }

        public void setIsPropertyInTransitQuantityRemoved(Boolean removed) {
            this.isPropertyInTransitQuantityRemoved = removed;
        }

        private Boolean isPropertyReservedQuantityRemoved;

        public Boolean getIsPropertyReservedQuantityRemoved() {
            return this.isPropertyReservedQuantityRemoved;
        }

        public void setIsPropertyReservedQuantityRemoved(Boolean removed) {
            this.isPropertyReservedQuantityRemoved = removed;
        }

        private Boolean isPropertyOccupiedQuantityRemoved;

        public Boolean getIsPropertyOccupiedQuantityRemoved() {
            return this.isPropertyOccupiedQuantityRemoved;
        }

        public void setIsPropertyOccupiedQuantityRemoved(Boolean removed) {
            this.isPropertyOccupiedQuantityRemoved = removed;
        }

        private Boolean isPropertyVirtualQuantityRemoved;

        public Boolean getIsPropertyVirtualQuantityRemoved() {
            return this.isPropertyVirtualQuantityRemoved;
        }

        public void setIsPropertyVirtualQuantityRemoved(Boolean removed) {
            this.isPropertyVirtualQuantityRemoved = removed;
        }

        private Map<InventoryItemEntryEventId, InventoryItemEntryEvent> inventoryItemEntryEvents = new HashMap<InventoryItemEntryEventId, InventoryItemEntryEvent>();
        
        private Iterable<InventoryItemEntryEvent> readOnlyInventoryItemEntryEvents;

        public Iterable<InventoryItemEntryEvent> getInventoryItemEntryEvents()
        {
            if (!getEventReadOnly())
            {
                return this.inventoryItemEntryEvents.values();
            }
            else
            {
                if (readOnlyInventoryItemEntryEvents != null) { return readOnlyInventoryItemEntryEvents; }
                InventoryItemEntryEventDao eventDao = getInventoryItemEntryEventDao();
                List<InventoryItemEntryEvent> eL = new ArrayList<InventoryItemEntryEvent>();
                for (InventoryItemEntryEvent e : eventDao.findByInventoryItemEventId(this.getInventoryItemEventId()))
                {
                    ((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e).setEventReadOnly(true);
                    eL.add((InventoryItemEntryEvent)e);
                }
                return (readOnlyInventoryItemEntryEvents = eL);
            }
        }

        public void setInventoryItemEntryEvents(Iterable<InventoryItemEntryEvent> es)
        {
            if (es != null)
            {
                for (InventoryItemEntryEvent e : es)
                {
                    addInventoryItemEntryEvent(e);
                }
            }
            else { this.inventoryItemEntryEvents.clear(); }
        }
        
        public void addInventoryItemEntryEvent(InventoryItemEntryEvent e)
        {
            throwOnInconsistentEventIds((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e);
            this.inventoryItemEntryEvents.put(((InventoryItemEntryEvent.SqlInventoryItemEntryEvent)e).getInventoryItemEntryEventId(), e);
        }

        public void save()
        {
            for (InventoryItemEntryEvent e : this.getInventoryItemEntryEvents()) {
                getInventoryItemEntryEventDao().save(e);
            }
        }
    }


    public static class SimpleInventoryItemStateCreated extends AbstractInventoryItemStateCreated
    {
        public SimpleInventoryItemStateCreated() {
        }

        public SimpleInventoryItemStateCreated(InventoryItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryItemStateMergePatched extends AbstractInventoryItemStateMergePatched
    {
        public SimpleInventoryItemStateMergePatched() {
        }

        public SimpleInventoryItemStateMergePatched(InventoryItemEventId eventId) {
            super(eventId);
        }
    }

}

