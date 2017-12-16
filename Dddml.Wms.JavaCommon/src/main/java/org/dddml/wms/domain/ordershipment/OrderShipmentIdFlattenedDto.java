package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderShipmentIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderId",
            "orderItemSeqId",
            "shipmentId",
            "shipmentItemSeqId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private OrderShipmentIdDto value;

    public OrderShipmentIdFlattenedDto()
    {
        this(new OrderShipmentIdDto());
    }

    public OrderShipmentIdFlattenedDto(OrderShipmentIdDto value)
    {
        this.value = value;
    }

    public OrderShipmentIdDto toOrderShipmentIdDto()
    {
        return this.value;
    }

    public OrderShipmentId toOrderShipmentId()
    {
        return this.value.toOrderShipmentId();
    }

    public String getOrderId()
    {
        return this.value.getOrderId();
    }

    public void setOrderId(String orderId)
    {
        this.value.setOrderId(orderId);
    }

    public String getOrderItemSeqId()
    {
        return this.value.getOrderItemSeqId();
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.value.setOrderItemSeqId(orderItemSeqId);
    }

    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
    }

    public String getShipmentItemSeqId()
    {
        return this.value.getShipmentItemSeqId();
    }

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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderShipmentIdFlattenedDto other = (OrderShipmentIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

