package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEvent.*;

public abstract class AbstractSellableInventoryItemState implements SellableInventoryItemState, Saveable
{

    private InventoryItemId sellableInventoryItemId;

    public InventoryItemId getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
    }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
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

    private EntityStateCollection<Long, SellableInventoryItemEntryState> entries;

    public EntityStateCollection<Long, SellableInventoryItemEntryState> getEntries()
    {
        return this.entries;
    }

    public void setEntries(EntityStateCollection<Long, SellableInventoryItemEntryState> entries)
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

    private String commandId;

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public AbstractSellableInventoryItemState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setSellableInventoryItemId(((SellableInventoryItemEvent) events.get(0)).getSellableInventoryItemEventId().getSellableInventoryItemId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractSellableInventoryItemState() {
        this(false);
    }

    public AbstractSellableInventoryItemState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        entries = new SimpleSellableInventoryItemEntryStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof SellableInventoryItemStateCreated) {
            when((SellableInventoryItemStateCreated) e);
        } else if (e instanceof SellableInventoryItemStateMergePatched) {
            when((SellableInventoryItemStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(SellableInventoryItemStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setSellableQuantity(e.getSellableQuantity());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated innerEvent : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryState innerState = this.getEntries().get(innerEvent.getSellableInventoryItemEntryEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(SellableInventoryItemStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getSellableQuantity() == null)
        {
            if (e.getIsPropertySellableQuantityRemoved() != null && e.getIsPropertySellableQuantityRemoved())
            {
                this.setSellableQuantity(null);
            }
        }
        else
        {
            this.setSellableQuantity(e.getSellableQuantity());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (SellableInventoryItemEntryEvent innerEvent : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryState innerState = this.getEntries().get(innerEvent.getSellableInventoryItemEntryEventId().getEntrySeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void save()
    {
        ((Saveable)entries).save();

    }

    protected void throwOnWrongEvent(SellableInventoryItemEvent event)
    {
        InventoryItemId stateEntityId = this.getSellableInventoryItemId(); // Aggregate Id
        InventoryItemId eventEntityId = event.getSellableInventoryItemEventId().getSellableInventoryItemId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getSellableInventoryItemEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getSellableInventoryItemEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(SellableInventoryItemState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleSellableInventoryItemState extends AbstractSellableInventoryItemState
    {

        public SimpleSellableInventoryItemState() {
        }

        public SimpleSellableInventoryItemState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleSellableInventoryItemState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleSellableInventoryItemEntryStateCollection extends AbstractSellableInventoryItemEntryStateCollection
    {
        public SimpleSellableInventoryItemEntryStateCollection(AbstractSellableInventoryItemState outerState)
        {
            super(outerState);
        }
    }


}

