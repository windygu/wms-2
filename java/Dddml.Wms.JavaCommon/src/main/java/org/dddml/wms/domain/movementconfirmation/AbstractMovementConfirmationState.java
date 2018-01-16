package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationStateEvent.*;

public abstract class AbstractMovementConfirmationState implements MovementConfirmationState, Saveable
{

    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    private String documentStatusId;

    public String getDocumentStatusId()
    {
        return this.documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId)
    {
        this.documentStatusId = documentStatusId;
    }

    private String movementDocumentNumber;

    public String getMovementDocumentNumber()
    {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
    }

    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount()
    {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount)
    {
        this.approvalAmount = approvalAmount;
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

    private String processing;

    public String getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(String processing)
    {
        this.processing = processing;
    }

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private MovementConfirmationLineStates movementConfirmationLines;

    public MovementConfirmationLineStates getMovementConfirmationLines()
    {
        return this.movementConfirmationLines;
    }

    public void setMovementConfirmationLines(MovementConfirmationLineStates movementConfirmationLines)
    {
        this.movementConfirmationLines = movementConfirmationLines;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractMovementConfirmationState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDocumentNumber(((MovementConfirmationStateEvent) events.get(0)).getStateEventId().getDocumentNumber());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractMovementConfirmationState() {
        this(false);
    }

    public AbstractMovementConfirmationState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        movementConfirmationLines = new SimpleMovementConfirmationLineStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementConfirmationStateCreated) {
            when((MovementConfirmationStateCreated) e);
        } else if (e instanceof MovementConfirmationStateMergePatched) {
            when((MovementConfirmationStateMergePatched) e);
        } else if (e instanceof MovementConfirmationStateDeleted) {
            when((MovementConfirmationStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementConfirmationStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDocumentStatusId(e.getDocumentStatusId());
        this.setMovementDocumentNumber(e.getMovementDocumentNumber());
        this.setIsApproved(e.getIsApproved());
        this.setApprovalAmount(e.getApprovalAmount());
        this.setProcessed(e.getProcessed());
        this.setProcessing(e.getProcessing());
        this.setDocumentTypeId(e.getDocumentTypeId());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated innerEvent : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineState innerState = this.getMovementConfirmationLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
        }
    }

    public void when(MovementConfirmationStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getDocumentStatusId() == null)
        {
            if (e.getIsPropertyDocumentStatusIdRemoved() != null && e.getIsPropertyDocumentStatusIdRemoved())
            {
                this.setDocumentStatusId(null);
            }
        }
        else
        {
            this.setDocumentStatusId(e.getDocumentStatusId());
        }
        if (e.getMovementDocumentNumber() == null)
        {
            if (e.getIsPropertyMovementDocumentNumberRemoved() != null && e.getIsPropertyMovementDocumentNumberRemoved())
            {
                this.setMovementDocumentNumber(null);
            }
        }
        else
        {
            this.setMovementDocumentNumber(e.getMovementDocumentNumber());
        }
        if (e.getIsApproved() == null)
        {
            if (e.getIsPropertyIsApprovedRemoved() != null && e.getIsPropertyIsApprovedRemoved())
            {
                this.setIsApproved(null);
            }
        }
        else
        {
            this.setIsApproved(e.getIsApproved());
        }
        if (e.getApprovalAmount() == null)
        {
            if (e.getIsPropertyApprovalAmountRemoved() != null && e.getIsPropertyApprovalAmountRemoved())
            {
                this.setApprovalAmount(null);
            }
        }
        else
        {
            this.setApprovalAmount(e.getApprovalAmount());
        }
        if (e.getProcessed() == null)
        {
            if (e.getIsPropertyProcessedRemoved() != null && e.getIsPropertyProcessedRemoved())
            {
                this.setProcessed(null);
            }
        }
        else
        {
            this.setProcessed(e.getProcessed());
        }
        if (e.getProcessing() == null)
        {
            if (e.getIsPropertyProcessingRemoved() != null && e.getIsPropertyProcessingRemoved())
            {
                this.setProcessing(null);
            }
        }
        else
        {
            this.setProcessing(e.getProcessing());
        }
        if (e.getDocumentTypeId() == null)
        {
            if (e.getIsPropertyDocumentTypeIdRemoved() != null && e.getIsPropertyDocumentTypeIdRemoved())
            {
                this.setDocumentTypeId(null);
            }
        }
        else
        {
            this.setDocumentTypeId(e.getDocumentTypeId());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (MovementConfirmationLineStateEvent innerEvent : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineState innerState = this.getMovementConfirmationLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved)
            {
                //MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved removed = (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved)innerEvent;
                this.getMovementConfirmationLines().remove(innerState);
            }
        }
    }

    public void when(MovementConfirmationStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (MovementConfirmationLineState innerState : this.getMovementConfirmationLines())
        {
            this.getMovementConfirmationLines().remove(innerState);
        
            MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved innerE = e.newMovementConfirmationLineStateRemoved(innerState.getLineNumber());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addMovementConfirmationLineEvent(innerE);
        }
    }

    public void save()
    {
        movementConfirmationLines.save();

    }

    protected void throwOnWrongEvent(MovementConfirmationStateEvent stateEvent)
    {
        String stateEntityId = this.getDocumentNumber(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getDocumentNumber(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementConfirmationState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementConfirmationState extends AbstractMovementConfirmationState
    {

        public SimpleMovementConfirmationState() {
        }

        public SimpleMovementConfirmationState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementConfirmationState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleMovementConfirmationLineStates extends AbstractMovementConfirmationLineStates
    {
        public SimpleMovementConfirmationLineStates(AbstractMovementConfirmationState outerState)
        {
            super(outerState);
        }
    }


}

