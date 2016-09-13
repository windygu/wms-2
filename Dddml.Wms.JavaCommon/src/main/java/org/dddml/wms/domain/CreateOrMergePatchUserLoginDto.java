package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchUserLoginDto extends AbstractUserLoginCommandDto
{
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractUserLoginCommand.AbstractCreateOrMergePatchUserLogin command)
    {
        ((AbstractUserLoginCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public UserLoginCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUserLoginCommand.SimpleCreateUserLogin command = new AbstractUserLoginCommand.SimpleCreateUserLogin();
            copyTo((AbstractUserLoginCommand.AbstractCreateUserLogin) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUserLoginCommand.SimpleMergePatchUserLogin command = new AbstractUserLoginCommand.SimpleMergePatchUserLogin();
            copyTo((AbstractUserLoginCommand.SimpleMergePatchUserLogin) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractUserLoginCommand.SimpleRemoveUserLogin command = new AbstractUserLoginCommand.SimpleRemoveUserLogin();
            ((AbstractUserLoginCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUserLoginCommand.AbstractCreateUserLogin command)
    {
        copyTo((AbstractUserLoginCommand.AbstractCreateOrMergePatchUserLogin) command);
    }

    public void copyTo(AbstractUserLoginCommand.AbstractMergePatchUserLogin command)
    {
        copyTo((AbstractUserLoginCommand.AbstractCreateOrMergePatchUserLogin) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUserLoginDto extends CreateOrMergePatchUserLoginDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UserLoginCommand.CreateUserLogin toCreateUserLogin()
        {
            return (UserLoginCommand.CreateUserLogin) toCommand();
        }

    }

    public static class MergePatchUserLoginDto extends CreateOrMergePatchUserLoginDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UserLoginCommand.MergePatchUserLogin toMergePatchUserLogin()
        {
            return (UserLoginCommand.MergePatchUserLogin) toCommand();
        }

    }

}

