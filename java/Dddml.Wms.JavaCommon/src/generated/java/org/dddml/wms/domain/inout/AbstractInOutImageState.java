package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inout.InOutImageEvent.*;

public abstract class AbstractInOutImageState implements InOutImageState
{

    private InOutImageId inOutImageId = new InOutImageId();

    public InOutImageId getInOutImageId() {
        return this.inOutImageId;
    }

    public void setInOutImageId(InOutImageId inOutImageId) {
        this.inOutImageId = inOutImageId;
    }

    public String getInOutDocumentNumber() {
        return this.getInOutImageId().getInOutDocumentNumber();
    }
        
    public void setInOutDocumentNumber(String inOutDocumentNumber) {
        this.getInOutImageId().setInOutDocumentNumber(inOutDocumentNumber);
    }

    public String getSequenceId() {
        return this.getInOutImageId().getSequenceId();
    }
        
    public void setSequenceId(String sequenceId) {
        this.getInOutImageId().setSequenceId(sequenceId);
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


    public AbstractInOutImageState() {
        this(false);
    }

    public AbstractInOutImageState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutImageStateCreated) {
            when((InOutImageStateCreated) e);
        } else if (e instanceof InOutImageStateMergePatched) {
            when((InOutImageStateMergePatched) e);
        } else if (e instanceof InOutImageStateRemoved) {
            when((InOutImageStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutImageStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setUrl(e.getUrl());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InOutImageStateMergePatched e)
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

    public void when(InOutImageStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InOutImageEvent event)
    {
        String stateEntityIdInOutDocumentNumber = this.getInOutImageId().getInOutDocumentNumber();
        String eventEntityIdInOutDocumentNumber = event.getInOutImageEventId().getInOutDocumentNumber();
        if (!stateEntityIdInOutDocumentNumber.equals(eventEntityIdInOutDocumentNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InOutDocumentNumber %1$s in state but entity id InOutDocumentNumber %2$s in event", stateEntityIdInOutDocumentNumber, eventEntityIdInOutDocumentNumber);
        }

        String stateEntityIdSequenceId = this.getInOutImageId().getSequenceId();
        String eventEntityIdSequenceId = event.getInOutImageEventId().getSequenceId();
        if (!stateEntityIdSequenceId.equals(eventEntityIdSequenceId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id SequenceId %1$s in state but entity id SequenceId %2$s in event", stateEntityIdSequenceId, eventEntityIdSequenceId);
        }

        if (getForReapplying()) { return; }

        InOutImageStateEvent stateEvent = event instanceof InOutImageStateEvent ? (InOutImageStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? InOutImageState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(InOutImageState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleInOutImageState extends AbstractInOutImageState
    {

        public SimpleInOutImageState() {
        }

        public SimpleInOutImageState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

