package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineStateEventIdDto
{

    public PhysicalInventoryLineStateEventIdDto()
    {
    }

    public PhysicalInventoryLineStateEventId toPhysicalInventoryLineStateEventId()
    {
        PhysicalInventoryLineStateEventId v = new PhysicalInventoryLineStateEventId();
        v.setPhysicalInventoryDocumentNumber(this.getPhysicalInventoryDocumentNumber());
        v.setInventoryItemId(this.getInventoryItemId().toInventoryItemId());
        v.setPhysicalInventoryVersion(this.getPhysicalInventoryVersion());
        return v;
    }

    private String physicalInventoryDocumentNumber;

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.physicalInventoryDocumentNumber;
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
    }

    private InventoryItemIdDto inventoryItemId = new InventoryItemIdDto();

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PhysicalInventoryLineStateEventIdDto.class) {
            return false;
        }

        PhysicalInventoryLineStateEventIdDto other = (PhysicalInventoryLineStateEventIdDto)obj;
        return true 
            && (getPhysicalInventoryDocumentNumber() == other.getPhysicalInventoryDocumentNumber() || (getPhysicalInventoryDocumentNumber() != null && getPhysicalInventoryDocumentNumber().equals(other.getPhysicalInventoryDocumentNumber())))
            && (getInventoryItemId() == other.getInventoryItemId() || (getInventoryItemId() != null && getInventoryItemId().equals(other.getInventoryItemId())))
            && (getPhysicalInventoryVersion() == other.getPhysicalInventoryVersion() || (getPhysicalInventoryVersion() != null && getPhysicalInventoryVersion().equals(other.getPhysicalInventoryVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPhysicalInventoryDocumentNumber() != null) {
            hash += 13 * this.getPhysicalInventoryDocumentNumber().hashCode();
        }
        if (this.getInventoryItemId() != null) {
            hash += 13 * this.getInventoryItemId().hashCode();
        }
        if (this.getPhysicalInventoryVersion() != null) {
            hash += 13 * this.getPhysicalInventoryVersion().hashCode();
        }
        return hash;
    }

}

