package org.dddml.wms.domain.damagetype;

import org.dddml.wms.domain.damagetype.DamageTypeStateEvent.DamageTypeStateCreated;
import org.dddml.wms.domain.damagetype.DamageTypeStateEvent.DamageTypeStateDeleted;
import org.dddml.wms.domain.damagetype.DamageTypeStateEvent.DamageTypeStateMergePatched;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.Event;

import java.util.Date;
import java.util.List;

public abstract class AbstractDamageTypeState implements DamageTypeState {

    private String damageTypeId;
    private String description;
    private String sequenceId;
    private String defaultHandlingMethodId;
    private Long version;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
    private Boolean active;
    private Boolean deleted;
    private Boolean stateReadOnly;
    private boolean forReapplying;
    private String commandId;

    public AbstractDamageTypeState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDamageTypeId(((DamageTypeStateEvent) events.get(0)).getStateEventId().getDamageTypeId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }

    public AbstractDamageTypeState() {
        this(false);
    }

    public AbstractDamageTypeState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }

    public String getDamageTypeId() {
        return this.damageTypeId;
    }

    public void setDamageTypeId(String damageTypeId) {
        this.damageTypeId = damageTypeId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDefaultHandlingMethodId() {
        return this.defaultHandlingMethodId;
    }

    public void setDefaultHandlingMethodId(String defaultHandlingMethodId) {
        this.defaultHandlingMethodId = defaultHandlingMethodId;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() {
        return this.getVersion() == null;
    }

    public Boolean getStateReadOnly() {
        return this.stateReadOnly;
    }

    public void setStateReadOnly(Boolean readOnly) {
        this.stateReadOnly = readOnly;
    }

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof DamageTypeStateCreated) {
            when((DamageTypeStateCreated) e);
        } else if (e instanceof DamageTypeStateMergePatched) {
            when((DamageTypeStateMergePatched) e);
        } else if (e instanceof DamageTypeStateDeleted) {
            when((DamageTypeStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(DamageTypeStateCreated e) {
        throwOnWrongEvent(e);

        this.setDescription(e.getDescription());
        this.setSequenceId(e.getSequenceId());
        this.setDefaultHandlingMethodId(e.getDefaultHandlingMethodId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(DamageTypeStateMergePatched e) {
        throwOnWrongEvent(e);

        if (e.getDescription() == null) {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved()) {
                this.setDescription(null);
            }
        } else {
            this.setDescription(e.getDescription());
        }
        if (e.getSequenceId() == null) {
            if (e.getIsPropertySequenceIdRemoved() != null && e.getIsPropertySequenceIdRemoved()) {
                this.setSequenceId(null);
            }
        } else {
            this.setSequenceId(e.getSequenceId());
        }
        if (e.getDefaultHandlingMethodId() == null) {
            if (e.getIsPropertyDefaultHandlingMethodIdRemoved() != null && e.getIsPropertyDefaultHandlingMethodIdRemoved()) {
                this.setDefaultHandlingMethodId(null);
            }
        } else {
            this.setDefaultHandlingMethodId(e.getDefaultHandlingMethodId());
        }
        if (e.getActive() == null) {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved()) {
                this.setActive(null);
            }
        } else {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(DamageTypeStateDeleted e) {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save() {
    }

    protected void throwOnWrongEvent(DamageTypeStateEvent stateEvent) {
        String stateEntityId = this.getDamageTypeId(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getDamageTypeId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(DamageTypeState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleDamageTypeState extends AbstractDamageTypeState {

        public SimpleDamageTypeState() {
        }

        public SimpleDamageTypeState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleDamageTypeState(List<Event> events) {
            super(events);
        }

    }


}

