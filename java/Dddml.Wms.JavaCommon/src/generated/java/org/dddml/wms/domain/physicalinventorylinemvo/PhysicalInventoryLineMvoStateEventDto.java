package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class PhysicalInventoryLineMvoStateEventDto extends AbstractStateEvent
{

    private PhysicalInventoryLineMvoStateEventId stateEventId;

    PhysicalInventoryLineMvoStateEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new PhysicalInventoryLineMvoStateEventId(); }
        return this.stateEventId;
    }

    void setStateEventId(PhysicalInventoryLineMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    public PhysicalInventoryLineId getPhysicalInventoryLineId() {
        return getStateEventId().getPhysicalInventoryLineId();
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId) {
        getStateEventId().setPhysicalInventoryLineId(physicalInventoryLineId);
    }

    public Long getPhysicalInventoryVersion() {
        return getStateEventId().getPhysicalInventoryVersion();
    }
    
    public void getPhysicalInventoryVersion(Long physicalInventoryVersion) {
        getStateEventId().setPhysicalInventoryVersion(physicalInventoryVersion);
    }

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity() {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity() {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity) {
        this.countedQuantity = countedQuantity;
    }

    private Boolean processed;

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    private Long reversalLineNumber;

    public Long getReversalLineNumber() {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber) {
        this.reversalLineNumber = reversalLineNumber;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private String physicalInventoryDocumentStatusId;

    public String getPhysicalInventoryDocumentStatusId() {
        return this.physicalInventoryDocumentStatusId;
    }

    public void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId) {
        this.physicalInventoryDocumentStatusId = physicalInventoryDocumentStatusId;
    }

    private String physicalInventoryWarehouseId;

    public String getPhysicalInventoryWarehouseId() {
        return this.physicalInventoryWarehouseId;
    }

    public void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId) {
        this.physicalInventoryWarehouseId = physicalInventoryWarehouseId;
    }

    private String physicalInventoryLocatorIdPattern;

    public String getPhysicalInventoryLocatorIdPattern() {
        return this.physicalInventoryLocatorIdPattern;
    }

    public void setPhysicalInventoryLocatorIdPattern(String physicalInventoryLocatorIdPattern) {
        this.physicalInventoryLocatorIdPattern = physicalInventoryLocatorIdPattern;
    }

    private String physicalInventoryProductIdPattern;

    public String getPhysicalInventoryProductIdPattern() {
        return this.physicalInventoryProductIdPattern;
    }

    public void setPhysicalInventoryProductIdPattern(String physicalInventoryProductIdPattern) {
        this.physicalInventoryProductIdPattern = physicalInventoryProductIdPattern;
    }

    private Boolean physicalInventoryPosted;

    public Boolean getPhysicalInventoryPosted() {
        return this.physicalInventoryPosted;
    }

    public void setPhysicalInventoryPosted(Boolean physicalInventoryPosted) {
        this.physicalInventoryPosted = physicalInventoryPosted;
    }

    private Boolean physicalInventoryProcessed;

    public Boolean getPhysicalInventoryProcessed() {
        return this.physicalInventoryProcessed;
    }

    public void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed) {
        this.physicalInventoryProcessed = physicalInventoryProcessed;
    }

    private String physicalInventoryProcessing;

    public String getPhysicalInventoryProcessing() {
        return this.physicalInventoryProcessing;
    }

    public void setPhysicalInventoryProcessing(String physicalInventoryProcessing) {
        this.physicalInventoryProcessing = physicalInventoryProcessing;
    }

    private String physicalInventoryDocumentTypeId;

    public String getPhysicalInventoryDocumentTypeId() {
        return this.physicalInventoryDocumentTypeId;
    }

    public void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId) {
        this.physicalInventoryDocumentTypeId = physicalInventoryDocumentTypeId;
    }

    private Date physicalInventoryMovementDate;

    public Date getPhysicalInventoryMovementDate() {
        return this.physicalInventoryMovementDate;
    }

    public void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate) {
        this.physicalInventoryMovementDate = physicalInventoryMovementDate;
    }

    private String physicalInventoryDescription;

    public String getPhysicalInventoryDescription() {
        return this.physicalInventoryDescription;
    }

    public void setPhysicalInventoryDescription(String physicalInventoryDescription) {
        this.physicalInventoryDescription = physicalInventoryDescription;
    }

    private Boolean physicalInventoryIsApproved;

    public Boolean getPhysicalInventoryIsApproved() {
        return this.physicalInventoryIsApproved;
    }

    public void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved) {
        this.physicalInventoryIsApproved = physicalInventoryIsApproved;
    }

    private BigDecimal physicalInventoryApprovalAmount;

    public BigDecimal getPhysicalInventoryApprovalAmount() {
        return this.physicalInventoryApprovalAmount;
    }

    public void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount) {
        this.physicalInventoryApprovalAmount = physicalInventoryApprovalAmount;
    }

    private Boolean physicalInventoryIsQuantityUpdated;

    public Boolean getPhysicalInventoryIsQuantityUpdated() {
        return this.physicalInventoryIsQuantityUpdated;
    }

    public void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated) {
        this.physicalInventoryIsQuantityUpdated = physicalInventoryIsQuantityUpdated;
    }

    private String physicalInventoryReversalDocumentNumber;

    public String getPhysicalInventoryReversalDocumentNumber() {
        return this.physicalInventoryReversalDocumentNumber;
    }

    public void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber) {
        this.physicalInventoryReversalDocumentNumber = physicalInventoryReversalDocumentNumber;
    }

    private String physicalInventoryCreatedBy;

    public String getPhysicalInventoryCreatedBy() {
        return this.physicalInventoryCreatedBy;
    }

    public void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy) {
        this.physicalInventoryCreatedBy = physicalInventoryCreatedBy;
    }

    private Date physicalInventoryCreatedAt;

    public Date getPhysicalInventoryCreatedAt() {
        return this.physicalInventoryCreatedAt;
    }

    public void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt) {
        this.physicalInventoryCreatedAt = physicalInventoryCreatedAt;
    }

    private String physicalInventoryUpdatedBy;

    public String getPhysicalInventoryUpdatedBy() {
        return this.physicalInventoryUpdatedBy;
    }

    public void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy) {
        this.physicalInventoryUpdatedBy = physicalInventoryUpdatedBy;
    }

    private Date physicalInventoryUpdatedAt;

    public Date getPhysicalInventoryUpdatedAt() {
        return this.physicalInventoryUpdatedAt;
    }

    public void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt) {
        this.physicalInventoryUpdatedAt = physicalInventoryUpdatedAt;
    }

    private Boolean physicalInventoryActive;

    public Boolean getPhysicalInventoryActive() {
        return this.physicalInventoryActive;
    }

    public void setPhysicalInventoryActive(Boolean physicalInventoryActive) {
        this.physicalInventoryActive = physicalInventoryActive;
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

    private Boolean isPropertyBookQuantityRemoved;

    public Boolean getIsPropertyBookQuantityRemoved() {
        return this.isPropertyBookQuantityRemoved;
    }

    public void setIsPropertyBookQuantityRemoved(Boolean removed) {
        this.isPropertyBookQuantityRemoved = removed;
    }

    private Boolean isPropertyCountedQuantityRemoved;

    public Boolean getIsPropertyCountedQuantityRemoved() {
        return this.isPropertyCountedQuantityRemoved;
    }

    public void setIsPropertyCountedQuantityRemoved(Boolean removed) {
        this.isPropertyCountedQuantityRemoved = removed;
    }

    private Boolean isPropertyProcessedRemoved;

    public Boolean getIsPropertyProcessedRemoved() {
        return this.isPropertyProcessedRemoved;
    }

    public void setIsPropertyProcessedRemoved(Boolean removed) {
        this.isPropertyProcessedRemoved = removed;
    }

    private Boolean isPropertyReversalLineNumberRemoved;

    public Boolean getIsPropertyReversalLineNumberRemoved() {
        return this.isPropertyReversalLineNumberRemoved;
    }

    public void setIsPropertyReversalLineNumberRemoved(Boolean removed) {
        this.isPropertyReversalLineNumberRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryDocumentStatusIdRemoved;

    public Boolean getIsPropertyPhysicalInventoryDocumentStatusIdRemoved() {
        return this.isPropertyPhysicalInventoryDocumentStatusIdRemoved;
    }

    public void setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryWarehouseIdRemoved;

    public Boolean getIsPropertyPhysicalInventoryWarehouseIdRemoved() {
        return this.isPropertyPhysicalInventoryWarehouseIdRemoved;
    }

    public void setIsPropertyPhysicalInventoryWarehouseIdRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryLocatorIdPatternRemoved;

    public Boolean getIsPropertyPhysicalInventoryLocatorIdPatternRemoved() {
        return this.isPropertyPhysicalInventoryLocatorIdPatternRemoved;
    }

    public void setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryLocatorIdPatternRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryProductIdPatternRemoved;

    public Boolean getIsPropertyPhysicalInventoryProductIdPatternRemoved() {
        return this.isPropertyPhysicalInventoryProductIdPatternRemoved;
    }

    public void setIsPropertyPhysicalInventoryProductIdPatternRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryProductIdPatternRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryPostedRemoved;

    public Boolean getIsPropertyPhysicalInventoryPostedRemoved() {
        return this.isPropertyPhysicalInventoryPostedRemoved;
    }

    public void setIsPropertyPhysicalInventoryPostedRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryPostedRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryProcessedRemoved;

    public Boolean getIsPropertyPhysicalInventoryProcessedRemoved() {
        return this.isPropertyPhysicalInventoryProcessedRemoved;
    }

    public void setIsPropertyPhysicalInventoryProcessedRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryProcessedRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryProcessingRemoved;

    public Boolean getIsPropertyPhysicalInventoryProcessingRemoved() {
        return this.isPropertyPhysicalInventoryProcessingRemoved;
    }

    public void setIsPropertyPhysicalInventoryProcessingRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryProcessingRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryDocumentTypeIdRemoved;

    public Boolean getIsPropertyPhysicalInventoryDocumentTypeIdRemoved() {
        return this.isPropertyPhysicalInventoryDocumentTypeIdRemoved;
    }

    public void setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryMovementDateRemoved;

    public Boolean getIsPropertyPhysicalInventoryMovementDateRemoved() {
        return this.isPropertyPhysicalInventoryMovementDateRemoved;
    }

    public void setIsPropertyPhysicalInventoryMovementDateRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryMovementDateRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryDescriptionRemoved;

    public Boolean getIsPropertyPhysicalInventoryDescriptionRemoved() {
        return this.isPropertyPhysicalInventoryDescriptionRemoved;
    }

    public void setIsPropertyPhysicalInventoryDescriptionRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryDescriptionRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryIsApprovedRemoved;

    public Boolean getIsPropertyPhysicalInventoryIsApprovedRemoved() {
        return this.isPropertyPhysicalInventoryIsApprovedRemoved;
    }

    public void setIsPropertyPhysicalInventoryIsApprovedRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryIsApprovedRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryApprovalAmountRemoved;

    public Boolean getIsPropertyPhysicalInventoryApprovalAmountRemoved() {
        return this.isPropertyPhysicalInventoryApprovalAmountRemoved;
    }

    public void setIsPropertyPhysicalInventoryApprovalAmountRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryApprovalAmountRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryIsQuantityUpdatedRemoved;

    public Boolean getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved() {
        return this.isPropertyPhysicalInventoryIsQuantityUpdatedRemoved;
    }

    public void setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryIsQuantityUpdatedRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryReversalDocumentNumberRemoved;

    public Boolean getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved() {
        return this.isPropertyPhysicalInventoryReversalDocumentNumberRemoved;
    }

    public void setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryReversalDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryCreatedByRemoved;

    public Boolean getIsPropertyPhysicalInventoryCreatedByRemoved() {
        return this.isPropertyPhysicalInventoryCreatedByRemoved;
    }

    public void setIsPropertyPhysicalInventoryCreatedByRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryCreatedByRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryCreatedAtRemoved;

    public Boolean getIsPropertyPhysicalInventoryCreatedAtRemoved() {
        return this.isPropertyPhysicalInventoryCreatedAtRemoved;
    }

    public void setIsPropertyPhysicalInventoryCreatedAtRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryCreatedAtRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryUpdatedByRemoved;

    public Boolean getIsPropertyPhysicalInventoryUpdatedByRemoved() {
        return this.isPropertyPhysicalInventoryUpdatedByRemoved;
    }

    public void setIsPropertyPhysicalInventoryUpdatedByRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryUpdatedByRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryUpdatedAtRemoved;

    public Boolean getIsPropertyPhysicalInventoryUpdatedAtRemoved() {
        return this.isPropertyPhysicalInventoryUpdatedAtRemoved;
    }

    public void setIsPropertyPhysicalInventoryUpdatedAtRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryActiveRemoved;

    public Boolean getIsPropertyPhysicalInventoryActiveRemoved() {
        return this.isPropertyPhysicalInventoryActiveRemoved;
    }

    public void setIsPropertyPhysicalInventoryActiveRemoved(Boolean removed) {
        this.isPropertyPhysicalInventoryActiveRemoved = removed;
    }


	public static class PhysicalInventoryLineMvoStateCreatedDto extends PhysicalInventoryLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PhysicalInventoryLineMvoStateMergePatchedDto extends PhysicalInventoryLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PhysicalInventoryLineMvoStateDeletedDto extends PhysicalInventoryLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

