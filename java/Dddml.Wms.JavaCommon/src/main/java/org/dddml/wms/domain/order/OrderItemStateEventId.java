package org.dddml.wms.domain.order;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrderItemStateEventId implements Serializable
{
    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
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

    public OrderItemStateEventId()
    {
    }

    public OrderItemStateEventId(String orderId, String orderItemSeqId, Long orderVersion)
    {
        this.orderId = orderId;
        this.orderItemSeqId = orderItemSeqId;
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

        OrderItemStateEventId other = (OrderItemStateEventId)obj;
        return true 
            && (orderId == other.orderId || (orderId != null && orderId.equals(other.orderId)))
            && (orderItemSeqId == other.orderItemSeqId || (orderItemSeqId != null && orderItemSeqId.equals(other.orderItemSeqId)))
            && (orderVersion == other.orderVersion || (orderVersion != null && orderVersion.equals(other.orderVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderId != null) {
            hash += 13 * this.orderId.hashCode();
        }
        if (this.orderItemSeqId != null) {
            hash += 13 * this.orderItemSeqId.hashCode();
        }
        if (this.orderVersion != null) {
            hash += 13 * this.orderVersion.hashCode();
        }
        return hash;
    }

}

