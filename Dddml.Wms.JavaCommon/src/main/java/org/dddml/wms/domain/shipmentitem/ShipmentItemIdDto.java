package org.dddml.wms.domain.shipmentitem;

import org.dddml.wms.domain.*;

public class ShipmentItemIdDto
{

    public ShipmentItemIdDto()
    {
    }

    public ShipmentItemId toShipmentItemId()
    {
        ShipmentItemId v = new ShipmentItemId();
        v.setShipmentId(this.getShipmentId());
        v.setShipmentItemSeqId(this.getShipmentItemSeqId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ShipmentItemIdDto.class) {
            return false;
        }

        ShipmentItemIdDto other = (ShipmentItemIdDto)obj;
        return true 
            && (getShipmentId() == other.getShipmentId() || (getShipmentId() != null && getShipmentId().equals(other.getShipmentId())))
            && (getShipmentItemSeqId() == other.getShipmentItemSeqId() || (getShipmentItemSeqId() != null && getShipmentItemSeqId().equals(other.getShipmentItemSeqId())))
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
        return hash;
    }

}

