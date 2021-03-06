package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attribute.AttributeValueEvent.*;

public abstract class AbstractAttributeValueState implements AttributeValueState
{

    private AttributeValueId attributeValueId = new AttributeValueId();

    public AttributeValueId getAttributeValueId() {
        return this.attributeValueId;
    }

    public void setAttributeValueId(AttributeValueId attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public String getAttributeId() {
        return this.getAttributeValueId().getAttributeId();
    }
        
    public void setAttributeId(String attributeId) {
        this.getAttributeValueId().setAttributeId(attributeId);
    }

    public String getValue() {
        return this.getAttributeValueId().getValue();
    }
        
    public void setValue(String value) {
        this.getAttributeValueId().setValue(value);
    }

    private String attributeValueName;

    public String getAttributeValueName()
    {
        return this.attributeValueName;
    }

    public void setAttributeValueName(String attributeValueName)
    {
        this.attributeValueName = attributeValueName;
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


    public AbstractAttributeValueState() {
        this(false);
    }

    public AbstractAttributeValueState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof AttributeValueStateCreated) {
            when((AttributeValueStateCreated) e);
        } else if (e instanceof AttributeValueStateMergePatched) {
            when((AttributeValueStateMergePatched) e);
        } else if (e instanceof AttributeValueStateRemoved) {
            when((AttributeValueStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(AttributeValueStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setAttributeValueName(e.getAttributeValueName());
        this.setDescription(e.getDescription());
        this.setReferenceId(e.getReferenceId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(AttributeValueStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getAttributeValueName() == null)
        {
            if (e.getIsPropertyAttributeValueNameRemoved() != null && e.getIsPropertyAttributeValueNameRemoved())
            {
                this.setAttributeValueName(null);
            }
        }
        else
        {
            this.setAttributeValueName(e.getAttributeValueName());
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

    public void when(AttributeValueStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(AttributeValueEvent event)
    {
        String stateEntityIdAttributeId = this.getAttributeValueId().getAttributeId();
        String eventEntityIdAttributeId = event.getAttributeValueEventId().getAttributeId();
        if (!stateEntityIdAttributeId.equals(eventEntityIdAttributeId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeId %1$s in state but entity id AttributeId %2$s in event", stateEntityIdAttributeId, eventEntityIdAttributeId);
        }

        String stateEntityIdValue = this.getAttributeValueId().getValue();
        String eventEntityIdValue = event.getAttributeValueEventId().getValue();
        if (!stateEntityIdValue.equals(eventEntityIdValue))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id Value %1$s in state but entity id Value %2$s in event", stateEntityIdValue, eventEntityIdValue);
        }

        if (getForReapplying()) { return; }

        AttributeValueStateEvent stateEvent = event instanceof AttributeValueStateEvent ? (AttributeValueStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? AttributeValueState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(AttributeValueState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleAttributeValueState extends AbstractAttributeValueState
    {

        public SimpleAttributeValueState() {
        }

        public SimpleAttributeValueState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

