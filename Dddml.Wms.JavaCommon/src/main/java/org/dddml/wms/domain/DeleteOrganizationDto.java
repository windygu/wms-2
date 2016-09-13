package org.dddml.wms.domain;


public class DeleteOrganizationDto extends AbstractOrganizationCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrganizationCommand.DeleteOrganization toDeleteOrganization()
    {
        AbstractOrganizationCommand.SimpleDeleteOrganization command = new AbstractOrganizationCommand.SimpleDeleteOrganization();
        ((AbstractOrganizationCommandDto)this).copyTo(command);
        return command;
    }
}

