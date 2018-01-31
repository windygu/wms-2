package org.dddml.wms.domain.shipment;


public class RemoveShipmentReceiptDto extends CreateOrMergePatchShipmentReceiptDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public ShipmentReceiptCommand.RemoveShipmentReceipt toRemoveShipmentReceipt()
    {
        AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt command = new AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt();
        ((AbstractShipmentReceiptCommandDto)this).copyTo(command);
        return command;
    }
}

