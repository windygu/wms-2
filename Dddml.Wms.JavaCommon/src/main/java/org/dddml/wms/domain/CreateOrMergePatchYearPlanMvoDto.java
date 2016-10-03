package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchYearPlanMvoDto extends AbstractYearPlanMvoCommandDto
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

    private String personEmail;

    public String getPersonEmail()
    {
        return this.personEmail;
    }

    public void setPersonEmail(String personEmail)
    {
        this.personEmail = personEmail;
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

    private String personUpdatedBy;

    public String getPersonUpdatedBy()
    {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy)
    {
        this.personUpdatedBy = personUpdatedBy;
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

    private Boolean isPropertyPersonEmailRemoved;

    public Boolean getIsPropertyPersonEmailRemoved()
    {
        return this.isPropertyPersonEmailRemoved;
    }

    public void setIsPropertyPersonEmailRemoved(Boolean removed)
    {
        this.isPropertyPersonEmailRemoved = removed;
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

    private Boolean isPropertyPersonUpdatedByRemoved;

    public Boolean getIsPropertyPersonUpdatedByRemoved()
    {
        return this.isPropertyPersonUpdatedByRemoved;
    }

    public void setIsPropertyPersonUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyPersonUpdatedByRemoved = removed;
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

    public void copyTo(AbstractYearPlanMvoCommand.AbstractCreateOrMergePatchYearPlanMvo command)
    {
        ((AbstractYearPlanMvoCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setPersonBirthDate(this.getPersonBirthDate());
        command.setPersonLoves((this.getPersonLoves() == null) ? null : this.getPersonLoves().toPersonalName());
        command.setPersonEmergencyContact((this.getPersonEmergencyContact() == null) ? null : this.getPersonEmergencyContact().toContact());
        command.setPersonEmail(this.getPersonEmail());
        command.setPersonCreatedBy(this.getPersonCreatedBy());
        command.setPersonUpdatedBy(this.getPersonUpdatedBy());
        command.setPersonCreatedAt(this.getPersonCreatedAt());
        command.setPersonUpdatedAt(this.getPersonUpdatedAt());
        command.setPersonActive(this.getPersonActive());
        command.setPersonDeleted(this.getPersonDeleted());
    }

    public YearPlanMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractYearPlanMvoCommand.SimpleCreateYearPlanMvo command = new AbstractYearPlanMvoCommand.SimpleCreateYearPlanMvo();
            copyTo((AbstractYearPlanMvoCommand.AbstractCreateYearPlanMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractYearPlanMvoCommand.SimpleMergePatchYearPlanMvo command = new AbstractYearPlanMvoCommand.SimpleMergePatchYearPlanMvo();
            copyTo((AbstractYearPlanMvoCommand.SimpleMergePatchYearPlanMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractYearPlanMvoCommand.AbstractCreateYearPlanMvo command)
    {
        copyTo((AbstractYearPlanMvoCommand.AbstractCreateOrMergePatchYearPlanMvo) command);
    }

    public void copyTo(AbstractYearPlanMvoCommand.AbstractMergePatchYearPlanMvo command)
    {
        copyTo((AbstractYearPlanMvoCommand.AbstractCreateOrMergePatchYearPlanMvo) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyPersonBirthDateRemoved(this.getIsPropertyPersonBirthDateRemoved());
        command.setIsPropertyPersonLovesRemoved(this.getIsPropertyPersonLovesRemoved());
        command.setIsPropertyPersonEmergencyContactRemoved(this.getIsPropertyPersonEmergencyContactRemoved());
        command.setIsPropertyPersonEmailRemoved(this.getIsPropertyPersonEmailRemoved());
        command.setIsPropertyPersonCreatedByRemoved(this.getIsPropertyPersonCreatedByRemoved());
        command.setIsPropertyPersonUpdatedByRemoved(this.getIsPropertyPersonUpdatedByRemoved());
        command.setIsPropertyPersonCreatedAtRemoved(this.getIsPropertyPersonCreatedAtRemoved());
        command.setIsPropertyPersonUpdatedAtRemoved(this.getIsPropertyPersonUpdatedAtRemoved());
        command.setIsPropertyPersonActiveRemoved(this.getIsPropertyPersonActiveRemoved());
        command.setIsPropertyPersonDeletedRemoved(this.getIsPropertyPersonDeletedRemoved());
    }

    public static class CreateYearPlanMvoDto extends CreateOrMergePatchYearPlanMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public YearPlanMvoCommand.CreateYearPlanMvo toCreateYearPlanMvo()
        {
            return (YearPlanMvoCommand.CreateYearPlanMvo) toCommand();
        }

    }

    public static class MergePatchYearPlanMvoDto extends CreateOrMergePatchYearPlanMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public YearPlanMvoCommand.MergePatchYearPlanMvo toMergePatchYearPlanMvo()
        {
            return (YearPlanMvoCommand.MergePatchYearPlanMvo) toCommand();
        }

    }

}

