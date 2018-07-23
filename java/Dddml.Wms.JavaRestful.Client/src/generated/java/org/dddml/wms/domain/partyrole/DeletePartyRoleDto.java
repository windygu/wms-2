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

}

