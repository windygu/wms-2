package org.dddml.wms.domain.shipment;


public class RemoveShipmentImageDto extends CreateOrMergePatchShipmentImageDto
{

    public RemoveShipmentImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

