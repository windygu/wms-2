package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleEvent.*;

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

    private InventoryItemId triggerInventoryItemId;

    public InventoryItemId getTriggerInventoryItemId()
    {
        return this.triggerInventoryItemId;
    }

    public void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId)
    {
        this.triggerInventoryItemId = triggerInventoryItemId;
    }

    private InventoryItemId outputInventoryItemId;

    public InventoryItemId getOutputInventoryItemId()
    {
        return this.outputInventoryItemId;
    }

    public void setOutputInventoryItemId(InventoryItemId outputInventoryItemId)
    {
        this.outputInventoryItemId = outputInventoryItemId;
    }

    private String triggerAccountName;

    public String getTriggerAccountName()
    {
        return this.triggerAccountName;
    }

    public void setTriggerAccountName(String triggerAccountName)
    {
        this.triggerAccountName = triggerAccountName;
    }

    private String outputAccountName;

    public String getOutputAccountName()
    {
        return this.outputAccountName;
    }

    public void setOutputAccountName(String outputAccountName)
    {
        this.outputAccountName = outputAccountName;
    }

    private Boolean isOutputNegated;

    public Boolean getIsOutputNegated()
    {
        return this.isOutputNegated;
    }

    public void setIsOutputNegated(Boolean isOutputNegated)
    {
        this.isOutputNegated = isOutputNegated;
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
            this.setInventoryPostingRuleId(((InventoryPostingRuleEvent) events.get(0)).getInventoryPostingRuleEventId().getInventoryPostingRuleId());
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

        this.setTriggerInventoryItemId(e.getTriggerInventoryItemId());
        this.setOutputInventoryItemId(e.getOutputInventoryItemId());
        this.setTriggerAccountName(e.getTriggerAccountName());
        this.setOutputAccountName(e.getOutputAccountName());
        this.setIsOutputNegated(e.getIsOutputNegated());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InventoryPostingRuleStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getTriggerInventoryItemId() == null)
        {
            if (e.getIsPropertyTriggerInventoryItemIdRemoved() != null && e.getIsPropertyTriggerInventoryItemIdRemoved())
            {
                this.setTriggerInventoryItemId(null);
            }
        }
        else
        {
            this.setTriggerInventoryItemId(e.getTriggerInventoryItemId());
        }
        if (e.getOutputInventoryItemId() == null)
        {
            if (e.getIsPropertyOutputInventoryItemIdRemoved() != null && e.getIsPropertyOutputInventoryItemIdRemoved())
            {
                this.setOutputInventoryItemId(null);
            }
        }
        else
        {
            this.setOutputInventoryItemId(e.getOutputInventoryItemId());
        }
        if (e.getTriggerAccountName() == null)
        {
            if (e.getIsPropertyTriggerAccountNameRemoved() != null && e.getIsPropertyTriggerAccountNameRemoved())
            {
                this.setTriggerAccountName(null);
            }
        }
        else
        {
            this.setTriggerAccountName(e.getTriggerAccountName());
        }
        if (e.getOutputAccountName() == null)
        {
            if (e.getIsPropertyOutputAccountNameRemoved() != null && e.getIsPropertyOutputAccountNameRemoved())
            {
                this.setOutputAccountName(null);
            }
        }
        else
        {
            this.setOutputAccountName(e.getOutputAccountName());
        }
        if (e.getIsOutputNegated() == null)
        {
            if (e.getIsPropertyIsOutputNegatedRemoved() != null && e.getIsPropertyIsOutputNegatedRemoved())
            {
                this.setIsOutputNegated(null);
            }
        }
        else
        {
            this.setIsOutputNegated(e.getIsOutputNegated());
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

    protected void throwOnWrongEvent(InventoryPostingRuleEvent stateEvent)
    {
        String stateEntityId = this.getInventoryPostingRuleId(); // Aggregate Id
        String eventEntityId = stateEvent.getInventoryPostingRuleEventId().getInventoryPostingRuleId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getInventoryPostingRuleEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getInventoryPostingRuleEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryPostingRuleState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
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

