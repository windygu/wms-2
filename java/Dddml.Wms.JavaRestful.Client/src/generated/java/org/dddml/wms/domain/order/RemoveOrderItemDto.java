package org.dddml.wms.domain.order;


public class RemoveOrderItemDto extends CreateOrMergePatchOrderItemDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

