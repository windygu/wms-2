package org.dddml.wms.domain.shipment;


public class RemoveItemIssuanceDto extends CreateOrMergePatchItemIssuanceDto
{

    public RemoveItemIssuanceDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

