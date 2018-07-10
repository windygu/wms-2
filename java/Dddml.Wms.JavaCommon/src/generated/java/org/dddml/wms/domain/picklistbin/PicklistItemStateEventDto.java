package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class PicklistItemStateEventDto extends AbstractEvent
{

    private PicklistItemEventId picklistItemEventId;

    PicklistItemEventId getPicklistItemEventId() {
        if (picklistItemEventId == null) { picklistItemEventId = new PicklistItemEventId(); }
        return picklistItemEventId;
    }

    void setPicklistItemEventId(PicklistItemEventId eventId) {
        this.picklistItemEventId = eventId;
    }

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId() {
        return getPicklistItemEventId().getPicklistItemOrderShipGrpInvId();
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        getPicklistItemEventId().setPicklistItemOrderShipGrpInvId(picklistItemOrderShipGrpInvId);
    }

    private String itemStatusId;

    public String getItemStatusId() {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
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

    private Boolean isPropertyItemStatusIdRemoved;

    public Boolean getIsPropertyItemStatusIdRemoved() {
        return this.isPropertyItemStatusIdRemoved;
    }

    public void setIsPropertyItemStatusIdRemoved(Boolean removed) {
        this.isPropertyItemStatusIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class PicklistItemStateCreatedDto extends PicklistItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PicklistItemStateMergePatchedDto extends PicklistItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PicklistItemStateRemovedDto extends PicklistItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

