package org.dddml.wms.domain.orderitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderItemIdOrderId",
            "orderItemIdOrderItemSeqId",
            "version",
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

        OrderItemStateEventIdFlattenedDto other = (OrderItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

