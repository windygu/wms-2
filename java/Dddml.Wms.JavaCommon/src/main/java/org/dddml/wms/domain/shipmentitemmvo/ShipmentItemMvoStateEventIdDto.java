package org.dddml.wms.domain.shipmentitemmvo;

import org.dddml.wms.domain.shipment.ShipmentItemIdDto;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentItemMvoStateEventIdDto
{

    public ShipmentItemMvoStateEventIdDto()
    {
    }

    public ShipmentItemMvoStateEventId toShipmentItemMvoStateEventId()
    {
        ShipmentItemMvoStateEventId v = new ShipmentItemMvoStateEventId();
        v.setShipmentItemId(this.getShipmentItemId().toShipmentItemId());
        v.setShipmentVersion(this.getShipmentVersion());
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

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentItemMvoStateEventIdDto.class) {
            return false;
        }

        ShipmentItemMvoStateEventIdDto other = (ShipmentItemMvoStateEventIdDto)obj;
        return true 
            && (getShipmentItemId() == other.getShipmentItemId() || (getShipmentItemId() != null && getShipmentItemId().equals(other.getShipmentItemId())))
            && (getShipmentVersion() == other.getShipmentVersion() || (getShipmentVersion() != null && getShipmentVersion().equals(other.getShipmentVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentItemId() != null) {
            hash += 13 * this.getShipmentItemId().hashCode();
        }
        if (this.getShipmentVersion() != null) {
            hash += 13 * this.getShipmentVersion().hashCode();
        }
        return hash;
    }

}

