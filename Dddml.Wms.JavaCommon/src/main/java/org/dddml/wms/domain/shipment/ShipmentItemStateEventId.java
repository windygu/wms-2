package org.dddml.wms.domain.shipment;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentItemStateEventId implements Serializable
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

    public ShipmentItemStateEventId()
    {
    }

    public ShipmentItemStateEventId(String shipmentId, String shipmentItemSeqId, Long shipmentVersion)
    {
        this.shipmentId = shipmentId;
        this.shipmentItemSeqId = shipmentItemSeqId;
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

        ShipmentItemStateEventId other = (ShipmentItemStateEventId)obj;
        return true 
            && (shipmentId == other.shipmentId || (shipmentId != null && shipmentId.equals(other.shipmentId)))
            && (shipmentItemSeqId == other.shipmentItemSeqId || (shipmentItemSeqId != null && shipmentItemSeqId.equals(other.shipmentItemSeqId)))
            && (shipmentVersion == other.shipmentVersion || (shipmentVersion != null && shipmentVersion.equals(other.shipmentVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentId != null) {
            hash += 13 * this.shipmentId.hashCode();
        }
        if (this.shipmentItemSeqId != null) {
            hash += 13 * this.shipmentItemSeqId.hashCode();
        }
        if (this.shipmentVersion != null) {
            hash += 13 * this.shipmentVersion.hashCode();
        }
        return hash;
    }

}

