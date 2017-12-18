package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentId",
            "shipmentItemSeqId",
            "shipmentVersion",
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

    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
    }

    public String getShipmentItemSeqId()
    {
        return this.value.getShipmentItemSeqId();
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.value.setShipmentItemSeqId(shipmentItemSeqId);
    }

    public Long getShipmentVersion()
    {
        return this.value.getShipmentVersion();
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.value.setShipmentVersion(shipmentVersion);
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

