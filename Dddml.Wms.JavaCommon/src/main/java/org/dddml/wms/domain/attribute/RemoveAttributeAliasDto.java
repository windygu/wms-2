package org.dddml.wms.domain.attribute;


public class RemoveAttributeAliasDto extends CreateOrMergePatchAttributeAliasDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public AttributeAliasCommand.RemoveAttributeAlias toRemoveAttributeAlias()
    {
        AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias command = new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
        ((AbstractAttributeAliasCommandDto)this).copyTo(command);
        return command;
    }
}

