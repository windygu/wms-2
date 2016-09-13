package org.dddml.wms.domain;


public class RemoveUserLoginDto extends CreateOrMergePatchUserLoginDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public UserLoginCommand.RemoveUserLogin toRemoveUserLogin()
    {
        AbstractUserLoginCommand.SimpleRemoveUserLogin command = new AbstractUserLoginCommand.SimpleRemoveUserLogin();
        ((AbstractUserLoginCommandDto)this).copyTo(command);
        return command;
    }
}

