package org.dddml.wms.domain.shipmenttype;


public class DeleteShipmentTypeDto extends AbstractShipmentTypeCommandDto
{

    public DeleteShipmentTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

