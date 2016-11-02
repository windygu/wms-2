package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class UserClaimStateEventDto extends AbstractStateEvent
{

    private UserClaimStateEventIdDto stateEventId;

    UserClaimStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new UserClaimStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(UserClaimStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public Integer getClaimId() {
        return getStateEventId().getClaimId();
    }

    public void setClaimId(Integer claimId) {
        getStateEventId().setClaimId(claimId);
    }

    private String claimType;

    public String getClaimType() {
        return this.claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    private String claimValue;

    public String getClaimValue() {
        return this.claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
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

    private Boolean isPropertyClaimTypeRemoved;

    public Boolean getIsPropertyClaimTypeRemoved() {
        return this.isPropertyClaimTypeRemoved;
    }

    public void setIsPropertyClaimTypeRemoved(Boolean removed) {
        this.isPropertyClaimTypeRemoved = removed;
    }

    private Boolean isPropertyClaimValueRemoved;

    public Boolean getIsPropertyClaimValueRemoved() {
        return this.isPropertyClaimValueRemoved;
    }

    public void setIsPropertyClaimValueRemoved(Boolean removed) {
        this.isPropertyClaimValueRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class UserClaimStateCreatedDto extends UserClaimStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class UserClaimStateMergePatchedDto extends UserClaimStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class UserClaimStateRemovedDto extends UserClaimStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

