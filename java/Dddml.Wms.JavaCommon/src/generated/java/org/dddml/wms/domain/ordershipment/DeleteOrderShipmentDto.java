package org.dddml.wms.domain.ordershipment;


public class DeleteOrderShipmentDto extends AbstractOrderShipmentCommandDto
{

    public DeleteOrderShipmentDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderShipmentCommand.DeleteOrderShipment toDeleteOrderShipment()
    {
        AbstractOrderShipmentCommand.SimpleDeleteOrderShipment command = new AbstractOrderShipmentCommand.SimpleDeleteOrderShipment();
        ((AbstractOrderShipmentCommandDto)this).copyTo(command);
        return command;
    }
}

