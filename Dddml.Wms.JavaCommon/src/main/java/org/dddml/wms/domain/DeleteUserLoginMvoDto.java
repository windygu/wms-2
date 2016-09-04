package org.dddml.wms.domain;


public class DeleteUserLoginMvoDto extends AbstractUserLoginMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UserLoginMvoCommand.DeleteUserLoginMvo toDeleteUserLoginMvo()
    {
        AbstractUserLoginMvoCommand.SimpleDeleteUserLoginMvo command = new AbstractUserLoginMvoCommand.SimpleDeleteUserLoginMvo();
        ((AbstractUserLoginMvoCommandDto)this).copyTo(command);
        return command;
    }

}

