package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.InventoryItemStateEvent.*;

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

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
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
            this.setInventoryItemId(((InventoryItemStateEvent) events.get(0)).getStateEventId().getInventoryItemId());
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

        this.setQuantityOnHand(e.getQuantityOnHand());
        this.setQuantityReserved(e.getQuantityReserved());
        this.setQuantityOccupied(e.getQuantityOccupied());
        this.setQuantityVirtual(e.getQuantityVirtual());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated innerEvent : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryState innerState = this.getEntries().get(innerEvent.getStateEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(InventoryItemStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getQuantityOnHand() == null)
        {
            if (e.getIsPropertyQuantityOnHandRemoved() != null && e.getIsPropertyQuantityOnHandRemoved())
            {
                this.setQuantityOnHand(null);
            }
        }
        else
        {
            this.setQuantityOnHand(e.getQuantityOnHand());
        }
        if (e.getQuantityReserved() == null)
        {
            if (e.getIsPropertyQuantityReservedRemoved() != null && e.getIsPropertyQuantityReservedRemoved())
            {
                this.setQuantityReserved(null);
            }
        }
        else
        {
            this.setQuantityReserved(e.getQuantityReserved());
        }
        if (e.getQuantityOccupied() == null)
        {
            if (e.getIsPropertyQuantityOccupiedRemoved() != null && e.getIsPropertyQuantityOccupiedRemoved())
            {
                this.setQuantityOccupied(null);
            }
        }
        else
        {
            this.setQuantityOccupied(e.getQuantityOccupied());
        }
        if (e.getQuantityVirtual() == null)
        {
            if (e.getIsPropertyQuantityVirtualRemoved() != null && e.getIsPropertyQuantityVirtualRemoved())
            {
                this.setQuantityVirtual(null);
            }
        }
        else
        {
            this.setQuantityVirtual(e.getQuantityVirtual());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (InventoryItemEntryStateEvent innerEvent : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryState innerState = this.getEntries().get(innerEvent.getStateEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void save()
    {
        entries.save();

    }

    protected void throwOnWrongEvent(InventoryItemStateEvent stateEvent)
    {
        InventoryItemId stateEntityId = this.getInventoryItemId(); // Aggregate Id
        InventoryItemId eventEntityId = stateEvent.getStateEventId().getInventoryItemId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
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

