package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractDamageReasonStateEvent extends AbstractStateEvent implements DamageReasonStateEvent 
{
    private DamageReasonEventId damageReasonEventId;

    public DamageReasonEventId getDamageReasonEventId() {
        return this.damageReasonEventId;
    }

    public void setDamageReasonEventId(DamageReasonEventId eventId) {
        this.damageReasonEventId = eventId;
    }
    
    public String getDamageReasonId() {
        return getDamageReasonEventId().getDamageReasonId();
    }

    public void setDamageReasonId(String damageReasonId) {
        getDamageReasonEventId().setDamageReasonId(damageReasonId);
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

    protected AbstractDamageReasonStateEvent(DamageReasonEventId eventId) {
        this.damageReasonEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractDamageReasonStateCreated extends AbstractDamageReasonStateEvent implements DamageReasonStateEvent.DamageReasonStateCreated
    {
        public AbstractDamageReasonStateCreated() {
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateCreated(DamageReasonEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractDamageReasonStateMergePatched extends AbstractDamageReasonStateEvent implements DamageReasonStateEvent.DamageReasonStateMergePatched
    {
        public AbstractDamageReasonStateMergePatched() {
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateMergePatched(DamageReasonEventId eventId) {
            super(eventId);
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
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateDeleted(DamageReasonEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleDamageReasonStateCreated extends AbstractDamageReasonStateCreated
    {
        public SimpleDamageReasonStateCreated() {
        }

        public SimpleDamageReasonStateCreated(DamageReasonEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleDamageReasonStateMergePatched extends AbstractDamageReasonStateMergePatched
    {
        public SimpleDamageReasonStateMergePatched() {
        }

        public SimpleDamageReasonStateMergePatched(DamageReasonEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleDamageReasonStateDeleted extends AbstractDamageReasonStateDeleted
    {
        public SimpleDamageReasonStateDeleted() {
        }

        public SimpleDamageReasonStateDeleted(DamageReasonEventId eventId) {
            super(eventId);
        }
    }

}

