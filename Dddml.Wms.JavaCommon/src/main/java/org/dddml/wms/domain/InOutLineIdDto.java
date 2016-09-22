package org.dddml.wms.domain;


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
            && (inOutDocumentNumber == other.inOutDocumentNumber || (inOutDocumentNumber != null && inOutDocumentNumber.equals(other.inOutDocumentNumber)))
            && (skuId == other.skuId || (skuId != null && skuId.equals(other.skuId)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inOutDocumentNumber != null) {
            hash += 13 * this.inOutDocumentNumber.hashCode();
        }
        if (this.skuId != null) {
            hash += 13 * this.skuId.hashCode();
        }
        return hash;
    }

}

