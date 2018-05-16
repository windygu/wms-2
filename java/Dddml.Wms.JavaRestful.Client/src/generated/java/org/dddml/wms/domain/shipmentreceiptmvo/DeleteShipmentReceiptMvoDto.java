package org.dddml.wms.domain.shipmentreceiptmvo;


public class DeleteShipmentReceiptMvoDto extends AbstractShipmentReceiptMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

