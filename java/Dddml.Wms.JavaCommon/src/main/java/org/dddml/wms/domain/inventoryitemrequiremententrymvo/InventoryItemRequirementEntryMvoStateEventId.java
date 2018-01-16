package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryId;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryMvoStateEventId implements Serializable
{
    private InventoryItemRequirementEntryId inventoryItemRequirementEntryId = new InventoryItemRequirementEntryId();

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId()
    {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
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

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setProductId(inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId);
    }

    public Long getInventoryItemRequirementEntryIdEntrySeqId()
    {
        return getInventoryItemRequirementEntryId().getEntrySeqId();
    }

    public void setInventoryItemRequirementEntryIdEntrySeqId(Long inventoryItemRequirementEntryIdEntrySeqId)
    {
        getInventoryItemRequirementEntryId().setEntrySeqId(inventoryItemRequirementEntryIdEntrySeqId);
    }

    public InventoryItemRequirementEntryMvoStateEventId()
    {
    }

    public InventoryItemRequirementEntryMvoStateEventId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
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

        InventoryItemRequirementEntryMvoStateEventId other = (InventoryItemRequirementEntryMvoStateEventId)obj;
        return true 
            && (inventoryItemRequirementEntryId == other.inventoryItemRequirementEntryId || (inventoryItemRequirementEntryId != null && inventoryItemRequirementEntryId.equals(other.inventoryItemRequirementEntryId)))
            && (inventoryItemRequirementVersion == other.inventoryItemRequirementVersion || (inventoryItemRequirementVersion != null && inventoryItemRequirementVersion.equals(other.inventoryItemRequirementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemRequirementEntryId != null) {
            hash += 13 * this.inventoryItemRequirementEntryId.hashCode();
        }
        if (this.inventoryItemRequirementVersion != null) {
            hash += 13 * this.inventoryItemRequirementVersion.hashCode();
        }
        return hash;
    }

}

