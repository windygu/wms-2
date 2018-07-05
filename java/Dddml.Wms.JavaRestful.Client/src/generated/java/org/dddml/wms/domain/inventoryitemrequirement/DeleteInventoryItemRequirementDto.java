package org.dddml.wms.domain.inventoryitemrequirement;


public class DeleteInventoryItemRequirementDto extends AbstractInventoryItemRequirementCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

