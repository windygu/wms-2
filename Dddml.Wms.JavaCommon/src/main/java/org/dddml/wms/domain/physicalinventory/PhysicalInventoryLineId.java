package org.dddml.wms.domain.physicalinventory;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineId implements Serializable
{
    private String physicalInventoryDocumentNumber;

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.physicalInventoryDocumentNumber;
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
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

    public PhysicalInventoryLineId()
    {
    }

    public PhysicalInventoryLineId(String physicalInventoryDocumentNumber, String lineNumber)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
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

        PhysicalInventoryLineId other = (PhysicalInventoryLineId)obj;
        return true 
            && (physicalInventoryDocumentNumber == other.physicalInventoryDocumentNumber || (physicalInventoryDocumentNumber != null && physicalInventoryDocumentNumber.equals(other.physicalInventoryDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.physicalInventoryDocumentNumber != null) {
            hash += 13 * this.physicalInventoryDocumentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        return hash;
    }

}

