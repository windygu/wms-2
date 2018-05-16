package org.dddml.wms.domain.shipment;


public class RemoveShipmentItemDto extends CreateOrMergePatchShipmentItemDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

