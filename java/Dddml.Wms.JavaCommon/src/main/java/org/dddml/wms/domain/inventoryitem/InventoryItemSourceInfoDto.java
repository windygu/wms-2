package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemSourceInfoDto
{

    public InventoryItemSourceInfoDto()
    {
    }

    public InventoryItemSourceInfo toInventoryItemSourceInfo()
    {
        InventoryItemSourceInfo v = new InventoryItemSourceInfo();
        v.setDocumentTypeId(this.getDocumentTypeId());
        v.setDocumentNumber(this.getDocumentNumber());
        v.setLineNumber(this.getLineNumber());
        v.setLineSeqId(this.getLineSeqId());
        return v;
    }

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

    private Integer lineSeqId;

    public Integer getLineSeqId()
    {
        return this.lineSeqId;
    }

    public void setLineSeqId(Integer lineSeqId)
    {
        this.lineSeqId = lineSeqId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemSourceInfoDto.class) {
            return false;
        }

        InventoryItemSourceInfoDto other = (InventoryItemSourceInfoDto)obj;
        return true 
            && (getDocumentTypeId() == other.getDocumentTypeId() || (getDocumentTypeId() != null && getDocumentTypeId().equals(other.getDocumentTypeId())))
            && (getDocumentNumber() == other.getDocumentNumber() || (getDocumentNumber() != null && getDocumentNumber().equals(other.getDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
            && (getLineSeqId() == other.getLineSeqId() || (getLineSeqId() != null && getLineSeqId().equals(other.getLineSeqId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getDocumentTypeId() != null) {
            hash += 13 * this.getDocumentTypeId().hashCode();
        }
        if (this.getDocumentNumber() != null) {
            hash += 13 * this.getDocumentNumber().hashCode();
        }
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        if (this.getLineSeqId() != null) {
            hash += 13 * this.getLineSeqId().hashCode();
        }
        return hash;
    }

}

