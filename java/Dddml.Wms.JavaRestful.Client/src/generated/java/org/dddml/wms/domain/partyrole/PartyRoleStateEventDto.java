package org.dddml.wms.domain.partyrole;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class PartyRoleStateEventDto extends AbstractEvent
{

    private PartyRoleEventId partyRoleEventId;

    PartyRoleEventId getPartyRoleEventId() {
        if (partyRoleEventId == null) { partyRoleEventId = new PartyRoleEventId(); }
        return partyRoleEventId;
    }

    void setPartyRoleEventId(PartyRoleEventId eventId) {
        this.partyRoleEventId = eventId;
    }

    public PartyRoleId getPartyRoleId() {
        return getPartyRoleEventId().getPartyRoleId();
    }

    public void setPartyRoleId(PartyRoleId partyRoleId) {
        getPartyRoleEventId().setPartyRoleId(partyRoleId);
    }

    public Long getVersion() {
        return getPartyRoleEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getPartyRoleEventId().setVersion(version);
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class PartyRoleStateCreatedDto extends PartyRoleStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PartyRoleStateMergePatchedDto extends PartyRoleStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PartyRoleStateDeletedDto extends PartyRoleStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

