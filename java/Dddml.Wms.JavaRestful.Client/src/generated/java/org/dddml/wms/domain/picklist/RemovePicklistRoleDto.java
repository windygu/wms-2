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

}

