package org.dddml.wms.domain.partyrole;


public class DeletePartyRoleDto extends AbstractPartyRoleCommandDto
{

    public DeletePartyRoleDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

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

