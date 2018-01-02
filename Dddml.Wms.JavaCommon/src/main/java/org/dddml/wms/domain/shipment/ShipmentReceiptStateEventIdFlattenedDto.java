package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentReceiptStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentId",
            "receiptSeqId",
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
	
    private ShipmentReceiptStateEventIdDto value;

    public ShipmentReceiptStateEventIdFlattenedDto()
    {
        this(new ShipmentReceiptStateEventIdDto());
    }

    public ShipmentReceiptStateEventIdFlattenedDto(ShipmentReceiptStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentReceiptStateEventIdDto toShipmentReceiptStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentReceiptStateEventId toShipmentReceiptStateEventId()
    {
        return this.value.toShipmentReceiptStateEventId();
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

        ShipmentReceiptStateEventIdFlattenedDto other = (ShipmentReceiptStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

