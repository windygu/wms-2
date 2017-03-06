package org.dddml.wms.domain.attributeset;


public class RemoveAttributeUseDto extends CreateOrMergePatchAttributeUseDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public AttributeUseCommand.RemoveAttributeUse toRemoveAttributeUse()
    {
        AbstractAttributeUseCommand.SimpleRemoveAttributeUse command = new AbstractAttributeUseCommand.SimpleRemoveAttributeUse();
        ((AbstractAttributeUseCommandDto)this).copyTo(command);
        return command;
    }
}

