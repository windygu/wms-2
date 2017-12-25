package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inoutlinemvo.InOutLineMvoStateEvent.*;

public abstract class AbstractInOutLineMvoState implements InOutLineMvoState
{

    private InOutLineId inOutLineId;

    public InOutLineId getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineId inOutLineId)
    {
        this.inOutLineId = inOutLineId;
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
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

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
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

    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private BigDecimal pickedQuantity;

    public BigDecimal getPickedQuantity()
    {
        return this.pickedQuantity;
    }

    public void setPickedQuantity(BigDecimal pickedQuantity)
    {
        this.pickedQuantity = pickedQuantity;
    }

    private Boolean isInvoiced;

    public Boolean getIsInvoiced()
    {
        return this.isInvoiced;
    }

    public void setIsInvoiced(Boolean isInvoiced)
    {
        this.isInvoiced = isInvoiced;
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

    private BigDecimal quantityEntered;

    public BigDecimal getQuantityEntered()
    {
        return this.quantityEntered;
    }

    public void setQuantityEntered(BigDecimal quantityEntered)
    {
        this.quantityEntered = quantityEntered;
    }

    private Long rmaLineNumber;

    public Long getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(Long rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
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

    private String inOutDocumentStatusId;

    public String getInOutDocumentStatusId()
    {
        return this.inOutDocumentStatusId;
    }

    public void setInOutDocumentStatusId(String inOutDocumentStatusId)
    {
        this.inOutDocumentStatusId = inOutDocumentStatusId;
    }

    private Boolean inOutPosted;

    public Boolean getInOutPosted()
    {
        return this.inOutPosted;
    }

    public void setInOutPosted(Boolean inOutPosted)
    {
        this.inOutPosted = inOutPosted;
    }

    private Boolean inOutProcessed;

    public Boolean getInOutProcessed()
    {
        return this.inOutProcessed;
    }

    public void setInOutProcessed(Boolean inOutProcessed)
    {
        this.inOutProcessed = inOutProcessed;
    }

    private String inOutProcessing;

    public String getInOutProcessing()
    {
        return this.inOutProcessing;
    }

    public void setInOutProcessing(String inOutProcessing)
    {
        this.inOutProcessing = inOutProcessing;
    }

    private String inOutDocumentTypeId;

    public String getInOutDocumentTypeId()
    {
        return this.inOutDocumentTypeId;
    }

    public void setInOutDocumentTypeId(String inOutDocumentTypeId)
    {
        this.inOutDocumentTypeId = inOutDocumentTypeId;
    }

    private String inOutDescription;

    public String getInOutDescription()
    {
        return this.inOutDescription;
    }

    public void setInOutDescription(String inOutDescription)
    {
        this.inOutDescription = inOutDescription;
    }

    private String inOutOrderId;

    public String getInOutOrderId()
    {
        return this.inOutOrderId;
    }

    public void setInOutOrderId(String inOutOrderId)
    {
        this.inOutOrderId = inOutOrderId;
    }

    private Date inOutDateOrdered;

    public Date getInOutDateOrdered()
    {
        return this.inOutDateOrdered;
    }

    public void setInOutDateOrdered(Date inOutDateOrdered)
    {
        this.inOutDateOrdered = inOutDateOrdered;
    }

    private Boolean inOutIsPrinted;

    public Boolean getInOutIsPrinted()
    {
        return this.inOutIsPrinted;
    }

    public void setInOutIsPrinted(Boolean inOutIsPrinted)
    {
        this.inOutIsPrinted = inOutIsPrinted;
    }

    private String inOutMovementTypeId;

    public String getInOutMovementTypeId()
    {
        return this.inOutMovementTypeId;
    }

    public void setInOutMovementTypeId(String inOutMovementTypeId)
    {
        this.inOutMovementTypeId = inOutMovementTypeId;
    }

    private Date inOutMovementDate;

    public Date getInOutMovementDate()
    {
        return this.inOutMovementDate;
    }

    public void setInOutMovementDate(Date inOutMovementDate)
    {
        this.inOutMovementDate = inOutMovementDate;
    }

    private String inOutBusinessPartnerId;

    public String getInOutBusinessPartnerId()
    {
        return this.inOutBusinessPartnerId;
    }

    public void setInOutBusinessPartnerId(String inOutBusinessPartnerId)
    {
        this.inOutBusinessPartnerId = inOutBusinessPartnerId;
    }

    private String inOutWarehouseId;

    public String getInOutWarehouseId()
    {
        return this.inOutWarehouseId;
    }

    public void setInOutWarehouseId(String inOutWarehouseId)
    {
        this.inOutWarehouseId = inOutWarehouseId;
    }

    private String inOutPOReference;

    public String getInOutPOReference()
    {
        return this.inOutPOReference;
    }

    public void setInOutPOReference(String inOutPOReference)
    {
        this.inOutPOReference = inOutPOReference;
    }

    private String inOutShipperId;

    public String getInOutShipperId()
    {
        return this.inOutShipperId;
    }

    public void setInOutShipperId(String inOutShipperId)
    {
        this.inOutShipperId = inOutShipperId;
    }

    private Date inOutDatePrinted;

    public Date getInOutDatePrinted()
    {
        return this.inOutDatePrinted;
    }

    public void setInOutDatePrinted(Date inOutDatePrinted)
    {
        this.inOutDatePrinted = inOutDatePrinted;
    }

    private String inOutSalesRepresentative;

    public String getInOutSalesRepresentative()
    {
        return this.inOutSalesRepresentative;
    }

    public void setInOutSalesRepresentative(String inOutSalesRepresentative)
    {
        this.inOutSalesRepresentative = inOutSalesRepresentative;
    }

    private Integer inOutNumberOfPackages;

    public Integer getInOutNumberOfPackages()
    {
        return this.inOutNumberOfPackages;
    }

    public void setInOutNumberOfPackages(Integer inOutNumberOfPackages)
    {
        this.inOutNumberOfPackages = inOutNumberOfPackages;
    }

    private Date inOutPickDate;

    public Date getInOutPickDate()
    {
        return this.inOutPickDate;
    }

    public void setInOutPickDate(Date inOutPickDate)
    {
        this.inOutPickDate = inOutPickDate;
    }

    private Date inOutShipDate;

    public Date getInOutShipDate()
    {
        return this.inOutShipDate;
    }

    public void setInOutShipDate(Date inOutShipDate)
    {
        this.inOutShipDate = inOutShipDate;
    }

    private String inOutTrackingNumber;

    public String getInOutTrackingNumber()
    {
        return this.inOutTrackingNumber;
    }

    public void setInOutTrackingNumber(String inOutTrackingNumber)
    {
        this.inOutTrackingNumber = inOutTrackingNumber;
    }

    private Date inOutDateReceived;

    public Date getInOutDateReceived()
    {
        return this.inOutDateReceived;
    }

    public void setInOutDateReceived(Date inOutDateReceived)
    {
        this.inOutDateReceived = inOutDateReceived;
    }

    private Boolean inOutIsInTransit;

    public Boolean getInOutIsInTransit()
    {
        return this.inOutIsInTransit;
    }

    public void setInOutIsInTransit(Boolean inOutIsInTransit)
    {
        this.inOutIsInTransit = inOutIsInTransit;
    }

    private Boolean inOutIsApproved;

    public Boolean getInOutIsApproved()
    {
        return this.inOutIsApproved;
    }

    public void setInOutIsApproved(Boolean inOutIsApproved)
    {
        this.inOutIsApproved = inOutIsApproved;
    }

    private Boolean inOutIsInDispute;

    public Boolean getInOutIsInDispute()
    {
        return this.inOutIsInDispute;
    }

    public void setInOutIsInDispute(Boolean inOutIsInDispute)
    {
        this.inOutIsInDispute = inOutIsInDispute;
    }

    private String inOutRmaNumber;

    public String getInOutRmaNumber()
    {
        return this.inOutRmaNumber;
    }

    public void setInOutRmaNumber(String inOutRmaNumber)
    {
        this.inOutRmaNumber = inOutRmaNumber;
    }

    private String inOutReversalNumber;

    public String getInOutReversalNumber()
    {
        return this.inOutReversalNumber;
    }

    public void setInOutReversalNumber(String inOutReversalNumber)
    {
        this.inOutReversalNumber = inOutReversalNumber;
    }

    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
    }

    private String inOutCreatedBy;

    public String getInOutCreatedBy()
    {
        return this.inOutCreatedBy;
    }

    public void setInOutCreatedBy(String inOutCreatedBy)
    {
        this.inOutCreatedBy = inOutCreatedBy;
    }

    private Date inOutCreatedAt;

    public Date getInOutCreatedAt()
    {
        return this.inOutCreatedAt;
    }

    public void setInOutCreatedAt(Date inOutCreatedAt)
    {
        this.inOutCreatedAt = inOutCreatedAt;
    }

    private String inOutUpdatedBy;

    public String getInOutUpdatedBy()
    {
        return this.inOutUpdatedBy;
    }

    public void setInOutUpdatedBy(String inOutUpdatedBy)
    {
        this.inOutUpdatedBy = inOutUpdatedBy;
    }

    private Date inOutUpdatedAt;

    public Date getInOutUpdatedAt()
    {
        return this.inOutUpdatedAt;
    }

    public void setInOutUpdatedAt(Date inOutUpdatedAt)
    {
        this.inOutUpdatedAt = inOutUpdatedAt;
    }

    private Boolean inOutActive;

    public Boolean getInOutActive()
    {
        return this.inOutActive;
    }

    public void setInOutActive(Boolean inOutActive)
    {
        this.inOutActive = inOutActive;
    }

    private Boolean inOutDeleted;

    public Boolean getInOutDeleted()
    {
        return this.inOutDeleted;
    }

    public void setInOutDeleted(Boolean inOutDeleted)
    {
        this.inOutDeleted = inOutDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getInOutVersion() == null;
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

    public AbstractInOutLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInOutLineId(((InOutLineMvoStateEvent) events.get(0)).getStateEventId().getInOutLineId());
            for (Event e : events) {
                mutate(e);
                this.setInOutVersion(this.getInOutVersion() + 1);
            }
        }
    }


    public AbstractInOutLineMvoState() {
        this(false);
    }

    public AbstractInOutLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutLineMvoStateCreated) {
            when((InOutLineMvoStateCreated) e);
        } else if (e instanceof InOutLineMvoStateMergePatched) {
            when((InOutLineMvoStateMergePatched) e);
        } else if (e instanceof InOutLineMvoStateDeleted) {
            when((InOutLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setLocatorId(e.getLocatorId());
        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setDescription(e.getDescription());
        this.setUomId(e.getUomId());
        this.setMovementQuantity(e.getMovementQuantity());
        this.setConfirmedQuantity(e.getConfirmedQuantity());
        this.setScrappedQuantity(e.getScrappedQuantity());
        this.setTargetQuantity(e.getTargetQuantity());
        this.setPickedQuantity(e.getPickedQuantity());
        this.setIsInvoiced(e.getIsInvoiced());
        this.setProcessed(e.getProcessed());
        this.setQuantityEntered(e.getQuantityEntered());
        this.setRmaLineNumber(e.getRmaLineNumber());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setInOutDocumentStatusId(e.getInOutDocumentStatusId());
        this.setInOutPosted(e.getInOutPosted());
        this.setInOutProcessed(e.getInOutProcessed());
        this.setInOutProcessing(e.getInOutProcessing());
        this.setInOutDocumentTypeId(e.getInOutDocumentTypeId());
        this.setInOutDescription(e.getInOutDescription());
        this.setInOutOrderId(e.getInOutOrderId());
        this.setInOutDateOrdered(e.getInOutDateOrdered());
        this.setInOutIsPrinted(e.getInOutIsPrinted());
        this.setInOutMovementTypeId(e.getInOutMovementTypeId());
        this.setInOutMovementDate(e.getInOutMovementDate());
        this.setInOutBusinessPartnerId(e.getInOutBusinessPartnerId());
        this.setInOutWarehouseId(e.getInOutWarehouseId());
        this.setInOutPOReference(e.getInOutPOReference());
        this.setInOutShipperId(e.getInOutShipperId());
        this.setInOutDatePrinted(e.getInOutDatePrinted());
        this.setInOutSalesRepresentative(e.getInOutSalesRepresentative());
        this.setInOutNumberOfPackages(e.getInOutNumberOfPackages());
        this.setInOutPickDate(e.getInOutPickDate());
        this.setInOutShipDate(e.getInOutShipDate());
        this.setInOutTrackingNumber(e.getInOutTrackingNumber());
        this.setInOutDateReceived(e.getInOutDateReceived());
        this.setInOutIsInTransit(e.getInOutIsInTransit());
        this.setInOutIsApproved(e.getInOutIsApproved());
        this.setInOutIsInDispute(e.getInOutIsInDispute());
        this.setInOutRmaNumber(e.getInOutRmaNumber());
        this.setInOutReversalNumber(e.getInOutReversalNumber());
        this.setInOutCreatedBy(e.getInOutCreatedBy());
        this.setInOutCreatedAt(e.getInOutCreatedAt());
        this.setInOutUpdatedBy(e.getInOutUpdatedBy());
        this.setInOutUpdatedAt(e.getInOutUpdatedAt());
        this.setInOutActive(e.getInOutActive());
        this.setInOutDeleted(e.getInOutDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InOutLineMvoStateMergePatched e)
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
        if (e.getUomId() == null)
        {
            if (e.getIsPropertyUomIdRemoved() != null && e.getIsPropertyUomIdRemoved())
            {
                this.setUomId(null);
            }
        }
        else
        {
            this.setUomId(e.getUomId());
        }
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
        if (e.getPickedQuantity() == null)
        {
            if (e.getIsPropertyPickedQuantityRemoved() != null && e.getIsPropertyPickedQuantityRemoved())
            {
                this.setPickedQuantity(null);
            }
        }
        else
        {
            this.setPickedQuantity(e.getPickedQuantity());
        }
        if (e.getIsInvoiced() == null)
        {
            if (e.getIsPropertyIsInvoicedRemoved() != null && e.getIsPropertyIsInvoicedRemoved())
            {
                this.setIsInvoiced(null);
            }
        }
        else
        {
            this.setIsInvoiced(e.getIsInvoiced());
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
        if (e.getQuantityEntered() == null)
        {
            if (e.getIsPropertyQuantityEnteredRemoved() != null && e.getIsPropertyQuantityEnteredRemoved())
            {
                this.setQuantityEntered(null);
            }
        }
        else
        {
            this.setQuantityEntered(e.getQuantityEntered());
        }
        if (e.getRmaLineNumber() == null)
        {
            if (e.getIsPropertyRmaLineNumberRemoved() != null && e.getIsPropertyRmaLineNumberRemoved())
            {
                this.setRmaLineNumber(null);
            }
        }
        else
        {
            this.setRmaLineNumber(e.getRmaLineNumber());
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
        if (e.getInOutDocumentStatusId() == null)
        {
            if (e.getIsPropertyInOutDocumentStatusIdRemoved() != null && e.getIsPropertyInOutDocumentStatusIdRemoved())
            {
                this.setInOutDocumentStatusId(null);
            }
        }
        else
        {
            this.setInOutDocumentStatusId(e.getInOutDocumentStatusId());
        }
        if (e.getInOutPosted() == null)
        {
            if (e.getIsPropertyInOutPostedRemoved() != null && e.getIsPropertyInOutPostedRemoved())
            {
                this.setInOutPosted(null);
            }
        }
        else
        {
            this.setInOutPosted(e.getInOutPosted());
        }
        if (e.getInOutProcessed() == null)
        {
            if (e.getIsPropertyInOutProcessedRemoved() != null && e.getIsPropertyInOutProcessedRemoved())
            {
                this.setInOutProcessed(null);
            }
        }
        else
        {
            this.setInOutProcessed(e.getInOutProcessed());
        }
        if (e.getInOutProcessing() == null)
        {
            if (e.getIsPropertyInOutProcessingRemoved() != null && e.getIsPropertyInOutProcessingRemoved())
            {
                this.setInOutProcessing(null);
            }
        }
        else
        {
            this.setInOutProcessing(e.getInOutProcessing());
        }
        if (e.getInOutDocumentTypeId() == null)
        {
            if (e.getIsPropertyInOutDocumentTypeIdRemoved() != null && e.getIsPropertyInOutDocumentTypeIdRemoved())
            {
                this.setInOutDocumentTypeId(null);
            }
        }
        else
        {
            this.setInOutDocumentTypeId(e.getInOutDocumentTypeId());
        }
        if (e.getInOutDescription() == null)
        {
            if (e.getIsPropertyInOutDescriptionRemoved() != null && e.getIsPropertyInOutDescriptionRemoved())
            {
                this.setInOutDescription(null);
            }
        }
        else
        {
            this.setInOutDescription(e.getInOutDescription());
        }
        if (e.getInOutOrderId() == null)
        {
            if (e.getIsPropertyInOutOrderIdRemoved() != null && e.getIsPropertyInOutOrderIdRemoved())
            {
                this.setInOutOrderId(null);
            }
        }
        else
        {
            this.setInOutOrderId(e.getInOutOrderId());
        }
        if (e.getInOutDateOrdered() == null)
        {
            if (e.getIsPropertyInOutDateOrderedRemoved() != null && e.getIsPropertyInOutDateOrderedRemoved())
            {
                this.setInOutDateOrdered(null);
            }
        }
        else
        {
            this.setInOutDateOrdered(e.getInOutDateOrdered());
        }
        if (e.getInOutIsPrinted() == null)
        {
            if (e.getIsPropertyInOutIsPrintedRemoved() != null && e.getIsPropertyInOutIsPrintedRemoved())
            {
                this.setInOutIsPrinted(null);
            }
        }
        else
        {
            this.setInOutIsPrinted(e.getInOutIsPrinted());
        }
        if (e.getInOutMovementTypeId() == null)
        {
            if (e.getIsPropertyInOutMovementTypeIdRemoved() != null && e.getIsPropertyInOutMovementTypeIdRemoved())
            {
                this.setInOutMovementTypeId(null);
            }
        }
        else
        {
            this.setInOutMovementTypeId(e.getInOutMovementTypeId());
        }
        if (e.getInOutMovementDate() == null)
        {
            if (e.getIsPropertyInOutMovementDateRemoved() != null && e.getIsPropertyInOutMovementDateRemoved())
            {
                this.setInOutMovementDate(null);
            }
        }
        else
        {
            this.setInOutMovementDate(e.getInOutMovementDate());
        }
        if (e.getInOutBusinessPartnerId() == null)
        {
            if (e.getIsPropertyInOutBusinessPartnerIdRemoved() != null && e.getIsPropertyInOutBusinessPartnerIdRemoved())
            {
                this.setInOutBusinessPartnerId(null);
            }
        }
        else
        {
            this.setInOutBusinessPartnerId(e.getInOutBusinessPartnerId());
        }
        if (e.getInOutWarehouseId() == null)
        {
            if (e.getIsPropertyInOutWarehouseIdRemoved() != null && e.getIsPropertyInOutWarehouseIdRemoved())
            {
                this.setInOutWarehouseId(null);
            }
        }
        else
        {
            this.setInOutWarehouseId(e.getInOutWarehouseId());
        }
        if (e.getInOutPOReference() == null)
        {
            if (e.getIsPropertyInOutPOReferenceRemoved() != null && e.getIsPropertyInOutPOReferenceRemoved())
            {
                this.setInOutPOReference(null);
            }
        }
        else
        {
            this.setInOutPOReference(e.getInOutPOReference());
        }
        if (e.getInOutShipperId() == null)
        {
            if (e.getIsPropertyInOutShipperIdRemoved() != null && e.getIsPropertyInOutShipperIdRemoved())
            {
                this.setInOutShipperId(null);
            }
        }
        else
        {
            this.setInOutShipperId(e.getInOutShipperId());
        }
        if (e.getInOutDatePrinted() == null)
        {
            if (e.getIsPropertyInOutDatePrintedRemoved() != null && e.getIsPropertyInOutDatePrintedRemoved())
            {
                this.setInOutDatePrinted(null);
            }
        }
        else
        {
            this.setInOutDatePrinted(e.getInOutDatePrinted());
        }
        if (e.getInOutSalesRepresentative() == null)
        {
            if (e.getIsPropertyInOutSalesRepresentativeRemoved() != null && e.getIsPropertyInOutSalesRepresentativeRemoved())
            {
                this.setInOutSalesRepresentative(null);
            }
        }
        else
        {
            this.setInOutSalesRepresentative(e.getInOutSalesRepresentative());
        }
        if (e.getInOutNumberOfPackages() == null)
        {
            if (e.getIsPropertyInOutNumberOfPackagesRemoved() != null && e.getIsPropertyInOutNumberOfPackagesRemoved())
            {
                this.setInOutNumberOfPackages(null);
            }
        }
        else
        {
            this.setInOutNumberOfPackages(e.getInOutNumberOfPackages());
        }
        if (e.getInOutPickDate() == null)
        {
            if (e.getIsPropertyInOutPickDateRemoved() != null && e.getIsPropertyInOutPickDateRemoved())
            {
                this.setInOutPickDate(null);
            }
        }
        else
        {
            this.setInOutPickDate(e.getInOutPickDate());
        }
        if (e.getInOutShipDate() == null)
        {
            if (e.getIsPropertyInOutShipDateRemoved() != null && e.getIsPropertyInOutShipDateRemoved())
            {
                this.setInOutShipDate(null);
            }
        }
        else
        {
            this.setInOutShipDate(e.getInOutShipDate());
        }
        if (e.getInOutTrackingNumber() == null)
        {
            if (e.getIsPropertyInOutTrackingNumberRemoved() != null && e.getIsPropertyInOutTrackingNumberRemoved())
            {
                this.setInOutTrackingNumber(null);
            }
        }
        else
        {
            this.setInOutTrackingNumber(e.getInOutTrackingNumber());
        }
        if (e.getInOutDateReceived() == null)
        {
            if (e.getIsPropertyInOutDateReceivedRemoved() != null && e.getIsPropertyInOutDateReceivedRemoved())
            {
                this.setInOutDateReceived(null);
            }
        }
        else
        {
            this.setInOutDateReceived(e.getInOutDateReceived());
        }
        if (e.getInOutIsInTransit() == null)
        {
            if (e.getIsPropertyInOutIsInTransitRemoved() != null && e.getIsPropertyInOutIsInTransitRemoved())
            {
                this.setInOutIsInTransit(null);
            }
        }
        else
        {
            this.setInOutIsInTransit(e.getInOutIsInTransit());
        }
        if (e.getInOutIsApproved() == null)
        {
            if (e.getIsPropertyInOutIsApprovedRemoved() != null && e.getIsPropertyInOutIsApprovedRemoved())
            {
                this.setInOutIsApproved(null);
            }
        }
        else
        {
            this.setInOutIsApproved(e.getInOutIsApproved());
        }
        if (e.getInOutIsInDispute() == null)
        {
            if (e.getIsPropertyInOutIsInDisputeRemoved() != null && e.getIsPropertyInOutIsInDisputeRemoved())
            {
                this.setInOutIsInDispute(null);
            }
        }
        else
        {
            this.setInOutIsInDispute(e.getInOutIsInDispute());
        }
        if (e.getInOutRmaNumber() == null)
        {
            if (e.getIsPropertyInOutRmaNumberRemoved() != null && e.getIsPropertyInOutRmaNumberRemoved())
            {
                this.setInOutRmaNumber(null);
            }
        }
        else
        {
            this.setInOutRmaNumber(e.getInOutRmaNumber());
        }
        if (e.getInOutReversalNumber() == null)
        {
            if (e.getIsPropertyInOutReversalNumberRemoved() != null && e.getIsPropertyInOutReversalNumberRemoved())
            {
                this.setInOutReversalNumber(null);
            }
        }
        else
        {
            this.setInOutReversalNumber(e.getInOutReversalNumber());
        }
        if (e.getInOutCreatedBy() == null)
        {
            if (e.getIsPropertyInOutCreatedByRemoved() != null && e.getIsPropertyInOutCreatedByRemoved())
            {
                this.setInOutCreatedBy(null);
            }
        }
        else
        {
            this.setInOutCreatedBy(e.getInOutCreatedBy());
        }
        if (e.getInOutCreatedAt() == null)
        {
            if (e.getIsPropertyInOutCreatedAtRemoved() != null && e.getIsPropertyInOutCreatedAtRemoved())
            {
                this.setInOutCreatedAt(null);
            }
        }
        else
        {
            this.setInOutCreatedAt(e.getInOutCreatedAt());
        }
        if (e.getInOutUpdatedBy() == null)
        {
            if (e.getIsPropertyInOutUpdatedByRemoved() != null && e.getIsPropertyInOutUpdatedByRemoved())
            {
                this.setInOutUpdatedBy(null);
            }
        }
        else
        {
            this.setInOutUpdatedBy(e.getInOutUpdatedBy());
        }
        if (e.getInOutUpdatedAt() == null)
        {
            if (e.getIsPropertyInOutUpdatedAtRemoved() != null && e.getIsPropertyInOutUpdatedAtRemoved())
            {
                this.setInOutUpdatedAt(null);
            }
        }
        else
        {
            this.setInOutUpdatedAt(e.getInOutUpdatedAt());
        }
        if (e.getInOutActive() == null)
        {
            if (e.getIsPropertyInOutActiveRemoved() != null && e.getIsPropertyInOutActiveRemoved())
            {
                this.setInOutActive(null);
            }
        }
        else
        {
            this.setInOutActive(e.getInOutActive());
        }
        if (e.getInOutDeleted() == null)
        {
            if (e.getIsPropertyInOutDeletedRemoved() != null && e.getIsPropertyInOutDeletedRemoved())
            {
                this.setInOutDeleted(null);
            }
        }
        else
        {
            this.setInOutDeleted(e.getInOutDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(InOutLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InOutLineMvoStateEvent stateEvent)
    {
        InOutLineId stateEntityId = this.getInOutLineId(); // Aggregate Id
        InOutLineId eventEntityId = stateEvent.getStateEventId().getInOutLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getInOutVersion();
        Long eventVersion = stateEvent.getStateEventId().getInOutVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getInOutVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InOutLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInOutLineMvoState extends AbstractInOutLineMvoState
    {

        public SimpleInOutLineMvoState() {
        }

        public SimpleInOutLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInOutLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

