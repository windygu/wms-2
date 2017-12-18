package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemMvoCommandDto extends AbstractCommand
{
    private OrderItemIdDto orderItemId;

    public OrderItemIdDto getOrderItemId()
    {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemIdDto orderItemId)
    {
        this.orderItemId = orderItemId;
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


    public void copyTo(AbstractOrderItemMvoCommand command)
    {
        command.setOrderItemId((this.getOrderItemId() == null) ? null : this.getOrderItemId().toOrderItemId());
        command.setOrderVersion(this.getOrderVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
