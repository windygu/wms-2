package org.dddml.wms.domain.sellableinventoryitem;


public class RemoveSellableInventoryItemEntryDto extends CreateOrMergePatchSellableInventoryItemEntryDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

