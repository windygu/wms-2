package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class MovementLineStateEventDto extends AbstractStateEvent
{

    private MovementLineStateEventIdDto stateEventId;

    MovementLineStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new MovementLineStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(MovementLineStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getLineNumber() {
        return getStateEventId().getLineNumber();
    }

    public void setLineNumber(String lineNumber) {
        getStateEventId().setLineNumber(lineNumber);
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity() {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity) {
        this.movementQuantity = movementQuantity;
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean isPropertyMovementQuantityRemoved;

    public Boolean getIsPropertyMovementQuantityRemoved() {
        return this.isPropertyMovementQuantityRemoved;
    }

    public void setIsPropertyMovementQuantityRemoved(Boolean removed) {
        this.isPropertyMovementQuantityRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class MovementLineStateCreatedDto extends MovementLineStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class MovementLineStateMergePatchedDto extends MovementLineStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class MovementLineStateRemovedDto extends MovementLineStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

