package org.dddml.wms.domain.orderitem;


public class DeleteOrderItemDto extends AbstractOrderItemCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderItemCommand.DeleteOrderItem toDeleteOrderItem()
    {
        AbstractOrderItemCommand.SimpleDeleteOrderItem command = new AbstractOrderItemCommand.SimpleDeleteOrderItem();
        ((AbstractOrderItemCommandDto)this).copyTo(command);
        return command;
    }
}

