package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;

public class OrderShipmentStateEventIdDtoWrapper extends OrderShipmentStateEventIdDto
{
	
    private OrderShipmentStateEventId value;

    public OrderShipmentStateEventIdDtoWrapper()
    {
        this(new OrderShipmentStateEventId());
    }

    public OrderShipmentStateEventIdDtoWrapper(OrderShipmentStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderShipmentStateEventId toOrderShipmentStateEventId()
    {
        return this.value;
    }

    @Override
    public OrderShipmentIdDto getOrderShipmentId()
    {
        return new OrderShipmentIdDtoWrapper(this.value.getOrderShipmentId());
    }

    @Override
    public void setOrderShipmentId(OrderShipmentIdDto orderShipmentId)
    {
        this.value.setOrderShipmentId(orderShipmentId.toOrderShipmentId());
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == OrderShipmentStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderShipmentStateEventIdDtoWrapper other = (OrderShipmentStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

