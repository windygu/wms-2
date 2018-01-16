package org.dddml.wms.domain.shipmentreceiptmvo;

import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentReceiptMvoStateEventIdDtoWrapper extends ShipmentReceiptMvoStateEventIdDto
{
	
    private ShipmentReceiptMvoStateEventId value;

    public ShipmentReceiptMvoStateEventIdDtoWrapper()
    {
        this(new ShipmentReceiptMvoStateEventId());
    }

    public ShipmentReceiptMvoStateEventIdDtoWrapper(ShipmentReceiptMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentReceiptMvoStateEventId toShipmentReceiptMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public ShipmentReceiptIdDto getShipmentReceiptId()
    {
        return new ShipmentReceiptIdDtoWrapper(this.value.getShipmentReceiptId());
    }

    @Override
    public void setShipmentReceiptId(ShipmentReceiptIdDto shipmentReceiptId)
    {
        this.value.setShipmentReceiptId(shipmentReceiptId.toShipmentReceiptId());
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
        if (obj.getClass() == ShipmentReceiptMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentReceiptMvoStateEventIdDtoWrapper other = (ShipmentReceiptMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

