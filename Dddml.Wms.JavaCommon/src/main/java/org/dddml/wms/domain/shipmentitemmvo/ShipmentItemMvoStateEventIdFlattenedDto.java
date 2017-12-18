package org.dddml.wms.domain.shipmentitemmvo;

import org.dddml.wms.domain.shipment.ShipmentItemIdDto;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentItemMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentItemIdShipmentId",
            "shipmentItemIdShipmentItemSeqId",
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
	
    private ShipmentItemMvoStateEventIdDto value;

    public ShipmentItemMvoStateEventIdFlattenedDto()
    {
        this(new ShipmentItemMvoStateEventIdDto());
    }

    public ShipmentItemMvoStateEventIdFlattenedDto(ShipmentItemMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentItemMvoStateEventIdDto toShipmentItemMvoStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentItemMvoStateEventId toShipmentItemMvoStateEventId()
    {
        return this.value.toShipmentItemMvoStateEventId();
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

        ShipmentItemMvoStateEventIdFlattenedDto other = (ShipmentItemMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

