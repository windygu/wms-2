package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentItemIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentId",
            "shipmentItemSeqId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private ShipmentItemIdDto value;

    public ShipmentItemIdFlattenedDto()
    {
        this(new ShipmentItemIdDto());
    }

    public ShipmentItemIdFlattenedDto(ShipmentItemIdDto value)
    {
        this.value = value;
    }

    public ShipmentItemIdDto toShipmentItemIdDto()
    {
        return this.value;
    }

    public ShipmentItemId toShipmentItemId()
    {
        return this.value.toShipmentItemId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentItemIdFlattenedDto other = (ShipmentItemIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

