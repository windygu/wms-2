package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchPermissionDto extends AbstractPermissionCommandDto
{
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String parentPermissionId;

    public String getParentPermissionId()
    {
        return this.parentPermissionId;
    }

    public void setParentPermissionId(String parentPermissionId)
    {
        this.parentPermissionId = parentPermissionId;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved()
    {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed)
    {
        this.isPropertyNameRemoved = removed;
    }

    private Boolean isPropertyParentPermissionIdRemoved;

    public Boolean getIsPropertyParentPermissionIdRemoved()
    {
        return this.isPropertyParentPermissionIdRemoved;
    }

    public void setIsPropertyParentPermissionIdRemoved(Boolean removed)
    {
        this.isPropertyParentPermissionIdRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
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

    public void copyTo(AbstractPermissionCommand.AbstractCreateOrMergePatchPermission command)
    {
        ((AbstractPermissionCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setParentPermissionId(this.getParentPermissionId());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public PermissionCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPermissionCommand.SimpleCreatePermission command = new AbstractPermissionCommand.SimpleCreatePermission();
            copyTo((AbstractPermissionCommand.AbstractCreatePermission) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPermissionCommand.SimpleMergePatchPermission command = new AbstractPermissionCommand.SimpleMergePatchPermission();
            copyTo((AbstractPermissionCommand.SimpleMergePatchPermission) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPermissionCommand.AbstractCreatePermission command)
    {
        copyTo((AbstractPermissionCommand.AbstractCreateOrMergePatchPermission) command);
    }

    public void copyTo(AbstractPermissionCommand.AbstractMergePatchPermission command)
    {
        copyTo((AbstractPermissionCommand.AbstractCreateOrMergePatchPermission) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyParentPermissionIdRemoved(this.getIsPropertyParentPermissionIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePermissionDto extends CreateOrMergePatchPermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PermissionCommand.CreatePermission toCreatePermission()
        {
            return (PermissionCommand.CreatePermission) toCommand();
        }

    }

    public static class MergePatchPermissionDto extends CreateOrMergePatchPermissionDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PermissionCommand.MergePatchPermission toMergePatchPermission()
        {
            return (PermissionCommand.MergePatchPermission) toCommand();
        }

    }

}

