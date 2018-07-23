package org.dddml.wms.domain.inventoryitem;


public class DeleteInventoryItemDto extends AbstractInventoryItemCommandDto
{

    public DeleteInventoryItemDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryItemCommand.DeleteInventoryItem toDeleteInventoryItem()
    {
        AbstractInventoryItemCommand.SimpleDeleteInventoryItem command = new AbstractInventoryItemCommand.SimpleDeleteInventoryItem();
        ((AbstractInventoryItemCommandDto)this).copyTo(command);
        return command;
    }
}

