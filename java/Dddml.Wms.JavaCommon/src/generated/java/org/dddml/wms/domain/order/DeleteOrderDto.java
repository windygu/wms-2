package org.dddml.wms.domain.order;


public class DeleteOrderDto extends AbstractOrderCommandDto
{

    public DeleteOrderDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderCommand.DeleteOrder toDeleteOrder()
    {
        AbstractOrderCommand.SimpleDeleteOrder command = new AbstractOrderCommand.SimpleDeleteOrder();
        ((AbstractOrderCommandDto)this).copyTo(command);
        return command;
    }
}

