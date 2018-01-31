package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderId",
            "orderItemSeqId",
            "orderVersion",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private OrderItemStateEventIdDto value;

    public OrderItemStateEventIdFlattenedDto()
    {
        this(new OrderItemStateEventIdDto());
    }

    public OrderItemStateEventIdFlattenedDto(OrderItemStateEventIdDto value)
    {
        this.value = value;
    }

    public OrderItemStateEventIdDto toOrderItemStateEventIdDto()
    {
        return this.value;
    }

    public OrderItemStateEventId toOrderItemStateEventId()
    {
        return this.value.toOrderItemStateEventId();
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

    public Long getOrderVersion()
    {
        return this.value.getOrderVersion();
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.value.setOrderVersion(orderVersion);
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

        OrderItemStateEventIdFlattenedDto other = (OrderItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

