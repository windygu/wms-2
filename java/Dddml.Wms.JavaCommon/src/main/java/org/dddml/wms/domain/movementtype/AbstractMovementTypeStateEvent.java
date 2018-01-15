package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementTypeStateEvent extends AbstractStateEvent implements MovementTypeStateEvent 
{
    private MovementTypeStateEventId stateEventId;

    public MovementTypeStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getMovementTypeId() {
        return getStateEventId().getMovementTypeId();
    }

    public void setMovementTypeId(String movementTypeId) {
        getStateEventId().setMovementTypeId(movementTypeId);
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

    protected AbstractMovementTypeStateEvent() {
    }

    protected AbstractMovementTypeStateEvent(MovementTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementTypeStateCreated extends AbstractMovementTypeStateEvent implements MovementTypeStateEvent.MovementTypeStateCreated
    {
        public AbstractMovementTypeStateCreated() {
            this(new MovementTypeStateEventId());
        }

        public AbstractMovementTypeStateCreated(MovementTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementTypeStateMergePatched extends AbstractMovementTypeStateEvent implements MovementTypeStateEvent.MovementTypeStateMergePatched
    {
        public AbstractMovementTypeStateMergePatched() {
            this(new MovementTypeStateEventId());
        }

        public AbstractMovementTypeStateMergePatched(MovementTypeStateEventId stateEventId) {
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractMovementTypeStateDeleted extends AbstractMovementTypeStateEvent implements MovementTypeStateEvent.MovementTypeStateDeleted
    {
        public AbstractMovementTypeStateDeleted() {
            this(new MovementTypeStateEventId());
        }

        public AbstractMovementTypeStateDeleted(MovementTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleMovementTypeStateCreated extends AbstractMovementTypeStateCreated
    {
        public SimpleMovementTypeStateCreated() {
        }

        public SimpleMovementTypeStateCreated(MovementTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementTypeStateMergePatched extends AbstractMovementTypeStateMergePatched
    {
        public SimpleMovementTypeStateMergePatched() {
        }

        public SimpleMovementTypeStateMergePatched(MovementTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementTypeStateDeleted extends AbstractMovementTypeStateDeleted
    {
        public SimpleMovementTypeStateDeleted() {
        }

        public SimpleMovementTypeStateDeleted(MovementTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

