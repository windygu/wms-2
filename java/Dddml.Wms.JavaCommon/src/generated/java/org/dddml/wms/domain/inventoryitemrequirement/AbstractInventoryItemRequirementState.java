package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEvent.*;

public abstract class AbstractInventoryItemRequirementState implements InventoryItemRequirementState.SqlInventoryItemRequirementState, Saveable
{

    private InventoryItemId inventoryItemRequirementId;

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
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

    private EntityStateCollection<Long, InventoryItemRequirementEntryState> entries;

    public EntityStateCollection<Long, InventoryItemRequirementEntryState> getEntries()
    {
        return this.entries;
    }

    public void setEntries(EntityStateCollection<Long, InventoryItemRequirementEntryState> entries)
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

    public AbstractInventoryItemRequirementState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryItemRequirementId(((InventoryItemRequirementEvent.SqlInventoryItemRequirementEvent) events.get(0)).getInventoryItemRequirementEventId().getInventoryItemRequirementId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInventoryItemRequirementState() {
        this(false);
    }

    public AbstractInventoryItemRequirementState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        entries = new SimpleInventoryItemRequirementEntryStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemRequirementStateCreated) {
            when((InventoryItemRequirementStateCreated) e);
        } else if (e instanceof InventoryItemRequirementStateMergePatched) {
            when((InventoryItemRequirementStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemRequirementStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated innerEvent : e.getInventoryItemRequirementEntryEvents()) {
            InventoryItemRequirementEntryState innerState = this.getEntries().get(((InventoryItemRequirementEntryEvent.SqlInventoryItemRequirementEntryEvent)innerEvent).getInventoryItemRequirementEntryEventId().getEntrySeqId());
            ((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)innerState).mutate(innerEvent);
        }
    }

    public void when(InventoryItemRequirementStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (InventoryItemRequirementEntryEvent innerEvent : e.getInventoryItemRequirementEntryEvents()) {
            InventoryItemRequirementEntryState innerState = this.getEntries().get(((InventoryItemRequirementEntryEvent.SqlInventoryItemRequirementEntryEvent)innerEvent).getInventoryItemRequirementEntryEventId().getEntrySeqId());
            ((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)innerState).mutate(innerEvent);
        }
    }

    public void save()
    {
        ((Saveable)entries).save();

    }

    protected void throwOnWrongEvent(InventoryItemRequirementEvent event)
    {
        InventoryItemId stateEntityId = this.getInventoryItemRequirementId(); // Aggregate Id
        InventoryItemId eventEntityId = ((InventoryItemRequirementEvent.SqlInventoryItemRequirementEvent)event).getInventoryItemRequirementEventId().getInventoryItemRequirementId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((InventoryItemRequirementEvent.SqlInventoryItemRequirementEvent)event).getInventoryItemRequirementEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getInventoryItemRequirementEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemRequirementState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryItemRequirementState extends AbstractInventoryItemRequirementState
    {

        public SimpleInventoryItemRequirementState() {
        }

        public SimpleInventoryItemRequirementState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryItemRequirementState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleInventoryItemRequirementEntryStateCollection extends AbstractInventoryItemRequirementEntryStateCollection
    {
        public SimpleInventoryItemRequirementEntryStateCollection(AbstractInventoryItemRequirementState outerState)
        {
            super(outerState);
        }
    }


}

