package org.dddml.wms.domain.shipmentitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentItemIdShipmentId",
            "shipmentItemIdShipmentItemSeqId",
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
	
    private ShipmentItemStateEventIdDto value;

    public ShipmentItemStateEventIdFlattenedDto()
    {
        this(new ShipmentItemStateEventIdDto());
    }

    public ShipmentItemStateEventIdFlattenedDto(ShipmentItemStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentItemStateEventIdDto toShipmentItemStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentItemStateEventId toShipmentItemStateEventId()
    {
        return this.value.toShipmentItemStateEventId();
    }

    public String getShipmentItemIdShipmentId()
    {
        return this.value.getShipmentItemId().getShipmentId();
    }

    public void setShipmentItemIdShipmentId(String shipmentItemIdShipmentId)
    {
        this.value.getShipmentItemId().setShipmentId(shipmentItemIdShipmentId);
    }

    public String getShipmentItemIdShipmentItemSeqId()
    {
        return this.value.getShipmentItemId().getShipmentItemSeqId();
    }

    public void setShipmentItemIdShipmentItemSeqId(String shipmentItemIdShipmentItemSeqId)
    {
        this.value.getShipmentItemId().setShipmentItemSeqId(shipmentItemIdShipmentItemSeqId);
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

        ShipmentItemStateEventIdFlattenedDto other = (ShipmentItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

