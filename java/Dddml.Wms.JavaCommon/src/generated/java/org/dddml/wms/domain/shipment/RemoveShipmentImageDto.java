package org.dddml.wms.domain.shipment;


public class RemoveShipmentImageDto extends CreateOrMergePatchShipmentImageDto
{

    public RemoveShipmentImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public ShipmentImageCommand.RemoveShipmentImage toRemoveShipmentImage()
    {
        AbstractShipmentImageCommand.SimpleRemoveShipmentImage command = new AbstractShipmentImageCommand.SimpleRemoveShipmentImage();
        ((AbstractShipmentImageCommandDto)this).copyTo(command);
        return command;
    }
}

