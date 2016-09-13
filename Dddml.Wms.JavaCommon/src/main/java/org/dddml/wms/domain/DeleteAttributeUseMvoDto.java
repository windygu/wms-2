package org.dddml.wms.domain;


public class DeleteAttributeUseMvoDto extends AbstractAttributeUseMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeUseMvoCommand.DeleteAttributeUseMvo toDeleteAttributeUseMvo()
    {
        AbstractAttributeUseMvoCommand.SimpleDeleteAttributeUseMvo command = new AbstractAttributeUseMvoCommand.SimpleDeleteAttributeUseMvo();
        ((AbstractAttributeUseMvoCommandDto)this).copyTo(command);
        return command;
    }
}

