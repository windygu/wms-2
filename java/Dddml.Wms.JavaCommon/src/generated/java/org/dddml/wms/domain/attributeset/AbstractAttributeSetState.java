package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributeset.AttributeSetEvent.*;

public abstract class AbstractAttributeSetState implements AttributeSetState, Saveable
{

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
    }

    private String attributeSetName;

    public String getAttributeSetName()
    {
        return this.attributeSetName;
    }

    public void setAttributeSetName(String attributeSetName)
    {
        this.attributeSetName = attributeSetName;
    }

    private String organizationId;

    public String getOrganizationId()
    {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String referenceId;

    public String getReferenceId()
    {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId)
    {
        this.referenceId = referenceId;
    }

    private Boolean isInstanceAttributeSet = true;

    public Boolean getIsInstanceAttributeSet()
    {
        return this.isInstanceAttributeSet;
    }

    public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet)
    {
        this.isInstanceAttributeSet = isInstanceAttributeSet;
    }

    private Boolean isMandatory = true;

    public Boolean getIsMandatory()
    {
        return this.isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory)
    {
        this.isMandatory = isMandatory;
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

    private AttributeUseStates attributeUses;

    public AttributeUseStates getAttributeUses()
    {
        return this.attributeUses;
    }

    public void setAttributeUses(AttributeUseStates attributeUses)
    {
        this.attributeUses = attributeUses;
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

    public AbstractAttributeSetState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setAttributeSetId(((AttributeSetEvent) events.get(0)).getAttributeSetEventId().getAttributeSetId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractAttributeSetState() {
        this(false);
    }

    public AbstractAttributeSetState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        attributeUses = new SimpleAttributeUseStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof AttributeSetStateCreated) {
            when((AttributeSetStateCreated) e);
        } else if (e instanceof AttributeSetStateMergePatched) {
            when((AttributeSetStateMergePatched) e);
        } else if (e instanceof AttributeSetStateDeleted) {
            when((AttributeSetStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(AttributeSetStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setAttributeSetName(e.getAttributeSetName());
        this.setOrganizationId(e.getOrganizationId());
        this.setDescription(e.getDescription());
        this.setReferenceId(e.getReferenceId());
        if(e.getIsInstanceAttributeSet() != null) { this.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet()); }
        if(e.getIsMandatory() != null) { this.setIsMandatory(e.getIsMandatory()); }
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (AttributeUseEvent.AttributeUseStateCreated innerEvent : e.getAttributeUseEvents()) {
            AttributeUseState innerState = this.getAttributeUses().get(innerEvent.getAttributeUseEventId().getAttributeId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(AttributeSetStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getAttributeSetName() == null)
        {
            if (e.getIsPropertyAttributeSetNameRemoved() != null && e.getIsPropertyAttributeSetNameRemoved())
            {
                this.setAttributeSetName(null);
            }
        }
        else
        {
            this.setAttributeSetName(e.getAttributeSetName());
        }
        if (e.getOrganizationId() == null)
        {
            if (e.getIsPropertyOrganizationIdRemoved() != null && e.getIsPropertyOrganizationIdRemoved())
            {
                this.setOrganizationId(null);
            }
        }
        else
        {
            this.setOrganizationId(e.getOrganizationId());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getReferenceId() == null)
        {
            if (e.getIsPropertyReferenceIdRemoved() != null && e.getIsPropertyReferenceIdRemoved())
            {
                this.setReferenceId(null);
            }
        }
        else
        {
            this.setReferenceId(e.getReferenceId());
        }
        if (e.getIsInstanceAttributeSet() == null)
        {
            if (e.getIsPropertyIsInstanceAttributeSetRemoved() != null && e.getIsPropertyIsInstanceAttributeSetRemoved())
            {
                this.setIsInstanceAttributeSet(null);
            }
        }
        else
        {
            this.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet());
        }
        if (e.getIsMandatory() == null)
        {
            if (e.getIsPropertyIsMandatoryRemoved() != null && e.getIsPropertyIsMandatoryRemoved())
            {
                this.setIsMandatory(null);
            }
        }
        else
        {
            this.setIsMandatory(e.getIsMandatory());
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

        for (AttributeUseEvent innerEvent : e.getAttributeUseEvents()) {
            AttributeUseState innerState = this.getAttributeUses().get(innerEvent.getAttributeUseEventId().getAttributeId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof AttributeUseEvent.AttributeUseStateRemoved)
            {
                //AttributeUseEvent.AttributeUseStateRemoved removed = (AttributeUseEvent.AttributeUseStateRemoved)innerEvent;
                this.getAttributeUses().remove(innerState);
            }
        }
    }

    public void when(AttributeSetStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (AttributeUseState innerState : this.getAttributeUses())
        {
            this.getAttributeUses().remove(innerState);
        
            AttributeUseEvent.AttributeUseStateRemoved innerE = e.newAttributeUseStateRemoved(innerState.getAttributeId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addAttributeUseEvent(innerE);
        }
    }

    public void save()
    {
        attributeUses.save();

    }

    protected void throwOnWrongEvent(AttributeSetEvent event)
    {
        String stateEntityId = this.getAttributeSetId(); // Aggregate Id
        String eventEntityId = event.getAttributeSetEventId().getAttributeSetId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getAttributeSetEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getAttributeSetEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(AttributeSetState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleAttributeSetState extends AbstractAttributeSetState
    {

        public SimpleAttributeSetState() {
        }

        public SimpleAttributeSetState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleAttributeSetState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleAttributeUseStates extends AbstractAttributeUseStates
    {
        public SimpleAttributeUseStates(AbstractAttributeSetState outerState)
        {
            super(outerState);
        }
    }


}

