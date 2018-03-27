package org.dddml.wms.domain.picklistbin;


public class RemovePicklistItemDto extends CreateOrMergePatchPicklistItemDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public PicklistItemCommand.RemovePicklistItem toRemovePicklistItem()
    {
        AbstractPicklistItemCommand.SimpleRemovePicklistItem command = new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
        ((AbstractPicklistItemCommandDto)this).copyTo(command);
        return command;
    }
}

