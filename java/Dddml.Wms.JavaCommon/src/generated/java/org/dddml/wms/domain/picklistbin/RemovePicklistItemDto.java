package org.dddml.wms.domain.picklistbin;


public class RemovePicklistItemDto extends CreateOrMergePatchPicklistItemDto
{

    public RemovePicklistItemDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

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

