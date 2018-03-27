package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class PicklistRoleStateEventDto extends AbstractStateEvent
{

    private PicklistRoleEventId picklistRoleEventId;

    PicklistRoleEventId getStateEventId() {
        if (picklistRoleEventId == null) { picklistRoleEventId = new PicklistRoleEventId(); }
        return picklistRoleEventId;
    }

    void setPicklistRoleEventId(PicklistRoleEventId eventId) {
        this.picklistRoleEventId = eventId;
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

    private String createdByUserLogin;

    public String getCreatedByUserLogin() {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin) {
        this.createdByUserLogin = createdByUserLogin;
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


	public static class PicklistRoleStateCreatedDto extends PicklistRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PicklistRoleStateMergePatchedDto extends PicklistRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PicklistRoleStateRemovedDto extends PicklistRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

