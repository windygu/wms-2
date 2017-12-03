package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleStateEvent.*;

public abstract class AbstractInventoryPostingRuleState implements InventoryPostingRuleState
{

    private String inventoryPostingRuleId;

    public String getInventoryPostingRuleId()
    {
        return this.inventoryPostingRuleId;
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
    }

    private InventoryItemId trigger;

    public InventoryItemId getTrigger()
    {
        return this.trigger;
    }

    public void setTrigger(InventoryItemId trigger)
    {
        this.trigger = trigger;
    }

    private InventoryItemId output;

    public InventoryItemId getOutput()
    {
        return this.output;
    }

    public void setOutput(InventoryItemId output)
    {
        this.output = output;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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

    public AbstractInventoryPostingRuleState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryPostingRuleId(((InventoryPostingRuleStateEvent) events.get(0)).getStateEventId().getInventoryPostingRuleId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInventoryPostingRuleState() {
        this(false);
    }

    public AbstractInventoryPostingRuleState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryPostingRuleStateCreated) {
            when((InventoryPostingRuleStateCreated) e);
        } else if (e instanceof InventoryPostingRuleStateMergePatched) {
            when((InventoryPostingRuleStateMergePatched) e);
        } else if (e instanceof InventoryPostingRuleStateDeleted) {
            when((InventoryPostingRuleStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryPostingRuleStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setTrigger(e.getTrigger());
        this.setOutput(e.getOutput());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InventoryPostingRuleStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getTrigger() == null)
        {
            if (e.getIsPropertyTriggerRemoved() != null && e.getIsPropertyTriggerRemoved())
            {
                this.setTrigger(null);
            }
        }
        else
        {
            this.setTrigger(e.getTrigger());
        }
        if (e.getOutput() == null)
        {
            if (e.getIsPropertyOutputRemoved() != null && e.getIsPropertyOutputRemoved())
            {
                this.setOutput(null);
            }
        }
        else
        {
            this.setOutput(e.getOutput());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(InventoryPostingRuleStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryPostingRuleStateEvent stateEvent)
    {
        String stateEntityId = this.getInventoryPostingRuleId(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getInventoryPostingRuleId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryPostingRuleState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryPostingRuleState extends AbstractInventoryPostingRuleState
    {

        public SimpleInventoryPostingRuleState() {
        }

        public SimpleInventoryPostingRuleState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryPostingRuleState(List<Event> events) {
            super(events);
        }

    }


}

