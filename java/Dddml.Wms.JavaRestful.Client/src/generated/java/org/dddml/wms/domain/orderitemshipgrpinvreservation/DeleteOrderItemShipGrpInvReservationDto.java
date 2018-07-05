package org.dddml.wms.domain.orderitemshipgrpinvreservation;


public class DeleteOrderItemShipGrpInvReservationDto extends AbstractOrderItemShipGrpInvReservationCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

