package org.dddml.wms.domain.shipment;


public class RemoveShipmentReceiptImageDto extends CreateOrMergePatchShipmentReceiptImageDto
{

    public RemoveShipmentReceiptImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public ShipmentReceiptImageCommand.RemoveShipmentReceiptImage toRemoveShipmentReceiptImage()
    {
        AbstractShipmentReceiptImageCommand.SimpleRemoveShipmentReceiptImage command = new AbstractShipmentReceiptImageCommand.SimpleRemoveShipmentReceiptImage();
        ((AbstractShipmentReceiptImageCommandDto)this).copyTo(command);
        return command;
    }
}

