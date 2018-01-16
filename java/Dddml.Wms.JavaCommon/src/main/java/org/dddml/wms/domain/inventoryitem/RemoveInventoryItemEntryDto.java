package org.dddml.wms.domain.inventoryitem;


public class RemoveInventoryItemEntryDto extends CreateOrMergePatchInventoryItemEntryDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

