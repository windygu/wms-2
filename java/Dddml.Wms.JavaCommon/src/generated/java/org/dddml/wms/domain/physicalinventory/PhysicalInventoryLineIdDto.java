package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineIdDto
{

    public PhysicalInventoryLineIdDto()
    {
    }

    public PhysicalInventoryLineId toPhysicalInventoryLineId()
    {
        PhysicalInventoryLineId v = new PhysicalInventoryLineId();
        v.setPhysicalInventoryDocumentNumber(this.getPhysicalInventoryDocumentNumber());
        v.setInventoryItemId(this.getInventoryItemId().toInventoryItemId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PhysicalInventoryLineIdDto.class) {
            return false;
        }

        PhysicalInventoryLineIdDto other = (PhysicalInventoryLineIdDto)obj;
        return true 
            && (getPhysicalInventoryDocumentNumber() == other.getPhysicalInventoryDocumentNumber() || (getPhysicalInventoryDocumentNumber() != null && getPhysicalInventoryDocumentNumber().equals(other.getPhysicalInventoryDocumentNumber())))
            && (getInventoryItemId() == other.getInventoryItemId() || (getInventoryItemId() != null && getInventoryItemId().equals(other.getInventoryItemId())))
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
        return hash;
    }

}

