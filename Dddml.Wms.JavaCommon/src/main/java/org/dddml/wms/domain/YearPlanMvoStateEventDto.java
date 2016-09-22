package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class YearPlanMvoStateEventDto extends AbstractStateEvent
{
    private String stateEventType;

    public String getStateEventType() {
        return this.stateEventType;
    }

    public void setStateEventType(String type) {
        this.stateEventType = type;
    }

    private YearPlanMvoStateEventIdDto stateEventId;

    YearPlanMvoStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new YearPlanMvoStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(YearPlanMvoStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }
    public YearPlanIdDto getYearPlanId() {
        return getStateEventId().getYearPlanId();
    }

    public void setYearPlanId(YearPlanIdDto yearPlanId) {
        getStateEventId().setYearPlanId(yearPlanId);
    }

    public Long getPersonVersion() {
        return getStateEventId().getPersonVersion();
    }
    
    public void getPersonVersion(Long personVersion) {
        getStateEventId().setPersonVersion(personVersion);
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private Date personBirthDate;

    public Date getPersonBirthDate() {
        return this.personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    private PersonalNameDto personLoves = new PersonalNameDto();

    public PersonalNameDto getPersonLoves() {
        return this.personLoves;
    }

    public void setPersonLoves(PersonalNameDto personLoves) {
        this.personLoves = personLoves;
    }

    private ContactDto personEmergencyContact = new ContactDto();

    public ContactDto getPersonEmergencyContact() {
        return this.personEmergencyContact;
    }

    public void setPersonEmergencyContact(ContactDto personEmergencyContact) {
        this.personEmergencyContact = personEmergencyContact;
    }

    private String personCreatedBy;

    public String getPersonCreatedBy() {
        return this.personCreatedBy;
    }

    public void setPersonCreatedBy(String personCreatedBy) {
        this.personCreatedBy = personCreatedBy;
    }

    private String personUpdatedBy;

    public String getPersonUpdatedBy() {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy) {
        this.personUpdatedBy = personUpdatedBy;
    }

    private Date personCreatedAt;

    public Date getPersonCreatedAt() {
        return this.personCreatedAt;
    }

    public void setPersonCreatedAt(Date personCreatedAt) {
        this.personCreatedAt = personCreatedAt;
    }

    private Date personUpdatedAt;

    public Date getPersonUpdatedAt() {
        return this.personUpdatedAt;
    }

    public void setPersonUpdatedAt(Date personUpdatedAt) {
        this.personUpdatedAt = personUpdatedAt;
    }

    private Boolean personActive;

    public Boolean getPersonActive() {
        return this.personActive;
    }

    public void setPersonActive(Boolean personActive) {
        this.personActive = personActive;
    }

    private Boolean personDeleted;

    public Boolean getPersonDeleted() {
        return this.personDeleted;
    }

    public void setPersonDeleted(Boolean personDeleted) {
        this.personDeleted = personDeleted;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
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

    private Boolean isPropertyPersonBirthDateRemoved;

    public Boolean getIsPropertyPersonBirthDateRemoved() {
        return this.isPropertyPersonBirthDateRemoved;
    }

    public void setIsPropertyPersonBirthDateRemoved(Boolean removed) {
        this.isPropertyPersonBirthDateRemoved = removed;
    }

    private Boolean isPropertyPersonLovesRemoved;

    public Boolean getIsPropertyPersonLovesRemoved() {
        return this.isPropertyPersonLovesRemoved;
    }

    public void setIsPropertyPersonLovesRemoved(Boolean removed) {
        this.isPropertyPersonLovesRemoved = removed;
    }

    private Boolean isPropertyPersonEmergencyContactRemoved;

    public Boolean getIsPropertyPersonEmergencyContactRemoved() {
        return this.isPropertyPersonEmergencyContactRemoved;
    }

    public void setIsPropertyPersonEmergencyContactRemoved(Boolean removed) {
        this.isPropertyPersonEmergencyContactRemoved = removed;
    }

    private Boolean isPropertyPersonCreatedByRemoved;

    public Boolean getIsPropertyPersonCreatedByRemoved() {
        return this.isPropertyPersonCreatedByRemoved;
    }

    public void setIsPropertyPersonCreatedByRemoved(Boolean removed) {
        this.isPropertyPersonCreatedByRemoved = removed;
    }

    private Boolean isPropertyPersonUpdatedByRemoved;

    public Boolean getIsPropertyPersonUpdatedByRemoved() {
        return this.isPropertyPersonUpdatedByRemoved;
    }

    public void setIsPropertyPersonUpdatedByRemoved(Boolean removed) {
        this.isPropertyPersonUpdatedByRemoved = removed;
    }

    private Boolean isPropertyPersonCreatedAtRemoved;

    public Boolean getIsPropertyPersonCreatedAtRemoved() {
        return this.isPropertyPersonCreatedAtRemoved;
    }

    public void setIsPropertyPersonCreatedAtRemoved(Boolean removed) {
        this.isPropertyPersonCreatedAtRemoved = removed;
    }

    private Boolean isPropertyPersonUpdatedAtRemoved;

    public Boolean getIsPropertyPersonUpdatedAtRemoved() {
        return this.isPropertyPersonUpdatedAtRemoved;
    }

    public void setIsPropertyPersonUpdatedAtRemoved(Boolean removed) {
        this.isPropertyPersonUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyPersonActiveRemoved;

    public Boolean getIsPropertyPersonActiveRemoved() {
        return this.isPropertyPersonActiveRemoved;
    }

    public void setIsPropertyPersonActiveRemoved(Boolean removed) {
        this.isPropertyPersonActiveRemoved = removed;
    }

    private Boolean isPropertyPersonDeletedRemoved;

    public Boolean getIsPropertyPersonDeletedRemoved() {
        return this.isPropertyPersonDeletedRemoved;
    }

    public void setIsPropertyPersonDeletedRemoved(Boolean removed) {
        this.isPropertyPersonDeletedRemoved = removed;
    }


	public static class YearPlanMvoStateCreatedDto extends YearPlanMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class YearPlanMvoStateMergePatchedDto extends YearPlanMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public class YearPlanMvoStateDeletedDto extends YearPlanMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

