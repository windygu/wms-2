package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class PersonStateEventDto extends AbstractStateEvent
{
    private String stateEventType;

    public String getStateEventType() {
        return this.stateEventType;
    }

    public void setStateEventType(String type) {
        this.stateEventType = type;
    }

    private PersonStateEventIdDto stateEventId;

    PersonStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new PersonStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(PersonStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }
    public PersonalNameDto getPersonalName() {
        return getStateEventId().getPersonalName();
    }

    public void setPersonalName(PersonalNameDto personalName) {
        getStateEventId().setPersonalName(personalName);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private Date birthDate;

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private PersonalNameDto loves = new PersonalNameDto();

    public PersonalNameDto getLoves() {
        return this.loves;
    }

    public void setLoves(PersonalNameDto loves) {
        this.loves = loves;
    }

    private ContactDto emergencyContact = new ContactDto();

    public ContactDto getEmergencyContact() {
        return this.emergencyContact;
    }

    public void setEmergencyContact(ContactDto emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private Boolean isPropertyBirthDateRemoved;

    public Boolean getIsPropertyBirthDateRemoved() {
        return this.isPropertyBirthDateRemoved;
    }

    public void setIsPropertyBirthDateRemoved(Boolean removed) {
        this.isPropertyBirthDateRemoved = removed;
    }

    private Boolean isPropertyLovesRemoved;

    public Boolean getIsPropertyLovesRemoved() {
        return this.isPropertyLovesRemoved;
    }

    public void setIsPropertyLovesRemoved(Boolean removed) {
        this.isPropertyLovesRemoved = removed;
    }

    private Boolean isPropertyEmergencyContactRemoved;

    public Boolean getIsPropertyEmergencyContactRemoved() {
        return this.isPropertyEmergencyContactRemoved;
    }

    public void setIsPropertyEmergencyContactRemoved(Boolean removed) {
        this.isPropertyEmergencyContactRemoved = removed;
    }

    private Boolean isPropertyEmailRemoved;

    public Boolean getIsPropertyEmailRemoved() {
        return this.isPropertyEmailRemoved;
    }

    public void setIsPropertyEmailRemoved(Boolean removed) {
        this.isPropertyEmailRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private YearPlanStateEventDto[] yearPlanEvents;

    public YearPlanStateEventDto[] getYearPlanEvents() {
        return this.yearPlanEvents;
    }

    public void setYearPlanEvents(YearPlanStateEventDto[] events) {
        this.yearPlanEvents = events;
    }


	public static class PersonStateCreatedDto extends PersonStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PersonStateMergePatchedDto extends PersonStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public class PersonStateDeletedDto extends PersonStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

