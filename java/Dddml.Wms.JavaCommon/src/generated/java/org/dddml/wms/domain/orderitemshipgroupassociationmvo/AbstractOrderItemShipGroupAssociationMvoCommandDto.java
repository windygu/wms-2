package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemShipGroupAssociationMvoCommandDto extends AbstractCommand
{
    private OrderItemShipGroupAssociationId orderItemShipGroupAssociationId;

    public OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId()
    {
        return this.orderItemShipGroupAssociationId;
    }

    public void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId)
    {
        this.orderItemShipGroupAssociationId = orderItemShipGroupAssociationId;
    }

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }


    public void copyTo(AbstractOrderItemShipGroupAssociationMvoCommand command)
    {
        command.setOrderItemShipGroupAssociationId(this.getOrderItemShipGroupAssociationId());
        command.setOrderVersion(this.getOrderVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
