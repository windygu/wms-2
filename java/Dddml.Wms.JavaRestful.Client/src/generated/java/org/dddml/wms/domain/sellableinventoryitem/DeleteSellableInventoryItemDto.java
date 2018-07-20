package org.dddml.wms.domain.sellableinventoryitem;


public class DeleteSellableInventoryItemDto extends AbstractSellableInventoryItemCommandDto
{

    public DeleteSellableInventoryItemDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

