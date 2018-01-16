package org.dddml.wms.domain.shipmenttype;


public class DeleteShipmentTypeDto extends AbstractShipmentTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentTypeCommand.DeleteShipmentType toDeleteShipmentType()
    {
        AbstractShipmentTypeCommand.SimpleDeleteShipmentType command = new AbstractShipmentTypeCommand.SimpleDeleteShipmentType();
        ((AbstractShipmentTypeCommandDto)this).copyTo(command);
        return command;
    }
}

