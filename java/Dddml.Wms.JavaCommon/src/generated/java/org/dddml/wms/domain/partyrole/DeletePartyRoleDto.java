package org.dddml.wms.domain.partyrole;


public class DeletePartyRoleDto extends AbstractPartyRoleCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PartyRoleCommand.DeletePartyRole toDeletePartyRole()
    {
        AbstractPartyRoleCommand.SimpleDeletePartyRole command = new AbstractPartyRoleCommand.SimpleDeletePartyRole();
        ((AbstractPartyRoleCommandDto)this).copyTo(command);
        return command;
    }
}

