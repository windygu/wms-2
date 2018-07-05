package org.dddml.wms.domain.shipmentpackage;


public class DeleteShipmentPackageDto extends AbstractShipmentPackageCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

