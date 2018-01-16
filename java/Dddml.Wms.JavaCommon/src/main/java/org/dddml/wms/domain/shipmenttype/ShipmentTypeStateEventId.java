package org.dddml.wms.domain.shipmenttype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentTypeStateEventId implements Serializable
{
    private String shipmentTypeId;

    public String getShipmentTypeId()
    {
        return this.shipmentTypeId;
    }

    public void setShipmentTypeId(String shipmentTypeId)
    {
        this.shipmentTypeId = shipmentTypeId;
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

    public ShipmentTypeStateEventId()
    {
    }

    public ShipmentTypeStateEventId(String shipmentTypeId, Long version)
    {
        this.shipmentTypeId = shipmentTypeId;
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

        ShipmentTypeStateEventId other = (ShipmentTypeStateEventId)obj;
        return true 
            && (shipmentTypeId == other.shipmentTypeId || (shipmentTypeId != null && shipmentTypeId.equals(other.shipmentTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentTypeId != null) {
            hash += 13 * this.shipmentTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

