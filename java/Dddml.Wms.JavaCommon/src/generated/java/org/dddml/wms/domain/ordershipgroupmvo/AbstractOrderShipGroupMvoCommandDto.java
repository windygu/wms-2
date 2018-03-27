package org.dddml.wms.domain.ordershipgroupmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipGroupMvoCommandDto extends AbstractCommand
{
    private OrderShipGroupId orderShipGroupId;

    public OrderShipGroupId getOrderShipGroupId()
    {
        return this.orderShipGroupId;
    }

    public void setOrderShipGroupId(OrderShipGroupId orderShipGroupId)
    {
        this.orderShipGroupId = orderShipGroupId;
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


    public void copyTo(AbstractOrderShipGroupMvoCommand command)
    {
        command.setOrderShipGroupId(this.getOrderShipGroupId());
        command.setOrderVersion(this.getOrderVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
