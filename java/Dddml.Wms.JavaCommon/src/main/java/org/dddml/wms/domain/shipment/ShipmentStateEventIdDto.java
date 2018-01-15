package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentStateEventIdDto
{

    public ShipmentStateEventIdDto()
    {
    }

    public ShipmentStateEventId toShipmentStateEventId()
    {
        ShipmentStateEventId v = new ShipmentStateEventId();
        v.setShipmentId(this.getShipmentId());
        v.setVersion(this.getVersion());
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentStateEventIdDto.class) {
            return false;
        }

        ShipmentStateEventIdDto other = (ShipmentStateEventIdDto)obj;
        return true 
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentId() != null) {
            hash += 13 * this.getShipmentId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

