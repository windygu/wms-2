package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractMovementLineEvent extends AbstractEvent implements MovementLineEvent.SqlMovementLineEvent 
{
    private MovementLineEventId movementLineEventId;

    public MovementLineEventId getMovementLineEventId() {
        return this.movementLineEventId;
    }

    public void setMovementLineEventId(MovementLineEventId eventId) {
        this.movementLineEventId = eventId;
    }
    
    public String getLineNumber() {
        return getMovementLineEventId().getLineNumber();
    }

    public void setLineNumber(String lineNumber) {
        getMovementLineEventId().setLineNumber(lineNumber);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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

    protected AbstractMovementLineEvent() {
    }

    protected AbstractMovementLineEvent(MovementLineEventId eventId) {
        this.movementLineEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractMovementLineStateEvent extends AbstractMovementLineEvent implements MovementLineEvent.MovementLineStateEvent {
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

        private String attributeSetInstanceId;

        public String getAttributeSetInstanceId()
        {
            return this.attributeSetInstanceId;
        }

        public void setAttributeSetInstanceId(String attributeSetInstanceId)
        {
            this.attributeSetInstanceId = attributeSetInstanceId;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractMovementLineStateEvent(MovementLineEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractMovementLineStateCreated extends AbstractMovementLineStateEvent implements MovementLineEvent.MovementLineStateCreated
    {
        public AbstractMovementLineStateCreated() {
            this(new MovementLineEventId());
        }

        public AbstractMovementLineStateCreated(MovementLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementLineStateMergePatched extends AbstractMovementLineStateEvent implements MovementLineEvent.MovementLineStateMergePatched
    {
        public AbstractMovementLineStateMergePatched() {
            this(new MovementLineEventId());
        }

        public AbstractMovementLineStateMergePatched(MovementLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Boolean isPropertyAttributeSetInstanceIdRemoved;

        public Boolean getIsPropertyAttributeSetInstanceIdRemoved() {
            return this.isPropertyAttributeSetInstanceIdRemoved;
        }

        public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed) {
            this.isPropertyAttributeSetInstanceIdRemoved = removed;
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


    public static abstract class AbstractMovementLineStateRemoved extends AbstractMovementLineStateEvent implements MovementLineEvent.MovementLineStateRemoved
    {
        public AbstractMovementLineStateRemoved() {
            this(new MovementLineEventId());
        }

        public AbstractMovementLineStateRemoved(MovementLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleMovementLineStateCreated extends AbstractMovementLineStateCreated
    {
        public SimpleMovementLineStateCreated() {
        }

        public SimpleMovementLineStateCreated(MovementLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementLineStateMergePatched extends AbstractMovementLineStateMergePatched
    {
        public SimpleMovementLineStateMergePatched() {
        }

        public SimpleMovementLineStateMergePatched(MovementLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementLineStateRemoved extends AbstractMovementLineStateRemoved
    {
        public SimpleMovementLineStateRemoved() {
        }

        public SimpleMovementLineStateRemoved(MovementLineEventId eventId) {
            super(eventId);
        }
    }

}

