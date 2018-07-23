package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemShipGrpInvReservationCommandDto extends AbstractCommand
{
    /**
     * Order Item Ship Grp Inv Res Id
     */
    private OrderItemShipGrpInvResId orderItemShipGrpInvResId;

    public OrderItemShipGrpInvResId getOrderItemShipGrpInvResId()
    {
        return this.orderItemShipGrpInvResId;
    }

    public void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId)
    {
        this.orderItemShipGrpInvResId = orderItemShipGrpInvResId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public void copyTo(AbstractOrderItemShipGrpInvReservationCommand command)
    {
        command.setOrderItemShipGrpInvResId(this.getOrderItemShipGrpInvResId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
