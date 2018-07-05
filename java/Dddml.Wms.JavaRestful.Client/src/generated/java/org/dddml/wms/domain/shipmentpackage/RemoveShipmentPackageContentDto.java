package org.dddml.wms.domain.shipmentpackage;


public class RemoveShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

