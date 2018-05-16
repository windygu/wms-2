package org.dddml.wms.domain.inventorypostingrule;


public class DeleteInventoryPostingRuleDto extends AbstractInventoryPostingRuleCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

