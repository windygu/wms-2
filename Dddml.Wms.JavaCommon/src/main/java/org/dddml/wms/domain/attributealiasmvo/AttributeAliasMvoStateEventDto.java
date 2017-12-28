package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class AttributeAliasMvoStateEventDto extends AbstractStateEvent
{

    private AttributeAliasMvoStateEventIdDto stateEventId;

    AttributeAliasMvoStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new AttributeAliasMvoStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(AttributeAliasMvoStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public AttributeAliasIdDto getAttributeAliasId() {
        return getStateEventId().getAttributeAliasId();
    }

    public void setAttributeAliasId(AttributeAliasIdDto attributeAliasId) {
        getStateEventId().setAttributeAliasId(attributeAliasId);
    }

    public Long getAttributeVersion() {
        return getStateEventId().getAttributeVersion();
    }
    
    public void getAttributeVersion(Long attributeVersion) {
        getStateEventId().setAttributeVersion(attributeVersion);
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String attributeAttributeName;

    public String getAttributeAttributeName() {
        return this.attributeAttributeName;
    }

    public void setAttributeAttributeName(String attributeAttributeName) {
        this.attributeAttributeName = attributeAttributeName;
    }

    private String attributeOrganizationId;

    public String getAttributeOrganizationId() {
        return this.attributeOrganizationId;
    }

    public void setAttributeOrganizationId(String attributeOrganizationId) {
        this.attributeOrganizationId = attributeOrganizationId;
    }

    private String attributeDescription;

    public String getAttributeDescription() {
        return this.attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    private Boolean attributeIsMandatory;

    public Boolean getAttributeIsMandatory() {
        return this.attributeIsMandatory;
    }

    public void setAttributeIsMandatory(Boolean attributeIsMandatory) {
        this.attributeIsMandatory = attributeIsMandatory;
    }

    private Boolean attributeIsInstanceAttribute;

    public Boolean getAttributeIsInstanceAttribute() {
        return this.attributeIsInstanceAttribute;
    }

    public void setAttributeIsInstanceAttribute(Boolean attributeIsInstanceAttribute) {
        this.attributeIsInstanceAttribute = attributeIsInstanceAttribute;
    }

    private String attributeAttributeValueType;

    public String getAttributeAttributeValueType() {
        return this.attributeAttributeValueType;
    }

    public void setAttributeAttributeValueType(String attributeAttributeValueType) {
        this.attributeAttributeValueType = attributeAttributeValueType;
    }

    private Integer attributeAttributeValueLength;

    public Integer getAttributeAttributeValueLength() {
        return this.attributeAttributeValueLength;
    }

    public void setAttributeAttributeValueLength(Integer attributeAttributeValueLength) {
        this.attributeAttributeValueLength = attributeAttributeValueLength;
    }

    private Boolean attributeIsList;

    public Boolean getAttributeIsList() {
        return this.attributeIsList;
    }

    public void setAttributeIsList(Boolean attributeIsList) {
        this.attributeIsList = attributeIsList;
    }

    private String attributeFieldName;

    public String getAttributeFieldName() {
        return this.attributeFieldName;
    }

    public void setAttributeFieldName(String attributeFieldName) {
        this.attributeFieldName = attributeFieldName;
    }

    private String attributeReferenceId;

    public String getAttributeReferenceId() {
        return this.attributeReferenceId;
    }

    public void setAttributeReferenceId(String attributeReferenceId) {
        this.attributeReferenceId = attributeReferenceId;
    }

    private String attributeCreatedBy;

    public String getAttributeCreatedBy() {
        return this.attributeCreatedBy;
    }

    public void setAttributeCreatedBy(String attributeCreatedBy) {
        this.attributeCreatedBy = attributeCreatedBy;
    }

    private Date attributeCreatedAt;

    public Date getAttributeCreatedAt() {
        return this.attributeCreatedAt;
    }

    public void setAttributeCreatedAt(Date attributeCreatedAt) {
        this.attributeCreatedAt = attributeCreatedAt;
    }

    private String attributeUpdatedBy;

    public String getAttributeUpdatedBy() {
        return this.attributeUpdatedBy;
    }

    public void setAttributeUpdatedBy(String attributeUpdatedBy) {
        this.attributeUpdatedBy = attributeUpdatedBy;
    }

    private Date attributeUpdatedAt;

    public Date getAttributeUpdatedAt() {
        return this.attributeUpdatedAt;
    }

    public void setAttributeUpdatedAt(Date attributeUpdatedAt) {
        this.attributeUpdatedAt = attributeUpdatedAt;
    }

    private Boolean attributeActive;

    public Boolean getAttributeActive() {
        return this.attributeActive;
    }

    public void setAttributeActive(Boolean attributeActive) {
        this.attributeActive = attributeActive;
    }

    private Boolean attributeDeleted;

    public Boolean getAttributeDeleted() {
        return this.attributeDeleted;
    }

    public void setAttributeDeleted(Boolean attributeDeleted) {
        this.attributeDeleted = attributeDeleted;
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

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved() {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed) {
        this.isPropertyNameRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyAttributeAttributeNameRemoved;

    public Boolean getIsPropertyAttributeAttributeNameRemoved() {
        return this.isPropertyAttributeAttributeNameRemoved;
    }

    public void setIsPropertyAttributeAttributeNameRemoved(Boolean removed) {
        this.isPropertyAttributeAttributeNameRemoved = removed;
    }

    private Boolean isPropertyAttributeOrganizationIdRemoved;

    public Boolean getIsPropertyAttributeOrganizationIdRemoved() {
        return this.isPropertyAttributeOrganizationIdRemoved;
    }

    public void setIsPropertyAttributeOrganizationIdRemoved(Boolean removed) {
        this.isPropertyAttributeOrganizationIdRemoved = removed;
    }

    private Boolean isPropertyAttributeDescriptionRemoved;

    public Boolean getIsPropertyAttributeDescriptionRemoved() {
        return this.isPropertyAttributeDescriptionRemoved;
    }

    public void setIsPropertyAttributeDescriptionRemoved(Boolean removed) {
        this.isPropertyAttributeDescriptionRemoved = removed;
    }

    private Boolean isPropertyAttributeIsMandatoryRemoved;

    public Boolean getIsPropertyAttributeIsMandatoryRemoved() {
        return this.isPropertyAttributeIsMandatoryRemoved;
    }

    public void setIsPropertyAttributeIsMandatoryRemoved(Boolean removed) {
        this.isPropertyAttributeIsMandatoryRemoved = removed;
    }

    private Boolean isPropertyAttributeIsInstanceAttributeRemoved;

    public Boolean getIsPropertyAttributeIsInstanceAttributeRemoved() {
        return this.isPropertyAttributeIsInstanceAttributeRemoved;
    }

    public void setIsPropertyAttributeIsInstanceAttributeRemoved(Boolean removed) {
        this.isPropertyAttributeIsInstanceAttributeRemoved = removed;
    }

    private Boolean isPropertyAttributeAttributeValueTypeRemoved;

    public Boolean getIsPropertyAttributeAttributeValueTypeRemoved() {
        return this.isPropertyAttributeAttributeValueTypeRemoved;
    }

    public void setIsPropertyAttributeAttributeValueTypeRemoved(Boolean removed) {
        this.isPropertyAttributeAttributeValueTypeRemoved = removed;
    }

    private Boolean isPropertyAttributeAttributeValueLengthRemoved;

    public Boolean getIsPropertyAttributeAttributeValueLengthRemoved() {
        return this.isPropertyAttributeAttributeValueLengthRemoved;
    }

    public void setIsPropertyAttributeAttributeValueLengthRemoved(Boolean removed) {
        this.isPropertyAttributeAttributeValueLengthRemoved = removed;
    }

    private Boolean isPropertyAttributeIsListRemoved;

    public Boolean getIsPropertyAttributeIsListRemoved() {
        return this.isPropertyAttributeIsListRemoved;
    }

    public void setIsPropertyAttributeIsListRemoved(Boolean removed) {
        this.isPropertyAttributeIsListRemoved = removed;
    }

    private Boolean isPropertyAttributeFieldNameRemoved;

    public Boolean getIsPropertyAttributeFieldNameRemoved() {
        return this.isPropertyAttributeFieldNameRemoved;
    }

    public void setIsPropertyAttributeFieldNameRemoved(Boolean removed) {
        this.isPropertyAttributeFieldNameRemoved = removed;
    }

    private Boolean isPropertyAttributeReferenceIdRemoved;

    public Boolean getIsPropertyAttributeReferenceIdRemoved() {
        return this.isPropertyAttributeReferenceIdRemoved;
    }

    public void setIsPropertyAttributeReferenceIdRemoved(Boolean removed) {
        this.isPropertyAttributeReferenceIdRemoved = removed;
    }

    private Boolean isPropertyAttributeCreatedByRemoved;

    public Boolean getIsPropertyAttributeCreatedByRemoved() {
        return this.isPropertyAttributeCreatedByRemoved;
    }

    public void setIsPropertyAttributeCreatedByRemoved(Boolean removed) {
        this.isPropertyAttributeCreatedByRemoved = removed;
    }

    private Boolean isPropertyAttributeCreatedAtRemoved;

    public Boolean getIsPropertyAttributeCreatedAtRemoved() {
        return this.isPropertyAttributeCreatedAtRemoved;
    }

    public void setIsPropertyAttributeCreatedAtRemoved(Boolean removed) {
        this.isPropertyAttributeCreatedAtRemoved = removed;
    }

    private Boolean isPropertyAttributeUpdatedByRemoved;

    public Boolean getIsPropertyAttributeUpdatedByRemoved() {
        return this.isPropertyAttributeUpdatedByRemoved;
    }

    public void setIsPropertyAttributeUpdatedByRemoved(Boolean removed) {
        this.isPropertyAttributeUpdatedByRemoved = removed;
    }

    private Boolean isPropertyAttributeUpdatedAtRemoved;

    public Boolean getIsPropertyAttributeUpdatedAtRemoved() {
        return this.isPropertyAttributeUpdatedAtRemoved;
    }

    public void setIsPropertyAttributeUpdatedAtRemoved(Boolean removed) {
        this.isPropertyAttributeUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyAttributeActiveRemoved;

    public Boolean getIsPropertyAttributeActiveRemoved() {
        return this.isPropertyAttributeActiveRemoved;
    }

    public void setIsPropertyAttributeActiveRemoved(Boolean removed) {
        this.isPropertyAttributeActiveRemoved = removed;
    }

    private Boolean isPropertyAttributeDeletedRemoved;

    public Boolean getIsPropertyAttributeDeletedRemoved() {
        return this.isPropertyAttributeDeletedRemoved;
    }

    public void setIsPropertyAttributeDeletedRemoved(Boolean removed) {
        this.isPropertyAttributeDeletedRemoved = removed;
    }


	public static class AttributeAliasMvoStateCreatedDto extends AttributeAliasMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class AttributeAliasMvoStateMergePatchedDto extends AttributeAliasMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class AttributeAliasMvoStateDeletedDto extends AttributeAliasMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

