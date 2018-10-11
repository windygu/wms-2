package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.roletype.RoleTypeEvent.*;

public abstract class AbstractRoleTypeState implements RoleTypeState.SqlRoleTypeState
{

    private String roleTypeId;

    public String getRoleTypeId()
    {
        return this.roleTypeId;
    }

    public void setRoleTypeId(String roleTypeId)
    {
        this.roleTypeId = roleTypeId;
    }

    private String parentTypeId;

    public String getParentTypeId()
    {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }

    private String hasTable;

    public String getHasTable()
    {
        return this.hasTable;
    }

    public void setHasTable(String hasTable)
    {
        this.hasTable = hasTable;
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

    public AbstractRoleTypeState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setRoleTypeId(((RoleTypeEvent.SqlRoleTypeEvent) events.get(0)).getRoleTypeEventId().getRoleTypeId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractRoleTypeState() {
        this(false);
    }

    public AbstractRoleTypeState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getRoleTypeId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getRoleTypeId(), ((RoleTypeState)obj).getRoleTypeId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof RoleTypeStateCreated) {
            when((RoleTypeStateCreated) e);
        } else if (e instanceof RoleTypeStateMergePatched) {
            when((RoleTypeStateMergePatched) e);
        } else if (e instanceof RoleTypeStateDeleted) {
            when((RoleTypeStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(RoleTypeStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setParentTypeId(e.getParentTypeId());
        this.setHasTable(e.getHasTable());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(RoleTypeState s) {
        if (s == this) {
            return;
        }
        this.setParentTypeId(s.getParentTypeId());
        this.setHasTable(s.getHasTable());
        this.setDescription(s.getDescription());
        this.setActive(s.getActive());
    }

    public void when(RoleTypeStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getParentTypeId() == null)
        {
            if (e.getIsPropertyParentTypeIdRemoved() != null && e.getIsPropertyParentTypeIdRemoved())
            {
                this.setParentTypeId(null);
            }
        }
        else
        {
            this.setParentTypeId(e.getParentTypeId());
        }
        if (e.getHasTable() == null)
        {
            if (e.getIsPropertyHasTableRemoved() != null && e.getIsPropertyHasTableRemoved())
            {
                this.setHasTable(null);
            }
        }
        else
        {
            this.setHasTable(e.getHasTable());
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

    public void when(RoleTypeStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(RoleTypeEvent event)
    {
        String stateEntityId = this.getRoleTypeId(); // Aggregate Id
        String eventEntityId = ((RoleTypeEvent.SqlRoleTypeEvent)event).getRoleTypeEventId().getRoleTypeId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((RoleTypeEvent.SqlRoleTypeEvent)event).getRoleTypeEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getRoleTypeEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(RoleTypeState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleRoleTypeState extends AbstractRoleTypeState
    {

        public SimpleRoleTypeState() {
        }

        public SimpleRoleTypeState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleRoleTypeState(List<Event> events) {
            super(events);
        }

    }


}

