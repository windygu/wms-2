package org.dddml.wms.domain.inventoryitemrequiremententrymvo;


public class DeleteInventoryItemRequirementEntryMvoDto extends AbstractInventoryItemRequirementEntryMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryItemRequirementEntryMvoCommand.DeleteInventoryItemRequirementEntryMvo toDeleteInventoryItemRequirementEntryMvo()
    {
        AbstractInventoryItemRequirementEntryMvoCommand.SimpleDeleteInventoryItemRequirementEntryMvo command = new AbstractInventoryItemRequirementEntryMvoCommand.SimpleDeleteInventoryItemRequirementEntryMvo();
        ((AbstractInventoryItemRequirementEntryMvoCommandDto)this).copyTo(command);
        return command;
    }
}

