package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ShipmentReceiptStateEventIdDto
{

    public ShipmentReceiptStateEventIdDto()
    {
    }

    public ShipmentReceiptStateEventId toShipmentReceiptStateEventId()
    {
        ShipmentReceiptStateEventId v = new ShipmentReceiptStateEventId();
        v.setShipmentId(this.getShipmentId());
        v.setReceiptSeqId(this.getReceiptSeqId());
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

    private String receiptSeqId;

    public String getReceiptSeqId()
    {
        return this.receiptSeqId;
    }

    public void setReceiptSeqId(String receiptSeqId)
    {
        this.receiptSeqId = receiptSeqId;
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
        if (obj == null || obj.getClass() != ShipmentReceiptStateEventIdDto.class) {
            return false;
        }

        ShipmentReceiptStateEventIdDto other = (ShipmentReceiptStateEventIdDto)obj;
        return true 
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getReceiptSeqId() == other.getReceiptSeqId() || (getReceiptSeqId() != null && getReceiptSeqId().equals(other.getReceiptSeqId())))
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
        if (this.getReceiptSeqId() != null) {
            hash += 13 * this.getReceiptSeqId().hashCode();
        }
        if (this.getShipmentVersion() != null) {
            hash += 13 * this.getShipmentVersion().hashCode();
        }
        return hash;
    }

}

