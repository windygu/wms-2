package org.dddml.wms.domain.orderheader;


public class DeleteOrderHeaderDto extends AbstractOrderHeaderCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderHeaderCommand.DeleteOrderHeader toDeleteOrderHeader()
    {
        AbstractOrderHeaderCommand.SimpleDeleteOrderHeader command = new AbstractOrderHeaderCommand.SimpleDeleteOrderHeader();
        ((AbstractOrderHeaderCommandDto)this).copyTo(command);
        return command;
    }
}

