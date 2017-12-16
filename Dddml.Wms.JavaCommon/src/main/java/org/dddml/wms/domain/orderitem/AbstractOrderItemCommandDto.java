package org.dddml.wms.domain.orderitem;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemCommandDto extends AbstractCommand
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public void copyTo(AbstractOrderItemCommand command)
    {
        command.setOrderItemId((this.getOrderItemId() == null) ? null : this.getOrderItemId().toOrderItemId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
