package org.dddml.wms.domain;


public class RemoveAttributeValueDto extends CreateOrMergePatchAttributeValueDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public AttributeValueCommand.RemoveAttributeValue toRemoveAttributeValue()
    {
        AbstractAttributeValueCommand.SimpleRemoveAttributeValue command = new AbstractAttributeValueCommand.SimpleRemoveAttributeValue();
        ((AbstractAttributeValueCommandDto)this).copyTo(command);
        return command;
    }
}

