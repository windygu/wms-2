package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentItemStateEventIdDto
{

    public ShipmentItemStateEventIdDto()
    {
    }

    public ShipmentItemStateEventId toShipmentItemStateEventId()
    {
        ShipmentItemStateEventId v = new ShipmentItemStateEventId();
        v.setShipmentId(this.getShipmentId());
        v.setShipmentItemSeqId(this.getShipmentItemSeqId());
        v.setShipmentVersion(this.getShipmentVersion());
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

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
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
        if (obj == null || obj.getClass() != ShipmentItemStateEventIdDto.class) {
            return false;
        }

        ShipmentItemStateEventIdDto other = (ShipmentItemStateEventIdDto)obj;
        return true 
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getShipmentItemSeqId() == other.getShipmentItemSeqId() || (getShipmentItemSeqId() != null && getShipmentItemSeqId().equals(other.getShipmentItemSeqId())))
            && (getShipmentVersion() == other.getShipmentVersion() || (getShipmentVersion() != null && getShipmentVersion().equals(other.getShipmentVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getShipmentId() != null) {
            hash += 13 * this.getShipmentId().hashCode();
        }
        if (this.getShipmentItemSeqId() != null) {
            hash += 13 * this.getShipmentItemSeqId().hashCode();
        }
        if (this.getShipmentVersion() != null) {
            hash += 13 * this.getShipmentVersion().hashCode();
        }
        return hash;
    }

}

