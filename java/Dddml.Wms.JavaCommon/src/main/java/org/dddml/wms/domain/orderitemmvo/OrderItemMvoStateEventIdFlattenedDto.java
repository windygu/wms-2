package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.OrderItemIdDto;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderItemMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderItemIdOrderId",
            "orderItemIdOrderItemSeqId",
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
	
    private OrderItemMvoStateEventIdDto value;

    public OrderItemMvoStateEventIdFlattenedDto()
    {
        this(new OrderItemMvoStateEventIdDto());
    }

    public OrderItemMvoStateEventIdFlattenedDto(OrderItemMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public OrderItemMvoStateEventIdDto toOrderItemMvoStateEventIdDto()
    {
        return this.value;
    }

    public OrderItemMvoStateEventId toOrderItemMvoStateEventId()
    {
        return this.value.toOrderItemMvoStateEventId();
    }

    public String getOrderItemIdOrderId()
    {
        return this.value.getOrderItemId().getOrderId();
    }

    public void setOrderItemIdOrderId(String orderItemIdOrderId)
    {
        this.value.getOrderItemId().setOrderId(orderItemIdOrderId);
    }

    public String getOrderItemIdOrderItemSeqId()
    {
        return this.value.getOrderItemId().getOrderItemSeqId();
    }

    public void setOrderItemIdOrderItemSeqId(String orderItemIdOrderItemSeqId)
    {
        this.value.getOrderItemId().setOrderItemSeqId(orderItemIdOrderItemSeqId);
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

        OrderItemMvoStateEventIdFlattenedDto other = (OrderItemMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

