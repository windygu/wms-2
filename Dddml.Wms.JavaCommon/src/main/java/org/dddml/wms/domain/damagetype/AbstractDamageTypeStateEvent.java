package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractDamageTypeStateEvent extends AbstractStateEvent implements DamageTypeStateEvent 
{
    private DamageTypeStateEventId stateEventId;

    public DamageTypeStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(DamageTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getDamageTypeId() {
        return getStateEventId().getDamageTypeId();
    }

    public void setDamageTypeId(String damageTypeId) {
        getStateEventId().setDamageTypeId(damageTypeId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private String defaultHandlingMethodId;

    public String getDefaultHandlingMethodId()
    {
        return this.defaultHandlingMethodId;
    }

    public void setDefaultHandlingMethodId(String defaultHandlingMethodId)
    {
        this.defaultHandlingMethodId = defaultHandlingMethodId;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractDamageTypeStateEvent() {
    }

    protected AbstractDamageTypeStateEvent(DamageTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractDamageTypeStateCreated extends AbstractDamageTypeStateEvent implements DamageTypeStateEvent.DamageTypeStateCreated
    {
        public AbstractDamageTypeStateCreated() {
            this(new DamageTypeStateEventId());
        }

        public AbstractDamageTypeStateCreated(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractDamageTypeStateMergePatched extends AbstractDamageTypeStateEvent implements DamageTypeStateEvent.DamageTypeStateMergePatched
    {
        public AbstractDamageTypeStateMergePatched() {
            this(new DamageTypeStateEventId());
        }

        public AbstractDamageTypeStateMergePatched(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertySequenceIdRemoved;

        public Boolean getIsPropertySequenceIdRemoved() {
            return this.isPropertySequenceIdRemoved;
        }

        public void setIsPropertySequenceIdRemoved(Boolean removed) {
            this.isPropertySequenceIdRemoved = removed;
        }

        private Boolean isPropertyDefaultHandlingMethodIdRemoved;

        public Boolean getIsPropertyDefaultHandlingMethodIdRemoved() {
            return this.isPropertyDefaultHandlingMethodIdRemoved;
        }

        public void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed) {
            this.isPropertyDefaultHandlingMethodIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractDamageTypeStateDeleted extends AbstractDamageTypeStateEvent implements DamageTypeStateEvent.DamageTypeStateDeleted
    {
        public AbstractDamageTypeStateDeleted() {
            this(new DamageTypeStateEventId());
        }

        public AbstractDamageTypeStateDeleted(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleDamageTypeStateCreated extends AbstractDamageTypeStateCreated
    {
        public SimpleDamageTypeStateCreated() {
        }

        public SimpleDamageTypeStateCreated(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageTypeStateMergePatched extends AbstractDamageTypeStateMergePatched
    {
        public SimpleDamageTypeStateMergePatched() {
        }

        public SimpleDamageTypeStateMergePatched(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageTypeStateDeleted extends AbstractDamageTypeStateDeleted
    {
        public SimpleDamageTypeStateDeleted() {
        }

        public SimpleDamageTypeStateDeleted(DamageTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

