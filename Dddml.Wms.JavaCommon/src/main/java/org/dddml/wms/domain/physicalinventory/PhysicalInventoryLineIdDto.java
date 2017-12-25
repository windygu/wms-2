package org.dddml.wms.domain.physicalinventory;

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
        v.setLineNumber(this.getLineNumber());
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
        if (obj == null || obj.getClass() != PhysicalInventoryLineIdDto.class) {
            return false;
        }

        PhysicalInventoryLineIdDto other = (PhysicalInventoryLineIdDto)obj;
        return true 
            && (getPhysicalInventoryDocumentNumber() == other.getPhysicalInventoryDocumentNumber() || (getPhysicalInventoryDocumentNumber() != null && getPhysicalInventoryDocumentNumber().equals(other.getPhysicalInventoryDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPhysicalInventoryDocumentNumber() != null) {
            hash += 13 * this.getPhysicalInventoryDocumentNumber().hashCode();
        }
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        return hash;
    }

}

