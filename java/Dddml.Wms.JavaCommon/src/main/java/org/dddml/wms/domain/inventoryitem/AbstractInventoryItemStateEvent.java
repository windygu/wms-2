package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemStateEvent extends AbstractStateEvent implements InventoryItemStateEvent 
{
    private InventoryItemStateEventId stateEventId;

    public InventoryItemStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(InventoryItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public InventoryItemId getInventoryItemId() {
        return getStateEventId().getInventoryItemId();
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        getStateEventId().setInventoryItemId(inventoryItemId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractInventoryItemStateEvent() {
    }

    protected AbstractInventoryItemStateEvent(InventoryItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected InventoryItemEntryStateEventDao getInventoryItemEntryStateEventDao() {
        return (InventoryItemEntryStateEventDao)ApplicationContext.current.get("InventoryItemEntryStateEventDao");
    }

    protected InventoryItemEntryStateEventId newInventoryItemEntryStateEventId(Long entrySeqId)
    {
        InventoryItemEntryStateEventId stateEventId = new InventoryItemEntryStateEventId(this.getStateEventId().getInventoryItemId(), 
            entrySeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(InventoryItemEntryStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(InventoryItemStateEvent oe, InventoryItemEntryStateEvent e)
    {
        if (!oe.getStateEventId().getInventoryItemId().equals(e.getStateEventId().getInventoryItemId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id InventoryItemId %1$s but inner id InventoryItemId %2$s", 
                oe.getStateEventId().getInventoryItemId(), e.getStateEventId().getInventoryItemId());
        }
    }

    public InventoryItemEntryStateEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId) {
        return new AbstractInventoryItemEntryStateEvent.SimpleInventoryItemEntryStateCreated(newInventoryItemEntryStateEventId(entrySeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemStateCreated extends AbstractInventoryItemStateEvent implements InventoryItemStateEvent.InventoryItemStateCreated, Saveable
    {
        public AbstractInventoryItemStateCreated() {
            this(new InventoryItemStateEventId());
        }

        public AbstractInventoryItemStateCreated(InventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<InventoryItemEntryStateEventId, InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> inventoryItemEntryEvents = new HashMap<InventoryItemEntryStateEventId, InventoryItemEntryStateEvent.InventoryItemEntryStateCreated>();
        
        private Iterable<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> readOnlyInventoryItemEntryEvents;

        public Iterable<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> getInventoryItemEntryEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.inventoryItemEntryEvents.values();
            }
            else
            {
                if (readOnlyInventoryItemEntryEvents != null) { return readOnlyInventoryItemEntryEvents; }
                InventoryItemEntryStateEventDao eventDao = getInventoryItemEntryStateEventDao();
                List<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> eL = new ArrayList<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated>();
                for (InventoryItemEntryStateEvent e : eventDao.findByInventoryItemStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((InventoryItemEntryStateEvent.InventoryItemEntryStateCreated)e);
                }
                return (readOnlyInventoryItemEntryEvents = eL);
            }
        }

        public void setInventoryItemEntryEvents(Iterable<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> es)
        {
            if (es != null)
            {
                for (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e : es)
                {
                    addInventoryItemEntryEvent(e);
                }
            }
            else { this.inventoryItemEntryEvents.clear(); }
        }
        
        public void addInventoryItemEntryEvent(InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemEntryEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e : this.getInventoryItemEntryEvents()) {
                getInventoryItemEntryStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractInventoryItemStateMergePatched extends AbstractInventoryItemStateEvent implements InventoryItemStateEvent.InventoryItemStateMergePatched, Saveable
    {
        public AbstractInventoryItemStateMergePatched() {
            this(new InventoryItemStateEventId());
        }

        public AbstractInventoryItemStateMergePatched(InventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
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

        private Map<InventoryItemEntryStateEventId, InventoryItemEntryStateEvent> inventoryItemEntryEvents = new HashMap<InventoryItemEntryStateEventId, InventoryItemEntryStateEvent>();
        
        private Iterable<InventoryItemEntryStateEvent> readOnlyInventoryItemEntryEvents;

        public Iterable<InventoryItemEntryStateEvent> getInventoryItemEntryEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.inventoryItemEntryEvents.values();
            }
            else
            {
                if (readOnlyInventoryItemEntryEvents != null) { return readOnlyInventoryItemEntryEvents; }
                InventoryItemEntryStateEventDao eventDao = getInventoryItemEntryStateEventDao();
                List<InventoryItemEntryStateEvent> eL = new ArrayList<InventoryItemEntryStateEvent>();
                for (InventoryItemEntryStateEvent e : eventDao.findByInventoryItemStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((InventoryItemEntryStateEvent)e);
                }
                return (readOnlyInventoryItemEntryEvents = eL);
            }
        }

        public void setInventoryItemEntryEvents(Iterable<InventoryItemEntryStateEvent> es)
        {
            if (es != null)
            {
                for (InventoryItemEntryStateEvent e : es)
                {
                    addInventoryItemEntryEvent(e);
                }
            }
            else { this.inventoryItemEntryEvents.clear(); }
        }
        
        public void addInventoryItemEntryEvent(InventoryItemEntryStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemEntryEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (InventoryItemEntryStateEvent e : this.getInventoryItemEntryEvents()) {
                getInventoryItemEntryStateEventDao().save(e);
            }
        }
    }


    public static class SimpleInventoryItemStateCreated extends AbstractInventoryItemStateCreated
    {
        public SimpleInventoryItemStateCreated() {
        }

        public SimpleInventoryItemStateCreated(InventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleInventoryItemStateMergePatched extends AbstractInventoryItemStateMergePatched
    {
        public SimpleInventoryItemStateMergePatched() {
        }

        public SimpleInventoryItemStateMergePatched(InventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

