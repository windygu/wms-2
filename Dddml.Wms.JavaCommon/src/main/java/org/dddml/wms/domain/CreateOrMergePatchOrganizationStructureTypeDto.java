package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchOrganizationStructureTypeDto extends AbstractOrganizationStructureTypeCommandDto
{
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    public void copyTo(AbstractOrganizationStructureTypeCommand.AbstractCreateOrMergePatchOrganizationStructureType command)
    {
        ((AbstractOrganizationStructureTypeCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public OrganizationStructureTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrganizationStructureTypeCommand.SimpleCreateOrganizationStructureType command = new AbstractOrganizationStructureTypeCommand.SimpleCreateOrganizationStructureType();
            copyTo((AbstractOrganizationStructureTypeCommand.AbstractCreateOrganizationStructureType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrganizationStructureTypeCommand.SimpleMergePatchOrganizationStructureType command = new AbstractOrganizationStructureTypeCommand.SimpleMergePatchOrganizationStructureType();
            copyTo((AbstractOrganizationStructureTypeCommand.SimpleMergePatchOrganizationStructureType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrganizationStructureTypeCommand.AbstractCreateOrganizationStructureType command)
    {
        copyTo((AbstractOrganizationStructureTypeCommand.AbstractCreateOrMergePatchOrganizationStructureType) command);
    }

    public void copyTo(AbstractOrganizationStructureTypeCommand.AbstractMergePatchOrganizationStructureType command)
    {
        copyTo((AbstractOrganizationStructureTypeCommand.AbstractCreateOrMergePatchOrganizationStructureType) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrganizationStructureTypeDto extends CreateOrMergePatchOrganizationStructureTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrganizationStructureTypeCommand.CreateOrganizationStructureType toCreateOrganizationStructureType()
        {
            return (OrganizationStructureTypeCommand.CreateOrganizationStructureType) toCommand();
        }

    }

    public static class MergePatchOrganizationStructureTypeDto extends CreateOrMergePatchOrganizationStructureTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrganizationStructureTypeCommand.MergePatchOrganizationStructureType toMergePatchOrganizationStructureType()
        {
            return (OrganizationStructureTypeCommand.MergePatchOrganizationStructureType) toCommand();
        }

    }

}

