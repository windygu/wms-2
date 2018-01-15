package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentReceiptIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentId",
            "receiptSeqId",
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
	
    private ShipmentReceiptIdDto value;

    public ShipmentReceiptIdFlattenedDto()
    {
        this(new ShipmentReceiptIdDto());
    }

    public ShipmentReceiptIdFlattenedDto(ShipmentReceiptIdDto value)
    {
        this.value = value;
    }

    public ShipmentReceiptIdDto toShipmentReceiptIdDto()
    {
        return this.value;
    }

    public ShipmentReceiptId toShipmentReceiptId()
    {
        return this.value.toShipmentReceiptId();
    }

    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
    }

    public String getReceiptSeqId()
    {
        return this.value.getReceiptSeqId();
    }

    public void setReceiptSeqId(String receiptSeqId)
    {
        this.value.setReceiptSeqId(receiptSeqId);
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

        ShipmentReceiptIdFlattenedDto other = (ShipmentReceiptIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

