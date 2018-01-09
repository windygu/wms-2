package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.statusitem.StatusItemStateEvent.*;

public abstract class AbstractStatusItemState implements StatusItemState
{

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private String statusTypeId;

    public String getStatusTypeId()
    {
        return this.statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId)
    {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    public String getStatusCode()
    {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    public AbstractStatusItemState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setStatusId(((StatusItemStateEvent) events.get(0)).getStateEventId().getStatusId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractStatusItemState() {
        this(false);
    }

    public AbstractStatusItemState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof StatusItemStateCreated) {
            when((StatusItemStateCreated) e);
        } else if (e instanceof StatusItemStateMergePatched) {
            when((StatusItemStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(StatusItemStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setStatusTypeId(e.getStatusTypeId());
        this.setStatusCode(e.getStatusCode());
        this.setSequenceId(e.getSequenceId());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(StatusItemStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getStatusTypeId() == null)
        {
            if (e.getIsPropertyStatusTypeIdRemoved() != null && e.getIsPropertyStatusTypeIdRemoved())
            {
                this.setStatusTypeId(null);
            }
        }
        else
        {
            this.setStatusTypeId(e.getStatusTypeId());
        }
        if (e.getStatusCode() == null)
        {
            if (e.getIsPropertyStatusCodeRemoved() != null && e.getIsPropertyStatusCodeRemoved())
            {
                this.setStatusCode(null);
            }
        }
        else
        {
            this.setStatusCode(e.getStatusCode());
        }
        if (e.getSequenceId() == null)
        {
            if (e.getIsPropertySequenceIdRemoved() != null && e.getIsPropertySequenceIdRemoved())
            {
                this.setSequenceId(null);
            }
        }
        else
        {
            this.setSequenceId(e.getSequenceId());
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

    public void save()
    {
    }

    protected void throwOnWrongEvent(StatusItemStateEvent stateEvent)
    {
        String stateEntityId = this.getStatusId(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getStatusId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(StatusItemState.VERSION_NULL)) && !(eventVersion.compareTo(stateVersion) >= 0))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleStatusItemState extends AbstractStatusItemState
    {

        public SimpleStatusItemState() {
        }

        public SimpleStatusItemState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleStatusItemState(List<Event> events) {
            super(events);
        }

    }


}

