package org.dddml.wms.domain.orderitemmvo;

import java.io.Serializable;
import org.dddml.wms.domain.order.OrderItemId;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;

public class OrderItemMvoStateEventId implements Serializable
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

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
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

    public OrderItemMvoStateEventId()
    {
    }

    public OrderItemMvoStateEventId(OrderItemId orderItemId, Long orderVersion)
    {
        this.orderItemId = orderItemId;
        this.orderVersion = orderVersion;
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

        OrderItemMvoStateEventId other = (OrderItemMvoStateEventId)obj;
        return true 
            && (orderItemId == other.orderItemId || (orderItemId != null && orderItemId.equals(other.orderItemId)))
            && (orderVersion == other.orderVersion || (orderVersion != null && orderVersion.equals(other.orderVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderItemId != null) {
            hash += 13 * this.orderItemId.hashCode();
        }
        if (this.orderVersion != null) {
            hash += 13 * this.orderVersion.hashCode();
        }
        return hash;
    }

}

