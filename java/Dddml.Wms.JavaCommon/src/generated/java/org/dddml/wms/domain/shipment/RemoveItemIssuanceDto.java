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

    public ItemIssuanceCommand.RemoveItemIssuance toRemoveItemIssuance()
    {
        AbstractItemIssuanceCommand.SimpleRemoveItemIssuance command = new AbstractItemIssuanceCommand.SimpleRemoveItemIssuance();
        ((AbstractItemIssuanceCommandDto)this).copyTo(command);
        return command;
    }
}

