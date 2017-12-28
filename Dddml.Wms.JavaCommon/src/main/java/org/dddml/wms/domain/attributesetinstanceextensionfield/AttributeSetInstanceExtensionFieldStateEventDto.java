package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class AttributeSetInstanceExtensionFieldStateEventDto extends AbstractStateEvent
{

    private AttributeSetInstanceExtensionFieldStateEventIdDto stateEventId;

    AttributeSetInstanceExtensionFieldStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new AttributeSetInstanceExtensionFieldStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(AttributeSetInstanceExtensionFieldStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getName() {
        return getStateEventId().getName();
    }

    public void setName(String name) {
        getStateEventId().setName(name);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Integer length;

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    private String alias;

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String groupId;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    private Boolean isPropertyTypeRemoved;

    public Boolean getIsPropertyTypeRemoved() {
        return this.isPropertyTypeRemoved;
    }

    public void setIsPropertyTypeRemoved(Boolean removed) {
        this.isPropertyTypeRemoved = removed;
    }

    private Boolean isPropertyLengthRemoved;

    public Boolean getIsPropertyLengthRemoved() {
        return this.isPropertyLengthRemoved;
    }

    public void setIsPropertyLengthRemoved(Boolean removed) {
        this.isPropertyLengthRemoved = removed;
    }

    private Boolean isPropertyAliasRemoved;

    public Boolean getIsPropertyAliasRemoved() {
        return this.isPropertyAliasRemoved;
    }

    public void setIsPropertyAliasRemoved(Boolean removed) {
        this.isPropertyAliasRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyGroupIdRemoved;

    public Boolean getIsPropertyGroupIdRemoved() {
        return this.isPropertyGroupIdRemoved;
    }

    public void setIsPropertyGroupIdRemoved(Boolean removed) {
        this.isPropertyGroupIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class AttributeSetInstanceExtensionFieldStateCreatedDto extends AttributeSetInstanceExtensionFieldStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class AttributeSetInstanceExtensionFieldStateMergePatchedDto extends AttributeSetInstanceExtensionFieldStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class AttributeSetInstanceExtensionFieldStateDeletedDto extends AttributeSetInstanceExtensionFieldStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

