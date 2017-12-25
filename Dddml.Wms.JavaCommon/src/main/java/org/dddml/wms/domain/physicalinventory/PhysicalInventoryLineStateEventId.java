package org.dddml.wms.domain.physicalinventory;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineStateEventId implements Serializable
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

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }

    public PhysicalInventoryLineStateEventId()
    {
    }

    public PhysicalInventoryLineStateEventId(String physicalInventoryDocumentNumber, String lineNumber, Long physicalInventoryVersion)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
        this.lineNumber = lineNumber;
        this.physicalInventoryVersion = physicalInventoryVersion;
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

        PhysicalInventoryLineStateEventId other = (PhysicalInventoryLineStateEventId)obj;
        return true 
            && (physicalInventoryDocumentNumber == other.physicalInventoryDocumentNumber || (physicalInventoryDocumentNumber != null && physicalInventoryDocumentNumber.equals(other.physicalInventoryDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            && (physicalInventoryVersion == other.physicalInventoryVersion || (physicalInventoryVersion != null && physicalInventoryVersion.equals(other.physicalInventoryVersion)))
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
        if (this.physicalInventoryVersion != null) {
            hash += 13 * this.physicalInventoryVersion.hashCode();
        }
        return hash;
    }

}

