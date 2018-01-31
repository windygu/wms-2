package org.dddml.wms.domain.shipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentItemId implements Serializable
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

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    public ShipmentItemId()
    {
    }

    public ShipmentItemId(String shipmentId, String shipmentItemSeqId)
    {
        this.shipmentId = shipmentId;
        this.shipmentItemSeqId = shipmentItemSeqId;
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

        ShipmentItemId other = (ShipmentItemId)obj;
        return true 
            && (shipmentId == other.shipmentId || (shipmentId != null && shipmentId.equals(other.shipmentId)))
            && (shipmentItemSeqId == other.shipmentItemSeqId || (shipmentItemSeqId != null && shipmentItemSeqId.equals(other.shipmentItemSeqId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentId != null) {
            hash += 13 * this.shipmentId.hashCode();
        }
        if (this.shipmentItemSeqId != null) {
            hash += 13 * this.shipmentItemSeqId.hashCode();
        }
        return hash;
    }

}

