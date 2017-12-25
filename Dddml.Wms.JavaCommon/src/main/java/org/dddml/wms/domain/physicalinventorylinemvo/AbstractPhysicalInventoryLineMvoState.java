package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventorylinemvo.PhysicalInventoryLineMvoStateEvent.*;

public abstract class AbstractPhysicalInventoryLineMvoState implements PhysicalInventoryLineMvoState
{

    private PhysicalInventoryLineId physicalInventoryLineId;

    public PhysicalInventoryLineId getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
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

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private String physicalInventoryDocumentStatusId;

    public String getPhysicalInventoryDocumentStatusId()
    {
        return this.physicalInventoryDocumentStatusId;
    }

    public void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId)
    {
        this.physicalInventoryDocumentStatusId = physicalInventoryDocumentStatusId;
    }

    private String physicalInventoryWarehouseId;

    public String getPhysicalInventoryWarehouseId()
    {
        return this.physicalInventoryWarehouseId;
    }

    public void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId)
    {
        this.physicalInventoryWarehouseId = physicalInventoryWarehouseId;
    }

    private Boolean physicalInventoryPosted;

    public Boolean getPhysicalInventoryPosted()
    {
        return this.physicalInventoryPosted;
    }

    public void setPhysicalInventoryPosted(Boolean physicalInventoryPosted)
    {
        this.physicalInventoryPosted = physicalInventoryPosted;
    }

    private Boolean physicalInventoryProcessed;

    public Boolean getPhysicalInventoryProcessed()
    {
        return this.physicalInventoryProcessed;
    }

    public void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed)
    {
        this.physicalInventoryProcessed = physicalInventoryProcessed;
    }

    private String physicalInventoryProcessing;

    public String getPhysicalInventoryProcessing()
    {
        return this.physicalInventoryProcessing;
    }

    public void setPhysicalInventoryProcessing(String physicalInventoryProcessing)
    {
        this.physicalInventoryProcessing = physicalInventoryProcessing;
    }

    private String physicalInventoryDocumentTypeId;

    public String getPhysicalInventoryDocumentTypeId()
    {
        return this.physicalInventoryDocumentTypeId;
    }

    public void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId)
    {
        this.physicalInventoryDocumentTypeId = physicalInventoryDocumentTypeId;
    }

    private Date physicalInventoryMovementDate;

    public Date getPhysicalInventoryMovementDate()
    {
        return this.physicalInventoryMovementDate;
    }

    public void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate)
    {
        this.physicalInventoryMovementDate = physicalInventoryMovementDate;
    }

    private String physicalInventoryDescription;

    public String getPhysicalInventoryDescription()
    {
        return this.physicalInventoryDescription;
    }

    public void setPhysicalInventoryDescription(String physicalInventoryDescription)
    {
        this.physicalInventoryDescription = physicalInventoryDescription;
    }

    private Boolean physicalInventoryIsApproved;

    public Boolean getPhysicalInventoryIsApproved()
    {
        return this.physicalInventoryIsApproved;
    }

    public void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved)
    {
        this.physicalInventoryIsApproved = physicalInventoryIsApproved;
    }

    private BigDecimal physicalInventoryApprovalAmount;

    public BigDecimal getPhysicalInventoryApprovalAmount()
    {
        return this.physicalInventoryApprovalAmount;
    }

    public void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount)
    {
        this.physicalInventoryApprovalAmount = physicalInventoryApprovalAmount;
    }

    private Boolean physicalInventoryIsQuantityUpdated;

    public Boolean getPhysicalInventoryIsQuantityUpdated()
    {
        return this.physicalInventoryIsQuantityUpdated;
    }

    public void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated)
    {
        this.physicalInventoryIsQuantityUpdated = physicalInventoryIsQuantityUpdated;
    }

    private String physicalInventoryReversalDocumentNumber;

    public String getPhysicalInventoryReversalDocumentNumber()
    {
        return this.physicalInventoryReversalDocumentNumber;
    }

    public void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber)
    {
        this.physicalInventoryReversalDocumentNumber = physicalInventoryReversalDocumentNumber;
    }

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }

    private String physicalInventoryCreatedBy;

    public String getPhysicalInventoryCreatedBy()
    {
        return this.physicalInventoryCreatedBy;
    }

    public void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy)
    {
        this.physicalInventoryCreatedBy = physicalInventoryCreatedBy;
    }

    private Date physicalInventoryCreatedAt;

    public Date getPhysicalInventoryCreatedAt()
    {
        return this.physicalInventoryCreatedAt;
    }

    public void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt)
    {
        this.physicalInventoryCreatedAt = physicalInventoryCreatedAt;
    }

    private String physicalInventoryUpdatedBy;

    public String getPhysicalInventoryUpdatedBy()
    {
        return this.physicalInventoryUpdatedBy;
    }

    public void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy)
    {
        this.physicalInventoryUpdatedBy = physicalInventoryUpdatedBy;
    }

    private Date physicalInventoryUpdatedAt;

    public Date getPhysicalInventoryUpdatedAt()
    {
        return this.physicalInventoryUpdatedAt;
    }

    public void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt)
    {
        this.physicalInventoryUpdatedAt = physicalInventoryUpdatedAt;
    }

    private Boolean physicalInventoryActive;

    public Boolean getPhysicalInventoryActive()
    {
        return this.physicalInventoryActive;
    }

    public void setPhysicalInventoryActive(Boolean physicalInventoryActive)
    {
        this.physicalInventoryActive = physicalInventoryActive;
    }

    private Boolean physicalInventoryDeleted;

    public Boolean getPhysicalInventoryDeleted()
    {
        return this.physicalInventoryDeleted;
    }

    public void setPhysicalInventoryDeleted(Boolean physicalInventoryDeleted)
    {
        this.physicalInventoryDeleted = physicalInventoryDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getPhysicalInventoryVersion() == null;
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

    public AbstractPhysicalInventoryLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPhysicalInventoryLineId(((PhysicalInventoryLineMvoStateEvent) events.get(0)).getStateEventId().getPhysicalInventoryLineId());
            for (Event e : events) {
                mutate(e);
                this.setPhysicalInventoryVersion(this.getPhysicalInventoryVersion() + 1);
            }
        }
    }


    public AbstractPhysicalInventoryLineMvoState() {
        this(false);
    }

    public AbstractPhysicalInventoryLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PhysicalInventoryLineMvoStateCreated) {
            when((PhysicalInventoryLineMvoStateCreated) e);
        } else if (e instanceof PhysicalInventoryLineMvoStateMergePatched) {
            when((PhysicalInventoryLineMvoStateMergePatched) e);
        } else if (e instanceof PhysicalInventoryLineMvoStateDeleted) {
            when((PhysicalInventoryLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PhysicalInventoryLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setLocatorId(e.getLocatorId());
        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setBookQuantity(e.getBookQuantity());
        this.setCountedQuantity(e.getCountedQuantity());
        this.setProcessed(e.getProcessed());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setDescription(e.getDescription());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        this.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
        this.setPhysicalInventoryPosted(e.getPhysicalInventoryPosted());
        this.setPhysicalInventoryProcessed(e.getPhysicalInventoryProcessed());
        this.setPhysicalInventoryProcessing(e.getPhysicalInventoryProcessing());
        this.setPhysicalInventoryDocumentTypeId(e.getPhysicalInventoryDocumentTypeId());
        this.setPhysicalInventoryMovementDate(e.getPhysicalInventoryMovementDate());
        this.setPhysicalInventoryDescription(e.getPhysicalInventoryDescription());
        this.setPhysicalInventoryIsApproved(e.getPhysicalInventoryIsApproved());
        this.setPhysicalInventoryApprovalAmount(e.getPhysicalInventoryApprovalAmount());
        this.setPhysicalInventoryIsQuantityUpdated(e.getPhysicalInventoryIsQuantityUpdated());
        this.setPhysicalInventoryReversalDocumentNumber(e.getPhysicalInventoryReversalDocumentNumber());
        this.setPhysicalInventoryCreatedBy(e.getPhysicalInventoryCreatedBy());
        this.setPhysicalInventoryCreatedAt(e.getPhysicalInventoryCreatedAt());
        this.setPhysicalInventoryUpdatedBy(e.getPhysicalInventoryUpdatedBy());
        this.setPhysicalInventoryUpdatedAt(e.getPhysicalInventoryUpdatedAt());
        this.setPhysicalInventoryActive(e.getPhysicalInventoryActive());
        this.setPhysicalInventoryDeleted(e.getPhysicalInventoryDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PhysicalInventoryLineMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getLocatorId() == null)
        {
            if (e.getIsPropertyLocatorIdRemoved() != null && e.getIsPropertyLocatorIdRemoved())
            {
                this.setLocatorId(null);
            }
        }
        else
        {
            this.setLocatorId(e.getLocatorId());
        }
        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        }
        if (e.getBookQuantity() == null)
        {
            if (e.getIsPropertyBookQuantityRemoved() != null && e.getIsPropertyBookQuantityRemoved())
            {
                this.setBookQuantity(null);
            }
        }
        else
        {
            this.setBookQuantity(e.getBookQuantity());
        }
        if (e.getCountedQuantity() == null)
        {
            if (e.getIsPropertyCountedQuantityRemoved() != null && e.getIsPropertyCountedQuantityRemoved())
            {
                this.setCountedQuantity(null);
            }
        }
        else
        {
            this.setCountedQuantity(e.getCountedQuantity());
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
        if (e.getReversalLineNumber() == null)
        {
            if (e.getIsPropertyReversalLineNumberRemoved() != null && e.getIsPropertyReversalLineNumberRemoved())
            {
                this.setReversalLineNumber(null);
            }
        }
        else
        {
            this.setReversalLineNumber(e.getReversalLineNumber());
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
        if (e.getPhysicalInventoryDocumentStatusId() == null)
        {
            if (e.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved() != null && e.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved())
            {
                this.setPhysicalInventoryDocumentStatusId(null);
            }
        }
        else
        {
            this.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        }
        if (e.getPhysicalInventoryWarehouseId() == null)
        {
            if (e.getIsPropertyPhysicalInventoryWarehouseIdRemoved() != null && e.getIsPropertyPhysicalInventoryWarehouseIdRemoved())
            {
                this.setPhysicalInventoryWarehouseId(null);
            }
        }
        else
        {
            this.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
        }
        if (e.getPhysicalInventoryPosted() == null)
        {
            if (e.getIsPropertyPhysicalInventoryPostedRemoved() != null && e.getIsPropertyPhysicalInventoryPostedRemoved())
            {
                this.setPhysicalInventoryPosted(null);
            }
        }
        else
        {
            this.setPhysicalInventoryPosted(e.getPhysicalInventoryPosted());
        }
        if (e.getPhysicalInventoryProcessed() == null)
        {
            if (e.getIsPropertyPhysicalInventoryProcessedRemoved() != null && e.getIsPropertyPhysicalInventoryProcessedRemoved())
            {
                this.setPhysicalInventoryProcessed(null);
            }
        }
        else
        {
            this.setPhysicalInventoryProcessed(e.getPhysicalInventoryProcessed());
        }
        if (e.getPhysicalInventoryProcessing() == null)
        {
            if (e.getIsPropertyPhysicalInventoryProcessingRemoved() != null && e.getIsPropertyPhysicalInventoryProcessingRemoved())
            {
                this.setPhysicalInventoryProcessing(null);
            }
        }
        else
        {
            this.setPhysicalInventoryProcessing(e.getPhysicalInventoryProcessing());
        }
        if (e.getPhysicalInventoryDocumentTypeId() == null)
        {
            if (e.getIsPropertyPhysicalInventoryDocumentTypeIdRemoved() != null && e.getIsPropertyPhysicalInventoryDocumentTypeIdRemoved())
            {
                this.setPhysicalInventoryDocumentTypeId(null);
            }
        }
        else
        {
            this.setPhysicalInventoryDocumentTypeId(e.getPhysicalInventoryDocumentTypeId());
        }
        if (e.getPhysicalInventoryMovementDate() == null)
        {
            if (e.getIsPropertyPhysicalInventoryMovementDateRemoved() != null && e.getIsPropertyPhysicalInventoryMovementDateRemoved())
            {
                this.setPhysicalInventoryMovementDate(null);
            }
        }
        else
        {
            this.setPhysicalInventoryMovementDate(e.getPhysicalInventoryMovementDate());
        }
        if (e.getPhysicalInventoryDescription() == null)
        {
            if (e.getIsPropertyPhysicalInventoryDescriptionRemoved() != null && e.getIsPropertyPhysicalInventoryDescriptionRemoved())
            {
                this.setPhysicalInventoryDescription(null);
            }
        }
        else
        {
            this.setPhysicalInventoryDescription(e.getPhysicalInventoryDescription());
        }
        if (e.getPhysicalInventoryIsApproved() == null)
        {
            if (e.getIsPropertyPhysicalInventoryIsApprovedRemoved() != null && e.getIsPropertyPhysicalInventoryIsApprovedRemoved())
            {
                this.setPhysicalInventoryIsApproved(null);
            }
        }
        else
        {
            this.setPhysicalInventoryIsApproved(e.getPhysicalInventoryIsApproved());
        }
        if (e.getPhysicalInventoryApprovalAmount() == null)
        {
            if (e.getIsPropertyPhysicalInventoryApprovalAmountRemoved() != null && e.getIsPropertyPhysicalInventoryApprovalAmountRemoved())
            {
                this.setPhysicalInventoryApprovalAmount(null);
            }
        }
        else
        {
            this.setPhysicalInventoryApprovalAmount(e.getPhysicalInventoryApprovalAmount());
        }
        if (e.getPhysicalInventoryIsQuantityUpdated() == null)
        {
            if (e.getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved() != null && e.getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved())
            {
                this.setPhysicalInventoryIsQuantityUpdated(null);
            }
        }
        else
        {
            this.setPhysicalInventoryIsQuantityUpdated(e.getPhysicalInventoryIsQuantityUpdated());
        }
        if (e.getPhysicalInventoryReversalDocumentNumber() == null)
        {
            if (e.getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved() != null && e.getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved())
            {
                this.setPhysicalInventoryReversalDocumentNumber(null);
            }
        }
        else
        {
            this.setPhysicalInventoryReversalDocumentNumber(e.getPhysicalInventoryReversalDocumentNumber());
        }
        if (e.getPhysicalInventoryCreatedBy() == null)
        {
            if (e.getIsPropertyPhysicalInventoryCreatedByRemoved() != null && e.getIsPropertyPhysicalInventoryCreatedByRemoved())
            {
                this.setPhysicalInventoryCreatedBy(null);
            }
        }
        else
        {
            this.setPhysicalInventoryCreatedBy(e.getPhysicalInventoryCreatedBy());
        }
        if (e.getPhysicalInventoryCreatedAt() == null)
        {
            if (e.getIsPropertyPhysicalInventoryCreatedAtRemoved() != null && e.getIsPropertyPhysicalInventoryCreatedAtRemoved())
            {
                this.setPhysicalInventoryCreatedAt(null);
            }
        }
        else
        {
            this.setPhysicalInventoryCreatedAt(e.getPhysicalInventoryCreatedAt());
        }
        if (e.getPhysicalInventoryUpdatedBy() == null)
        {
            if (e.getIsPropertyPhysicalInventoryUpdatedByRemoved() != null && e.getIsPropertyPhysicalInventoryUpdatedByRemoved())
            {
                this.setPhysicalInventoryUpdatedBy(null);
            }
        }
        else
        {
            this.setPhysicalInventoryUpdatedBy(e.getPhysicalInventoryUpdatedBy());
        }
        if (e.getPhysicalInventoryUpdatedAt() == null)
        {
            if (e.getIsPropertyPhysicalInventoryUpdatedAtRemoved() != null && e.getIsPropertyPhysicalInventoryUpdatedAtRemoved())
            {
                this.setPhysicalInventoryUpdatedAt(null);
            }
        }
        else
        {
            this.setPhysicalInventoryUpdatedAt(e.getPhysicalInventoryUpdatedAt());
        }
        if (e.getPhysicalInventoryActive() == null)
        {
            if (e.getIsPropertyPhysicalInventoryActiveRemoved() != null && e.getIsPropertyPhysicalInventoryActiveRemoved())
            {
                this.setPhysicalInventoryActive(null);
            }
        }
        else
        {
            this.setPhysicalInventoryActive(e.getPhysicalInventoryActive());
        }
        if (e.getPhysicalInventoryDeleted() == null)
        {
            if (e.getIsPropertyPhysicalInventoryDeletedRemoved() != null && e.getIsPropertyPhysicalInventoryDeletedRemoved())
            {
                this.setPhysicalInventoryDeleted(null);
            }
        }
        else
        {
            this.setPhysicalInventoryDeleted(e.getPhysicalInventoryDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(PhysicalInventoryLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PhysicalInventoryLineMvoStateEvent stateEvent)
    {
        PhysicalInventoryLineId stateEntityId = this.getPhysicalInventoryLineId(); // Aggregate Id
        PhysicalInventoryLineId eventEntityId = stateEvent.getStateEventId().getPhysicalInventoryLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getPhysicalInventoryVersion();
        Long eventVersion = stateEvent.getStateEventId().getPhysicalInventoryVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getPhysicalInventoryVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PhysicalInventoryLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePhysicalInventoryLineMvoState extends AbstractPhysicalInventoryLineMvoState
    {

        public SimplePhysicalInventoryLineMvoState() {
        }

        public SimplePhysicalInventoryLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePhysicalInventoryLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

