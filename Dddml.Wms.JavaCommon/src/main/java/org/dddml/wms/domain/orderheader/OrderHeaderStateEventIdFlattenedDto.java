package org.dddml.wms.domain.orderheader;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrderHeaderStateEventIdFlattenedDto
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
	
    private OrderHeaderStateEventIdDto value;

    public OrderHeaderStateEventIdFlattenedDto()
    {
        this(new OrderHeaderStateEventIdDto());
    }

    public OrderHeaderStateEventIdFlattenedDto(OrderHeaderStateEventIdDto value)
    {
        this.value = value;
    }

    public OrderHeaderStateEventIdDto toOrderHeaderStateEventIdDto()
    {
        return this.value;
    }

    public OrderHeaderStateEventId toOrderHeaderStateEventId()
    {
        return this.value.toOrderHeaderStateEventId();
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

        OrderHeaderStateEventIdFlattenedDto other = (OrderHeaderStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

