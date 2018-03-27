package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklist.PicklistRoleStateEvent.*;

public abstract class AbstractPicklistRoleState implements PicklistRoleState
{

    private PicklistRoleId picklistRoleId = new PicklistRoleId();

    public PicklistRoleId getPicklistRoleId() {
        return this.picklistRoleId;
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId) {
        this.picklistRoleId = picklistRoleId;
    }

    public String getPicklistId() {
        return this.getPicklistRoleId().getPicklistId();
    }
        
    public void setPicklistId(String picklistId) {
        this.getPicklistRoleId().setPicklistId(picklistId);
    }

    public PartyRoleId getPartyRoleId() {
        return this.getPicklistRoleId().getPartyRoleId();
    }
        
    public void setPartyRoleId(PartyRoleId partyRoleId) {
        this.getPicklistRoleId().setPartyRoleId(partyRoleId);
    }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
    }

    private String lastModifiedByUserLogin;

    public String getLastModifiedByUserLogin()
    {
        return this.lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin)
    {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
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

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
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


    public AbstractPicklistRoleState() {
        this(false);
    }

    public AbstractPicklistRoleState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistRoleStateCreated) {
            when((PicklistRoleStateCreated) e);
        } else if (e instanceof PicklistRoleStateMergePatched) {
            when((PicklistRoleStateMergePatched) e);
        } else if (e instanceof PicklistRoleStateRemoved) {
            when((PicklistRoleStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistRoleStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedByUserLogin(e.getCreatedByUserLogin());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PicklistRoleStateMergePatched e)
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

        this.setLastModifiedByUserLogin(e.getCreatedByUserLogin());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(PicklistRoleStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setLastModifiedByUserLogin(e.getCreatedByUserLogin());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PicklistRoleStateEvent stateEvent)
    {
        String stateEntityIdPicklistId = this.getPicklistRoleId().getPicklistId();
        String eventEntityIdPicklistId = stateEvent.getPicklistRoleEventId().getPicklistId();
        if (!stateEntityIdPicklistId.equals(eventEntityIdPicklistId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PicklistId %1$s in state but entity id PicklistId %2$s in event", stateEntityIdPicklistId, eventEntityIdPicklistId);
        }

        PartyRoleId stateEntityIdPartyRoleId = this.getPicklistRoleId().getPartyRoleId();
        PartyRoleId eventEntityIdPartyRoleId = stateEvent.getPicklistRoleEventId().getPartyRoleId();
        if (!stateEntityIdPartyRoleId.equals(eventEntityIdPartyRoleId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PartyRoleId %1$s in state but entity id PartyRoleId %2$s in event", stateEntityIdPartyRoleId, eventEntityIdPartyRoleId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? PicklistRoleState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(PicklistRoleState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePicklistRoleState extends AbstractPicklistRoleState
    {

        public SimplePicklistRoleState() {
        }

        public SimplePicklistRoleState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

