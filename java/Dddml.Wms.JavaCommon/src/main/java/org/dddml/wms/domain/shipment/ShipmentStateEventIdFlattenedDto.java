package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentId",
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
	
    private ShipmentStateEventIdDto value;

    public ShipmentStateEventIdFlattenedDto()
    {
        this(new ShipmentStateEventIdDto());
    }

    public ShipmentStateEventIdFlattenedDto(ShipmentStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentStateEventIdDto toShipmentStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentStateEventId toShipmentStateEventId()
    {
        return this.value.toShipmentStateEventId();
    }

    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
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

        ShipmentStateEventIdFlattenedDto other = (ShipmentStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

