package org.dddml.wms.domain;


public class RemoveAttributeSetInstanceExtensionFieldDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public AttributeSetInstanceExtensionFieldCommand.RemoveAttributeSetInstanceExtensionField toRemoveAttributeSetInstanceExtensionField()
    {
        AbstractAttributeSetInstanceExtensionFieldCommand.SimpleRemoveAttributeSetInstanceExtensionField command = new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleRemoveAttributeSetInstanceExtensionField();
        ((AbstractAttributeSetInstanceExtensionFieldCommandDto)this).copyTo(command);
        return command;
    }
}

