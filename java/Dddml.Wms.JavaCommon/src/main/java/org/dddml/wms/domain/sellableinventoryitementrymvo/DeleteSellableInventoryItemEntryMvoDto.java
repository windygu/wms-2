package org.dddml.wms.domain.sellableinventoryitementrymvo;


public class DeleteSellableInventoryItemEntryMvoDto extends AbstractSellableInventoryItemEntryMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public SellableInventoryItemEntryMvoCommand.DeleteSellableInventoryItemEntryMvo toDeleteSellableInventoryItemEntryMvo()
    {
        AbstractSellableInventoryItemEntryMvoCommand.SimpleDeleteSellableInventoryItemEntryMvo command = new AbstractSellableInventoryItemEntryMvoCommand.SimpleDeleteSellableInventoryItemEntryMvo();
        ((AbstractSellableInventoryItemEntryMvoCommandDto)this).copyTo(command);
        return command;
    }
}

