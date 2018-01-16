package org.dddml.wms.domain.shipmentitemmvo;

import java.io.Serializable;
import org.dddml.wms.domain.shipment.ShipmentItemId;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentItemMvoStateEventId implements Serializable
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

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
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

    public ShipmentItemMvoStateEventId()
    {
    }

    public ShipmentItemMvoStateEventId(ShipmentItemId shipmentItemId, Long shipmentVersion)
    {
        this.shipmentItemId = shipmentItemId;
        this.shipmentVersion = shipmentVersion;
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

        ShipmentItemMvoStateEventId other = (ShipmentItemMvoStateEventId)obj;
        return true 
            && (shipmentItemId == other.shipmentItemId || (shipmentItemId != null && shipmentItemId.equals(other.shipmentItemId)))
            && (shipmentVersion == other.shipmentVersion || (shipmentVersion != null && shipmentVersion.equals(other.shipmentVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentItemId != null) {
            hash += 13 * this.shipmentItemId.hashCode();
        }
        if (this.shipmentVersion != null) {
            hash += 13 * this.shipmentVersion.hashCode();
        }
        return hash;
    }

}

