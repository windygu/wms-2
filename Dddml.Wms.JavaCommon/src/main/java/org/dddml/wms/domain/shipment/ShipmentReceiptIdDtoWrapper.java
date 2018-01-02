package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentReceiptIdDtoWrapper extends ShipmentReceiptIdDto
{
	
    private ShipmentReceiptId value;

    public ShipmentReceiptIdDtoWrapper()
    {
        this(new ShipmentReceiptId());
    }

    public ShipmentReceiptIdDtoWrapper(ShipmentReceiptId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ShipmentReceiptId toShipmentReceiptId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ShipmentReceiptIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentReceiptIdDtoWrapper other = (ShipmentReceiptIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

