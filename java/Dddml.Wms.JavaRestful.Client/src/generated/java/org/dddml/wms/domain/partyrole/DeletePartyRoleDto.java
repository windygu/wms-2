package org.dddml.wms.domain.partyrole;


public class DeletePartyRoleDto extends AbstractPartyRoleCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

