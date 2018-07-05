package org.dddml.wms.domain.inventoryitem;


public class DeleteInventoryItemDto extends AbstractInventoryItemCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

