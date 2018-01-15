package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class PhysicalInventoryStateEventDto extends AbstractStateEvent
{

    private PhysicalInventoryStateEventIdDto stateEventId;

    PhysicalInventoryStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new PhysicalInventoryStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(PhysicalInventoryStateEventIdDto stateEventId) {
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

    private String warehouseId;

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
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

    private Date movementDate;

    public Date getMovementDate() {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Boolean isApproved;

    public Boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount() {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    private Boolean isQuantityUpdated;

    public Boolean getIsQuantityUpdated() {
        return this.isQuantityUpdated;
    }

    public void setIsQuantityUpdated(Boolean isQuantityUpdated) {
        this.isQuantityUpdated = isQuantityUpdated;
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

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved() {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed) {
        this.isPropertyWarehouseIdRemoved = removed;
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

    private Boolean isPropertyMovementDateRemoved;

    public Boolean getIsPropertyMovementDateRemoved() {
        return this.isPropertyMovementDateRemoved;
    }

    public void setIsPropertyMovementDateRemoved(Boolean removed) {
        this.isPropertyMovementDateRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyIsApprovedRemoved;

    public Boolean getIsPropertyIsApprovedRemoved() {
        return this.isPropertyIsApprovedRemoved;
    }

    public void setIsPropertyIsApprovedRemoved(Boolean removed) {
        this.isPropertyIsApprovedRemoved = removed;
    }

    private Boolean isPropertyApprovalAmountRemoved;

    public Boolean getIsPropertyApprovalAmountRemoved() {
        return this.isPropertyApprovalAmountRemoved;
    }

    public void setIsPropertyApprovalAmountRemoved(Boolean removed) {
        this.isPropertyApprovalAmountRemoved = removed;
    }

    private Boolean isPropertyIsQuantityUpdatedRemoved;

    public Boolean getIsPropertyIsQuantityUpdatedRemoved() {
        return this.isPropertyIsQuantityUpdatedRemoved;
    }

    public void setIsPropertyIsQuantityUpdatedRemoved(Boolean removed) {
        this.isPropertyIsQuantityUpdatedRemoved = removed;
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


    private PhysicalInventoryLineStateEventDto[] physicalInventoryLineEvents;

    public PhysicalInventoryLineStateEventDto[] getPhysicalInventoryLineEvents() {
        return this.physicalInventoryLineEvents;
    }

    public void setPhysicalInventoryLineEvents(PhysicalInventoryLineStateEventDto[] events) {
        this.physicalInventoryLineEvents = events;
    }


	public static class PhysicalInventoryStateCreatedDto extends PhysicalInventoryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PhysicalInventoryStateMergePatchedDto extends PhysicalInventoryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PhysicalInventoryStateDeletedDto extends PhysicalInventoryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

