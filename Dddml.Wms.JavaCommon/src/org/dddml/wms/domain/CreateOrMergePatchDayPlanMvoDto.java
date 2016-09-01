package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchDayPlanMvoDto extends AbstractDayPlanMvoCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String monthPlanDescription;

    public String getMonthPlanDescription()
    {
        return this.monthPlanDescription;
    }

    public void setMonthPlanDescription(String monthPlanDescription)
    {
        this.monthPlanDescription = monthPlanDescription;
    }

    private Long monthPlanVersion;

    public Long getMonthPlanVersion()
    {
        return this.monthPlanVersion;
    }

    public void setMonthPlanVersion(Long monthPlanVersion)
    {
        this.monthPlanVersion = monthPlanVersion;
    }

    private String monthPlanCreatedBy;

    public String getMonthPlanCreatedBy()
    {
        return this.monthPlanCreatedBy;
    }

    public void setMonthPlanCreatedBy(String monthPlanCreatedBy)
    {
        this.monthPlanCreatedBy = monthPlanCreatedBy;
    }

    private Date monthPlanCreatedAt;

    public Date getMonthPlanCreatedAt()
    {
        return this.monthPlanCreatedAt;
    }

    public void setMonthPlanCreatedAt(Date monthPlanCreatedAt)
    {
        this.monthPlanCreatedAt = monthPlanCreatedAt;
    }

    private String monthPlanUpdatedBy;

    public String getMonthPlanUpdatedBy()
    {
        return this.monthPlanUpdatedBy;
    }

    public void setMonthPlanUpdatedBy(String monthPlanUpdatedBy)
    {
        this.monthPlanUpdatedBy = monthPlanUpdatedBy;
    }

    private Date monthPlanUpdatedAt;

    public Date getMonthPlanUpdatedAt()
    {
        return this.monthPlanUpdatedAt;
    }

    public void setMonthPlanUpdatedAt(Date monthPlanUpdatedAt)
    {
        this.monthPlanUpdatedAt = monthPlanUpdatedAt;
    }

    private Boolean monthPlanActive;

    public Boolean getMonthPlanActive()
    {
        return this.monthPlanActive;
    }

    public void setMonthPlanActive(Boolean monthPlanActive)
    {
        this.monthPlanActive = monthPlanActive;
    }

    private Boolean monthPlanDeleted;

    public Boolean getMonthPlanDeleted()
    {
        return this.monthPlanDeleted;
    }

    public void setMonthPlanDeleted(Boolean monthPlanDeleted)
    {
        this.monthPlanDeleted = monthPlanDeleted;
    }

    private String yearPlanDescription;

    public String getYearPlanDescription()
    {
        return this.yearPlanDescription;
    }

    public void setYearPlanDescription(String yearPlanDescription)
    {
        this.yearPlanDescription = yearPlanDescription;
    }

    private Long yearPlanVersion;

    public Long getYearPlanVersion()
    {
        return this.yearPlanVersion;
    }

    public void setYearPlanVersion(Long yearPlanVersion)
    {
        this.yearPlanVersion = yearPlanVersion;
    }

    private String yearPlanCreatedBy;

    public String getYearPlanCreatedBy()
    {
        return this.yearPlanCreatedBy;
    }

    public void setYearPlanCreatedBy(String yearPlanCreatedBy)
    {
        this.yearPlanCreatedBy = yearPlanCreatedBy;
    }

    private Date yearPlanCreatedAt;

    public Date getYearPlanCreatedAt()
    {
        return this.yearPlanCreatedAt;
    }

    public void setYearPlanCreatedAt(Date yearPlanCreatedAt)
    {
        this.yearPlanCreatedAt = yearPlanCreatedAt;
    }

    private String yearPlanUpdatedBy;

    public String getYearPlanUpdatedBy()
    {
        return this.yearPlanUpdatedBy;
    }

    public void setYearPlanUpdatedBy(String yearPlanUpdatedBy)
    {
        this.yearPlanUpdatedBy = yearPlanUpdatedBy;
    }

    private Date yearPlanUpdatedAt;

    public Date getYearPlanUpdatedAt()
    {
        return this.yearPlanUpdatedAt;
    }

    public void setYearPlanUpdatedAt(Date yearPlanUpdatedAt)
    {
        this.yearPlanUpdatedAt = yearPlanUpdatedAt;
    }

    private Boolean yearPlanActive;

    public Boolean getYearPlanActive()
    {
        return this.yearPlanActive;
    }

    public void setYearPlanActive(Boolean yearPlanActive)
    {
        this.yearPlanActive = yearPlanActive;
    }

    private Boolean yearPlanDeleted;

    public Boolean getYearPlanDeleted()
    {
        return this.yearPlanDeleted;
    }

    public void setYearPlanDeleted(Boolean yearPlanDeleted)
    {
        this.yearPlanDeleted = yearPlanDeleted;
    }

    private Date personBirthDate;

    public Date getPersonBirthDate()
    {
        return this.personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate)
    {
        this.personBirthDate = personBirthDate;
    }

    private PersonalNameDto personLoves;

    public PersonalNameDto getPersonLoves()
    {
        return this.personLoves;
    }

    public void setPersonLoves(PersonalNameDto personLoves)
    {
        this.personLoves = personLoves;
    }

    private ContactDto personEmergencyContact;

    public ContactDto getPersonEmergencyContact()
    {
        return this.personEmergencyContact;
    }

    public void setPersonEmergencyContact(ContactDto personEmergencyContact)
    {
        this.personEmergencyContact = personEmergencyContact;
    }

    private String personCreatedBy;

    public String getPersonCreatedBy()
    {
        return this.personCreatedBy;
    }

    public void setPersonCreatedBy(String personCreatedBy)
    {
        this.personCreatedBy = personCreatedBy;
    }

    private Date personCreatedAt;

    public Date getPersonCreatedAt()
    {
        return this.personCreatedAt;
    }

    public void setPersonCreatedAt(Date personCreatedAt)
    {
        this.personCreatedAt = personCreatedAt;
    }

    private String personUpdatedBy;

    public String getPersonUpdatedBy()
    {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy)
    {
        this.personUpdatedBy = personUpdatedBy;
    }

    private Date personUpdatedAt;

    public Date getPersonUpdatedAt()
    {
        return this.personUpdatedAt;
    }

    public void setPersonUpdatedAt(Date personUpdatedAt)
    {
        this.personUpdatedAt = personUpdatedAt;
    }

    private Boolean personActive;

    public Boolean getPersonActive()
    {
        return this.personActive;
    }

    public void setPersonActive(Boolean personActive)
    {
        this.personActive = personActive;
    }

    private Boolean personDeleted;

    public Boolean getPersonDeleted()
    {
        return this.personDeleted;
    }

    public void setPersonDeleted(Boolean personDeleted)
    {
        this.personDeleted = personDeleted;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyMonthPlanDescriptionRemoved;

    public Boolean getIsPropertyMonthPlanDescriptionRemoved()
    {
        return this.isPropertyMonthPlanDescriptionRemoved;
    }

    public void setIsPropertyMonthPlanDescriptionRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanDescriptionRemoved = removed;
    }

    private Boolean isPropertyMonthPlanVersionRemoved;

    public Boolean getIsPropertyMonthPlanVersionRemoved()
    {
        return this.isPropertyMonthPlanVersionRemoved;
    }

    public void setIsPropertyMonthPlanVersionRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanVersionRemoved = removed;
    }

    private Boolean isPropertyMonthPlanCreatedByRemoved;

    public Boolean getIsPropertyMonthPlanCreatedByRemoved()
    {
        return this.isPropertyMonthPlanCreatedByRemoved;
    }

    public void setIsPropertyMonthPlanCreatedByRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanCreatedByRemoved = removed;
    }

    private Boolean isPropertyMonthPlanCreatedAtRemoved;

    public Boolean getIsPropertyMonthPlanCreatedAtRemoved()
    {
        return this.isPropertyMonthPlanCreatedAtRemoved;
    }

    public void setIsPropertyMonthPlanCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMonthPlanUpdatedByRemoved;

    public Boolean getIsPropertyMonthPlanUpdatedByRemoved()
    {
        return this.isPropertyMonthPlanUpdatedByRemoved;
    }

    public void setIsPropertyMonthPlanUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMonthPlanUpdatedAtRemoved;

    public Boolean getIsPropertyMonthPlanUpdatedAtRemoved()
    {
        return this.isPropertyMonthPlanUpdatedAtRemoved;
    }

    public void setIsPropertyMonthPlanUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMonthPlanActiveRemoved;

    public Boolean getIsPropertyMonthPlanActiveRemoved()
    {
        return this.isPropertyMonthPlanActiveRemoved;
    }

    public void setIsPropertyMonthPlanActiveRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanActiveRemoved = removed;
    }

    private Boolean isPropertyMonthPlanDeletedRemoved;

    public Boolean getIsPropertyMonthPlanDeletedRemoved()
    {
        return this.isPropertyMonthPlanDeletedRemoved;
    }

    public void setIsPropertyMonthPlanDeletedRemoved(Boolean removed)
    {
        this.isPropertyMonthPlanDeletedRemoved = removed;
    }

    private Boolean isPropertyYearPlanDescriptionRemoved;

    public Boolean getIsPropertyYearPlanDescriptionRemoved()
    {
        return this.isPropertyYearPlanDescriptionRemoved;
    }

    public void setIsPropertyYearPlanDescriptionRemoved(Boolean removed)
    {
        this.isPropertyYearPlanDescriptionRemoved = removed;
    }

    private Boolean isPropertyYearPlanVersionRemoved;

    public Boolean getIsPropertyYearPlanVersionRemoved()
    {
        return this.isPropertyYearPlanVersionRemoved;
    }

    public void setIsPropertyYearPlanVersionRemoved(Boolean removed)
    {
        this.isPropertyYearPlanVersionRemoved = removed;
    }

    private Boolean isPropertyYearPlanCreatedByRemoved;

    public Boolean getIsPropertyYearPlanCreatedByRemoved()
    {
        return this.isPropertyYearPlanCreatedByRemoved;
    }

    public void setIsPropertyYearPlanCreatedByRemoved(Boolean removed)
    {
        this.isPropertyYearPlanCreatedByRemoved = removed;
    }

    private Boolean isPropertyYearPlanCreatedAtRemoved;

    public Boolean getIsPropertyYearPlanCreatedAtRemoved()
    {
        return this.isPropertyYearPlanCreatedAtRemoved;
    }

    public void setIsPropertyYearPlanCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyYearPlanCreatedAtRemoved = removed;
    }

    private Boolean isPropertyYearPlanUpdatedByRemoved;

    public Boolean getIsPropertyYearPlanUpdatedByRemoved()
    {
        return this.isPropertyYearPlanUpdatedByRemoved;
    }

    public void setIsPropertyYearPlanUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyYearPlanUpdatedByRemoved = removed;
    }

    private Boolean isPropertyYearPlanUpdatedAtRemoved;

    public Boolean getIsPropertyYearPlanUpdatedAtRemoved()
    {
        return this.isPropertyYearPlanUpdatedAtRemoved;
    }

    public void setIsPropertyYearPlanUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyYearPlanUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyYearPlanActiveRemoved;

    public Boolean getIsPropertyYearPlanActiveRemoved()
    {
        return this.isPropertyYearPlanActiveRemoved;
    }

    public void setIsPropertyYearPlanActiveRemoved(Boolean removed)
    {
        this.isPropertyYearPlanActiveRemoved = removed;
    }

    private Boolean isPropertyYearPlanDeletedRemoved;

    public Boolean getIsPropertyYearPlanDeletedRemoved()
    {
        return this.isPropertyYearPlanDeletedRemoved;
    }

    public void setIsPropertyYearPlanDeletedRemoved(Boolean removed)
    {
        this.isPropertyYearPlanDeletedRemoved = removed;
    }

    private Boolean isPropertyPersonBirthDateRemoved;

    public Boolean getIsPropertyPersonBirthDateRemoved()
    {
        return this.isPropertyPersonBirthDateRemoved;
    }

    public void setIsPropertyPersonBirthDateRemoved(Boolean removed)
    {
        this.isPropertyPersonBirthDateRemoved = removed;
    }

    private Boolean isPropertyPersonLovesRemoved;

    public Boolean getIsPropertyPersonLovesRemoved()
    {
        return this.isPropertyPersonLovesRemoved;
    }

    public void setIsPropertyPersonLovesRemoved(Boolean removed)
    {
        this.isPropertyPersonLovesRemoved = removed;
    }

    private Boolean isPropertyPersonEmergencyContactRemoved;

    public Boolean getIsPropertyPersonEmergencyContactRemoved()
    {
        return this.isPropertyPersonEmergencyContactRemoved;
    }

    public void setIsPropertyPersonEmergencyContactRemoved(Boolean removed)
    {
        this.isPropertyPersonEmergencyContactRemoved = removed;
    }

    private Boolean isPropertyPersonCreatedByRemoved;

    public Boolean getIsPropertyPersonCreatedByRemoved()
    {
        return this.isPropertyPersonCreatedByRemoved;
    }

    public void setIsPropertyPersonCreatedByRemoved(Boolean removed)
    {
        this.isPropertyPersonCreatedByRemoved = removed;
    }

    private Boolean isPropertyPersonCreatedAtRemoved;

    public Boolean getIsPropertyPersonCreatedAtRemoved()
    {
        return this.isPropertyPersonCreatedAtRemoved;
    }

    public void setIsPropertyPersonCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyPersonCreatedAtRemoved = removed;
    }

    private Boolean isPropertyPersonUpdatedByRemoved;

    public Boolean getIsPropertyPersonUpdatedByRemoved()
    {
        return this.isPropertyPersonUpdatedByRemoved;
    }

    public void setIsPropertyPersonUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyPersonUpdatedByRemoved = removed;
    }

    private Boolean isPropertyPersonUpdatedAtRemoved;

    public Boolean getIsPropertyPersonUpdatedAtRemoved()
    {
        return this.isPropertyPersonUpdatedAtRemoved;
    }

    public void setIsPropertyPersonUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyPersonUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyPersonActiveRemoved;

    public Boolean getIsPropertyPersonActiveRemoved()
    {
        return this.isPropertyPersonActiveRemoved;
    }

    public void setIsPropertyPersonActiveRemoved(Boolean removed)
    {
        this.isPropertyPersonActiveRemoved = removed;
    }

    private Boolean isPropertyPersonDeletedRemoved;

    public Boolean getIsPropertyPersonDeletedRemoved()
    {
        return this.isPropertyPersonDeletedRemoved;
    }

    public void setIsPropertyPersonDeletedRemoved(Boolean removed)
    {
        this.isPropertyPersonDeletedRemoved = removed;
    }


    public void copyTo(AbstractDayPlanMvoCommand.AbstractCreateOrMergePatchDayPlanMvo command)
    {
        ((AbstractDayPlanMvoCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setMonthPlanDescription(this.getMonthPlanDescription());
        command.setMonthPlanVersion(this.getMonthPlanVersion());
        command.setMonthPlanCreatedBy(this.getMonthPlanCreatedBy());
        command.setMonthPlanCreatedAt(this.getMonthPlanCreatedAt());
        command.setMonthPlanUpdatedBy(this.getMonthPlanUpdatedBy());
        command.setMonthPlanUpdatedAt(this.getMonthPlanUpdatedAt());
        command.setMonthPlanActive(this.getMonthPlanActive());
        command.setMonthPlanDeleted(this.getMonthPlanDeleted());
        command.setYearPlanDescription(this.getYearPlanDescription());
        command.setYearPlanVersion(this.getYearPlanVersion());
        command.setYearPlanCreatedBy(this.getYearPlanCreatedBy());
        command.setYearPlanCreatedAt(this.getYearPlanCreatedAt());
        command.setYearPlanUpdatedBy(this.getYearPlanUpdatedBy());
        command.setYearPlanUpdatedAt(this.getYearPlanUpdatedAt());
        command.setYearPlanActive(this.getYearPlanActive());
        command.setYearPlanDeleted(this.getYearPlanDeleted());
        command.setPersonBirthDate(this.getPersonBirthDate());
        command.setPersonLoves((this.getPersonLoves() == null) ? null : this.getPersonLoves().toPersonalName());
        command.setPersonEmergencyContact((this.getPersonEmergencyContact() == null) ? null : this.getPersonEmergencyContact().toContact());
        command.setPersonCreatedBy(this.getPersonCreatedBy());
        command.setPersonCreatedAt(this.getPersonCreatedAt());
        command.setPersonUpdatedBy(this.getPersonUpdatedBy());
        command.setPersonUpdatedAt(this.getPersonUpdatedAt());
        command.setPersonActive(this.getPersonActive());
        command.setPersonDeleted(this.getPersonDeleted());
    }

    public DayPlanMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractDayPlanMvoCommand.SimpleCreateDayPlanMvo command = new AbstractDayPlanMvoCommand.SimpleCreateDayPlanMvo();
            copyTo((AbstractDayPlanMvoCommand.AbstractCreateDayPlanMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractDayPlanMvoCommand.SimpleMergePatchDayPlanMvo command = new AbstractDayPlanMvoCommand.SimpleMergePatchDayPlanMvo();
            copyTo((AbstractDayPlanMvoCommand.SimpleMergePatchDayPlanMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractDayPlanMvoCommand.AbstractCreateDayPlanMvo command)
    {
        copyTo((AbstractDayPlanMvoCommand.AbstractCreateOrMergePatchDayPlanMvo) command);
    }

    public void copyTo(AbstractDayPlanMvoCommand.AbstractMergePatchDayPlanMvo command)
    {
        copyTo((AbstractDayPlanMvoCommand.AbstractCreateOrMergePatchDayPlanMvo) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyMonthPlanDescriptionRemoved(this.getIsPropertyMonthPlanDescriptionRemoved());
        command.setIsPropertyMonthPlanVersionRemoved(this.getIsPropertyMonthPlanVersionRemoved());
        command.setIsPropertyMonthPlanCreatedByRemoved(this.getIsPropertyMonthPlanCreatedByRemoved());
        command.setIsPropertyMonthPlanCreatedAtRemoved(this.getIsPropertyMonthPlanCreatedAtRemoved());
        command.setIsPropertyMonthPlanUpdatedByRemoved(this.getIsPropertyMonthPlanUpdatedByRemoved());
        command.setIsPropertyMonthPlanUpdatedAtRemoved(this.getIsPropertyMonthPlanUpdatedAtRemoved());
        command.setIsPropertyMonthPlanActiveRemoved(this.getIsPropertyMonthPlanActiveRemoved());
        command.setIsPropertyMonthPlanDeletedRemoved(this.getIsPropertyMonthPlanDeletedRemoved());
        command.setIsPropertyYearPlanDescriptionRemoved(this.getIsPropertyYearPlanDescriptionRemoved());
        command.setIsPropertyYearPlanVersionRemoved(this.getIsPropertyYearPlanVersionRemoved());
        command.setIsPropertyYearPlanCreatedByRemoved(this.getIsPropertyYearPlanCreatedByRemoved());
        command.setIsPropertyYearPlanCreatedAtRemoved(this.getIsPropertyYearPlanCreatedAtRemoved());
        command.setIsPropertyYearPlanUpdatedByRemoved(this.getIsPropertyYearPlanUpdatedByRemoved());
        command.setIsPropertyYearPlanUpdatedAtRemoved(this.getIsPropertyYearPlanUpdatedAtRemoved());
        command.setIsPropertyYearPlanActiveRemoved(this.getIsPropertyYearPlanActiveRemoved());
        command.setIsPropertyYearPlanDeletedRemoved(this.getIsPropertyYearPlanDeletedRemoved());
        command.setIsPropertyPersonBirthDateRemoved(this.getIsPropertyPersonBirthDateRemoved());
        command.setIsPropertyPersonLovesRemoved(this.getIsPropertyPersonLovesRemoved());
        command.setIsPropertyPersonEmergencyContactRemoved(this.getIsPropertyPersonEmergencyContactRemoved());
        command.setIsPropertyPersonCreatedByRemoved(this.getIsPropertyPersonCreatedByRemoved());
        command.setIsPropertyPersonCreatedAtRemoved(this.getIsPropertyPersonCreatedAtRemoved());
        command.setIsPropertyPersonUpdatedByRemoved(this.getIsPropertyPersonUpdatedByRemoved());
        command.setIsPropertyPersonUpdatedAtRemoved(this.getIsPropertyPersonUpdatedAtRemoved());
        command.setIsPropertyPersonActiveRemoved(this.getIsPropertyPersonActiveRemoved());
        command.setIsPropertyPersonDeletedRemoved(this.getIsPropertyPersonDeletedRemoved());
    }

    public static class CreateDayPlanMvoDto extends CreateOrMergePatchDayPlanMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public DayPlanMvoCommand.CreateDayPlanMvo toCreateDayPlanMvo()
        {
            return (DayPlanMvoCommand.CreateDayPlanMvo) toCommand();
        }

    }

    public static class MergePatchDayPlanMvoDto extends CreateOrMergePatchDayPlanMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public DayPlanMvoCommand.MergePatchDayPlanMvo toMergePatchDayPlanMvo()
        {
            return (DayPlanMvoCommand.MergePatchDayPlanMvo) toCommand();
        }

    }

}

