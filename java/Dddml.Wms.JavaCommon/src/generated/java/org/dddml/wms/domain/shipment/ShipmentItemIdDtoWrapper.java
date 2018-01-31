package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentItemIdDtoWrapper extends ShipmentItemIdDto
{
	
    private ShipmentItemId value;

    public ShipmentItemIdDtoWrapper()
    {
        this(new ShipmentItemId());
    }

    public ShipmentItemIdDtoWrapper(ShipmentItemId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentItemId toShipmentItemId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ShipmentItemIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentItemIdDtoWrapper other = (ShipmentItemIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

