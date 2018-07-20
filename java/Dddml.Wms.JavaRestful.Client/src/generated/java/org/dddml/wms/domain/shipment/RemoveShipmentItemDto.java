package org.dddml.wms.domain.shipment;


public class RemoveShipmentItemDto extends CreateOrMergePatchShipmentItemDto
{

    public RemoveShipmentItemDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

