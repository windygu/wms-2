package org.dddml.wms.domain.shipmentpackagecontentmvo;


public class DeleteShipmentPackageContentMvoDto extends AbstractShipmentPackageContentMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

