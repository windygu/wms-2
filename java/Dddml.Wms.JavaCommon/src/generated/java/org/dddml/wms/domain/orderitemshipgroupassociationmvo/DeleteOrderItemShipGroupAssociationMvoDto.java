package org.dddml.wms.domain.orderitemshipgroupassociationmvo;


public class DeleteOrderItemShipGroupAssociationMvoDto extends AbstractOrderItemShipGroupAssociationMvoCommandDto
{

    public DeleteOrderItemShipGroupAssociationMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo toDeleteOrderItemShipGroupAssociationMvo()
    {
        AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo command = new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo();
        ((AbstractOrderItemShipGroupAssociationMvoCommandDto)this).copyTo(command);
        return command;
    }
}

