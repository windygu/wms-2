package org.dddml.wms.domain.inout;

import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InOutStateEventDto extends AbstractStateEvent
{

    private InOutStateEventIdDto stateEventId;

    InOutStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InOutStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InOutStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getDocumentNumber() {
        return getStateEventId().getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber) {
        getStateEventId().setDocumentNumber(documentNumber);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String documentStatusId;

    public String getDocumentStatusId() {
        return this.documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    private Boolean posted;

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    private Boolean processed;

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    private String processing;

    public String getProcessing() {
        return this.processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    private String documentTypeId;

    public String getDocumentTypeId() {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private Date dateOrdered;

    public Date getDateOrdered() {
        return this.dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    private Boolean isPrinted;

    public Boolean getIsPrinted() {
        return this.isPrinted;
    }

    public void setIsPrinted(Boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    private String movementTypeId;

    public String getMovementTypeId() {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId) {
        this.movementTypeId = movementTypeId;
    }

    private Date movementDate;

    public Date getMovementDate() {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    private String businessPartnerId;

    public String getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(String businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    private String warehouseId;

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    private String POReference;

    public String getPOReference() {
        return this.POReference;
    }

    public void setPOReference(String poReference) {
        this.POReference = poReference;
    }

    private String shipperId;

    public String getShipperId() {
        return this.shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    private Date datePrinted;

    public Date getDatePrinted() {
        return this.datePrinted;
    }

    public void setDatePrinted(Date datePrinted) {
        this.datePrinted = datePrinted;
    }

    private String salesRepresentativeId;

    public String getSalesRepresentativeId() {
        return this.salesRepresentativeId;
    }

    public void setSalesRepresentativeId(String salesRepresentativeId) {
        this.salesRepresentativeId = salesRepresentativeId;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages() {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    private Date pickDate;

    public Date getPickDate() {
        return this.pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    private Date shipDate;

    public Date getShipDate() {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    private String trackingNumber;

    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    private Date dateReceived;

    public Date getDateReceived() {
        return this.dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    private Boolean isInTransit;

    public Boolean getIsInTransit() {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit) {
        this.isInTransit = isInTransit;
    }

    private Boolean isApproved;

    public Boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    private Boolean isInDispute;

    public Boolean getIsInDispute() {
        return this.isInDispute;
    }

    public void setIsInDispute(Boolean isInDispute) {
        this.isInDispute = isInDispute;
    }

    private String rmaDocumentNumber;

    public String getRmaDocumentNumber() {
        return this.rmaDocumentNumber;
    }

    public void setRmaDocumentNumber(String rmaDocumentNumber) {
        this.rmaDocumentNumber = rmaDocumentNumber;
    }

    private String reversalDocumentNumber;

    public String getReversalDocumentNumber() {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber) {
        this.reversalDocumentNumber = reversalDocumentNumber;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyDocumentStatusIdRemoved;

    public Boolean getIsPropertyDocumentStatusIdRemoved() {
        return this.isPropertyDocumentStatusIdRemoved;
    }

    public void setIsPropertyDocumentStatusIdRemoved(Boolean removed) {
        this.isPropertyDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyPostedRemoved;

    public Boolean getIsPropertyPostedRemoved() {
        return this.isPropertyPostedRemoved;
    }

    public void setIsPropertyPostedRemoved(Boolean removed) {
        this.isPropertyPostedRemoved = removed;
    }

    private Boolean isPropertyProcessedRemoved;

    public Boolean getIsPropertyProcessedRemoved() {
        return this.isPropertyProcessedRemoved;
    }

    public void setIsPropertyProcessedRemoved(Boolean removed) {
        this.isPropertyProcessedRemoved = removed;
    }

    private Boolean isPropertyProcessingRemoved;

    public Boolean getIsPropertyProcessingRemoved() {
        return this.isPropertyProcessingRemoved;
    }

    public void setIsPropertyProcessingRemoved(Boolean removed) {
        this.isPropertyProcessingRemoved = removed;
    }

    private Boolean isPropertyDocumentTypeIdRemoved;

    public Boolean getIsPropertyDocumentTypeIdRemoved() {
        return this.isPropertyDocumentTypeIdRemoved;
    }

    public void setIsPropertyDocumentTypeIdRemoved(Boolean removed) {
        this.isPropertyDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyOrderIdRemoved;

    public Boolean getIsPropertyOrderIdRemoved() {
        return this.isPropertyOrderIdRemoved;
    }

    public void setIsPropertyOrderIdRemoved(Boolean removed) {
        this.isPropertyOrderIdRemoved = removed;
    }

    private Boolean isPropertyDateOrderedRemoved;

    public Boolean getIsPropertyDateOrderedRemoved() {
        return this.isPropertyDateOrderedRemoved;
    }

    public void setIsPropertyDateOrderedRemoved(Boolean removed) {
        this.isPropertyDateOrderedRemoved = removed;
    }

    private Boolean isPropertyIsPrintedRemoved;

    public Boolean getIsPropertyIsPrintedRemoved() {
        return this.isPropertyIsPrintedRemoved;
    }

    public void setIsPropertyIsPrintedRemoved(Boolean removed) {
        this.isPropertyIsPrintedRemoved = removed;
    }

    private Boolean isPropertyMovementTypeIdRemoved;

    public Boolean getIsPropertyMovementTypeIdRemoved() {
        return this.isPropertyMovementTypeIdRemoved;
    }

    public void setIsPropertyMovementTypeIdRemoved(Boolean removed) {
        this.isPropertyMovementTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDateRemoved;

    public Boolean getIsPropertyMovementDateRemoved() {
        return this.isPropertyMovementDateRemoved;
    }

    public void setIsPropertyMovementDateRemoved(Boolean removed) {
        this.isPropertyMovementDateRemoved = removed;
    }

    private Boolean isPropertyBusinessPartnerIdRemoved;

    public Boolean getIsPropertyBusinessPartnerIdRemoved() {
        return this.isPropertyBusinessPartnerIdRemoved;
    }

    public void setIsPropertyBusinessPartnerIdRemoved(Boolean removed) {
        this.isPropertyBusinessPartnerIdRemoved = removed;
    }

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved() {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed) {
        this.isPropertyWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyPOReferenceRemoved;

    public Boolean getIsPropertyPOReferenceRemoved() {
        return this.isPropertyPOReferenceRemoved;
    }

    public void setIsPropertyPOReferenceRemoved(Boolean removed) {
        this.isPropertyPOReferenceRemoved = removed;
    }

    private Boolean isPropertyShipperIdRemoved;

    public Boolean getIsPropertyShipperIdRemoved() {
        return this.isPropertyShipperIdRemoved;
    }

    public void setIsPropertyShipperIdRemoved(Boolean removed) {
        this.isPropertyShipperIdRemoved = removed;
    }

    private Boolean isPropertyDatePrintedRemoved;

    public Boolean getIsPropertyDatePrintedRemoved() {
        return this.isPropertyDatePrintedRemoved;
    }

    public void setIsPropertyDatePrintedRemoved(Boolean removed) {
        this.isPropertyDatePrintedRemoved = removed;
    }

    private Boolean isPropertySalesRepresentativeIdRemoved;

    public Boolean getIsPropertySalesRepresentativeIdRemoved() {
        return this.isPropertySalesRepresentativeIdRemoved;
    }

    public void setIsPropertySalesRepresentativeIdRemoved(Boolean removed) {
        this.isPropertySalesRepresentativeIdRemoved = removed;
    }

    private Boolean isPropertyNumberOfPackagesRemoved;

    public Boolean getIsPropertyNumberOfPackagesRemoved() {
        return this.isPropertyNumberOfPackagesRemoved;
    }

    public void setIsPropertyNumberOfPackagesRemoved(Boolean removed) {
        this.isPropertyNumberOfPackagesRemoved = removed;
    }

    private Boolean isPropertyPickDateRemoved;

    public Boolean getIsPropertyPickDateRemoved() {
        return this.isPropertyPickDateRemoved;
    }

    public void setIsPropertyPickDateRemoved(Boolean removed) {
        this.isPropertyPickDateRemoved = removed;
    }

    private Boolean isPropertyShipDateRemoved;

    public Boolean getIsPropertyShipDateRemoved() {
        return this.isPropertyShipDateRemoved;
    }

    public void setIsPropertyShipDateRemoved(Boolean removed) {
        this.isPropertyShipDateRemoved = removed;
    }

    private Boolean isPropertyTrackingNumberRemoved;

    public Boolean getIsPropertyTrackingNumberRemoved() {
        return this.isPropertyTrackingNumberRemoved;
    }

    public void setIsPropertyTrackingNumberRemoved(Boolean removed) {
        this.isPropertyTrackingNumberRemoved = removed;
    }

    private Boolean isPropertyDateReceivedRemoved;

    public Boolean getIsPropertyDateReceivedRemoved() {
        return this.isPropertyDateReceivedRemoved;
    }

    public void setIsPropertyDateReceivedRemoved(Boolean removed) {
        this.isPropertyDateReceivedRemoved = removed;
    }

    private Boolean isPropertyIsInTransitRemoved;

    public Boolean getIsPropertyIsInTransitRemoved() {
        return this.isPropertyIsInTransitRemoved;
    }

    public void setIsPropertyIsInTransitRemoved(Boolean removed) {
        this.isPropertyIsInTransitRemoved = removed;
    }

    private Boolean isPropertyIsApprovedRemoved;

    public Boolean getIsPropertyIsApprovedRemoved() {
        return this.isPropertyIsApprovedRemoved;
    }

    public void setIsPropertyIsApprovedRemoved(Boolean removed) {
        this.isPropertyIsApprovedRemoved = removed;
    }

    private Boolean isPropertyIsInDisputeRemoved;

    public Boolean getIsPropertyIsInDisputeRemoved() {
        return this.isPropertyIsInDisputeRemoved;
    }

    public void setIsPropertyIsInDisputeRemoved(Boolean removed) {
        this.isPropertyIsInDisputeRemoved = removed;
    }

    private Boolean isPropertyRmaDocumentNumberRemoved;

    public Boolean getIsPropertyRmaDocumentNumberRemoved() {
        return this.isPropertyRmaDocumentNumberRemoved;
    }

    public void setIsPropertyRmaDocumentNumberRemoved(Boolean removed) {
        this.isPropertyRmaDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyReversalDocumentNumberRemoved;

    public Boolean getIsPropertyReversalDocumentNumberRemoved() {
        return this.isPropertyReversalDocumentNumberRemoved;
    }

    public void setIsPropertyReversalDocumentNumberRemoved(Boolean removed) {
        this.isPropertyReversalDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private InOutLineStateEventDto[] inOutLineEvents;

    public InOutLineStateEventDto[] getInOutLineEvents() {
        return this.inOutLineEvents;
    }

    public void setInOutLineEvents(InOutLineStateEventDto[] events) {
        this.inOutLineEvents = events;
    }


	public static class InOutStateCreatedDto extends InOutStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InOutStateMergePatchedDto extends InOutStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InOutStateDeletedDto extends InOutStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

