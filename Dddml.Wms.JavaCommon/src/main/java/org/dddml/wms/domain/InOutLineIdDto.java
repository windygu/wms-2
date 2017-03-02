package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class InOutLineIdDto
{

    public InOutLineIdDto()
    {
    }

    public InOutLineId toInOutLineId()
    {
        InOutLineId v = new InOutLineId();
        v.setInOutDocumentNumber(this.getInOutDocumentNumber());
        v.setSkuId(this.getSkuId().toSkuId());
        return v;
    }

    private String inOutDocumentNumber;

    public String getInOutDocumentNumber()
    {
        return this.inOutDocumentNumber;
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
    }

    private SkuIdDto skuId = new SkuIdDto();

    public SkuIdDto getSkuId()
    {
        return this.skuId;
    }

    public void setSkuId(SkuIdDto skuId)
    {
        this.skuId = skuId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InOutLineIdDto.class) {
            return false;
        }

        InOutLineIdDto other = (InOutLineIdDto)obj;
        return true 
            && (getInOutDocumentNumber() == other.getInOutDocumentNumber() || (getInOutDocumentNumber() != null && getInOutDocumentNumber().equals(other.getInOutDocumentNumber())))
            && (getSkuId() == other.getSkuId() || (getSkuId() != null && getSkuId().equals(other.getSkuId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInOutDocumentNumber() != null) {
            hash += 13 * this.getInOutDocumentNumber().hashCode();
        }
        if (this.getSkuId() != null) {
            hash += 13 * this.getSkuId().hashCode();
        }
        return hash;
    }

}

