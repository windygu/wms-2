package org.dddml.wms.domain.picklist;


public class RemovePicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

