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

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
    }

    private String attributeSetInstanceIdFrom;

    public String getAttributeSetInstanceIdFrom()
    {
        return this.attributeSetInstanceIdFrom;
    }

    public void setAttributeSetInstanceIdFrom(String attributeSetInstanceIdFrom)
    {
        this.attributeSetInstanceIdFrom = attributeSetInstanceIdFrom;
    }

    private String attributeSetInstanceIdTo;

    public String getAttributeSetInstanceIdTo()
    {
        return this.attributeSetInstanceIdTo;
    }

    public void setAttributeSetInstanceIdTo(String attributeSetInstanceIdTo)
    {
        this.attributeSetInstanceIdTo = attributeSetInstanceIdTo;
    }

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

        private Boolean isPropertyProductIdRemoved;

        public Boolean getIsPropertyProductIdRemoved() {
            return this.isPropertyProductIdRemoved;
        }

        public void setIsPropertyProductIdRemoved(Boolean removed) {
            this.isPropertyProductIdRemoved = removed;
        }

        private Boolean isPropertyLocatorIdFromRemoved;

        public Boolean getIsPropertyLocatorIdFromRemoved() {
            return this.isPropertyLocatorIdFromRemoved;
        }

        public void setIsPropertyLocatorIdFromRemoved(Boolean removed) {
            this.isPropertyLocatorIdFromRemoved = removed;
        }

        private Boolean isPropertyLocatorIdToRemoved;

        public Boolean getIsPropertyLocatorIdToRemoved() {
            return this.isPropertyLocatorIdToRemoved;
        }

        public void setIsPropertyLocatorIdToRemoved(Boolean removed) {
            this.isPropertyLocatorIdToRemoved = removed;
        }

        private Boolean isPropertyAttributeSetInstanceIdFromRemoved;

        public Boolean getIsPropertyAttributeSetInstanceIdFromRemoved() {
            return this.isPropertyAttributeSetInstanceIdFromRemoved;
        }

        public void setIsPropertyAttributeSetInstanceIdFromRemoved(Boolean removed) {
            this.isPropertyAttributeSetInstanceIdFromRemoved = removed;
        }

        private Boolean isPropertyAttributeSetInstanceIdToRemoved;

        public Boolean getIsPropertyAttributeSetInstanceIdToRemoved() {
            return this.isPropertyAttributeSetInstanceIdToRemoved;
        }

        public void setIsPropertyAttributeSetInstanceIdToRemoved(Boolean removed) {
            this.isPropertyAttributeSetInstanceIdToRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved() {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed) {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyReversalLineNumberRemoved;

        public Boolean getIsPropertyReversalLineNumberRemoved() {
            return this.isPropertyReversalLineNumberRemoved;
        }

        public void setIsPropertyReversalLineNumberRemoved(Boolean removed) {
            this.isPropertyReversalLineNumberRemoved = removed;
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

