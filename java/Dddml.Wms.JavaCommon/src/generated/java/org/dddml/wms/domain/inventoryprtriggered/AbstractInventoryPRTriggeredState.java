package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredEvent.*;

public abstract class AbstractInventoryPRTriggeredState implements InventoryPRTriggeredState.SqlInventoryPRTriggeredState
{

    private InventoryPRTriggeredId inventoryPRTriggeredId;

    public InventoryPRTriggeredId getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
    }

    private Boolean isProcessed;

    public Boolean getIsProcessed()
    {
        return this.isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed)
    {
        this.isProcessed = isProcessed;
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

    public AbstractInventoryPRTriggeredState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryPRTriggeredId(((InventoryPRTriggeredEvent.SqlInventoryPRTriggeredEvent) events.get(0)).getInventoryPRTriggeredEventId().getInventoryPRTriggeredId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInventoryPRTriggeredState() {
        this(false);
    }

    public AbstractInventoryPRTriggeredState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getInventoryPRTriggeredId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getInventoryPRTriggeredId(), ((InventoryPRTriggeredState)obj).getInventoryPRTriggeredId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryPRTriggeredStateCreated) {
            when((InventoryPRTriggeredStateCreated) e);
        } else if (e instanceof InventoryPRTriggeredStateMergePatched) {
            when((InventoryPRTriggeredStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryPRTriggeredStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setIsProcessed(e.getIsProcessed());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(InventoryPRTriggeredState s) {
        if (s == this) {
            return;
        }
        this.setIsProcessed(s.getIsProcessed());
    }

    public void when(InventoryPRTriggeredStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getIsProcessed() == null)
        {
            if (e.getIsPropertyIsProcessedRemoved() != null && e.getIsPropertyIsProcessedRemoved())
            {
                this.setIsProcessed(null);
            }
        }
        else
        {
            this.setIsProcessed(e.getIsProcessed());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryPRTriggeredEvent event)
    {
        InventoryPRTriggeredId stateEntityId = this.getInventoryPRTriggeredId(); // Aggregate Id
        InventoryPRTriggeredId eventEntityId = ((InventoryPRTriggeredEvent.SqlInventoryPRTriggeredEvent)event).getInventoryPRTriggeredEventId().getInventoryPRTriggeredId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((InventoryPRTriggeredEvent.SqlInventoryPRTriggeredEvent)event).getInventoryPRTriggeredEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getInventoryPRTriggeredEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryPRTriggeredState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryPRTriggeredState extends AbstractInventoryPRTriggeredState
    {

        public SimpleInventoryPRTriggeredState() {
        }

        public SimpleInventoryPRTriggeredState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryPRTriggeredState(List<Event> events) {
            super(events);
        }

    }


}

