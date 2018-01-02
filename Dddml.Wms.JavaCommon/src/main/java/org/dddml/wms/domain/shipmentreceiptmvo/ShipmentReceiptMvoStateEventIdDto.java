package org.dddml.wms.domain.shipmentreceiptmvo;

import org.dddml.wms.domain.shipment.ShipmentReceiptIdDto;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentReceiptMvoStateEventIdDto
{

    public ShipmentReceiptMvoStateEventIdDto()
    {
    }

    public ShipmentReceiptMvoStateEventId toShipmentReceiptMvoStateEventId()
    {
        ShipmentReceiptMvoStateEventId v = new ShipmentReceiptMvoStateEventId();
        v.setShipmentReceiptId(this.getShipmentReceiptId().toShipmentReceiptId());
        v.setShipmentVersion(this.getShipmentVersion());
        return v;
    }

    private ShipmentReceiptIdDto shipmentReceiptId = new ShipmentReceiptIdDto();

    public ShipmentReceiptIdDto getShipmentReceiptId()
    {
        return this.shipmentReceiptId;
    }

    public void setShipmentReceiptId(ShipmentReceiptIdDto shipmentReceiptId)
    {
        this.shipmentReceiptId = shipmentReceiptId;
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
        if (obj == null || obj.getClass() != ShipmentReceiptMvoStateEventIdDto.class) {
            return false;
        }

        ShipmentReceiptMvoStateEventIdDto other = (ShipmentReceiptMvoStateEventIdDto)obj;
        return true 
            && (getShipmentReceiptId() == other.getShipmentReceiptId() || (getShipmentReceiptId() != null && getShipmentReceiptId().equals(other.getShipmentReceiptId())))
            && (getShipmentVersion() == other.getShipmentVersion() || (getShipmentVersion() != null && getShipmentVersion().equals(other.getShipmentVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentReceiptId() != null) {
            hash += 13 * this.getShipmentReceiptId().hashCode();
        }
        if (this.getShipmentVersion() != null) {
            hash += 13 * this.getShipmentVersion().hashCode();
        }
        return hash;
    }

}

