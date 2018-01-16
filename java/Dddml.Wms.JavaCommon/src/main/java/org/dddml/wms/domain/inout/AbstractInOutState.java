package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inout.InOutStateEvent.*;

public abstract class AbstractInOutState implements InOutState, Saveable
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private Date dateOrdered;

    public Date getDateOrdered()
    {
        return this.dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered)
    {
        this.dateOrdered = dateOrdered;
    }

    private Boolean isPrinted;

    public Boolean getIsPrinted()
    {
        return this.isPrinted;
    }

    public void setIsPrinted(Boolean isPrinted)
    {
        this.isPrinted = isPrinted;
    }

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
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

    private String businessPartnerId;

    public String getBusinessPartnerId()
    {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(String businessPartnerId)
    {
        this.businessPartnerId = businessPartnerId;
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

    private String POReference;

    public String getPOReference()
    {
        return this.POReference;
    }

    public void setPOReference(String poReference)
    {
        this.POReference = poReference;
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

    private String shipperId;

    public String getShipperId()
    {
        return this.shipperId;
    }

    public void setShipperId(String shipperId)
    {
        this.shipperId = shipperId;
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

    private Date datePrinted;

    public Date getDatePrinted()
    {
        return this.datePrinted;
    }

    public void setDatePrinted(Date datePrinted)
    {
        this.datePrinted = datePrinted;
    }

    private String createdFrom;

    public String getCreatedFrom()
    {
        return this.createdFrom;
    }

    public void setCreatedFrom(String createdFrom)
    {
        this.createdFrom = createdFrom;
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

    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    private Date pickDate;

    public Date getPickDate()
    {
        return this.pickDate;
    }

    public void setPickDate(Date pickDate)
    {
        this.pickDate = pickDate;
    }

    private Date shipDate;

    public Date getShipDate()
    {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate)
    {
        this.shipDate = shipDate;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
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

    private Boolean isInDispute;

    public Boolean getIsInDispute()
    {
        return this.isInDispute;
    }

    public void setIsInDispute(Boolean isInDispute)
    {
        this.isInDispute = isInDispute;
    }

    private String rmaDocumentNumber;

    public String getRmaDocumentNumber()
    {
        return this.rmaDocumentNumber;
    }

    public void setRmaDocumentNumber(String rmaDocumentNumber)
    {
        this.rmaDocumentNumber = rmaDocumentNumber;
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

    private InOutLineStates inOutLines;

    public InOutLineStates getInOutLines()
    {
        return this.inOutLines;
    }

    public void setInOutLines(InOutLineStates inOutLines)
    {
        this.inOutLines = inOutLines;
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

    public AbstractInOutState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDocumentNumber(((InOutStateEvent) events.get(0)).getStateEventId().getDocumentNumber());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInOutState() {
        this(false);
    }

    public AbstractInOutState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        inOutLines = new SimpleInOutLineStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutStateCreated) {
            when((InOutStateCreated) e);
        } else if (e instanceof InOutStateMergePatched) {
            when((InOutStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDocumentStatusId(e.getDocumentStatusId());
        this.setPosted(e.getPosted());
        this.setProcessed(e.getProcessed());
        this.setProcessing(e.getProcessing());
        this.setDocumentTypeId(e.getDocumentTypeId());
        this.setDescription(e.getDescription());
        this.setOrderId(e.getOrderId());
        this.setDateOrdered(e.getDateOrdered());
        this.setIsPrinted(e.getIsPrinted());
        this.setMovementTypeId(e.getMovementTypeId());
        this.setMovementDate(e.getMovementDate());
        this.setBusinessPartnerId(e.getBusinessPartnerId());
        this.setWarehouseId(e.getWarehouseId());
        this.setPOReference(e.getPOReference());
        this.setFreightAmount(e.getFreightAmount());
        this.setShipperId(e.getShipperId());
        this.setChargeAmount(e.getChargeAmount());
        this.setDatePrinted(e.getDatePrinted());
        this.setCreatedFrom(e.getCreatedFrom());
        this.setSalesRepresentativeId(e.getSalesRepresentativeId());
        this.setNumberOfPackages(e.getNumberOfPackages());
        this.setPickDate(e.getPickDate());
        this.setShipDate(e.getShipDate());
        this.setTrackingNumber(e.getTrackingNumber());
        this.setDateReceived(e.getDateReceived());
        this.setIsInTransit(e.getIsInTransit());
        this.setIsApproved(e.getIsApproved());
        this.setIsInDispute(e.getIsInDispute());
        this.setRmaDocumentNumber(e.getRmaDocumentNumber());
        this.setReversalDocumentNumber(e.getReversalDocumentNumber());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (InOutLineStateEvent.InOutLineStateCreated innerEvent : e.getInOutLineEvents()) {
            InOutLineState innerState = this.getInOutLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
        }
    }

    public void when(InOutStateMergePatched e)
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
        if (e.getOrderId() == null)
        {
            if (e.getIsPropertyOrderIdRemoved() != null && e.getIsPropertyOrderIdRemoved())
            {
                this.setOrderId(null);
            }
        }
        else
        {
            this.setOrderId(e.getOrderId());
        }
        if (e.getDateOrdered() == null)
        {
            if (e.getIsPropertyDateOrderedRemoved() != null && e.getIsPropertyDateOrderedRemoved())
            {
                this.setDateOrdered(null);
            }
        }
        else
        {
            this.setDateOrdered(e.getDateOrdered());
        }
        if (e.getIsPrinted() == null)
        {
            if (e.getIsPropertyIsPrintedRemoved() != null && e.getIsPropertyIsPrintedRemoved())
            {
                this.setIsPrinted(null);
            }
        }
        else
        {
            this.setIsPrinted(e.getIsPrinted());
        }
        if (e.getMovementTypeId() == null)
        {
            if (e.getIsPropertyMovementTypeIdRemoved() != null && e.getIsPropertyMovementTypeIdRemoved())
            {
                this.setMovementTypeId(null);
            }
        }
        else
        {
            this.setMovementTypeId(e.getMovementTypeId());
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
        if (e.getPOReference() == null)
        {
            if (e.getIsPropertyPOReferenceRemoved() != null && e.getIsPropertyPOReferenceRemoved())
            {
                this.setPOReference(null);
            }
        }
        else
        {
            this.setPOReference(e.getPOReference());
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
        if (e.getDatePrinted() == null)
        {
            if (e.getIsPropertyDatePrintedRemoved() != null && e.getIsPropertyDatePrintedRemoved())
            {
                this.setDatePrinted(null);
            }
        }
        else
        {
            this.setDatePrinted(e.getDatePrinted());
        }
        if (e.getCreatedFrom() == null)
        {
            if (e.getIsPropertyCreatedFromRemoved() != null && e.getIsPropertyCreatedFromRemoved())
            {
                this.setCreatedFrom(null);
            }
        }
        else
        {
            this.setCreatedFrom(e.getCreatedFrom());
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
        if (e.getNumberOfPackages() == null)
        {
            if (e.getIsPropertyNumberOfPackagesRemoved() != null && e.getIsPropertyNumberOfPackagesRemoved())
            {
                this.setNumberOfPackages(null);
            }
        }
        else
        {
            this.setNumberOfPackages(e.getNumberOfPackages());
        }
        if (e.getPickDate() == null)
        {
            if (e.getIsPropertyPickDateRemoved() != null && e.getIsPropertyPickDateRemoved())
            {
                this.setPickDate(null);
            }
        }
        else
        {
            this.setPickDate(e.getPickDate());
        }
        if (e.getShipDate() == null)
        {
            if (e.getIsPropertyShipDateRemoved() != null && e.getIsPropertyShipDateRemoved())
            {
                this.setShipDate(null);
            }
        }
        else
        {
            this.setShipDate(e.getShipDate());
        }
        if (e.getTrackingNumber() == null)
        {
            if (e.getIsPropertyTrackingNumberRemoved() != null && e.getIsPropertyTrackingNumberRemoved())
            {
                this.setTrackingNumber(null);
            }
        }
        else
        {
            this.setTrackingNumber(e.getTrackingNumber());
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
        if (e.getIsInDispute() == null)
        {
            if (e.getIsPropertyIsInDisputeRemoved() != null && e.getIsPropertyIsInDisputeRemoved())
            {
                this.setIsInDispute(null);
            }
        }
        else
        {
            this.setIsInDispute(e.getIsInDispute());
        }
        if (e.getRmaDocumentNumber() == null)
        {
            if (e.getIsPropertyRmaDocumentNumberRemoved() != null && e.getIsPropertyRmaDocumentNumberRemoved())
            {
                this.setRmaDocumentNumber(null);
            }
        }
        else
        {
            this.setRmaDocumentNumber(e.getRmaDocumentNumber());
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

        for (InOutLineStateEvent innerEvent : e.getInOutLineEvents()) {
            InOutLineState innerState = this.getInOutLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof InOutLineStateEvent.InOutLineStateRemoved)
            {
                //InOutLineStateEvent.InOutLineStateRemoved removed = (InOutLineStateEvent.InOutLineStateRemoved)innerEvent;
                this.getInOutLines().remove(innerState);
            }
        }
    }

    public void save()
    {
        inOutLines.save();

    }

    protected void throwOnWrongEvent(InOutStateEvent stateEvent)
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
        if (!(stateVersion == null && eventVersion.equals(InOutState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInOutState extends AbstractInOutState
    {

        public SimpleInOutState() {
        }

        public SimpleInOutState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInOutState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleInOutLineStates extends AbstractInOutLineStates
    {
        public SimpleInOutLineStates(AbstractInOutState outerState)
        {
            super(outerState);
        }
    }


}

