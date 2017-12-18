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

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityInTransit;

    public BigDecimal getQuantityInTransit()
    {
        return this.quantityInTransit;
    }

    public void setQuantityInTransit(BigDecimal quantityInTransit)
    {
        this.quantityInTransit = quantityInTransit;
    }

    private BigDecimal quantityReserved;

    public BigDecimal getQuantityReserved()
    {
        return this.quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved)
    {
        this.quantityReserved = quantityReserved;
    }

    private BigDecimal quantityOccupied;

    public BigDecimal getQuantityOccupied()
    {
        return this.quantityOccupied;
    }

    public void setQuantityOccupied(BigDecimal quantityOccupied)
    {
        this.quantityOccupied = quantityOccupied;
    }

    private BigDecimal quantityVirtual;

    public BigDecimal getQuantityVirtual()
    {
        return this.quantityVirtual;
    }

    public void setQuantityVirtual(BigDecimal quantityVirtual)
    {
        this.quantityVirtual = quantityVirtual;
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

        private Boolean isPropertyQuantityOnHandRemoved;

        public Boolean getIsPropertyQuantityOnHandRemoved() {
            return this.isPropertyQuantityOnHandRemoved;
        }

        public void setIsPropertyQuantityOnHandRemoved(Boolean removed) {
            this.isPropertyQuantityOnHandRemoved = removed;
        }

        private Boolean isPropertyQuantityInTransitRemoved;

        public Boolean getIsPropertyQuantityInTransitRemoved() {
            return this.isPropertyQuantityInTransitRemoved;
        }

        public void setIsPropertyQuantityInTransitRemoved(Boolean removed) {
            this.isPropertyQuantityInTransitRemoved = removed;
        }

        private Boolean isPropertyQuantityReservedRemoved;

        public Boolean getIsPropertyQuantityReservedRemoved() {
            return this.isPropertyQuantityReservedRemoved;
        }

        public void setIsPropertyQuantityReservedRemoved(Boolean removed) {
            this.isPropertyQuantityReservedRemoved = removed;
        }

        private Boolean isPropertyQuantityOccupiedRemoved;

        public Boolean getIsPropertyQuantityOccupiedRemoved() {
            return this.isPropertyQuantityOccupiedRemoved;
        }

        public void setIsPropertyQuantityOccupiedRemoved(Boolean removed) {
            this.isPropertyQuantityOccupiedRemoved = removed;
        }

        private Boolean isPropertyQuantityVirtualRemoved;

        public Boolean getIsPropertyQuantityVirtualRemoved() {
            return this.isPropertyQuantityVirtualRemoved;
        }

        public void setIsPropertyQuantityVirtualRemoved(Boolean removed) {
            this.isPropertyQuantityVirtualRemoved = removed;
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

