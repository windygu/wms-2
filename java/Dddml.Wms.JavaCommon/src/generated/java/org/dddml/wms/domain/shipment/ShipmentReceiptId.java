package org.dddml.wms.domain.shipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentReceiptId implements Serializable
{
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

    public ShipmentReceiptId()
    {
    }

    public ShipmentReceiptId(String shipmentId, String receiptSeqId)
    {
        this.shipmentId = shipmentId;
        this.receiptSeqId = receiptSeqId;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ShipmentReceiptId other = (ShipmentReceiptId)obj;
        return true 
            && (shipmentId == other.shipmentId || (shipmentId != null && shipmentId.equals(other.shipmentId)))
            && (receiptSeqId == other.receiptSeqId || (receiptSeqId != null && receiptSeqId.equals(other.receiptSeqId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentId != null) {
            hash += 13 * this.shipmentId.hashCode();
        }
        if (this.receiptSeqId != null) {
            hash += 13 * this.receiptSeqId.hashCode();
        }
        return hash;
    }

}

