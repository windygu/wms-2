package org.dddml.wms.domain.order;


public class RemoveOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation toRemoveOrderItemShipGroupAssociation()
    {
        AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation command = new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
        ((AbstractOrderItemShipGroupAssociationCommandDto)this).copyTo(command);
        return command;
    }
}

