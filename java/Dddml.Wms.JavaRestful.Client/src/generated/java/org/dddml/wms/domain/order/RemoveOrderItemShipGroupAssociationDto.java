package org.dddml.wms.domain.order;


public class RemoveOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
{

    public RemoveOrderItemShipGroupAssociationDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

