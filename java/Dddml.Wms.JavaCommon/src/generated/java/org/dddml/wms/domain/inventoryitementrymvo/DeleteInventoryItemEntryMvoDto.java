package org.dddml.wms.domain.inventoryitementrymvo;


public class DeleteInventoryItemEntryMvoDto extends AbstractInventoryItemEntryMvoCommandDto
{

    public DeleteInventoryItemEntryMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryItemEntryMvoCommand.DeleteInventoryItemEntryMvo toDeleteInventoryItemEntryMvo()
    {
        AbstractInventoryItemEntryMvoCommand.SimpleDeleteInventoryItemEntryMvo command = new AbstractInventoryItemEntryMvoCommand.SimpleDeleteInventoryItemEntryMvo();
        ((AbstractInventoryItemEntryMvoCommandDto)this).copyTo(command);
        return command;
    }
}

