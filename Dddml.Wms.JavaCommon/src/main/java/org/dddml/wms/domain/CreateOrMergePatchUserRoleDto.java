package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchUserRoleDto extends AbstractUserRoleCommandDto
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

    public void copyTo(AbstractUserRoleCommand.AbstractCreateOrMergePatchUserRole command)
    {
        ((AbstractUserRoleCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public UserRoleCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUserRoleCommand.SimpleCreateUserRole command = new AbstractUserRoleCommand.SimpleCreateUserRole();
            copyTo((AbstractUserRoleCommand.AbstractCreateUserRole) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUserRoleCommand.SimpleMergePatchUserRole command = new AbstractUserRoleCommand.SimpleMergePatchUserRole();
            copyTo((AbstractUserRoleCommand.SimpleMergePatchUserRole) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractUserRoleCommand.SimpleRemoveUserRole command = new AbstractUserRoleCommand.SimpleRemoveUserRole();
            ((AbstractUserRoleCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUserRoleCommand.AbstractCreateUserRole command)
    {
        copyTo((AbstractUserRoleCommand.AbstractCreateOrMergePatchUserRole) command);
    }

    public void copyTo(AbstractUserRoleCommand.AbstractMergePatchUserRole command)
    {
        copyTo((AbstractUserRoleCommand.AbstractCreateOrMergePatchUserRole) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUserRoleDto extends CreateOrMergePatchUserRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UserRoleCommand.CreateUserRole toCreateUserRole()
        {
            return (UserRoleCommand.CreateUserRole) toCommand();
        }

    }

    public static class MergePatchUserRoleDto extends CreateOrMergePatchUserRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UserRoleCommand.MergePatchUserRole toMergePatchUserRole()
        {
            return (UserRoleCommand.MergePatchUserRole) toCommand();
        }

    }

}

