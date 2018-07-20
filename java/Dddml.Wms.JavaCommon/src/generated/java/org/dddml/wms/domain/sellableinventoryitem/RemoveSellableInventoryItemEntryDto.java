package org.dddml.wms.domain.sellableinventoryitem;


public class RemoveSellableInventoryItemEntryDto extends CreateOrMergePatchSellableInventoryItemEntryDto
{

    public RemoveSellableInventoryItemEntryDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

