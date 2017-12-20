package org.dddml.wms.domain.movement;

import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class MovementStateEventDto extends AbstractStateEvent
{

    private MovementStateEventIdDto stateEventId;

    MovementStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new MovementStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(MovementStateEventIdDto stateEventId) {
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

    private String documentTypeId;

    public String getDocumentTypeId() {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    private String documentStatusId;

    public String getDocumentStatusId() {
        return this.documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    private String movementTypeId;

    public String getMovementTypeId() {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId) {
        this.movementTypeId = movementTypeId;
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

    private Boolean isPropertyDocumentTypeIdRemoved;

    public Boolean getIsPropertyDocumentTypeIdRemoved() {
        return this.isPropertyDocumentTypeIdRemoved;
    }

    public void setIsPropertyDocumentTypeIdRemoved(Boolean removed) {
        this.isPropertyDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyDocumentStatusIdRemoved;

    public Boolean getIsPropertyDocumentStatusIdRemoved() {
        return this.isPropertyDocumentStatusIdRemoved;
    }

    public void setIsPropertyDocumentStatusIdRemoved(Boolean removed) {
        this.isPropertyDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyMovementTypeIdRemoved;

    public Boolean getIsPropertyMovementTypeIdRemoved() {
        return this.isPropertyMovementTypeIdRemoved;
    }

    public void setIsPropertyMovementTypeIdRemoved(Boolean removed) {
        this.isPropertyMovementTypeIdRemoved = removed;
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


    private MovementLineStateEventDto[] movementLineEvents;

    public MovementLineStateEventDto[] getMovementLineEvents() {
        return this.movementLineEvents;
    }

    public void setMovementLineEvents(MovementLineStateEventDto[] events) {
        this.movementLineEvents = events;
    }


    private MovementConfirmationLineStateEventDto[] movementConfirmationLineEvents;

    public MovementConfirmationLineStateEventDto[] getMovementConfirmationLineEvents() {
        return this.movementConfirmationLineEvents;
    }

    public void setMovementConfirmationLineEvents(MovementConfirmationLineStateEventDto[] events) {
        this.movementConfirmationLineEvents = events;
    }


	public static class MovementStateCreatedDto extends MovementStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class MovementStateMergePatchedDto extends MovementStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class MovementStateDeletedDto extends MovementStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

