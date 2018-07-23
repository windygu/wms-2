package org.dddml.wms.domain.picklist;


public class RemovePicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
{

    public RemovePicklistRoleDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public PicklistRoleCommand.RemovePicklistRole toRemovePicklistRole()
    {
        AbstractPicklistRoleCommand.SimpleRemovePicklistRole command = new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
        ((AbstractPicklistRoleCommandDto)this).copyTo(command);
        return command;
    }
}

