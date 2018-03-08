package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class AttributeAliasStateEventDto extends AbstractStateEvent
{

    private AttributeAliasEventId stateEventId;

    AttributeAliasEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new AttributeAliasEventId(); }
        return stateEventId;
    }

    void setStateEventId(AttributeAliasEventId eventId) {
        this.stateEventId = eventId;
    }

    public String getCode() {
        return getStateEventId().getCode();
    }

    public void setCode(String code) {
        getStateEventId().setCode(code);
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved() {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed) {
        this.isPropertyNameRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class AttributeAliasStateCreatedDto extends AttributeAliasStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class AttributeAliasStateMergePatchedDto extends AttributeAliasStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class AttributeAliasStateRemovedDto extends AttributeAliasStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

