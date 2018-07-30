package org.dddml.wms.domain.shipment;


public class RemoveShipmentReceiptImageDto extends CreateOrMergePatchShipmentReceiptImageDto
{

    public RemoveShipmentReceiptImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

