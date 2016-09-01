package org.dddml.wms.domain;


public class DeleteOrganizationStructureTypeDto extends AbstractOrganizationStructureTypeCommandDto
{

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

