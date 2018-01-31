package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;

public class OrderItemIdDtoWrapper extends OrderItemIdDto
{
	
    private OrderItemId value;

    public OrderItemIdDtoWrapper()
    {
        this(new OrderItemId());
    }

    public OrderItemIdDtoWrapper(OrderItemId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderItemId toOrderItemId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == OrderItemIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemIdDtoWrapper other = (OrderItemIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

