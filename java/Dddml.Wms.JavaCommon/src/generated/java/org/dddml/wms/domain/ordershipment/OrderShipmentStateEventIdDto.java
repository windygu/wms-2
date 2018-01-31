package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;

public class OrderShipmentStateEventIdDto
{

    public OrderShipmentStateEventIdDto()
    {
    }

    public OrderShipmentStateEventId toOrderShipmentStateEventId()
    {
        OrderShipmentStateEventId v = new OrderShipmentStateEventId();
        v.setOrderShipmentId(this.getOrderShipmentId().toOrderShipmentId());
        v.setVersion(this.getVersion());
        return v;
    }

    private OrderShipmentIdDto orderShipmentId = new OrderShipmentIdDto();

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrderShipmentStateEventIdDto.class) {
            return false;
        }

        OrderShipmentStateEventIdDto other = (OrderShipmentStateEventIdDto)obj;
        return true 
            && (getOrderShipmentId() == other.getOrderShipmentId() || (getOrderShipmentId() != null && getOrderShipmentId().equals(other.getOrderShipmentId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrderShipmentId() != null) {
            hash += 13 * this.getOrderShipmentId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

