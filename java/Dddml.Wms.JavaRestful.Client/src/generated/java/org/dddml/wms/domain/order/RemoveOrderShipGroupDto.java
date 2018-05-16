package org.dddml.wms.domain.order;


public class RemoveOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

