package org.dddml.wms.domain.shipmentitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentItemStateEventId implements Serializable
{
    private ShipmentItemId shipmentItemId = new ShipmentItemId();

    public ShipmentItemId getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId)
    {
        this.shipmentItemId = shipmentItemId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public String getShipmentItemIdShipmentId()
    {
        return getShipmentItemId().getShipmentId();
    }

    public void setShipmentItemIdShipmentId(String shipmentItemIdShipmentId)
    {
        getShipmentItemId().setShipmentId(shipmentItemIdShipmentId);
    }

    public String getShipmentItemIdShipmentItemSeqId()
    {
        return getShipmentItemId().getShipmentItemSeqId();
    }

    public void setShipmentItemIdShipmentItemSeqId(String shipmentItemIdShipmentItemSeqId)
    {
        getShipmentItemId().setShipmentItemSeqId(shipmentItemIdShipmentItemSeqId);
    }

    public ShipmentItemStateEventId()
    {
    }

    public ShipmentItemStateEventId(ShipmentItemId shipmentItemId, Long version)
    {
        this.shipmentItemId = shipmentItemId;
        this.version = version;
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

        ShipmentItemStateEventId other = (ShipmentItemStateEventId)obj;
        return true 
            && (shipmentItemId == other.shipmentItemId || (shipmentItemId != null && shipmentItemId.equals(other.shipmentItemId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentItemId != null) {
            hash += 13 * this.shipmentItemId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

