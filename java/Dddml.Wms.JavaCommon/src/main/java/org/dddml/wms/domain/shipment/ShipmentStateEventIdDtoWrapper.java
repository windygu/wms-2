package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentStateEventIdDtoWrapper extends ShipmentStateEventIdDto
{
	
    private ShipmentStateEventId value;

    public ShipmentStateEventIdDtoWrapper()
    {
        this(new ShipmentStateEventId());
    }

    public ShipmentStateEventIdDtoWrapper(ShipmentStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentStateEventId toShipmentStateEventId()
    {
        return this.value;
    }

    @Override
    public String getShipmentId()
    {
        return this.value.getShipmentId();
    }

    @Override
    public void setShipmentId(String shipmentId)
    {
        this.value.setShipmentId(shipmentId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ShipmentStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentStateEventIdDtoWrapper other = (ShipmentStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

