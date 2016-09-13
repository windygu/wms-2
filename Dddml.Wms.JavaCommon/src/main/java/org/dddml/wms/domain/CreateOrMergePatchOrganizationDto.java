package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchOrganizationDto extends AbstractOrganizationCommandDto
{
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    private Boolean isSummary;

    public Boolean getIsSummary()
    {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary)
    {
        this.isSummary = isSummary;
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

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved()
    {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed)
    {
        this.isPropertyNameRemoved = removed;
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

    private Boolean isPropertyTypeRemoved;

    public Boolean getIsPropertyTypeRemoved()
    {
        return this.isPropertyTypeRemoved;
    }

    public void setIsPropertyTypeRemoved(Boolean removed)
    {
        this.isPropertyTypeRemoved = removed;
    }

    private Boolean isPropertyIsSummaryRemoved;

    public Boolean getIsPropertyIsSummaryRemoved()
    {
        return this.isPropertyIsSummaryRemoved;
    }

    public void setIsPropertyIsSummaryRemoved(Boolean removed)
    {
        this.isPropertyIsSummaryRemoved = removed;
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

    public void copyTo(AbstractOrganizationCommand.AbstractCreateOrMergePatchOrganization command)
    {
        ((AbstractOrganizationCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setDescription(this.getDescription());
        command.setType(this.getType());
        command.setIsSummary(this.getIsSummary());
        command.setActive(this.getActive());
    }

    public OrganizationCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrganizationCommand.SimpleCreateOrganization command = new AbstractOrganizationCommand.SimpleCreateOrganization();
            copyTo((AbstractOrganizationCommand.AbstractCreateOrganization) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrganizationCommand.SimpleMergePatchOrganization command = new AbstractOrganizationCommand.SimpleMergePatchOrganization();
            copyTo((AbstractOrganizationCommand.SimpleMergePatchOrganization) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrganizationCommand.AbstractCreateOrganization command)
    {
        copyTo((AbstractOrganizationCommand.AbstractCreateOrMergePatchOrganization) command);
    }

    public void copyTo(AbstractOrganizationCommand.AbstractMergePatchOrganization command)
    {
        copyTo((AbstractOrganizationCommand.AbstractCreateOrMergePatchOrganization) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyTypeRemoved(this.getIsPropertyTypeRemoved());
        command.setIsPropertyIsSummaryRemoved(this.getIsPropertyIsSummaryRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrganizationDto extends CreateOrMergePatchOrganizationDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrganizationCommand.CreateOrganization toCreateOrganization()
        {
            return (OrganizationCommand.CreateOrganization) toCommand();
        }

    }

    public static class MergePatchOrganizationDto extends CreateOrMergePatchOrganizationDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrganizationCommand.MergePatchOrganization toMergePatchOrganization()
        {
            return (OrganizationCommand.MergePatchOrganization) toCommand();
        }

    }

}

