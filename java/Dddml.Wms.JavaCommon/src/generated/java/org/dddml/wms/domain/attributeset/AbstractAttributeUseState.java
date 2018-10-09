package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributeset.AttributeUseEvent.*;

public abstract class AbstractAttributeUseState implements AttributeUseState.SqlAttributeUseState
{

    private AttributeSetAttributeUseId attributeSetAttributeUseId = new AttributeSetAttributeUseId();

    public AttributeSetAttributeUseId getAttributeSetAttributeUseId() {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId) {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    public String getAttributeSetId() {
        return this.getAttributeSetAttributeUseId().getAttributeSetId();
    }
        
    public void setAttributeSetId(String attributeSetId) {
        this.getAttributeSetAttributeUseId().setAttributeSetId(attributeSetId);
    }

    public String getAttributeId() {
        return this.getAttributeSetAttributeUseId().getAttributeId();
    }
        
    public void setAttributeId(String attributeId) {
        this.getAttributeSetAttributeUseId().setAttributeId(attributeId);
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


    public AbstractAttributeUseState() {
        this(false);
    }

    public AbstractAttributeUseState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof AttributeUseStateCreated) {
            when((AttributeUseStateCreated) e);
        } else if (e instanceof AttributeUseStateMergePatched) {
            when((AttributeUseStateMergePatched) e);
        } else if (e instanceof AttributeUseStateRemoved) {
            when((AttributeUseStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
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

    public void save()
    {
    }

    protected void throwOnWrongEvent(AttributeUseEvent event)
    {
        String stateEntityIdAttributeSetId = this.getAttributeSetAttributeUseId().getAttributeSetId();
        String eventEntityIdAttributeSetId = ((AttributeUseEvent.SqlAttributeUseEvent)event).getAttributeUseEventId().getAttributeSetId();
        if (!stateEntityIdAttributeSetId.equals(eventEntityIdAttributeSetId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeSetId %1$s in state but entity id AttributeSetId %2$s in event", stateEntityIdAttributeSetId, eventEntityIdAttributeSetId);
        }

        String stateEntityIdAttributeId = this.getAttributeSetAttributeUseId().getAttributeId();
        String eventEntityIdAttributeId = ((AttributeUseEvent.SqlAttributeUseEvent)event).getAttributeUseEventId().getAttributeId();
        if (!stateEntityIdAttributeId.equals(eventEntityIdAttributeId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeId %1$s in state but entity id AttributeId %2$s in event", stateEntityIdAttributeId, eventEntityIdAttributeId);
        }

        if (getForReapplying()) { return; }

        AttributeUseStateEvent stateEvent = event instanceof AttributeUseStateEvent ? (AttributeUseStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? AttributeUseState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(AttributeUseState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleAttributeUseState extends AbstractAttributeUseState
    {

        public SimpleAttributeUseState() {
        }

        public SimpleAttributeUseState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

