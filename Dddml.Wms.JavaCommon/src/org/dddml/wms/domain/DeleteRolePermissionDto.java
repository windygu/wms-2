package org.dddml.wms.domain;


public class DeleteRolePermissionDto extends AbstractRolePermissionCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public RolePermissionCommand.DeleteRolePermission toDeleteRolePermission()
    {
        AbstractRolePermissionCommand.SimpleDeleteRolePermission command = new AbstractRolePermissionCommand.SimpleDeleteRolePermission();
        ((AbstractRolePermissionCommandDto)this).copyTo(command);
        return command;
    }

}

