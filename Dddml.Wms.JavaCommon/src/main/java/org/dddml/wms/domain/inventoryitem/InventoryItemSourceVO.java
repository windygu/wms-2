package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemSourceVO implements Serializable
{
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

    public InventoryItemSourceVO()
    {
    }

    public InventoryItemSourceVO(String inventoryItemEventTypeId, String documentNumber, String lineNumber)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
        this.documentNumber = documentNumber;
        this.lineNumber = lineNumber;
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

        InventoryItemSourceVO other = (InventoryItemSourceVO)obj;
        return true 
            && (inventoryItemEventTypeId == other.inventoryItemEventTypeId || (inventoryItemEventTypeId != null && inventoryItemEventTypeId.equals(other.inventoryItemEventTypeId)))
            && (documentNumber == other.documentNumber || (documentNumber != null && documentNumber.equals(other.documentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemEventTypeId != null) {
            hash += 13 * this.inventoryItemEventTypeId.hashCode();
        }
        if (this.documentNumber != null) {
            hash += 13 * this.documentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        return hash;
    }

}

