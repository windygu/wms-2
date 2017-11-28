package org.dddml.wms.domain.inventoryitemeventtype;


public class DeleteInventoryItemEventTypeDto extends AbstractInventoryItemEventTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryItemEventTypeCommand.DeleteInventoryItemEventType toDeleteInventoryItemEventType()
    {
        AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType command = new AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType();
        ((AbstractInventoryItemEventTypeCommandDto)this).copyTo(command);
        return command;
    }
}

