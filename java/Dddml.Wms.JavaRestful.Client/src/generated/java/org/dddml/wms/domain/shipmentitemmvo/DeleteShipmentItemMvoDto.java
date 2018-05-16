package org.dddml.wms.domain.shipmentitemmvo;


public class DeleteShipmentItemMvoDto extends AbstractShipmentItemMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

