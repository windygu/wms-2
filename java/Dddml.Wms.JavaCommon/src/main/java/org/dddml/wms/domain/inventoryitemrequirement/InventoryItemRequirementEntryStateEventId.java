package org.dddml.wms.domain.inventoryitemrequirement;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryStateEventId implements Serializable
{
    private InventoryItemId inventoryItemRequirementId = new InventoryItemId();

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
    }

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }

    private Long inventoryItemRequirementVersion;

    public Long getInventoryItemRequirementVersion()
    {
        return this.inventoryItemRequirementVersion;
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
    }

    public String getInventoryItemRequirementIdProductId()
    {
        return getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementIdProductId(String inventoryItemRequirementIdProductId)
    {
        getInventoryItemRequirementId().setProductId(inventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementIdLocatorId()
    {
        return getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementIdLocatorId(String inventoryItemRequirementIdLocatorId)
    {
        getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementIdAttributeSetInstanceId)
    {
        getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementIdAttributeSetInstanceId);
    }

    public InventoryItemRequirementEntryStateEventId()
    {
    }

    public InventoryItemRequirementEntryStateEventId(InventoryItemId inventoryItemRequirementId, Long entrySeqId, Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
        this.entrySeqId = entrySeqId;
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
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

        InventoryItemRequirementEntryStateEventId other = (InventoryItemRequirementEntryStateEventId)obj;
        return true 
            && (inventoryItemRequirementId == other.inventoryItemRequirementId || (inventoryItemRequirementId != null && inventoryItemRequirementId.equals(other.inventoryItemRequirementId)))
            && (entrySeqId == other.entrySeqId || (entrySeqId != null && entrySeqId.equals(other.entrySeqId)))
            && (inventoryItemRequirementVersion == other.inventoryItemRequirementVersion || (inventoryItemRequirementVersion != null && inventoryItemRequirementVersion.equals(other.inventoryItemRequirementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemRequirementId != null) {
            hash += 13 * this.inventoryItemRequirementId.hashCode();
        }
        if (this.entrySeqId != null) {
            hash += 13 * this.entrySeqId.hashCode();
        }
        if (this.inventoryItemRequirementVersion != null) {
            hash += 13 * this.inventoryItemRequirementVersion.hashCode();
        }
        return hash;
    }

}

