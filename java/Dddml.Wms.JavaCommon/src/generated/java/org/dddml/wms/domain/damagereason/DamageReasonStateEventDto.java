package org.dddml.wms.domain.damagereason;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class DamageReasonStateEventDto extends AbstractEvent
{

    private DamageReasonEventId damageReasonEventId;

    DamageReasonEventId getDamageReasonEventId() {
        if (damageReasonEventId == null) { damageReasonEventId = new DamageReasonEventId(); }
        return damageReasonEventId;
    }

    void setDamageReasonEventId(DamageReasonEventId eventId) {
        this.damageReasonEventId = eventId;
    }

    public String getDamageReasonId() {
        return getDamageReasonEventId().getDamageReasonId();
    }

    public void setDamageReasonId(String damageReasonId) {
        getDamageReasonEventId().setDamageReasonId(damageReasonId);
    }

    public Long getVersion() {
        return getDamageReasonEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getDamageReasonEventId().setVersion(version);
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class DamageReasonStateCreatedDto extends DamageReasonStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class DamageReasonStateMergePatchedDto extends DamageReasonStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class DamageReasonStateDeletedDto extends DamageReasonStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

