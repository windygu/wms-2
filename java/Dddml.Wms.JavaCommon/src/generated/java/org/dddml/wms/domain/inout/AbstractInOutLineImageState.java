package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inout.InOutLineImageEvent.*;

public abstract class AbstractInOutLineImageState implements InOutLineImageState.SqlInOutLineImageState
{

    private InOutLineImageId inOutLineImageId = new InOutLineImageId();

    public InOutLineImageId getInOutLineImageId() {
        return this.inOutLineImageId;
    }

    public void setInOutLineImageId(InOutLineImageId inOutLineImageId) {
        this.inOutLineImageId = inOutLineImageId;
    }

    public String getInOutDocumentNumber() {
        return this.getInOutLineImageId().getInOutDocumentNumber();
    }
        
    public void setInOutDocumentNumber(String inOutDocumentNumber) {
        this.getInOutLineImageId().setInOutDocumentNumber(inOutDocumentNumber);
    }

    public String getInOutLineLineNumber() {
        return this.getInOutLineImageId().getInOutLineLineNumber();
    }
        
    public void setInOutLineLineNumber(String inOutLineLineNumber) {
        this.getInOutLineImageId().setInOutLineLineNumber(inOutLineLineNumber);
    }

    public String getSequenceId() {
        return this.getInOutLineImageId().getSequenceId();
    }
        
    public void setSequenceId(String sequenceId) {
        this.getInOutLineImageId().setSequenceId(sequenceId);
    }

    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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


    public AbstractInOutLineImageState() {
        this(false);
    }

    public AbstractInOutLineImageState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutLineImageStateCreated) {
            when((InOutLineImageStateCreated) e);
        } else if (e instanceof InOutLineImageStateMergePatched) {
            when((InOutLineImageStateMergePatched) e);
        } else if (e instanceof InOutLineImageStateRemoved) {
            when((InOutLineImageStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutLineImageStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setUrl(e.getUrl());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(InOutLineImageState s) {
        if (s == this) {
            return;
        }
        this.setUrl(s.getUrl());
        this.setActive(s.getActive());
    }

    public void when(InOutLineImageStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getUrl() == null)
        {
            if (e.getIsPropertyUrlRemoved() != null && e.getIsPropertyUrlRemoved())
            {
                this.setUrl(null);
            }
        }
        else
        {
            this.setUrl(e.getUrl());
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

    public void when(InOutLineImageStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InOutLineImageEvent event)
    {
        String stateEntityIdInOutDocumentNumber = this.getInOutLineImageId().getInOutDocumentNumber();
        String eventEntityIdInOutDocumentNumber = ((InOutLineImageEvent.SqlInOutLineImageEvent)event).getInOutLineImageEventId().getInOutDocumentNumber();
        if (!stateEntityIdInOutDocumentNumber.equals(eventEntityIdInOutDocumentNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InOutDocumentNumber %1$s in state but entity id InOutDocumentNumber %2$s in event", stateEntityIdInOutDocumentNumber, eventEntityIdInOutDocumentNumber);
        }

        String stateEntityIdInOutLineLineNumber = this.getInOutLineImageId().getInOutLineLineNumber();
        String eventEntityIdInOutLineLineNumber = ((InOutLineImageEvent.SqlInOutLineImageEvent)event).getInOutLineImageEventId().getInOutLineLineNumber();
        if (!stateEntityIdInOutLineLineNumber.equals(eventEntityIdInOutLineLineNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InOutLineLineNumber %1$s in state but entity id InOutLineLineNumber %2$s in event", stateEntityIdInOutLineLineNumber, eventEntityIdInOutLineLineNumber);
        }

        String stateEntityIdSequenceId = this.getInOutLineImageId().getSequenceId();
        String eventEntityIdSequenceId = ((InOutLineImageEvent.SqlInOutLineImageEvent)event).getInOutLineImageEventId().getSequenceId();
        if (!stateEntityIdSequenceId.equals(eventEntityIdSequenceId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id SequenceId %1$s in state but entity id SequenceId %2$s in event", stateEntityIdSequenceId, eventEntityIdSequenceId);
        }

        if (getForReapplying()) { return; }

        InOutLineImageStateEvent stateEvent = event instanceof InOutLineImageStateEvent ? (InOutLineImageStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? InOutLineImageState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(InOutLineImageState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleInOutLineImageState extends AbstractInOutLineImageState
    {

        public SimpleInOutLineImageState() {
        }

        public SimpleInOutLineImageState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

