package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractDamageReasonStateEvent extends AbstractStateEvent implements DamageReasonStateEvent 
{
    private DamageReasonStateEventId stateEventId;

    public DamageReasonStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(DamageReasonStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getDamageReasonId() {
        return getStateEventId().getDamageReasonId();
    }

    public void setDamageReasonId(String damageReasonId) {
        getStateEventId().setDamageReasonId(damageReasonId);
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

    protected AbstractDamageReasonStateEvent() {
    }

    protected AbstractDamageReasonStateEvent(DamageReasonStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractDamageReasonStateCreated extends AbstractDamageReasonStateEvent implements DamageReasonStateEvent.DamageReasonStateCreated
    {
        public AbstractDamageReasonStateCreated() {
            this(new DamageReasonStateEventId());
        }

        public AbstractDamageReasonStateCreated(DamageReasonStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractDamageReasonStateMergePatched extends AbstractDamageReasonStateEvent implements DamageReasonStateEvent.DamageReasonStateMergePatched
    {
        public AbstractDamageReasonStateMergePatched() {
            this(new DamageReasonStateEventId());
        }

        public AbstractDamageReasonStateMergePatched(DamageReasonStateEventId stateEventId) {
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


    public static abstract class AbstractDamageReasonStateDeleted extends AbstractDamageReasonStateEvent implements DamageReasonStateEvent.DamageReasonStateDeleted
    {
        public AbstractDamageReasonStateDeleted() {
            this(new DamageReasonStateEventId());
        }

        public AbstractDamageReasonStateDeleted(DamageReasonStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleDamageReasonStateCreated extends AbstractDamageReasonStateCreated
    {
        public SimpleDamageReasonStateCreated() {
        }

        public SimpleDamageReasonStateCreated(DamageReasonStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageReasonStateMergePatched extends AbstractDamageReasonStateMergePatched
    {
        public SimpleDamageReasonStateMergePatched() {
        }

        public SimpleDamageReasonStateMergePatched(DamageReasonStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleDamageReasonStateDeleted extends AbstractDamageReasonStateDeleted
    {
        public SimpleDamageReasonStateDeleted() {
        }

        public SimpleDamageReasonStateDeleted(DamageReasonStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

