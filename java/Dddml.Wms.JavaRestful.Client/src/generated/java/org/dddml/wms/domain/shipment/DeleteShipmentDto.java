package org.dddml.wms.domain.shipment;


public class DeleteShipmentDto extends AbstractShipmentCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

