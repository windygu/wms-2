package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistRoleDto extends AbstractPicklistRoleCommandDto
{
    /**
     * Active
     */
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

    public void copyTo(AbstractPicklistRoleCommand.AbstractCreateOrMergePatchPicklistRole command)
    {
        ((AbstractPicklistRoleCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public PicklistRoleCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPicklistRoleCommand.SimpleCreatePicklistRole command = new AbstractPicklistRoleCommand.SimpleCreatePicklistRole();
            copyTo((AbstractPicklistRoleCommand.AbstractCreatePicklistRole) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole command = new AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole();
            copyTo((AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractPicklistRoleCommand.SimpleRemovePicklistRole command = new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
            ((AbstractPicklistRoleCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPicklistRoleCommand.AbstractCreatePicklistRole command)
    {
        copyTo((AbstractPicklistRoleCommand.AbstractCreateOrMergePatchPicklistRole) command);
    }

    public void copyTo(AbstractPicklistRoleCommand.AbstractMergePatchPicklistRole command)
    {
        copyTo((AbstractPicklistRoleCommand.AbstractCreateOrMergePatchPicklistRole) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
    {
        public CreatePicklistRoleDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PicklistRoleCommand.CreatePicklistRole toCreatePicklistRole()
        {
            return (PicklistRoleCommand.CreatePicklistRole) toCommand();
        }

    }

    public static class MergePatchPicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
    {
        public MergePatchPicklistRoleDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PicklistRoleCommand.MergePatchPicklistRole toMergePatchPicklistRole()
        {
            return (PicklistRoleCommand.MergePatchPicklistRole) toCommand();
        }

    }

}

