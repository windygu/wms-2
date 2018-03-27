package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class PicklistBinStateEventDto extends AbstractStateEvent
{

    private PicklistBinEventId picklistBinEventId;

    PicklistBinEventId getStateEventId() {
        if (picklistBinEventId == null) { picklistBinEventId = new PicklistBinEventId(); }
        return picklistBinEventId;
    }

    void setPicklistBinEventId(PicklistBinEventId eventId) {
        this.picklistBinEventId = eventId;
    }

    public String getPicklistBinId() {
        return getStateEventId().getPicklistBinId();
    }

    public void setPicklistBinId(String picklistBinId) {
        getStateEventId().setPicklistBinId(picklistBinId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String picklistId;

    public String getPicklistId() {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId) {
        this.picklistId = picklistId;
    }

    private Long binLocationNumber;

    public Long getBinLocationNumber() {
        return this.binLocationNumber;
    }

    public void setBinLocationNumber(Long binLocationNumber) {
        this.binLocationNumber = binLocationNumber;
    }

    private String primaryOrderId;

    public String getPrimaryOrderId() {
        return this.primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId) {
        this.primaryOrderId = primaryOrderId;
    }

    private Long primaryShipGroupSeqId;

    public Long getPrimaryShipGroupSeqId() {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId) {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

    private Boolean isPropertyPicklistIdRemoved;

    public Boolean getIsPropertyPicklistIdRemoved() {
        return this.isPropertyPicklistIdRemoved;
    }

    public void setIsPropertyPicklistIdRemoved(Boolean removed) {
        this.isPropertyPicklistIdRemoved = removed;
    }

    private Boolean isPropertyBinLocationNumberRemoved;

    public Boolean getIsPropertyBinLocationNumberRemoved() {
        return this.isPropertyBinLocationNumberRemoved;
    }

    public void setIsPropertyBinLocationNumberRemoved(Boolean removed) {
        this.isPropertyBinLocationNumberRemoved = removed;
    }

    private Boolean isPropertyPrimaryOrderIdRemoved;

    public Boolean getIsPropertyPrimaryOrderIdRemoved() {
        return this.isPropertyPrimaryOrderIdRemoved;
    }

    public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed) {
        this.isPropertyPrimaryOrderIdRemoved = removed;
    }

    private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

    public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved() {
        return this.isPropertyPrimaryShipGroupSeqIdRemoved;
    }

    public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed) {
        this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private PicklistItemStateEventDto[] picklistItemEvents;

    public PicklistItemStateEventDto[] getPicklistItemEvents() {
        return this.picklistItemEvents;
    }

    public void setPicklistItemEvents(PicklistItemStateEventDto[] events) {
        this.picklistItemEvents = events;
    }


	public static class PicklistBinStateCreatedDto extends PicklistBinStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PicklistBinStateMergePatchedDto extends PicklistBinStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PicklistBinStateDeletedDto extends PicklistBinStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

