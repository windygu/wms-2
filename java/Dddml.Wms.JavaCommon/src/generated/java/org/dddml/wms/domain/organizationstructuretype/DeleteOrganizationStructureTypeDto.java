package org.dddml.wms.domain.organizationstructuretype;


public class DeleteOrganizationStructureTypeDto extends AbstractOrganizationStructureTypeCommandDto
{

    public DeleteOrganizationStructureTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrganizationStructureTypeCommand.DeleteOrganizationStructureType toDeleteOrganizationStructureType()
    {
        AbstractOrganizationStructureTypeCommand.SimpleDeleteOrganizationStructureType command = new AbstractOrganizationStructureTypeCommand.SimpleDeleteOrganizationStructureType();
        ((AbstractOrganizationStructureTypeCommandDto)this).copyTo(command);
        return command;
    }
}

