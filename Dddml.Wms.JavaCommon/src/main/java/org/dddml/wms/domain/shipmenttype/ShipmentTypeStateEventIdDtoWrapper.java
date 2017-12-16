package org.dddml.wms.domain.shipmenttype;

import org.dddml.wms.domain.*;

public class ShipmentTypeStateEventIdDtoWrapper extends ShipmentTypeStateEventIdDto
{
	
    private ShipmentTypeStateEventId value;

    public ShipmentTypeStateEventIdDtoWrapper()
    {
        this(new ShipmentTypeStateEventId());
    }

    public ShipmentTypeStateEventIdDtoWrapper(ShipmentTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentTypeStateEventId toShipmentTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getShipmentTypeId()
    {
        return this.value.getShipmentTypeId();
    }

    @Override
    public void setShipmentTypeId(String shipmentTypeId)
    {
        this.value.setShipmentTypeId(shipmentTypeId);
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
        if (obj.getClass() == ShipmentTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentTypeStateEventIdDtoWrapper other = (ShipmentTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

