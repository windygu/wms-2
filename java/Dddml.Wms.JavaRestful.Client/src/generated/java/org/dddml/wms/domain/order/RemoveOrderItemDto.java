package org.dddml.wms.domain.order;


public class RemoveOrderItemDto extends CreateOrMergePatchOrderItemDto
{

    public RemoveOrderItemDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

