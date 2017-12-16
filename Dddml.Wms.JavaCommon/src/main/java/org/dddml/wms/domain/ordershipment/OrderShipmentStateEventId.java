package org.dddml.wms.domain.ordershipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrderShipmentStateEventId implements Serializable
{
    private OrderShipmentId orderShipmentId = new OrderShipmentId();

    public OrderShipmentId getOrderShipmentId()
    {
        return this.orderShipmentId;
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId)
    {
        this.orderShipmentId = orderShipmentId;
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

    public String getOrderShipmentIdOrderId()
    {
        return getOrderShipmentId().getOrderId();
    }

    public void setOrderShipmentIdOrderId(String orderShipmentIdOrderId)
    {
        getOrderShipmentId().setOrderId(orderShipmentIdOrderId);
    }

    public String getOrderShipmentIdOrderItemSeqId()
    {
        return getOrderShipmentId().getOrderItemSeqId();
    }

    public void setOrderShipmentIdOrderItemSeqId(String orderShipmentIdOrderItemSeqId)
    {
        getOrderShipmentId().setOrderItemSeqId(orderShipmentIdOrderItemSeqId);
    }

    public String getOrderShipmentIdShipmentId()
    {
        return getOrderShipmentId().getShipmentId();
    }

    public void setOrderShipmentIdShipmentId(String orderShipmentIdShipmentId)
    {
        getOrderShipmentId().setShipmentId(orderShipmentIdShipmentId);
    }

    public String getOrderShipmentIdShipmentItemSeqId()
    {
        return getOrderShipmentId().getShipmentItemSeqId();
    }

    public void setOrderShipmentIdShipmentItemSeqId(String orderShipmentIdShipmentItemSeqId)
    {
        getOrderShipmentId().setShipmentItemSeqId(orderShipmentIdShipmentItemSeqId);
    }

    public OrderShipmentStateEventId()
    {
    }

    public OrderShipmentStateEventId(OrderShipmentId orderShipmentId, Long version)
    {
        this.orderShipmentId = orderShipmentId;
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

        OrderShipmentStateEventId other = (OrderShipmentStateEventId)obj;
        return true 
            && (orderShipmentId == other.orderShipmentId || (orderShipmentId != null && orderShipmentId.equals(other.orderShipmentId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderShipmentId != null) {
            hash += 13 * this.orderShipmentId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

