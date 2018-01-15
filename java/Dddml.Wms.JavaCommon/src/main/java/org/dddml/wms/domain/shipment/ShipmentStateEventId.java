package org.dddml.wms.domain.shipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentStateEventId implements Serializable
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public ShipmentStateEventId()
    {
    }

    public ShipmentStateEventId(String shipmentId, Long version)
    {
        this.shipmentId = shipmentId;
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

        ShipmentStateEventId other = (ShipmentStateEventId)obj;
        return true 
            && (shipmentId == other.shipmentId || (shipmentId != null && shipmentId.equals(other.shipmentId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentId != null) {
            hash += 13 * this.shipmentId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

