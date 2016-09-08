package org.dddml.wms.domain;


public class DeleteAttributeSetDto extends AbstractAttributeSetCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeSetCommand.DeleteAttributeSet toDeleteAttributeSet()
    {
        AbstractAttributeSetCommand.SimpleDeleteAttributeSet command = new AbstractAttributeSetCommand.SimpleDeleteAttributeSet();
        ((AbstractAttributeSetCommandDto)this).copyTo(command);
        return command;
    }

}

