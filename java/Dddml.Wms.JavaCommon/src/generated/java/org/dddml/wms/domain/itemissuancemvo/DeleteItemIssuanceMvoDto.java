package org.dddml.wms.domain.itemissuancemvo;


public class DeleteItemIssuanceMvoDto extends AbstractItemIssuanceMvoCommandDto
{

    public DeleteItemIssuanceMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ItemIssuanceMvoCommand.DeleteItemIssuanceMvo toDeleteItemIssuanceMvo()
    {
        AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo command = new AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo();
        ((AbstractItemIssuanceMvoCommandDto)this).copyTo(command);
        return command;
    }
}

