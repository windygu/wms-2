package org.dddml.wms.domain.inventorypostingrule;


public class DeleteInventoryPostingRuleDto extends AbstractInventoryPostingRuleCommandDto
{

    public DeleteInventoryPostingRuleDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

