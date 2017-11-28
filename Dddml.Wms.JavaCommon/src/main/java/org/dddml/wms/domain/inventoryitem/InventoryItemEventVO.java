package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemEventVO implements Serializable
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

    public InventoryItemEventVO()
    {
    }

    public InventoryItemEventVO(String inventoryItemEventTypeId, String documentNumber)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
        this.documentNumber = documentNumber;
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

        InventoryItemEventVO other = (InventoryItemEventVO)obj;
        return true 
            && (inventoryItemEventTypeId == other.inventoryItemEventTypeId || (inventoryItemEventTypeId != null && inventoryItemEventTypeId.equals(other.inventoryItemEventTypeId)))
            && (documentNumber == other.documentNumber || (documentNumber != null && documentNumber.equals(other.documentNumber)))
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
        return hash;
    }

}

