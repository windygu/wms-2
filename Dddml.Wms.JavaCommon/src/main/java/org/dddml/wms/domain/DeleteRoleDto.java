package org.dddml.wms.domain;


public class DeleteRoleDto extends AbstractRoleCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public RoleCommand.DeleteRole toDeleteRole()
    {
        AbstractRoleCommand.SimpleDeleteRole command = new AbstractRoleCommand.SimpleDeleteRole();
        ((AbstractRoleCommandDto)this).copyTo(command);
        return command;
    }
}

