package org.dddml.wms.domain.shipmentpackage;


public class DeleteShipmentPackageDto extends AbstractShipmentPackageCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentPackageCommand.DeleteShipmentPackage toDeleteShipmentPackage()
    {
        AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage command = new AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage();
        ((AbstractShipmentPackageCommandDto)this).copyTo(command);
        return command;
    }
}

