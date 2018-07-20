package org.dddml.wms.domain.shipment;


public class RemoveShipmentReceiptDto extends CreateOrMergePatchShipmentReceiptDto
{

    public RemoveShipmentReceiptDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

