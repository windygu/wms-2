package org.dddml.wms.domain.orderitemmvo;


public class DeleteOrderItemMvoDto extends AbstractOrderItemMvoCommandDto
{

    public DeleteOrderItemMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderItemMvoCommand.DeleteOrderItemMvo toDeleteOrderItemMvo()
    {
        AbstractOrderItemMvoCommand.SimpleDeleteOrderItemMvo command = new AbstractOrderItemMvoCommand.SimpleDeleteOrderItemMvo();
        ((AbstractOrderItemMvoCommandDto)this).copyTo(command);
        return command;
    }
}

