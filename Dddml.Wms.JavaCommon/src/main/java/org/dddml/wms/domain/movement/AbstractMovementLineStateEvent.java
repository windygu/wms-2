package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementLineStateEvent extends AbstractStateEvent implements MovementLineStateEvent 
{
    private MovementLineStateEventId stateEventId;

    public MovementLineStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementLineStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getLineNumber() {
        return getStateEventId().getLineNumber();
    }

    public void setLineNumber(String lineNumber) {
        getStateEventId().setLineNumber(lineNumber);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
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

    protected AbstractMovementLineStateEvent() {
    }

    protected AbstractMovementLineStateEvent(MovementLineStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementLineStateCreated extends AbstractMovementLineStateEvent implements MovementLineStateEvent.MovementLineStateCreated
    {
        public AbstractMovementLineStateCreated() {
            this(new MovementLineStateEventId());
        }

        public AbstractMovementLineStateCreated(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementLineStateMergePatched extends AbstractMovementLineStateEvent implements MovementLineStateEvent.MovementLineStateMergePatched
    {
        public AbstractMovementLineStateMergePatched() {
            this(new MovementLineStateEventId());
        }

        public AbstractMovementLineStateMergePatched(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyMovementQuantityRemoved;

        public Boolean getIsPropertyMovementQuantityRemoved() {
            return this.isPropertyMovementQuantityRemoved;
        }

        public void setIsPropertyMovementQuantityRemoved(Boolean removed) {
            this.isPropertyMovementQuantityRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractMovementLineStateRemoved extends AbstractMovementLineStateEvent implements MovementLineStateEvent.MovementLineStateRemoved
    {
        public AbstractMovementLineStateRemoved() {
            this(new MovementLineStateEventId());
        }

        public AbstractMovementLineStateRemoved(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleMovementLineStateCreated extends AbstractMovementLineStateCreated
    {
        public SimpleMovementLineStateCreated() {
        }

        public SimpleMovementLineStateCreated(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementLineStateMergePatched extends AbstractMovementLineStateMergePatched
    {
        public SimpleMovementLineStateMergePatched() {
        }

        public SimpleMovementLineStateMergePatched(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementLineStateRemoved extends AbstractMovementLineStateRemoved
    {
        public SimpleMovementLineStateRemoved() {
        }

        public SimpleMovementLineStateRemoved(MovementLineStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

