package org.dddml.wms.domain.shipmentpackagecontentmvo;


public class DeleteShipmentPackageContentMvoDto extends AbstractShipmentPackageContentMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo toDeleteShipmentPackageContentMvo()
    {
        AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo command = new AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo();
        ((AbstractShipmentPackageContentMvoCommandDto)this).copyTo(command);
        return command;
    }
}

