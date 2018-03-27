package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class OrderRoleStateEventDto extends AbstractStateEvent
{

    private OrderRoleEventId orderRoleEventId;

    OrderRoleEventId getStateEventId() {
        if (orderRoleEventId == null) { orderRoleEventId = new OrderRoleEventId(); }
        return orderRoleEventId;
    }

    void setOrderRoleEventId(OrderRoleEventId eventId) {
        this.orderRoleEventId = eventId;
    }

    public PartyRoleId getPartyRoleId() {
        return getStateEventId().getPartyRoleId();
    }

    public void setPartyRoleId(PartyRoleId partyRoleId) {
        getStateEventId().setPartyRoleId(partyRoleId);
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class OrderRoleStateCreatedDto extends OrderRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderRoleStateMergePatchedDto extends OrderRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderRoleStateRemovedDto extends OrderRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

