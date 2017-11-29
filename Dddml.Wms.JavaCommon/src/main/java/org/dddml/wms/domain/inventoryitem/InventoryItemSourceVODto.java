package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemSourceVODto
{

    public InventoryItemSourceVODto()
    {
    }

    public InventoryItemSourceVO toInventoryItemSourceVO()
    {
        InventoryItemSourceVO v = new InventoryItemSourceVO();
        v.setInventoryItemEventTypeId(this.getInventoryItemEventTypeId());
        v.setDocumentNumber(this.getDocumentNumber());
        v.setLineNumber(this.getLineNumber());
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

    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemSourceVODto.class) {
            return false;
        }

        InventoryItemSourceVODto other = (InventoryItemSourceVODto)obj;
        return true 
            && (getInventoryItemEventTypeId() == other.getInventoryItemEventTypeId() || (getInventoryItemEventTypeId() != null && getInventoryItemEventTypeId().equals(other.getInventoryItemEventTypeId())))
            && (getDocumentNumber() == other.getDocumentNumber() || (getDocumentNumber() != null && getDocumentNumber().equals(other.getDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
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
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        return hash;
    }

}

