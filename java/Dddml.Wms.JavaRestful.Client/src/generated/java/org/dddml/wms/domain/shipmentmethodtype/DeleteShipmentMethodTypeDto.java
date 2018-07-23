package org.dddml.wms.domain.shipmentmethodtype;


public class DeleteShipmentMethodTypeDto extends AbstractShipmentMethodTypeCommandDto
{

    public DeleteShipmentMethodTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

