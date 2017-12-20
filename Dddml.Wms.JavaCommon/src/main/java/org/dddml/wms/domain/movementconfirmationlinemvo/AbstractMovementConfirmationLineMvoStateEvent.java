package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementConfirmationLineMvoStateEvent extends AbstractStateEvent implements MovementConfirmationLineMvoStateEvent 
{
    private MovementConfirmationLineMvoStateEventId stateEventId;

    public MovementConfirmationLineMvoStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementConfirmationLineMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public MovementConfirmationLineId getMovementConfirmationLineId() {
        return getStateEventId().getMovementConfirmationLineId();
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId) {
        getStateEventId().setMovementConfirmationLineId(movementConfirmationLineId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private String movementMovementTypeId;

    public String getMovementMovementTypeId()
    {
        return this.movementMovementTypeId;
    }

    public void setMovementMovementTypeId(String movementMovementTypeId)
    {
        this.movementMovementTypeId = movementMovementTypeId;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractMovementConfirmationLineMvoStateEvent() {
    }

    protected AbstractMovementConfirmationLineMvoStateEvent(MovementConfirmationLineMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementConfirmationLineMvoStateCreated extends AbstractMovementConfirmationLineMvoStateEvent implements MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated
    {
        public AbstractMovementConfirmationLineMvoStateCreated() {
            this(new MovementConfirmationLineMvoStateEventId());
        }

        public AbstractMovementConfirmationLineMvoStateCreated(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementConfirmationLineMvoStateMergePatched extends AbstractMovementConfirmationLineMvoStateEvent implements MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched
    {
        public AbstractMovementConfirmationLineMvoStateMergePatched() {
            this(new MovementConfirmationLineMvoStateEventId());
        }

        public AbstractMovementConfirmationLineMvoStateMergePatched(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
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

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved() {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed) {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertyMovementDocumentTypeIdRemoved;

        public Boolean getIsPropertyMovementDocumentTypeIdRemoved() {
            return this.isPropertyMovementDocumentTypeIdRemoved;
        }

        public void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed) {
            this.isPropertyMovementDocumentTypeIdRemoved = removed;
        }

        private Boolean isPropertyMovementDocumentStatusIdRemoved;

        public Boolean getIsPropertyMovementDocumentStatusIdRemoved() {
            return this.isPropertyMovementDocumentStatusIdRemoved;
        }

        public void setIsPropertyMovementDocumentStatusIdRemoved(Boolean removed) {
            this.isPropertyMovementDocumentStatusIdRemoved = removed;
        }

        private Boolean isPropertyMovementMovementTypeIdRemoved;

        public Boolean getIsPropertyMovementMovementTypeIdRemoved() {
            return this.isPropertyMovementMovementTypeIdRemoved;
        }

        public void setIsPropertyMovementMovementTypeIdRemoved(Boolean removed) {
            this.isPropertyMovementMovementTypeIdRemoved = removed;
        }

        private Boolean isPropertyMovementDescriptionRemoved;

        public Boolean getIsPropertyMovementDescriptionRemoved() {
            return this.isPropertyMovementDescriptionRemoved;
        }

        public void setIsPropertyMovementDescriptionRemoved(Boolean removed) {
            this.isPropertyMovementDescriptionRemoved = removed;
        }

        private Boolean isPropertyMovementCreatedByRemoved;

        public Boolean getIsPropertyMovementCreatedByRemoved() {
            return this.isPropertyMovementCreatedByRemoved;
        }

        public void setIsPropertyMovementCreatedByRemoved(Boolean removed) {
            this.isPropertyMovementCreatedByRemoved = removed;
        }

        private Boolean isPropertyMovementCreatedAtRemoved;

        public Boolean getIsPropertyMovementCreatedAtRemoved() {
            return this.isPropertyMovementCreatedAtRemoved;
        }

        public void setIsPropertyMovementCreatedAtRemoved(Boolean removed) {
            this.isPropertyMovementCreatedAtRemoved = removed;
        }

        private Boolean isPropertyMovementUpdatedByRemoved;

        public Boolean getIsPropertyMovementUpdatedByRemoved() {
            return this.isPropertyMovementUpdatedByRemoved;
        }

        public void setIsPropertyMovementUpdatedByRemoved(Boolean removed) {
            this.isPropertyMovementUpdatedByRemoved = removed;
        }

        private Boolean isPropertyMovementUpdatedAtRemoved;

        public Boolean getIsPropertyMovementUpdatedAtRemoved() {
            return this.isPropertyMovementUpdatedAtRemoved;
        }

        public void setIsPropertyMovementUpdatedAtRemoved(Boolean removed) {
            this.isPropertyMovementUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyMovementActiveRemoved;

        public Boolean getIsPropertyMovementActiveRemoved() {
            return this.isPropertyMovementActiveRemoved;
        }

        public void setIsPropertyMovementActiveRemoved(Boolean removed) {
            this.isPropertyMovementActiveRemoved = removed;
        }

        private Boolean isPropertyMovementDeletedRemoved;

        public Boolean getIsPropertyMovementDeletedRemoved() {
            return this.isPropertyMovementDeletedRemoved;
        }

        public void setIsPropertyMovementDeletedRemoved(Boolean removed) {
            this.isPropertyMovementDeletedRemoved = removed;
        }

    }


    public static abstract class AbstractMovementConfirmationLineMvoStateDeleted extends AbstractMovementConfirmationLineMvoStateEvent implements MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted
    {
        public AbstractMovementConfirmationLineMvoStateDeleted() {
            this(new MovementConfirmationLineMvoStateEventId());
        }

        public AbstractMovementConfirmationLineMvoStateDeleted(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleMovementConfirmationLineMvoStateCreated extends AbstractMovementConfirmationLineMvoStateCreated
    {
        public SimpleMovementConfirmationLineMvoStateCreated() {
        }

        public SimpleMovementConfirmationLineMvoStateCreated(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementConfirmationLineMvoStateMergePatched extends AbstractMovementConfirmationLineMvoStateMergePatched
    {
        public SimpleMovementConfirmationLineMvoStateMergePatched() {
        }

        public SimpleMovementConfirmationLineMvoStateMergePatched(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementConfirmationLineMvoStateDeleted extends AbstractMovementConfirmationLineMvoStateDeleted
    {
        public SimpleMovementConfirmationLineMvoStateDeleted() {
        }

        public SimpleMovementConfirmationLineMvoStateDeleted(MovementConfirmationLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

