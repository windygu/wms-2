package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchPersonDto extends AbstractPersonCommandDto
{
    private Date birthDate;

    public Date getBirthDate()
    {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    private PersonalNameDto loves;

    public PersonalNameDto getLoves()
    {
        return this.loves;
    }

    public void setLoves(PersonalNameDto loves)
    {
        this.loves = loves;
    }

    private ContactDto emergencyContact;

    public ContactDto getEmergencyContact()
    {
        return this.emergencyContact;
    }

    public void setEmergencyContact(ContactDto emergencyContact)
    {
        this.emergencyContact = emergencyContact;
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

    private CreateOrMergePatchYearPlanDto[] yearPlans;

    public CreateOrMergePatchYearPlanDto[] getYearPlans()
    {
        return this.yearPlans;
    }

    public void setYearPlans(CreateOrMergePatchYearPlanDto[] yearPlans)
    {
        this.yearPlans = yearPlans;
    }

    private Boolean isPropertyBirthDateRemoved;

    public Boolean getIsPropertyBirthDateRemoved()
    {
        return this.isPropertyBirthDateRemoved;
    }

    public void setIsPropertyBirthDateRemoved(Boolean removed)
    {
        this.isPropertyBirthDateRemoved = removed;
    }

    private Boolean isPropertyLovesRemoved;

    public Boolean getIsPropertyLovesRemoved()
    {
        return this.isPropertyLovesRemoved;
    }

    public void setIsPropertyLovesRemoved(Boolean removed)
    {
        this.isPropertyLovesRemoved = removed;
    }

    private Boolean isPropertyEmergencyContactRemoved;

    public Boolean getIsPropertyEmergencyContactRemoved()
    {
        return this.isPropertyEmergencyContactRemoved;
    }

    public void setIsPropertyEmergencyContactRemoved(Boolean removed)
    {
        this.isPropertyEmergencyContactRemoved = removed;
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

    public void copyTo(AbstractPersonCommand.AbstractCreateOrMergePatchPerson command)
    {
        ((AbstractPersonCommandDto) this).copyTo(command);
        command.setBirthDate(this.getBirthDate());
        command.setLoves((this.getLoves() == null) ? null : this.getLoves().toPersonalName());
        command.setEmergencyContact((this.getEmergencyContact() == null) ? null : this.getEmergencyContact().toContact());
        command.setActive(this.getActive());
    }

    public PersonCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPersonCommand.SimpleCreatePerson command = new AbstractPersonCommand.SimpleCreatePerson();
            copyTo((AbstractPersonCommand.AbstractCreatePerson) command);
            if (this.getYearPlans() != null) {
                for (CreateOrMergePatchYearPlanDto cmd : this.getYearPlans()) {
                    command.getYearPlans().add((YearPlanCommand.CreateYearPlan) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPersonCommand.SimpleMergePatchPerson command = new AbstractPersonCommand.SimpleMergePatchPerson();
            copyTo((AbstractPersonCommand.SimpleMergePatchPerson) command);
            if (this.getYearPlans() != null) {
                for (CreateOrMergePatchYearPlanDto cmd : this.getYearPlans()) {
                    command.getYearPlanCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPersonCommand.AbstractCreatePerson command)
    {
        copyTo((AbstractPersonCommand.AbstractCreateOrMergePatchPerson) command);
    }

    public void copyTo(AbstractPersonCommand.AbstractMergePatchPerson command)
    {
        copyTo((AbstractPersonCommand.AbstractCreateOrMergePatchPerson) command);
        command.setIsPropertyBirthDateRemoved(this.getIsPropertyBirthDateRemoved());
        command.setIsPropertyLovesRemoved(this.getIsPropertyLovesRemoved());
        command.setIsPropertyEmergencyContactRemoved(this.getIsPropertyEmergencyContactRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePersonDto extends CreateOrMergePatchPersonDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PersonCommand.CreatePerson toCreatePerson()
        {
            return (PersonCommand.CreatePerson) toCommand();
        }

    }

    public static class MergePatchPersonDto extends CreateOrMergePatchPersonDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PersonCommand.MergePatchPerson toMergePatchPerson()
        {
            return (PersonCommand.MergePatchPerson) toCommand();
        }

    }

}

