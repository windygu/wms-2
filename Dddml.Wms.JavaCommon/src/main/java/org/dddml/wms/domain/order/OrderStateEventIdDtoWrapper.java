package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;

public class OrderStateEventIdDtoWrapper extends OrderStateEventIdDto
{
	
    private OrderStateEventId value;

    public OrderStateEventIdDtoWrapper()
    {
        this(new OrderStateEventId());
    }

    public OrderStateEventIdDtoWrapper(OrderStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderStateEventId toOrderStateEventId()
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
        if (obj.getClass() == OrderStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderStateEventIdDtoWrapper other = (OrderStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

