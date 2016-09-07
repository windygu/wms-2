package org.dddml.wms.domain;


public class RemoveUserRoleDto extends CreateOrMergePatchUserRoleDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public UserRoleCommand.RemoveUserRole toRemoveUserRole()
    {
        AbstractUserRoleCommand.SimpleRemoveUserRole command = new AbstractUserRoleCommand.SimpleRemoveUserRole();
        ((AbstractUserRoleCommandDto)this).copyTo(command);
        return command;
    }

}

