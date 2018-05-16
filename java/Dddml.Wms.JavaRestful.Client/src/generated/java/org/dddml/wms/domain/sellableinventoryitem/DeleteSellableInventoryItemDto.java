package org.dddml.wms.domain.sellableinventoryitem;


public class DeleteSellableInventoryItemDto extends AbstractSellableInventoryItemCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

