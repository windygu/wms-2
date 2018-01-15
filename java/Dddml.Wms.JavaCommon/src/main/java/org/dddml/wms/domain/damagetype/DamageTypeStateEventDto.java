package org.dddml.wms.domain.damagetype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class DamageTypeStateEventDto extends AbstractStateEvent
{

    private DamageTypeStateEventIdDto stateEventId;

    DamageTypeStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new DamageTypeStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(DamageTypeStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getDamageTypeId() {
        return getStateEventId().getDamageTypeId();
    }

    public void setDamageTypeId(String damageTypeId) {
        getStateEventId().setDamageTypeId(damageTypeId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String sequenceId;

    public String getSequenceId() {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    private String defaultHandlingMethodId;

    public String getDefaultHandlingMethodId() {
        return this.defaultHandlingMethodId;
    }

    public void setDefaultHandlingMethodId(String defaultHandlingMethodId) {
        this.defaultHandlingMethodId = defaultHandlingMethodId;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertySequenceIdRemoved;

    public Boolean getIsPropertySequenceIdRemoved() {
        return this.isPropertySequenceIdRemoved;
    }

    public void setIsPropertySequenceIdRemoved(Boolean removed) {
        this.isPropertySequenceIdRemoved = removed;
    }

    private Boolean isPropertyDefaultHandlingMethodIdRemoved;

    public Boolean getIsPropertyDefaultHandlingMethodIdRemoved() {
        return this.isPropertyDefaultHandlingMethodIdRemoved;
    }

    public void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed) {
        this.isPropertyDefaultHandlingMethodIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class DamageTypeStateCreatedDto extends DamageTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class DamageTypeStateMergePatchedDto extends DamageTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class DamageTypeStateDeletedDto extends DamageTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

