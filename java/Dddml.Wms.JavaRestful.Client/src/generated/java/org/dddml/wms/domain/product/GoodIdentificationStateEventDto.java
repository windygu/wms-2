package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class GoodIdentificationStateEventDto extends AbstractEvent
{

    private GoodIdentificationEventId goodIdentificationEventId;

    GoodIdentificationEventId getGoodIdentificationEventId() {
        if (goodIdentificationEventId == null) { goodIdentificationEventId = new GoodIdentificationEventId(); }
        return goodIdentificationEventId;
    }

    void setGoodIdentificationEventId(GoodIdentificationEventId eventId) {
        this.goodIdentificationEventId = eventId;
    }

    public String getGoodIdentificationTypeId() {
        return getGoodIdentificationEventId().getGoodIdentificationTypeId();
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId) {
        getGoodIdentificationEventId().setGoodIdentificationTypeId(goodIdentificationTypeId);
    }

    private String idValue;

    public String getIdValue() {
        return this.idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
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

    private Boolean isPropertyIdValueRemoved;

    public Boolean getIsPropertyIdValueRemoved() {
        return this.isPropertyIdValueRemoved;
    }

    public void setIsPropertyIdValueRemoved(Boolean removed) {
        this.isPropertyIdValueRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class GoodIdentificationStateCreatedDto extends GoodIdentificationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class GoodIdentificationStateMergePatchedDto extends GoodIdentificationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class GoodIdentificationStateRemovedDto extends GoodIdentificationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

