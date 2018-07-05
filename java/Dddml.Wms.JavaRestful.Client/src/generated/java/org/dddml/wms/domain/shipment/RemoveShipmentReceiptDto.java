package org.dddml.wms.domain.shipment;


public class RemoveShipmentReceiptDto extends CreateOrMergePatchShipmentReceiptDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

