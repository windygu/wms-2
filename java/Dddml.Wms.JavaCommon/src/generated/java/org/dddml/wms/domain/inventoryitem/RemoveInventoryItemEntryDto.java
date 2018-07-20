package org.dddml.wms.domain.inventoryitem;


public class RemoveInventoryItemEntryDto extends CreateOrMergePatchInventoryItemEntryDto
{

    public RemoveInventoryItemEntryDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

