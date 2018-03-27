package org.dddml.wms.domain.order;


public class RemoveOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public OrderShipGroupCommand.RemoveOrderShipGroup toRemoveOrderShipGroup()
    {
        AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup command = new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
        ((AbstractOrderShipGroupCommandDto)this).copyTo(command);
        return command;
    }
}

