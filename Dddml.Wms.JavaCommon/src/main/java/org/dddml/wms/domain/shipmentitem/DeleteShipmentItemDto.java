package org.dddml.wms.domain.shipmentitem;


public class DeleteShipmentItemDto extends AbstractShipmentItemCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentItemCommand.DeleteShipmentItem toDeleteShipmentItem()
    {
        AbstractShipmentItemCommand.SimpleDeleteShipmentItem command = new AbstractShipmentItemCommand.SimpleDeleteShipmentItem();
        ((AbstractShipmentItemCommandDto)this).copyTo(command);
        return command;
    }
}

