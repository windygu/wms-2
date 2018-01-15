package org.dddml.wms.domain.inventorypostingrule;


public class DeleteInventoryPostingRuleDto extends AbstractInventoryPostingRuleCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryPostingRuleCommand.DeleteInventoryPostingRule toDeleteInventoryPostingRule()
    {
        AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule command = new AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule();
        ((AbstractInventoryPostingRuleCommandDto)this).copyTo(command);
        return command;
    }
}

