package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractDamageHandlingMethodStateEvent extends AbstractStateEvent implements DamageHandlingMethodStateEvent 
{
    private DamageHandlingMethodStateEventId stateEventId;

    public DamageHandlingMethodStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(DamageHandlingMethodStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getDamageHandlingMethodId() {
        return getStateEventId().getDamageHandlingMethodId();
    }

    public void setDamageHandlingMethodId(String damageHandlingMethodId) {
        getStateEventId().setDamageHandlingMethodId(damageHandlingMethodId);
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

    protected AbstractDamageHandlingMethodStateEvent() {
    }

    protected AbstractDamageHandlingMethodStateEvent(DamageHandlingMethodStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractDamageHandlingMethodStateCreated extends AbstractDamageHandlingMethodStateEvent implements DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated
    {
        public AbstractDamageHandlingMethodStateCreated() {
            this(new DamageHandlingMethodStateEventId());
        }

        public AbstractDamageHandlingMethodStateCreated(DamageHandlingMethodStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractDamageHandlingMethodStateMergePatched extends AbstractDamageHandlingMethodStateEvent implements DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched
    {
        public AbstractDamageHandlingMethodStateMergePatched() {
            this(new DamageHandlingMethodStateEventId());
        }

        public AbstractDamageHandlingMethodStateMergePatched(DamageHandlingMethodStateEventId stateEventId) {
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractDamageHandlingMethodStateDeleted extends AbstractDamageHandlingMethodStateEvent implements DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted
    {
        public AbstractDamageHandlingMethodStateDeleted() {
            this(new DamageHandlingMethodStateEventId());
        }

        public AbstractDamageHandlingMethodStateDeleted(DamageHandlingMethodStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleDamageHandlingMethodStateCreated extends AbstractDamageHandlingMethodStateCreated
    {
        public SimpleDamageHandlingMethodStateCreated() {
        }

        public SimpleDamageHandlingMethodStateCreated(DamageHandlingMethodStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageHandlingMethodStateMergePatched extends AbstractDamageHandlingMethodStateMergePatched
    {
        public SimpleDamageHandlingMethodStateMergePatched() {
        }

        public SimpleDamageHandlingMethodStateMergePatched(DamageHandlingMethodStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageHandlingMethodStateDeleted extends AbstractDamageHandlingMethodStateDeleted
    {
        public SimpleDamageHandlingMethodStateDeleted() {
        }

        public SimpleDamageHandlingMethodStateDeleted(DamageHandlingMethodStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

