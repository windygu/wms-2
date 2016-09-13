package org.dddml.wms.domain;


public class DeleteUserDto extends AbstractUserCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UserCommand.DeleteUser toDeleteUser()
    {
        AbstractUserCommand.SimpleDeleteUser command = new AbstractUserCommand.SimpleDeleteUser();
        ((AbstractUserCommandDto)this).copyTo(command);
        return command;
    }
}

