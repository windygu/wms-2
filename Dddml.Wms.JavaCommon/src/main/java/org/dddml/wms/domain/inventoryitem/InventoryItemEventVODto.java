package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEventVODto
{

    public InventoryItemEventVODto()
    {
    }

    public InventoryItemEventVO toInventoryItemEventVO()
    {
        InventoryItemEventVO v = new InventoryItemEventVO();
        v.setInventoryItemEventTypeId(this.getInventoryItemEventTypeId());
        v.setDocumentNumber(this.getDocumentNumber());
        return v;
    }

    private String inventoryItemEventTypeId;

    public String getInventoryItemEventTypeId()
    {
        return this.inventoryItemEventTypeId;
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
    }

    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemEventVODto.class) {
            return false;
        }

        InventoryItemEventVODto other = (InventoryItemEventVODto)obj;
        return true 
            && (getInventoryItemEventTypeId() == other.getInventoryItemEventTypeId() || (getInventoryItemEventTypeId() != null && getInventoryItemEventTypeId().equals(other.getInventoryItemEventTypeId())))
            && (getDocumentNumber() == other.getDocumentNumber() || (getDocumentNumber() != null && getDocumentNumber().equals(other.getDocumentNumber())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemEventTypeId() != null) {
            hash += 13 * this.getInventoryItemEventTypeId().hashCode();
        }
        if (this.getDocumentNumber() != null) {
            hash += 13 * this.getDocumentNumber().hashCode();
        }
        return hash;
    }

}

