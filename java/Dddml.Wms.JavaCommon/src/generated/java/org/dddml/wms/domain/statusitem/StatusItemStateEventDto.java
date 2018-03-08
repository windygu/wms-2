package org.dddml.wms.domain.statusitem;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class StatusItemStateEventDto extends AbstractStateEvent
{

    private StatusItemEventId statusItemEventId;

    StatusItemEventId getStateEventId() {
        if (statusItemEventId == null) { statusItemEventId = new StatusItemEventId(); }
        return statusItemEventId;
    }

    void setStatusItemEventId(StatusItemEventId eventId) {
        this.statusItemEventId = eventId;
    }

    public String getStatusId() {
        return getStateEventId().getStatusId();
    }

    public void setStatusId(String statusId) {
        getStateEventId().setStatusId(statusId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String statusTypeId;

    public String getStatusTypeId() {
        return this.statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    private String sequenceId;

    public String getSequenceId() {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
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

    private Boolean isPropertyStatusTypeIdRemoved;

    public Boolean getIsPropertyStatusTypeIdRemoved() {
        return this.isPropertyStatusTypeIdRemoved;
    }

    public void setIsPropertyStatusTypeIdRemoved(Boolean removed) {
        this.isPropertyStatusTypeIdRemoved = removed;
    }

    private Boolean isPropertyStatusCodeRemoved;

    public Boolean getIsPropertyStatusCodeRemoved() {
        return this.isPropertyStatusCodeRemoved;
    }

    public void setIsPropertyStatusCodeRemoved(Boolean removed) {
        this.isPropertyStatusCodeRemoved = removed;
    }

    private Boolean isPropertySequenceIdRemoved;

    public Boolean getIsPropertySequenceIdRemoved() {
        return this.isPropertySequenceIdRemoved;
    }

    public void setIsPropertySequenceIdRemoved(Boolean removed) {
        this.isPropertySequenceIdRemoved = removed;
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


	public static class StatusItemStateCreatedDto extends StatusItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class StatusItemStateMergePatchedDto extends StatusItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class StatusItemStateDeletedDto extends StatusItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

