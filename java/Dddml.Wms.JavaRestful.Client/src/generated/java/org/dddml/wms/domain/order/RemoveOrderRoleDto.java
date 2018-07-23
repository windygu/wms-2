package org.dddml.wms.domain.order;


public class RemoveOrderRoleDto extends CreateOrMergePatchOrderRoleDto
{

    public RemoveOrderRoleDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

