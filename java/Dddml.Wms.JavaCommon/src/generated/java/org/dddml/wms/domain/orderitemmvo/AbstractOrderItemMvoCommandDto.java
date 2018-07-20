package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemMvoCommandDto extends AbstractCommand
{
    /**
     * Order Item Id
     */
    private OrderItemId orderItemId;

    public OrderItemId getOrderItemId()
    {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId)
    {
        this.orderItemId = orderItemId;
    }

    /**
     * Order Version
     */
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
        command.setOrderItemId(this.getOrderItemId());
        command.setOrderVersion(this.getOrderVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
