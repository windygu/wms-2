package org.dddml.wms.domain.inventoryitemrequirement;


public class RemoveInventoryItemRequirementEntryDto extends CreateOrMergePatchInventoryItemRequirementEntryDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

