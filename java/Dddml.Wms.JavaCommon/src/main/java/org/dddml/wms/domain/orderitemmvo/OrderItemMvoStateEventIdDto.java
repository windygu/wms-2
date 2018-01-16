package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.OrderItemIdDto;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;

public class OrderItemMvoStateEventIdDto
{

    public OrderItemMvoStateEventIdDto()
    {
    }

    public OrderItemMvoStateEventId toOrderItemMvoStateEventId()
    {
        OrderItemMvoStateEventId v = new OrderItemMvoStateEventId();
        v.setOrderItemId(this.getOrderItemId().toOrderItemId());
        v.setOrderVersion(this.getOrderVersion());
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

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrderItemMvoStateEventIdDto.class) {
            return false;
        }

        OrderItemMvoStateEventIdDto other = (OrderItemMvoStateEventIdDto)obj;
        return true 
            && (getOrderItemId() == other.getOrderItemId() || (getOrderItemId() != null && getOrderItemId().equals(other.getOrderItemId())))
            && (getOrderVersion() == other.getOrderVersion() || (getOrderVersion() != null && getOrderVersion().equals(other.getOrderVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrderItemId() != null) {
            hash += 13 * this.getOrderItemId().hashCode();
        }
        if (this.getOrderVersion() != null) {
            hash += 13 * this.getOrderVersion().hashCode();
        }
        return hash;
    }

}

