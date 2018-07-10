package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class AttributeSetStateEventDto extends AbstractEvent
{

    private AttributeSetEventId attributeSetEventId;

    AttributeSetEventId getAttributeSetEventId() {
        if (attributeSetEventId == null) { attributeSetEventId = new AttributeSetEventId(); }
        return attributeSetEventId;
    }

    void setAttributeSetEventId(AttributeSetEventId eventId) {
        this.attributeSetEventId = eventId;
    }

    public String getAttributeSetId() {
        return getAttributeSetEventId().getAttributeSetId();
    }

    public void setAttributeSetId(String attributeSetId) {
        getAttributeSetEventId().setAttributeSetId(attributeSetId);
    }

    public Long getVersion() {
        return getAttributeSetEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getAttributeSetEventId().setVersion(version);
    }

    private String attributeSetName;

    public String getAttributeSetName() {
        return this.attributeSetName;
    }

    public void setAttributeSetName(String attributeSetName) {
        this.attributeSetName = attributeSetName;
    }

    private String organizationId;

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String referenceId;

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    private Boolean isInstanceAttributeSet;

    public Boolean getIsInstanceAttributeSet() {
        return this.isInstanceAttributeSet;
    }

    public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet) {
        this.isInstanceAttributeSet = isInstanceAttributeSet;
    }

    private Boolean isMandatory;

    public Boolean getIsMandatory() {
        return this.isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
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

    private Boolean isPropertyAttributeSetNameRemoved;

    public Boolean getIsPropertyAttributeSetNameRemoved() {
        return this.isPropertyAttributeSetNameRemoved;
    }

    public void setIsPropertyAttributeSetNameRemoved(Boolean removed) {
        this.isPropertyAttributeSetNameRemoved = removed;
    }

    private Boolean isPropertyOrganizationIdRemoved;

    public Boolean getIsPropertyOrganizationIdRemoved() {
        return this.isPropertyOrganizationIdRemoved;
    }

    public void setIsPropertyOrganizationIdRemoved(Boolean removed) {
        this.isPropertyOrganizationIdRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyReferenceIdRemoved;

    public Boolean getIsPropertyReferenceIdRemoved() {
        return this.isPropertyReferenceIdRemoved;
    }

    public void setIsPropertyReferenceIdRemoved(Boolean removed) {
        this.isPropertyReferenceIdRemoved = removed;
    }

    private Boolean isPropertyIsInstanceAttributeSetRemoved;

    public Boolean getIsPropertyIsInstanceAttributeSetRemoved() {
        return this.isPropertyIsInstanceAttributeSetRemoved;
    }

    public void setIsPropertyIsInstanceAttributeSetRemoved(Boolean removed) {
        this.isPropertyIsInstanceAttributeSetRemoved = removed;
    }

    private Boolean isPropertyIsMandatoryRemoved;

    public Boolean getIsPropertyIsMandatoryRemoved() {
        return this.isPropertyIsMandatoryRemoved;
    }

    public void setIsPropertyIsMandatoryRemoved(Boolean removed) {
        this.isPropertyIsMandatoryRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private AttributeUseStateEventDto[] attributeUseEvents;

    public AttributeUseStateEventDto[] getAttributeUseEvents() {
        return this.attributeUseEvents;
    }

    public void setAttributeUseEvents(AttributeUseStateEventDto[] events) {
        this.attributeUseEvents = events;
    }


	public static class AttributeSetStateCreatedDto extends AttributeSetStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class AttributeSetStateMergePatchedDto extends AttributeSetStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class AttributeSetStateDeletedDto extends AttributeSetStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

