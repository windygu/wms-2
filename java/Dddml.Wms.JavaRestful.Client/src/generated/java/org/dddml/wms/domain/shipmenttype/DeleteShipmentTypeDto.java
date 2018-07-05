package org.dddml.wms.domain.shipmenttype;


public class DeleteShipmentTypeDto extends AbstractShipmentTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

