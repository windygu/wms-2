package org.dddml.wms.domain.order;


public class RemoveOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
{

    public RemoveOrderShipGroupDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

