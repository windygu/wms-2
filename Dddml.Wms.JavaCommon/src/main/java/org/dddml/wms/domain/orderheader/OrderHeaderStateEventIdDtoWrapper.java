package org.dddml.wms.domain.orderheader;

import org.dddml.wms.domain.*;

public class OrderHeaderStateEventIdDtoWrapper extends OrderHeaderStateEventIdDto
{
	
    private OrderHeaderStateEventId value;

    public OrderHeaderStateEventIdDtoWrapper()
    {
        this(new OrderHeaderStateEventId());
    }

    public OrderHeaderStateEventIdDtoWrapper(OrderHeaderStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderHeaderStateEventId toOrderHeaderStateEventId()
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
        if (obj.getClass() == OrderHeaderStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderHeaderStateEventIdDtoWrapper other = (OrderHeaderStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

