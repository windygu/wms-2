package org.dddml.wms.domain.shipmentpackage;


public class RemoveShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
{

    public RemoveShipmentPackageContentDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

