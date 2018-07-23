package org.dddml.wms.domain.ordershipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipmentCommandDto extends AbstractCommand
{
    /**
     * Order Shipment Id
     */
    private OrderShipmentId orderShipmentId;

    public OrderShipmentId getOrderShipmentId()
    {
        return this.orderShipmentId;
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId)
    {
        this.orderShipmentId = orderShipmentId;
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


}
