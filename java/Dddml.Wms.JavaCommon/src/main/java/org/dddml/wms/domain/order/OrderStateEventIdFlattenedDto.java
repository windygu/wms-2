package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "orderId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private OrderStateEventIdDto value;

    public OrderStateEventIdFlattenedDto()
    {
        this(new OrderStateEventIdDto());
    }

    public OrderStateEventIdFlattenedDto(OrderStateEventIdDto value)
    {
        this.value = value;
    }

    public OrderStateEventIdDto toOrderStateEventIdDto()
    {
        return this.value;
    }

    public OrderStateEventId toOrderStateEventId()
    {
        return this.value.toOrderStateEventId();
    }

    public String getOrderId()
    {
        return this.value.getOrderId();
    }

    public void setOrderId(String orderId)
    {
        this.value.setOrderId(orderId);
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

        OrderStateEventIdFlattenedDto other = (OrderStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

