package org.dddml.wms.domain.party;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class PartyStateEventDto extends AbstractEvent
{

    private PartyEventId partyEventId;

    PartyEventId getPartyEventId() {
        if (partyEventId == null) { partyEventId = new PartyEventId(); }
        return partyEventId;
    }

    void setPartyEventId(PartyEventId eventId) {
        this.partyEventId = eventId;
    }

    public String getPartyId() {
        return getPartyEventId().getPartyId();
    }

    public void setPartyId(String partyId) {
        getPartyEventId().setPartyId(partyId);
    }

    public Long getVersion() {
        return getPartyEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getPartyEventId().setVersion(version);
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

    private String externalId;

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    private String preferredCurrencyUomId;

    public String getPreferredCurrencyUomId() {
        return this.preferredCurrencyUomId;
    }

    public void setPreferredCurrencyUomId(String preferredCurrencyUomId) {
        this.preferredCurrencyUomId = preferredCurrencyUomId;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String organizationName;

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    private Boolean isSummary;

    public Boolean getIsSummary() {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary) {
        this.isSummary = isSummary;
    }

    private String salutation;

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String middleName;

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String personalTitle;

    public String getPersonalTitle() {
        return this.personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }

    private String nickname;

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String cardId;

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    private Boolean isPropertyExternalIdRemoved;

    public Boolean getIsPropertyExternalIdRemoved() {
        return this.isPropertyExternalIdRemoved;
    }

    public void setIsPropertyExternalIdRemoved(Boolean removed) {
        this.isPropertyExternalIdRemoved = removed;
    }

    private Boolean isPropertyPreferredCurrencyUomIdRemoved;

    public Boolean getIsPropertyPreferredCurrencyUomIdRemoved() {
        return this.isPropertyPreferredCurrencyUomIdRemoved;
    }

    public void setIsPropertyPreferredCurrencyUomIdRemoved(Boolean removed) {
        this.isPropertyPreferredCurrencyUomIdRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyOrganizationNameRemoved;

    public Boolean getIsPropertyOrganizationNameRemoved() {
        return this.isPropertyOrganizationNameRemoved;
    }

    public void setIsPropertyOrganizationNameRemoved(Boolean removed) {
        this.isPropertyOrganizationNameRemoved = removed;
    }

    private Boolean isPropertyIsSummaryRemoved;

    public Boolean getIsPropertyIsSummaryRemoved() {
        return this.isPropertyIsSummaryRemoved;
    }

    public void setIsPropertyIsSummaryRemoved(Boolean removed) {
        this.isPropertyIsSummaryRemoved = removed;
    }

    private Boolean isPropertySalutationRemoved;

    public Boolean getIsPropertySalutationRemoved() {
        return this.isPropertySalutationRemoved;
    }

    public void setIsPropertySalutationRemoved(Boolean removed) {
        this.isPropertySalutationRemoved = removed;
    }

    private Boolean isPropertyFirstNameRemoved;

    public Boolean getIsPropertyFirstNameRemoved() {
        return this.isPropertyFirstNameRemoved;
    }

    public void setIsPropertyFirstNameRemoved(Boolean removed) {
        this.isPropertyFirstNameRemoved = removed;
    }

    private Boolean isPropertyMiddleNameRemoved;

    public Boolean getIsPropertyMiddleNameRemoved() {
        return this.isPropertyMiddleNameRemoved;
    }

    public void setIsPropertyMiddleNameRemoved(Boolean removed) {
        this.isPropertyMiddleNameRemoved = removed;
    }

    private Boolean isPropertyLastNameRemoved;

    public Boolean getIsPropertyLastNameRemoved() {
        return this.isPropertyLastNameRemoved;
    }

    public void setIsPropertyLastNameRemoved(Boolean removed) {
        this.isPropertyLastNameRemoved = removed;
    }

    private Boolean isPropertyPersonalTitleRemoved;

    public Boolean getIsPropertyPersonalTitleRemoved() {
        return this.isPropertyPersonalTitleRemoved;
    }

    public void setIsPropertyPersonalTitleRemoved(Boolean removed) {
        this.isPropertyPersonalTitleRemoved = removed;
    }

    private Boolean isPropertyNicknameRemoved;

    public Boolean getIsPropertyNicknameRemoved() {
        return this.isPropertyNicknameRemoved;
    }

    public void setIsPropertyNicknameRemoved(Boolean removed) {
        this.isPropertyNicknameRemoved = removed;
    }

    private Boolean isPropertyCardIdRemoved;

    public Boolean getIsPropertyCardIdRemoved() {
        return this.isPropertyCardIdRemoved;
    }

    public void setIsPropertyCardIdRemoved(Boolean removed) {
        this.isPropertyCardIdRemoved = removed;
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

