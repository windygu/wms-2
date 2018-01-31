package org.dddml.wms.domain.shipmentreceiptmvo;

import org.dddml.wms.domain.shipment.ShipmentReceiptIdDto;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ShipmentReceiptMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "shipmentReceiptIdShipmentId",
            "shipmentReceiptIdReceiptSeqId",
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
	
    private ShipmentReceiptMvoStateEventIdDto value;

    public ShipmentReceiptMvoStateEventIdFlattenedDto()
    {
        this(new ShipmentReceiptMvoStateEventIdDto());
    }

    public ShipmentReceiptMvoStateEventIdFlattenedDto(ShipmentReceiptMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public ShipmentReceiptMvoStateEventIdDto toShipmentReceiptMvoStateEventIdDto()
    {
        return this.value;
    }

    public ShipmentReceiptMvoStateEventId toShipmentReceiptMvoStateEventId()
    {
        return this.value.toShipmentReceiptMvoStateEventId();
    }

    public String getShipmentReceiptIdShipmentId()
    {
        return this.value.getShipmentReceiptId().getShipmentId();
    }

    public void setShipmentReceiptIdShipmentId(String shipmentReceiptIdShipmentId)
    {
        this.value.getShipmentReceiptId().setShipmentId(shipmentReceiptIdShipmentId);
    }

    public String getShipmentReceiptIdReceiptSeqId()
    {
        return this.value.getShipmentReceiptId().getReceiptSeqId();
    }

    public void setShipmentReceiptIdReceiptSeqId(String shipmentReceiptIdReceiptSeqId)
    {
        this.value.getShipmentReceiptId().setReceiptSeqId(shipmentReceiptIdReceiptSeqId);
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

        ShipmentReceiptMvoStateEventIdFlattenedDto other = (ShipmentReceiptMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

