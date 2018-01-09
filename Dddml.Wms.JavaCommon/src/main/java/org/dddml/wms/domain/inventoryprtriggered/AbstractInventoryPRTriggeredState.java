package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredStateEvent.*;

public abstract class AbstractInventoryPRTriggeredState implements InventoryPRTriggeredState
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
            this.setInventoryPRTriggeredId(((InventoryPRTriggeredStateEvent) events.get(0)).getStateEventId().getInventoryPRTriggeredId());
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

    protected void throwOnWrongEvent(InventoryPRTriggeredStateEvent stateEvent)
    {
        InventoryPRTriggeredId stateEntityId = this.getInventoryPRTriggeredId(); // Aggregate Id
        InventoryPRTriggeredId eventEntityId = stateEvent.getStateEventId().getInventoryPRTriggeredId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryPRTriggeredState.VERSION_NULL)) && !(eventVersion.compareTo(stateVersion) >= 0))
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

