package org.dddml.wms.domain;


public class DeleteUserRoleMvoDto extends AbstractUserRoleMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UserRoleMvoCommand.DeleteUserRoleMvo toDeleteUserRoleMvo()
    {
        AbstractUserRoleMvoCommand.SimpleDeleteUserRoleMvo command = new AbstractUserRoleMvoCommand.SimpleDeleteUserRoleMvo();
        ((AbstractUserRoleMvoCommandDto)this).copyTo(command);
        return command;
    }
}

