package org.dddml.wms.domain.ordershipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipmentCommandDto extends AbstractCommand
{
    private OrderShipmentIdDto orderShipmentId;

    public OrderShipmentIdDto getOrderShipmentId()
    {
        return this.orderShipmentId;
    }

    public void setOrderShipmentId(OrderShipmentIdDto orderShipmentId)
    {
        this.orderShipmentId = orderShipmentId;
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


    public void copyTo(AbstractOrderShipmentCommand command)
    {
        command.setOrderShipmentId((this.getOrderShipmentId() == null) ? null : this.getOrderShipmentId().toOrderShipmentId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
