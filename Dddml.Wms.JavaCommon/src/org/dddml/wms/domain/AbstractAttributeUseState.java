package org.dddml.wms.domain;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.domain.AttributeUseStateEvent.*;

public abstract class AbstractAttributeUseState implements AttributeUseState
{

    private AttributeSetAttributeUseId attributeSetAttributeUseId = new AttributeSetAttributeUseId();

    public AttributeSetAttributeUseId getAttributeSetAttributeUseId() {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId) {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    private String attributeId;

    public String getAttributeId()
    {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId)
    {
        this.attributeId = attributeId;
    }

    private Integer sequenceNumber;

    public Integer getSequenceNumber()
    {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
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

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
    }

    public boolean isStateUnsaved() 
    {
        return VERSION_ZERO.equals(this.getVersion());
    }


    public AbstractAttributeUseState()
    {
        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        if (e instanceof AttributeUseStateCreated) {
            when((AttributeUseStateCreated) e);
        } else if (e instanceof AttributeUseStateMergePatched) {
            when((AttributeUseStateMergePatched) e);
        } else if (e instanceof AttributeUseStateRemoved) {
            when((AttributeUseStateRemoved) e);
        }
    }

    public void when(AttributeUseStateCreated e)
    {
        throwOnWrongEvent(e);
        this.setSequenceNumber(e.getSequenceNumber());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(AttributeUseStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getSequenceNumber() == null)
        {
            if (e.getIsPropertySequenceNumberRemoved() != null && e.getIsPropertySequenceNumberRemoved())
            {
                this.setSequenceNumber(null);
            }
        }
        else
        {
            this.setSequenceNumber(e.getSequenceNumber());
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

    public void when(AttributeUseStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    protected void throwOnWrongEvent(AttributeUseStateEvent stateEvent)
    {
        String stateEntityIdAttributeSetId = this.getAttributeSetAttributeUseId().getAttributeSetId();
        String eventEntityIdAttributeSetId = stateEvent.getStateEventId().getAttributeSetId();
        if (stateEntityIdAttributeSetId != eventEntityIdAttributeSetId)
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeSetId %1$s in state but entity id AttributeSetId %2$s in event", stateEntityIdAttributeSetId, eventEntityIdAttributeSetId);
        }

        String stateEntityIdAttributeId = this.getAttributeSetAttributeUseId().getAttributeId();
        String eventEntityIdAttributeId = stateEvent.getStateEventId().getAttributeId();
        if (stateEntityIdAttributeId != eventEntityIdAttributeId)
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeId %1$s in state but entity id AttributeId %2$s in event", stateEntityIdAttributeId, eventEntityIdAttributeId);
        }

        Long stateVersion = this.getVersion();
        if(stateVersion == null) {
            stateVersion = AttributeUseState.VERSION_ZERO;
        }
        Long eventVersion = stateEvent.getVersion();
        if(eventVersion == null) {
            eventVersion = AttributeUseState.VERSION_ZERO;
        }
        if (AttributeUseState.VERSION_ZERO.equals(eventVersion))
        {
            stateEvent.setVersion(stateVersion);
            eventVersion = stateVersion;
        }
        if (!stateVersion.equals(eventVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version %1$s and event version %2$s", stateVersion, eventVersion);
        }

    }

    public static class SimpleAttributeUseState extends AbstractAttributeUseState
    {
    }


}
