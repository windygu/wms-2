package org.dddml.wms.domain.party;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class PartyStateEventDto extends AbstractEvent
{

    private PartyEventId partyEventId;

    PartyEventId getStateEventId() {
        if (partyEventId == null) { partyEventId = new PartyEventId(); }
        return partyEventId;
    }

    void setPartyEventId(PartyEventId eventId) {
        this.partyEventId = eventId;
    }

    public String getPartyId() {
        return getStateEventId().getPartyId();
    }

    public void setPartyId(String partyId) {
        getStateEventId().setPartyId(partyId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String partyTypeId;

    public String getPartyTypeId() {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    private String primaryRoleTypeId;

    public String getPrimaryRoleTypeId() {
        return this.primaryRoleTypeId;
    }

    public void setPrimaryRoleTypeId(String primaryRoleTypeId) {
        this.primaryRoleTypeId = primaryRoleTypeId;
    }

    private String organizationName;

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Boolean isSummary;

    public Boolean getIsSummary() {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary) {
        this.isSummary = isSummary;
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

    private Boolean isPropertyPartyTypeIdRemoved;

    public Boolean getIsPropertyPartyTypeIdRemoved() {
        return this.isPropertyPartyTypeIdRemoved;
    }

    public void setIsPropertyPartyTypeIdRemoved(Boolean removed) {
        this.isPropertyPartyTypeIdRemoved = removed;
    }

    private Boolean isPropertyPrimaryRoleTypeIdRemoved;

    public Boolean getIsPropertyPrimaryRoleTypeIdRemoved() {
        return this.isPropertyPrimaryRoleTypeIdRemoved;
    }

    public void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed) {
        this.isPropertyPrimaryRoleTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrganizationNameRemoved;

    public Boolean getIsPropertyOrganizationNameRemoved() {
        return this.isPropertyOrganizationNameRemoved;
    }

    public void setIsPropertyOrganizationNameRemoved(Boolean removed) {
        this.isPropertyOrganizationNameRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyTypeRemoved;

    public Boolean getIsPropertyTypeRemoved() {
        return this.isPropertyTypeRemoved;
    }

    public void setIsPropertyTypeRemoved(Boolean removed) {
        this.isPropertyTypeRemoved = removed;
    }

    private Boolean isPropertyIsSummaryRemoved;

    public Boolean getIsPropertyIsSummaryRemoved() {
        return this.isPropertyIsSummaryRemoved;
    }

    public void setIsPropertyIsSummaryRemoved(Boolean removed) {
        this.isPropertyIsSummaryRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class PartyStateCreatedDto extends PartyStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PartyStateMergePatchedDto extends PartyStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PartyStateDeletedDto extends PartyStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

