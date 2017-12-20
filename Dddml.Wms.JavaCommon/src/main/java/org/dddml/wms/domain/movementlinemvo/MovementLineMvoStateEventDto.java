package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class MovementLineMvoStateEventDto extends AbstractStateEvent
{

    private MovementLineMvoStateEventIdDto stateEventId;

    MovementLineMvoStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new MovementLineMvoStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(MovementLineMvoStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public MovementLineIdDto getMovementLineId() {
        return getStateEventId().getMovementLineId();
    }

    public void setMovementLineId(MovementLineIdDto movementLineId) {
        getStateEventId().setMovementLineId(movementLineId);
    }

    public Long getMovementVersion() {
        return getStateEventId().getMovementVersion();
    }
    
    public void getMovementVersion(Long movementVersion) {
        getStateEventId().setMovementVersion(movementVersion);
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity() {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity) {
        this.movementQuantity = movementQuantity;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId() {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId) {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId() {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId) {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private String movementMovementTypeId;

    public String getMovementMovementTypeId() {
        return this.movementMovementTypeId;
    }

    public void setMovementMovementTypeId(String movementMovementTypeId) {
        this.movementMovementTypeId = movementMovementTypeId;
    }

    private String movementDescription;

    public String getMovementDescription() {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription) {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy() {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy) {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt() {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt) {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy() {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy) {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt() {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt) {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive() {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive) {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted() {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted) {
        this.movementDeleted = movementDeleted;
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

    private Boolean isPropertyMovementQuantityRemoved;

    public Boolean getIsPropertyMovementQuantityRemoved() {
        return this.isPropertyMovementQuantityRemoved;
    }

    public void setIsPropertyMovementQuantityRemoved(Boolean removed) {
        this.isPropertyMovementQuantityRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyMovementDocumentTypeIdRemoved;

    public Boolean getIsPropertyMovementDocumentTypeIdRemoved() {
        return this.isPropertyMovementDocumentTypeIdRemoved;
    }

    public void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed) {
        this.isPropertyMovementDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDocumentStatusIdRemoved;

    public Boolean getIsPropertyMovementDocumentStatusIdRemoved() {
        return this.isPropertyMovementDocumentStatusIdRemoved;
    }

    public void setIsPropertyMovementDocumentStatusIdRemoved(Boolean removed) {
        this.isPropertyMovementDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyMovementMovementTypeIdRemoved;

    public Boolean getIsPropertyMovementMovementTypeIdRemoved() {
        return this.isPropertyMovementMovementTypeIdRemoved;
    }

    public void setIsPropertyMovementMovementTypeIdRemoved(Boolean removed) {
        this.isPropertyMovementMovementTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDescriptionRemoved;

    public Boolean getIsPropertyMovementDescriptionRemoved() {
        return this.isPropertyMovementDescriptionRemoved;
    }

    public void setIsPropertyMovementDescriptionRemoved(Boolean removed) {
        this.isPropertyMovementDescriptionRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedByRemoved;

    public Boolean getIsPropertyMovementCreatedByRemoved() {
        return this.isPropertyMovementCreatedByRemoved;
    }

    public void setIsPropertyMovementCreatedByRemoved(Boolean removed) {
        this.isPropertyMovementCreatedByRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedAtRemoved;

    public Boolean getIsPropertyMovementCreatedAtRemoved() {
        return this.isPropertyMovementCreatedAtRemoved;
    }

    public void setIsPropertyMovementCreatedAtRemoved(Boolean removed) {
        this.isPropertyMovementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedByRemoved;

    public Boolean getIsPropertyMovementUpdatedByRemoved() {
        return this.isPropertyMovementUpdatedByRemoved;
    }

    public void setIsPropertyMovementUpdatedByRemoved(Boolean removed) {
        this.isPropertyMovementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedAtRemoved;

    public Boolean getIsPropertyMovementUpdatedAtRemoved() {
        return this.isPropertyMovementUpdatedAtRemoved;
    }

    public void setIsPropertyMovementUpdatedAtRemoved(Boolean removed) {
        this.isPropertyMovementUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementActiveRemoved;

    public Boolean getIsPropertyMovementActiveRemoved() {
        return this.isPropertyMovementActiveRemoved;
    }

    public void setIsPropertyMovementActiveRemoved(Boolean removed) {
        this.isPropertyMovementActiveRemoved = removed;
    }

    private Boolean isPropertyMovementDeletedRemoved;

    public Boolean getIsPropertyMovementDeletedRemoved() {
        return this.isPropertyMovementDeletedRemoved;
    }

    public void setIsPropertyMovementDeletedRemoved(Boolean removed) {
        this.isPropertyMovementDeletedRemoved = removed;
    }


	public static class MovementLineMvoStateCreatedDto extends MovementLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class MovementLineMvoStateMergePatchedDto extends MovementLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class MovementLineMvoStateDeletedDto extends MovementLineMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

