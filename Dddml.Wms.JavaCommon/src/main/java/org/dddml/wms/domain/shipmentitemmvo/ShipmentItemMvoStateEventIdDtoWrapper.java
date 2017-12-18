package org.dddml.wms.domain.shipmentitemmvo;

import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentItemMvoStateEventIdDtoWrapper extends ShipmentItemMvoStateEventIdDto
{
	
    private ShipmentItemMvoStateEventId value;

    public ShipmentItemMvoStateEventIdDtoWrapper()
    {
        this(new ShipmentItemMvoStateEventId());
    }

    public ShipmentItemMvoStateEventIdDtoWrapper(ShipmentItemMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentItemMvoStateEventId toShipmentItemMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public ShipmentItemIdDto getShipmentItemId()
    {
        return new ShipmentItemIdDtoWrapper(this.value.getShipmentItemId());
    }

    @Override
    public void setShipmentItemId(ShipmentItemIdDto shipmentItemId)
    {
        this.value.setShipmentItemId(shipmentItemId.toShipmentItemId());
    }

    @Override
    public Long getShipmentVersion()
    {
        return this.value.getShipmentVersion();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ShipmentItemMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentItemMvoStateEventIdDtoWrapper other = (ShipmentItemMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

