package org.dddml.wms.domain;


public class DeleteAttributeSetInstanceExtensionFieldMvoDto extends AbstractAttributeSetInstanceExtensionFieldMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeSetInstanceExtensionFieldMvoCommand.DeleteAttributeSetInstanceExtensionFieldMvo toDeleteAttributeSetInstanceExtensionFieldMvo()
    {
        AbstractAttributeSetInstanceExtensionFieldMvoCommand.SimpleDeleteAttributeSetInstanceExtensionFieldMvo command = new AbstractAttributeSetInstanceExtensionFieldMvoCommand.SimpleDeleteAttributeSetInstanceExtensionFieldMvo();
        ((AbstractAttributeSetInstanceExtensionFieldMvoCommandDto)this).copyTo(command);
        return command;
    }

}

