package org.dddml.wms.domain;


public class DeleteOrganizationStructureDto extends AbstractOrganizationStructureCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrganizationStructureCommand.DeleteOrganizationStructure toDeleteOrganizationStructure()
    {
        AbstractOrganizationStructureCommand.SimpleDeleteOrganizationStructure command = new AbstractOrganizationStructureCommand.SimpleDeleteOrganizationStructure();
        ((AbstractOrganizationStructureCommandDto)this).copyTo(command);
        return command;
    }

}

