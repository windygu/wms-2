package org.dddml.wms.domain.physicalinventorylinemvo;

import java.io.Serializable;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineId;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineMvoStateEventId implements Serializable
{
    private PhysicalInventoryLineId physicalInventoryLineId = new PhysicalInventoryLineId();

    public PhysicalInventoryLineId getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }

    public String getPhysicalInventoryLineIdPhysicalInventoryDocumentNumber()
    {
        return getPhysicalInventoryLineId().getPhysicalInventoryDocumentNumber();
    }

    public void setPhysicalInventoryLineIdPhysicalInventoryDocumentNumber(String physicalInventoryLineIdPhysicalInventoryDocumentNumber)
    {
        getPhysicalInventoryLineId().setPhysicalInventoryDocumentNumber(physicalInventoryLineIdPhysicalInventoryDocumentNumber);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdProductId()
    {
        return getPhysicalInventoryLineId().getInventoryItemId().getProductId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdProductId(String physicalInventoryLineIdInventoryItemIdProductId)
    {
        getPhysicalInventoryLineId().getInventoryItemId().setProductId(physicalInventoryLineIdInventoryItemIdProductId);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdLocatorId()
    {
        return getPhysicalInventoryLineId().getInventoryItemId().getLocatorId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdLocatorId(String physicalInventoryLineIdInventoryItemIdLocatorId)
    {
        getPhysicalInventoryLineId().getInventoryItemId().setLocatorId(physicalInventoryLineIdInventoryItemIdLocatorId);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdAttributeSetInstanceId()
    {
        return getPhysicalInventoryLineId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdAttributeSetInstanceId(String physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId)
    {
        getPhysicalInventoryLineId().getInventoryItemId().setAttributeSetInstanceId(physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId);
    }

    public PhysicalInventoryLineMvoStateEventId()
    {
    }

    public PhysicalInventoryLineMvoStateEventId(PhysicalInventoryLineId physicalInventoryLineId, Long physicalInventoryVersion)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
        this.physicalInventoryVersion = physicalInventoryVersion;
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

        PhysicalInventoryLineMvoStateEventId other = (PhysicalInventoryLineMvoStateEventId)obj;
        return true 
            && (physicalInventoryLineId == other.physicalInventoryLineId || (physicalInventoryLineId != null && physicalInventoryLineId.equals(other.physicalInventoryLineId)))
            && (physicalInventoryVersion == other.physicalInventoryVersion || (physicalInventoryVersion != null && physicalInventoryVersion.equals(other.physicalInventoryVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.physicalInventoryLineId != null) {
            hash += 13 * this.physicalInventoryLineId.hashCode();
        }
        if (this.physicalInventoryVersion != null) {
            hash += 13 * this.physicalInventoryVersion.hashCode();
        }
        return hash;
    }

}

