package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentReceiptStateEventIdDtoWrapper extends ShipmentReceiptStateEventIdDto
{
	
    private ShipmentReceiptStateEventId value;

    public ShipmentReceiptStateEventIdDtoWrapper()
    {
        this(new ShipmentReceiptStateEventId());
    }

    public ShipmentReceiptStateEventIdDtoWrapper(ShipmentReceiptStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentReceiptStateEventId toShipmentReceiptStateEventId()
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
    public String getReceiptSeqId()
    {
        return this.value.getReceiptSeqId();
    }

    @Override
    public void setReceiptSeqId(String receiptSeqId)
    {
        this.value.setReceiptSeqId(receiptSeqId);
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
        if (obj.getClass() == ShipmentReceiptStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentReceiptStateEventIdDtoWrapper other = (ShipmentReceiptStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

