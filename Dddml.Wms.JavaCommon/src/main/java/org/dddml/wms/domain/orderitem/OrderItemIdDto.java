package org.dddml.wms.domain.orderitem;

import org.dddml.wms.domain.*;

public class OrderItemIdDto
{

    public OrderItemIdDto()
    {
    }

    public OrderItemId toOrderItemId()
    {
        OrderItemId v = new OrderItemId();
        v.setOrderId(this.getOrderId());
        v.setOrderItemSeqId(this.getOrderItemSeqId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrderItemIdDto.class) {
            return false;
        }

        OrderItemIdDto other = (OrderItemIdDto)obj;
        return true 
            && (getOrderId() == other.getOrderId() || (getOrderId() != null && getOrderId().equals(other.getOrderId())))
            && (getOrderItemSeqId() == other.getOrderItemSeqId() || (getOrderItemSeqId() != null && getOrderItemSeqId().equals(other.getOrderItemSeqId())))
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
        return hash;
    }

}

