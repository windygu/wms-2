package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryEvent.*;

public abstract class AbstractPhysicalInventoryState implements PhysicalInventoryState, Saveable
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

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String locatorIdPattern;

    public String getLocatorIdPattern()
    {
        return this.locatorIdPattern;
    }

    public void setLocatorIdPattern(String locatorIdPattern)
    {
        this.locatorIdPattern = locatorIdPattern;
    }

    private String productIdPattern;

    public String getProductIdPattern()
    {
        return this.productIdPattern;
    }

    public void setProductIdPattern(String productIdPattern)
    {
        this.productIdPattern = productIdPattern;
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

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean isQuantityUpdated;

    public Boolean getIsQuantityUpdated()
    {
        return this.isQuantityUpdated;
    }

    public void setIsQuantityUpdated(Boolean isQuantityUpdated)
    {
        this.isQuantityUpdated = isQuantityUpdated;
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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private EntityStateCollection<InventoryItemId, PhysicalInventoryLineState> physicalInventoryLines;

    public EntityStateCollection<InventoryItemId, PhysicalInventoryLineState> getPhysicalInventoryLines()
    {
        return this.physicalInventoryLines;
    }

    public void setPhysicalInventoryLines(EntityStateCollection<InventoryItemId, PhysicalInventoryLineState> physicalInventoryLines)
    {
        this.physicalInventoryLines = physicalInventoryLines;
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

    public AbstractPhysicalInventoryState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDocumentNumber(((PhysicalInventoryEvent.SqlPhysicalInventoryEvent) events.get(0)).getPhysicalInventoryEventId().getDocumentNumber());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractPhysicalInventoryState() {
        this(false);
    }

    public AbstractPhysicalInventoryState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        physicalInventoryLines = new SimplePhysicalInventoryLineStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PhysicalInventoryStateCreated) {
            when((PhysicalInventoryStateCreated) e);
        } else if (e instanceof PhysicalInventoryStateMergePatched) {
            when((PhysicalInventoryStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PhysicalInventoryStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDocumentStatusId(e.getDocumentStatusId());
        this.setWarehouseId(e.getWarehouseId());
        this.setLocatorIdPattern(e.getLocatorIdPattern());
        this.setProductIdPattern(e.getProductIdPattern());
        this.setPosted(e.getPosted());
        this.setProcessed(e.getProcessed());
        this.setProcessing(e.getProcessing());
        this.setDocumentTypeId(e.getDocumentTypeId());
        this.setMovementDate(e.getMovementDate());
        this.setDescription(e.getDescription());
        this.setIsApproved(e.getIsApproved());
        this.setApprovalAmount(e.getApprovalAmount());
        this.setIsQuantityUpdated(e.getIsQuantityUpdated());
        this.setReversalDocumentNumber(e.getReversalDocumentNumber());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated innerEvent : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineState innerState = this.getPhysicalInventoryLines().get(((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)innerEvent).getPhysicalInventoryLineEventId().getInventoryItemId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(PhysicalInventoryStateMergePatched e)
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
        if (e.getWarehouseId() == null)
        {
            if (e.getIsPropertyWarehouseIdRemoved() != null && e.getIsPropertyWarehouseIdRemoved())
            {
                this.setWarehouseId(null);
            }
        }
        else
        {
            this.setWarehouseId(e.getWarehouseId());
        }
        if (e.getLocatorIdPattern() == null)
        {
            if (e.getIsPropertyLocatorIdPatternRemoved() != null && e.getIsPropertyLocatorIdPatternRemoved())
            {
                this.setLocatorIdPattern(null);
            }
        }
        else
        {
            this.setLocatorIdPattern(e.getLocatorIdPattern());
        }
        if (e.getProductIdPattern() == null)
        {
            if (e.getIsPropertyProductIdPatternRemoved() != null && e.getIsPropertyProductIdPatternRemoved())
            {
                this.setProductIdPattern(null);
            }
        }
        else
        {
            this.setProductIdPattern(e.getProductIdPattern());
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
        if (e.getIsQuantityUpdated() == null)
        {
            if (e.getIsPropertyIsQuantityUpdatedRemoved() != null && e.getIsPropertyIsQuantityUpdatedRemoved())
            {
                this.setIsQuantityUpdated(null);
            }
        }
        else
        {
            this.setIsQuantityUpdated(e.getIsQuantityUpdated());
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

        for (PhysicalInventoryLineEvent innerEvent : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineState innerState = this.getPhysicalInventoryLines().get(((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)innerEvent).getPhysicalInventoryLineEventId().getInventoryItemId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved)
            {
                //PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved removed = (PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved)innerEvent;
                this.getPhysicalInventoryLines().remove(innerState);
            }
        }
    }

    public void save()
    {
        ((Saveable)physicalInventoryLines).save();

    }

    protected void throwOnWrongEvent(PhysicalInventoryEvent event)
    {
        String stateEntityId = this.getDocumentNumber(); // Aggregate Id
        String eventEntityId = ((PhysicalInventoryEvent.SqlPhysicalInventoryEvent)event).getPhysicalInventoryEventId().getDocumentNumber(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((PhysicalInventoryEvent.SqlPhysicalInventoryEvent)event).getPhysicalInventoryEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getPhysicalInventoryEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PhysicalInventoryState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePhysicalInventoryState extends AbstractPhysicalInventoryState
    {

        public SimplePhysicalInventoryState() {
        }

        public SimplePhysicalInventoryState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePhysicalInventoryState(List<Event> events) {
            super(events);
        }

    }

    static class SimplePhysicalInventoryLineStateCollection extends AbstractPhysicalInventoryLineStateCollection
    {
        public SimplePhysicalInventoryLineStateCollection(AbstractPhysicalInventoryState outerState)
        {
            super(outerState);
        }
    }


}

