package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movement.MovementEvent.*;

public abstract class AbstractMovementState implements MovementState, Saveable
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

    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
    }

    private Boolean posted;

    public Boolean getPosted()
    {
        return this.posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
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

    private Date dateReceived;

    public Date getDateReceived()
    {
        return this.dateReceived;
    }

    public void setDateReceived(Date dateReceived)
    {
        this.dateReceived = dateReceived;
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

    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
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

    private String shipperId;

    public String getShipperId()
    {
        return this.shipperId;
    }

    public void setShipperId(String shipperId)
    {
        this.shipperId = shipperId;
    }

    private String salesRepresentativeId;

    public String getSalesRepresentativeId()
    {
        return this.salesRepresentativeId;
    }

    public void setSalesRepresentativeId(String salesRepresentativeId)
    {
        this.salesRepresentativeId = salesRepresentativeId;
    }

    private String businessPartnerId;

    public String getBusinessPartnerId()
    {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(String businessPartnerId)
    {
        this.businessPartnerId = businessPartnerId;
    }

    private BigDecimal chargeAmount;

    public BigDecimal getChargeAmount()
    {
        return this.chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount)
    {
        this.chargeAmount = chargeAmount;
    }

    private String createFrom;

    public String getCreateFrom()
    {
        return this.createFrom;
    }

    public void setCreateFrom(String createFrom)
    {
        this.createFrom = createFrom;
    }

    private BigDecimal freightAmount;

    public BigDecimal getFreightAmount()
    {
        return this.freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount)
    {
        this.freightAmount = freightAmount;
    }

    private String reversalDocumentNumber;

    public String getReversalDocumentNumber()
    {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber)
    {
        this.reversalDocumentNumber = reversalDocumentNumber;
    }

    private String warehouseIdFrom;

    public String getWarehouseIdFrom()
    {
        return this.warehouseIdFrom;
    }

    public void setWarehouseIdFrom(String warehouseIdFrom)
    {
        this.warehouseIdFrom = warehouseIdFrom;
    }

    private String warehouseIdTo;

    public String getWarehouseIdTo()
    {
        return this.warehouseIdTo;
    }

    public void setWarehouseIdTo(String warehouseIdTo)
    {
        this.warehouseIdTo = warehouseIdTo;
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

    private MovementLineStates movementLines;

    public MovementLineStates getMovementLines()
    {
        return this.movementLines;
    }

    public void setMovementLines(MovementLineStates movementLines)
    {
        this.movementLines = movementLines;
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

    public AbstractMovementState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDocumentNumber(((MovementEvent) events.get(0)).getMovementEventId().getDocumentNumber());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractMovementState() {
        this(false);
    }

    public AbstractMovementState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        movementLines = new SimpleMovementLineStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementStateCreated) {
            when((MovementStateCreated) e);
        } else if (e instanceof MovementStateMergePatched) {
            when((MovementStateMergePatched) e);
        } else if (e instanceof MovementStateDeleted) {
            when((MovementStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDocumentStatusId(e.getDocumentStatusId());
        this.setMovementDate(e.getMovementDate());
        this.setPosted(e.getPosted());
        this.setProcessed(e.getProcessed());
        this.setProcessing(e.getProcessing());
        this.setDateReceived(e.getDateReceived());
        this.setDocumentTypeId(e.getDocumentTypeId());
        this.setIsInTransit(e.getIsInTransit());
        this.setIsApproved(e.getIsApproved());
        this.setApprovalAmount(e.getApprovalAmount());
        this.setShipperId(e.getShipperId());
        this.setSalesRepresentativeId(e.getSalesRepresentativeId());
        this.setBusinessPartnerId(e.getBusinessPartnerId());
        this.setChargeAmount(e.getChargeAmount());
        this.setCreateFrom(e.getCreateFrom());
        this.setFreightAmount(e.getFreightAmount());
        this.setReversalDocumentNumber(e.getReversalDocumentNumber());
        this.setWarehouseIdFrom(e.getWarehouseIdFrom());
        this.setWarehouseIdTo(e.getWarehouseIdTo());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (MovementLineEvent.MovementLineStateCreated innerEvent : e.getMovementLineEvents()) {
            MovementLineState innerState = this.getMovementLines().get(innerEvent.getMovementLineEventId().getLineNumber());
            innerState.mutate(innerEvent);
        }
    }

    public void when(MovementStateMergePatched e)
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
        if (e.getMovementDate() == null)
        {
            if (e.getIsPropertyMovementDateRemoved() != null && e.getIsPropertyMovementDateRemoved())
            {
                this.setMovementDate(null);
            }
        }
        else
        {
            this.setMovementDate(e.getMovementDate());
        }
        if (e.getPosted() == null)
        {
            if (e.getIsPropertyPostedRemoved() != null && e.getIsPropertyPostedRemoved())
            {
                this.setPosted(null);
            }
        }
        else
        {
            this.setPosted(e.getPosted());
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
        if (e.getDateReceived() == null)
        {
            if (e.getIsPropertyDateReceivedRemoved() != null && e.getIsPropertyDateReceivedRemoved())
            {
                this.setDateReceived(null);
            }
        }
        else
        {
            this.setDateReceived(e.getDateReceived());
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
        if (e.getIsInTransit() == null)
        {
            if (e.getIsPropertyIsInTransitRemoved() != null && e.getIsPropertyIsInTransitRemoved())
            {
                this.setIsInTransit(null);
            }
        }
        else
        {
            this.setIsInTransit(e.getIsInTransit());
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
        if (e.getShipperId() == null)
        {
            if (e.getIsPropertyShipperIdRemoved() != null && e.getIsPropertyShipperIdRemoved())
            {
                this.setShipperId(null);
            }
        }
        else
        {
            this.setShipperId(e.getShipperId());
        }
        if (e.getSalesRepresentativeId() == null)
        {
            if (e.getIsPropertySalesRepresentativeIdRemoved() != null && e.getIsPropertySalesRepresentativeIdRemoved())
            {
                this.setSalesRepresentativeId(null);
            }
        }
        else
        {
            this.setSalesRepresentativeId(e.getSalesRepresentativeId());
        }
        if (e.getBusinessPartnerId() == null)
        {
            if (e.getIsPropertyBusinessPartnerIdRemoved() != null && e.getIsPropertyBusinessPartnerIdRemoved())
            {
                this.setBusinessPartnerId(null);
            }
        }
        else
        {
            this.setBusinessPartnerId(e.getBusinessPartnerId());
        }
        if (e.getChargeAmount() == null)
        {
            if (e.getIsPropertyChargeAmountRemoved() != null && e.getIsPropertyChargeAmountRemoved())
            {
                this.setChargeAmount(null);
            }
        }
        else
        {
            this.setChargeAmount(e.getChargeAmount());
        }
        if (e.getCreateFrom() == null)
        {
            if (e.getIsPropertyCreateFromRemoved() != null && e.getIsPropertyCreateFromRemoved())
            {
                this.setCreateFrom(null);
            }
        }
        else
        {
            this.setCreateFrom(e.getCreateFrom());
        }
        if (e.getFreightAmount() == null)
        {
            if (e.getIsPropertyFreightAmountRemoved() != null && e.getIsPropertyFreightAmountRemoved())
            {
                this.setFreightAmount(null);
            }
        }
        else
        {
            this.setFreightAmount(e.getFreightAmount());
        }
        if (e.getReversalDocumentNumber() == null)
        {
            if (e.getIsPropertyReversalDocumentNumberRemoved() != null && e.getIsPropertyReversalDocumentNumberRemoved())
            {
                this.setReversalDocumentNumber(null);
            }
        }
        else
        {
            this.setReversalDocumentNumber(e.getReversalDocumentNumber());
        }
        if (e.getWarehouseIdFrom() == null)
        {
            if (e.getIsPropertyWarehouseIdFromRemoved() != null && e.getIsPropertyWarehouseIdFromRemoved())
            {
                this.setWarehouseIdFrom(null);
            }
        }
        else
        {
            this.setWarehouseIdFrom(e.getWarehouseIdFrom());
        }
        if (e.getWarehouseIdTo() == null)
        {
            if (e.getIsPropertyWarehouseIdToRemoved() != null && e.getIsPropertyWarehouseIdToRemoved())
            {
                this.setWarehouseIdTo(null);
            }
        }
        else
        {
            this.setWarehouseIdTo(e.getWarehouseIdTo());
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

        for (MovementLineEvent innerEvent : e.getMovementLineEvents()) {
            MovementLineState innerState = this.getMovementLines().get(innerEvent.getMovementLineEventId().getLineNumber());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof MovementLineEvent.MovementLineStateRemoved)
            {
                //MovementLineEvent.MovementLineStateRemoved removed = (MovementLineEvent.MovementLineStateRemoved)innerEvent;
                this.getMovementLines().remove(innerState);
            }
        }
    }

    public void when(MovementStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (MovementLineState innerState : this.getMovementLines())
        {
            this.getMovementLines().remove(innerState);
        
            MovementLineEvent.MovementLineStateRemoved innerE = e.newMovementLineStateRemoved(innerState.getLineNumber());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addMovementLineEvent(innerE);
        }
    }

    public void save()
    {
        movementLines.save();

    }

    protected void throwOnWrongEvent(MovementEvent event)
    {
        String stateEntityId = this.getDocumentNumber(); // Aggregate Id
        String eventEntityId = event.getMovementEventId().getDocumentNumber(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getMovementEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getMovementEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementState extends AbstractMovementState
    {

        public SimpleMovementState() {
        }

        public SimpleMovementState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleMovementLineStates extends AbstractMovementLineStates
    {
        public SimpleMovementLineStates(AbstractMovementState outerState)
        {
            super(outerState);
        }
    }


}

