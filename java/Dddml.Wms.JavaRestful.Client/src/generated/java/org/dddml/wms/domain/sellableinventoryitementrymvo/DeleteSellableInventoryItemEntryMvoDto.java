package org.dddml.wms.domain.sellableinventoryitementrymvo;


public class DeleteSellableInventoryItemEntryMvoDto extends AbstractSellableInventoryItemEntryMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

