package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractMovementConfirmationLineEvent extends AbstractEvent implements MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent 
{
    private MovementConfirmationLineEventId movementConfirmationLineEventId;

    public MovementConfirmationLineEventId getMovementConfirmationLineEventId() {
        return this.movementConfirmationLineEventId;
    }

    public void setMovementConfirmationLineEventId(MovementConfirmationLineEventId eventId) {
        this.movementConfirmationLineEventId = eventId;
    }
    
    public String getLineNumber() {
        return getMovementConfirmationLineEventId().getLineNumber();
    }

    public void setLineNumber(String lineNumber) {
        getMovementConfirmationLineEventId().setLineNumber(lineNumber);
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

    protected AbstractMovementConfirmationLineEvent() {
    }

    protected AbstractMovementConfirmationLineEvent(MovementConfirmationLineEventId eventId) {
        this.movementConfirmationLineEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractMovementConfirmationLineStateEvent extends AbstractMovementConfirmationLineEvent implements MovementConfirmationLineEvent.MovementConfirmationLineStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String movementLineNumber;

        public String getMovementLineNumber()
        {
            return this.movementLineNumber;
        }

        public void setMovementLineNumber(String movementLineNumber)
        {
            this.movementLineNumber = movementLineNumber;
        }

        private BigDecimal targetQuantity;

        public BigDecimal getTargetQuantity()
        {
            return this.targetQuantity;
        }

        public void setTargetQuantity(BigDecimal targetQuantity)
        {
            this.targetQuantity = targetQuantity;
        }

        private BigDecimal confirmedQuantity;

        public BigDecimal getConfirmedQuantity()
        {
            return this.confirmedQuantity;
        }

        public void setConfirmedQuantity(BigDecimal confirmedQuantity)
        {
            this.confirmedQuantity = confirmedQuantity;
        }

        private BigDecimal differenceQuantity;

        public BigDecimal getDifferenceQuantity()
        {
            return this.differenceQuantity;
        }

        public void setDifferenceQuantity(BigDecimal differenceQuantity)
        {
            this.differenceQuantity = differenceQuantity;
        }

        private BigDecimal scrappedQuantity;

        public BigDecimal getScrappedQuantity()
        {
            return this.scrappedQuantity;
        }

        public void setScrappedQuantity(BigDecimal scrappedQuantity)
        {
            this.scrappedQuantity = scrappedQuantity;
        }

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractMovementConfirmationLineStateEvent(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractMovementConfirmationLineStateCreated extends AbstractMovementConfirmationLineStateEvent implements MovementConfirmationLineEvent.MovementConfirmationLineStateCreated
    {
        public AbstractMovementConfirmationLineStateCreated() {
            this(new MovementConfirmationLineEventId());
        }

        public AbstractMovementConfirmationLineStateCreated(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementConfirmationLineStateMergePatched extends AbstractMovementConfirmationLineStateEvent implements MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched
    {
        public AbstractMovementConfirmationLineStateMergePatched() {
            this(new MovementConfirmationLineEventId());
        }

        public AbstractMovementConfirmationLineStateMergePatched(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyMovementLineNumberRemoved;

        public Boolean getIsPropertyMovementLineNumberRemoved() {
            return this.isPropertyMovementLineNumberRemoved;
        }

        public void setIsPropertyMovementLineNumberRemoved(Boolean removed) {
            this.isPropertyMovementLineNumberRemoved = removed;
        }

        private Boolean isPropertyTargetQuantityRemoved;

        public Boolean getIsPropertyTargetQuantityRemoved() {
            return this.isPropertyTargetQuantityRemoved;
        }

        public void setIsPropertyTargetQuantityRemoved(Boolean removed) {
            this.isPropertyTargetQuantityRemoved = removed;
        }

        private Boolean isPropertyConfirmedQuantityRemoved;

        public Boolean getIsPropertyConfirmedQuantityRemoved() {
            return this.isPropertyConfirmedQuantityRemoved;
        }

        public void setIsPropertyConfirmedQuantityRemoved(Boolean removed) {
            this.isPropertyConfirmedQuantityRemoved = removed;
        }

        private Boolean isPropertyDifferenceQuantityRemoved;

        public Boolean getIsPropertyDifferenceQuantityRemoved() {
            return this.isPropertyDifferenceQuantityRemoved;
        }

        public void setIsPropertyDifferenceQuantityRemoved(Boolean removed) {
            this.isPropertyDifferenceQuantityRemoved = removed;
        }

        private Boolean isPropertyScrappedQuantityRemoved;

        public Boolean getIsPropertyScrappedQuantityRemoved() {
            return this.isPropertyScrappedQuantityRemoved;
        }

        public void setIsPropertyScrappedQuantityRemoved(Boolean removed) {
            this.isPropertyScrappedQuantityRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved() {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed) {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractMovementConfirmationLineStateRemoved extends AbstractMovementConfirmationLineStateEvent implements MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved
    {
        public AbstractMovementConfirmationLineStateRemoved() {
            this(new MovementConfirmationLineEventId());
        }

        public AbstractMovementConfirmationLineStateRemoved(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleMovementConfirmationLineStateCreated extends AbstractMovementConfirmationLineStateCreated
    {
        public SimpleMovementConfirmationLineStateCreated() {
        }

        public SimpleMovementConfirmationLineStateCreated(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementConfirmationLineStateMergePatched extends AbstractMovementConfirmationLineStateMergePatched
    {
        public SimpleMovementConfirmationLineStateMergePatched() {
        }

        public SimpleMovementConfirmationLineStateMergePatched(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementConfirmationLineStateRemoved extends AbstractMovementConfirmationLineStateRemoved
    {
        public SimpleMovementConfirmationLineStateRemoved() {
        }

        public SimpleMovementConfirmationLineStateRemoved(MovementConfirmationLineEventId eventId) {
            super(eventId);
        }
    }

}

