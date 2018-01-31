package org.dddml.wms.domain.ordershipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrderShipmentId implements Serializable
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

    public OrderShipmentId()
    {
    }

    public OrderShipmentId(String orderId, String orderItemSeqId, String shipmentId, String shipmentItemSeqId)
    {
        this.orderId = orderId;
        this.orderItemSeqId = orderItemSeqId;
        this.shipmentId = shipmentId;
        this.shipmentItemSeqId = shipmentItemSeqId;
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

        OrderShipmentId other = (OrderShipmentId)obj;
        return true 
            && (orderId == other.orderId || (orderId != null && orderId.equals(other.orderId)))
            && (orderItemSeqId == other.orderItemSeqId || (orderItemSeqId != null && orderItemSeqId.equals(other.orderItemSeqId)))
            && (shipmentId == other.shipmentId || (shipmentId != null && shipmentId.equals(other.shipmentId)))
            && (shipmentItemSeqId == other.shipmentItemSeqId || (shipmentItemSeqId != null && shipmentItemSeqId.equals(other.shipmentItemSeqId)))
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
        if (this.shipmentId != null) {
            hash += 13 * this.shipmentId.hashCode();
        }
        if (this.shipmentItemSeqId != null) {
            hash += 13 * this.shipmentItemSeqId.hashCode();
        }
        return hash;
    }

}

