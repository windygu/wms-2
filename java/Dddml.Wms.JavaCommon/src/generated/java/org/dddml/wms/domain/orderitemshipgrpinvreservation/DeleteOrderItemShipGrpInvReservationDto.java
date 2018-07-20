package org.dddml.wms.domain.orderitemshipgrpinvreservation;


public class DeleteOrderItemShipGrpInvReservationDto extends AbstractOrderItemShipGrpInvReservationCommandDto
{

    public DeleteOrderItemShipGrpInvReservationDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation toDeleteOrderItemShipGrpInvReservation()
    {
        AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation command = new AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation();
        ((AbstractOrderItemShipGrpInvReservationCommandDto)this).copyTo(command);
        return command;
    }
}

