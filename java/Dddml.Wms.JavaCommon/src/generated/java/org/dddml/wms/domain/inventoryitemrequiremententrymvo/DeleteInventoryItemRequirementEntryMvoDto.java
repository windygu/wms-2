package org.dddml.wms.domain.inventoryitemrequiremententrymvo;


public class DeleteInventoryItemRequirementEntryMvoDto extends AbstractInventoryItemRequirementEntryMvoCommandDto
{

    public DeleteInventoryItemRequirementEntryMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

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

