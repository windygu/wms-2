package org.dddml.wms.domain.attribute;


public class RemoveAttributeValueDto extends CreateOrMergePatchAttributeValueDto
{

    public RemoveAttributeValueDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

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

