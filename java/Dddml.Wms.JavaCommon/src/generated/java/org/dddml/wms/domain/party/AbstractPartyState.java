package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.PartyStateEvent.*;

public abstract class AbstractPartyState implements PartyState
{

    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
    }

    private String partyTypeId;

    public String getPartyTypeId()
    {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId)
    {
        this.partyTypeId = partyTypeId;
    }

    private String primaryRoleTypeId;

    public String getPrimaryRoleTypeId()
    {
        return this.primaryRoleTypeId;
    }

    public void setPrimaryRoleTypeId(String primaryRoleTypeId)
    {
        this.primaryRoleTypeId = primaryRoleTypeId;
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

    public AbstractPartyState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPartyId(((PartyStateEvent) events.get(0)).getPartyEventId().getPartyId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractPartyState() {
        this(false);
    }

    public AbstractPartyState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PartyStateCreated) {
            when((PartyStateCreated) e);
        } else if (e instanceof PartyStateMergePatched) {
            when((PartyStateMergePatched) e);
        } else if (e instanceof PartyStateDeleted) {
            when((PartyStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PartyStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setPartyTypeId(e.getPartyTypeId());
        this.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PartyStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getPartyTypeId() == null)
        {
            if (e.getIsPropertyPartyTypeIdRemoved() != null && e.getIsPropertyPartyTypeIdRemoved())
            {
                this.setPartyTypeId(null);
            }
        }
        else
        {
            this.setPartyTypeId(e.getPartyTypeId());
        }
        if (e.getPrimaryRoleTypeId() == null)
        {
            if (e.getIsPropertyPrimaryRoleTypeIdRemoved() != null && e.getIsPropertyPrimaryRoleTypeIdRemoved())
            {
                this.setPrimaryRoleTypeId(null);
            }
        }
        else
        {
            this.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
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

    public void when(PartyStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PartyStateEvent stateEvent)
    {
        String stateEntityId = this.getPartyId(); // Aggregate Id
        String eventEntityId = stateEvent.getPartyEventId().getPartyId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getPartyEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getPartyEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PartyState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePartyState extends AbstractPartyState
    {

        public SimplePartyState() {
        }

        public SimplePartyState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePartyState(List<Event> events) {
            super(events);
        }

    }


}

