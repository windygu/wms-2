package org.dddml.wms.domain.order;


public class RemoveOrderRoleDto extends CreateOrMergePatchOrderRoleDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public OrderRoleCommand.RemoveOrderRole toRemoveOrderRole()
    {
        AbstractOrderRoleCommand.SimpleRemoveOrderRole command = new AbstractOrderRoleCommand.SimpleRemoveOrderRole();
        ((AbstractOrderRoleCommandDto)this).copyTo(command);
        return command;
    }
}

