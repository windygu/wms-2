package org.dddml.wms.domain.orderitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderItemIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderId",
            "orderItemSeqId",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private OrderItemIdDto value;

    public OrderItemIdFlattenedDto()
    {
        this(new OrderItemIdDto());
    }

    public OrderItemIdFlattenedDto(OrderItemIdDto value)
    {
        this.value = value;
    }

    public OrderItemIdDto toOrderItemIdDto()
    {
        return this.value;
    }

    public OrderItemId toOrderItemId()
    {
        return this.value.toOrderItemId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemIdFlattenedDto other = (OrderItemIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

