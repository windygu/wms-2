package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchUserPermissionDto extends AbstractUserPermissionCommandDto
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

    public void copyTo(AbstractUserPermissionCommand.AbstractCreateOrMergePatchUserPermission command)
    {
        ((AbstractUserPermissionCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public UserPermissionCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUserPermissionCommand.SimpleCreateUserPermission command = new AbstractUserPermissionCommand.SimpleCreateUserPermission();
            copyTo((AbstractUserPermissionCommand.AbstractCreateUserPermission) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUserPermissionCommand.SimpleMergePatchUserPermission command = new AbstractUserPermissionCommand.SimpleMergePatchUserPermission();
            copyTo((AbstractUserPermissionCommand.SimpleMergePatchUserPermission) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractUserPermissionCommand.SimpleRemoveUserPermission command = new AbstractUserPermissionCommand.SimpleRemoveUserPermission();
            ((AbstractUserPermissionCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUserPermissionCommand.AbstractCreateUserPermission command)
    {
        copyTo((AbstractUserPermissionCommand.AbstractCreateOrMergePatchUserPermission) command);
    }

    public void copyTo(AbstractUserPermissionCommand.AbstractMergePatchUserPermission command)
    {
        copyTo((AbstractUserPermissionCommand.AbstractCreateOrMergePatchUserPermission) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUserPermissionDto extends CreateOrMergePatchUserPermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UserPermissionCommand.CreateUserPermission toCreateUserPermission()
        {
            return (UserPermissionCommand.CreateUserPermission) toCommand();
        }

    }

    public static class MergePatchUserPermissionDto extends CreateOrMergePatchUserPermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UserPermissionCommand.MergePatchUserPermission toMergePatchUserPermission()
        {
            return (UserPermissionCommand.MergePatchUserPermission) toCommand();
        }

    }

}

