package org.dddml.wms.domain.shipmentitem;

import org.dddml.wms.domain.*;

public class ShipmentItemStateEventIdDtoWrapper extends ShipmentItemStateEventIdDto
{
	
    private ShipmentItemStateEventId value;

    public ShipmentItemStateEventIdDtoWrapper()
    {
        this(new ShipmentItemStateEventId());
    }

    public ShipmentItemStateEventIdDtoWrapper(ShipmentItemStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentItemStateEventId toShipmentItemStateEventId()
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
        if (obj.getClass() == ShipmentItemStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentItemStateEventIdDtoWrapper other = (ShipmentItemStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

