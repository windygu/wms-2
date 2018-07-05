package org.dddml.wms.domain.shipment;


public class RemoveItemIssuanceDto extends CreateOrMergePatchItemIssuanceDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

