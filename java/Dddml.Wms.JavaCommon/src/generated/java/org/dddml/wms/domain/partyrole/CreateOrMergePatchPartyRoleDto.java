package org.dddml.wms.domain.partyrole;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPartyRoleDto extends AbstractPartyRoleCommandDto
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

    public void copyTo(AbstractPartyRoleCommand.AbstractCreateOrMergePatchPartyRole command)
    {
        ((AbstractPartyRoleCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public PartyRoleCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPartyRoleCommand.SimpleCreatePartyRole command = new AbstractPartyRoleCommand.SimpleCreatePartyRole();
            copyTo((AbstractPartyRoleCommand.AbstractCreatePartyRole) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPartyRoleCommand.SimpleMergePatchPartyRole command = new AbstractPartyRoleCommand.SimpleMergePatchPartyRole();
            copyTo((AbstractPartyRoleCommand.SimpleMergePatchPartyRole) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPartyRoleCommand.AbstractCreatePartyRole command)
    {
        copyTo((AbstractPartyRoleCommand.AbstractCreateOrMergePatchPartyRole) command);
    }

    public void copyTo(AbstractPartyRoleCommand.AbstractMergePatchPartyRole command)
    {
        copyTo((AbstractPartyRoleCommand.AbstractCreateOrMergePatchPartyRole) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePartyRoleDto extends CreateOrMergePatchPartyRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PartyRoleCommand.CreatePartyRole toCreatePartyRole()
        {
            return (PartyRoleCommand.CreatePartyRole) toCommand();
        }

    }

    public static class MergePatchPartyRoleDto extends CreateOrMergePatchPartyRoleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PartyRoleCommand.MergePatchPartyRole toMergePatchPartyRole()
        {
            return (PartyRoleCommand.MergePatchPartyRole) toCommand();
        }

    }

}

