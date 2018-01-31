package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementlinemvo.MovementLineMvoStateEvent.*;

public abstract class AbstractMovementLineMvoState implements MovementLineMvoState
{

    private MovementLineId movementLineId;

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
    {
        this.movementLineId = movementLineId;
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

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private Date movementMovementDate;

    public Date getMovementMovementDate()
    {
        return this.movementMovementDate;
    }

    public void setMovementMovementDate(Date movementMovementDate)
    {
        this.movementMovementDate = movementMovementDate;
    }

    private Boolean movementPosted;

    public Boolean getMovementPosted()
    {
        return this.movementPosted;
    }

    public void setMovementPosted(Boolean movementPosted)
    {
        this.movementPosted = movementPosted;
    }

    private Boolean movementProcessed;

    public Boolean getMovementProcessed()
    {
        return this.movementProcessed;
    }

    public void setMovementProcessed(Boolean movementProcessed)
    {
        this.movementProcessed = movementProcessed;
    }

    private String movementProcessing;

    public String getMovementProcessing()
    {
        return this.movementProcessing;
    }

    public void setMovementProcessing(String movementProcessing)
    {
        this.movementProcessing = movementProcessing;
    }

    private Date movementDateReceived;

    public Date getMovementDateReceived()
    {
        return this.movementDateReceived;
    }

    public void setMovementDateReceived(Date movementDateReceived)
    {
        this.movementDateReceived = movementDateReceived;
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

    private Boolean movementIsInTransit;

    public Boolean getMovementIsInTransit()
    {
        return this.movementIsInTransit;
    }

    public void setMovementIsInTransit(Boolean movementIsInTransit)
    {
        this.movementIsInTransit = movementIsInTransit;
    }

    private Boolean movementIsApproved;

    public Boolean getMovementIsApproved()
    {
        return this.movementIsApproved;
    }

    public void setMovementIsApproved(Boolean movementIsApproved)
    {
        this.movementIsApproved = movementIsApproved;
    }

    private BigDecimal movementApprovalAmount;

    public BigDecimal getMovementApprovalAmount()
    {
        return this.movementApprovalAmount;
    }

    public void setMovementApprovalAmount(BigDecimal movementApprovalAmount)
    {
        this.movementApprovalAmount = movementApprovalAmount;
    }

    private String movementShipperId;

    public String getMovementShipperId()
    {
        return this.movementShipperId;
    }

    public void setMovementShipperId(String movementShipperId)
    {
        this.movementShipperId = movementShipperId;
    }

    private String movementSalesRepresentativeId;

    public String getMovementSalesRepresentativeId()
    {
        return this.movementSalesRepresentativeId;
    }

    public void setMovementSalesRepresentativeId(String movementSalesRepresentativeId)
    {
        this.movementSalesRepresentativeId = movementSalesRepresentativeId;
    }

    private String movementBusinessPartnerId;

    public String getMovementBusinessPartnerId()
    {
        return this.movementBusinessPartnerId;
    }

    public void setMovementBusinessPartnerId(String movementBusinessPartnerId)
    {
        this.movementBusinessPartnerId = movementBusinessPartnerId;
    }

    private BigDecimal movementChargeAmount;

    public BigDecimal getMovementChargeAmount()
    {
        return this.movementChargeAmount;
    }

    public void setMovementChargeAmount(BigDecimal movementChargeAmount)
    {
        this.movementChargeAmount = movementChargeAmount;
    }

    private String movementCreateFrom;

    public String getMovementCreateFrom()
    {
        return this.movementCreateFrom;
    }

    public void setMovementCreateFrom(String movementCreateFrom)
    {
        this.movementCreateFrom = movementCreateFrom;
    }

    private BigDecimal movementFreightAmount;

    public BigDecimal getMovementFreightAmount()
    {
        return this.movementFreightAmount;
    }

    public void setMovementFreightAmount(BigDecimal movementFreightAmount)
    {
        this.movementFreightAmount = movementFreightAmount;
    }

    private String movementReversalDocumentNumber;

    public String getMovementReversalDocumentNumber()
    {
        return this.movementReversalDocumentNumber;
    }

    public void setMovementReversalDocumentNumber(String movementReversalDocumentNumber)
    {
        this.movementReversalDocumentNumber = movementReversalDocumentNumber;
    }

    private String movementWarehouseIdFrom;

    public String getMovementWarehouseIdFrom()
    {
        return this.movementWarehouseIdFrom;
    }

    public void setMovementWarehouseIdFrom(String movementWarehouseIdFrom)
    {
        this.movementWarehouseIdFrom = movementWarehouseIdFrom;
    }

    private String movementWarehouseIdTo;

    public String getMovementWarehouseIdTo()
    {
        return this.movementWarehouseIdTo;
    }

    public void setMovementWarehouseIdTo(String movementWarehouseIdTo)
    {
        this.movementWarehouseIdTo = movementWarehouseIdTo;
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

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getMovementVersion() == null;
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

    public AbstractMovementLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setMovementLineId(((MovementLineMvoStateEvent) events.get(0)).getStateEventId().getMovementLineId());
            for (Event e : events) {
                mutate(e);
                this.setMovementVersion(this.getMovementVersion() + 1);
            }
        }
    }


    public AbstractMovementLineMvoState() {
        this(false);
    }

    public AbstractMovementLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementLineMvoStateCreated) {
            when((MovementLineMvoStateCreated) e);
        } else if (e instanceof MovementLineMvoStateMergePatched) {
            when((MovementLineMvoStateMergePatched) e);
        } else if (e instanceof MovementLineMvoStateDeleted) {
            when((MovementLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setMovementQuantity(e.getMovementQuantity());
        this.setProductId(e.getProductId());
        this.setLocatorIdFrom(e.getLocatorIdFrom());
        this.setLocatorIdTo(e.getLocatorIdTo());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setProcessed(e.getProcessed());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        this.setMovementMovementDate(e.getMovementMovementDate());
        this.setMovementPosted(e.getMovementPosted());
        this.setMovementProcessed(e.getMovementProcessed());
        this.setMovementProcessing(e.getMovementProcessing());
        this.setMovementDateReceived(e.getMovementDateReceived());
        this.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        this.setMovementIsInTransit(e.getMovementIsInTransit());
        this.setMovementIsApproved(e.getMovementIsApproved());
        this.setMovementApprovalAmount(e.getMovementApprovalAmount());
        this.setMovementShipperId(e.getMovementShipperId());
        this.setMovementSalesRepresentativeId(e.getMovementSalesRepresentativeId());
        this.setMovementBusinessPartnerId(e.getMovementBusinessPartnerId());
        this.setMovementChargeAmount(e.getMovementChargeAmount());
        this.setMovementCreateFrom(e.getMovementCreateFrom());
        this.setMovementFreightAmount(e.getMovementFreightAmount());
        this.setMovementReversalDocumentNumber(e.getMovementReversalDocumentNumber());
        this.setMovementWarehouseIdFrom(e.getMovementWarehouseIdFrom());
        this.setMovementWarehouseIdTo(e.getMovementWarehouseIdTo());
        this.setMovementDescription(e.getMovementDescription());
        this.setMovementCreatedBy(e.getMovementCreatedBy());
        this.setMovementCreatedAt(e.getMovementCreatedAt());
        this.setMovementUpdatedBy(e.getMovementUpdatedBy());
        this.setMovementUpdatedAt(e.getMovementUpdatedAt());
        this.setMovementActive(e.getMovementActive());
        this.setMovementDeleted(e.getMovementDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(MovementLineMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getMovementQuantity() == null)
        {
            if (e.getIsPropertyMovementQuantityRemoved() != null && e.getIsPropertyMovementQuantityRemoved())
            {
                this.setMovementQuantity(null);
            }
        }
        else
        {
            this.setMovementQuantity(e.getMovementQuantity());
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
        if (e.getLocatorIdFrom() == null)
        {
            if (e.getIsPropertyLocatorIdFromRemoved() != null && e.getIsPropertyLocatorIdFromRemoved())
            {
                this.setLocatorIdFrom(null);
            }
        }
        else
        {
            this.setLocatorIdFrom(e.getLocatorIdFrom());
        }
        if (e.getLocatorIdTo() == null)
        {
            if (e.getIsPropertyLocatorIdToRemoved() != null && e.getIsPropertyLocatorIdToRemoved())
            {
                this.setLocatorIdTo(null);
            }
        }
        else
        {
            this.setLocatorIdTo(e.getLocatorIdTo());
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
        if (e.getMovementDocumentStatusId() == null)
        {
            if (e.getIsPropertyMovementDocumentStatusIdRemoved() != null && e.getIsPropertyMovementDocumentStatusIdRemoved())
            {
                this.setMovementDocumentStatusId(null);
            }
        }
        else
        {
            this.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        }
        if (e.getMovementMovementDate() == null)
        {
            if (e.getIsPropertyMovementMovementDateRemoved() != null && e.getIsPropertyMovementMovementDateRemoved())
            {
                this.setMovementMovementDate(null);
            }
        }
        else
        {
            this.setMovementMovementDate(e.getMovementMovementDate());
        }
        if (e.getMovementPosted() == null)
        {
            if (e.getIsPropertyMovementPostedRemoved() != null && e.getIsPropertyMovementPostedRemoved())
            {
                this.setMovementPosted(null);
            }
        }
        else
        {
            this.setMovementPosted(e.getMovementPosted());
        }
        if (e.getMovementProcessed() == null)
        {
            if (e.getIsPropertyMovementProcessedRemoved() != null && e.getIsPropertyMovementProcessedRemoved())
            {
                this.setMovementProcessed(null);
            }
        }
        else
        {
            this.setMovementProcessed(e.getMovementProcessed());
        }
        if (e.getMovementProcessing() == null)
        {
            if (e.getIsPropertyMovementProcessingRemoved() != null && e.getIsPropertyMovementProcessingRemoved())
            {
                this.setMovementProcessing(null);
            }
        }
        else
        {
            this.setMovementProcessing(e.getMovementProcessing());
        }
        if (e.getMovementDateReceived() == null)
        {
            if (e.getIsPropertyMovementDateReceivedRemoved() != null && e.getIsPropertyMovementDateReceivedRemoved())
            {
                this.setMovementDateReceived(null);
            }
        }
        else
        {
            this.setMovementDateReceived(e.getMovementDateReceived());
        }
        if (e.getMovementDocumentTypeId() == null)
        {
            if (e.getIsPropertyMovementDocumentTypeIdRemoved() != null && e.getIsPropertyMovementDocumentTypeIdRemoved())
            {
                this.setMovementDocumentTypeId(null);
            }
        }
        else
        {
            this.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        }
        if (e.getMovementIsInTransit() == null)
        {
            if (e.getIsPropertyMovementIsInTransitRemoved() != null && e.getIsPropertyMovementIsInTransitRemoved())
            {
                this.setMovementIsInTransit(null);
            }
        }
        else
        {
            this.setMovementIsInTransit(e.getMovementIsInTransit());
        }
        if (e.getMovementIsApproved() == null)
        {
            if (e.getIsPropertyMovementIsApprovedRemoved() != null && e.getIsPropertyMovementIsApprovedRemoved())
            {
                this.setMovementIsApproved(null);
            }
        }
        else
        {
            this.setMovementIsApproved(e.getMovementIsApproved());
        }
        if (e.getMovementApprovalAmount() == null)
        {
            if (e.getIsPropertyMovementApprovalAmountRemoved() != null && e.getIsPropertyMovementApprovalAmountRemoved())
            {
                this.setMovementApprovalAmount(null);
            }
        }
        else
        {
            this.setMovementApprovalAmount(e.getMovementApprovalAmount());
        }
        if (e.getMovementShipperId() == null)
        {
            if (e.getIsPropertyMovementShipperIdRemoved() != null && e.getIsPropertyMovementShipperIdRemoved())
            {
                this.setMovementShipperId(null);
            }
        }
        else
        {
            this.setMovementShipperId(e.getMovementShipperId());
        }
        if (e.getMovementSalesRepresentativeId() == null)
        {
            if (e.getIsPropertyMovementSalesRepresentativeIdRemoved() != null && e.getIsPropertyMovementSalesRepresentativeIdRemoved())
            {
                this.setMovementSalesRepresentativeId(null);
            }
        }
        else
        {
            this.setMovementSalesRepresentativeId(e.getMovementSalesRepresentativeId());
        }
        if (e.getMovementBusinessPartnerId() == null)
        {
            if (e.getIsPropertyMovementBusinessPartnerIdRemoved() != null && e.getIsPropertyMovementBusinessPartnerIdRemoved())
            {
                this.setMovementBusinessPartnerId(null);
            }
        }
        else
        {
            this.setMovementBusinessPartnerId(e.getMovementBusinessPartnerId());
        }
        if (e.getMovementChargeAmount() == null)
        {
            if (e.getIsPropertyMovementChargeAmountRemoved() != null && e.getIsPropertyMovementChargeAmountRemoved())
            {
                this.setMovementChargeAmount(null);
            }
        }
        else
        {
            this.setMovementChargeAmount(e.getMovementChargeAmount());
        }
        if (e.getMovementCreateFrom() == null)
        {
            if (e.getIsPropertyMovementCreateFromRemoved() != null && e.getIsPropertyMovementCreateFromRemoved())
            {
                this.setMovementCreateFrom(null);
            }
        }
        else
        {
            this.setMovementCreateFrom(e.getMovementCreateFrom());
        }
        if (e.getMovementFreightAmount() == null)
        {
            if (e.getIsPropertyMovementFreightAmountRemoved() != null && e.getIsPropertyMovementFreightAmountRemoved())
            {
                this.setMovementFreightAmount(null);
            }
        }
        else
        {
            this.setMovementFreightAmount(e.getMovementFreightAmount());
        }
        if (e.getMovementReversalDocumentNumber() == null)
        {
            if (e.getIsPropertyMovementReversalDocumentNumberRemoved() != null && e.getIsPropertyMovementReversalDocumentNumberRemoved())
            {
                this.setMovementReversalDocumentNumber(null);
            }
        }
        else
        {
            this.setMovementReversalDocumentNumber(e.getMovementReversalDocumentNumber());
        }
        if (e.getMovementWarehouseIdFrom() == null)
        {
            if (e.getIsPropertyMovementWarehouseIdFromRemoved() != null && e.getIsPropertyMovementWarehouseIdFromRemoved())
            {
                this.setMovementWarehouseIdFrom(null);
            }
        }
        else
        {
            this.setMovementWarehouseIdFrom(e.getMovementWarehouseIdFrom());
        }
        if (e.getMovementWarehouseIdTo() == null)
        {
            if (e.getIsPropertyMovementWarehouseIdToRemoved() != null && e.getIsPropertyMovementWarehouseIdToRemoved())
            {
                this.setMovementWarehouseIdTo(null);
            }
        }
        else
        {
            this.setMovementWarehouseIdTo(e.getMovementWarehouseIdTo());
        }
        if (e.getMovementDescription() == null)
        {
            if (e.getIsPropertyMovementDescriptionRemoved() != null && e.getIsPropertyMovementDescriptionRemoved())
            {
                this.setMovementDescription(null);
            }
        }
        else
        {
            this.setMovementDescription(e.getMovementDescription());
        }
        if (e.getMovementCreatedBy() == null)
        {
            if (e.getIsPropertyMovementCreatedByRemoved() != null && e.getIsPropertyMovementCreatedByRemoved())
            {
                this.setMovementCreatedBy(null);
            }
        }
        else
        {
            this.setMovementCreatedBy(e.getMovementCreatedBy());
        }
        if (e.getMovementCreatedAt() == null)
        {
            if (e.getIsPropertyMovementCreatedAtRemoved() != null && e.getIsPropertyMovementCreatedAtRemoved())
            {
                this.setMovementCreatedAt(null);
            }
        }
        else
        {
            this.setMovementCreatedAt(e.getMovementCreatedAt());
        }
        if (e.getMovementUpdatedBy() == null)
        {
            if (e.getIsPropertyMovementUpdatedByRemoved() != null && e.getIsPropertyMovementUpdatedByRemoved())
            {
                this.setMovementUpdatedBy(null);
            }
        }
        else
        {
            this.setMovementUpdatedBy(e.getMovementUpdatedBy());
        }
        if (e.getMovementUpdatedAt() == null)
        {
            if (e.getIsPropertyMovementUpdatedAtRemoved() != null && e.getIsPropertyMovementUpdatedAtRemoved())
            {
                this.setMovementUpdatedAt(null);
            }
        }
        else
        {
            this.setMovementUpdatedAt(e.getMovementUpdatedAt());
        }
        if (e.getMovementActive() == null)
        {
            if (e.getIsPropertyMovementActiveRemoved() != null && e.getIsPropertyMovementActiveRemoved())
            {
                this.setMovementActive(null);
            }
        }
        else
        {
            this.setMovementActive(e.getMovementActive());
        }
        if (e.getMovementDeleted() == null)
        {
            if (e.getIsPropertyMovementDeletedRemoved() != null && e.getIsPropertyMovementDeletedRemoved())
            {
                this.setMovementDeleted(null);
            }
        }
        else
        {
            this.setMovementDeleted(e.getMovementDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(MovementLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MovementLineMvoStateEvent stateEvent)
    {
        MovementLineId stateEntityId = this.getMovementLineId(); // Aggregate Id
        MovementLineId eventEntityId = stateEvent.getStateEventId().getMovementLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getMovementVersion();
        Long eventVersion = stateEvent.getStateEventId().getMovementVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getMovementVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementLineMvoState extends AbstractMovementLineMvoState
    {

        public SimpleMovementLineMvoState() {
        }

        public SimpleMovementLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

