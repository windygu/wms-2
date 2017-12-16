package org.dddml.wms.domain.shipmentitem;

import org.dddml.wms.domain.*;

public class ShipmentItemStateEventIdDto
{

    public ShipmentItemStateEventIdDto()
    {
    }

    public ShipmentItemStateEventId toShipmentItemStateEventId()
    {
        ShipmentItemStateEventId v = new ShipmentItemStateEventId();
        v.setShipmentItemId(this.getShipmentItemId().toShipmentItemId());
        v.setVersion(this.getVersion());
        return v;
    }

    private ShipmentItemIdDto shipmentItemId = new ShipmentItemIdDto();

    public ShipmentItemIdDto getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemIdDto shipmentItemId)
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentItemStateEventIdDto.class) {
            return false;
        }

        ShipmentItemStateEventIdDto other = (ShipmentItemStateEventIdDto)obj;
        return true 
            && (getShipmentItemId() == other.getShipmentItemId() || (getShipmentItemId() != null && getShipmentItemId().equals(other.getShipmentItemId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentItemId() != null) {
            hash += 13 * this.getShipmentItemId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

