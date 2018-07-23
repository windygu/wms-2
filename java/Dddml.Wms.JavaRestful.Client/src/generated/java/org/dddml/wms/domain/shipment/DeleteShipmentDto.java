package org.dddml.wms.domain.shipment;


public class DeleteShipmentDto extends AbstractShipmentCommandDto
{

    public DeleteShipmentDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

