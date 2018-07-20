package org.dddml.wms.domain.inventoryitemrequirement;


public class RemoveInventoryItemRequirementEntryDto extends CreateOrMergePatchInventoryItemRequirementEntryDto
{

    public RemoveInventoryItemRequirementEntryDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

