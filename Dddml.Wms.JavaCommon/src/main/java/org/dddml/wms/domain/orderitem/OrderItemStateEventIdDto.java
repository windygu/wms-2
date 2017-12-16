package org.dddml.wms.domain.orderitem;

import org.dddml.wms.domain.*;

public class OrderItemStateEventIdDto
{

    public OrderItemStateEventIdDto()
    {
    }

    public OrderItemStateEventId toOrderItemStateEventId()
    {
        OrderItemStateEventId v = new OrderItemStateEventId();
        v.setOrderItemId(this.getOrderItemId().toOrderItemId());
        v.setVersion(this.getVersion());
        return v;
    }

    private OrderItemIdDto orderItemId = new OrderItemIdDto();

    public OrderItemIdDto getOrderItemId()
    {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemIdDto orderItemId)
    {
        this.orderItemId = orderItemId;
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
        if (obj == null || obj.getClass() != OrderItemStateEventIdDto.class) {
            return false;
        }

        OrderItemStateEventIdDto other = (OrderItemStateEventIdDto)obj;
        return true 
            && (getOrderItemId() == other.getOrderItemId() || (getOrderItemId() != null && getOrderItemId().equals(other.getOrderItemId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrderItemId() != null) {
            hash += 13 * this.getOrderItemId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

