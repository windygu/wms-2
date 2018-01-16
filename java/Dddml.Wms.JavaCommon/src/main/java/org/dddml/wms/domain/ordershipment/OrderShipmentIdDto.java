package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;

public class OrderShipmentIdDto
{

    public OrderShipmentIdDto()
    {
    }

    public OrderShipmentId toOrderShipmentId()
    {
        OrderShipmentId v = new OrderShipmentId();
        v.setOrderId(this.getOrderId());
        v.setOrderItemSeqId(this.getOrderItemSeqId());
        v.setShipmentId(this.getShipmentId());
        v.setShipmentItemSeqId(this.getShipmentItemSeqId());
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

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrderShipmentIdDto.class) {
            return false;
        }

        OrderShipmentIdDto other = (OrderShipmentIdDto)obj;
        return true 
            && (getOrderId() == other.getOrderId() || (getOrderId() != null && getOrderId().equals(other.getOrderId())))
            && (getOrderItemSeqId() == other.getOrderItemSeqId() || (getOrderItemSeqId() != null && getOrderItemSeqId().equals(other.getOrderItemSeqId())))
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getShipmentItemSeqId() == other.getShipmentItemSeqId() || (getShipmentItemSeqId() != null && getShipmentItemSeqId().equals(other.getShipmentItemSeqId())))
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
        if (this.getShipmentId() != null) {
            hash += 13 * this.getShipmentId().hashCode();
        }
        if (this.getShipmentItemSeqId() != null) {
            hash += 13 * this.getShipmentItemSeqId().hashCode();
        }
        return hash;
    }

}

