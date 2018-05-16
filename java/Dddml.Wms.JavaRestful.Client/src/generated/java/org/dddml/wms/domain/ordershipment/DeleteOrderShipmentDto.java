package org.dddml.wms.domain.ordershipment;


public class DeleteOrderShipmentDto extends AbstractOrderShipmentCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

