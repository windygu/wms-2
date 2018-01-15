package org.dddml.wms.domain.shipmenttype;

import org.dddml.wms.domain.*;

public class ShipmentTypeStateEventIdDto
{

    public ShipmentTypeStateEventIdDto()
    {
    }

    public ShipmentTypeStateEventId toShipmentTypeStateEventId()
    {
        ShipmentTypeStateEventId v = new ShipmentTypeStateEventId();
        v.setShipmentTypeId(this.getShipmentTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentTypeStateEventIdDto.class) {
            return false;
        }

        ShipmentTypeStateEventIdDto other = (ShipmentTypeStateEventIdDto)obj;
        return true 
            && (getShipmentTypeId() == other.getShipmentTypeId() || (getShipmentTypeId() != null && getShipmentTypeId().equals(other.getShipmentTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentTypeId() != null) {
            hash += 13 * this.getShipmentTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

