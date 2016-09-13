package org.dddml.wms.domain;


public class RemoveUserPermissionDto extends CreateOrMergePatchUserPermissionDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public UserPermissionCommand.RemoveUserPermission toRemoveUserPermission()
    {
        AbstractUserPermissionCommand.SimpleRemoveUserPermission command = new AbstractUserPermissionCommand.SimpleRemoveUserPermission();
        ((AbstractUserPermissionCommandDto)this).copyTo(command);
        return command;
    }
}

