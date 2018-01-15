package org.dddml.wms.domain.shipment;


public class RemoveShipmentItemDto extends CreateOrMergePatchShipmentItemDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public ShipmentItemCommand.RemoveShipmentItem toRemoveShipmentItem()
    {
        AbstractShipmentItemCommand.SimpleRemoveShipmentItem command = new AbstractShipmentItemCommand.SimpleRemoveShipmentItem();
        ((AbstractShipmentItemCommandDto)this).copyTo(command);
        return command;
    }
}

