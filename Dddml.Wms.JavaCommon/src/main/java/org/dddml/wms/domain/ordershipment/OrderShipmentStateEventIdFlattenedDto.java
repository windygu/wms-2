package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderShipmentStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderShipmentIdOrderId",
            "orderShipmentIdOrderItemSeqId",
            "orderShipmentIdShipmentId",
            "orderShipmentIdShipmentItemSeqId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "String",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private OrderShipmentStateEventIdDto value;

    public OrderShipmentStateEventIdFlattenedDto()
    {
        this(new OrderShipmentStateEventIdDto());
    }

    public OrderShipmentStateEventIdFlattenedDto(OrderShipmentStateEventIdDto value)
    {
        this.value = value;
    }

    public OrderShipmentStateEventIdDto toOrderShipmentStateEventIdDto()
    {
        return this.value;
    }

    public OrderShipmentStateEventId toOrderShipmentStateEventId()
    {
        return this.value.toOrderShipmentStateEventId();
    }

    public String getOrderShipmentIdOrderId()
    {
        return this.value.getOrderShipmentId().getOrderId();
    }

    public void setOrderShipmentIdOrderId(String orderShipmentIdOrderId)
    {
        this.value.getOrderShipmentId().setOrderId(orderShipmentIdOrderId);
    }

    public String getOrderShipmentIdOrderItemSeqId()
    {
        return this.value.getOrderShipmentId().getOrderItemSeqId();
    }

    public void setOrderShipmentIdOrderItemSeqId(String orderShipmentIdOrderItemSeqId)
    {
        this.value.getOrderShipmentId().setOrderItemSeqId(orderShipmentIdOrderItemSeqId);
    }

    public String getOrderShipmentIdShipmentId()
    {
        return this.value.getOrderShipmentId().getShipmentId();
    }

    public void setOrderShipmentIdShipmentId(String orderShipmentIdShipmentId)
    {
        this.value.getOrderShipmentId().setShipmentId(orderShipmentIdShipmentId);
    }

    public String getOrderShipmentIdShipmentItemSeqId()
    {
        return this.value.getOrderShipmentId().getShipmentItemSeqId();
    }

    public void setOrderShipmentIdShipmentItemSeqId(String orderShipmentIdShipmentItemSeqId)
    {
        this.value.getOrderShipmentId().setShipmentItemSeqId(orderShipmentIdShipmentItemSeqId);
    }

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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

        OrderShipmentStateEventIdFlattenedDto other = (OrderShipmentStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

