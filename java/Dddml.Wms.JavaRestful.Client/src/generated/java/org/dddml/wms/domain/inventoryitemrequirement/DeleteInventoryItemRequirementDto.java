package org.dddml.wms.domain.inventoryitemrequirement;


public class DeleteInventoryItemRequirementDto extends AbstractInventoryItemRequirementCommandDto
{

    public DeleteInventoryItemRequirementDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

