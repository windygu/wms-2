package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemSourceInfoDtoWrapper extends InventoryItemSourceInfoDto
{
	
    private InventoryItemSourceInfo value;

    public InventoryItemSourceInfoDtoWrapper()
    {
        this(new InventoryItemSourceInfo());
    }

    public InventoryItemSourceInfoDtoWrapper(InventoryItemSourceInfo value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemSourceInfo toInventoryItemSourceInfo()
    {
        return this.value;
    }

    @Override
    public String getDocumentTypeId()
    {
        return this.value.getDocumentTypeId();
    }

    @Override
    public void setDocumentTypeId(String documentTypeId)
    {
        this.value.setDocumentTypeId(documentTypeId);
    }

    @Override
    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    @Override
    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
    }

    @Override
    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    @Override
    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
    }

    @Override
    public Integer getLineSeqId()
    {
        return this.value.getLineSeqId();
    }

    @Override
    public void setLineSeqId(Integer lineSeqId)
    {
        this.value.setLineSeqId(lineSeqId);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == InventoryItemSourceInfoDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemSourceInfoDtoWrapper other = (InventoryItemSourceInfoDtoWrapper)obj;
        return value.equals(other.value);
    }

}

