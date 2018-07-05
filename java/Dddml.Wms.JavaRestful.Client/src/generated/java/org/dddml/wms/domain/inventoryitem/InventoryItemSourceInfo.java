package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemSourceInfo implements Serializable
{
    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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

    private Integer lineSubSeqId;

    public Integer getLineSubSeqId()
    {
        return this.lineSubSeqId;
    }

    public void setLineSubSeqId(Integer lineSubSeqId)
    {
        this.lineSubSeqId = lineSubSeqId;
    }

    public InventoryItemSourceInfo()
    {
    }

    public InventoryItemSourceInfo(String documentTypeId, String documentNumber, String lineNumber, Integer lineSubSeqId)
    {
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.lineNumber = lineNumber;
        this.lineSubSeqId = lineSubSeqId;
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

        InventoryItemSourceInfo other = (InventoryItemSourceInfo)obj;
        return true 
            && (documentTypeId == other.documentTypeId || (documentTypeId != null && documentTypeId.equals(other.documentTypeId)))
            && (documentNumber == other.documentNumber || (documentNumber != null && documentNumber.equals(other.documentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            && (lineSubSeqId == other.lineSubSeqId || (lineSubSeqId != null && lineSubSeqId.equals(other.lineSubSeqId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.documentTypeId != null) {
            hash += 13 * this.documentTypeId.hashCode();
        }
        if (this.documentNumber != null) {
            hash += 13 * this.documentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        if (this.lineSubSeqId != null) {
            hash += 13 * this.lineSubSeqId.hashCode();
        }
        return hash;
    }



}

