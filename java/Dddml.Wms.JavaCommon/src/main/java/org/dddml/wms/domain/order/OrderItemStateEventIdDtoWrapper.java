package org.dddml.wms.domain.order;

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
    public String getOrderId()
    {
        return this.value.getOrderId();
    }

    @Override
    public void setOrderId(String orderId)
    {
        this.value.setOrderId(orderId);
    }

    @Override
    public String getOrderItemSeqId()
    {
        return this.value.getOrderItemSeqId();
    }

    @Override
    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.value.setOrderItemSeqId(orderItemSeqId);
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

