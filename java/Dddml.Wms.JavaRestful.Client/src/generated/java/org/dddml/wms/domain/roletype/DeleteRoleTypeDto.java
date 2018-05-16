package org.dddml.wms.domain.roletype;


public class DeleteRoleTypeDto extends AbstractRoleTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

