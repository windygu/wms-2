package org.dddml.wms.domain.orderitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrderItemStateEventId implements Serializable
{
    private OrderItemId orderItemId = new OrderItemId();

    public OrderItemId getOrderItemId()
    {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId)
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

    public String getOrderItemIdOrderId()
    {
        return getOrderItemId().getOrderId();
    }

    public void setOrderItemIdOrderId(String orderItemIdOrderId)
    {
        getOrderItemId().setOrderId(orderItemIdOrderId);
    }

    public String getOrderItemIdOrderItemSeqId()
    {
        return getOrderItemId().getOrderItemSeqId();
    }

    public void setOrderItemIdOrderItemSeqId(String orderItemIdOrderItemSeqId)
    {
        getOrderItemId().setOrderItemSeqId(orderItemIdOrderItemSeqId);
    }

    public OrderItemStateEventId()
    {
    }

    public OrderItemStateEventId(OrderItemId orderItemId, Long version)
    {
        this.orderItemId = orderItemId;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemStateEventId other = (OrderItemStateEventId)obj;
        return true 
            && (orderItemId == other.orderItemId || (orderItemId != null && orderItemId.equals(other.orderItemId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderItemId != null) {
            hash += 13 * this.orderItemId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

