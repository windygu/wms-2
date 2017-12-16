package org.dddml.wms.domain.shipmenttype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentTypeId",
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
	
    private ShipmentTypeStateEventIdDto value;

    public ShipmentTypeStateEventIdFlattenedDto()
    {
        this(new ShipmentTypeStateEventIdDto());
    }

    public ShipmentTypeStateEventIdFlattenedDto(ShipmentTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentTypeStateEventIdDto toShipmentTypeStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentTypeStateEventId toShipmentTypeStateEventId()
    {
        return this.value.toShipmentTypeStateEventId();
    }

    public String getShipmentTypeId()
    {
        return this.value.getShipmentTypeId();
    }

    public void setShipmentTypeId(String shipmentTypeId)
    {
        this.value.setShipmentTypeId(shipmentTypeId);
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

        ShipmentTypeStateEventIdFlattenedDto other = (ShipmentTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

