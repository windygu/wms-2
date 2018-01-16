package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;

public class OrderItemMvoStateEventIdDtoWrapper extends OrderItemMvoStateEventIdDto
{
	
    private OrderItemMvoStateEventId value;

    public OrderItemMvoStateEventIdDtoWrapper()
    {
        this(new OrderItemMvoStateEventId());
    }

    public OrderItemMvoStateEventIdDtoWrapper(OrderItemMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderItemMvoStateEventId toOrderItemMvoStateEventId()
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
    public Long getOrderVersion()
    {
        return this.value.getOrderVersion();
    }

    @Override
    public void setOrderVersion(Long orderVersion)
    {
        this.value.setOrderVersion(orderVersion);
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
        if (obj.getClass() == OrderItemMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemMvoStateEventIdDtoWrapper other = (OrderItemMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

