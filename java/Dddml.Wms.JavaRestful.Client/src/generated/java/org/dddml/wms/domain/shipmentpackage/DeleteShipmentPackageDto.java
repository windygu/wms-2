package org.dddml.wms.domain.shipmentpackage;


public class DeleteShipmentPackageDto extends AbstractShipmentPackageCommandDto
{

    public DeleteShipmentPackageDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

