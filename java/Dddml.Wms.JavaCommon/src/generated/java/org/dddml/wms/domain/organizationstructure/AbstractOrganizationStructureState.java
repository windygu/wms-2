package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.organizationstructure.OrganizationStructureEvent.*;

public abstract class AbstractOrganizationStructureState implements OrganizationStructureState.SqlOrganizationStructureState
{

    private OrganizationStructureId id;

    public OrganizationStructureId getId()
    {
        return this.id;
    }

    public void setId(OrganizationStructureId id)
    {
        this.id = id;
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

    public AbstractOrganizationStructureState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setId(((OrganizationStructureEvent.SqlOrganizationStructureEvent) events.get(0)).getOrganizationStructureEventId().getId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractOrganizationStructureState() {
        this(false);
    }

    public AbstractOrganizationStructureState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrganizationStructureStateCreated) {
            when((OrganizationStructureStateCreated) e);
        } else if (e instanceof OrganizationStructureStateMergePatched) {
            when((OrganizationStructureStateMergePatched) e);
        } else if (e instanceof OrganizationStructureStateDeleted) {
            when((OrganizationStructureStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrganizationStructureStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrganizationStructureStateMergePatched e)
    {
        throwOnWrongEvent(e);

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

    public void when(OrganizationStructureStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrganizationStructureEvent event)
    {
        OrganizationStructureId stateEntityId = this.getId(); // Aggregate Id
        OrganizationStructureId eventEntityId = ((OrganizationStructureEvent.SqlOrganizationStructureEvent)event).getOrganizationStructureEventId().getId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((OrganizationStructureEvent.SqlOrganizationStructureEvent)event).getOrganizationStructureEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getOrganizationStructureEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrganizationStructureState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrganizationStructureState extends AbstractOrganizationStructureState
    {

        public SimpleOrganizationStructureState() {
        }

        public SimpleOrganizationStructureState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrganizationStructureState(List<Event> events) {
            super(events);
        }

    }


}

