package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmationlinemvo.MovementConfirmationLineMvoStateEvent.*;

public abstract class AbstractMovementConfirmationLineMvoState implements MovementConfirmationLineMvoState
{

    private MovementConfirmationLineId movementConfirmationLineId;

    public MovementConfirmationLineId getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
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

    private String movementConfirmationDocumentStatusId;

    public String getMovementConfirmationDocumentStatusId()
    {
        return this.movementConfirmationDocumentStatusId;
    }

    public void setMovementConfirmationDocumentStatusId(String movementConfirmationDocumentStatusId)
    {
        this.movementConfirmationDocumentStatusId = movementConfirmationDocumentStatusId;
    }

    private String movementConfirmationMovementDocumentNumber;

    public String getMovementConfirmationMovementDocumentNumber()
    {
        return this.movementConfirmationMovementDocumentNumber;
    }

    public void setMovementConfirmationMovementDocumentNumber(String movementConfirmationMovementDocumentNumber)
    {
        this.movementConfirmationMovementDocumentNumber = movementConfirmationMovementDocumentNumber;
    }

    private Boolean movementConfirmationIsApproved;

    public Boolean getMovementConfirmationIsApproved()
    {
        return this.movementConfirmationIsApproved;
    }

    public void setMovementConfirmationIsApproved(Boolean movementConfirmationIsApproved)
    {
        this.movementConfirmationIsApproved = movementConfirmationIsApproved;
    }

    private BigDecimal movementConfirmationApprovalAmount;

    public BigDecimal getMovementConfirmationApprovalAmount()
    {
        return this.movementConfirmationApprovalAmount;
    }

    public void setMovementConfirmationApprovalAmount(BigDecimal movementConfirmationApprovalAmount)
    {
        this.movementConfirmationApprovalAmount = movementConfirmationApprovalAmount;
    }

    private Boolean movementConfirmationProcessed;

    public Boolean getMovementConfirmationProcessed()
    {
        return this.movementConfirmationProcessed;
    }

    public void setMovementConfirmationProcessed(Boolean movementConfirmationProcessed)
    {
        this.movementConfirmationProcessed = movementConfirmationProcessed;
    }

    private String movementConfirmationProcessing;

    public String getMovementConfirmationProcessing()
    {
        return this.movementConfirmationProcessing;
    }

    public void setMovementConfirmationProcessing(String movementConfirmationProcessing)
    {
        this.movementConfirmationProcessing = movementConfirmationProcessing;
    }

    private String movementConfirmationDocumentTypeId;

    public String getMovementConfirmationDocumentTypeId()
    {
        return this.movementConfirmationDocumentTypeId;
    }

    public void setMovementConfirmationDocumentTypeId(String movementConfirmationDocumentTypeId)
    {
        this.movementConfirmationDocumentTypeId = movementConfirmationDocumentTypeId;
    }

    private String movementConfirmationDescription;

    public String getMovementConfirmationDescription()
    {
        return this.movementConfirmationDescription;
    }

    public void setMovementConfirmationDescription(String movementConfirmationDescription)
    {
        this.movementConfirmationDescription = movementConfirmationDescription;
    }

    private Long movementConfirmationVersion;

    public Long getMovementConfirmationVersion()
    {
        return this.movementConfirmationVersion;
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.movementConfirmationVersion = movementConfirmationVersion;
    }

    private String movementConfirmationCreatedBy;

    public String getMovementConfirmationCreatedBy()
    {
        return this.movementConfirmationCreatedBy;
    }

    public void setMovementConfirmationCreatedBy(String movementConfirmationCreatedBy)
    {
        this.movementConfirmationCreatedBy = movementConfirmationCreatedBy;
    }

    private Date movementConfirmationCreatedAt;

    public Date getMovementConfirmationCreatedAt()
    {
        return this.movementConfirmationCreatedAt;
    }

    public void setMovementConfirmationCreatedAt(Date movementConfirmationCreatedAt)
    {
        this.movementConfirmationCreatedAt = movementConfirmationCreatedAt;
    }

    private String movementConfirmationUpdatedBy;

    public String getMovementConfirmationUpdatedBy()
    {
        return this.movementConfirmationUpdatedBy;
    }

    public void setMovementConfirmationUpdatedBy(String movementConfirmationUpdatedBy)
    {
        this.movementConfirmationUpdatedBy = movementConfirmationUpdatedBy;
    }

    private Date movementConfirmationUpdatedAt;

    public Date getMovementConfirmationUpdatedAt()
    {
        return this.movementConfirmationUpdatedAt;
    }

    public void setMovementConfirmationUpdatedAt(Date movementConfirmationUpdatedAt)
    {
        this.movementConfirmationUpdatedAt = movementConfirmationUpdatedAt;
    }

    private Boolean movementConfirmationActive;

    public Boolean getMovementConfirmationActive()
    {
        return this.movementConfirmationActive;
    }

    public void setMovementConfirmationActive(Boolean movementConfirmationActive)
    {
        this.movementConfirmationActive = movementConfirmationActive;
    }

    private Boolean movementConfirmationDeleted;

    public Boolean getMovementConfirmationDeleted()
    {
        return this.movementConfirmationDeleted;
    }

    public void setMovementConfirmationDeleted(Boolean movementConfirmationDeleted)
    {
        this.movementConfirmationDeleted = movementConfirmationDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getMovementConfirmationVersion() == null;
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

    public AbstractMovementConfirmationLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setMovementConfirmationLineId(((MovementConfirmationLineMvoStateEvent) events.get(0)).getMovementConfirmationLineMvoEventId().getMovementConfirmationLineId());
            for (Event e : events) {
                mutate(e);
                this.setMovementConfirmationVersion(this.getMovementConfirmationVersion() + 1);
            }
        }
    }


    public AbstractMovementConfirmationLineMvoState() {
        this(false);
    }

    public AbstractMovementConfirmationLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementConfirmationLineMvoStateCreated) {
            when((MovementConfirmationLineMvoStateCreated) e);
        } else if (e instanceof MovementConfirmationLineMvoStateMergePatched) {
            when((MovementConfirmationLineMvoStateMergePatched) e);
        } else if (e instanceof MovementConfirmationLineMvoStateDeleted) {
            when((MovementConfirmationLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementConfirmationLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setMovementLineNumber(e.getMovementLineNumber());
        this.setTargetQuantity(e.getTargetQuantity());
        this.setConfirmedQuantity(e.getConfirmedQuantity());
        this.setDifferenceQuantity(e.getDifferenceQuantity());
        this.setScrappedQuantity(e.getScrappedQuantity());
        this.setDescription(e.getDescription());
        this.setProcessed(e.getProcessed());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setMovementConfirmationDocumentStatusId(e.getMovementConfirmationDocumentStatusId());
        this.setMovementConfirmationMovementDocumentNumber(e.getMovementConfirmationMovementDocumentNumber());
        this.setMovementConfirmationIsApproved(e.getMovementConfirmationIsApproved());
        this.setMovementConfirmationApprovalAmount(e.getMovementConfirmationApprovalAmount());
        this.setMovementConfirmationProcessed(e.getMovementConfirmationProcessed());
        this.setMovementConfirmationProcessing(e.getMovementConfirmationProcessing());
        this.setMovementConfirmationDocumentTypeId(e.getMovementConfirmationDocumentTypeId());
        this.setMovementConfirmationDescription(e.getMovementConfirmationDescription());
        this.setMovementConfirmationCreatedBy(e.getMovementConfirmationCreatedBy());
        this.setMovementConfirmationCreatedAt(e.getMovementConfirmationCreatedAt());
        this.setMovementConfirmationUpdatedBy(e.getMovementConfirmationUpdatedBy());
        this.setMovementConfirmationUpdatedAt(e.getMovementConfirmationUpdatedAt());
        this.setMovementConfirmationActive(e.getMovementConfirmationActive());
        this.setMovementConfirmationDeleted(e.getMovementConfirmationDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(MovementConfirmationLineMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getMovementLineNumber() == null)
        {
            if (e.getIsPropertyMovementLineNumberRemoved() != null && e.getIsPropertyMovementLineNumberRemoved())
            {
                this.setMovementLineNumber(null);
            }
        }
        else
        {
            this.setMovementLineNumber(e.getMovementLineNumber());
        }
        if (e.getTargetQuantity() == null)
        {
            if (e.getIsPropertyTargetQuantityRemoved() != null && e.getIsPropertyTargetQuantityRemoved())
            {
                this.setTargetQuantity(null);
            }
        }
        else
        {
            this.setTargetQuantity(e.getTargetQuantity());
        }
        if (e.getConfirmedQuantity() == null)
        {
            if (e.getIsPropertyConfirmedQuantityRemoved() != null && e.getIsPropertyConfirmedQuantityRemoved())
            {
                this.setConfirmedQuantity(null);
            }
        }
        else
        {
            this.setConfirmedQuantity(e.getConfirmedQuantity());
        }
        if (e.getDifferenceQuantity() == null)
        {
            if (e.getIsPropertyDifferenceQuantityRemoved() != null && e.getIsPropertyDifferenceQuantityRemoved())
            {
                this.setDifferenceQuantity(null);
            }
        }
        else
        {
            this.setDifferenceQuantity(e.getDifferenceQuantity());
        }
        if (e.getScrappedQuantity() == null)
        {
            if (e.getIsPropertyScrappedQuantityRemoved() != null && e.getIsPropertyScrappedQuantityRemoved())
            {
                this.setScrappedQuantity(null);
            }
        }
        else
        {
            this.setScrappedQuantity(e.getScrappedQuantity());
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
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
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
        if (e.getMovementConfirmationDocumentStatusId() == null)
        {
            if (e.getIsPropertyMovementConfirmationDocumentStatusIdRemoved() != null && e.getIsPropertyMovementConfirmationDocumentStatusIdRemoved())
            {
                this.setMovementConfirmationDocumentStatusId(null);
            }
        }
        else
        {
            this.setMovementConfirmationDocumentStatusId(e.getMovementConfirmationDocumentStatusId());
        }
        if (e.getMovementConfirmationMovementDocumentNumber() == null)
        {
            if (e.getIsPropertyMovementConfirmationMovementDocumentNumberRemoved() != null && e.getIsPropertyMovementConfirmationMovementDocumentNumberRemoved())
            {
                this.setMovementConfirmationMovementDocumentNumber(null);
            }
        }
        else
        {
            this.setMovementConfirmationMovementDocumentNumber(e.getMovementConfirmationMovementDocumentNumber());
        }
        if (e.getMovementConfirmationIsApproved() == null)
        {
            if (e.getIsPropertyMovementConfirmationIsApprovedRemoved() != null && e.getIsPropertyMovementConfirmationIsApprovedRemoved())
            {
                this.setMovementConfirmationIsApproved(null);
            }
        }
        else
        {
            this.setMovementConfirmationIsApproved(e.getMovementConfirmationIsApproved());
        }
        if (e.getMovementConfirmationApprovalAmount() == null)
        {
            if (e.getIsPropertyMovementConfirmationApprovalAmountRemoved() != null && e.getIsPropertyMovementConfirmationApprovalAmountRemoved())
            {
                this.setMovementConfirmationApprovalAmount(null);
            }
        }
        else
        {
            this.setMovementConfirmationApprovalAmount(e.getMovementConfirmationApprovalAmount());
        }
        if (e.getMovementConfirmationProcessed() == null)
        {
            if (e.getIsPropertyMovementConfirmationProcessedRemoved() != null && e.getIsPropertyMovementConfirmationProcessedRemoved())
            {
                this.setMovementConfirmationProcessed(null);
            }
        }
        else
        {
            this.setMovementConfirmationProcessed(e.getMovementConfirmationProcessed());
        }
        if (e.getMovementConfirmationProcessing() == null)
        {
            if (e.getIsPropertyMovementConfirmationProcessingRemoved() != null && e.getIsPropertyMovementConfirmationProcessingRemoved())
            {
                this.setMovementConfirmationProcessing(null);
            }
        }
        else
        {
            this.setMovementConfirmationProcessing(e.getMovementConfirmationProcessing());
        }
        if (e.getMovementConfirmationDocumentTypeId() == null)
        {
            if (e.getIsPropertyMovementConfirmationDocumentTypeIdRemoved() != null && e.getIsPropertyMovementConfirmationDocumentTypeIdRemoved())
            {
                this.setMovementConfirmationDocumentTypeId(null);
            }
        }
        else
        {
            this.setMovementConfirmationDocumentTypeId(e.getMovementConfirmationDocumentTypeId());
        }
        if (e.getMovementConfirmationDescription() == null)
        {
            if (e.getIsPropertyMovementConfirmationDescriptionRemoved() != null && e.getIsPropertyMovementConfirmationDescriptionRemoved())
            {
                this.setMovementConfirmationDescription(null);
            }
        }
        else
        {
            this.setMovementConfirmationDescription(e.getMovementConfirmationDescription());
        }
        if (e.getMovementConfirmationCreatedBy() == null)
        {
            if (e.getIsPropertyMovementConfirmationCreatedByRemoved() != null && e.getIsPropertyMovementConfirmationCreatedByRemoved())
            {
                this.setMovementConfirmationCreatedBy(null);
            }
        }
        else
        {
            this.setMovementConfirmationCreatedBy(e.getMovementConfirmationCreatedBy());
        }
        if (e.getMovementConfirmationCreatedAt() == null)
        {
            if (e.getIsPropertyMovementConfirmationCreatedAtRemoved() != null && e.getIsPropertyMovementConfirmationCreatedAtRemoved())
            {
                this.setMovementConfirmationCreatedAt(null);
            }
        }
        else
        {
            this.setMovementConfirmationCreatedAt(e.getMovementConfirmationCreatedAt());
        }
        if (e.getMovementConfirmationUpdatedBy() == null)
        {
            if (e.getIsPropertyMovementConfirmationUpdatedByRemoved() != null && e.getIsPropertyMovementConfirmationUpdatedByRemoved())
            {
                this.setMovementConfirmationUpdatedBy(null);
            }
        }
        else
        {
            this.setMovementConfirmationUpdatedBy(e.getMovementConfirmationUpdatedBy());
        }
        if (e.getMovementConfirmationUpdatedAt() == null)
        {
            if (e.getIsPropertyMovementConfirmationUpdatedAtRemoved() != null && e.getIsPropertyMovementConfirmationUpdatedAtRemoved())
            {
                this.setMovementConfirmationUpdatedAt(null);
            }
        }
        else
        {
            this.setMovementConfirmationUpdatedAt(e.getMovementConfirmationUpdatedAt());
        }
        if (e.getMovementConfirmationActive() == null)
        {
            if (e.getIsPropertyMovementConfirmationActiveRemoved() != null && e.getIsPropertyMovementConfirmationActiveRemoved())
            {
                this.setMovementConfirmationActive(null);
            }
        }
        else
        {
            this.setMovementConfirmationActive(e.getMovementConfirmationActive());
        }
        if (e.getMovementConfirmationDeleted() == null)
        {
            if (e.getIsPropertyMovementConfirmationDeletedRemoved() != null && e.getIsPropertyMovementConfirmationDeletedRemoved())
            {
                this.setMovementConfirmationDeleted(null);
            }
        }
        else
        {
            this.setMovementConfirmationDeleted(e.getMovementConfirmationDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(MovementConfirmationLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MovementConfirmationLineMvoStateEvent stateEvent)
    {
        MovementConfirmationLineId stateEntityId = this.getMovementConfirmationLineId(); // Aggregate Id
        MovementConfirmationLineId eventEntityId = stateEvent.getMovementConfirmationLineMvoEventId().getMovementConfirmationLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getMovementConfirmationVersion();
        Long eventVersion = stateEvent.getMovementConfirmationLineMvoEventId().getMovementConfirmationVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getMovementConfirmationLineMvoEventId().getMovementConfirmationVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementConfirmationLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementConfirmationLineMvoState extends AbstractMovementConfirmationLineMvoState
    {

        public SimpleMovementConfirmationLineMvoState() {
        }

        public SimpleMovementConfirmationLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementConfirmationLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

