package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;


public class DeleteAttributeSetInstanceExtensionFieldGroupDto extends AbstractAttributeSetInstanceExtensionFieldGroupCommandDto
{

    public DeleteAttributeSetInstanceExtensionFieldGroupDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup toDeleteAttributeSetInstanceExtensionFieldGroup()
    {
        AbstractAttributeSetInstanceExtensionFieldGroupCommand.SimpleDeleteAttributeSetInstanceExtensionFieldGroup command = new AbstractAttributeSetInstanceExtensionFieldGroupCommand.SimpleDeleteAttributeSetInstanceExtensionFieldGroup();
        ((AbstractAttributeSetInstanceExtensionFieldGroupCommandDto)this).copyTo(command);
        return command;
    }
}

