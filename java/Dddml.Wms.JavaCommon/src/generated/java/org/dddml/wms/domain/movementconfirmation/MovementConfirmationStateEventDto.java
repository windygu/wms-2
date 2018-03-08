package org.dddml.wms.domain.movementconfirmation;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class MovementConfirmationStateEventDto extends AbstractStateEvent
{

    private MovementConfirmationEventId movementConfirmationEventId;

    MovementConfirmationEventId getStateEventId() {
        if (movementConfirmationEventId == null) { movementConfirmationEventId = new MovementConfirmationEventId(); }
        return movementConfirmationEventId;
    }

    void setMovementConfirmationEventId(MovementConfirmationEventId eventId) {
        this.movementConfirmationEventId = eventId;
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

    private String movementDocumentNumber;

    public String getMovementDocumentNumber() {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber) {
        this.movementDocumentNumber = movementDocumentNumber;
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

    private Boolean isPropertyMovementDocumentNumberRemoved;

    public Boolean getIsPropertyMovementDocumentNumberRemoved() {
        return this.isPropertyMovementDocumentNumberRemoved;
    }

    public void setIsPropertyMovementDocumentNumberRemoved(Boolean removed) {
        this.isPropertyMovementDocumentNumberRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private MovementConfirmationLineStateEventDto[] movementConfirmationLineEvents;

    public MovementConfirmationLineStateEventDto[] getMovementConfirmationLineEvents() {
        return this.movementConfirmationLineEvents;
    }

    public void setMovementConfirmationLineEvents(MovementConfirmationLineStateEventDto[] events) {
        this.movementConfirmationLineEvents = events;
    }


	public static class MovementConfirmationStateCreatedDto extends MovementConfirmationStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class MovementConfirmationStateMergePatchedDto extends MovementConfirmationStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class MovementConfirmationStateDeletedDto extends MovementConfirmationStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

