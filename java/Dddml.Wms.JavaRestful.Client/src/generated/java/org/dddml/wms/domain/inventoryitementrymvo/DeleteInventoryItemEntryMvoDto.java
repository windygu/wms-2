package org.dddml.wms.domain.inventoryitementrymvo;


public class DeleteInventoryItemEntryMvoDto extends AbstractInventoryItemEntryMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

