package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchRolePermissionDto extends AbstractRolePermissionCommandDto
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


    public void copyTo(AbstractRolePermissionCommand.AbstractCreateOrMergePatchRolePermission command)
    {
        ((AbstractRolePermissionCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public RolePermissionCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractRolePermissionCommand.SimpleCreateRolePermission command = new AbstractRolePermissionCommand.SimpleCreateRolePermission();
            copyTo((AbstractRolePermissionCommand.AbstractCreateRolePermission) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractRolePermissionCommand.SimpleMergePatchRolePermission command = new AbstractRolePermissionCommand.SimpleMergePatchRolePermission();
            copyTo((AbstractRolePermissionCommand.SimpleMergePatchRolePermission) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractRolePermissionCommand.AbstractCreateRolePermission command)
    {
        copyTo((AbstractRolePermissionCommand.AbstractCreateOrMergePatchRolePermission) command);
    }

    public void copyTo(AbstractRolePermissionCommand.AbstractMergePatchRolePermission command)
    {
        copyTo((AbstractRolePermissionCommand.AbstractCreateOrMergePatchRolePermission) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateRolePermissionDto extends CreateOrMergePatchRolePermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public RolePermissionCommand.CreateRolePermission toCreateRolePermission()
        {
            return (RolePermissionCommand.CreateRolePermission) toCommand();
        }

    }

    public static class MergePatchRolePermissionDto extends CreateOrMergePatchRolePermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public RolePermissionCommand.MergePatchRolePermission toMergePatchRolePermission()
        {
            return (RolePermissionCommand.MergePatchRolePermission) toCommand();
        }

    }

}

