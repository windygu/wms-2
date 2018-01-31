package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;

public class OrderShipmentIdDtoWrapper extends OrderShipmentIdDto
{
	
    private OrderShipmentId value;

    public OrderShipmentIdDtoWrapper()
    {
        this(new OrderShipmentId());
    }

    public OrderShipmentIdDtoWrapper(OrderShipmentId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrderShipmentId toOrderShipmentId()
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
    public String getOrderItemSeqId()
    {
        return this.value.getOrderItemSeqId();
    }

    @Override
    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.value.setOrderItemSeqId(orderItemSeqId);
    }

    @Override
    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    @Override
    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
    }

    @Override
    public String getShipmentItemSeqId()
    {
        return this.value.getShipmentItemSeqId();
    }

    @Override
    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.value.setShipmentItemSeqId(shipmentItemSeqId);
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
        if (obj.getClass() == OrderShipmentIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrderShipmentIdDtoWrapper other = (OrderShipmentIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

