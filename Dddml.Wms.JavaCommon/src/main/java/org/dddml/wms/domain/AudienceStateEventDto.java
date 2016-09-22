package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class AudienceStateEventDto extends AbstractStateEvent
{
    private String stateEventType;

    public String getStateEventType() {
        return this.stateEventType;
    }

    public void setStateEventType(String type) {
        this.stateEventType = type;
    }

    private AudienceStateEventIdDto stateEventId;

    AudienceStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new AudienceStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(AudienceStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }
    public String getClientId() {
        return getStateEventId().getClientId();
    }

    public void setClientId(String clientId) {
        getStateEventId().setClientId(clientId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String base64Secret;

    public String getBase64Secret() {
        return this.base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
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

    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved() {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed) {
        this.isPropertyNameRemoved = removed;
    }

    private Boolean isPropertyBase64SecretRemoved;

    public Boolean getIsPropertyBase64SecretRemoved() {
        return this.isPropertyBase64SecretRemoved;
    }

    public void setIsPropertyBase64SecretRemoved(Boolean removed) {
        this.isPropertyBase64SecretRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class AudienceStateCreatedDto extends AudienceStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class AudienceStateMergePatchedDto extends AudienceStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public class AudienceStateDeletedDto extends AudienceStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

