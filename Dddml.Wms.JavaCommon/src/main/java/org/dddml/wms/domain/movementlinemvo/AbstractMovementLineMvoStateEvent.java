package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementLineMvoStateEvent extends AbstractStateEvent implements MovementLineMvoStateEvent 
{
    private MovementLineMvoStateEventId stateEventId;

    public MovementLineMvoStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementLineMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public MovementLineId getMovementLineId() {
        return getStateEventId().getMovementLineId();
    }

    public void setMovementLineId(MovementLineId movementLineId) {
        getStateEventId().setMovementLineId(movementLineId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
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

    protected AbstractMovementLineMvoStateEvent() {
    }

    protected AbstractMovementLineMvoStateEvent(MovementLineMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementLineMvoStateCreated extends AbstractMovementLineMvoStateEvent implements MovementLineMvoStateEvent.MovementLineMvoStateCreated
    {
        public AbstractMovementLineMvoStateCreated() {
            this(new MovementLineMvoStateEventId());
        }

        public AbstractMovementLineMvoStateCreated(MovementLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMovementLineMvoStateMergePatched extends AbstractMovementLineMvoStateEvent implements MovementLineMvoStateEvent.MovementLineMvoStateMergePatched
    {
        public AbstractMovementLineMvoStateMergePatched() {
            this(new MovementLineMvoStateEventId());
        }

        public AbstractMovementLineMvoStateMergePatched(MovementLineMvoStateEventId stateEventId) {
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


    public static abstract class AbstractMovementLineMvoStateDeleted extends AbstractMovementLineMvoStateEvent implements MovementLineMvoStateEvent.MovementLineMvoStateDeleted
    {
        public AbstractMovementLineMvoStateDeleted() {
            this(new MovementLineMvoStateEventId());
        }

        public AbstractMovementLineMvoStateDeleted(MovementLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleMovementLineMvoStateCreated extends AbstractMovementLineMvoStateCreated
    {
        public SimpleMovementLineMvoStateCreated() {
        }

        public SimpleMovementLineMvoStateCreated(MovementLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementLineMvoStateMergePatched extends AbstractMovementLineMvoStateMergePatched
    {
        public SimpleMovementLineMvoStateMergePatched() {
        }

        public SimpleMovementLineMvoStateMergePatched(MovementLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementLineMvoStateDeleted extends AbstractMovementLineMvoStateDeleted
    {
        public SimpleMovementLineMvoStateDeleted() {
        }

        public SimpleMovementLineMvoStateDeleted(MovementLineMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

