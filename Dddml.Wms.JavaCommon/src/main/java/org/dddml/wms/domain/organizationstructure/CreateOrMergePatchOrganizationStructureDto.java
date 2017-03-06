package org.dddml.wms.domain.organizationstructure;

import org.dddml.wms.domain.*;
import java.util.Date;

public class CreateOrMergePatchOrganizationStructureDto extends AbstractOrganizationStructureCommandDto
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

    public void copyTo(AbstractOrganizationStructureCommand.AbstractCreateOrMergePatchOrganizationStructure command)
    {
        ((AbstractOrganizationStructureCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public OrganizationStructureCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrganizationStructureCommand.SimpleCreateOrganizationStructure command = new AbstractOrganizationStructureCommand.SimpleCreateOrganizationStructure();
            copyTo((AbstractOrganizationStructureCommand.AbstractCreateOrganizationStructure) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrganizationStructureCommand.SimpleMergePatchOrganizationStructure command = new AbstractOrganizationStructureCommand.SimpleMergePatchOrganizationStructure();
            copyTo((AbstractOrganizationStructureCommand.SimpleMergePatchOrganizationStructure) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrganizationStructureCommand.AbstractCreateOrganizationStructure command)
    {
        copyTo((AbstractOrganizationStructureCommand.AbstractCreateOrMergePatchOrganizationStructure) command);
    }

    public void copyTo(AbstractOrganizationStructureCommand.AbstractMergePatchOrganizationStructure command)
    {
        copyTo((AbstractOrganizationStructureCommand.AbstractCreateOrMergePatchOrganizationStructure) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrganizationStructureDto extends CreateOrMergePatchOrganizationStructureDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrganizationStructureCommand.CreateOrganizationStructure toCreateOrganizationStructure()
        {
            return (OrganizationStructureCommand.CreateOrganizationStructure) toCommand();
        }

    }

    public static class MergePatchOrganizationStructureDto extends CreateOrMergePatchOrganizationStructureDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrganizationStructureCommand.MergePatchOrganizationStructure toMergePatchOrganizationStructure()
        {
            return (OrganizationStructureCommand.MergePatchOrganizationStructure) toCommand();
        }

    }

}

