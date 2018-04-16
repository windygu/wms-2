package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractDamageReasonEvent extends AbstractEvent implements DamageReasonEvent 
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

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractDamageReasonEvent() {
    }

    protected AbstractDamageReasonEvent(DamageReasonEventId eventId) {
        this.damageReasonEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractDamageReasonStateEvent extends AbstractDamageReasonEvent implements DamageReasonEvent.DamageReasonStateEvent {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractDamageReasonStateEvent(DamageReasonEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractDamageReasonStateCreated extends AbstractDamageReasonStateEvent implements DamageReasonEvent.DamageReasonStateCreated
    {
        public AbstractDamageReasonStateCreated() {
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateCreated(DamageReasonEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractDamageReasonStateMergePatched extends AbstractDamageReasonStateEvent implements DamageReasonEvent.DamageReasonStateMergePatched
    {
        public AbstractDamageReasonStateMergePatched() {
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateMergePatched(DamageReasonEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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


    public static abstract class AbstractDamageReasonStateDeleted extends AbstractDamageReasonStateEvent implements DamageReasonEvent.DamageReasonStateDeleted
    {
        public AbstractDamageReasonStateDeleted() {
            this(new DamageReasonEventId());
        }

        public AbstractDamageReasonStateDeleted(DamageReasonEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

