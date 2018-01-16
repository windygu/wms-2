package org.dddml.wms.domain.shipmentreceiptmvo;

import java.io.Serializable;
import org.dddml.wms.domain.shipment.ShipmentReceiptId;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ShipmentReceiptMvoStateEventId implements Serializable
{
    private ShipmentReceiptId shipmentReceiptId = new ShipmentReceiptId();

    public ShipmentReceiptId getShipmentReceiptId()
    {
        return this.shipmentReceiptId;
    }

    public void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId)
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

    public String getShipmentReceiptIdShipmentId()
    {
        return getShipmentReceiptId().getShipmentId();
    }

    public void setShipmentReceiptIdShipmentId(String shipmentReceiptIdShipmentId)
    {
        getShipmentReceiptId().setShipmentId(shipmentReceiptIdShipmentId);
    }

    public String getShipmentReceiptIdReceiptSeqId()
    {
        return getShipmentReceiptId().getReceiptSeqId();
    }

    public void setShipmentReceiptIdReceiptSeqId(String shipmentReceiptIdReceiptSeqId)
    {
        getShipmentReceiptId().setReceiptSeqId(shipmentReceiptIdReceiptSeqId);
    }

    public ShipmentReceiptMvoStateEventId()
    {
    }

    public ShipmentReceiptMvoStateEventId(ShipmentReceiptId shipmentReceiptId, Long shipmentVersion)
    {
        this.shipmentReceiptId = shipmentReceiptId;
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

        ShipmentReceiptMvoStateEventId other = (ShipmentReceiptMvoStateEventId)obj;
        return true 
            && (shipmentReceiptId == other.shipmentReceiptId || (shipmentReceiptId != null && shipmentReceiptId.equals(other.shipmentReceiptId)))
            && (shipmentVersion == other.shipmentVersion || (shipmentVersion != null && shipmentVersion.equals(other.shipmentVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentReceiptId != null) {
            hash += 13 * this.shipmentReceiptId.hashCode();
        }
        if (this.shipmentVersion != null) {
            hash += 13 * this.shipmentVersion.hashCode();
        }
        return hash;
    }

}

