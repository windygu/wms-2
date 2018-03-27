package org.dddml.wms.domain.shipmentpackage;


public class RemoveShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public ShipmentPackageContentCommand.RemoveShipmentPackageContent toRemoveShipmentPackageContent()
    {
        AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent command = new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
        ((AbstractShipmentPackageContentCommandDto)this).copyTo(command);
        return command;
    }
}

