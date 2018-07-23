package org.dddml.wms.domain.roletype;


public class DeleteRoleTypeDto extends AbstractRoleTypeCommandDto
{

    public DeleteRoleTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

