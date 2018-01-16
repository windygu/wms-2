package org.dddml.wms.domain.shipment;

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
    public String getShipmentItemSeqId()
    {
        return this.value.getShipmentItemSeqId();
    }

    @Override
    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.value.setShipmentItemSeqId(shipmentItemSeqId);
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

