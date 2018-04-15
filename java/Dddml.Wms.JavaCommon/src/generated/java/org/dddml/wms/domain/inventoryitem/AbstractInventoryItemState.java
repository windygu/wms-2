package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.InventoryItemEvent.*;

public abstract class AbstractInventoryItemState implements InventoryItemState, Saveable
{

    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private InventoryItemEntryStates entries;

    public InventoryItemEntryStates getEntries()
    {
        return this.entries;
    }

    public void setEntries(InventoryItemEntryStates entries)
    {
        this.entries = entries;
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

    public AbstractInventoryItemState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryItemId(((InventoryItemEvent) events.get(0)).getInventoryItemEventId().getInventoryItemId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInventoryItemState() {
        this(false);
    }

    public AbstractInventoryItemState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        entries = new SimpleInventoryItemEntryStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemStateCreated) {
            when((InventoryItemStateCreated) e);
        } else if (e instanceof InventoryItemStateMergePatched) {
            when((InventoryItemStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setOnHandQuantity(e.getOnHandQuantity());
        this.setInTransitQuantity(e.getInTransitQuantity());
        this.setReservedQuantity(e.getReservedQuantity());
        this.setOccupiedQuantity(e.getOccupiedQuantity());
        this.setVirtualQuantity(e.getVirtualQuantity());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (InventoryItemEntryEvent.InventoryItemEntryStateCreated innerEvent : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryState innerState = this.getEntries().get(innerEvent.getInventoryItemEntryEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(InventoryItemStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getOnHandQuantity() == null)
        {
            if (e.getIsPropertyOnHandQuantityRemoved() != null && e.getIsPropertyOnHandQuantityRemoved())
            {
                this.setOnHandQuantity(null);
            }
        }
        else
        {
            this.setOnHandQuantity(e.getOnHandQuantity());
        }
        if (e.getInTransitQuantity() == null)
        {
            if (e.getIsPropertyInTransitQuantityRemoved() != null && e.getIsPropertyInTransitQuantityRemoved())
            {
                this.setInTransitQuantity(null);
            }
        }
        else
        {
            this.setInTransitQuantity(e.getInTransitQuantity());
        }
        if (e.getReservedQuantity() == null)
        {
            if (e.getIsPropertyReservedQuantityRemoved() != null && e.getIsPropertyReservedQuantityRemoved())
            {
                this.setReservedQuantity(null);
            }
        }
        else
        {
            this.setReservedQuantity(e.getReservedQuantity());
        }
        if (e.getOccupiedQuantity() == null)
        {
            if (e.getIsPropertyOccupiedQuantityRemoved() != null && e.getIsPropertyOccupiedQuantityRemoved())
            {
                this.setOccupiedQuantity(null);
            }
        }
        else
        {
            this.setOccupiedQuantity(e.getOccupiedQuantity());
        }
        if (e.getVirtualQuantity() == null)
        {
            if (e.getIsPropertyVirtualQuantityRemoved() != null && e.getIsPropertyVirtualQuantityRemoved())
            {
                this.setVirtualQuantity(null);
            }
        }
        else
        {
            this.setVirtualQuantity(e.getVirtualQuantity());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (InventoryItemEntryEvent innerEvent : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryState innerState = this.getEntries().get(innerEvent.getInventoryItemEntryEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void save()
    {
        entries.save();

    }

    protected void throwOnWrongEvent(InventoryItemEvent stateEvent)
    {
        InventoryItemId stateEntityId = this.getInventoryItemId(); // Aggregate Id
        InventoryItemId eventEntityId = stateEvent.getInventoryItemEventId().getInventoryItemId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getInventoryItemEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getInventoryItemEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryItemState extends AbstractInventoryItemState
    {

        public SimpleInventoryItemState() {
        }

        public SimpleInventoryItemState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryItemState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleInventoryItemEntryStates extends AbstractInventoryItemEntryStates
    {
        public SimpleInventoryItemEntryStates(AbstractInventoryItemState outerState)
        {
            super(outerState);
        }
    }


}

