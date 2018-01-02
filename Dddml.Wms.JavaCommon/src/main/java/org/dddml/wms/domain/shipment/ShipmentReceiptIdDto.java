package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentReceiptIdDto
{

    public ShipmentReceiptIdDto()
    {
    }

    public ShipmentReceiptId toShipmentReceiptId()
    {
        ShipmentReceiptId v = new ShipmentReceiptId();
        v.setShipmentId(this.getShipmentId());
        v.setReceiptSeqId(this.getReceiptSeqId());
        return v;
    }

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private String receiptSeqId;

    public String getReceiptSeqId()
    {
        return this.receiptSeqId;
    }

    public void setReceiptSeqId(String receiptSeqId)
    {
        this.receiptSeqId = receiptSeqId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentReceiptIdDto.class) {
            return false;
        }

        ShipmentReceiptIdDto other = (ShipmentReceiptIdDto)obj;
        return true 
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getReceiptSeqId() == other.getReceiptSeqId() || (getReceiptSeqId() != null && getReceiptSeqId().equals(other.getReceiptSeqId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentId() != null) {
            hash += 13 * this.getShipmentId().hashCode();
        }
        if (this.getReceiptSeqId() != null) {
            hash += 13 * this.getReceiptSeqId().hashCode();
        }
        return hash;
    }

}

