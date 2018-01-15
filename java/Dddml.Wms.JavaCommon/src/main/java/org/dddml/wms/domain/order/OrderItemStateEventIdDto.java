package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;

public class OrderItemStateEventIdDto
{

    public OrderItemStateEventIdDto()
    {
    }

    public OrderItemStateEventId toOrderItemStateEventId()
    {
        OrderItemStateEventId v = new OrderItemStateEventId();
        v.setOrderId(this.getOrderId());
        v.setOrderItemSeqId(this.getOrderItemSeqId());
        v.setOrderVersion(this.getOrderVersion());
        return v;
    }

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
            && (getOrderId() == other.getOrderId() || (getOrderId() != null && getOrderId().equals(other.getOrderId())))
            && (getOrderItemSeqId() == other.getOrderItemSeqId() || (getOrderItemSeqId() != null && getOrderItemSeqId().equals(other.getOrderItemSeqId())))
            && (getOrderVersion() == other.getOrderVersion() || (getOrderVersion() != null && getOrderVersion().equals(other.getOrderVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrderId() != null) {
            hash += 13 * this.getOrderId().hashCode();
        }
        if (this.getOrderItemSeqId() != null) {
            hash += 13 * this.getOrderItemSeqId().hashCode();
        }
        if (this.getOrderVersion() != null) {
            hash += 13 * this.getOrderVersion().hashCode();
        }
        return hash;
    }

}

