package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchRoleDto extends AbstractRoleCommandDto
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


    public void copyTo(AbstractRoleCommand.AbstractCreateOrMergePatchRole command)
    {
        ((AbstractRoleCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public RoleCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractRoleCommand.SimpleCreateRole command = new AbstractRoleCommand.SimpleCreateRole();
            copyTo((AbstractRoleCommand.AbstractCreateRole) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractRoleCommand.SimpleMergePatchRole command = new AbstractRoleCommand.SimpleMergePatchRole();
            copyTo((AbstractRoleCommand.SimpleMergePatchRole) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractRoleCommand.AbstractCreateRole command)
    {
        copyTo((AbstractRoleCommand.AbstractCreateOrMergePatchRole) command);
    }

    public void copyTo(AbstractRoleCommand.AbstractMergePatchRole command)
    {
        copyTo((AbstractRoleCommand.AbstractCreateOrMergePatchRole) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateRoleDto extends CreateOrMergePatchRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public RoleCommand.CreateRole toCreateRole()
        {
            return (RoleCommand.CreateRole) toCommand();
        }

    }

    public static class MergePatchRoleDto extends CreateOrMergePatchRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public RoleCommand.MergePatchRole toMergePatchRole()
        {
            return (RoleCommand.MergePatchRole) toCommand();
        }

    }

}

