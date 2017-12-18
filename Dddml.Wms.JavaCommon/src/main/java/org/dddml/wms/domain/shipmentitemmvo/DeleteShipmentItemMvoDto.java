package org.dddml.wms.domain.shipmentitemmvo;


public class DeleteShipmentItemMvoDto extends AbstractShipmentItemMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentItemMvoCommand.DeleteShipmentItemMvo toDeleteShipmentItemMvo()
    {
        AbstractShipmentItemMvoCommand.SimpleDeleteShipmentItemMvo command = new AbstractShipmentItemMvoCommand.SimpleDeleteShipmentItemMvo();
        ((AbstractShipmentItemMvoCommandDto)this).copyTo(command);
        return command;
    }
}

