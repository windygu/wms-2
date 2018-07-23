package org.dddml.wms.domain.ordershipgroupmvo;


public class DeleteOrderShipGroupMvoDto extends AbstractOrderShipGroupMvoCommandDto
{

    public DeleteOrderShipGroupMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo toDeleteOrderShipGroupMvo()
    {
        AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo command = new AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo();
        ((AbstractOrderShipGroupMvoCommandDto)this).copyTo(command);
        return command;
    }
}

