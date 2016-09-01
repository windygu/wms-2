package org.dddml.wms.domain;


public class DeleteUserPermissionMvoDto extends AbstractUserPermissionMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UserPermissionMvoCommand.DeleteUserPermissionMvo toDeleteUserPermissionMvo()
    {
        AbstractUserPermissionMvoCommand.SimpleDeleteUserPermissionMvo command = new AbstractUserPermissionMvoCommand.SimpleDeleteUserPermissionMvo();
        ((AbstractUserPermissionMvoCommandDto)this).copyTo(command);
        return command;
    }

}

