package org.dddml.wms.domain.orderitem;

import org.dddml.wms.domain.*;

public class OrderItemStateEventIdDtoWrapper extends OrderItemStateEventIdDto
{
	
    private OrderItemStateEventId value;

    public OrderItemStateEventIdDtoWrapper()
    {
        this(new OrderItemStateEventId());
    }

    public OrderItemStateEventIdDtoWrapper(OrderItemStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderItemStateEventId toOrderItemStateEventId()
    {
        return this.value;
    }

    @Override
    public OrderItemIdDto getOrderItemId()
    {
        return new OrderItemIdDtoWrapper(this.value.getOrderItemId());
    }

    @Override
    public void setOrderItemId(OrderItemIdDto orderItemId)
    {
        this.value.setOrderItemId(orderItemId.toOrderItemId());
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
        if (obj.getClass() == OrderItemStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemStateEventIdDtoWrapper other = (OrderItemStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

